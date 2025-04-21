import javax.swing.*;
import java.awt.*;

public class InvoiceJFrame  extends JFrame {
    private JTextField customerNameField = new JTextField(20);
    private JTextField customerInvoiceField = new JTextField(20);
    private JTextField productNameField = new JTextField(10);
    private JTextField productPriceField = new JTextField(5);
    private JTextField quantityField = new JTextField(5);
    private JTextArea outputArea = new JTextArea(15, 40);


    private Invoice invoice;

    //appstuff
    public InvoiceJFrame() {
        setTitle("Invoice Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
//Top. customer info
        JPanel customerPanel = new JPanel();
        customerPanel.setLayout(new GridLayout(2, 2));
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer Info"));
        customerPanel.add(new JLabel("Customer Name:"));
        customerPanel.add(customerNameField);
        customerPanel.add(new JLabel("Invoice Number:"));
        customerPanel.add(customerInvoiceField);
        add(customerPanel, BorderLayout.NORTH);

        //center product form
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(3, 2));
        productPanel.setBorder(BorderFactory.createTitledBorder("Product Info"));

        productPanel.add(new JLabel("Product Name:"));
        productPanel.add(productNameField);
        productPanel.add(new JLabel("Product Price:"));
        productPanel.add(productPriceField);
        productPanel.add(new JLabel("Quantity:"));
        productPanel.add(quantityField);

        JButton addButton = new JButton("Add Item");
        productPanel.add(addButton);
        add(productPanel, BorderLayout.CENTER);


        //bottom buttons and output


        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());

        JButton generateButton = new JButton("Generate Invoice");
        outputPanel.add(generateButton, BorderLayout.NORTH);
        outputArea.setEditable(false);

        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setEditable(false);
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);


        add(outputPanel, BorderLayout.SOUTH);

        // action: add line item
        addButton.addActionListener(e -> {
            try {
                String name = productNameField.getText();
                double price = Double.parseDouble(productPriceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                if (invoice == null) {
                    String customerName = customerNameField.getText();
                    String customerAddress = customerInvoiceField.getText();
                    invoice = new Invoice(customerName, customerAddress);
                }

                Product product = new Product(name, price);
                LineItem lineItem = new LineItem(product, quantity);
                invoice.addLineItem(lineItem);

                JOptionPane.showMessageDialog(this, "Item added to invoice.");
                productNameField.setText("");
                productPriceField.setText("");
                quantityField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());

                if (invoice == null || invoice.getLineItems().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please add a product before generating the invoice.");
                }
            }
            outputArea.setText(InvoicePrinter.printInvoice(invoice));
        });
        pack();
        setLocationRelativeTo(null); // center
        setVisible(true);

        //quit button not used
        JButton quitButton = new JButton("Quit");
        //reset button
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            customerNameField.setText("");
            customerInvoiceField.setText("");
            productNameField.setText("");
            productPriceField.setText("");
            quantityField.setText("");
            outputArea.setText("");
            invoice = null;
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(InvoiceApp::new);
    }
}
