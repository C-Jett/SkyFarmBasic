package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private TreeView<String> tree;

    @FXML
    private TextField priceBox;

    @FXML
    private TextField nameBox;

    @FXML
    private TextField xCoord;

    @FXML
    private TextField lenBox;

    @FXML
    private TextField yCoord;

    @FXML
    private TextField widthBox;

    @FXML
    private Button confirmButton;

    @FXML
    private Button removeButton;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Button newButton;


    public void initialize(URL url, ResourceBundle rb){
        loadTreeItems("SkyFarm");

    }

    //Sets tree and can load array of saved tree items
    public void loadTreeItems(String ...rootItems){
        Items rootItem = new Items("Farm",0.0,0,0,0,0);
        TreeItem<String> root = new TreeItem<>(rootItem.getName());
        root.setExpanded(true);
        tree.setShowRoot(false);
        for(String itemString: rootItems){
            root.getChildren().add(new TreeItem<>(new Items(itemString,0.0,1,1,1,1).getName()));
        }
        tree.setRoot(root);

    }

    //Adds new item to the tree with the selected value
    @FXML
    void addNewItem(ActionEvent event) {
        TreeItem<String> selectedItem = tree.getSelectionModel().getSelectedItem();

        if(selectedItem == null || nameBox.getText().isEmpty()){
            System.out.println("The Tree is empty");
        }
        else{
            //Add a bool to check for item-container
            selectedItem.getChildren().add(new TreeItem<>(nameBox.getText()));
            selectedItem.setExpanded(true);
        }

    }

    @FXML
    void confirmEdit(ActionEvent event) {

   }

    @FXML
    void removeItem(ActionEvent event) {
        TreeItem<String> selectedItem = tree.getSelectionModel().getSelectedItem();

        if(selectedItem == null || selectedItem.getValue() == "SkyFarm"){
            System.out.println("Please add a new item to the list!");
        }

        else{
            //Add a bool to check for item-container
            selectedItem.getParent().getChildren().remove(selectedItem);
            selectedItem.setExpanded(true);
        }

    }

    //Most certainly not needed anymore, as selection model does this.
    @FXML
    void selectItem(MouseEvent event) {


    }

    @FXML
    void sendName(ActionEvent event) {
        nameBox.getText();
    }

    @FXML
    void sendPrice(ActionEvent event) {
        Integer.parseInt(priceBox.getText());
    }

    @FXML
    void setColor(ActionEvent event) {

    }

    @FXML
    void setLen(ActionEvent event) {

    }

    @FXML
    void setWidth(ActionEvent event) {

    }

    @FXML
    void setXCoord(ActionEvent event) {

    }

    @FXML
    void setYCoord(ActionEvent event) {

    }
}

