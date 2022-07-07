package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class Enter_calf extends JFrame implements ActionListener {

    JTextField txt1,txt2;
    JLabel jl1,jl2;
    JButton but1,but2;
    JPasswordField pas1;

    Enter_calf(){
        jl1=new JLabel();
        jl1.setText("USERNAME:");
        jl1.setBounds(20,20,100,20);
        add(jl1);

        jl2=new JLabel();
        jl2.setText("AADHAR CARD:");
        jl2.setBounds(20,50,100,20);
        add(jl2);

        txt1=new JTextField();
        txt1.setBounds(180,20,100,20);
        add(txt1);

        pas1=new JPasswordField();
        pas1.setBounds(180,50,100,20);
        pas1.setEchoChar('#');
        add(pas1);

        but1=new JButton("ENTER");
        but1.setBounds(20,80,80,20);
        but1.setBackground(Color.BLACK);
        but1.setForeground(new Color(255,255,255));
        Cursor c1=new Cursor(Cursor.HAND_CURSOR);
        but1.setCursor(c1);
        add(but1);
        but1.addActionListener(this);

        but2=new JButton("BACK");
        but2.setBounds(180,80,80,20);
        but2.setBackground(Color.BLACK);
        but2.setForeground(new Color(255,255,255));
        Cursor c2=new Cursor(Cursor.HAND_CURSOR);
        but2.setCursor(c2);
        add(but2);
        but2.addActionListener(this);

        ImageIcon img2=new ImageIcon(ClassLoader.getSystemResource("com/company/images/images (26).jpeg"));
        Image I=img2.getImage().getScaledInstance(741,300,Image.SCALE_DEFAULT);
        ImageIcon i=new ImageIcon(I);
        JLabel lim=new JLabel(i);
        lim.setBounds(0,100,741,300);
        add(lim);

        getContentPane().setBackground(new Color(255,255,224));
        setBounds(50,50,741,414);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(new Main());
        setVisible(true);
    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                String str="javax.swing.plaf.nimbus.NimbusLookAndFeel";
                try {
                    UIManager.setLookAndFeel(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Enter_calf e=new Enter_calf();
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==but1) {
            String str=txt1.getText();
            char[] arr=pas1.getPassword();
            String password=new String(arr);
            if(str.equals("") || password.equals("")||(str.equals("") && password.equals(""))) {
                JOptionPane.showMessageDialog(this, "Please Enter username and Password Correctly");
            }else {
                try {
                    Connect con = new Connect();
                    String s = "select * from Enter where username='" + str + "' and password='" + password + "'";
                    ResultSet r = con.st.executeQuery(s);
                    if (r.next()) {//if matches then next page opens else not
                        new Calf_Management().setVisible(true);
                        this.setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(this, "Not Valid!");
                    }
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(this,ee.getMessage());
                }
            }
        }else if(e.getSource()==but2){
            new DashBoard().setVisible(true);
            this.dispose();
        }
    }
}

