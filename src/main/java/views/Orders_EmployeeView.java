package views;

import models.Orders;
import models.Person;
import models.Product;
import models.Table;
import utilities.Employee_Utilities;
import utilities.Orders_Utilities;
import utilities.Product_Utilities;
import utilities.Table_Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static java.lang.Integer.parseInt;

public class Orders_EmployeeView extends JFrame{

    private static final ImageIcon wallpaper = new ImageIcon(getImgRute());
    private JLabel title;
    private JLabel employeeNameLabel;
    private static JComboBox employeeNameCombo;
    private JLabel tableIdLabel;
    private static JComboBox tableIdCombo;
    private JLabel productNameLabel;
    private static JComboBox productNameCombo;
    private JLabel quantityLabel;
    private static JTextField quantityData;
    private JButton addBtn;


    private JPanel pane1;
    private JPanel pane2;
    private JPanel pane3;

    private JPanel bgImgPane(){
        JPanel panel = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(wallpaper.getImage(), 0, 0, null);
            }
        };
        return panel;
    }

    private static String getImgRute(){
        String rute = new File("src/main/java/assets/mainView.png").getAbsolutePath();
        return rute;
    }

    public Orders_EmployeeView (){

        //Window property.
        super("Comandas");
        setSize(700,250);
        setLocationRelativeTo(null);
        setResizable(false);


        //Add components here.
        JPanel bgPanel = bgImgPane();
        bgPanel.setOpaque(false);
        bgPanel.setLayout(new BoxLayout(bgPanel, BoxLayout.Y_AXIS));

        pane1 = new JPanel();
        pane1.setOpaque(false);
        pane1.setLayout(new BoxLayout(pane1,BoxLayout.X_AXIS));
        pane1.setPreferredSize(new Dimension(700,80));
        pane1.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));

        pane2 = new JPanel();
        pane2.setOpaque(false);
        pane2.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane2.setPreferredSize(new Dimension(700,20));

        pane3 = new JPanel();
        pane3.setOpaque(false);
        pane3.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane3.setPreferredSize(new Dimension(700,100));

        addBtn = new JButton("Enviar comanda");

        //Buttons styles...

        addBtn.setBorderPainted(true);
        addBtn.setFocusPainted(false);
        addBtn.addActionListener(new sendProduct());

        bgPanel.add(pane1);
        bgPanel.add(pane2);
        bgPanel.add(pane3);

        title = new JLabel("Comandas");
        title.setFont(new Font("Georgia", Font.PLAIN, 40));
        title.setForeground(Color.white);
        title.setOpaque(false);
        pane1.add(title);

        employeeNameLabel = new JLabel("Camarer@                  "); employeeNameLabel.setForeground(Color.white);
        pane2.add(employeeNameLabel);

        tableIdLabel = new JLabel("Mesa                        "); tableIdLabel.setForeground(Color.white);
        pane2.add(tableIdLabel);

        productNameLabel = new JLabel("Producto                            "); productNameLabel.setForeground(Color.white);
        pane2.add(productNameLabel);

        quantityLabel = new JLabel("             Cantidad"); quantityLabel.setForeground(Color.white);
        pane2.add(quantityLabel);

        employeeNameCombo = new JComboBox<>();
        for (Person p : Employee_Utilities.getAlle()){
            String name = p.getPname();
            employeeNameCombo.addItem(name);
        }
        pane2.add(employeeNameCombo);

        tableIdCombo = new JComboBox<>();
        for (Table t : Table_Utilities.getAllt()){
            int num = t.getId();
            tableIdCombo.addItem(num);
        }
        pane2.add(tableIdCombo);

        productNameCombo = new JComboBox<>();
        for (Product p : Product_Utilities.getAllp()){
            String name = p.getName();
            productNameCombo.addItem(name);
        }

        quantityData = new JTextField();
        quantityData.setPreferredSize(new Dimension(50, 20));

        pane2.add(employeeNameLabel);
        pane2.add(tableIdLabel);
        pane2.add(productNameLabel);
        pane2.add(quantityLabel);
        pane3.add(employeeNameCombo);
        pane3.add(tableIdCombo);
        pane3.add(productNameCombo);
        pane3.add(quantityData);
        pane3.add(addBtn);

        setContentPane(bgPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    static class sendProduct implements ActionListener {
        public void actionPerformed (ActionEvent a){

            int idEmployee = 0;
            int idTable = 0;
            int idProduct = 0;

            for (Person p : Employee_Utilities.getAlle()){
                if (p.getPname().equals(employeeNameCombo.getSelectedItem())){
                    idEmployee = p.getId();
                }
            }


            for (Table t : Table_Utilities.getAllt()){
                String dataCombo = String.valueOf(tableIdCombo.getSelectedItem());
                String id = String.valueOf(t.getId());
                if (id.equals(dataCombo)){
                    idTable = t.getId();
                }
            }


            for (Product p : Product_Utilities.getAllp()){
                if (p.getName().equals(productNameCombo.getSelectedItem())){
                    idProduct = p.getId();
                }
            }

            int quantity = Integer.parseInt(quantityData.getText());
            int state = 0;

            Orders order = new Orders(idEmployee, idTable, idProduct, quantity, state);

            Orders_Utilities.insertIntoOrders(order);
            Orders_Utilities.insertIntoProductOrders(order);

    }

    /*static class findProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int idData = Integer.parseInt(idField.getText());

            String name = Product_Utilities.getById(idData).getName();
            nameField.setText(name);
            int code = Product_Utilities.getById(idData).getCode();
            codeField.setText(String.valueOf(code));
            double price = Product_Utilities.getById(idData).getPrice();
            priceField.setText(String.valueOf(price));

            ProductType pType = Product_Utilities.getById(idData).getProductType();
            pTypeCombo.getModel().setSelectedItem(pType);
        }
    }

    static class updateProduct implements ActionListener {
        public void actionPerformed (ActionEvent a){
            int idData = Integer.parseInt(idField.getText());
            ProductType typeData = (ProductType) pTypeCombo.getSelectedItem();
            int codeData = Integer.parseInt(codeField.getText());
            String nameData = nameField.getText();
            double priceData = Double.parseDouble(priceField.getText());

            Product product = new Product(idData, typeData, nameData, codeData, priceData);

            Product_Utilities.updateProduct(product);
        }
    }

    static class deleteProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int idData = Integer.parseInt(idField.getText());
            Product_Utilities.deleteProduct(idData);
        }*/
    }

}

