package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientView{

    private JButton productMenuBtn;
    private Container pane;

    public ClientView(){

        JFrame frame = new JFrame("Zona cliente");
        frame.setBackground(Color.decode("#e2e2e2"));
        frame.setSize(220, 120);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


        //Add components here.
        pane = frame.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        productMenuBtn = new JButton("Carta");

        //Buttons stiles...
        productMenuBtn.setBorderPainted(true);
        productMenuBtn.setPreferredSize(new Dimension(170,60));
        productMenuBtn.setOpaque(false);
        productMenuBtn.setFocusPainted(false);
        productMenuBtn.addActionListener(new openMenuClientView());

        //pane.add(tittle);
        pane.add(productMenuBtn);

        //No more components.
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    class openMenuClientView implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            new Menu_ClientView();
        }
    }

}