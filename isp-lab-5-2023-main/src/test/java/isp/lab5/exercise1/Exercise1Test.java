package isp.lab5.exercise1;

import org.junit.Test;

import java.util.Arrays;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * @author Radu Miron
 * @version 1
 */
public class Exercise1Test {
    @Test
    public void testToString() {
        Product product = new Product("8945", "Laptop", 999.99, ProductCategory.ELECTRONICS);

        String expected = "Product{" +
                "productId='8945', " +
                "name='Laptop', " +
                "price=999.99, " +
                "productCategory=Electronics & Gadgets" +
                '}';
        String actual= product.toString();
        assertEquals(expected, actual);
    }
    }


