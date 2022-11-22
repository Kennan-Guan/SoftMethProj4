package com.example.softmethproject4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class defines the Controller for the MainView, as well as all elements and attributes of the MainView and also the methods
 * that are invoked based on user inputted Action Events in the MainView.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class MainController {
    private ArrayList<Pizza> currentOrderPizzas;

    private ArrayList<Order> ordersList;

    @FXML
    private Button chicagoStyle;

    @FXML
    private Button newYorkStyle;

    @FXML
    private Button storeOrders;

    @FXML
    private Button currentOrder;

    /**
     * This method loads the CHIStyleView when the user clicks on the Chicago Style button in the MainView.
     * @throws IOException if the CHIStyleView.fxml file does not exist.
     */
    @FXML
    protected void onChicagoClick() throws IOException {
        if (currentOrderPizzas == null) {
            currentOrderPizzas = new ArrayList<>();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CHIStyleView.fxml"));
        Parent root = loader.load();

        CHIStyleController chiStyleController = loader.getController();
        chiStyleController.setPizzaList(currentOrderPizzas);

        Stage stage = new Stage();
        stage.setTitle("Chicago Style Pizza");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();

    }

    /**
     * This method loads the NYStyleView when the user clicks on the New York Style button in the MainView.
     * @throws IOException if the NYStyleView.fxml file does not exist.
     */
    @FXML
    protected void onNewYorkClick() throws IOException {
        if (currentOrderPizzas == null) {
            currentOrderPizzas = new ArrayList<>();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("NYStyleView.fxml"));
        Parent root = loader.load();

        NYStyleController nyStyleController = loader.getController();
        nyStyleController.setPizzaList(currentOrderPizzas);

        Stage stage = new Stage();
        stage.setTitle("New York Style Pizza");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();

    }

    /**
     * This method loads the StoreOrdersView when the user clicks on the Store Orders button in the MainView.
     * @throws IOException if the StoreOrdersView.fxml file does not exist.
     */
    @FXML
    protected void onStoreOrdersClick() throws IOException {
        if (ordersList == null) {
            ordersList = new ArrayList<>();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
        Parent root = loader.load();

        StoreOrdersController storeOrdersController = loader.getController();
        storeOrdersController.setOrdersList(ordersList);

        Stage stage = new Stage();
        stage.setTitle("Store Orders");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();

    }

    /**
     * This method loads the CurrentOrderView when the user clicks on the Current Order button in the MainView.
     * @throws IOException if the CurrentOrderView.fxml file does not exist.
     */
    @FXML
    protected void onCurrentOrderClick() throws IOException {
        if (currentOrderPizzas == null) {
            currentOrderPizzas = new ArrayList<>();
        }
        if (ordersList == null) {
            ordersList = new ArrayList<>();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
        Parent root = loader.load();

        CurrentOrderController currentOrderController = loader.getController();
        currentOrderController.setCurrentOrder(currentOrderPizzas);
        currentOrderController.setOrderList(ordersList);

        Stage stage = new Stage();
        stage.setTitle("Current Order");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();

    }
}