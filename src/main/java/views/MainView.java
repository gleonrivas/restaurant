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
    private JButton coockerBtn;
    private JPanel pane;

    public MainView() throws IOException {
        
        //Window property.

        super("Menu principal");
        setSize(400, 280);
        setLocationRelativeTo(null);
        setResizable(false);


        //Add components here.
        pane = new JPanel();
        pane.setOpaque(false);



        title = new JLabel();
        title.setText("Elige un perfil:");
        title.setFont(new Font("Georgia", Font.PLAIN, 35));
        title.setBorder(BorderFactory.createEmptyBorder(15,30,15,30));


        adminBtn = new JButton("Administración");
        employeeBtn = new JButton("Zona de empleados");
        clientBtn = new JButton("Zona para clientes");
        coockerBtn = new JButton("Oído Cocina");

        //Buttons stiles...
        adminBtn.setBorderPainted(true);
        adminBtn.setPreferredSize(new Dimension(170,60));
        adminBtn.setOpaque(false);
        adminBtn.addActionListener(new openAdminView());

        employeeBtn.setBorderPainted(true);
        employeeBtn.setPreferredSize(new Dimension(170,60));
        employeeBtn.setOpaque(false);
        employeeBtn.addActionListener(new openEmployeeView());


        clientBtn.setBorderPainted(true);
        clientBtn.setPreferredSize(new Dimension(170,60));
        clientBtn.setOpaque(false);
        clientBtn.addActionListener(new openClientView());

        coockerBtn.setBorderPainted(true);
        coockerBtn.setPreferredSize(new Dimension(170,60));
        coockerBtn.setOpaque(false);
        coockerBtn.addActionListener(new openAdminView());

        setContentPane(pane);
        add(title);
        add(adminBtn);
        add(employeeBtn);
        add(clientBtn);
        add(coockerBtn);

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