package edu.glyndwr.validator.frontend.factories;

import edu.glyndwr.validator.frontend.controller.ValidatorViewController;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;

/**
 *
 * @author Alexander Bruckbauer s17001620
 */
@Component
public class FrontendStageFactory {

    private UniversityRecordTableViewFactory universityRecordTableViewFactory;
    private UniversityRecordNewDataPaneFactory universityRecordNewDataPaneFactory;

    public Stage buildFrontendUI(ValidatorViewController controller, Stage stage) {
        universityRecordTableViewFactory = new UniversityRecordTableViewFactory();
        universityRecordNewDataPaneFactory = new UniversityRecordNewDataPaneFactory();
        VBox root = new VBox();
        root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;");
        GridPane universityRecordNewDataPane;
        controller.setUniversityRecordTable(universityRecordTableViewFactory.getNewTable());
        universityRecordNewDataPane = universityRecordNewDataPaneFactory.buildNewUniversityRecordDataPane(controller);
        FlowPane pane = new FlowPane();
        pane.getChildren().addAll(universityRecordNewDataPane, controller.getUniversityRecordTable());
        root.getChildren().addAll(pane);
        root.setSpacing(5);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("University Records");
        return stage;
    }
}
