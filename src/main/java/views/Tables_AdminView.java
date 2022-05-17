package views;

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
        setSize(430,500);
        setLocationRelativeTo(null);
        setResizable(false);


        //Add components here.
        JPanel bgPanel = bgImgPane();
        bgPanel.setOpaque(false);

        paneV = new JPanel();
        paneV.setOpaque(false);
        paneV.setLayout(new BoxLayout(paneV,BoxLayout.Y_AXIS));
        paneV.setPreferredSize(new Dimension(350,270));
        paneV.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));

        paneH = new JPanel();
        paneH.setOpaque(false);
        paneH.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        paneH.setPreferredSize(new Dimension(500,300));

        createTableBtn = new JButton("Crear mesa");
        findTableBtn = new JButton("Buscar mesas");
        modifyTableBtn = new JButton("Modificar mesa");
        deleteTableBtn = new JButton("Eliminar mesa");

        //Buttons styles...
        createTableBtn.setBorderPainted(true);
        createTableBtn.setPreferredSize(new Dimension(170,60));
        createTableBtn.setOpaque(false);
        createTableBtn.setFocusPainted(false);
        //createTableBtn.addActionListener();

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

        bgPanel.add(paneV);
        bgPanel.add(paneH);

        idLabel = new JLabel("ID"); idLabel.setForeground(Color.white); paneV.add(idLabel);
        idField = new JTextField(); idField.setPreferredSize(new Dimension (300, 50)); paneV.add(idField);

        locationLabel = new JLabel("Posición"); locationLabel.setForeground(Color.white); paneV.add(locationLabel);
        locationField = new JTextField(); locationField.setPreferredSize(new Dimension (300, 50)); paneV.add(locationField);

        availabilityLabel = new JLabel("Disponibilidad"); availabilityLabel.setForeground(Color.white); paneV.add(availabilityLabel);
        availabilityField = new JComboBox<>();

        for (TableAvailability e : TableAvailability.values()){
            availabilityField.addItem(e);
        }

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

            Table table = new Table(idData, locationData, capacityData);

            Table_Utilities.createProduct(table);
        }
    }

}
