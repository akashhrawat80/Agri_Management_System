package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,cancel;
    DashBoard(){
        b1=new JButton("Home");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(10,10,200,20);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Admin");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(10,40,200,20);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("New Registration");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(10,70,200,20);
        b3.addActionListener(this);
        add(b3);

        b4=new JButton("Authorities Info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(10,100,200,20);
        b4.addActionListener(this);
        add(b4);

        b5=new JButton("Cards");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(10,130,200,20);
        b5.addActionListener(this);
        add(b5);

        b6=new JButton("Loans");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(10,160,200,20);
        b6.addActionListener(this);
        add(b6);

        b7=new JButton("Insurance");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(10,190,200,20);
        b7.addActionListener(this);
        add(b7);

        b8=new JButton("Crop Loss");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setBounds(10,220,200,20);
        b8.addActionListener(this);
        add(b8);

        b9=new JButton("Farmer Info");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setBounds(10,250,200,20);
        b9.addActionListener(this);
        add(b9);

        b10=new JButton("Schemes");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.setBounds(10,280,200,20);
        b10.addActionListener(this);
        add(b10);

        b11=new JButton("Help");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.setBounds(10,310,200,20);
        b11.addActionListener(this);
        add(b11);

        b12=new JButton("Cow Management");
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.setBounds(10,340,200,20);
        b12.addActionListener(this);
        add(b12);

        cancel=new JButton("Back");
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.setBounds(340,420,100,20);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("com/company/images/side.jpg"));
        Image i=icon.getImage().getScaledInstance(500,414,Image.SCALE_DEFAULT);
        ImageIcon ic=new ImageIcon(i);
        JLabel img=new JLabel(ic);
        img.setBounds(220,0,500,414);
        add(img);
        //getContentPane().setBackground(Color.GRAY.darker());

        setBounds(50,50,741,414);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]){
        DashBoard dash=new DashBoard();
        dash.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            new Main().setVisible(true);
            this.dispose();
        }else if(e.getSource()==b2){
            new Enter().setVisible(true);
            this.dispose();
        }else if(e.getSource()==b3){
            new IncludeFarmer().setVisible(true);
            this.dispose();
        }else if(e.getSource()==b4){
            new AuthoritiesInfo().setVisible(true);
            this.dispose();
        }else if(e.getSource()==b5){
            new KisanCreditCard().setVisible(true);
            this.dispose();
        }else if(e.getSource()==b6){
            new Loan().setVisible(true);
            this.dispose();
        }else if(e.getSource()==b7){
            new Insurance().setVisible(true);
            this.dispose();
        }else if(e.getSource()==b8){
            new Loss().setVisible(true);
        }else if(e.getSource()==b9){
            new FarmerInfo().setVisible(true);
            this.dispose();
        }else if(e.getSource()==b10){
            new Schemes().setVisible(true);
            //this.dispose();
        }else if(e.getSource()==b11){
            new Helpline().setVisible(true);
        }else if(e.getSource()==b12) {
            new Calf_Management().setVisible(true);
            this.dispose();
        }else if(e.getSource()==cancel){
            new Main().setVisible(true);
            this.dispose();
        }
    }
}
