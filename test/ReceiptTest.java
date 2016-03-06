import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReceiptTest {
    private Receipt receipt;
    private Promotion[] promotions;

    @Before
    public void setUp() {
        promotions = Fixture.getAllPromotions();

        Item[] allItems = Fixture.getAllItems();

        ReceiptItem[] receiptItems = {
                    new ReceiptItem(new CartItem("ITEM000001", 5.00, allItems)),
                    new ReceiptItem(new CartItem("ITEM000003", 2.00, allItems)),
                    new ReceiptItem(new CartItem("ITEM000005", 3.00, allItems))
        };

        receipt = new Receipt(receiptItems);

    }

    @Test
    public void testGetAmount() {

        double amount = receipt.getAmount(promotions);

        assertThat(amount, is(51.00));
    }

    @Test
    public void testGetReduced() {

        double reduced = receipt.getReduced(promotions);

        assertThat(reduced, is(7.5));
    }

    @Test
    public void testGetReceiptText() {

        String receiptText = receipt.getReceiptText(promotions);

        String expectText =
                "***<没钱赚商店>收据***\n" +
                        "名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)\n" +
                        "名称：荔枝，数量：2斤，单价：15.00(元)，小计：30.00(元)\n" +
                        "名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)\n" +
                        "----------------------\n" +
                        "总计：51.00(元)\n" +
                        "节省：7.50(元)\n" +
                        "**********************";

        assertThat(receiptText, is(expectText));
    }

    @Test
    public void testEquals() {

        Item[] allItems = Fixture.getAllItems();
        ReceiptItem[] receiptItems = {
                new ReceiptItem(new CartItem("ITEM000001", 5.00, allItems)),
                new ReceiptItem(new CartItem("ITEM000003", 2.00, allItems)),
                new ReceiptItem(new CartItem("ITEM000005", 3.00, allItems))
        };

        Receipt receipt2 = new Receipt(receiptItems);
        assertThat(receipt.equals(receipt2), is(true));
    }

    @Test
    public void testUnEquals() {

        Item[] allItems = Fixture.getAllItems();
        ReceiptItem[] receiptItems = {
                new ReceiptItem(new CartItem("ITEM000001", 5.00, allItems)),
                new ReceiptItem(new CartItem("ITEM000002", 3.00, allItems)),
                new ReceiptItem(new CartItem("ITEM000005", 3.00, allItems))
        };

        Receipt receipt2 = new Receipt(receiptItems);
        assertThat(receipt.equals(receipt2), is(false));
    }
}