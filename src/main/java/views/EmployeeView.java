package views;

import javax.swing.*;
import java.awt.*;

public class EmployeeView{

    private JButton capacityBtn;
    private JButton ordersBtn;
    private JButton billsBtn;
    private Container pane;


    public EmployeeView(){

        JFrame frame = new JFrame("Zona empleados");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


        //Add components here.
        pane = frame.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        capacityBtn = new JButton("Aforo");
        ordersBtn = new JButton("Pedidos");
        billsBtn = new JButton("Cuentas");

        //Buttons stiles...
        capacityBtn.setBorderPainted(true);
        capacityBtn.setPreferredSize(new Dimension(110,60));
        capacityBtn.setFocusPainted(false);

        ordersBtn.setBorderPainted(true);
        ordersBtn.setPreferredSize(new Dimension(110,60));
        ordersBtn.setFocusPainted(false);

        billsBtn.setBorderPainted(true);
        billsBtn.setPreferredSize(new Dimension(110,60));
        billsBtn.setFocusPainted(false);

        //pane.add(tittle);
        pane.add(capacityBtn);
        pane.add(ordersBtn);
        pane.add(billsBtn);

        //No more components.
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}