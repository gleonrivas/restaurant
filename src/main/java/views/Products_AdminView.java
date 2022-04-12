package views;

import models.Product;
import models.ProductType;
import utilities.Product_Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Products_AdminView extends JFrame{

    private JLabel idLabel;
    private JTextField idField;
    private JLabel typeLabel;
    private JComboBox typeCombo;
    private JLabel codeLabel;
    private JTextField codeField;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel priceLabel;
    private JTextField priceField;

    private JButton createProductBtn;
    private JButton findProductBtn;
    private JButton modifyProductBtn;
    private JButton deleteProductBtn;

    private JPanel paneV;
    private JPanel paneH;
    private JPanel pane;

    public Products_AdminView (){

        //Window property.
        super("Gestión de productos");
        setSize(440,430);
        setLocationRelativeTo(null);
        setResizable(false);


        //Add components here.
        pane = new JPanel();
        pane.setOpaque(false);

        paneV = new JPanel();
        paneV.setLayout(new BoxLayout(paneV,BoxLayout.Y_AXIS));
        paneV.setPreferredSize(new Dimension(350,200));
        paneV.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));

        paneH = new JPanel();
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

        findProductBtn.setBorderPainted(true);
        findProductBtn.setPreferredSize(new Dimension(170, 60));
        findProductBtn.setOpaque(false);
        findProductBtn.setFocusPainted(false);

        modifyProductBtn.setBorderPainted(true);
        modifyProductBtn.setPreferredSize(new Dimension(170,60));
        modifyProductBtn.setOpaque(false);
        modifyProductBtn.setFocusPainted(false);

        deleteProductBtn.setBorderPainted(true);
        deleteProductBtn.setPreferredSize(new Dimension(170,60));
        deleteProductBtn.setOpaque(false);
        deleteProductBtn.setFocusPainted(false);

        pane.add(paneV);
        pane.add(paneH);

        idLabel = new JLabel("ID"); paneV.add(idLabel);
        idField = new JTextField(); idField.setPreferredSize(new Dimension (300, 50)); paneV.add(idField);
        typeLabel = new JLabel("Tipo"); paneV.add(typeLabel);
        typeCombo = new JComboBox<>();
        for (ProductType p : ProductType.values()){
            typeCombo.addItem(p);
        }
        paneV.add(typeCombo);
        codeLabel = new JLabel("Código"); paneV.add(codeLabel);
        codeField = new JTextField(); codeField.setPreferredSize(new Dimension (300, 50)); paneV.add(codeField);
        nameLabel = new JLabel("Nombre"); paneV.add(nameLabel);
        nameField = new JTextField(); nameField.setPreferredSize(new Dimension (300, 50)); paneV.add(nameField);
        priceLabel = new JLabel("Precio"); paneV.add(priceLabel);
        priceField = new JTextField(); priceField.setPreferredSize(new Dimension (300, 50)); paneV.add(priceField);

        paneH.add(createProductBtn);
        paneH.add(findProductBtn);
        paneH.add(modifyProductBtn);
        paneH.add(deleteProductBtn);
        setContentPane(pane);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        class insertProducts implements ActionListener {
            public void actionPerformed (ActionEvent a){
                int idData = Integer.parseInt(idField.getText());
                String typeData = Objects.requireNonNull(typeCombo.getSelectedItem()).toString();
                int codeData = Integer.parseInt(codeField.getText());
                String descriptionData = descriptionField.getText();
                double priceData = Double.parseDouble(priceField.getText());

                Product product = new Product(idField, typeCombo, codeField, descriptionField, priceField);

                Product_Utilities.createProduct(product);
            }
        }

    }

}
