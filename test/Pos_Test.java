import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Pos_Test {

    @Test
    public void get_cart_items_should_return_a_cart_item_array() {
        Pos pos = new Pos();
        String[] tags = Fixture.getTags();
        Item[] allItems = Fixture.getAllItems();

//        CartItems[] cartItems = pos.getCartItems(tags, allItems);

//        CartItems[] expectCartItems = {};
//        assertThat(cartItems, is(expectCartItems));
    }
}
