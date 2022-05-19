package views;

import models.Product;
import models.ProductType;
import models.TableAvailability;
import models.Table;
import utilities.Product_Utilities;
import utilities.Table_Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Tables_AdminView extends JFrame {

    private static final ImageIcon wallpaper = new ImageIcon(getImgRute());
    private JLabel idLabel;
    private static JTextField idField;
    private JLabel locationLabel;
    private static JTextField locationField;
    private JLabel availabilityLabel;
    private static JComboBox availabilityField;
    private JLabel capacityLabel;
    private static JTextField capacityField;

    private JButton createTableBtn;
    private JButton findTableBtn;
    private JButton modifyTableBtn;
    private JButton deleteTableBtn;

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

    public Tables_AdminView() {

        //Window property.
        super("Mesas");
        setSize(430,400);
        setLocationRelativeTo(null);
        setResizable(false);


        //Add components here.
        JPanel bgPanel = bgImgPane();
        bgPanel.setOpaque(false);

        paneV = new JPanel();
        paneV.setOpaque(false);
        paneV.setLayout(new BoxLayout(paneV,BoxLayout.Y_AXIS));
        paneV.setPreferredSize(new Dimension(350,150));
        paneV.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));

        paneH = new JPanel();
        paneH.setOpaque(false);
        paneH.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        paneH.setPreferredSize(new Dimension(500,290));

        createTableBtn = new JButton("Crear mesa");
        findTableBtn = new JButton("Buscar mesas");
        modifyTableBtn = new JButton("Modificar mesa");
        deleteTableBtn = new JButton("Eliminar mesa");

        //Buttons styles...
        createTableBtn.setBorderPainted(true);
        createTableBtn.setPreferredSize(new Dimension(170,60));
        createTableBtn.setOpaque(false);
        createTableBtn.setFocusPainted(false);
        createTableBtn.addActionListener(new insertTable());

        findTableBtn.setBorderPainted(true);
        findTableBtn.setPreferredSize(new Dimension(170, 60));
        findTableBtn.setOpaque(false);
        findTableBtn.setFocusPainted(false);
        findTableBtn.addActionListener(new findTable());

        modifyTableBtn.setBorderPainted(true);
        modifyTableBtn.setPreferredSize(new Dimension(170,60));
        modifyTableBtn.setOpaque(false);
        modifyTableBtn.setFocusPainted(false);
        modifyTableBtn.addActionListener(new updateTable());

        deleteTableBtn.setBorderPainted(true);
        deleteTableBtn.setPreferredSize(new Dimension(170,60));
        deleteTableBtn.setOpaque(false);
        deleteTableBtn.setFocusPainted(false);
        deleteTableBtn.addActionListener(new deleteTable());

        bgPanel.add(paneV);
        bgPanel.add(paneH);

        idLabel = new JLabel("ID"); idLabel.setForeground(Color.white); paneV.add(idLabel);
        idField = new JTextField(); idField.setPreferredSize(new Dimension (300, 50)); paneV.add(idField);

        locationLabel = new JLabel("Posición"); locationLabel.setForeground(Color.white); paneV.add(locationLabel);
        locationField = new JTextField(); locationField.setPreferredSize(new Dimension (300, 50)); paneV.add(locationField);

        capacityLabel = new JLabel("Capacidad de la mesa"); capacityLabel.setForeground(Color.white); paneV.add(capacityLabel);
        capacityField = new JTextField(); capacityField.setPreferredSize(new Dimension (300,50)); paneV.add(capacityField);

        paneH.add(createTableBtn);
        paneH.add(findTableBtn);
        paneH.add(modifyTableBtn);
        paneH.add(deleteTableBtn);
        setContentPane(bgPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    static class insertTable implements ActionListener {
        public void actionPerformed (ActionEvent a){
            int idData = Integer.parseInt(idField.getText());
            int  locationData = Integer.parseInt(locationField.getText());
            int capacityData = Integer.parseInt(capacityField.getText());
            TableAvailability availability = TableAvailability.DISPONIBLE;

            Table table = new Table(idData, locationData, availability, capacityData);

            Table_Utilities.createTable(table);
        }
    }
    static class findTable implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int idData = Integer.parseInt(idField.getText());
            idField.setText(String.valueOf(idData));
            int location = Table_Utilities.getById(idData).getLocation();
            locationField.setText(String.valueOf(location));
            int capacity = Table_Utilities.getById(idData).getCapacity();
            capacityField.setText(String.valueOf(capacity));
        }
    }

    static class updateTable implements ActionListener {
        public void actionPerformed (ActionEvent a){
            int idData = Integer.parseInt(idField.getText());
            int locationData = Integer.parseInt(locationField.getText());
            int capacity = Integer.parseInt(capacityField.getText());

            Table table = new Table(idData, locationData, capacity);

            Table_Utilities.updateTable(table);
        }
    }
    static class deleteTable implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int idData = Integer.parseInt(idField.getText());
            Table_Utilities.deleteTable(idData);
        }
    }


}
