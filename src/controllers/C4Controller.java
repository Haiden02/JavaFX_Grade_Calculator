package controllers;

import application.Assignment;
import application.Calculate;
import application.FileEditor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class C4Controller implements Initializable {

    @FXML
    private Label grade;
    @FXML
    private TextField markField;
    @FXML
    private TextField weightField;
    @FXML
    private TableView<Assignment> table;
    @FXML
    private TableColumn<Assignment, Double> marks;
    @FXML
    private TableColumn<Assignment, Double> weights;

    ObservableList<Assignment> list = FXCollections.observableArrayList();

    @FXML
    void add(ActionEvent e) throws FileNotFoundException {
        double mark = 0;
        double weight = 0;
        String temp = this.markField.getText();

        try{
            mark = Double.parseDouble(temp);
        }catch (Exception er){
            return;
        }

        temp = this.weightField.getText();

        try{
            weight = Double.parseDouble(temp);
        }catch (Exception er){
            return;
        }

        this.list.add(new Assignment(mark, weight));
        this.markField.clear();
        this.weightField.clear();
        calculate();
    }

    @FXML
    public void delete(ActionEvent e) throws FileNotFoundException {
        try {
            this.list.remove(this.table.getSelectionModel().getSelectedIndex());
        } catch (Exception er) {
            return;
        }
        calculate();
    }

    @FXML
    public void back(ActionEvent e) throws IOException {
        calculate();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../scenes/home.fxml"));
        Parent root = loader.load();
        HomeController hc = loader.getController();
        hc.calculateAll();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.marks.setCellValueFactory(new PropertyValueFactory<Assignment, Double>("mark"));
        this.weights.setCellValueFactory(new PropertyValueFactory<Assignment, Double>("weight"));
        this.table.setItems(list);
    }

    public void calculate() throws FileNotFoundException {
        List<Double> marks = new ArrayList<>();
        List<Double> weights = new ArrayList<>();
        FileEditor c4Editor = new FileEditor();

        for(Assignment a : this.list){
            marks.add(a.getMark());
            weights.add(a.getWeight());
        }

        c4Editor.edit("C4", marks, weights);
        Calculate calc = new Calculate("C4");
        calc.calculateMark();
        this.grade.setText(calc.toString());
    }

    public void setUp() throws FileNotFoundException {
        FileEditor fe = new FileEditor();
        fe.read("C4");
        List<Double> marks = fe.getMarks();
        List<Double> weights = fe.getWeights();

        if(marks.size() == weights.size()){
            for(int i = 0; i < marks.size(); i++){
                this.list.add(new Assignment(marks.get(i), weights.get(i)));
            }
        }
        else{
            return;
        }

        Calculate calc = new Calculate("C4");
        calc.calculateMark();
        this.grade.setText(calc.toString());
    }
}
