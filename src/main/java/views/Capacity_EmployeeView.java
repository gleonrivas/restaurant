package views;

import models.TableAvailability;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Capacity_EmployeeView extends JFrame{

    private static final ImageIcon wallpaper = new ImageIcon(getImgRute());
    private JLabel MesaLabel;
    private static JComboBox MesaCombo;
    private JLabel LibreOcupLabel;
    private static JComboBox LibreOcupCombo;

    private JButton aplicarBtn;

    private JPanel paneV;
    private JPanel paneH;
    private JPanel paneT1;
    private JPanel paneT2;
    private JPanel paneT3;

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

    public Capacity_EmployeeView(){

        super("Gestión de Aforo");
        setSize(600,310);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel bgPanel = bgImgPane();
        bgPanel.setOpaque(false);

        paneT1 = new JPanel();
        paneT1.setOpaque(false);
        paneT1.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 20));

        paneT2 = new JPanel();
        paneT2.setOpaque(false);
        paneT2.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 20));

        paneT3 = new JPanel();
        paneT3.setOpaque(false);
        paneT3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        paneT3.setPreferredSize(new Dimension(100,60));

        paneV = new JPanel();
        paneV.setOpaque(false);
        paneV.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        paneH = new JPanel();
        paneH.setOpaque(false);
        paneH.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        aplicarBtn = new JButton("Enviar");

        aplicarBtn.setBorderPainted(true);
        aplicarBtn.setPreferredSize(new Dimension(100,40));
        aplicarBtn.setOpaque(true);
        aplicarBtn.setFocusPainted(false);
        aplicarBtn.addActionListener(new LibreOcupMesa());

        bgPanel.add(paneT1);
        bgPanel.add(paneT2);
        bgPanel.add(paneV);
        bgPanel.add(paneH);
        bgPanel.add(paneT3);

        MesaLabel = new JLabel("ID Mesa"); MesaLabel.setForeground(Color.white); paneT1.add(MesaLabel);
        MesaCombo = new JComboBox<>(); MesaCombo.setPreferredSize(new Dimension(200, 30)); paneV.add(MesaCombo);
        LibreOcupLabel = new JLabel("Estado"); LibreOcupLabel.setForeground(Color.white); paneT2.add(LibreOcupLabel);
        LibreOcupCombo = new JComboBox<>(); LibreOcupCombo.setPreferredSize(new Dimension(200, 30));

        paneH.add(LibreOcupCombo);
        paneT3.add(aplicarBtn);

        setContentPane(bgPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    static class LibreOcupMesa implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = ;
        }
    }

}

