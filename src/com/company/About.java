package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    JButton b;
    About(){
        setLayout(new BorderLayout());
        JLabel l=new JLabel();
        l.setText("<html><i>This software is developed by  horizon .Inc</i></html>");
        l.setFont(new Font("Tahoma",Font.ITALIC,30));
        add(l,BorderLayout.CENTER);

        b=new JButton("Back");
        b.addActionListener(this);
        add(b,BorderLayout.SOUTH);

        getContentPane().setBackground(Color.GRAY);
        setBounds(50,50,741,414);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        while(true){
            l.setVisible(false);
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
            l.setVisible(true);
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
        }
        */


    }
    public static void main(String args[]){
        new About();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b){
            new Category().setVisible(true);
            this.dispose();
        }
    }
}
