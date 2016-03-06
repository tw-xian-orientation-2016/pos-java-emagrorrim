import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CartItemTest {

    @Test
    public void testEquals() {
        Item[] allItems = Fixture.getAllItems();
        CartItem cartItem1 = new CartItem("ITEM000001", 5.00, allItems);
        CartItem cartItem2 = new CartItem("ITEM000001", 5.00, allItems);

        assertThat(cartItem1.equals(cartItem2), is(true));
    }

    @Test
    public void testUnEquals() {
        Item[] allItems = Fixture.getAllItems();
        CartItem cartItem1 = new CartItem("ITEM000001", 5.00, allItems);
        CartItem cartItem2 = new CartItem("ITEM000003", 3.00, allItems);

        assertThat(cartItem1.equals(cartItem2), is(false));
    }


}