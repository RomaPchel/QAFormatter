package com.example.qaformatter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.awt.*;


public class HelloController {
    public Label references;

    public boolean isAPAwasPressed() {
        return APAwasPressed;
    }

    public void setAPAwasPressed(boolean APAwasPressed) {
        this.APAwasPressed = APAwasPressed;
    }

    public boolean APAwasPressed;
    //QAFormatter obj = new QAFormatter();
    public Label count;
    @FXML
    private Label wordCountText;
    @FXML
    private Label ReferenceCountText;
    @FXML
    private Label formatGuide;
    @FXML
    private Label dragFile;
    @FXML
    private Text drag;
    public HelloController() throws AWTException {
    }


    @FXML
    private void initialize() {
        HelloApplication appObj = new HelloApplication();
        if (isAPAwasPressed()) {
            formatGuide.setText("1.topic of the paper\n" +
                    "2.originality\n" +
                    "3.word count\n" +
                    "4.instructions\n" +
                    "5.features\n" +
                    "6.proofread/format\n" +
                    "7.rate\n" +
                    "8.move to the next folder\n");

            drag.setText("Done!");
        } else {
            drag.setText("Drag File and Press Start!");

        }
    }

    @FXML
    protected void APA() throws Exception {

        HelloApplication appObj = new HelloApplication();
        Robot robot = new Robot();
        setAPAwasPressed(true);
                //obj.deleteHardReturnsForReferences(robot);
//            obj.setSpacing2(robot);
//            obj.setFontSize(robot);
//            obj.setFontStyle(robot);

//            wordCountText.setText("Word count: ");
//            count.setText(Integer.toString(obj.countWords()));
//            ReferenceCountText.setText("Reference count: ");
//            references.setText(Integer.toString(obj.countReferences()));




    }

}