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

            //product form
        }
    }
