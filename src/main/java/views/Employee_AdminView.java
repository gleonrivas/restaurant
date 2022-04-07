package views;

import models.Person;
import models.PersonType;
import utilities.Employee_Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class Employee_AdminView extends JFrame {

    private JLabel idLabel;
    private static JTextField idField;
    private JLabel nameLabel;
    private static JTextField nameField;
    private JLabel surnameLabel;
    private static JTextField surnameField;
    private JLabel addressLabel;
    private static JTextField addressField;
    private JLabel phoneLabel;
    private static JTextField phoneField;
    private JLabel dniLabel;
    private static JTextField dniField;
    private JLabel eTypeLabel;
    private static JComboBox eTypeCombo;

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
        setSize(450, 560);
        setLocationRelativeTo(null);
        setResizable(false);


        //Adding components here.
        pane = new JPanel();
        pane.setOpaque(false);

        paneV = new JPanel();
        paneV.setLayout(new BoxLayout(paneV,BoxLayout.Y_AXIS));
        paneV.setPreferredSize(new Dimension(400,350));
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
        createEmployeeBtn.addActionListener(new insertData());

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
        eTypeLabel = new JLabel("Tipo de Empleado");


        //Creating and styling input fields
        idField = new JTextField(); idField.setPreferredSize(new Dimension(400, 50));
        paneV.add(idLabel);paneV.add(idField);

        nameField = new JTextField(); nameField.setPreferredSize(new Dimension(400, 50));
        paneV.add(nameLabel);paneV.add(nameField);

        surnameField = new JTextField(); surnameField.setPreferredSize(new Dimension(400, 50));
        paneV.add(surnameLabel);paneV.add(surnameField);

        addressField = new JTextField(); addressField.setPreferredSize(new Dimension(300, 50));
        paneV.add(addressLabel);paneV.add(addressField);

        phoneField = new JTextField(); phoneField.setPreferredSize(new Dimension(300, 50));
        paneV.add(phoneLabel);paneV.add(phoneField);

        dniField = new JTextField(); dniField.setPreferredSize(new Dimension(300, 50));
        paneV.add(dniLabel);paneV.add(dniField);

        eTypeCombo = new JComboBox<>();
        paneV.add(eTypeLabel);
        for (PersonType i : PersonType.values()){
            eTypeCombo.addItem(i);
        }
        paneV.add(eTypeCombo);


        paneH.add(createEmployeeBtn);
        paneH.add(findEmployeeBtn);
        paneH.add(modifyEmployeeBtn);
        paneH.add(deleteEmployeeBtn);
        setContentPane(pane);

        //No more components.
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    static class insertData implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            int idData = Integer.parseInt(idField.getText());
            String nameData = nameField.getText();
            String surnameData = surnameField.getText();
            String addressData = addressField.getText();
            int phoneData = Integer.parseInt(phoneField.getText());
            String dniData = dniField.getText();
            PersonType employeeData = (PersonType) eTypeCombo.getSelectedItem();

            Person person = new Person( idData, nameData, surnameData, addressData, phoneData, dniData, employeeData);

            Employee_Utilities.createEmployee(person);
        }
    }

    /*static class findData implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new Employee_Utilities.;
        }
    }

    /*class openClientView implements ActionListener {
        public void actionPerformed(ActionEvent i) {
            new ClientView();
        }
    }*/

}
