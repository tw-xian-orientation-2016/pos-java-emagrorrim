import java.util.Objects;

public class ReceiptItem {
    private CartItem cartItem;

    public ReceiptItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }



    private String getTypeOfPromotions(String barcode, Promotion[] promotions) {

        for (int i = 0; i < promotions.length; i++) {
            String[] barcodes = promotions[i].barcodes;

            for (int j = 0; j < barcodes.length; j++) {
                if (barcodes[j].equals(barcode)) {
                    return promotions[i].type;
                }
            }
        }

        return "";
    }

    private double calculateReduced(String type) {

        if (type.equals("BUY_TWO_GET_ONE_FREE")) {
            return (int)(cartItem.getCount() / 3) * cartItem.getPrice();
        }

        return 0;
    }

    public boolean equals(Object object) {
        ReceiptItem receiptItem = (ReceiptItem) object;
        return cartItem.equals(receiptItem.cartItem);
    }

    public String getName() {
        return cartItem.getName();
    }

    public double getCount() {
        return cartItem.getCount();
    }

    public String getUnit() {
        return cartItem.getUnit();
    }

    public double getPrice() {
        return cartItem.getPrice();
    }

    public double getTotal(Promotion[] promotions) {

        return cartItem.getCount() * cartItem.getPrice() - getReduced(promotions);
    }

    public double getReduced(Promotion[] promotions)  {

        String type = getTypeOfPromotions(cartItem.getBarcode(), promotions);

        return calculateReduced(type);
    }

}
