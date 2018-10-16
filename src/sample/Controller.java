package sample;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.security.Key;
import java.util.*;


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

    @FXML
    private CheckBox containerCheck;


    public void initialize(URL url, ResourceBundle rb){
        loadTreeItems("SkyFarm");

    }

    //Sets tree and can load array of saved tree items
    public void loadTreeItems(String ...rootItems){
        Items rootItem = new Item("Farm",0.0,0,0,0,0);
        TreeItem<String> root = new TreeItem<>(rootItem.getName());
        root.setExpanded(true);
        tree.setShowRoot(false);
        for(String itemString: rootItems){
            root.getChildren().add(new TreeItem<>(new Item(itemString,0.0,1,1,1,1).getName()));
        }
        tree.setRoot(root);
    }

    public Map.Entry<String,Items> getEntrySet(String findingKey) {
        ArrayList<HashMap<String, Items>> toCheck = new ArrayList<>();
        toCheck.add(Main.itemMap);
        while (!toCheck.isEmpty()) {
            HashMap<String, Items> checking = toCheck.remove(0);
            for (Map.Entry<String, Items> entry : checking.entrySet()) {
                if (entry.getKey().equals(findingKey)) return entry;
                if (entry.getValue().getType()) toCheck.add(entry.getValue().getChildren());
            }
        }
        return null;
    }

    public boolean containsKey(String findingKey){
        ArrayList<HashMap<String, Items>> toCheck = new ArrayList<>();
        toCheck.add(Main.itemMap);
        while(!toCheck.isEmpty()){
            HashMap<String, Items> checking = toCheck.remove(0);
            for(Map.Entry<String,Items> entry:checking.entrySet()){
                if (entry.getKey().equals(findingKey)) return true;
                if (entry.getValue().getType()) toCheck.add(entry.getValue().getChildren());
            }

        };
        return false;
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
            Items newItem = containerCheck.isSelected() ? new Item(nameBox.getText(), 1.0, 5, 5, 5, 5):
                    new ItemContainer(nameBox.getText(), 1.0, 5, 5, 5, 5);
            Main.itemMap.put(newItem.getName(), newItem);
            selectedItem.getChildren().add(new TreeItem<>(newItem.getName()));
            selectedItem.setExpanded(true);

            System.out.println(new Gson().toJson(Main.itemMap));
            try {
                PrintWriter writer = new PrintWriter(new File("skyfarm.json"));
                writer.print(new Gson().toJson(Main.itemMap));
                writer.close();
            }
            catch (IOException e){e.printStackTrace();}
        }


    }

    @FXML
    void confirmEdit(ActionEvent event) {
        try{
            FileReader file = new FileReader(new File("skyfarm.json"));
            BufferedReader reader = new BufferedReader(file);

            String line;
            String output = "";

            while((line = reader.readLine()) != null){
                output += line;
            }
            Main.itemMap = new Gson().fromJson(output,Main.itemMap.getClass());
            Map.Entry<String, Items> mapped;
            if((mapped = getEntrySet(nameBox.getText()))!=null){
                ////FINISH THIS TOMORROW
            }
            System.out.println(Main.itemMap);

        } catch(IOException e){e.printStackTrace();}}

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

