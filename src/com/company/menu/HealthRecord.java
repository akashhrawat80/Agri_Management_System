package com.company.menu;
import com.company.Calf_Management;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;
import java.util.Vector;

public class HealthRecord extends JFrame implements ActionListener {
    JPanel p1;
    Vector comboHealth,comboTreatment,comboShotLocation,comboShotType,comboAdministrator,comboUnits;
    DefaultComboBoxModel<String> model,model1,model2,model3,model44,model5;
    BufferedWriter file;
    BufferedReader reader;
    DefaultListModel l;
    JList area;
    JButton cancel,ok,help;
    JTextField Lot_number,Dose,treated,comments;
    JScrollPane pane;
    public JComboBox<String> reason_box,treatment_box,ShotLocation_box,Shottype_box,Administrator_box,Units_box;
    public HealthRecord() throws Exception{
        setLayout(null);
        p1 = new JPanel();
        p1.setBounds(5, 5, 480, 500);
        p1.setLayout(null);
        p1.setBorder(BorderFactory.createTitledBorder(""));
        JLabel l1 = new JLabel("<html><i>Animal Treated<i><html>");
        l1.setBounds(60, 10, 100, 15);
        p1.add(l1);
        try {
            file = new BufferedWriter(new FileWriter("HealthRecord.txt", true));
        } catch (
                IOException iOexception) {
            iOexception.printStackTrace();
        }

        l = new DefaultListModel<>();
        l.addElement("");
        File f = new File("D:/akash/Agri_Management_System/HealthRecord.txt");
        reader = new BufferedReader(new FileReader(f));
        while (reader.readLine() != null) {
            l.addElement(reader.readLine());
        }
        area = new JList<>(l);
        area.setFocusable(true);
        pane = new JScrollPane(area);
        pane.setBounds(20, 27, 180, 345);
        p1.add(pane);
        JLabel date=new JLabel("Date");
        date.setBounds(220,20,50,10);
        p1.add(date);
        UtilDateModel model4=new UtilDateModel();
        Properties p4=new Properties();
        p4.put("text.today","Today");
        p4.put("text.month","Month");
        p4.put("text.year","Year");
        JDatePanelImpl datepanel4=new JDatePanelImpl(model4,p4);
        JDatePickerImpl datepicker4=new JDatePickerImpl(datepanel4,new Calf_Management.DateLabelFormatter());
        datepicker4.setBounds(220, 45, 130, 20);
        p1.add(datepicker4);

        JLabel reason=new JLabel("Reason");
        reason.setBounds(220,70,100,10);
        p1.add(reason);
        comboHealth=new Vector();
        model=new DefaultComboBoxModel<>(comboHealth);

        reason_box=new JComboBox<>(model);
        reason_box.addItem("");
        reason_box.addItem("<Add/Edit>");
        try {
            f = new File("D:/akash/Agri_Management_System/Reason.txt");
            f.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            while(br.readLine()!=null){
                model.addElement(br.readLine());
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
        reason_box.addActionListener(this);
        reason_box.setBounds(220,85,150,20);
        p1.add(reason_box);

        JLabel treatment=new JLabel("Treatment");
        treatment.setBounds(220,110,100,10);
        p1.add(treatment);
        comboTreatment=new Vector();
        model1=new DefaultComboBoxModel<>(comboTreatment);

        try {
            f = new File("D:/akash/Agri_Management_System/Treatment_health.txt");
            f.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            while(br.readLine()!=null){
                model1.addElement(br.readLine());
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
        treatment_box=new JComboBox<>(model1);
        treatment_box.addItem("");
        treatment_box.addItem("<Add/Edit>");
        treatment_box.addActionListener(this);
        treatment_box.setBounds(220,125,150,20);
        p1.add(treatment_box);

        JLabel Shot_location=new JLabel("Shot Location");
        Shot_location.setBounds(220,150,100,10);
        p1.add(Shot_location);
        comboShotLocation=new Vector();
        model2=new DefaultComboBoxModel<>(comboShotLocation);
        ShotLocation_box=new JComboBox<>(model2);
        ShotLocation_box.addItem("");
        ShotLocation_box.addItem("<Add/Edit>");
        try {
            f = new File("D:/akash/Agri_Management_System/Shot_Location_health.txt");
            f.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            while(br.readLine()!=null){
                model2.addElement(br.readLine());
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }

        ShotLocation_box.addActionListener(this);
        ShotLocation_box.setBounds(220,165,150,20);
        p1.add(ShotLocation_box);

        JLabel shot_type=new JLabel("Shot Type");
        shot_type.setBounds(220,190,100,10);
        p1.add(shot_type);
        comboShotType=new Vector();
        model3=new DefaultComboBoxModel<>(comboShotType);
        Shottype_box=new JComboBox<>(model3);
        Shottype_box.addItem("");
        Shottype_box.addItem("<Add/Edit>");
        try {
            f = new File("D:/akash/Agri_Management_System/Shot_type_health.txt");
            f.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            while(br.readLine()!=null){
                model3.addElement(br.readLine());
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }

        Shottype_box.addActionListener(this);
        Shottype_box.setBounds(220,205,150,20);
        p1.add(Shottype_box);

        JLabel administrator=new JLabel("Administrator");
        administrator.setBounds(220,230,100,10);
        p1.add(administrator);
        comboAdministrator=new Vector();
        model44=new DefaultComboBoxModel<>(comboAdministrator);
        Administrator_box=new JComboBox<>(model44);
        model44.addElement("");
        model44.addElement("<Add/Edit>");
        try {
            f = new File("D:/akash/Agri_Management_System/administrator_health.txt");
            f.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            while(br.readLine()!=null){
                model44.addElement(br.readLine());
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }

        Administrator_box.addActionListener(this);
        Administrator_box.setBounds(220,245,150,20);
        p1.add(Administrator_box);

        JLabel units=new JLabel("Units");
        units.setBounds(220,270,50,10);
        p1.add(units);
        comboUnits=new Vector();
        model5=new DefaultComboBoxModel<>(comboUnits);
        Units_box=new JComboBox<>(model5);
        model5.addElement("");
        model5.addElement("<Add/Edit>");
        try {
            f = new File("D:/akash/Agri_Management_System/Units_health.txt");
            f.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            while(br.readLine()!=null){
                model5.addElement(br.readLine());
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
        Units_box.addActionListener(this);
        Units_box.setBounds(220,285,150,20);
        p1.add(Units_box);

        JLabel comment=new JLabel("Comments");
        comment.setBounds(220,310,50,10);
        p1.add(comment);

        comments=new JTextField();
        comments.setBounds(220,325,150,20);
        p1.add(comments);

        cancel = new JButton("Cancel");
        cancel.setBounds(10, 520, 100, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        ok = new JButton("OK");
        ok.setBounds(140, 520, 100, 20);
        ok.setBackground(Color.BLACK);
        ok.setForeground(Color.WHITE);
        ok.addActionListener(this);
        add(ok);
        help = new JButton("Help");
        help.setBounds(270, 520, 100, 20);
        help.setBackground(Color.BLACK);
        help.setForeground(Color.WHITE);
        help.addActionListener(this);
        add(help);
        //setUndecorated(true);
        add(p1);
        setResizable(false);
        setTitle("Health Record");

        setBounds(50, 50, 500, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancel){
            this.dispose();
        }
        if (((String)reason_box.getSelectedItem()).equals("<Add/Edit>")) {
            try {
                new addReason().setVisible(true);
                //reason_box.setSelectedIndex(0);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        if (treatment_box.getActionCommand().equals("<Add/Edit>")) {
            try {
                new addTreatment().setVisible(true);
                //treatment_box.setSelectedIndex(0);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        if (ShotLocation_box.getActionCommand().equals("<Add/Edit>")) {
            try {
                new addShotLocation().setVisible(true);
                // ShotLocation_box.setSelectedIndex(0);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        if (Shottype_box.getActionCommand().equals("<Add/Edit>")) {
            try {
                new addShotType().setVisible(true);
                //Shottype_box.setSelectedIndex(0);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        if (Administrator_box.getActionCommand().equals("<Add/Edit>")) {
            try {
                new addAdministrator().setVisible(true);
                //Administrator_box.setSelectedIndex(0);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        if (Units_box.getActionCommand().equals("<Add/Edit>")) {
            try {
                new addUnits().setVisible(true);
                //Units_box.setSelectedIndex(0);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }
}