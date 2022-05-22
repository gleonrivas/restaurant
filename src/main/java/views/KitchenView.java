package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class KitchenView extends JFrame{

    private static final ImageIcon wallpaper = new ImageIcon(getImgRute());
    private JLabel title;
    private JPanel componentsArea;
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
        String rute = new File("src/main/java/assets/mainview.png").getAbsolutePath();
        return rute;
    }


    public KitchenView(){

        super("Cocina");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel bgPanel = bgImgPane();
        bgPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        componentsArea = new JPanel();
        componentsArea.setLayout(new FlowLayout(FlowLayout.CENTER));

        title = new JLabel("Cocinero, cocinerooo!");

        title.setFont(new Font("Georgia",Font.PLAIN, 30));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));


        setContentPane(bgPanel);
        componentsArea.setOpaque(false);
        bgPanel.add(title);
        bgPanel.add(componentsArea);

        //No more components.
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    class markAsDone implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new Orders_EmployeeView();
        }
    }


}
