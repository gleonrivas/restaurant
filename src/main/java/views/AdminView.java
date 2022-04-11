package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AdminView extends JFrame{

    private static final ImageIcon wallpaper = new ImageIcon(getImgRute());
    private JLabel title;
    private JButton employeesBtn;
    private JButton productsBtn;
    private JButton tablesBtn;
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
        String rute = new File("src/main/java/assets/adminView.png").getAbsolutePath();
        return rute;
    }


    public AdminView(){

        super("Administración");
        setSize(400, 360);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel bgPanel = bgImgPane();
        bgPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        btnPane = new JPanel();
        btnPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        title = new JLabel("Administración");
        employeesBtn = new JButton("Empleados");
        productsBtn = new JButton("Productos");
        tablesBtn = new JButton("Mesas");

        title.setFont(new Font("Georgia",Font.PLAIN, 40));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(40,0,120,0));

        //Buttons stiles...
        employeesBtn.setBorderPainted(true);
        employeesBtn.setPreferredSize(new Dimension(100,60));
        employeesBtn.setOpaque(false);
        employeesBtn.setFocusPainted(false);
        employeesBtn.addActionListener(new openEmployeeUIView());

        productsBtn.setBorderPainted(true);
        productsBtn.setPreferredSize(new Dimension(100,60));
        productsBtn.setOpaque(false);
        productsBtn.setFocusPainted(false);
        productsBtn.addActionListener(new openProductsUIView());

        tablesBtn.setBorderPainted(true);
        tablesBtn.setPreferredSize(new Dimension(100,60));
        tablesBtn.setOpaque(false);
        tablesBtn.setFocusPainted(false);
        tablesBtn.addActionListener(new openTablesUIView());

        setContentPane(bgPanel);
        btnPane.setOpaque(false);
        bgPanel.add(title);
        bgPanel.add(btnPane);
        btnPane.add(employeesBtn);
        btnPane.add(productsBtn);
        btnPane.add(tablesBtn);

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