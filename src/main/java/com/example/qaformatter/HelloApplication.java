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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {

    static String filePathGlobal;
    static boolean successGlobal;

    @FXML
     private Label wordCountText;
    @FXML
     private Label ReferenceCountText;
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

        guideText.setTooltip(new Tooltip("check if the paper's on topic"));
        guideText2.setTooltip(new Tooltip("if there's plag - all your efforts will\n" +
                "be wasted > do not skip this step"));
        guideText3.setTooltip(new Tooltip("title page and references not included"));
        guideText4.setTooltip(new Tooltip("mind +/-10% leeway rule; "));
        guideText5.setTooltip(new Tooltip("Most of the time Times New Roman 12"));
        guideText6.setTooltip(new Tooltip("APA:     |\"TOPIC        PAGE\"|\n" +
                                             "HARV:  |\"          Topic PAGE\"|\n" +
                                             "MLA:     |\"          Surname PAGE\"|"));
        guideText7.setTooltip(new Tooltip("APA:\n" +
                "       (bold)Topic\n" +
                "       (blank)\n" +
                "       Name\n" +
                "       University\n" +
                "       (blankS)\n" +
                "       (bold)Author Note\n" +
                "HARV:\n        TOPIC\n         Name\n        (blank)\n         Course\n         Prof Name\n         Institution\n         Location\n         Date\n" +
                "MLA:\nName\nProf Name\nCourse\nDate"));
      //  guideText8.setTooltip(new Tooltip(""));
        guideText9.setTooltip(new Tooltip("Ctrl + L"));
        guideText11.setTooltip(new Tooltip("US: suffix -> iz and yz \n UK:  suffix -> is and ys\n Press Hint for Help"));
        guideText12.setTooltip(new Tooltip("Press Hint for Help"));
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
                    dragText.setText("Formatted");
                    wordCountText.setText("Word count: " + obj.countWords() + "+- some words");

                    ReferenceCountText.setText("Reference count: " + obj.countReferences());

                    System.out.println("APA");
                    System.out.println(returnSuccess());
                }
            }
        }

        if ((event.getSource() == FORMAT)) {
            if (returnPath() == null){
                dragText.setText("Drag File!");
            }else{
                obj.changeStyle(obj.robot);
                obj.saveFile(obj.robot);
                dragText.setText("Counted");
            }

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
            String url = "https://docs.google.com/document/d/1gUUYJ5wfVUMH3e7INAzM9iBqYfMS25gMaM3YjLcOplc/edit#";
            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else{
            Runtime rt = Runtime.getRuntime();
            String url = "https://docs.google.com/document/d/1bgKqIQth28zPbPuBlXTxQYySwRaLgj7gIBLPoacErnA/edit#";
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

        wordCountText = new Label();
        ReferenceCountText = new Label();

        COUNT = new Button();

        FORMAT = new Button();
        scene.setOnDragOver(new EventHandler<DragEvent>() {
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
        scene.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                setSuccess(false);
                if (db.hasFiles()) {

                    setSuccess(true);
                    for (File file:db.getFiles()) {
                        setFilePathGlobal(file.getPath());
                        System.out.println(file.getPath());
                        System.out.println(file.getName());


                    }
                }
                event.setDropCompleted(successGlobal);

                event.consume();

            }

        });

        stage.setTitle("QAFormatter");
        stage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Check_green_icon.svg/2048px-Check_green_icon.svg.png"));
        stage.setX(400);
        stage.setY(200);
        stage.setHeight(500);
        stage.setWidth(500);
        stage.setScene(scene);
        stage.show();

    }


    private String toString(String name) {
        return "" + name;
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