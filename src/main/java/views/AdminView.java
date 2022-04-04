package views;

import javax.swing.*;
import java.awt.*;

public class AdminView {

    private JButton employeesBtn;
    private JButton productsBtn;
    private JButton tablesBtn;
    private Container pane;


    public AdminView(){

        JFrame frame = new JFrame("Administración");
            frame.setBackground(Color.decode("#8888EE"));
            frame.setSize(400, 200);
            frame.setLocationRelativeTo(null);

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
        employeesBtn.setForeground(Color.decode("#8888EE"));

        productsBtn.setBorderPainted(true);
        productsBtn.setPreferredSize(new Dimension(170,60));
        productsBtn.setOpaque(false);
        productsBtn.setFocusPainted(false);
        productsBtn.setForeground(Color.decode("#8888EE"));

        tablesBtn.setBorderPainted(true);
        tablesBtn.setPreferredSize(new Dimension(170,60));
        tablesBtn.setOpaque(false);
        tablesBtn.setFocusPainted(false);
        tablesBtn.setForeground(Color.decode("#8888EE"));

        //pane.add(tittle);
            pane.add(employeesBtn);
            pane.add(productsBtn);
            pane.add(tablesBtn);

        //No more components.
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}