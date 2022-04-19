package com.example.qaformatter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class HelloApplication extends Application {

    static String filePathGlobal;
    static boolean successGlobal;
    @FXML
     private Label wordCountText;
    @FXML
     private Label ReferenceCountText;
    @FXML
    private Button COUNT;
    @FXML
    private Button FORMAT;
    @FXML
    private Label dragText;
    @FXML
    private Label guideText;
    @FXML
    private Label guideText2;
    @FXML
    private Label guideText3;
    @FXML
    private Label guideText4;
    @FXML
    private Label guideText5;
    @FXML
    private Label guideText6;
    @FXML
    private Label guideText7;
    @FXML
    private Label guideText8;
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


    public static void main(String[] args) {
        Application.launch(args);
    }


    @FXML
    private void initialize() {
        HelloApplication appObj = new HelloApplication();
        if (appObj.returnSuccess()) {

            dragText.setText("Done!");
        }else{
            dragText.setText("Drag File and Press Format!");
        }
    }
    public void handleButton(ActionEvent event) throws Exception {
        QAFormatter obj = new QAFormatter();
        if ((event.getSource() == COUNT) ) {

            if (returnPath() == null){
                dragText.setText("Drag File");
            }else {
               // obj.changeStyle(obj.robot);
                dragText.setText("Pressed APA");
                if (obj.countWords() <=0 ){
                    wordCountText.setText("Wrong Format or Last line of Title Page");
                }else if (obj.countReferences() <0){
                    ReferenceCountText.setText("Wrong Format of Heading for References");
                }
                else
                {
                    wordCountText.setText("Word count: " + obj.countWords() + "+- some words");

                    ReferenceCountText.setText("Reference count: " + obj.countReferences());

                    System.out.println("APA");
                    System.out.println(returnSuccess());
                }
            }
        }
        if ((event.getSource() == FORMAT)) {
           obj.changeStyle(obj.robot);
           obj.saveFile(obj.robot);
            dragText.setText("Formatted");
        }
    }
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 320);
        BorderPane pane = new BorderPane();


        wordCountText = new Label();
        ReferenceCountText = new Label();
        guideText = new Label();

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