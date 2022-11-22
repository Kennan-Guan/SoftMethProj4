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

        if (orderNumList.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        double orderPrice = 0;
        for (int i = 0; i < orders.getOrders().size(); i++) {
            if (orders.getOrders().get(i).getSerialNumber() == orderNumList.getSelectionModel().getSelectedItem().intValue()) {
                for (Pizza p : orders.getOrders().get(i).getCurrentOrder()) {
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
        if (orderNumList.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        for (int x = 0; x < this.orders.getOrders().size(); x++) {
            if (orderNumList.getSelectionModel().getSelectedItem().intValue() == this.orders.getOrders().get(x).getSerialNumber()) {
                for (int i = 0; i < orderSerialNumbers.size(); i++) {
                    if (orderSerialNumbers.get(i) == orderNumList.getSelectionModel().getSelectedItem().intValue()) {
                        orderSerialNumbers.remove(i);
                    }
                }
                orderTotal.clear();
                orders.getOrders().remove(x);
                setOrdersList(orders.getOrders());
                return;
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

    /**
     * This method is invoked when the StoreOrdersView is loaded. This method sets the ArrayList of Orders.
     * @param list is an ArrayList of Order objects passed from the CurrentOrderController.
     */
    public void setOrdersList(ArrayList<Order> list) {
        orders = new StoreOrder(list);
        updateOrderList();
    }

    /**
     * This is a helper method to update the list of serial numbers used in the ComboBox.
     */
    public void updateOrderList() {
        for (Order order: this.orders.getOrders()) {
            if (orderSerialNumbers.contains(order.getSerialNumber()) == false) {
                orderSerialNumbers.add(order.getSerialNumber());
            }
        }
        orderNumList.setItems(orderSerialNumbers);
    }

}