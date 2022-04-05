package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainView extends JFrame{

    private JLabel title;
    private JButton adminBtn;
    private JButton employeeBtn;
    private JButton clientBtn;
    private JPanel pane;

    public MainView() throws IOException {
        
        //Window property.

        super("Menu principal");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setResizable(false);


        //Add components here.
        pane = new JPanel();
        pane.setOpaque(false);



        title = new JLabel();
        title.setText("Elige un perfil:");
        title.setFont(new Font("Normal", Font.PLAIN, 35));
        title.setForeground(Color.decode("#696969"));

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

        setContentPane(pane);
        add(title);
        add(adminBtn);
        add(employeeBtn);
        add(clientBtn);

        //No more components.
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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