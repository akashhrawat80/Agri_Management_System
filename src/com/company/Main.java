package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{
    JButton btn1,exit;
    JLabel lab,copyright;
    Main(){
        this.setBounds(50,50,741,414);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("com/company/images/images (25).jpeg"));
        JLabel l1=new JLabel(img1);
        l1.setBounds(0,0,741,414);
        add(l1);

        JLabel l2=new JLabel("AGRI MANAGEMENT SYSTEM");
        l2.setBounds(350,10,390,20);
        Font f1=new Font("serif",Font.BOLD,25);
        l2.setFont(f1);
        l2.setForeground(Color.WHITE);
        l1.add(l2);

        btn1=new JButton("NEXT");
        btn1.setFont(new Font("serif",Font.BOLD,15));
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(new Color(255,255,255));
        btn1.setBounds(610,285,100,20);
        l1.add(btn1);
        btn1.addActionListener(this);

        exit=new JButton("EXIT");
        exit.setFont(new Font("serif",Font.BOLD,15));
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setBounds(30,285,100,20);
        l1.add(exit);
        exit.addActionListener(this);

        lab=new JLabel("JAI JAWAN JAI KISAN");
        lab.setBounds(0,5,500,30);
        lab.setFont(new Font("serif",Font.TRUETYPE_FONT,30));
        lab.setForeground(Color.BLUE);
        l1.add(lab);
        copyright=new JLabel("<html>Version v. 1.0<br>Copyright 2021,Horizon.Inc<br>All Rights Reserved</html>");
        copyright.setBounds(610,300,120,80);
        copyright.setFont(new Font("charlesworth",Font.BOLD,10));
        copyright.setForeground(Color.BLACK);
        l1.add(copyright);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        //.........................................................................
       /* while(true){
            l2.setVisible(false);
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
            l2.setVisible(true);
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
        }
        *///..........................................................................
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn1){
            new DashBoard().setVisible(true);
            this.dispose();
        }else if(e.getSource()==exit){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });


    }
}
