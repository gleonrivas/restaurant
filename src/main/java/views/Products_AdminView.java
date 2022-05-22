package views;

import models.Product;
import models.ProductType;
import utilities.Product_Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Products_AdminView extends JFrame{

    private static final ImageIcon wallpaper = new ImageIcon(getImgRute());
    private JLabel idLabel;
    private static JTextField idField;
    private JLabel typeLabel;
    private static JComboBox pTypeCombo;
    private JLabel nameLabel;
    private static JTextField nameField;
    private JLabel priceLabel;
    private static JTextField priceField;

    private JButton createProductBtn;
    private JButton findProductBtn;
    private JButton modifyProductBtn;
    private JButton deleteProductBtn;

    private JPanel paneV;
    private JPanel paneH;
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
        String rute = new File("src/main/java/assets/Employee_AdminView.png").getAbsolutePath();
        return rute;
    }

    public Products_AdminView (){

        //Window property.
        super("Gestión de productos");
        setSize(440,500);
        setLocationRelativeTo(null);
        setResizable(false);


        //Add components here.
        JPanel bgPanel = bgImgPane();
        bgPanel.setOpaque(false);

        paneV = new JPanel();
        paneV.setOpaque(false);
        paneV.setLayout(new BoxLayout(paneV,BoxLayout.Y_AXIS));
        paneV.setPreferredSize(new Dimension(350,260));
        paneV.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));

        paneH = new JPanel();
        paneH.setOpaque(false);
        paneH.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        paneH.setPreferredSize(new Dimension(500,400));

        createProductBtn = new JButton("Crear producto");
        findProductBtn = new JButton("Buscar producto");
        modifyProductBtn = new JButton("Modificar Datos");
        deleteProductBtn = new JButton("Eliminar producto");

        //Buttons styles...
        createProductBtn.setBorderPainted(true);
        createProductBtn.setPreferredSize(new Dimension(170,60));
        createProductBtn.setOpaque(false);
        createProductBtn.setFocusPainted(false);
        createProductBtn.addActionListener(new insertProducts());

        findProductBtn.setBorderPainted(true);
        findProductBtn.setPreferredSize(new Dimension(170, 60));
        findProductBtn.setOpaque(false);
        findProductBtn.setFocusPainted(false);
        findProductBtn.addActionListener(new findProduct());

        modifyProductBtn.setBorderPainted(true);
        modifyProductBtn.setPreferredSize(new Dimension(170,60));
        modifyProductBtn.setOpaque(false);
        modifyProductBtn.setFocusPainted(false);
        modifyProductBtn.addActionListener(new updateProduct());

        deleteProductBtn.setBorderPainted(true);
        deleteProductBtn.setPreferredSize(new Dimension(170,60));
        deleteProductBtn.setOpaque(false);
        deleteProductBtn.setFocusPainted(false);
        deleteProductBtn.addActionListener(new deleteProduct());

        bgPanel.add(paneV);
        bgPanel.add(paneH);

        idLabel = new JLabel("ID"); idLabel.setForeground(Color.white); paneV.add(idLabel);
        idField = new JTextField(); idField.setPreferredSize(new Dimension (300, 50)); paneV.add(idField);
        nameLabel = new JLabel("Nombre"); nameLabel.setForeground(Color.white); paneV.add(nameLabel);
        nameField = new JTextField(); nameField.setPreferredSize(new Dimension (300, 50)); paneV.add(nameField);
        priceLabel = new JLabel("Precio"); priceLabel.setForeground(Color.white); paneV.add(priceLabel);
        priceField = new JTextField(); priceField.setPreferredSize(new Dimension (300, 50)); paneV.add(priceField);
        typeLabel = new JLabel("Tipo"); typeLabel.setForeground(Color.white); paneV.add(typeLabel);
        pTypeCombo = new JComboBox<>();
        for (ProductType p : ProductType.values()){
            pTypeCombo.addItem(p);
        }
        paneV.add(pTypeCombo);

        paneH.add(createProductBtn);
        paneH.add(findProductBtn);
        paneH.add(modifyProductBtn);
        paneH.add(deleteProductBtn);
        setContentPane(bgPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    static class insertProducts implements ActionListener {
        public void actionPerformed (ActionEvent a){
            int idData = Integer.parseInt(idField.getText());
            ProductType typeData = (ProductType) pTypeCombo.getSelectedItem();
            String nameData = nameField.getText();
            double priceData = Double.parseDouble(priceField.getText());

            Product product = new Product(idData, typeData, nameData, priceData);

            Product_Utilities.createProduct(product);
        }
    }

    static class findProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int idData = Integer.parseInt(idField.getText());

            String name = Product_Utilities.getById(idData).getName();
            nameField.setText(name);
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
            String nameData = nameField.getText();
            double priceData = Double.parseDouble(priceField.getText());

            Product product = new Product(idData, typeData, nameData, priceData);

            Product_Utilities.updateProduct(product);
        }
    }

    static class deleteProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int idData = Integer.parseInt(idField.getText());
            Product_Utilities.deleteProduct(idData);
        }
    }

}
