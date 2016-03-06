import java.util.Objects;

public class Item {
    public String barcode;
    public String name;
    public String unit;
    public double price;

    public Item(String barcode, String name, String unit, double price) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public boolean equals(Object object) {

        Item item = (Item) object;

        if (!barcode.equals(item.barcode)) {
            return false;
        }
        if (!name.equals(item.name)) {
            return false;
        }
        if (!unit.equals(item.unit)) {
            return false;
        }
        return price == item.price;
    }
}
