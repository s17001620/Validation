
package edu.glyndwr.validator.frontend.factories;


import edu.glyndwr.validator.frontend.controller.ValidatorViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.springframework.stereotype.Component;


/**
 *
 * @author Alexander Bruckbauer s17001620
 */
@Component
public class UniversityRecordNewDataPaneFactory {
public GridPane buildNewUniversityRecordDataPane(ValidatorViewController controller){
       GridPane pane = new GridPane();

        pane.setHgap(10);
        pane.setVgap(5);

        pane.addRow(0, new Label("Student ID: "), controller.getStudentIDField());
        pane.addRow(1, new Label("Computing module code: "), controller.getComputingModuleCodeField());
        pane.addRow(2, new Label("Plas Coch campus room number: "), controller.getPlasCochCampusRoomNumberField());
        pane.addRow(3, new Label("WGU email address: "), controller.getWGUemailAddressField());
        pane.addRow(4, new Label("UK postcode: "), controller.getUKPostcodeField());

        Button addButton = new Button("Add");       
        addButton.setOnAction((ActionEvent e) -> {
           controller.addRecord();
        });     
       Button deleteButton = new Button("Delete Selected Rows");
        deleteButton.setOnAction((ActionEvent e) -> {
            controller.deleteRecord();
        }); 

        pane.add(addButton, 2, 0);
        pane.add(deleteButton, 1, 7);
     
        return pane;
    }

}
