package views;

import javax.swing.*;
import java.awt.*;

public class Products_AdminView extends JFrame{

    private JLabel idLabel;
    private JTextField idField;
    private JLabel codeLabel;
    private JTextField codeField;
    private JLabel descripcionLabel;
    private JTextField descriptionField;
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
        paneV = new JPanel();
        paneV.setLayout(new BoxLayout(paneV,BoxLayout.Y_AXIS));
        paneV.setPreferredSize(new Dimension(300,200));
        paneV.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));


        paneH = new JPanel();
        paneH.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        paneH.setPreferredSize(new Dimension(500,400));


        createProductBtn = new JButton("Crear producto");
        findProductBtn = new JButton("Buscar producto");
        modifyProductBtn = new JButton("Modificar productos");
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
        codeLabel = new JLabel("Código"); paneV.add(codeLabel);
        codeField = new JTextField(); codeField.setPreferredSize(new Dimension (300, 50)); paneV.add(codeField);
        descripcionLabel = new JLabel("Descripción"); paneV.add(descripcionLabel);
        descriptionField = new JTextField(); descriptionField.setPreferredSize(new Dimension (300, 50)); paneV.add(descriptionField);
        priceLabel = new JLabel("Precio"); paneV.add(priceLabel);
        priceField = new JTextField(); priceField.setPreferredSize(new Dimension (300, 50)); paneV.add(priceField);

        paneH.add(createProductBtn);
        paneH.add(findProductBtn);
        paneH.add(modifyProductBtn);
        paneH.add(deleteProductBtn);
        setContentPane(pane);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}
