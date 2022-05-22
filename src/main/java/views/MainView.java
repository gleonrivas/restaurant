package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainView extends JFrame{

    private static final ImageIcon wallpaper = new ImageIcon(getImgRute());
    private JLabel title;
    private JButton adminBtn;
    private JButton employeeBtn;
    private JButton clientBtn;
    private JButton kitchenBtn;
    private JPanel bgPanel;
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
        String rute = new File("src/main/java/assets/mainView.png").getAbsolutePath();
        return rute;
    }

    public MainView() throws IOException {
        
        //Window property.

        super("Menu principal");
        setSize(400, 280);
        setLocationRelativeTo(null);
        setResizable(false);


        //Add components here.
        JPanel bgPanel = bgImgPane();
        bgPanel.setOpaque(false);



        title = new JLabel();
        title.setText("Restaurante Marianito");
        title.setForeground(Color.white);
        title.setFont(new Font("Georgia", Font.PLAIN, 35));
        title.setBorder(BorderFactory.createEmptyBorder(15,30,15,30));


        adminBtn = new JButton("Administración");
        employeeBtn = new JButton("Zona camarer@s");
        clientBtn = new JButton("Zona para clientes");
        kitchenBtn = new JButton("Oído Cocina");

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

        kitchenBtn.setBorderPainted(true);
        kitchenBtn.setPreferredSize(new Dimension(170,60));
        kitchenBtn.setOpaque(false);
        kitchenBtn.addActionListener(new openKitchenView());

        setContentPane(bgPanel);
        add(title);
        add(adminBtn);
        add(employeeBtn);
        add(clientBtn);
        add(kitchenBtn);

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
            new Menu_ClientView();
        }
    }
    class openKitchenView implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            new KitchenView();
        }
    }

    public static void main(String args[]) throws IOException {
        MainView mainMenu = new MainView();

    }
}