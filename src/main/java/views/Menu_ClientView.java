package views;

import models.Product;
import models.ProductType;
import utilities.Product_Utilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Menu_ClientView extends JFrame {

    private JPanel pane0;
    private JPanel pane1;
    private JLabel title;
    private JScrollPane slider;


    public Menu_ClientView(){

        super("A la Carta");
        setSize(800, 500);
        setLocationRelativeTo(null);

        pane0 = new JPanel();
        pane1 = new JPanel();
        slider = new JScrollPane(new JTextArea());
        title = new JLabel("Menú a la carta");

        pane0.setBackground(Color.cyan);
        pane1.setBackground(Color.blue);
        slider.setBackground(Color.yellow);
        title.setBackground(Color.red);

        pane0.add(pane1);
        pane1.add(title);

        pane1.setLayout(new BoxLayout(pane1,BoxLayout.Y_AXIS));


        title.setFont(new Font("Georgia", Font.PLAIN, 35));
        title.setBorder(BorderFactory.createEmptyBorder(40, 35,0,0));
        title.setOpaque(false);


        List<Product> productList = Product_Utilities.getAll();
        Map<ProductType, List<Product>> productsMap = productList.stream().collect(Collectors.groupingBy(Product::getProductType));

        for (ProductType o : productsMap.keySet()){

            pane1.add(new JLabel(o.toString()));

            String [] columNames = {"", ""};
            Object [][] dataRows = new Object[productsMap.get(o).size()][2];

            int row = 0;

            for (Product p : productsMap.get(o))
                if (p.getProductType().equals(o)){

                    dataRows[row][0] = p.getName();
                    dataRows[row][1]= p.getPrice() + " €";

                    row++;
                }
            JTable table = new JTable(dataRows, columNames);
            table.setOpaque(false);
            pane1.add(table);

        }

        JTable menuContent = new JTable();

        setContentPane(pane0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
