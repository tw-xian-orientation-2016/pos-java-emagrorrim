import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReceiptItemTest {
    ReceiptItem receiptItem;
    Promotion[] promotions;

    @Before
    public void setUp() {
        promotions = Fixture.getAllPromotions();

        Item[] allItems = Fixture.getAllItems();
        CartItem cartItem = new CartItem("ITEM000001", 5.00, allItems);
        receiptItem = new ReceiptItem(cartItem);
    }

    @Test
    public void testGetTotal() {

        assertThat(receiptItem.getTotal(promotions), is(12.0));
    }

    @Test
    public void testGetReduced() {

        assertThat(receiptItem.getReduced(promotions), is(3.0));
    }

    @Test
    public void testEquals() {
        Item[] allItems = Fixture.getAllItems();
        CartItem cartItem = new CartItem("ITEM000001", 5.00, allItems);
        ReceiptItem receiptItem2 = new ReceiptItem(cartItem);

        assertThat(receiptItem.equals(receiptItem2), is(true));
    }

    @Test
    public void testUnEquals() {
        Item[] allItems = Fixture.getAllItems();
        CartItem cartItem = new CartItem("ITEM000001", 2.00, allItems);
        ReceiptItem receiptItem2 = new ReceiptItem(cartItem);

        assertThat(receiptItem.equals(receiptItem2), is(false));
    }
}