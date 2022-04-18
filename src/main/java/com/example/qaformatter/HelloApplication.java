package com.example.qaformatter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    static String filePathGlobal;
    static boolean successGlobal;
    @FXML
     private Label wordCountText;
    @FXML
     private Label ReferenceCountText;
    @FXML
    private Button APA;
    @FXML
    private Button HARVARD;
    @FXML
    private Button MLA;
    @FXML
    private Label dragText;
    @FXML
    private Label guideText;

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
        if ((event.getSource() == APA) ) {

            if (returnPath() == null){
                dragText.setText("Drag File");
            }else {
                obj.changeStyle(obj.robot);
                guideText.setText("""
                        Check Table:\s
                        1.topic of the paper
                        2.originality
                        3.word count
                        4.instructions
                        5.features
                        6.proofread/format
                        7.rate
                        8.move to the next folder
                        """);
                dragText.setText("Pressed APA");
                if (obj.countWords("Author Note") <=0 || obj.countReferences("References") <0){
                    wordCountText.setText("Wrong Format");
                    ReferenceCountText.setText("Wrong Format");
                }else {
                    wordCountText.setText("Word count: " + obj.countWords("Author Note") + "+- some words");
                    ReferenceCountText.setText("Reference count: " + obj.countReferences("References"));
                    System.out.println("APA");
                    System.out.println(returnSuccess());
                }
            }
        }
        if ((event.getSource() == HARVARD)) {
            if (returnPath() == null){
                dragText.setText("Drag File");
            }else {
            guideText.setText("""
                    Check Table:\s
                    1.topic of the paper
                    2.originality
                    3.word count
                    4.instructions
                    5.features
                    6.proofread/format
                    7.rate
                    8.move to the next folder
                    """);
            dragText.setText("Pressed HARVARD");
                if (obj.countWords("Date") <=0 || obj.countReferences("References") <0){
                    wordCountText.setText("Wrong Format");
                    ReferenceCountText.setText("Wrong Format");
                }else {
                    wordCountText.setText("Word count: " + obj.countWords("Date") + "+- some words");
                    ReferenceCountText.setText("Reference count: " + obj.countReferences("References"));
                    System.out.println("HARVARD");
                    System.out.println(returnSuccess());
                }
        }}
        if ((event.getSource() == MLA)) {
            if (returnPath() == null){
                dragText.setText("Drag File");
            }else {
                guideText.setText("""
                        Check Table:\s
                        1.topic of the paper
                        2.originality
                        3.word count
                        4.instructions
                        5.features
                        6.proofread/format
                        7.rate
                        8.move to the next folder
                        """);
                dragText.setText("Pressed MLA");
                if (obj.countWords("Date") <=0 || obj.countReferences("Works Cited") <0){
                    wordCountText.setText("Wrong Format");
                    ReferenceCountText.setText("Wrong Format");
                }else{
                    wordCountText.setText("Word count: " + obj.countWords("Date") + "+- some words");
                    ReferenceCountText.setText("Reference count: " + obj.countReferences("Works Cited"));
                    System.out.println("MLA");
                    System.out.println(returnSuccess());
                }

            }
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

        APA = new Button();

        HARVARD = new Button();

        MLA = new Button();




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
                        setFilePathGlobal(file.getName());
                        System.out.println(file.getName());

                    }
                }
                event.setDropCompleted(successGlobal);
                event.consume();
            }
        });

        pane.setLeft(APA);
        pane.setRight(HARVARD);
        stage.setTitle("QAFormatter");

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