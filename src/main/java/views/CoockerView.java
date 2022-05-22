package views;

import models.TableAvailability;
import utilities.Table_Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CoockerView extends JFrame{

    private static final ImageIcon wallpaper = new ImageIcon(getImgRute());
    private JLabel nombreLabel;
    private JLabel cantidadLabel;

    private JButton hechoBtn;

    private JPanel pane1;
    private JPanel pane2;
    private JPanel pane3;
    private JPanel pane4;
    private JPanel pane5;
    private JPanel pane6;

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

    public CoockerView() {

        super("Oido Cocina");
        setSize(600,300);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel bgPanel = bgImgPane();
        bgPanel.setOpaque(false);

        pane1 = new JPanel();
        //pane1.setOpaque(false);
        pane1.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        pane1.setBackground(Color.yellow);

        pane2 = new JPanel();
        //pane2.setOpaque(false);
        pane2.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        pane2.setBackground(Color.black);

        pane3 = new JPanel();
        //pane3.setOpaque(false);
        pane3.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 8));
        pane3.setBackground(Color.green);

        pane4 = new JPanel();
        //pane4.setOpaque(false);
        pane4.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 20));
        pane4.setBackground(Color.red);

        pane5 = new JPanel();
        //pane5.setOpaque(false);
        pane5.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 20));
        pane5.setBackground(Color.PINK);

        pane6 = new JPanel();
        //pane6.setOpaque(false);
        pane6.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 8));
        pane6.setBackground(Color.GRAY);

        hechoBtn = new JButton("Hecho");

        hechoBtn.setBorderPainted(true);
        hechoBtn.setPreferredSize(new Dimension(100,40));
        hechoBtn.setOpaque(false);
        hechoBtn.setFocusPainted(false);
        //hechoBtn.addActionListener(new productDone());

        bgPanel.add(pane1);
        bgPanel.add(pane2);
        bgPanel.add(pane3);
        bgPanel.add(pane4);
        bgPanel.add(pane5);
        bgPanel.add(pane6);

        nombreLabel = new JLabel("Nombre de Producto"); nombreLabel.setForeground(Color.white); pane1.add(nombreLabel);
        cantidadLabel = new JLabel("Cantidad"); cantidadLabel.setForeground(Color.white); pane2.add(cantidadLabel);

        pane3.add(hechoBtn);


        setContentPane(bgPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }

}
