package com.example.qaformatter;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;

import java.util.Scanner;

import com.aspose.words.*;


public class QAFormatter {

    static int [] timesNewRoman = {KeyEvent.VK_T, KeyEvent.VK_I,KeyEvent.VK_M,KeyEvent.VK_E};
    Robot robot = new Robot();

    public QAFormatter() throws AWTException {
    }

    public static void main(String[] args)  throws Exception{
        Scanner scanner = new Scanner(System.in);
        QAFormatter object = new QAFormatter();

        System.out.println("enter spacing");
        int spacing = scanner.nextInt();
        Thread.sleep(1500);
        switch (spacing){
            case 1:
                object.setSpacing1(object.robot);
            case 2:
                object.setSpacing2(object.robot);
        }
        //object.deleteHardReturnsForReferences(object.robot);
//       // object.setFontSize(object.robot);
       // object.countWords();

       // object.selectPages(object.getLastPage());

    }
    void setFontSize(Robot robot) throws  InterruptedException{
        //Open Font Size Menu
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
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_2);
        //Input
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
    void setSpacing2(Robot robot) throws InterruptedException {
        //Self-explanatory
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(200);
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
    void setFontStyle(Robot robot) throws InterruptedException {
        String[] fonts = {"Times New Roman", "Colibri", "Arial"};
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
        for (int j : timesNewRoman) {
            robot.keyPress(j);
            robot.delay(100);
        }
        Thread.sleep(200);
        //Enter and CLose
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    int countReferences() throws  Exception{
        File file = new File("D:\\QAFormatter\\Output.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        boolean countReferences = false;
        int amountOfReferences = 0;

        while ( line != null) {

            if(line.equals("References")){
                countReferences=true;
            }
        if(countReferences){
            //System.out.println(line);
            if(line.equals("\r\n")){
                System.out.println("minus reference");
                amountOfReferences--;
            }else{
                System.out.println(line);
                amountOfReferences++;
            }
        }
            line = bufferedReader.readLine();

        }
        System.out.println("Total number of references = "+ amountOfReferences);
        return amountOfReferences-2;

    }
    int countWords() throws Exception {

        HelloApplication appObj = new HelloApplication();
        System.out.println("D:\\QAFormatter\\" + appObj.returnPath());
        Document doc = new Document("D:\\QAFormatter\\" + appObj.returnPath());

        doc.save("Output.txt");
        File file = new File("D:\\QAFormatter\\Output.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();

        int wordCount = 0;
        boolean startCount = false;
        //!line.equals("References")
        while ( line != null) {

            if(line.equals("Author Note")) {
                startCount = true;
            }else if(line.equals("References")){
                startCount=false;
            }
            if(startCount){
               // System.out.println(line);

                String[] words = line.split("\\s+");
                // System.out.println(Arrays.toString(words));
                wordCount += words.length;


            }
            line = bufferedReader.readLine();

        }
        System.out.println("Total word count = "+ wordCount);

        return wordCount-38;
    }


    void deleteHardReturnsForReferences(Robot robot) throws InterruptedException {

        String deleteMacros = "Sub ReplaceSpaces()\n" +
                "\n" +
                "With Selection.Find\n" +
                "\n" +
                ".ClearFormatting\n" +
                "\n" +
                ".Replacement.ClearFormatting\n" +
                "\n" +
                ".Text = \"^p^p\"\n" +
                "\n" +
                ".Replacement.Text = \"^p\"\n" +
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
        Thread.sleep(2000);
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


