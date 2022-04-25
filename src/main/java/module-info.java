module com.example.qaformatter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.aspose.words;



    opens com.example.qaformatter to javafx.fxml;
    exports com.example.qaformatter;
}