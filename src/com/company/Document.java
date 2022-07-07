package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Document extends JFrame implements ActionListener{
    JFileChooser file;
    JLabel head;
    JButton cancel;
    Document(){
        head=new JLabel("ADD DOCUMENTs");
        head.setFont(new Font("Tahoma",Font.BOLD,20));
        head.setBounds(250,5,300,30);
        add(head);

//FileChooser.............................................................

        cancel=new JButton("back");
        cancel.setBounds(0,0,100,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setBounds(50,50,741,414);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]){
        Document doc=new Document();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancel){
            new IncludeFarmer().setVisible(true);
            this.dispose();
        }
    }
}
