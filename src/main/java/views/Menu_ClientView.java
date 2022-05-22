package views;

import models.Product;
import models.ProductType;
import utilities.Product_Utilities;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Menu_ClientView extends JFrame {

    private JPanel pane0;
    private JPanel pane1;
    private JLabel title;


    public Menu_ClientView(){

        super("A la Carta");
        setSize(400, 680);
        setLocationRelativeTo(null);

        pane0 = new JPanel();
        pane1 = new JPanel();
        title = new JLabel("Menú a la carta");


        pane0.setBackground(Color.WHITE);

        pane0.add(pane1);
        pane1.add(title);

        pane1.setOpaque(false);

        pane1.setLayout(new BoxLayout(pane1,BoxLayout.Y_AXIS));


        title.setFont(new Font("Georgia", Font.PLAIN, 35));
        title.setBorder(BorderFactory.createEmptyBorder(25, 0,25,0));


        List<Product> productList = Product_Utilities.getAll();
        Map<ProductType, List<Product>> productsMap = productList.stream().collect(Collectors.groupingBy(Product::getProductType));

        for (ProductType o : productsMap.keySet()){

            JLabel x = new JLabel(o.toString());
            x.setFont(new Font("Arial", Font.BOLD, 15));
            pane1.add(x);

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
            table.setBackground(Color.WHITE);
            pane1.add(table);

        }


        setContentPane(pane0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
