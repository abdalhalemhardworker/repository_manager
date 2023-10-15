package UI.Pages;

import Entities.LoadModel;
import Repo.LoadRepo;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class LoadPage extends SplitPane {

    Label loadNumberLable = new Label("load number");
    TextField loadNumberTextField = new TextField();

    TableView<LoadModel> dataTable = new TableView<>();
    LoadModel selectedLoad;

    public LoadPage() {
        setOrientation(Orientation.VERTICAL);
        setDividerPosition(0, 0.5);

        getItems().addAll(buildFormPan(), buildTable());
    }

    private Pane buildFormPan() {

        HBox firstRow = new HBox();
        loadNumberLable = new Label("load number");
        loadNumberLable.setPadding(new Insets(0, 10, 0, 10));
        HBox.setHgrow(loadNumberLable, Priority.NEVER);
        HBox.setHgrow(loadNumberTextField, Priority.ALWAYS);

        firstRow.getChildren().addAll(loadNumberLable, loadNumberTextField);

        Button saveButton = new Button("save");
        saveButton.setOnMousePressed((t) -> {
            if (dataTable.getSelectionModel().getSelectedItems().isEmpty()) {
                LoadRepo.addNew(new LoadModel(0, loadNumberTextField.getText()));

                ObservableList dataRef = dataTable.getItems();
                dataRef.clear();

                for (LoadModel load : LoadRepo.getAll()) {
                    dataRef.add(load);
                }

                return;
            }
//            System.out.println(selectedLoad.toString());

            
            System.out.println(LoadRepo.updateLoad(selectedLoad.getId(), selectedLoad));

            ObservableList dataRef = dataTable.getItems();
            dataRef.clear();

            for (LoadModel load : LoadRepo.getAll()) {
                dataRef.add(load);
            }
        });

        AnchorPane emptyPan = new AnchorPane();
        VBox.setVgrow(emptyPan, Priority.ALWAYS);

        VBox form = new VBox(firstRow, emptyPan, saveButton);

        return form;
    }

    private TableView buildTable() {

        TableColumn<LoadModel, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory((p) -> new SimpleIntegerProperty(p.getValue().getId()).asObject());

        TableColumn<LoadModel, String> loadNumberColumn = new TableColumn<>("Load Number");
        loadNumberColumn.setCellValueFactory((p) -> new SimpleStringProperty(p.getValue().getLoadNumber()));

        dataTable.getColumns().addAll(idColumn, loadNumberColumn);

        dataTable.setOnMouseClicked((t) -> {
            selectedLoad = dataTable.getSelectionModel().getSelectedItem();
            loadNumberTextField.setText(selectedLoad.getLoadNumber());
        });

        ObservableList dataRef = dataTable.getItems();
        for (LoadModel load : LoadRepo.getAll()) {
            dataRef.add(load);
        }
        return dataTable;
    }
}
