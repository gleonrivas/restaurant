package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EmployeeView extends JFrame{

    private static final ImageIcon wallpaper = new ImageIcon(getImgRute());
    private JLabel title;
    private JButton bilssBtn;
    private JButton availabilityBtn;
    private JButton ordersBtn;
    private JPanel btnPane;
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
        String rute = new File("src/main/java/assets/mainview.png").getAbsolutePath();
        return rute;
    }


    public EmployeeView(){

        super("Zona Camarer@");
        setSize(400, 290);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel bgPanel = bgImgPane();
        bgPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        btnPane = new JPanel();
        btnPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        title = new JLabel("Zona Camarer@s");
        bilssBtn = new JButton("Cuentas");
        availabilityBtn = new JButton("Pedidos");
        ordersBtn = new JButton("Aforo");

        title.setFont(new Font("Georgia",Font.PLAIN, 40));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(40,0,40,0));

        //Buttons stiles...
        bilssBtn.setBorderPainted(true);
        bilssBtn.setPreferredSize(new Dimension(100,60));
        bilssBtn.setOpaque(false);
        bilssBtn.setFocusPainted(false);
        //bilssBtn.addActionListener(new );

        availabilityBtn.setBorderPainted(true);
        availabilityBtn.setPreferredSize(new Dimension(100,60));
        availabilityBtn.setOpaque(false);
        availabilityBtn.setFocusPainted(false);
        //availabilityBtn.addActionListener(new );

        ordersBtn.setBorderPainted(true);
        ordersBtn.setPreferredSize(new Dimension(100,60));
        ordersBtn.setOpaque(false);
        ordersBtn.setFocusPainted(false);
        //ordersBtn.addActionListener(new );

        setContentPane(bgPanel);
        btnPane.setOpaque(false);
        bgPanel.add(title);
        bgPanel.add(btnPane);
        btnPane.add(bilssBtn);
        btnPane.add(availabilityBtn);
        btnPane.add(ordersBtn);

        //No more components.
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    class openEmployeeUIView implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new Employee_AdminView();
        }
    }

    class openProductsUIView implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new Products_AdminView();
        }
    }

    class openTablesUIView implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new Tables_AdminView();
        }
    }

}
