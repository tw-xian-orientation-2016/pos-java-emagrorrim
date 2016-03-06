import java.text.DecimalFormat;
import java.util.Arrays;

public class Receipt {
    private ReceiptItem[] receiptItems;

    public ReceiptItem[] getReceiptItems() {
        return receiptItems;
    }

    public Receipt(ReceiptItem[] receiptItems) {
        this.receiptItems = receiptItems;
    }

    public double getAmount(Promotion[] promotions) {

        double amount = 0.0;

        for (ReceiptItem receiptItem : receiptItems) {
            amount += receiptItem.getTotal(promotions);
        }

        return amount;
    }

    public double getReduced(Promotion[] promotions) {

        double reduced = 0.0;

        for (ReceiptItem receiptItem: receiptItems) {
            reduced += receiptItem.getReduced(promotions);
        }

        return reduced;
    }

    public String getReceiptText(Promotion[] allPromotions) {
        String receiptText = "***<没钱赚商店>收据***\n";

        for (ReceiptItem receiptItem : getReceiptItems()) {
            receiptText = receiptText +
                    "名称：" + receiptItem.getName() + "，" +
                    "数量：" + formatCount(receiptItem.getCount()) + receiptItem.getUnit() + "，" +
                    "单价：" + formatPrice(receiptItem.getPrice()) + "(元)，" +
                    "小计：" + formatPrice(receiptItem.getTotal(allPromotions)) + "(元)\n";
        }

        receiptText += "----------------------\n";
        receiptText = receiptText +
                "总计：" + formatPrice(getAmount(allPromotions)) + "(元)\n" +
                "节省：" + formatPrice(getReduced(allPromotions)) + "(元)\n" +
                "**********************";

        return receiptText;
    }

    private String formatPrice(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        return decimalFormat.format(d);
    }
    private String formatCount(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0.##");

        return decimalFormat.format(d);
    }

    public boolean equals(Object object) {

        Receipt receipt = (Receipt)object;

        return Arrays.equals(receipt.receiptItems, receiptItems);
    }
}
