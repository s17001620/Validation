

package edu.glyndwr.validator.frontend.controller;


import edu.glyndwr.validator.backend.model.entities.UniversityRecord;
import edu.glyndwr.validator.frontend.factories.FrontendStageFactory;

import java.util.Arrays;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 * @author Alexander Bruckbauer s17001620
 */
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

    public void initializeStage(Stage primaryStage) {
        FrontendStageFactory uIfactory = new FrontendStageFactory();
        initializeFields();
        uIfactory.buildFrontendUI(this, primaryStage).show();
    }
    
    private void initializeFields(){
    studentIDField = new TextField();
    computingModuleCodeField= new TextField();
    plasCochCampusRoomNumberField= new TextField();
    wGUemailAddressField= new TextField();
    uKPostcodeField= new TextField();
    universityRecordTable = new TableView<>();
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
    String computingModuleCodeFieldText= computingModuleCodeField.getText();
    String plasCochCampusRoomNumberFieldText= plasCochCampusRoomNumberField.getText();
    String wGUemailAddressFieldText= wGUemailAddressField.getText();
    String uKPostcodeFieldText= uKPostcodeField.getText();
    // #TODO Validation happens HEre!!!
    
        UniversityRecord universityRecord = new UniversityRecord(studentIDFieldText, computingModuleCodeFieldText,plasCochCampusRoomNumberFieldText, wGUemailAddressFieldText, uKPostcodeFieldText);
        universityRecordTable.getItems().add(universityRecord);
        universityRecordTable.refresh();
        
    }
}
