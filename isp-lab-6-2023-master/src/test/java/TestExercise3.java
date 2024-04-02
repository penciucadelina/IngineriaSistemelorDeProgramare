package isp.lab6.exercise3;
import static org.junit.Assert.*;
import org.junit.*;

import java.util.Map;


public class TestExercise3 {

    private LoginSystem loginSystem;
    private OnlineStore store;
    private UserInterface userInterface;

    @Before
    public void setUp() {
        store = new OnlineStore();
        loginSystem = new LoginSystem(store);
        userInterface = new UserInterface(loginSystem, store);
    }

    @Test
    public void testRegister() {
        loginSystem.register("user1", "password1");
        assertTrue(loginSystem.login("user1", "password1"));
    }

    @Test
    public void testLoginLogout() {
        loginSystem.register("user2", "password2");
        assertTrue(loginSystem.login("user2", "password2"));
        assertTrue(loginSystem.logout("user2"));
    }

    @Test
    public void testAddToCart() {
        loginSystem.register("user3", "password3");
        userInterface.addToCart("user3", new Product("Laptop", 999.99), 2);
        Map<Product, Integer> shoppingCart = loginSystem.getSessions().get("user3").getShoppingCart();
        assertEquals(1, shoppingCart.size());
        assertEquals(2, (int) shoppingCart.get(new Product("Laptop", 999.99)));
    }

    @Test
    public void testCheckout() {
        loginSystem.register("user4", "password4");
        userInterface.addToCart("user4", new Product("Smartphone", 599.99), 1);
        String result = userInterface.checkout("user4");
        assertEquals("Checkout successful!", result);
    }

    @Test
    public void testCheckoutWhenNotLoggedIn() {
        loginSystem.register("user5", "password5");
        String result = userInterface.checkout("user5");
        assertEquals("User not logged in!", result);
    }

}
