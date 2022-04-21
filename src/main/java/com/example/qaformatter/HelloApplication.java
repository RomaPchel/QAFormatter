package com.example.qaformatter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {

    static String filePathGlobal;
    static boolean successGlobal;
    @FXML
     private Label wordCountText;
    @FXML
     private Label ReferenceCountText;

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        HelloApplication.fileName = fileName;
    }

    @FXML
    static private String fileName;
    @FXML
    private Label hoverText;
    @FXML
    private Button COUNT;
    @FXML
    private Button FORMAT;
    @FXML
    private Label dragText;
    @FXML
    public TextField guideText;
    @FXML
    public TextField guideText2;
    @FXML
    public TextField guideText3;
    @FXML
    public TextField guideText4;
    @FXML
    public TextField guideText5;
    @FXML
    public TextField guideText6;
    @FXML
    public TextField guideText7;
    @FXML
    public TextField guideText8;
    @FXML
    public TextField guideText9;
    @FXML
    public TextField guideText10;
    @FXML
    public TextField guideText11;
    @FXML
    public TextField guideText12;
    @FXML
    private CheckBox checkBox;
    @FXML
    private CheckBox checkBox2;
    @FXML
    private CheckBox checkBox3;
    @FXML
    private CheckBox checkBox4;
    @FXML
    private CheckBox checkBox5;
    @FXML
    private CheckBox checkBox6;
    @FXML
    private CheckBox checkBox7;
    @FXML
    private CheckBox checkBox8;
    @FXML
    private CheckBox checkBox9;
    @FXML
    private CheckBox checkBox10;
    @FXML
    private CheckBox checkBox11;
    @FXML
    private CheckBox checkBox12;
    @FXML
    private Button openLanguageSite;
    @FXML
    private Button openReferencesSite;
    @FXML
    private Button headingButton;
    @FXML
    private Button titlesButton;
    @FXML
    private Button refreshCheckBoxes;

    public static void main(String[] args) {
        Application.launch(args);
    }


    @FXML
    private void initialize() {

        if (returnPath() != null) {
            dragText.setText("Done!");
        }else{
            dragText.setText("Drag File and Press Format!");

        }
        hoverText.setText("Hover Over Text to See Hint!");
        guideText.textProperty().set("Instructions");
        guideText2.textProperty().set("Originality");
        guideText3.textProperty().set("Count References/Citations");
        guideText4.textProperty().set("Words Count");
        guideText5.textProperty().set("Font, Size and Spacing");
        guideText6.textProperty().set("Header");
        guideText7.textProperty().set("Title Page");
        guideText8.textProperty().set("Headings");
        guideText9.textProperty().set("Left-centered Text");
        guideText10.textProperty().set("Mistakes/Typos in Text");
        guideText11.textProperty().set("Language");
        guideText12.textProperty().set("References/In-text Citations");

        Tooltip tooltipForGuide = new Tooltip();
        Tooltip tooltipForGuide2 = new Tooltip();
        Tooltip tooltipForGuide3 = new Tooltip();
        Tooltip tooltipForGuide4 = new Tooltip();
        Tooltip tooltipForGuide5 = new Tooltip();
        Tooltip tooltipForGuide6 = new Tooltip();
        Tooltip tooltipForGuide7 = new Tooltip();
        Tooltip tooltipForGuide8 = new Tooltip();
        Tooltip tooltipForGuide9 = new Tooltip();
        Tooltip tooltipForGuide10 = new Tooltip();
        Tooltip tooltipForGuide11 = new Tooltip();
        Tooltip tooltipForGuide12 = new Tooltip();

        tooltipForGuide.setShowDuration(Duration.seconds(10));
        tooltipForGuide2.setShowDuration(Duration.seconds(10));
        tooltipForGuide3.setShowDuration(Duration.seconds(10));
        tooltipForGuide4.setShowDuration(Duration.seconds(10));
        tooltipForGuide5.setShowDuration(Duration.seconds(10));
        tooltipForGuide6.setShowDuration(Duration.seconds(10));
        tooltipForGuide7.setShowDuration(Duration.seconds(10));
        tooltipForGuide8.setShowDuration(Duration.seconds(10));
        tooltipForGuide9.setShowDuration(Duration.seconds(10));
        tooltipForGuide10.setShowDuration(Duration.seconds(10));
        tooltipForGuide11.setShowDuration(Duration.seconds(10));
        tooltipForGuide12.setShowDuration(Duration.seconds(10));

        tooltipForGuide.setText("check if the paper's on topic");
        tooltipForGuide2.setText("if there's plag - all your efforts will\n" +
                "be wasted > do not skip this step");
        tooltipForGuide4.setText("mind +/-10% leeway rule; title page and references not included");
        tooltipForGuide5.setText("Most of the time Times New Roman 12");
        tooltipForGuide6.setText("""
                APA:     |"TOPIC        PAGE"|
                HARV:  |"          Topic PAGE"|
                MLA:     |"          Surname PAGE"|""");
        tooltipForGuide7.setText("""
                APA:
                       (bold)Topic
                       Name
                       University
                       (blankS)
                       (bold)Author Note
                HARV:
                        TOPIC
                         Name
                        (blank)
                         Course
                         Prof Name
                         Institution
                         Location
                         Date
                MLA:
                Name
                Prof Name
                Course
                Date""");
        tooltipForGuide9.setText("Ctrl + L");
        tooltipForGuide11.setText("US: suffix -> iz and yz \n UK:  suffix -> is and ys\n Press Hint for Help");
        tooltipForGuide12.setText("Press Hint for Help");

        guideText.setTooltip(tooltipForGuide);
        guideText2.setTooltip(tooltipForGuide2);
        guideText5.setTooltip(tooltipForGuide5);
        guideText6.setTooltip(tooltipForGuide6);
        guideText7.setTooltip(tooltipForGuide7);
        guideText4.setTooltip(tooltipForGuide4);
        guideText9.setTooltip(tooltipForGuide9);
        guideText11.setTooltip(tooltipForGuide11);
        guideText12.setTooltip(tooltipForGuide12);
    }
    public void handleButton(ActionEvent event) throws Exception {
        QAFormatter obj = new QAFormatter();
        if ((event.getSource() == COUNT) ) {

            if (returnPath() == null){
                dragText.setText("Drag File");
            }else {
               // obj.changeStyle(obj.robot);
                if (obj.countWords() <=0 ){

                    wordCountText.setText("Wrong Format or Last line of Title Page");

                }else if (obj.countReferences() <0){

                    ReferenceCountText.setText("Wrong Format of Heading for References");

                }
                else
                {

                    dragText.setText(getFileName());
                    wordCountText.setText("Word count: " + obj.countWords() + " +- some words");

                    ReferenceCountText.setText("Reference count: " + obj.countReferences());
                    System.out.println(getFileName());
                    System.out.println("APA");
                    System.out.println(returnSuccess());
                }
            }
        }

        if ((event.getSource() == FORMAT)) {
            if (returnPath() == null){
                dragText.setText("Drag File");
            }else{
                obj.changeStyle(obj.robot);
                obj.saveFile(obj.robot);
                dragText.setText("Counted");
            }

        }
    }
    public void setRefreshCheckBoxes(ActionEvent event){
       if (event.getSource() == refreshCheckBoxes){
           checkBox.setSelected(false);
           checkBox2.setSelected(false);
           checkBox3.setSelected(false);
           checkBox4.setSelected(false);
           checkBox5.setSelected(false);
           checkBox6.setSelected(false);
           checkBox7.setSelected(false);
           checkBox8.setSelected(false);
           checkBox9.setSelected(false);
           checkBox10.setSelected(false);
           checkBox11.setSelected(false);
           checkBox12.setSelected(false);
       }
    }
    public void handleLanguageSite(ActionEvent event){
        if (event.getSource() == openLanguageSite){
            Runtime rt = Runtime.getRuntime();
            String url = "http://www.tysto.com/uk-us-spelling-list.html";
            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else if(event.getSource() == openReferencesSite){
            Runtime rt = Runtime.getRuntime();
            String url = "https://writerscrmassetsbucket.s3.amazonaws.com/uploads/library_asset/2949542/All_Formats_Table_with_APA_7th_edition_upd.pdf?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAQVZIBLWVMDVW2YKQ%2F20220415%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20220415T100359Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=66c6ee34e0385e06ce750fea014106b21cb2a7cde42cd8c7c30d68d6973bbea1";
            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else if(event.getSource() == headingButton){
            Runtime rt = Runtime.getRuntime();
            String url = "https://docs.google.com/document/d/1gUUYJ5wfVUMH3e7INAzM9iBqYfMS25gMaM3YjLcOplc/edit?usp=sharing";
            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else{
            Runtime rt = Runtime.getRuntime();
            String url = "https://docs.google.com/document/d/1bgKqIQth28zPbPuBlXTxQYySwRaLgj7gIBLPoacErnA/edit?usp=sharing";
            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 450, 320);
        fxmlLoader.setController(this);




        guideText = new TextField("NONE");
        //fileName = new Label("File Name");
        wordCountText = new Label();
        ReferenceCountText = new Label();

        COUNT = new Button();

        FORMAT = new Button();
        scene.setOnDragOver(new EventHandler<>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {

                    event.acceptTransferModes(TransferMode.COPY);
                } else {
                    event.consume();
                }
            }
        });


        // Dropping over surface
        scene.setOnDragDropped(new EventHandler<>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                setSuccess(false);
                if (db.hasFiles()) {

                    setSuccess(true);
                    for (File file : db.getFiles()) {
                        setFilePathGlobal(file.getPath());
                        System.out.println(file.getPath());
                        System.out.println(file.getName());
                        setFileName(file.getName());


                    }
                }
                event.setDropCompleted(successGlobal);

                event.consume();

            }

        });

        stage.setTitle("QAFormatter");
        stage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Check_green_icon.svg/2048px-Check_green_icon.svg.png"));
        stage.setX(450);
        stage.setY(200);
        stage.setHeight(550);
        stage.setWidth(500);
        stage.setScene(scene);
        stage.show();

    }



    void setFilePathGlobal(String path){
        filePathGlobal = path;
    }
    public String returnPath(){
        return filePathGlobal;
    }
    void setSuccess(boolean status){
        successGlobal = status;

    }
    public boolean returnSuccess(){
        return successGlobal;
    }
}