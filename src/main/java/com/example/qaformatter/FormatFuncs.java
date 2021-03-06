package com.example.qaformatter;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import com.aspose.words.*;


public class FormatFuncs {

    static int [] timesNewRoman = {KeyEvent.VK_T, KeyEvent.VK_I,KeyEvent.VK_M,KeyEvent.VK_E};
    Robot robot = new Robot();

    public FormatFuncs() throws AWTException {
    }



    void saveFile(Robot robot){
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_F12);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_F12);
    }
    void setFontSize(Robot robot) throws  InterruptedException{
        //Open Font Size Menu
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_CONTROL);

        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_P);
        //Enter Font Size
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        //Input
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
    void setSpacing2(Robot robot) throws InterruptedException {
        //Self-explanatory
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_2);

    }
    void setSpacing1(Robot robot) throws InterruptedException {
        //Self-explanatory
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_1);
        Thread.sleep(2000);

    }
    void changeStyle(Robot robot) throws AWTException, InterruptedException {
        FormatFuncs object = new FormatFuncs();
        object.setSpacing2(robot);
        object.setFontStyle(robot);
        object.setFontSize(robot);

    }
    void setFontStyle(Robot robot) throws InterruptedException {
        String[] fonts = {"Times New Roman"};
        //Save code to the clipboard
        StringSelection stringSelection = new StringSelection(fonts[0]);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        //Select all text
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        //Open Font Menu
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_F);
        //Enter preferred font
        //Paste pre-written code
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(200);
        //Enter and CLose
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
     int countReferences() throws  Exception{
        HelloApplication appObj = new HelloApplication();
        File outFile = new File(System.getProperty("user.dir")+ "\\output.txt");
        File fileRef = new File(System.getProperty("user.dir")+ "\\references.txt");
        Document doc = new Document( appObj.returnPath());
        doc.save("output.txt");
         System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileRef));

        FileInputStream fileInputStream = new FileInputStream(outFile);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        int amountOfReferences = 0;
        boolean countReferences = false;


        String[] possibleTitle = {"References", "List of references", "List of References", "List Of References","Bibliography", "Bibliography List", "bibliography list", "bibliography","references", "Reference", "reference", "Reference list","Reference`s list", "Reference's list","References list", "reference list", "Works Cited", "Works cited", "works cited", "work Cited"};
        while ( line != null) {
            line = line.replace("\n", "#").replace("\r", "#");
            for (String s : possibleTitle) {
                if (line.equals(s)) {
                    countReferences = true;
                    break;
                }
            }
        if(countReferences){

            if(line.equals("References") || line.equals("List of references")|| line.equals("List of References")|| line.equals("List Of References")|| line.equals("Bibliography List") || line.equals("bibliography list")|| line.equals("bibliography")|| line.equals("Bibliography") || line.equals("reference List")|| line.equals("reference list")|| line.equals("Reference List") || line.equals("reference") || line.equals("Reference")|| line.equals("Created with an evaluation copy of Aspose.Words. To discover the full versions of our APIs please visit: https://products.aspose.com/words/") || line.equals("Works Cited")|| line.equals("work cited") || line.equals("works cited")|| line.equals("Works cited") || line.equals("Work Cited") || line.equals("references") || line.equals(" ") || line.equals("\r\n\r\n") || line.equals("\n\n") || line.equals("") ){
                System.out.println("Not a Reference");
                }else{

                    amountOfReferences++;
                    System.out.println(line);
                    bufferedWriter.write(line);
                }
        }
            line = bufferedReader.readLine();
        }


         System.out.println("Total number of references = "+ amountOfReferences);
         bufferedWriter.close();
         PrintWriter writer = new PrintWriter(outFile);
         writer.print("");
         writer.close();
        return amountOfReferences;

    }
     int countWords() throws Exception {

        HelloApplication appObj = new HelloApplication();
        System.out.println( appObj.returnPath());
        Document doc = new Document( appObj.returnPath());

        doc.save("Output.txt");
        File file = new File(System.getProperty("user.dir")+ "\\output.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        String[] possibleStartPoint = {"Author Note", "Authors Note", "Author`s Note", "Author's Note", "Author Note", "Date", "Date:", "date", "date:", "The Date","The Date:", "The date", "The date:", "Introduction", "introduction"};
        int wordCount = 0;
        boolean startCount = false;
        //!line.equals("References")
        while ( line != null) {
            for (String s : possibleStartPoint) {
                if (line.equals(s)) {
                    startCount = true;
                    break;
                }
            }
            if(line.equals("References")){
                startCount=false;
            }
            if(startCount){

                String[] words = line.split(" ");
               // System.out.println(Arrays.toString(words));
                wordCount += words.length;


            }

            line = bufferedReader.readLine();
        }

        System.out.println("Total word count = "+ wordCount);
         PrintWriter writer = new PrintWriter(file);
         writer.print("");
         writer.close();
        return wordCount;
    }


    void deleteDoubleSpaces(Robot robot) throws InterruptedException {

        String deleteMacros = "Sub ReplaceSpaces()\n" +
                "\n" +
                "With Selection.Find\n" +
                "\n" +
                ".ClearFormatting\n" +
                "\n" +
                ".Replacement.ClearFormatting\n" +
                "\n" +
                ".Text = \"  \"\n" +
                "\n" +
                ".Replacement.Text = \" \"\n" +
                "\n" +
                ".Forward = True\n" +
                "\n" +
                ".Wrap = wdFindContinue\n" +
                "\n" +
                ".Format = False\n" +
                "\n" +
                ".MatchCase = False\n" +
                "\n" +
                ".MatchWholeWord = False\n" +
                "\n" +
                ".MatchWildcards = False\n" +
                "\n" +
                ".MatchSoundsLike = False\n" +
                "\n" +
                ".MatchAllWordForms = False\n" +
                "\n" +
                ".Execute Replace:=wdReplaceAll\n" +
                "\n" +
                "End With\n" +
                "\n" +
                "End Sub\n";

        StringSelection stringSelection = new StringSelection(deleteMacros);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        //Open VBM tab
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F11);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_F11);
        //Create new macros'
        robot.keyPress(KeyEvent.VK_F7);
        robot.keyRelease(KeyEvent.VK_F7);
//       // Delete code, to avoid stacking
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        Thread.sleep(1000);
//        //Paste pre-written code
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
//        //Run it
        robot.keyPress(KeyEvent.VK_F5);
        robot.keyRelease(KeyEvent.VK_F5);
////        //Close VBM
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_Q);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_Q);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_F12);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_F12);


    }
    void selectPages(int lastPage) throws InterruptedException {
        //Pre-written code
        String text = "Sub selectpages ()\n" +
                "Dim rgePages As Range\n" +
                "Selection.GoTo What:=wdGoToPage, Which:=wdGoToAbsolute, Count:=2\n" +
                "Set rgePages = Selection.Range\n" +
                "Selection.GoTo What:=wdGoToPage, Which:=wdGoToAbsolute, Count:=" + lastPage +"\n" +
                "rgePages.End = Selection.Bookmarks(\"\\Page\").Range.End\n" +
                "rgePages.Select\n" +
                "End Sub";
        //Save code to the clipboard
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        //Open VBM tab
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F11);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_F11);
        //Create new macros
        robot.keyPress(KeyEvent.VK_F7);
        robot.keyRelease(KeyEvent.VK_F7);
        //Paste pre-written code
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        //Run it
        robot.keyPress(KeyEvent.VK_F5);
        robot.keyRelease(KeyEvent.VK_F5);
        Thread.sleep(200);
        //Delete code, to avoid stacking
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        Thread.sleep(2000);
        //Close VBM
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_Q);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_Q);
    }

}


