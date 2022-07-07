package com.company;

import javax.swing.*;
import java.awt.*;

public class Welcome_Page extends JFrame {
    JButton b;
    Welcome_Page(){
                setBounds(50,50,841,514);
                setBackground(Color.PINK);
                Welcome_Cattle w=new Welcome_Cattle();
                JPanel p=new JPanel();
                p.setBounds(0,0,500,300);
                add(w);

                b=new JButton("NEXT");
                b.setBounds(700,400,70,20);
                //b.addActionListener(w);
               // add(b);
                //setLayout(null);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String args[]){
        new Welcome_Page();
    }
}
