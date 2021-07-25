package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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

    private final ObservableList<ItemInfo> dataList = FXCollections.observableArrayList();

    public void changeValueColumnEvent(TableColumn.CellEditEvent edditedCell){
        //set value column to string
    ItemInfo itemInfoSelected = ItemTable.getSelectionModel().getSelectedItem();
    itemInfoSelected.setValue(edditedCell.getNewValue().toString());
    }

    public void changeSerialColumnEvent(TableColumn.CellEditEvent edditedCell){
        //set serial column to string
        ItemInfo itemInfoSelected = ItemTable.getSelectionModel().getSelectedItem();
        itemInfoSelected.setSerialnumber(edditedCell.getNewValue().toString());
    }

    public void changeNameColumnEvent(TableColumn.CellEditEvent edditedCell){
        //set name column to string
        ItemInfo itemInfoSelected = ItemTable.getSelectionModel().getSelectedItem();
        itemInfoSelected.setName(edditedCell.getNewValue().toString());
    }


    @FXML
    public void addnewitem(ActionEvent actionEvent) {
    //link new iteminfo to text fields

        ItemInfo newItemInfo = new ItemInfo(enternamefield.getText(),
                                            enterserialnumberfield.getText(),
                                           entervaluefield.getText());
        //add value checker for serialnumber, and add converter for value
        //get the items and add it to tableview
        ItemTable.getItems().add(newItemInfo);
    }

    @FXML
    public void removeitem(ActionEvent actionEvent) {
        //remove selected rows
        //remember observablelist for item sorting
        ObservableList<ItemInfo> selectedRows, allItems;
        allItems = ItemTable.getItems();
        //remove selected rows
        selectedRows = ItemTable.getSelectionModel().getSelectedItems();
        allItems.removeAll(selectedRows);
    }


    @FXML
    public void sortbyvalue(ActionEvent actionEvent) {
        //sort order function for value
        ItemTable.getSortOrder().add(valueColumn);

    }

    @FXML
    public void sortbyserialnumber(ActionEvent actionEvent) {
        //sort order function for serial
        ItemTable.getSortOrder().add(serialColumn);
    }

    @FXML
    public void sortbyname(ActionEvent actionEvent) {
        //sort order function for name
        ItemTable.getSortOrder().add(nameColumn);
    }

    @FXML
    public void searchSerialNumber(ActionEvent actionEvent) {
        //use enterserialnumber textfield to search
        setCellValueFactory();
        //use filterfield and ifelse get functions
        FilteredList<ItemInfo> filteredData = new FilteredList<>(dataList, b->true);

    }

    @FXML
    public void searchName(ActionEvent actionEvent) {
        //use entername textfield to search

        //use filterfield and ifelse get functions

    }

    @FXML
    public void loadaninventory(ActionEvent actionEvent) {
        //file choooser
        //pop up, ask for file namme
    }

    @FXML
    public void saveinventorytofile(ActionEvent actionEvent) {
        //file chooser
        //pop up new scene and request file name and save to machine
        //reader and writer function either here or new function
    }


    public void initialedititems(){
        //edit initialization
        ItemTable.setEditable(true);
        valueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        serialColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void initialremoveitems(){
        //remove item initialization function
        ItemTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void setCellValueFactory(){
        //initialization cellvaluefactory
        valueColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("value"));
        serialColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("serialnumber"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("name"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
   //setCellValue
    setCellValueFactory();
    //edit
    initialedititems();
    //remove initialization
    initialremoveitems();

    }




}
