package com.company;

import com.company.loan_types.Fertilizers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class Loan_Apply extends JFrame implements ActionListener,MouseListener {

    JComboBox types,which;
    JRadioButton ra1,ra2;
    JLabel annual,ifyes,status,aly,annual1,total;
    JTextField annual_income,amt,other_annual_income,total_annual_income;
    JButton submit,cancel,apply;
    JPanel p,pane;
    JEditorPane edit;
    JFileChooser file;
    JScrollPane p1;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JTable table;
    Loan_Apply(){
        pane=new JPanel();
        pane.setPreferredSize(new Dimension(741,850));

        c1=new JCheckBox("Tractor Loan");
        c2=new JCheckBox("Combine Harvester");
        c3=new JCheckBox("Power Tiller");
        c4=new JCheckBox("Pump Set(with Tube well)");
        c5=new JCheckBox("Produce Marketing Loan");
        c6=new JCheckBox("Kisan Credit Card");
        c7=new JCheckBox("Assests Backed Loan");
        c1.setBounds(0,23,150,15);
        c2.setBounds(155,23,150,15);
        c3.setBounds(0,38,150,15);
        c4.setBounds(155,38,150,15);
        c5.setBounds(0,53,150,15);
        c6.setBounds(155,53,150,15);
        c7.setBounds(0,68,150,15);
        pane.add(c1);
        pane.add(c2);
        pane.add(c3);
        pane.add(c4);
        pane.add(c5);
        pane.add(c6);
        pane.add(c7);

        cancel=new JButton("back");
        cancel.setBounds(600,0,80,20);
        cancel.addActionListener(this);
        pane.add(cancel);

        JLabel l1=new JLabel("<html><u>LOAN PURPOSE(Select atleast one loan purpose)</u></html>");
        l1.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,15));
        l1.setBounds(0,0,350,20);
        pane.add(l1);

        JLabel type=new JLabel("<html><u>INCOME DETAILS</u></html>");
        type.setFont(new Font("Tahoma",Font.BOLD,10));
        type.setBounds(0,85,120,15);
        pane.add(type);

        annual=new JLabel("Annual Agriculture Income("+"\u20B9"+")");
        annual.setBounds(2,100,180,10);
        pane.add(annual);
        annual_income=new JTextField(100);
        annual_income.setBounds(5,112,150,20);
        pane.add(annual_income);

        annual1=new JLabel("Other annual income,if any("+"\u20B9"+")");
        annual1.setBounds(185,100,220,10);
        pane.add(annual1);
        other_annual_income=new JTextField(100);
        other_annual_income.setBounds(180,112,150,20);
        pane.add(other_annual_income);

        total=new JLabel("Total income("+"\u20B9"+")");
        total.setBounds(360,100,220,10);
        pane.add(total);
        total_annual_income=new JTextField(100);
        total_annual_income.setBounds(355,112,150,20);
        pane.add(total_annual_income);
        total_annual_income.addMouseListener(this);

        table=new JTable();

        apply=new JButton("Submit Application");
        apply.setBounds(300,800,200,20);
        apply.setBackground(Color.BLACK);
        apply.setForeground(Color.WHITE);
        pane.add(apply);
        apply.addActionListener(this);

        pane.setLayout(null);
        p1=new JScrollPane(pane);
        setLayout(new BorderLayout());
        add(p1,BorderLayout.CENTER);

        setBounds(50,50,741,414);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==cancel){
            new Loan().setVisible(true);
            this.dispose();
        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Loan_Apply loan1=new Loan_Apply();
                loan1.setVisible(true);
            }
        });

    }
    @Override
    public void mouseClicked(MouseEvent ae){
        int i=Integer.parseInt(annual_income.getText());
        int j=Integer.parseInt(other_annual_income.getText());
        total_annual_income.setText(String.valueOf(i+j));
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
