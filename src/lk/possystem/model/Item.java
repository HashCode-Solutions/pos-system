package lk.possystem.model;

/**
 * @author Sandun Sampath
 * @since - 10/9/2021 | 2021-October-09[Saturday]
 */
public class Item {
    private String itemId;
    private String description;
    private double price;
    private int qtyOnHand;

    public Item() {
    }

    public Item(String itemId, String description, double price, int qtyOnHand) {
        this.itemId = itemId;
        this.description = description;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
}
