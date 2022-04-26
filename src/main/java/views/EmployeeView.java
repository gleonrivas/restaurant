package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        capacityBtn.addActionListener(new openCapacity_EmployeeView());

        ordersBtn.setBorderPainted(true);
        ordersBtn.setPreferredSize(new Dimension(110,60));
        ordersBtn.setFocusPainted(false);
        ordersBtn.addActionListener(new openOrders_EmployeeView());

        billsBtn.setBorderPainted(true);
        billsBtn.setPreferredSize(new Dimension(110,60));
        billsBtn.setFocusPainted(false);
        billsBtn.addActionListener(new openBills_EmployeeView());

        //pane.add(tittle);
        pane.add(capacityBtn);
        pane.add(ordersBtn);
        pane.add(billsBtn);

        //No more components.
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    class openCapacity_EmployeeView implements ActionListener {
        public void actionPerformed(ActionEvent e) {new Capacity_EmployeeView();
        }
    }

    class openOrders_EmployeeView implements ActionListener {
        public void actionPerformed(ActionEvent e) {new Orders_EmployeeView();
        }
    }

    class openBills_EmployeeView implements ActionListener {
        public void actionPerformed(ActionEvent e) {new Bills_EmployeeView();
        }
    }
}