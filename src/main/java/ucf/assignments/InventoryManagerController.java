package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


import java.net.URL;
import java.util.ResourceBundle;

public class InventoryManagerController implements Initializable {
    @FXML
    private TableView<ItemInfo> ItemTable;

    @FXML
    private TableColumn<ItemInfo, String> valueColumn;

    @FXML
    private TableColumn<ItemInfo, String> serialColumn;

    @FXML
    private TableColumn<ItemInfo, String> nameColumn;

    @FXML
    private TextField entervaluefield;

    @FXML
    private TextField enterserialnumberfield;

    @FXML
    private TextField enternamefield;

    public void changeValueColumnEvent(TableColumn.CellEditEvent edditedCell){
    ItemInfo itemInfoSelected = ItemTable.getSelectionModel().getSelectedItem();
    itemInfoSelected.setValue(edditedCell.getNewValue().toString());
    }

    public void changeSerialColumnEvent(TableColumn.CellEditEvent edditedCell){
        ItemInfo itemInfoSelected = ItemTable.getSelectionModel().getSelectedItem();
        itemInfoSelected.setSerialnumber(edditedCell.getNewValue().toString());
    }

    public void changeNameColumnEvent(TableColumn.CellEditEvent edditedCell){
        ItemInfo itemInfoSelected = ItemTable.getSelectionModel().getSelectedItem();
        itemInfoSelected.setName(edditedCell.getNewValue().toString());
    }


    @FXML
    public void addnewitem(ActionEvent actionEvent) {

        ItemInfo newItemInfo = new ItemInfo(enternamefield.getText(),
                                            enterserialnumberfield.getText(),
                                           entervaluefield.getText());
        //add value checker for serialnumber, and add converter for value
        ItemTable.getItems().add(newItemInfo);
    }

    @FXML
    public void removeitem(ActionEvent actionEvent) {
        //remove selected rows
        //remember observablelist for item sorting
        ObservableList<ItemInfo> selectedRows, allItems;
        allItems = ItemTable.getItems();

        selectedRows = ItemTable.getSelectionModel().getSelectedItems();
        allItems.removeAll(selectedRows);
    }


    @FXML
    public void sortbyvalue(ActionEvent actionEvent) {
    }

    @FXML
    public void sortbyserialnumber(ActionEvent actionEvent) {
    }

    @FXML
    public void sortbyname(ActionEvent actionEvent) {
    }

    @FXML
    public void searchSerialNumber(ActionEvent actionEvent) {
    }

    @FXML
    public void searchName(ActionEvent actionEvent) {
    }

    @FXML
    public void loadaninventory(ActionEvent actionEvent) {
    }

    @FXML
    public void saveinventorytofile(ActionEvent actionEvent) {
    }






    @Override
    public void initialize(URL url, ResourceBundle rb){
    valueColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("value"));
    serialColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("serialnumber"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("name"));


    //edit initialization
    ItemTable.setEditable(true);
    valueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    serialColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    //remove initialization
    ItemTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }



}
