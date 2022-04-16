package com.example.qaformatter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.awt.*;


public class HelloController {
    public Label references;

    QAFormatter obj = new QAFormatter();
    public Label count;
    @FXML
    private Label wordCountText;
    @FXML
    private Label ReferenceCountText;
    @FXML
    private Label dragFile;
    @FXML
    private Text drag;
    public HelloController() throws AWTException {
    }


    @FXML
    private void initialize() {
        HelloApplication appObj = new HelloApplication();
        if (appObj.returnSuccess()) {

            drag.setText("Done!");
        }else{
            drag.setText("Drag File and Press Start!");
        }
    }
    @FXML
    protected void CountWord() throws Exception {

        HelloApplication appObj = new HelloApplication();
        Robot robot = new Robot();


            //obj.deleteHardReturnsForReferences(robot);
//            obj.setSpacing2(robot);
//            obj.setFontSize(robot);
//            obj.setFontStyle(robot);
            wordCountText.setText("Word count: ");
            count.setText(Integer.toString(obj.countWords()));
            ReferenceCountText.setText("Reference count: ");
            references.setText(Integer.toString(obj.countReferences()));




    }

}