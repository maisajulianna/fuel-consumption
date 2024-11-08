package org.example.fuelconsumption;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Locale;
import java.util.ResourceBundle;

public class CalculatorController {
    @FXML
    private Label distanceLbl;
    @FXML
    private Label fuelLbl;
    @FXML
    private Label result;
    @FXML
    private Label invalidInput;
    @FXML
    private Button btnCalculate;
    @FXML
    private TextField distanceInput;
    @FXML
    private TextField fuelInput;

    private ResourceBundle bundle;
    private Locale locale;

    @FXML
    private VBox fuelConsumptionVBox;

    // methods to change the language
    @FXML
    private void loadLanguage(String lang, String country) {
        locale = new Locale(lang, country);
        bundle = ResourceBundle.getBundle("calculator", locale);
        updateLanguage();
    }
    private void updateLanguage() {
        distanceLbl.setText(bundle.getString("distance"));
        fuelLbl.setText(bundle.getString("fuel"));
        btnCalculate.setText(bundle.getString("calculate"));
    }
    @FXML
    public void onbtnClickEN(ActionEvent actionEvent) {
        loadLanguage("en", "UK");
        fuelConsumptionVBox.setVisible(true);
    }
    @FXML
    public void onbtnClickFR(ActionEvent actionEvent) {
        loadLanguage("fr", "FR");
        fuelConsumptionVBox.setVisible(true);
    }
    @FXML
    public void onbtnClickJP(ActionEvent actionEvent) {
        loadLanguage("ja", "JP");
        fuelConsumptionVBox.setVisible(true);
    }
    @FXML
    public void onbtnClickIR(ActionEvent actionEvent) {
        loadLanguage("fa", "IR");
        fuelConsumptionVBox.setVisible(true);
    }


    // method to calculate the fuel consumption
    @FXML
    public void onbtnClickCalculate(ActionEvent actionEvent) {
        try {
            String distanceStr = distanceInput.getText();
            String fuelStr = fuelInput.getText();

            // convert to double
            double distance = Double.parseDouble(distanceStr);
            double fuel = Double.parseDouble(fuelStr);

            // calculation
            double fuelConsumption = (fuel / distance) * 100;

            // get result message
            String resultMessage = bundle.getString("result");

            String formattedResult = String.format(resultMessage, fuelConsumption);
            result.setText(formattedResult);

        } catch (NumberFormatException e) {
            invalidInput.setText(bundle.getString("invalid"));
        }
    }
}