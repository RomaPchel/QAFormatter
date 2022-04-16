package com.example.qaformatter;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    static String filePathGlobal;
    static boolean successGlobal;
    @Override
    public void start(Stage primaryStage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 320);


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

        primaryStage.setResizable(true);
        primaryStage.setTitle("QAFormatter");
        primaryStage.setScene(scene);
        primaryStage.show();
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