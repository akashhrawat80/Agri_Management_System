package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Loss extends JFrame implements ActionListener{
    JTable table;
    JButton cancel;
    Loss(){
        this.setTitle("Insurance Company Number");
        String data[][]={
                {"Agriculture Insurance Company","7869899999"},
                {"SBI Insurance Company","1200300400"}
        };
        String column[]={"Company","Number"};
        table=new JTable(data,column);
        table.setBounds(0,20,741,200);
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,20,741,200);
        this.add(sp);

        cancel=new JButton("Back");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(10,280,100,20);
        cancel.addActionListener(this);
        add(cancel);

        this.setLayout(null);
        this.setSize(741,414);
        this.setLocation(50,50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Loss().setVisible(true);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==cancel){
            new DashBoard().setVisible(true);
            this.dispose();
        }
    }
}

