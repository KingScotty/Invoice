public class InvoicePrinter {
    public static String printInvoice(Invoice Invoice) {


        StringBuilder sb = new StringBuilder();
        sb.append("Invoice\n");
        sb.append("Customer Name: ").append(Invoice.getCustomerName()).append("\n");
        sb.append("Invoice Number: ").append(Invoice.getInvoiceNumber()).append("\n");

        sb.append ("-------------------------------------\n");
        sb.append(String.format("%-15s %-5s $%-7s $%-7s\n", "Product", "Qty", "Unit Price", "Total"));
        sb.append ("-------------------------------------\n");

        for (LineItem lineItem : Invoice.getLineItems()) {
            Product p = lineItem.getProduct();
            sb.append(String.format("%-15s %-5d $%-7.2f $%-7.2f\n",
                    p.getName(), lineItem.getQuantity(), p.getUnitPrice(), lineItem.getTotal()));
        }
        sb.append("-------------------------------------\n");
        sb.append(String.format("AMOUNT DUE: $%.2f\n", invoice.getTotalAmount()));
        return sb.toString();
    }
    }


