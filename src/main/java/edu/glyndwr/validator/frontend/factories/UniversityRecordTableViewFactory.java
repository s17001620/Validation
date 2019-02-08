package edu.glyndwr.validator.frontend.factories;


import edu.glyndwr.validator.backend.model.entities.UniversityRecord;
import edu.glyndwr.validator.frontend.controller.ValidatorViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alexander Bruckbauer s17001620
 */
@Component
public class UniversityRecordTableViewFactory {

    @Getter
   ObservableList<UniversityRecord> universityRecordList;
    private ValidatorViewController controller;

    public UniversityRecordTableViewFactory() {
        universityRecordList = FXCollections.<UniversityRecord>observableArrayList();
    }

    public TableView<UniversityRecord> getNewTable() {
        TableView<UniversityRecord> table = new TableView<>();
        table.getColumns().addAll(getStudentIDColumn(),getComputingModuleCodeColumn(),getPlasCochCampusRoomNumberColumn(),getWGUemailAddressColumn(),getUKPostcodeColumn());
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPlaceholder(new Label("No visible columns and/or data exist."));
        table.setMinWidth(1000.0);
        return table;
    }



    public TableColumn<UniversityRecord, String> getStudentIDColumn() {
        TableColumn<UniversityRecord, String> studentIDCol = new TableColumn<>("StudentID");
        PropertyValueFactory<UniversityRecord, String> studentIDCellValueFactory = new PropertyValueFactory<>("studentID");
        studentIDCol.setCellValueFactory(studentIDCellValueFactory);
        return studentIDCol;
    }

    public TableColumn<UniversityRecord, String> getComputingModuleCodeColumn() {
        TableColumn<UniversityRecord, String> computingModuleCodeCol = new TableColumn<>("ComputingModuleCode");
        PropertyValueFactory<UniversityRecord, String> computingModuleCodeCellValueFactory = new PropertyValueFactory<>("computingModuleCode");
        computingModuleCodeCol.setCellValueFactory(computingModuleCodeCellValueFactory);
        return computingModuleCodeCol;
    }

    public TableColumn<UniversityRecord, String> getPlasCochCampusRoomNumberColumn() {
        TableColumn<UniversityRecord, String> plasCochCampusRoomNumberCol = new TableColumn<>("PlasCochCampusRoomNumber");
        PropertyValueFactory<UniversityRecord, String> plasCochCampusRoomNumberCellValueFactory = new PropertyValueFactory<>("plasCochCampusRoomNumber");
        plasCochCampusRoomNumberCol.setCellValueFactory(plasCochCampusRoomNumberCellValueFactory);
        return plasCochCampusRoomNumberCol;
    }

        public TableColumn<UniversityRecord, String> getWGUemailAddressColumn() {
        TableColumn<UniversityRecord, String> wGUemailAddressCol = new TableColumn<>("WGUemailAddress");
        PropertyValueFactory<UniversityRecord, String> wGUemailAddressCellValueFactory = new PropertyValueFactory<>("wGUemailAddress");
        wGUemailAddressCol.setCellValueFactory(wGUemailAddressCellValueFactory);
        return wGUemailAddressCol;
    }
   
      public TableColumn<UniversityRecord, String> getUKPostcodeColumn() {
        TableColumn<UniversityRecord, String> uKPostcodeCol = new TableColumn<>("UKPostcode");
        PropertyValueFactory<UniversityRecord, String> uKPostcodeCellValueFactory = new PropertyValueFactory<>("uKPostcode");
        uKPostcodeCol.setCellValueFactory(uKPostcodeCellValueFactory);
        return uKPostcodeCol;
    }
}
