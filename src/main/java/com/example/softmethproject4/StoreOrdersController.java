package com.example.softmethproject4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * This class defines the controller for the StoreOrdersView. This method also defines all elements and attributes
 * of the StoreOrdersView as well as any relevant methods that are invoked by button clicks or other actions by the user
 * on the StoreOrdersView.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class StoreOrdersController {

    private ObservableList<Integer> orderSerialNumbers = FXCollections.observableArrayList();
    private ObservableList<String> currentOrders = FXCollections.observableArrayList();
    private static StoreOrder orders;

    @FXML
    private Button cancelOrder;

    @FXML
    private Button exportOrders;

    @FXML
    private ListView<String> orderDisplay;

    @FXML
    private ComboBox<Integer> orderNumList;

    @FXML
    private TextArea orderTotal;

    /**
     * This method displays an order based on which serial number is selected from the Combo Box by the user. This method is invoked when a user selects a serial number
     * from the Combo Box.
     * @param event is the onClick event of a Combo Box serial number that invokes this method.
     */
    @FXML
    protected void displayCurrentOrder(ActionEvent event) {
        orderTotal.clear();
        orderDisplay.getItems().clear();
        double orderPrice = 0;
        for (int x = 0; x < this.orders.getOrders().size(); x++) {
            if (orderNumList.getSelectionModel().getSelectedIndex() + 1 == this.orders.getOrders().get(x).getSerialNumber()) {
                for (Pizza p: this.orders.getOrders().get(x).getCurrentOrder()) {
                    currentOrders.add(p.toString());
                    orderPrice += p.price();
                }
            }
        }
        orderPrice *= 1.06625;
        orderPrice = Math.round(orderPrice * 100) / 100.0;
        orderDisplay.setItems(currentOrders);
        orderTotal.appendText(String.format("%.2f", orderPrice));
    }

    /**
     * This method cancels the current order selected by the user and displayed on the screen. This method is invoked when the user selects an order to display and then
     * clicks the Cancel Order button.
     * @param event is the onClick event of clicking the Cancel Order button that invokes this method.
     */
    @FXML
    protected void cancelOrder(ActionEvent event) {
        for (int x = 0; x < this.orders.getOrders().size(); x++) {
            if (orderNumList.getSelectionModel().getSelectedIndex() + 1 == this.orders.getOrders().get(x).getSerialNumber()) {
                orderSerialNumbers.remove(this.orders.getOrders().get(x).getSerialNumber() - 1);
                orderNumList.setItems(orderSerialNumbers);
                orders.getOrders().remove(x);
                orderTotal.clear();
                orderDisplay.getItems().clear();
            }
        }
    }

    /**
     * This method exports all orders in StoreOrdersView to an external text file when the Export Orders button is clicked by the user.
     * @param event is the onClick event of clicking the Export Order button that invokes this method.
     */
    @FXML
    protected void exportOrders(ActionEvent event) {
        orders.export();
    }

    public void addOrder(Order order) {
        this.orders.getOrders().add(order);
    }

    /**
     * This method is invoked when the StoreOrdersView is loaded. This method sets the ArrayList of Orders as well as the Combo Box of serial numbers
     * based on the ArrayList passed to the method from the CurrentOrderController.
     * @param list is an ArrayList of Order objects passed from the CurrentOrderController.
     */
    public void setOrdersList(ArrayList<Order> list) {
        if (orders == null) {
            orders = new StoreOrder(list);
        }

        for (Order order: this.orders.getOrders()) {
            if (orderSerialNumbers.contains(order.getSerialNumber()) == false) {
                orderSerialNumbers.add(order.getSerialNumber());
            }
        }
        orderNumList.setItems(orderSerialNumbers);
    }

}