package com.example.softmethproject4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is a JUnit Test for the BuildYourOwn Class.
 * This class will test the price() method of the BuildYourOwn Class.
 */
class BuildYourOwnTest {

    /**
     * This test method will test the price() method of a BuildYourOwn Pizza object with 0 toppings added.
     * This method will test both Chicago Style and New York Style pizzas, and for each style this method
     * will also test the price() method for a small, medium, and large pizza with 0 toppings.
     */
    @Test
    public void test_BuildYourOwnPizza_0_toppings() {
        Pizza p = new BuildYourOwn(new ArrayList<Topping>(), Crust.PAN, Size.SMALL);
        double expectedOutput = 8.99;
        double actualOutput = p.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p1 = new BuildYourOwn(new ArrayList<Topping>(), Crust.PAN, Size.MEDIUM);
        expectedOutput = 10.99;
        actualOutput = p1.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p2 = new BuildYourOwn(new ArrayList<Topping>(), Crust.PAN, Size.LARGE);
        expectedOutput = 12.99;
        actualOutput = p2.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p3 = new BuildYourOwn(new ArrayList<Topping>(), Crust.HANDTOSSED, Size.SMALL);
        expectedOutput = 8.99;
        actualOutput = p3.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p4 = new BuildYourOwn(new ArrayList<Topping>(), Crust.HANDTOSSED, Size.MEDIUM);
        expectedOutput = 10.99;
        actualOutput = p4.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p5 = new BuildYourOwn(new ArrayList<Topping>(), Crust.HANDTOSSED, Size.LARGE);
        expectedOutput = 12.99;
        actualOutput = p5.price();
        assertEquals(expectedOutput, actualOutput, 0);
    }

    /**
     * This test method will test the price() method of a BuildYourOwn Pizza object with 1 toppings added.
     * This method will test both Chicago Style and New York Style pizzas, and for each style this method
     * will also test the price() method for a small, medium, and large pizza with 1 toppings.
     */
    @Test
    public void test_BuildYourOwnPizza_1_toppings() {
        Pizza p = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN)), Crust.PAN, Size.SMALL);
        double expectedOutput = 10.58;
        double actualOutput = p.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p1 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN)), Crust.PAN, Size.MEDIUM);
        expectedOutput = 12.58;
        actualOutput = p1.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p2 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN)), Crust.PAN, Size.LARGE);
        expectedOutput = 14.58;
        actualOutput = p2.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p3 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN)), Crust.HANDTOSSED, Size.SMALL);
        expectedOutput = 10.58;
        actualOutput = p3.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p4 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN)), Crust.HANDTOSSED, Size.MEDIUM);
        expectedOutput = 12.58;
        actualOutput = p4.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p5 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN)), Crust.HANDTOSSED, Size.LARGE);
        expectedOutput = 14.58;
        actualOutput = p5.price();
        assertEquals(expectedOutput, actualOutput, 0);
    }

    /**
     * This test method will test the price() method of a BuildYourOwn Pizza object with 2 toppings added.
     * This method will test both Chicago Style and New York Style pizzas, and for each style this method
     * will also test the price() method for a small, medium, and large pizza with 2 toppings.
     */
    @Test
    public void test_BuildYourOwnPizza_2_toppings() {
        Pizza p = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR)), Crust.PAN, Size.SMALL);
        double expectedOutput = 12.17;
        double actualOutput = p.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p1 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR)), Crust.PAN, Size.MEDIUM);
        expectedOutput = 14.17;
        actualOutput = p1.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p2 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR)), Crust.PAN, Size.LARGE);
        expectedOutput = 16.17;
        actualOutput = p2.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p3 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR)), Crust.HANDTOSSED, Size.SMALL);
        expectedOutput = 12.17;
        actualOutput = p3.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p4 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR)), Crust.HANDTOSSED, Size.MEDIUM);
        expectedOutput = 14.17;
        actualOutput = p4.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p5 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR)), Crust.HANDTOSSED, Size.LARGE);
        expectedOutput = 16.17;
        actualOutput = p5.price();
        assertEquals(expectedOutput, actualOutput, 0);
    }

    /**
     * This test method will test the price() method of a BuildYourOwn Pizza object with 3 toppings added.
     * This method will test both Chicago Style and New York Style pizzas, and for each style this method
     * will also test the price() method for a small, medium, and large pizza with 3 toppings.
     */
    @Test
    public void test_BuildYourOwnPizza_3_toppings() {
        Pizza p = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE)), Crust.PAN, Size.SMALL);
        double expectedOutput = 13.76;
        double actualOutput = p.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p1 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE)), Crust.PAN, Size.MEDIUM);
        expectedOutput = 15.76;
        actualOutput = p1.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p2 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE)), Crust.PAN, Size.LARGE);
        expectedOutput = 17.76;
        actualOutput = p2.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p3 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE)), Crust.HANDTOSSED, Size.SMALL);
        expectedOutput = 13.76;
        actualOutput = p3.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p4 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE)), Crust.HANDTOSSED, Size.MEDIUM);
        expectedOutput = 15.76;
        actualOutput = p4.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p5 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE)), Crust.HANDTOSSED, Size.LARGE);
        expectedOutput = 17.76;
        actualOutput = p5.price();
        assertEquals(expectedOutput, actualOutput, 0);
    }

    /**
     * This test method will test the price() method of a BuildYourOwn Pizza object with 4 toppings added.
     * This method will test both Chicago Style and New York Style pizzas, and for each style this method
     * will also test the price() method for a small, medium, and large pizza with 4 toppings.
     */
    @Test
    public void test_BuildYourOwnPizza_4_toppings() {
        Pizza p = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI)), Crust.PAN, Size.SMALL);
        double expectedOutput = 15.35;
        double actualOutput = p.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p1 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI)), Crust.PAN, Size.MEDIUM);
        expectedOutput = 17.35;
        actualOutput = p1.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p2 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI)), Crust.PAN, Size.LARGE);
        expectedOutput = 19.35;
        actualOutput = p2.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p3 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI)), Crust.HANDTOSSED, Size.SMALL);
        expectedOutput = 15.35;
        actualOutput = p3.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p4 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI)), Crust.HANDTOSSED, Size.MEDIUM);
        expectedOutput = 17.35;
        actualOutput = p4.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p5 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI)), Crust.HANDTOSSED, Size.LARGE);
        expectedOutput = 19.35;
        actualOutput = p5.price();
        assertEquals(expectedOutput, actualOutput, 0);
    }

    /**
     * This test method will test the price() method of a BuildYourOwn Pizza object with 5 toppings added.
     * This method will test both Chicago Style and New York Style pizzas, and for each style this method
     * will also test the price() method for a small, medium, and large pizza with 5 toppings.
     */
    @Test
    public void test_BuildYourOwnPizza_5_toppings() {
        Pizza p = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER)), Crust.PAN, Size.SMALL);
        double expectedOutput = 16.94;
        double actualOutput = p.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p1 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER)), Crust.PAN, Size.MEDIUM);
        expectedOutput = 18.94;
        actualOutput = p1.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p2 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER)), Crust.PAN, Size.LARGE);
        expectedOutput = 20.94;
        actualOutput = p2.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p3 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER)), Crust.HANDTOSSED, Size.SMALL);
        expectedOutput = 16.94;
        actualOutput = p3.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p4 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER)), Crust.HANDTOSSED, Size.MEDIUM);
        expectedOutput = 18.94;
        actualOutput = p4.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p5 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER)), Crust.HANDTOSSED, Size.LARGE);
        expectedOutput = 20.94;
        actualOutput = p5.price();
        assertEquals(expectedOutput, actualOutput, 0);
    }

    /**
     * This test method will test the price() method of a BuildYourOwn Pizza object with 5 toppings added.
     * This method will test both Chicago Style and New York Style pizzas, and for each style this method
     * will also test the price() method for a small, medium, and large pizza with 5 toppings.
     */
    @Test
    public void test_BuildYourOwnPizza_6_toppings() {
        Pizza p = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM)), Crust.PAN, Size.SMALL);
        double expectedOutput = 18.53;
        double actualOutput = p.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p1 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM)), Crust.PAN, Size.MEDIUM);
        expectedOutput = 20.53;
        actualOutput = p1.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p2 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM)), Crust.PAN, Size.LARGE);
        expectedOutput = 22.53;
        actualOutput = p2.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p3 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM)), Crust.HANDTOSSED, Size.SMALL);
        expectedOutput = 18.53;
        actualOutput = p3.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p4 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM)), Crust.HANDTOSSED, Size.MEDIUM);
        expectedOutput = 20.53;
        actualOutput = p4.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p5 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM)), Crust.HANDTOSSED, Size.LARGE);
        expectedOutput = 22.53;
        actualOutput = p5.price();
        assertEquals(expectedOutput, actualOutput, 0);
    }

    /**
     * This test method will test the price() method of a BuildYourOwn Pizza object with 7 toppings added.
     * This method will test both Chicago Style and New York Style pizzas, and for each style this method
     * will also test the price() method for a small, medium, and large pizza with 7 toppings.
     */
    @Test
    public void test_BuildYourOwnPizza_7_toppings() {
        Pizza p = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM, Topping.MUSHROOM)), Crust.PAN, Size.SMALL);
        double expectedOutput = 20.12;
        double actualOutput = p.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p1 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM, Topping.MUSHROOM)), Crust.PAN, Size.MEDIUM);
        expectedOutput = 22.12;
        actualOutput = p1.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p2 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM, Topping.MUSHROOM)), Crust.PAN, Size.LARGE);
        expectedOutput = 24.12;
        actualOutput = p2.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p3 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM, Topping.MUSHROOM)), Crust.HANDTOSSED, Size.SMALL);
        expectedOutput = 20.12;
        actualOutput = p3.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p4 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM, Topping.MUSHROOM)), Crust.HANDTOSSED, Size.MEDIUM);
        expectedOutput = 22.12;
        actualOutput = p4.price();
        assertEquals(expectedOutput, actualOutput, 0);

        Pizza p5 = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.CHEDDAR, Topping.PINEAPPLE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.HAM, Topping.MUSHROOM)), Crust.HANDTOSSED, Size.LARGE);
        expectedOutput = 24.12;
        actualOutput = p5.price();
        assertEquals(expectedOutput, actualOutput, 0);
    }
}