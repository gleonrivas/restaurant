package views;

import javax.swing.*;
import java.awt.*;

public class Tables_AdminView extends JFrame {

    private JLabel idLabel;
    private JTextField idField;
    private JLabel tableLabel;
    private JTextField tableField;
    private JLabel clientsLabel;
    private JTextField clientsField;

    private JButton createTableBtn;
    private JButton findTableBtn;
    private JButton modifyTableBtn;
    private JButton deleteTableBtn;

    private JPanel paneV;
    private JPanel paneH;
    private JPanel pane;

    public Tables_AdminView() {

        //Window property.
        super("Mesas");
        setSize(470,510);
        setLocationRelativeTo(null);
        setResizable(false);


        //Add components here.
        pane = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        paneV = new JPanel();
        paneV.setLayout(new BoxLayout(paneV,BoxLayout.Y_AXIS));

        paneH = new JPanel();
        paneH.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        paneH.setPreferredSize(new Dimension(500,400));

        createTableBtn = new JButton("Crear mesa");
        findTableBtn = new JButton("Buscar mesas");
        modifyTableBtn = new JButton("Modificar mesa");
        deleteTableBtn = new JButton("Eliminar mesa");

        //Buttons styles...
        createTableBtn.setBorderPainted(true);
        createTableBtn.setPreferredSize(new Dimension(170,60));
        createTableBtn.setOpaque(false);
        createTableBtn.setFocusPainted(false);

        findTableBtn.setBorderPainted(true);
        findTableBtn.setPreferredSize(new Dimension(170, 60));
        findTableBtn.setOpaque(false);
        findTableBtn.setFocusPainted(false);

        modifyTableBtn.setBorderPainted(true);
        modifyTableBtn.setPreferredSize(new Dimension(170,60));
        modifyTableBtn.setOpaque(false);
        modifyTableBtn.setFocusPainted(false);

        deleteTableBtn.setBorderPainted(true);
        deleteTableBtn.setPreferredSize(new Dimension(170,60));
        deleteTableBtn.setOpaque(false);
        deleteTableBtn.setFocusPainted(false);

        pane.add(paneV);
        pane.add(paneH);

        idLabel = new JLabel("ID"); paneV.add(idLabel);
        idField = new JTextField(); idField.setPreferredSize(new Dimension (300, 50)); paneV.add(idField);
        tableLabel = new JLabel("Número de mesa"); paneV.add(tableLabel);
        tableField = new JTextField(); tableField.setPreferredSize(new Dimension (300, 50)); paneV.add(tableField);
        clientsLabel = new JLabel("Número de comensales"); paneV.add(clientsLabel);
        clientsField = new JTextField(); clientsField.setPreferredSize(new Dimension (300,50)); paneV.add(clientsField);

        paneH.add(createTableBtn);
        paneH.add(findTableBtn);
        paneH.add(modifyTableBtn);
        paneH.add(deleteTableBtn);
        setContentPane(pane);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
