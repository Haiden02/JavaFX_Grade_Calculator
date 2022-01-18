package controllers;

import application.Calculate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label c1Label;
    @FXML
    private Label c2Label;
    @FXML
    private Label c3Label;
    @FXML
    private Label c4Label;
    @FXML
    private Label c5Label;

    @FXML
    public void c1(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../scenes/course1.fxml"));
        this.root = loader.load();
        C1Controller c = loader.getController();
        c.setUp();
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.show();
    }

    @FXML
    public void c2(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../scenes/course2.fxml"));
        this.root = loader.load();
        C2Controller c = loader.getController();
        c.setUp();
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.show();
    }

    @FXML
    public void c3(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../scenes/course3.fxml"));
        this.root = loader.load();
        C3Controller c = loader.getController();
        c.setUp();
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.show();
    }

    @FXML
    public void c4(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../scenes/course4.fxml"));
        this.root = loader.load();
        C4Controller c = loader.getController();
        c.setUp();
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.show();
    }

    @FXML
    public void c5(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../scenes/course5.fxml"));
        this.root = loader.load();
        C5Controller c = loader.getController();
        c.setUp();
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.show();
    }

    public void calculateAll() throws FileNotFoundException {
        Calculate calc = new Calculate("C1");
        calc.calculateMark();
        this.c1Label.setText(calc.toString());

        calc = new Calculate("C2");
        calc.calculateMark();
        this.c2Label.setText(calc.toString());

        calc = new Calculate("C3");
        calc.calculateMark();
        this.c3Label.setText(calc.toString());

        calc = new Calculate("C4");
        calc.calculateMark();
        this.c4Label.setText(calc.toString());

        calc = new Calculate("C5");
        calc.calculateMark();
        this.c5Label.setText(calc.toString());
    }
}
