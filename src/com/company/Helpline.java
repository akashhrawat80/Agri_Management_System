package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Helpline extends JFrame implements ActionListener {
    JButton cancel;
    JTextArea area;
    JScrollPane scroll;
    JScrollBar sbar;
    JTabbedPane tab;
    Helpline(){
        setLayout(null);
        setTitle("HELPLINE");
        tab=new JTabbedPane();
        tab.setBounds(0,0,741,350);

        JPanel a=new JPanel();
        JPanel a1=new JPanel();
        JPanel a2=new JPanel();
        JPanel a3=new JPanel();

        a.add(new JLabel("Phone/Whatsapp/Email"));
        a1.add(new JLabel("Address/Location"));
        a2.add(new JLabel("Privacy Policy"));
        a3.add(new JLabel("Terms of use"));

        tab.add("Phone/Whatsapp/Email",a);
        tab.add("Address/Location",a1);
        tab.add("Privacy Policy",a2);
        tab.add("Terms of use",a3);
        add(tab);

        cancel=new JButton("Cancel");
        cancel.setBounds(300,350,100,20);
        add(cancel);
        cancel.addActionListener(this);

        Container c=getContentPane();
        c.setBackground(Color.DARK_GRAY);
        setBounds(50,50,741,414);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String args[]){
        Helpline helpline=new Helpline();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.setVisible(false);
        }
    }
}
