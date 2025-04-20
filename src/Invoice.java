import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String customerName;
    private String invoiceNumber;
    private List<LineItem> lineItems;

    public Invoice(String customerName, String invoiceNumber) {
        this.customerName = customerName;
        this.invoiceNumber = invoiceNumber;
        this.lineItems = new ArrayList<>();

    }
    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
    public double getTotalAmount () {
        return lineItems.stream().mapToDouble(LineItem::getTotal).sum();
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
}
