package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainView extends JFrame{

    private JButton adminBtn;
    private JButton employeeBtn;
    private JButton clientBtn;
    private Container pane;

    public MainView() throws IOException {
        //Window property.
        JFrame frame = new JFrame("Menu principal");
        frame.setBackground(Color.decode("#e2e2e2"));
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        //Add components here.
        pane = frame.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));


        /* Font sample:
        tittle = new JLabel();
        tittle.setText("Hola, elige un perfil:");
        tittle.setFont(new Font("Chomsky", Font.PLAIN, 45));*/

        adminBtn = new JButton("Administración");
        employeeBtn = new JButton("Zona de empleados");
        clientBtn = new JButton("Zona para clientes");

        //Buttons stiles...
        adminBtn.setBorderPainted(true);
        adminBtn.setPreferredSize(new Dimension(170,60));
        adminBtn.setOpaque(false);
        adminBtn.setFocusPainted(false);
        adminBtn.addActionListener(new openAdminView());

        employeeBtn.setBorderPainted(true);
        employeeBtn.setPreferredSize(new Dimension(170,60));
        employeeBtn.setOpaque(false);
        employeeBtn.setFocusPainted(false);
        employeeBtn.addActionListener(new openEmployeeView());


        clientBtn.setBorderPainted(true);
        clientBtn.setPreferredSize(new Dimension(170,60));
        clientBtn.setOpaque(false);
        clientBtn.setFocusPainted(false);
        clientBtn.addActionListener(new openClientView());


        //pane.add(tittle);
        pane.add(adminBtn);
        pane.add(employeeBtn);
        pane.add(clientBtn);

        //No more components.
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    class openAdminView implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            new AdminView();
        }
    }

    class openEmployeeView implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new EmployeeView();
        }
    }

    class openClientView implements ActionListener {
        public void actionPerformed(ActionEvent i) {
            new ClientView();
        }
    }

    public static void main(String args[]) throws IOException {
        MainView mainMenu = new MainView();

    }
}