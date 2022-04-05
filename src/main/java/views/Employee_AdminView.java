package views;

import javax.swing.*;
import java.awt.*;


public class Employee_AdminView extends JFrame {

    private JLabel idLabel;
    private JTextField idField;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel surnameLabel;
    private JTextField surnameField;
    private JLabel addressLabel;
    private JTextField addressField;
    private JLabel phoneLabel;
    private JTextField phoneField;
    private JLabel dniLabel;
    private JTextField dniField;

    private JButton createEmployeeBtn;
    private JButton findEmployeeBtn;
    private JButton modifyEmployeeBtn;
    private JButton deleteEmployeeBtn;

    private JPanel pane;
    private JPanel paneV;
    private JPanel paneH;


    public Employee_AdminView() {

        //Window property.
        super("Gestión de empleados");
        setSize(450, 530);
        setLocationRelativeTo(null);
        setResizable(false);


        //Adding components here.
        pane = new JPanel();
        pane.setOpaque(false);

        paneV = new JPanel();
        paneV.setLayout(new BoxLayout(paneV,BoxLayout.Y_AXIS));
        paneV.setPreferredSize(new Dimension(300,300));
        paneV.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));

        paneH = new JPanel();
        paneH.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        paneH.setPreferredSize(new Dimension(500,400));

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

        pane.add(paneV);
        pane.add(paneH);

        //Creating tags labels for each input fields.
        idLabel = new JLabel("ID");
        nameLabel = new JLabel("Nombre");
        surnameLabel = new JLabel("Apellidos");
        addressLabel = new JLabel("Dirección postal");
        phoneLabel = new JLabel("Teléfono");
        dniLabel = new JLabel("DNI");


        //Creating and styling input fields
        idField = new JTextField(); idField.setPreferredSize(new Dimension(300, 50));
        paneV.add(idLabel);paneV.add(idField);
        nameField = new JTextField(); nameField.setPreferredSize(new Dimension(300, 50));
        paneV.add(nameLabel);paneV.add(nameField);
        surnameField = new JTextField(); surnameField.setPreferredSize(new Dimension(300, 50));
        paneV.add(surnameLabel);paneV.add(surnameField);
        addressField = new JTextField(); addressField.setPreferredSize(new Dimension(300, 50));
        paneV.add(addressLabel);paneV.add(addressField);
        phoneField = new JTextField(); phoneField.setPreferredSize(new Dimension(300, 50));
        paneV.add(phoneLabel);paneV.add(phoneField);
        dniField = new JTextField(); dniField.setPreferredSize(new Dimension(300, 50));
        paneV.add(dniLabel);paneV.add(dniField);

        paneH.add(createEmployeeBtn);
        paneH.add(findEmployeeBtn);
        paneH.add(modifyEmployeeBtn);
        paneH.add(deleteEmployeeBtn);
        setContentPane(pane);

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
