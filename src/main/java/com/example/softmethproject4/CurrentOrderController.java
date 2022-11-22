package com.example.softmethproject4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * This class defines the controller for the CurrentOrderView. This method also defines all elements and attributes
 * of the CurrentOrderView as well as any relevant methods that are invoked by button clicks or other actions by the user
 * on the CurrentOrderView.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class CurrentOrderController {

    private Order currentOrder;
    private double subPrice;
    private double orderTotal;
    private double salesTax;

    private ObservableList<String> currentPizzas = FXCollections.observableArrayList();

    private Alert noPizzas = new Alert(AlertType.WARNING);

    private ArrayList<Order> allOrders;

    private ArrayList<Pizza> allPizzas;

    @FXML
    private Button clearOrderButton;

    @FXML
    private ListView<String> orderDisplay;

    @FXML
    private TextArea orderNumDisplay;

    @FXML
    private TextArea orderTotalTextArea;

    @FXML
    private Button placeOrderButton;

    @FXML
    private Button removePizzaButton;

    @FXML
    private TextArea salesTaxTextArea;

    @FXML
    private TextArea subtotalTextArea;

    /**
     * This method removes a Pizza from the current order when the user selects a pizza from the order ListView and then
     * selects the Remove button.
     * @param event is the onClick event of the Remove button that invokes this method.
     */
    @FXML
    protected void removePizza(ActionEvent event) {
        if (!orderDisplay.getSelectionModel().isEmpty()) {
            int index = orderDisplay.getSelectionModel().getSelectedIndex();
            subPrice -= this.currentOrder.getCurrentOrder().get(index).price();
            salesTax = subPrice * 0.06625;
            orderTotal = subPrice * 1.06625;
            salesTax = Math.round(salesTax * 100) / 100.0;
            orderTotal = Math.round(orderTotal * 100) / 100.0;
            subtotalTextArea.clear();
            orderTotalTextArea.clear();
            salesTaxTextArea.clear();
            subtotalTextArea.appendText(String.format("%.2f", subPrice));
            orderTotalTextArea.appendText(String.format("%.2f", orderTotal));
            salesTaxTextArea.appendText(String.format("%.2f", salesTax));

            currentPizzas.remove(index);
            currentOrder.getCurrentOrder().remove(index);
            allPizzas.remove(index);
            orderDisplay.setItems(currentPizzas);
        }
    }

    /**
     * This method places the current order of pizzas. This method is invoked when the user is satisfied with their order
     * and selects the Place Order button on the CurrentOrderView.
     * @param event is the onClick event of the Place Order button that invokes this method.
     */
    @FXML
    protected void placeOrder(ActionEvent event) {
        if (this.currentOrder.getCurrentOrder().isEmpty()) {
            noPizzas.setTitle("WARNING");
            noPizzas.setContentText("Order is empty!");
            noPizzas.show();
            return;
        }
        allOrders.add(this.currentOrder);
        this.currentOrder.updateOrderCount();
        orderNumDisplay.clear();
        subtotalTextArea.clear();
        orderTotalTextArea.clear();
        salesTaxTextArea.clear();
        currentPizzas.clear();
        orderDisplay.getItems().clear();
        allPizzas.clear();
    }

    /**
     * This method clears the Order of pizzas from the current order when the user clicks the Clear
     * Order button. The ListView is cleared and the order price is back to zero.
     */
    @FXML
    protected void clearOrder() {
        currentOrder.clearOrder();
        allPizzas.clear();
        orderNumDisplay.clear();
        subtotalTextArea.clear();
        orderTotalTextArea.clear();
        salesTaxTextArea.clear();
        currentPizzas.clear();
        orderDisplay.getItems().clear();
    }

    /**
     * This method sets the current order based on an ArrayList of pizzas passed from the MainViewController. The ListView of
     * pizzas is initialized based on this new ArrayList.
     * @param pizzas is the ArrayList of pizzas in the current order that is passed from the MainViewController.
     */
    public void setCurrentOrder(ArrayList<Pizza> pizzas) {
        allPizzas = pizzas;
        currentOrder = new Order();
        for (Pizza piz: pizzas) {
            currentOrder.getCurrentOrder().add(piz);
        }
        orderNumDisplay.appendText(String.valueOf(this.currentOrder.getSerialNumber()));
        subPrice = 0;
        for (Pizza p: currentOrder.getCurrentOrder()) {
            subPrice += p.price();
            currentPizzas.add(p.toString());
        }
        orderDisplay.setItems(currentPizzas);
        orderTotal = subPrice * 1.06625;
        salesTax = subPrice * 0.06625;
        salesTax = Math.round(salesTax * 100) / 100.0;
        orderTotal = Math.round(orderTotal * 100) / 100.0;

        subtotalTextArea.appendText(String.format("%.2f", subPrice));
        orderTotalTextArea.appendText(String.format("%.2f", orderTotal));
        salesTaxTextArea.appendText(String.format("%.2f", salesTax));
    }

    /**
     * This method sets the ArrayList of all Orders that will be passed to the StoreOrderController.
     * @param list is the list of all Orders that will be passed to the StoreOrderController.
     */
    public void setOrderList(ArrayList<Order> list) {
        allOrders = list;
    }

    /**
     * This method initializes the CurrentOrderControllerView when it is loaded by the system.
     */
    @FXML
    void initialize() {
        assert clearOrderButton != null : "fx:id=\"clearOrderButton\" was not injected: check your FXML file 'CurrentOrderView.fxml'.";
        assert orderDisplay != null : "fx:id=\"orderDisplay\" was not injected: check your FXML file 'CurrentOrderView.fxml'.";
        assert orderNumDisplay != null : "fx:id=\"orderNumDisplay\" was not injected: check your FXML file 'CurrentOrderView.fxml'.";
        assert orderTotalTextArea != null : "fx:id=\"orderTotalTextArea\" was not injected: check your FXML file 'CurrentOrderView.fxml'.";
        assert placeOrderButton != null : "fx:id=\"placeOrderButton\" was not injected: check your FXML file 'CurrentOrderView.fxml'.";
        assert removePizzaButton != null : "fx:id=\"removePizzaButton\" was not injected: check your FXML file 'CurrentOrderView.fxml'.";
        assert salesTaxTextArea != null : "fx:id=\"salesTaxTextArea\" was not injected: check your FXML file 'CurrentOrderView.fxml'.";
        assert subtotalTextArea != null : "fx:id=\"subtotalTextArea\" was not injected: check your FXML file 'CurrentOrderView.fxml'.";
    }
}