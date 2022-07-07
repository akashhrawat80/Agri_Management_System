package com.company.menu;
import com.company.Calf_Management;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class addUnits extends JFrame implements ActionListener{
    JButton cancel, add, Rename, remove;
    JList<String> area;
    JScrollPane pane;
    JTextField text;
    DefaultListModel<String> l;
    BufferedWriter file;
    BufferedReader reader;
    JPanel p1;

    public addUnits() throws IOException {
        p1=new JPanel();
        p1.setBounds(5,10,480,350);
        p1.setLayout(null);
        p1.setBorder(BorderFactory.createTitledBorder("Units"));
        try {
            file = new BufferedWriter(new FileWriter("Units_health.txt", true));
        } catch (IOException iOexception) {
            iOexception.printStackTrace();
        }

        l = new DefaultListModel<>();
        l.addElement("");
        File f = new File("D:/akash/Agri_Management_System/Units_health.txt");
        reader = new BufferedReader(new FileReader(f));
        while (reader.readLine() != null) {
            l.addElement(reader.readLine());
        }
        area = new JList<>(l);
        area.setFocusable(true);
        pane = new JScrollPane(area);
        pane.setBounds(20, 27, 310, 250);
        p1.add(pane);

        text = new JTextField();
        text.setBounds(340, 27, 130, 30);
        p1.add(text);
        cancel = new JButton("Done");
        cancel.setBounds(100, 460, 120, 20);
        cancel.addActionListener(this);
        add(cancel);
        Rename = new JButton("Rename");
        Rename.setBounds(370, 180, 100, 20);
        Rename.addActionListener(this);
        p1.add(Rename);
        remove = new JButton("Remove");
        remove.setBounds(370, 140, 100, 20);
        remove.addActionListener(this);
        p1.add(remove);
        add = new JButton("Add");
        add.setBounds(370, 110, 100, 20);
        add.addActionListener(this);
        p1.add(add);
        add(p1);
        setUndecorated(true);
        setLayout(null);
        setBounds(50, 50, 500, 500);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            try {
                file.close();
                this.dispose();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            this.dispose();
        } else if (e.getSource() == add) {
            String s = text.getText();
            l.addElement(s);
            try {
                Calf_Management.h.model5.addElement(s);
                file.write(s);
                file.newLine();
                file.flush();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            text.setText("");
        } else if (e.getSource() == Rename) {

        } else if (e.getSource() == remove) {
            int s = area.getSelectedIndex();
            l.remove(s);
            try {
                while (reader.readLine() != null) {
                    //    if (reader.readLine().equals(s)) {

                    //  }
                }

            } catch (IOException exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error Clearing,try again");
            }

        }
    }
}




