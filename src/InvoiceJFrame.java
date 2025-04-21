import javax.swing.*;
import java.awt.*;

public class InvoiceJFrame  extends JFrame {
        private JTextField customerNameField = new JTextField(20);
        private JTextField customerAddressField = new JTextField(20);
        private JTextField productNameField = new JTextField(10);
        private JTextField productPriceField = new JTextField(5);
        private JTextField quantityField = new JTextField(5);
        private JTextArea outputArea = new JTextArea(15, 40);


        private Invoice invoice;

        //appstuff
        public void invoiceJFrame() {
setTitle("Invoice Generator");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());
//Top. customer info
       JPanel customerPanel = new JPanel();
            customerPanel.setLayout(new GridLayout(2, 2));
            customerPanel.setBorder(BorderFactory.createTitledBorder("Customer Info"));
            customerPanel.add(new JLabel("Customer Name:"));
            customerPanel.add(customerNameField);
            customerPanel.add(new JLabel("Customer Address:"));
            customerPanel.add(customerAddressField);
            add(customerPanel, BorderLayout.NORTH);

            //center product form
            JPanel productPanel = new JPanel();
            productPanel.setLayout(new GridLayout(3, 2));
            productPanel.setBorder(BorderFactory.createTitledBorder("Product Info"));

            productPanel.add (new JLabel("Product Name:"));
            productPanel.add(productNameField);
            productPanel.add(new JLabel("Product Price:"));
            productPanel.add(productPriceField);
            productPanel.add(new JLabel("Quantity:"));
            productPanel.add(quantityField);

          //  JButton addButton = new JButton("Add Item");
           // productPanel.add(addButton);
           // add(productPanel, BorderLayout.CENTER);

            add(productPanel, BorderLayout.CENTER);

            //bottom buttons

          //  JButton addButton = new JButton("Add Item");
            JButton addButton = new JButton("Add Item");
            productPanel.add(addButton);
            add(productPanel, BorderLayout.CENTER);

            JPanel outputPanel = new JPanel();
            outputPanel.setLayout(new BorderLayout());






            //quit button
            JButton quitButton = new JButton("Quit");
        }
    }
