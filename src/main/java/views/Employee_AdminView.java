package views;

import models.Person;
import models.PersonType;
import utilities.Employee_Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Employee_AdminView extends JFrame {

    private static final ImageIcon wallpaper = new ImageIcon(getImgRute());
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

    private JPanel paneV;
    private JPanel paneH;

    private JPanel bgImgPane(){
        JPanel panel = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(wallpaper.getImage(), 0, 0, null);
            }
        };
        return panel;
    }

    private static String getImgRute(){
        String rute = new File("src/main/java/assets/Employee_AdminView.png").getAbsolutePath();
        return rute;
    }


    public Employee_AdminView() {

        //Window property.
        super("Gestión de empleados");
        setSize(450, 600);
        setLocationRelativeTo(null);
        setResizable(false);


        //Adding components here.
        JPanel bgPanel = bgImgPane();
        bgPanel.setOpaque(false);

        paneV = new JPanel();
        paneV.setOpaque(false);
        paneV.setLayout(new BoxLayout(paneV,BoxLayout.Y_AXIS));
        paneV.setPreferredSize(new Dimension(350,370));
        paneV.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));

        paneH = new JPanel();
        paneH.setOpaque(false);
        paneH.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        paneH.setPreferredSize(new Dimension(450,300));

        createEmployeeBtn = new JButton("Crear empleado");
        findEmployeeBtn = new JButton("Buscar empleaado");
        modifyEmployeeBtn = new JButton("Modificar datos");
        deleteEmployeeBtn = new JButton("Eliminar empleado");

        //Buttons stiles...
        createEmployeeBtn.setBorderPainted(true);
        createEmployeeBtn.setPreferredSize(new Dimension(170,60));
        createEmployeeBtn.setOpaque(false);
        createEmployeeBtn.setFocusPainted(false);
        createEmployeeBtn.addActionListener(new insertEmployee());

        findEmployeeBtn.setBorderPainted(true);
        findEmployeeBtn.setPreferredSize(new Dimension(170,60));
        findEmployeeBtn.setOpaque(false);
        findEmployeeBtn.setFocusPainted(false);
        findEmployeeBtn.addActionListener(new findEmployee());

        modifyEmployeeBtn.setBorderPainted(true);
        modifyEmployeeBtn.setPreferredSize(new Dimension(170,60));
        modifyEmployeeBtn.setOpaque(false);
        modifyEmployeeBtn.setFocusPainted(false);
        modifyEmployeeBtn.addActionListener(new updateEmployee());

        deleteEmployeeBtn.setBorderPainted(true);
        deleteEmployeeBtn.setPreferredSize(new Dimension(170,60));
        deleteEmployeeBtn.setOpaque(false);
        deleteEmployeeBtn.setFocusPainted(false);
        deleteEmployeeBtn.addActionListener(new deleteEmployee());

        bgPanel.add(paneV);
        bgPanel.add(paneH);

        //Creating tags labels for each input fields.
        idLabel = new JLabel("ID"); idLabel.setForeground(Color.white); paneV.add(idLabel);
        idField = new JTextField(); idField.setPreferredSize(new Dimension(300, 50)); paneV.add(idField);

        nameLabel = new JLabel("Nombre"); nameLabel.setForeground(Color.white); paneV.add(nameLabel);
        nameField = new JTextField(); nameField.setPreferredSize(new Dimension(300, 50)); paneV.add(nameField);

        surnameLabel = new JLabel("Apellidos"); surnameLabel.setForeground(Color.white); paneV.add(surnameLabel);
        surnameField = new JTextField(); surnameField.setPreferredSize(new Dimension(300, 50)); paneV.add(surnameField);

        addressLabel = new JLabel("Dirección postal"); addressLabel.setForeground(Color.white); paneV.add(addressLabel);
        addressField = new JTextField(); addressField.setPreferredSize(new Dimension(300, 50)); paneV.add(addressField);

        phoneLabel = new JLabel("Teléfono"); phoneLabel.setForeground(Color.white); paneV.add(phoneLabel);
        phoneField = new JTextField(); phoneField.setPreferredSize(new Dimension(300, 50)); paneV.add(phoneField);

        dniLabel = new JLabel("DNI"); dniLabel.setForeground(Color.white); paneV.add(dniLabel);
        dniField = new JTextField(); dniField.setPreferredSize(new Dimension(300, 50)); paneV.add(dniField);

        eTypeLabel = new JLabel("Tipo de Empleado"); eTypeLabel.setForeground(Color.white);
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
        setContentPane(bgPanel);

        //No more components.
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    static class insertEmployee implements ActionListener {
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

    static class findEmployee implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int idData = Integer.parseInt(idField.getText());
            String name = Employee_Utilities.getById(idData).getPname();
            nameField.setText(name);
            String surname = Employee_Utilities.getById(idData).getSurname();
            surnameField.setText(surname);
            String address = Employee_Utilities.getById(idData).getAddress();
            addressField.setText(address);
            String phone = String.valueOf(Employee_Utilities.getById(idData).getPhone());
            phoneField.setText(phone);
            String dni = Employee_Utilities.getById(idData).getDni();
            dniField.setText(dni);
            PersonType eType = Employee_Utilities.getById(idData).geteType();
            eTypeCombo.getModel().setSelectedItem(eType);
        }
    }

    static class updateEmployee implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            int idData = Integer.parseInt(idField.getText());
            String nameData = nameField.getText();
            String surnameData = surnameField.getText();
            String addressData = addressField.getText();
            int phoneData = Integer.parseInt(phoneField.getText());
            String dniData = dniField.getText();
            PersonType employeeData = (PersonType) eTypeCombo.getSelectedItem();

            Person person = new Person( idData, nameData, surnameData, addressData, phoneData, dniData, employeeData);

            Employee_Utilities.updateEmployee(person);
        }
    }

    static class deleteEmployee implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int idData = Integer.parseInt(idField.getText());
            Employee_Utilities.deleteEmployee(idData);
        }
    }

}
