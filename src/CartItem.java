public class CartItem {
    private Item item;
    public double count;

    public CartItem(String barcode, double count, Item[] allItems) {
        this.item = findItem(barcode, allItems);
        this.count = count;
    }

    private Item findItem(String barcode,Item[] allItems) {

        for (int i = 0; i < allItems.length; i++) {
            if (barcode.equals(allItems[i].barcode)) {
                return allItems[i];
            }
        }
        return null;
    }

    public String getBarcode() {
        return item.barcode;
    }

    public double getPrice() {
        return item.price;
    }

    public double getCount() {
        return count;
    }

    public String getName() {
        return item.name;
    }

    public String getUnit() {
        return item.unit;
    }

    public boolean equals(Object object) {
        CartItem cartItem = (CartItem) object;
        return item.equals(cartItem.item) && count == cartItem.count;
    }
}
