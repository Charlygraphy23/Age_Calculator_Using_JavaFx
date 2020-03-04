package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Period;

public class Controller {

    @FXML
    private JFXButton closeButton;

    @FXML
    private JFXDatePicker dobDateTimePicker;

    @FXML
    private JFXDatePicker presentDateTimePicker;

    @FXML
    private Label yearsLabel;

    @FXML
    private Label daysLabel;

    @FXML
    void Close(ActionEvent e) {
        Stage stage=(Stage)((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    private  LocalDate birthDate,presentDate;

    @FXML
    void initialize() {
       presentDateTimePicker.setValue(LocalDate.now());
       dobDateTimePicker.setValue(LocalDate.of(2000,8,19));

       birthDate=dobDateTimePicker.getValue();
       presentDate=presentDateTimePicker.getValue();

        if(presentDateTimePicker.getValue()!=null && dobDateTimePicker.getValue()!=null){
            Period age=Period.between(dobDateTimePicker.getValue(),presentDateTimePicker.getValue());
            yearsLabel.setText(String.valueOf(age.getYears()));
            daysLabel.setText(" Years "+String.valueOf(age.getMonths())+" Months "+String.valueOf(age.getDays())+" Days ");
        }

       dobDateTimePicker.setOnAction(e->{
           if(presentDateTimePicker.getValue()!=null){
               Period age=Period.between(dobDateTimePicker.getValue(),presentDateTimePicker.getValue());
               yearsLabel.setText(String.valueOf(age.getYears()));
               daysLabel.setText(" Years "+String.valueOf(age.getMonths())+" Months "+String.valueOf(age.getDays())+" Days ");
           }
       });
        presentDateTimePicker.setOnAction(e->{
            if(dobDateTimePicker  .getValue()!=null){
                Period age=Period.between(dobDateTimePicker.getValue(),presentDateTimePicker.getValue());
                yearsLabel.setText(String.valueOf(age.getYears()));
                daysLabel.setText(" Years "+String.valueOf(age.getMonths())+" Months "+String.valueOf(age.getDays())+" Days ");
            }
        });

    }
}
