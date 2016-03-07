import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testEquals() {
        Item item1 = new Item("ITEM000000", "可口可乐", "瓶", 3.00);
        Item item2 = new Item("ITEM000000", "可口可乐", "瓶", 3.00);

        assertThat(item1.equals(item2), is(true));
    }

    @Test
    public void testUnEquals() {
        Item item1 = new Item("ITEM000000", "可口可乐", "瓶", 3.00);
        Item item2 = new Item("ITEM000001", "雪碧", "瓶", 3.00);

        assertThat(item1.equals(item2), is(false));
    }
}