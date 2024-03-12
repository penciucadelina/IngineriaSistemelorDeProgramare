
package isp.lab3.exercise5;

import isp.lab3.exercise1.Tree;
import isp.lab3.exercise5.VendingMachine;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class VendingMachineTest {


    /* @Test
     public void testDisplayProducts() {
         VendingMachine vendingMachine = new VendingMachine();
         String[] expected = "Cola Chips Chocolate Pepsi";
         assertEquals();
     }
 */
    @Test
    public void testInsertCoin() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.insertCoin(5);

        Assert.assertEquals(5, vendingMachine.getCredit());

        vendingMachine.insertCoin(2);

        Assert.assertEquals(7, vendingMachine.getCredit());


    }

    @Test
    public void testSelectProduct() {

        VendingMachine vendingMachine = new VendingMachine();

        String expected1 = "Insufficient credit, insert coins.";
        String actual1 = vendingMachine.selectProduct(1);
        assertEquals(expected1, actual1);


        vendingMachine.insertCoin(3);
        String expected2 = "Dispensing Cola";
        String actual2 = vendingMachine.selectProduct(1);
        assertEquals(expected2, actual2);


        String expected3 = "Invalid product selection.";
        String actual3 = vendingMachine.selectProduct(0);
        assertEquals(expected3, actual3);
    }
}