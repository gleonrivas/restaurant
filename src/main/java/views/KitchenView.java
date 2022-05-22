package views;

import models.Orders;
import utilities.Kitchen_Utilities;
import utilities.Product_Utilities;

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
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel bgPanel = bgImgPane();
        bgPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        title = new JLabel("Comandas a preparar:");

        title.setFont(new Font("Georgia",Font.PLAIN, 30));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));


        setContentPane(bgPanel);
        bgPanel.add(title);

        componentsArea = new JPanel();
        componentsArea.setLayout(new FlowLayout(FlowLayout.CENTER));
        componentsArea.setPreferredSize(new Dimension(600, 50));
        componentsArea.setOpaque(false);
        JLabel prct = new JLabel("Producto       ");
        prct.setFont(new Font("Arial", Font.BOLD, 15));
        prct.setForeground(Color.white);
        JLabel cant = new JLabel("Cantidad                                       ");
        cant.setForeground(Color.yellow);
        cant.setFont(new Font("Arial", Font.BOLD, 15));
        componentsArea.add(prct);
        componentsArea.add(cant);
        bgPanel.add(componentsArea);

        for (Orders order : Kitchen_Utilities.getForKitchen()){
            if (order.getState() == 0){
                JPanel internal = new JPanel();
                internal.setBorder(BorderFactory.createEmptyBorder(0, 100, 0 ,0));
                internal.setLayout(new FlowLayout(FlowLayout.LEFT));
                internal.setPreferredSize(new Dimension(600, 30));
                internal.setOpaque(false);

                JLabel productName = new JLabel(Product_Utilities.getById(order.getIdProduct()).getName() + "   ");
                productName.setForeground(Color.WHITE);
                JLabel quantity = new JLabel(String.valueOf(order.getQuantity()) + "  -->  ");
                quantity.setFont(new Font("Arial", Font.BOLD, 15));
                quantity.setForeground(Color.yellow);

                JButton button = new JButton("Marcar hecho");
                //button.addActionListener(Kitchen_Utilities.modifyState(order));

                internal.add(productName);
                internal.add(quantity);
                internal.add(button);

                bgPanel.add(internal);
            }
        }

        //No more components.
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    class markAsDone implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }


}
