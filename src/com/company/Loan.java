package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loan extends JFrame implements ActionListener {

    JComboBox types,which;
    JRadioButton ra3,ra4;
    JLabel ifyes,account_no,phone_no;
    JTextField other_bank,account_no_input,phone;
    JButton submit,cancel,check,next;
    JPanel p,pane;
    JEditorPane edit;
    JScrollPane p1;
    JCheckBox consent;
    Loan(){
        pane=new JPanel();
        pane.setPreferredSize(new Dimension(741,414));

        JLabel l1=new JLabel("<html><u>EXISTING LOAN</u></html>");
        l1.setBounds(0,0,350,35);
        pane.add(l1);
        ra3=new JRadioButton("Yes");
        ra3.setBounds(0,30,100,30);
        ra3.addActionListener(this);
        pane.add(ra3);

        ra4=new JRadioButton("No");
        ra4.setBounds(100,30,100,30);
        ra4.addActionListener(this);
        pane.add(ra4);

        ButtonGroup bg1=new ButtonGroup();
        bg1.add(ra3);
        bg1.add(ra4);

        JLabel type=new JLabel("Type of Loan");
        type.setBounds(60,85,200,35);
        pane.add(type);

        String[] str={"Daily Operations","Fertilizers","Buying Farm Machinery","Purchasing Lands","Storage Purposes","Product Marketing","Expansion","Subsidies","Grants"};
        types=new JComboBox(str);
        types.setBounds(230,85,200,20);
        types.addActionListener(this);
        pane.add(types);

        phone_no=new JLabel("Enter phone number");
        phone_no.setBounds(60,110,200,35);
        pane.add(phone_no);

        phone=new JTextField("+91");
        phone.setBounds(230,115,180,20);
        pane.add(phone);

        ifyes=new JLabel("BANK");
        ifyes.setBounds(60,140,200,35);
        pane.add(ifyes);

        String[] str1={"","SBI","PNB","GRAMIN","Cooperative","ICICI","other"};
        which=new JComboBox(str1);
        which.setBounds(230,140,150,25);
        pane.add(which);

        JLabel amount=new JLabel("<html>Please specify,<br> if other</html>");
        amount.setBounds(60,170,120,35);
        pane.add(amount);

        other_bank=new JTextField("null");
        other_bank.setBounds(230,180,200,25);
        pane.add(other_bank);

        account_no=new JLabel("ACCOUNT NO.");
        account_no.setBounds(60,205,120,35);
        pane.add(account_no);

        account_no_input=new JTextField();
        account_no_input.setBounds(230,210,200,25);
        pane.add(account_no_input);

        p=new JPanel();
        JScrollPane scroll=new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(439,0,285,375);
        pane.add(scroll);

        edit=new JEditorPane();
        edit.setContentType("text/plain");
        edit.setText("LOAN"
        +"INFO");
        edit.setEditable(true);
        p.add(edit);

        consent=new JCheckBox("<html>I hereby authorize the respective bank and/or its<br>representative to call me,email me,or " +
                "SMS me with<br>reference to my loan application.This consent will<br>superside any registration for any Do Not Call(DNC)<br>" +
                "/National Do Not Call(NDNC).*</html>");
        consent.setBounds(40,260,400,80);
        consent.addActionListener(this);
        pane.add(consent);

        check=new JButton("check");
        check.setBounds(230,350,120,20);
        pane.add(check);
        check.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBounds(60,350,120,20);
        pane.add(cancel);
        cancel.addActionListener(this);

        submit=new JButton("SUBMIT");
        submit.setBounds(60,380,150,20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        pane.add(submit);
        submit.addActionListener(this);

        next=new JButton("NEXT");
        next.setBounds(210,380,150,20);
        next.setBackground(Color.BLACK.darker());
        next.setForeground(Color.WHITE);
        next.setEnabled(false);
        pane.add(next);
        next.addActionListener(this);

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
        String s=(String) types.getSelectedItem();
        if(consent.isSelected()){
            submit.setEnabled(true);
        }
        if(e.getSource()==check) {
            if (s == "Daily Operations") {
                edit.setText("Daily Operations loan");
            } else if (s == "Fertilizers") {
                edit.setText("fertilizer loan");
            } else if (s == "Buying Farm Machinery") {
                edit.setText("Machinery loan");
            } else if (s == "Purchasing Lands") {
                edit.setText("Purchasing lands loan");
            } else if (s == "Storage Purposes") {
                edit.setText("Storage Purposes loan");
            } else if (s == "Product Marketing") {
                edit.setText("Product Marketing loan");
            } else if (s == "Expansion") {
                edit.setText("Expansion loan");
            } else if (s == "Subsidies") {
                edit.setText("Subsidies loan");
            } else if(s=="Grants"){
                edit.setText("Grants loan");
            }
        }else if(e.getSource()==cancel){
            new DashBoard().setVisible(true);
            this.setVisible(false);
        }
        if(ra4.isSelected()){
            phone.setEnabled(true);
            account_no_input.setEnabled(true);
            types.setEnabled(true);
            which.setEnabled(true);
            check.setEnabled(true);
            other_bank.setEnabled(true);
            submit.setEnabled(true);
            next.setEnabled(true);
            consent.setSelected(true);
        }else if(ra3.isSelected()) {
            phone.setEnabled(false);
            account_no_input.setEnabled(false);
            types.setEnabled(false);
            which.setEnabled(false);
            check.setEnabled(false);
            other_bank.setEnabled(false);
            submit.setEnabled(false);
            next.setEnabled(true);
            consent.setSelected(false);
        }
        if(e.getSource()==submit){
            try {
                String loan_type=(String)types.getSelectedItem();
                String phone1=phone.getText();
                String which1=(String)which.getSelectedItem();
                String other_bank1=other_bank.getText();
                String acc=account_no_input.getText();

                Connect con = new Connect();
                //create table Loan
                String str="insert into Loan values('"+loan_type+"','"+phone1+"','"+which1+"','"+other_bank1+"','"+acc+"')";
                con.st.executeUpdate(str);
            }catch(Exception exception){
                JOptionPane.showMessageDialog(this,exception.getMessage());
            }
        }else if(e.getSource()==next) {
            new Loan_Apply().setVisible(true);
            this.dispose();
        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Loan loan=new Loan();
                loan.setVisible(true);
            }
        });

    }
}
