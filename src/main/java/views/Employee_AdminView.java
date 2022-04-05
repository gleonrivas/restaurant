package views;

import javax.swing.*;
import java.awt.*;


public class Employee_AdminView extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField dniField;

    private JButton createEmployeeBtn;
    private JButton findEmployeeBtn;
    private JButton modifyEmployeeBtn;
    private JButton deleteEmployeeBtn;

    private JPanel paneV;
    private JPanel paneH;


    public Employee_AdminView() {
        //Window property.
        super("Gestión de empleados");
        setBackground(Color.decode("#e2e2e2"));
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);


        //Add components here.
        paneV.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

        paneH.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));


        createEmployeeBtn = new JButton("Crear empleado");
        findEmployeeBtn = new JButton("Buscar empleaado");
        modifyEmployeeBtn = new JButton("Modificar datos");
        deleteEmployeeBtn = new JButton("Eliminar empleado");

        //Buttons stiles...
        createEmployeeBtn.setBorderPainted(true);
        createEmployeeBtn.setPreferredSize(new Dimension(170,60));
        createEmployeeBtn.setOpaque(false);
        createEmployeeBtn.setFocusPainted(false);

        findEmployeeBtn.setBorderPainted(true);
        findEmployeeBtn.setPreferredSize(new Dimension(170,60));
        findEmployeeBtn.setOpaque(false);
        findEmployeeBtn.setFocusPainted(false);

        modifyEmployeeBtn.setBorderPainted(true);
        modifyEmployeeBtn.setPreferredSize(new Dimension(170,60));
        modifyEmployeeBtn.setOpaque(false);
        modifyEmployeeBtn.setFocusPainted(false);

        deleteEmployeeBtn.setBorderPainted(true);
        deleteEmployeeBtn.setPreferredSize(new Dimension(170,60));
        deleteEmployeeBtn.setOpaque(false);
        deleteEmployeeBtn.setFocusPainted(false);


        paneV.add(idField);
        paneV.add(nameField);
        paneV.add(surnameField);
        paneV.add(addressField);
        paneV.add(phoneField);
        paneV.add(dniField);

        //pane.add(tittle);
        paneH.add(createEmployeeBtn);
        paneH.add(findEmployeeBtn);
        paneH.add(modifyEmployeeBtn);
        paneH.add(deleteEmployeeBtn);

        //No more components.
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
/*
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
    }*/

}
