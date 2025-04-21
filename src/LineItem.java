public class LineItem {
    private Product product;
    private int quantity;
    public Product getProduct() {
        return product;
    }
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getUnitPrice() * quantity;
    }

    public String getProductName() {
        return product.getName();
    }

    public int getQuantity() {
        return quantity;
    }

    //print the line item
    @Override
    public String toString() {
        return String.format("%-15s %-5d $%-7.2f $%-7.2f",
                product.getName(), quantity, product.getUnitPrice(), getTotalPrice());
    }

    public double getTotal() {

        getTotalPrice();
        return product.getUnitPrice() * quantity;
    }

    }

