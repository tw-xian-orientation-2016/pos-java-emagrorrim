import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

        assertThat(cartItems, is(expectCartItems));
    }

    @Test
    public void get_receipt_items_should_return_a_receipt_item_array() {
        Pos pos = new Pos();
        Item[] allItems = Fixture.getAllItems();
        Promotion[] promotions = Fixture.getAllPromotions();
        CartItem[] input = {
                new CartItem("ITEM000001", 5.00, allItems),
                new CartItem("ITEM000003", 2.00, allItems),
                new CartItem("ITEM000005", 3.00, allItems)
        };

        ReceiptItem[] receiptItems = pos.getReceiptItems(input);

        ReceiptItem[] expectReceiptItems = {
                new ReceiptItem(new CartItem("ITEM000001", 5.00, allItems)),
                new ReceiptItem(new CartItem("ITEM000003", 2.00, allItems)),
                new ReceiptItem(new CartItem("ITEM000005", 3.00, allItems))
        };

        assertThat(receiptItems, is(expectReceiptItems));
    }

    @Test
    public void get_receipt_should_return_a_receipt() {
        Pos pos = new Pos();
        Item[] allItems = Fixture.getAllItems();

        ReceiptItem[] receiptItems = {
                new ReceiptItem(new CartItem("ITEM000001", 5.00, allItems)),
                new ReceiptItem(new CartItem("ITEM000003", 2.00, allItems)),
                new ReceiptItem(new CartItem("ITEM000005", 3.00, allItems))
        };

        Receipt receipt = pos.getReceipt(receiptItems);

        Receipt expectReceipt = new Receipt(receiptItems);

        assertThat(receipt, is(expectReceipt));
    }

    @Test
    public void print_receipt_should_print_receipt_string() {

        Pos pos = mock(Pos.class);

        String receiptText = "***<没钱赚商店>收据***\n" +
                "名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)\n" +
                "名称：荔枝，数量：2斤，单价：15.00(元)，小计：30.00(元)\n" +
                "名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)\n" +
                "----------------------\n" +
                "总计：51.00(元)\n" +
                "节省：7.50(元)\n" +
                "**********************";

        pos.printReceipt(receiptText);

        verify(pos).printReceipt(receiptText);
    }
}
