import java.util.ArrayList;

public class Pos {

    public CartItem[] getCartItems(String[] tags, Item[] allItems) {

        ArrayList<CartItem> cartItems = new ArrayList<>();

        for (int i = 0; i < tags.length; i++) {
            String[] tagComponents = tags[i].split("-");
            String barcode = tagComponents[0];
            double count = tagComponents.length > 1 ? Double.parseDouble(tagComponents[1]) : 1;

            CartItem cartItem = findCartItem(barcode, cartItems);
            if (cartItem != null) {
                cartItem.count += count;
            } else {
                cartItems.add(new CartItem(barcode, count, allItems));
            }
        }

        return cartItems.toArray(new  CartItem[cartItems.size()]);
    }


    private CartItem findCartItem(String barcode, ArrayList<CartItem> cartItems) {

        for (int i = 0; i < cartItems.size(); i++) {
            CartItem cartItem = cartItems.get(i);
            if (barcode.equals(cartItem.getBarcode())) {
                return cartItem;
            }
        }

        return null;
    }

    public ReceiptItem[] getReceiptItems(CartItem[] cartItems) {

        ArrayList<ReceiptItem> receiptItems = new ArrayList<>();

        for (int i = 0; i < cartItems.length; i++) {

            ReceiptItem receiptItem = new ReceiptItem(cartItems[i]);
            receiptItems .add(receiptItem);
        }

        return receiptItems.toArray(new ReceiptItem[receiptItems.size()]);
    }

    public Receipt getReceipt(ReceiptItem[] receiptItems) {
        return new Receipt(receiptItems);
    }


    public void printReceipt(String receiptText) {

        System.out.println(receiptText);
    }


}
