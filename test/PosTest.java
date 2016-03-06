import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PosTest {

    @Test
    public void get_cart_items_should_return_a_cart_item_array() {
        Pos pos = new Pos();
        String[] tags = Fixture.getTags();
        Item[] allItems = Fixture.getAllItems();

        CartItem[] cartItems = pos.getCartItems(tags, allItems);

        CartItem[] expectCartItems = {
                new CartItem("ITEM000001", 5.00, allItems),
                new CartItem("ITEM000003", 2.00, allItems),
                new CartItem("ITEM000005", 3.00, allItems)
        };

        assertThat(cartItems.length, is(expectCartItems.length));
        for (int i = 0; i < cartItems.length; i ++) {
            assertThat(cartItems[i].equals(expectCartItems[i]), is(true));
        }
    }
}
