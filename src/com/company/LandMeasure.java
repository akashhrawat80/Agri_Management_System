package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LandMeasure extends JFrame implements ActionListener{

    JLabel l1,l2,b1,b2,a1,a2,result;
    JTextField tl1,tl2,tb1,tb2,ta1,ta2;
    JButton btn,cancel;
    Double area;
    LandMeasure(){
        setTitle("LAND MEASUREMENT");
        Container c=getContentPane();
        l1=new JLabel("Length-1:");
        l1.setBounds(60,50,120,25);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        c.add(l1);

        tl1=new JTextField();
        tl1.setBounds(230,50,120,20);
        c.add(tl1);

        l2=new JLabel("Length-2:");
        l2.setBounds(60,80,120,25);
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        c.add(l2);

        tl2=new JTextField();
        tl2.setBounds(230,80,120,20);
        c.add(tl2);

        b1=new JLabel("Breadth-1:");
        b1.setBounds(60,110,120,20);
        b1.setFont(new Font("Tahoma",Font.BOLD,20));
        c.add(b1);

        tb1=new JTextField();
        tb1.setBounds(230,110,120,20);
        c.add(tb1);

        b2=new JLabel("Breadth-2:");
        b2.setBounds(60,140,120,20);
        b2.setFont(new Font("Tahoma",Font.BOLD,20));
        c.add(b2);

        tb2=new JTextField();
        tb2.setBounds(230,140,120,20);
        c.add(tb2);

        a1=new JLabel("Angle-1:");
        a1.setBounds(60,170,120,25);
        a1.setFont(new Font("Tahoma",Font.BOLD,20));
        c.add(a1);

        ta1=new JTextField();
        ta1.setBounds(230,170,120,20);
        c.add(ta1);

        a2=new JLabel("Angle-1:");
        a2.setBounds(60,200,120,25);
        a2.setFont(new Font("Tahoma",Font.BOLD,20));
        c.add(a2);

        ta2=new JTextField();
        ta2.setBounds(230,200,120,20);
        c.add(ta2);

        btn=new JButton("Calculate");
        btn.setBounds(60,240,120,30);
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.BLACK);
        c.add(btn);

        cancel=new JButton("Cancel");
        cancel.setBounds(600,340,100,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        c.add(cancel);

        result = new JLabel("LAND AREA(acre):");
        result.setBounds(60,300,700,30);
        result.setFont(new Font("Tahoma",Font.BOLD,20));
        c.add(result);

        btn.addActionListener(this);

        c.setBackground(Color.ORANGE);
        this.setBounds(50,50,741,414);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String args[]){
        LandMeasure measure=new LandMeasure();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.dispose();
        } else if (e.getSource() == btn) {
            try {
                Double w = Double.parseDouble(tl1.getText());
                Double x = Double.parseDouble(tl2.getText());
                Double y = Double.parseDouble(tb1.getText());
                Double z = Double.parseDouble(tb2.getText());
                Double p = Double.parseDouble(ta1.getText());
                Double q = Double.parseDouble(ta2.getText());

                p = Math.sin(p);
                q = Math.sin(q);

                area = 0.5 * w * x * p + (0.5 * y * z * q);
                area = 0.000247 * area;
                result.setText("LAND AREA(acre):" + area);
            } catch (NumberFormatException f) {
                result.setText("please fill all the requirements!!");
            } catch (ArithmeticException f1) {
                result.setText("Cannot divide by zero");
            }
        }
    }
}
