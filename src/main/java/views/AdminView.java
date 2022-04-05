package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView {

    private JButton employeesBtn;
    private JButton productsBtn;
    private JButton tablesBtn;
    private Container pane;


    public AdminView(){

        JFrame frame = new JFrame("Administración");
        frame.setBackground(Color.decode("#5f5fa6"));
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


        //Add components here.
        pane = frame.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        employeesBtn = new JButton("Empleados");
        productsBtn = new JButton("Productos");
        tablesBtn = new JButton("Mesas");

        //Buttons stiles...
        employeesBtn.setBorderPainted(true);
        employeesBtn.setPreferredSize(new Dimension(170,60));
        employeesBtn.setOpaque(false);
        employeesBtn.setFocusPainted(false);
        employeesBtn.setForeground(Color.decode("#5f5fa6"));
        employeesBtn.addActionListener(new openEmployeeUIView());

        productsBtn.setBorderPainted(true);
        productsBtn.setPreferredSize(new Dimension(170,60));
        productsBtn.setOpaque(false);
        productsBtn.setFocusPainted(false);
        productsBtn.setForeground(Color.decode("#5f5fa6"));
        productsBtn.addActionListener(new openProductsUIView());

        tablesBtn.setBorderPainted(true);
        tablesBtn.setPreferredSize(new Dimension(170,60));
        tablesBtn.setOpaque(false);
        tablesBtn.setFocusPainted(false);
        tablesBtn.setForeground(Color.decode("#5f5fa6"));
        tablesBtn.addActionListener(new openTablesUIView());

        //pane.add(tittle);
            pane.add(employeesBtn);
            pane.add(productsBtn);
            pane.add(tablesBtn);

        //No more components.
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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