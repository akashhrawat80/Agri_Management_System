package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IncludeFarmer extends JFrame implements ActionListener {
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,error,i;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JRadioButton ra1,ra2;
    JComboBox com1,com2;
    Scrollbar com;
    JButton b1,b2,cancel,update;
    ImageIcon ii,ic;
    Image im;
    IncludeFarmer(){

        getContentPane().setBackground(new Color(80,82,68));
        JMenuBar m=new JMenuBar();
        m.setForeground(Color.gray);
        m.setBounds(0,0,741,30);
        add(m);

        l=new JLabel();
        l.setText("Enter Farmer Details Below");
        l.setFont(new Font("Tahoma",Font.BOLD,20));
        l.setBounds(100,0,50,20);
        m.add(l);

        ic=new ImageIcon(ClassLoader.getSystemResource("com/company/images/f2.jpeg"));
        im=ic.getImage().getScaledInstance(741,414,Image.SCALE_DEFAULT);
        ii=new ImageIcon(im);
        i=new JLabel(ii);
        i.setBounds(0,0,741,414);
        add(i);

        l1=new JLabel();
        l1.setText("NAME:");
        l1.setFont(new Font("Tahoma",Font.BOLD,15));
        l1.setForeground(Color.BLACK);
        l1.setBounds(5,50,60,20);
        i.add(l1);

        t1=new JTextField();
        t1.setBounds(180,50,160,20);
        i.add(t1);

        l2=new JLabel();
        l2.setText("AGE:");
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        l2.setBounds(5,80,60,20);
        l2.setForeground(Color.BLACK);
        i.add(l2);

        t2=new JTextField();
        t2.setBounds(180,80,160,20);
        i.add(t2);

        l3=new JLabel();
        l3.setText("ADHAR NUMBER:");
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        l3.setBounds(5,100,150,20);
        l3.setForeground(Color.BLACK);
        i.add(l3);

        t3=new JTextField();
        t3.setBounds(180,100,160,20);
        i.add(t3);

        l4=new JLabel();
        l4.setText("GENDER:");
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        l4.setBounds(5,120,100,20);
        l4.setForeground(Color.BLACK);
        i.add(l4);
        ra1 = new JRadioButton("Male");
        ra1.setBounds(180, 120, 80, 20);
        i.add(ra1);

        ra2 = new JRadioButton("Female");
        ra2.setBounds(260, 120, 80, 20);
        i.add(ra2);

        ButtonGroup bg=new ButtonGroup();
        bg.add(ra1);
        bg.add(ra2);

        l5=new JLabel();
        l5.setText("OCCUPATION:");
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        l5.setBounds(5,140,120,20);
        l5.setForeground(Color.BLACK);
        i.add(l5);

        String str[]={"Agriculture","Government job","Private job","Business","Other"};
        com1=new JComboBox<String>(str);
        com1.setBounds(180,140,160,20);
        i.add(com1);

        l6=new JLabel();
        l6.setText("PHONE:");
        l6.setFont(new Font("Tahoma",Font.BOLD,15));
        l6.setBounds(5,160,60,20);
        l6.setForeground(Color.BLACK);
        i.add(l6);

        t6=new JTextField();
        t6.setBounds(180,160,160,20);
        i.add(t6);

        l7=new JLabel();
        l7.setText("EMAIL:");
        l7.setFont(new Font("Tahoma",Font.BOLD,15));
        l7.setBounds(5,180,120,20);
        l7.setForeground(Color.BLACK);
        i.add(l7);

        t7=new JTextField();
        t7.setBounds(180,180,160,20);
        i.add(t7);

        l8=new JLabel();
        l8.setText("LAND-OWNS(acre):");
        l8.setFont(new Font("Tahoma",Font.BOLD,15));
        l8.setBounds(5,200,190,20);
        l8.setForeground(Color.BLACK);
        i.add(l8);

        t8=new JTextField();
        t8.setBounds(180,200,160,20);
        i.add(t8);

        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(180,240,160,20);
        i.add(b1);
        b1.addActionListener(this);

        b2=new JButton("Next");
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.setBounds(540,360,160,20);
        i.add(b2);
        b2.setEnabled(true);
        b2.addActionListener(this);

        cancel=new JButton("cancel");
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.setBounds(20,360,160,20);
        i.add(cancel);
        cancel.addActionListener(this);

        update=new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(20,240,160,20);
        i.add(update);
        update.addActionListener(this);

        setBounds(50,50,741,414);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==cancel){
            new DashBoard().setVisible(true);
            this.dispose();
        }else if(e.getSource()==b1){
            String name = t1.getText();
            String age = t2.getText();
            String adhar = t3.getText();
            String phone = t6.getText();
            String email = t7.getText();
            String land = t8.getText();
            String gender = null;
            if (ra1.isSelected()) {
                gender = "male";
            } else if (ra2.isSelected()) {
                gender = "female";
            }
            String occupation = (String) com1.getSelectedItem();

            if (Double.parseDouble(land) > 7) {
                JOptionPane.showMessageDialog(null, "NOT ELIGIBLE FOR PENSION");
            } else {
                try {
                    Connect con = new Connect();
                    String str = "insert into farmer values('" + name + "','" + age + "','" + adhar + "','" + gender + "','" + occupation + "','" + phone + "','" + email + "','" + land + "')";
                    con.st.executeUpdate(str);//to insert value in database we use executeUpdate() and executeQuery is to fetch values
                    JOptionPane.showMessageDialog(null, "New Farmer Added");
                    b2.setEnabled(true);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this,exception.getMessage());
                }
            }
        }else if(e.getSource()==b2){
            new Document().setVisible(true);
            this.dispose();
            }
    }
    public static void main(String[] args){
        IncludeFarmer farmer=new IncludeFarmer();
        farmer.setVisible(true);
    }
}
