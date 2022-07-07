package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class AuthoritiesInfo extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7,l8;
    JTable table;
    JButton b1, b2;

    AuthoritiesInfo() {
        table = new JTable();
        table.setBounds(25, 60, 680, 200);
        add(table);

        l1=new JLabel("Name");
        l1.setBounds(25,40,50,10);
        add(l1);

        l2=new JLabel("Age");
        l2.setBounds(110,40,70,10);
        add(l2);

        l3=new JLabel("Adhar");
        l3.setBounds(195,40,70,10);
        add(l3);

        l4=new JLabel("Gender");
        l4.setBounds(280,40,70,10);
        add(l4);

        l5=new JLabel("Designation");
        l5.setBounds(365,40,70,10);
        add(l5);

        l6=new JLabel("Phone");
        l6.setBounds(450,40,70,10);
        add(l6);

        l7=new JLabel("Email");
        l7.setBounds(535,40,70,10);
        add(l7);

        l8=new JLabel("In status");
        l8.setBounds(620,40,70,10);
        add(l8);

        b1=new JButton("Show data");
        b1.setBounds(380,350,120,20);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBounds(250,350,120,20);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        this.setTitle("Authorities Information");
        getContentPane().setBackground(Color.WHITE);
        setBounds(50, 50, 741, 414);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/company/images/iamfarmer.jpg"));
        setIconImage(icon.getImage());
        setLayout(null);
        setVisible(true);
    }
    public static void main(String args[])
    {
        AuthoritiesInfo info = new AuthoritiesInfo();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1){
            try{
                Connect c=new Connect();
                String str="Select * from authority";
                ResultSet rs=c.st.executeQuery(str);

                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }else if(e.getSource()==b2){
            new DashBoard().setVisible(true);
            this.dispose();
        }
    }
}
