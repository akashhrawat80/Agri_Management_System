package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IncludeAuthority extends JFrame implements ActionListener {
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t6,t7,t8;
    JRadioButton ra1,ra2;
    JComboBox com1;
    JButton b1,b2,cancel;
    IncludeAuthority(){

        getContentPane().setBackground(Color.WHITE);
        JMenuBar m=new JMenuBar();
        m.setForeground(Color.GRAY);
        m.setBounds(0,0,741,30);
        add(m);

        l=new JLabel();
        l.setText("<Enter Authority Details Below>");
        l.setFont(new Font("Tahoma",Font.BOLD,20));
        l.setBounds(50,0,50,20);
        m.add(l);

        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("com/company/images/iamfarmer.jpg"));
        Image im=ic.getImage().getScaledInstance(741,414,Image.SCALE_DEFAULT);
        ImageIcon ii=new ImageIcon(im);
        JLabel i=new JLabel(ii);
        i.setBounds(350,0,381,414);
        add(i);

        l1=new JLabel();
        l1.setText("NAME:");
        l1.setFont(new Font("Tahoma",Font.BOLD,15));
        l1.setForeground(Color.BLACK);
        l1.setBounds(5,50,60,20);
        add(l1);

        t1=new JTextField();
        t1.setBounds(180,50,160,20);
        add(t1);

        l2=new JLabel();
        l2.setText("AGE:");
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        l2.setBounds(5,70,60,20);
        l2.setForeground(Color.BLACK);
        add(l2);

        t2=new JTextField();
        t2.setBounds(180,70,160,20);
        add(t2);

        l3=new JLabel();
        l3.setText("ADHAR NUMBER:");
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        l3.setBounds(5,90,150,20);
        l3.setForeground(Color.BLACK);
        add(l3);

        t3=new JTextField();
        t3.setBounds(180,90,160,20);
        add(t3);

        l4=new JLabel();
        l4.setText("GENDER:");
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        l4.setBounds(5,110,100,20);
        l4.setForeground(Color.BLACK);
        add(l4);
        ra1 = new JRadioButton("Male");
        ra1.setBounds(180, 110, 80, 20);
        add(ra1);

        ra2 = new JRadioButton("Female");
        ra2.setBounds(260, 110, 80, 20);
        add(ra2);

        ButtonGroup bg=new ButtonGroup();
        bg.add(ra1);
        bg.add(ra2);

        l5=new JLabel();
        l5.setText("DESIGNATION:");
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        l5.setBounds(5,130,120,20);
        l5.setForeground(Color.BLACK);
        add(l5);

        String[] str={"Grievnece Officer","Manager","Clerk","Sweeper"};
        com1=new JComboBox<>(str);
        com1.setBounds(180,130,160,20);
        add(com1);

        l6=new JLabel();
        l6.setText("PHONE:");
        l6.setFont(new Font("Tahoma",Font.BOLD,15));
        l6.setBounds(5,150,60,20);
        l6.setForeground(Color.BLACK);
        add(l6);

        t6=new JTextField();
        t6.setBounds(180,150,160,20);
        add(t6);

        l7=new JLabel();
        l7.setText("EMAIL:");
        l7.setFont(new Font("Tahoma",Font.BOLD,15));
        l7.setBounds(5,170,120,20);
        l7.setForeground(Color.BLACK);
        add(l7);

        t7=new JTextField();
        t7.setBounds(180,170,160,20);
        add(t7);

        l8=new JLabel();
        l8.setText("IN_STATUS");
        l8.setFont(new Font("Tahoma",Font.BOLD,15));
        l8.setBounds(5,190,190,20);
        l8.setForeground(Color.BLACK);
        add(l8);

        t8=new JTextField();
        t8.setBounds(180,190,160,20);
        add(t8);

        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(180,230,160,20);
        add(b1);
        b1.addActionListener(this);

        cancel=new JButton("cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(180,300,160,20);
        add(cancel);
        cancel.addActionListener(this);

        setBounds(50,50,741,414);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==cancel){
            new Category().setVisible(true);
            this.dispose();
        }else if(e.getSource()==b1){
            String name = t1.getText();
            String age = t2.getText();
            String adhar = t3.getText();
            String phone = t6.getText();
            String email = t7.getText();
            String in_status = t8.getText();

            String gender = null;
            if (ra1.isSelected()) {
                gender = "male";
            } else if (ra2.isSelected()) {
                gender = "female";
            }
            String Designation = (String) com1.getSelectedItem();

                try {
                    Connect con = new Connect();
                    String str = "insert into authority values('" + name + "','" + age + "','" + adhar + "','" + gender + "','" + Designation + "','" + phone + "','" + email + "','" + in_status + "')";
                    con.st.executeUpdate(str);//to insert value in database we use executeUpdate() and executeQuery is to fetch values
                    JOptionPane.showMessageDialog(null, "New Authority Added");
                    b2.setEnabled(true);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this,exception.getMessage());
                }
            }
        }

    public static void main(String[] args){
        IncludeAuthority auth=new IncludeAuthority();
        auth.setVisible(true);
    }
}
