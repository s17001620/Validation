package edu.glyndwr.validator.frontend.controller;

import edu.glyndwr.validator.backend.datal.entities.UniversityRecord;
import edu.glyndwr.validator.frontend.factories.FrontendStageFactory;
import edu.glyndwr.validator.frontend.strategies.validation.implementations.ComputingModuleCodeValidator;
import edu.glyndwr.validator.frontend.strategies.validation.implementations.PlasCochCampusRoomNumberValidator;
import edu.glyndwr.validator.frontend.strategies.validation.implementations.StudentIDValidator;
import edu.glyndwr.validator.frontend.strategies.validation.implementations.UKPostCodeValidator;
import edu.glyndwr.validator.frontend.strategies.validation.implementations.WGUEmailAddressValidator;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alexander Bruckbauer s17001620
 */
@Log
@Component
@Getter
@Setter
public class ValidatorViewController {

    private TableView<UniversityRecord> universityRecordTable;
    private TextField studentIDField;
    private TextField computingModuleCodeField;
    private TextField plasCochCampusRoomNumberField;
    private TextField wGUemailAddressField;
    private TextField uKPostcodeField;

    private Label studentIDFieldWrong;
    private Label computingModuleCodeFieldWrong;
    private Label plasCochCampusRoomNumberFieldWrong;
    private Label wGUemailAddressFieldWrong;
    private Label uKPostcodeFieldWrong;

    private StudentIDValidator studentIDValidator;
    private ComputingModuleCodeValidator computingModuleCodeValidator;
    private PlasCochCampusRoomNumberValidator plasCochCampusRoomNumberValidator;
    private WGUEmailAddressValidator wGUEmailAddressValidator;
    private UKPostCodeValidator uKPostCodeValidator;

    public void initializeStage(Stage primaryStage) {
        FrontendStageFactory uIfactory = new FrontendStageFactory();
        initializeFields();
        InputStream icon = null;
        try {
            icon = new DataInputStream(new FileInputStream(new ClassPathResource("icon.png").getFile()));
            
            if(null!=icon){
                Image imageIcon = new Image(icon);
                primaryStage.getIcons().add(imageIcon); 
            }else{
                log.info("icon inputstream null");
            }
           
        } catch (IOException ex) {
            Logger.getLogger(ValidatorViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        uIfactory.buildFrontendUI(this, primaryStage).show();
    }

    private void initializeFields() {
        studentIDField = new TextField();
        computingModuleCodeField = new TextField();
        plasCochCampusRoomNumberField = new TextField();
        wGUemailAddressField = new TextField();
        uKPostcodeField = new TextField();
        universityRecordTable = new TableView<>();
        studentIDValidator = new StudentIDValidator();
        computingModuleCodeValidator = new ComputingModuleCodeValidator();
        plasCochCampusRoomNumberValidator = new PlasCochCampusRoomNumberValidator();
        wGUEmailAddressValidator = new WGUEmailAddressValidator();
        uKPostCodeValidator = new UKPostCodeValidator();
        studentIDFieldWrong = new Label();
        computingModuleCodeFieldWrong = new Label();
        plasCochCampusRoomNumberFieldWrong = new Label();
        wGUemailAddressFieldWrong = new Label();
        uKPostcodeFieldWrong = new Label();
        studentIDFieldWrong.setTextFill(Color.web("#FF0000"));
        computingModuleCodeFieldWrong.setTextFill(Color.web("#FF0000"));
        plasCochCampusRoomNumberFieldWrong.setTextFill(Color.web("#FF0000"));
        wGUemailAddressFieldWrong.setTextFill(Color.web("#FF0000"));
        uKPostcodeFieldWrong.setTextFill(Color.web("#FF0000"));
    }

    public void deleteRecord() {
        TableViewSelectionModel tsm = universityRecordTable.getSelectionModel();
        if (tsm.isEmpty()) {
            System.out.println("Please select a row to delete.");
            return;
        }
        ObservableList<Integer> list = tsm.getSelectedIndices();
        Integer[] selectedIndices = new Integer[list.size()];
        selectedIndices = list.toArray(selectedIndices);
        Arrays.sort(selectedIndices);
        for (int i = selectedIndices.length - 1; i >= 0; i--) {
            tsm.clearSelection(selectedIndices[i]);
            UniversityRecord universityRecord = universityRecordTable.getItems().get(selectedIndices[i].intValue());
            universityRecordTable.getItems().remove(universityRecord);
        }
        universityRecordTable.refresh();
    }

    public void addRecord() {

        String studentIDFieldText = studentIDField.getText();
        String computingModuleCodeFieldText = computingModuleCodeField.getText();
        String plasCochCampusRoomNumberFieldText = plasCochCampusRoomNumberField.getText();
        String wGUemailAddressFieldText = wGUemailAddressField.getText();
        String uKPostcodeFieldText = uKPostcodeField.getText();
        Boolean isStudentIDValid = studentIDValidator.validateInput(studentIDFieldText);
        Boolean isComputingModuleCodeFieldValid = computingModuleCodeValidator.validateInput(computingModuleCodeFieldText);
        Boolean isPlasCochCampusRoomNumberFieldValid = plasCochCampusRoomNumberValidator.validateInput(plasCochCampusRoomNumberFieldText);
        Boolean iswGUemailAddressFieldValid = wGUEmailAddressValidator.validateInput(wGUemailAddressFieldText);
        Boolean isUKPostcodeFieldTextValid = uKPostCodeValidator.validateInput(uKPostcodeFieldText);

        Boolean isInputValid = isStudentIDValid && isComputingModuleCodeFieldValid && isPlasCochCampusRoomNumberFieldValid && iswGUemailAddressFieldValid && isUKPostcodeFieldTextValid;
        if (isInputValid) {
            UniversityRecord universityRecord = new UniversityRecord(studentIDFieldText, computingModuleCodeFieldText, plasCochCampusRoomNumberFieldText, wGUemailAddressFieldText, uKPostcodeFieldText);
            universityRecordTable.getItems().add(universityRecord);
            universityRecordTable.refresh();
        }
        SetFieldStatus(isInputValid, isStudentIDValid, isComputingModuleCodeFieldValid, isPlasCochCampusRoomNumberFieldValid, iswGUemailAddressFieldValid, isUKPostcodeFieldTextValid);
    }

    private void SetFieldStatus(Boolean isInputValid, Boolean isStudentIDValid, Boolean isComputingModuleCodeFieldValid, Boolean isPlasCochCampusRoomNumberFieldValid, Boolean iswGUemailAddressFieldValid, Boolean isUKPostcodeFieldTextValid) {
        if (!isStudentIDValid) {
            studentIDField.setStyle("-fx-control-inner-background: red");
            studentIDFieldWrong.setText("Student ID is invalid!");
        } else {
            studentIDField.setStyle("-fx-control-inner-background: white");
            studentIDFieldWrong.setText(null);
        }
        if (!isComputingModuleCodeFieldValid) {
            computingModuleCodeField.setStyle("-fx-control-inner-background: red");
            computingModuleCodeFieldWrong.setText("Computing Model Code is invalid!");
        } else {
            computingModuleCodeField.setStyle("-fx-control-inner-background: white");
            computingModuleCodeFieldWrong.setText(null);
        }
        if (!isPlasCochCampusRoomNumberFieldValid) {
            plasCochCampusRoomNumberField.setStyle("-fx-control-inner-background: red");
            plasCochCampusRoomNumberFieldWrong.setText("Plas Coch Campus Room Number is invalid!");
        } else {
            plasCochCampusRoomNumberField.setStyle("-fx-control-inner-background: white");
            plasCochCampusRoomNumberFieldWrong.setText(null);
        }
        if (!iswGUemailAddressFieldValid) {
            wGUemailAddressField.setStyle("-fx-control-inner-background: red");
            wGUemailAddressFieldWrong.setText("WGU Email Address is invalid!");
        } else {
            wGUemailAddressField.setStyle("-fx-control-inner-background: white");
            wGUemailAddressFieldWrong.setText(null);
        }
        if (!isUKPostcodeFieldTextValid) {
            uKPostcodeField.setStyle("-fx-control-inner-background: red");
            uKPostcodeFieldWrong.setText("UK Postcode invalid!");
        } else {
            uKPostcodeField.setStyle("-fx-control-inner-background: white");
            uKPostcodeFieldWrong.setText(null);
        }
        if (isInputValid) {
            studentIDField.setText(null);
            computingModuleCodeField.setText(null);
            plasCochCampusRoomNumberField.setText(null);
            wGUemailAddressField.setText(null);
            uKPostcodeField.setText(null);
        }
    }

}
