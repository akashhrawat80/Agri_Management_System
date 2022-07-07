package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoftwareInfo extends JFrame implements ActionListener {
    JButton b;
    SoftwareInfo(){
        setLayout(new BorderLayout());
        JLabel l=new JLabel();
        l.setText("<html><i>This software is developed by  horizon .Inc</i></html>");
        l.setFont(new Font("Tahoma",Font.ITALIC,30));
        add(l,BorderLayout.CENTER);

        b=new JButton("Back");
        b.addActionListener(this);
        add(b);

        getContentPane().setBackground(Color.GRAY);
        setBounds(50,50,741,414);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        SoftwareInfo info=new SoftwareInfo();
        info.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b){
            new Loan().setVisible(true);
            this.dispose();
        }
    }
}
