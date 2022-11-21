package com.example.softmethproject4;

import javafx.application.Application;
import javafx.beans.binding.ObjectExpression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

/**
 * This class defines the Controller for the CHIStyleView and also defines all attributes and elements on the
 * CHIStyleView, as well as the methods behind each ActionEvent that occurs on that view and connects to the backend program.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class CHIStyleController {

    Pizza currentPizza;

    ArrayList<Pizza> pizzaList;

    ArrayList<Topping> currentToppings;

    ObservableList<Topping> offeredToppings;

    Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);

    private final static double TOPPINGPRICE = 1.59;
    @FXML
    private ComboBox toppingOptions;

    @FXML
    private ImageView pizzaDisplay;

    @FXML
    private ToggleGroup sizeGroup;
    @FXML
    private RadioButton small;

    @FXML
    private RadioButton medium;

    @FXML
    private RadioButton large;

    @FXML
    private TextArea crustType;

    @FXML
    private ListView possibleToppingsList;

    @FXML
    private ListView addedToppingsList;

    @FXML
    private Button addToppingButton;

    @FXML
    private Button removeToppingButton;

    @FXML
    private TextArea totalCost;

    @FXML
    private Button addOrder;

    /**
     * This method sets the ListView of toppings in the CHIStyleView dependent on which flavor option is selected.
     */
    @FXML
    protected void setOptions() {
        if (toppingOptions.getValue() == null) {
            return;
        }

        resetToppings();
        if (toppingOptions.getValue().toString().equalsIgnoreCase("Deluxe")) {
            currentPizza = new ChicagoPizza().createDeluxe(findSize());
            pizzaDisplay.setImage(new Image(getClass().getResource("/images/chicagodeluxe.jpg").toExternalForm()));
        } else if (toppingOptions.getValue().toString().equalsIgnoreCase("BBQ Chicken")) {
            currentPizza = new ChicagoPizza().createBBQChicken(findSize());
            pizzaDisplay.setImage(new Image(getClass().getResource("/images/chicagobbq.jpg").toExternalForm()));
        } else if (toppingOptions.getValue().toString().equalsIgnoreCase("Meatzza")) {
            currentPizza = new ChicagoPizza().createMeatzza(findSize());
            pizzaDisplay.setImage(new Image(getClass().getResource("/images/chicagomeatzza.jpeg").toExternalForm()));
        } else if (toppingOptions.getValue().toString().equalsIgnoreCase("Build Your Own")) {
            currentPizza = new ChicagoPizza().createBuildYourOwn(currentToppings, findSize());
            pizzaDisplay.setImage(new Image(getClass().getResource("/images/chicagobuildyourown.jpeg").toExternalForm()));
        }
        crustType.setText(currentPizza.getCrust().toString());
        setToppings();
        setPrice();

    }

    /**
     * This method is called whenever the user selects a topping in the CHIStyleView and presses the Add button to add
     * that topping to the pizza. If the user tries to add more than 7 toppings to their Build Your Own pizza or new toppings
     * to a pizza with set toppings, the method will do nothing.
     */
    @FXML
    protected void addTopping() {
        if (possibleToppingsList.getSelectionModel().getSelectedItem() == null || toppingOptions.getValue() == null) {
            return;
        }

        Topping selected = Topping.valueOf(possibleToppingsList.getSelectionModel().getSelectedItem().toString().toUpperCase());
        if (toppingOptions.getValue().toString().equalsIgnoreCase("Build Your Own") && currentToppings.size() <= 7) {
            currentToppings.add(selected);
            offeredToppings.remove(selected);
            setToppings();
            setPrice();
        }
    }

    /**
     * This method is called whenever the user selects a topping in the Toppings ListView in the CHIStyleView and presses
     * the Remove button.
     */
    @FXML
    protected void removeTopping() {
        if (addedToppingsList.getSelectionModel().getSelectedItem() == null  || toppingOptions.getValue() == null) {
            return;
        }

        Topping selected = Topping.valueOf(addedToppingsList.getSelectionModel().getSelectedItem().toString().toUpperCase());
        if (toppingOptions.getValue().toString().equalsIgnoreCase("Build Your Own")) {
            currentToppings.remove(selected);
            offeredToppings.add(selected);
            setToppings();
            setPrice();
        }
    }

    /**
     * This method sets the Total Cost text area to the cost of the selected Chicago Style pizza, based on flavor, size,
     * and toppings.
     */
    @FXML
    protected void setPrice() {
        totalCost.clear();
        if (toppingOptions.getValue().toString().equalsIgnoreCase("Build Your Own")) {
            totalCost.appendText(String.format("%.2f",currentPizza.price() + currentPizza.getToppings().size() * TOPPINGPRICE));
        } else {
            totalCost.appendText(String.format("%.2f",currentPizza.price()));
        }
    }

    /**
     * This method is invoked when the user clicks the Add to Order method. The pizza is added to the Order and
     * an alert is shown to the user with confirmation. This method will do nothing if no pizza is selected to add.
     */
    @FXML
    protected void submitOrder(){
        if (toppingOptions.getValue() != null) {
            pizzaList.add(currentPizza);
            addedToppingsList.getItems().clear();
            toppingOptions.valueProperty().set(null);
            small.setSelected(true);
            crustType.clear();
            totalCost.clear();

            confirmation.setTitle("Pizza Added!");
            confirmation.setContentText("Pizza has been added to current order!\nClick on current orders for more info.");
            confirmation.show();
        }
    }

    /**
     * This method initializes the CHIStyleView whenever it is loaded by the system.
     */
    @FXML
    protected void initialize() {
        currentToppings = new ArrayList<>();
        offeredToppings = FXCollections.observableArrayList();

        resetToppings();

        possibleToppingsList.setItems(offeredToppings);
    }

    /**
     * This is helper method that resets the Topping ListView if the user decides to choose a different flavor.
     */
    protected void resetToppings() {
        offeredToppings.clear();
        currentToppings.clear();
        for (Topping topping : Topping.values()) {
            offeredToppings.add(topping);
        }
    }

    /**
     * This method indicates which size of pizza the user selects.
     * @return the size of the pizza that the user selected as a Size object.
     */
    protected Size findSize() {
        Size pizzaSize =  Size.SMALL;
        if (medium.isSelected()) {
            pizzaSize = Size.MEDIUM;
        } else if (large.isSelected()) {
            pizzaSize = Size.LARGE;
        }
        return pizzaSize;
    }

    /**
     * This method sets the ListView of Toppings based on the Pizza selected by the user.
     */
    protected void setToppings() {
        ObservableList<Topping> list = FXCollections.observableArrayList();

        for (Topping topping : currentPizza.getToppings()) {
            list.add(topping);
        }

        addedToppingsList.setItems(list);
    }

    /**
     * This method sets the ArrayList of pizzas in the current order to the list that will be passed to the CurrentOrderController.
     * @param list is the list of pizzas in the current order.
     */
    public void setPizzaList(ArrayList<Pizza> list) {
        pizzaList = list;
    }

}
