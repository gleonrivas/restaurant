package views;

import javax.swing.*;
import java.awt.*;

public class Capacity_EmployeeView {

    public static void main(String[] args) {

        JFrame mimarco = new JFrame();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class Capacity_EmployeeView extends JFrame{
    public Capacity_EmployeeView(){
        setTitle("Aforo");
        setBounds(300,300,400,200);
        JTable aforo = new JTable(datosFila, nombreColumna);
        add(new JScrollPane(aforo), BorderLayout.CENTER);
    }

    private String [] nombreColumna = {"Nº Mesa", "Disposición", ""};
    private Object [] [] datosFila = {};

}


