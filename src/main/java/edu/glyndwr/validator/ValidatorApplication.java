package edu.glyndwr.validator;

import edu.glyndwr.validator.frontend.controller.ValidatorViewController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("edu.glyndwr.validator")
public class ValidatorApplication extends Application {
    private ConfigurableApplicationContext context;
    @Autowired
    private ValidatorViewController validatorViewController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        validatorViewController = (ValidatorViewController) context.getBean(ValidatorViewController.class);
        validatorViewController.initializeStage(primaryStage);
    }
    
    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ValidatorViewController.class);
        context = builder.run(getParameters().getRaw().toArray(new String[0]));
    }
    
      @Override
    public void stop() throws Exception {
        context.close();
    }

}

