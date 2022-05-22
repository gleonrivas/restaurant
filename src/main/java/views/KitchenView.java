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
        setSize(600, 500);
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
        componentsArea.setPreferredSize(new Dimension(600, 30));
        componentsArea.setOpaque(false);
        componentsArea.add(new JLabel("Producto"));
        componentsArea.add(new JLabel("Cantidad"));
        bgPanel.add(componentsArea);

        for (Orders order : Kitchen_Utilities.getForKitchen()){
            if (order.getState() == 0){
                JPanel internal = new JPanel();
                internal.setLayout(new FlowLayout(FlowLayout.CENTER));
                internal.setPreferredSize(new Dimension(600, 30));
                internal.setOpaque(false);

                JLabel productName = new JLabel(Product_Utilities.getById(order.getIdProduct()).getName());
                productName.setForeground(Color.WHITE);
                JLabel quantity = new JLabel(String.valueOf(order.getQuantity()));
                quantity.setForeground(Color.WHITE);

                JButton button = new JButton("Marcar completado");
                button.addActionListener(new markAsDone(order));

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
        public markAsDone(Orders order) {
        }

        public void actionPerformed(ActionEvent e) {

        }
    }


}
