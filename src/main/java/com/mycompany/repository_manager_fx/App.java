package com.mycompany.repository_manager_fx;

import UI.Pages.LoadPage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Load");
        tab1.setClosable(false);
        tab1.setContent(new LoadPage());

        tabPane.getTabs().addAll(tab1);

        Scene mainScene = new Scene(tabPane);
        stage.setWidth(600);
        stage.setHeight(600);

        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
