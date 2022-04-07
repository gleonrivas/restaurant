package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AdminView extends JFrame{

    private static final ImageIcon wallpaper = new ImageIcon(getImgRute());
    private JButton employeesBtn;
    private JButton productsBtn;
    private JButton tablesBtn;
    private JPanel pane;


    public AdminView(){

        super("Administración");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel bgPanel = bgImgPane();


        //Add components here.
        pane = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pane.setBorder(BorderFactory.createEmptyBorder(270,0,0,0));

        employeesBtn = new JButton("Empleados");
        productsBtn = new JButton("Productos");
        tablesBtn = new JButton("Mesas");

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
        pane.setOpaque(false);
        bgPanel.add(pane);
        pane.add(employeesBtn);
        pane.add(productsBtn);
        pane.add(tablesBtn);

        //No more components.
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private static String getImgRute(){
        String ruta = new File("src/main/java/assets/400x400.png").getAbsolutePath();
        return ruta;
    }

    private JPanel bgImgPane(){
        JPanel panel = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(wallpaper.getImage(), 0, 0, null);
            }
        };
        return panel;
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