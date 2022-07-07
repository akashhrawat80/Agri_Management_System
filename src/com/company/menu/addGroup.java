package com.company.menu;
import com.company.Calf_Management;

import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;
import java.io.*;

public class addGroup extends JFrame implements ActionListener, Serializable {
    JButton cancel, add, clearAll, remove;
    JList<String> area;
    JScrollPane pane;
    JTextField text;
    DefaultListModel<String> l;
    BufferedWriter file;
    BufferedReader reader;

    public addGroup() throws IOException {
        JLabel l1 = new JLabel("<html><i>Add Cow Group<i><html>");
        l1.setBounds(10, 10, 100, 15);
        add(l1);
        try {
            file = new BufferedWriter(new FileWriter("Group.txt", true));
        } catch (IOException iOexception) {
            iOexception.printStackTrace();
        }

        l = new DefaultListModel<>();
        l.addElement("");
        File f = new File("D:/akash/Agri_Management_System/Group.txt");
        reader = new BufferedReader(new FileReader(f));
        while (reader.readLine() != null) {
            l.addElement(reader.readLine());
        }
        area = new JList<>(l);
        area.setFocusable(true);
        pane = new JScrollPane(area);
        pane.setBounds(10, 27, 310, 250);
        add(pane);

        text = new JTextField();
        text.setBounds(340, 27, 130, 30);
        add(text);
        cancel = new JButton("Save/Back");
        cancel.setBounds(100, 360, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        clearAll = new JButton("Clear All");
        clearAll.setBounds(370, 180, 100, 20);
        clearAll.addActionListener(this);
        add(clearAll);
        remove = new JButton("Remove");
        remove.setBounds(370, 140, 100, 20);
        remove.addActionListener(this);
        add(remove);
        add = new JButton("Add");
        add.setBounds(370, 110, 100, 20);
        add.addActionListener(this);
        add(add);
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
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            this.dispose();
        } else if (e.getSource() == add) {
            String s = text.getText();
            l.addElement(s);
            try {
                Calf_Management c=new Calf_Management();
                c.comboGroup.addElement(s);
                file.write(s);
                file.newLine();
                file.flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            text.setText("");
        } else if (e.getSource() == clearAll) {
            int i = JOptionPane.showConfirmDialog(this, "Are you sure?");
            if (i == 0) {
                l.clear();
                try {
                    file = new BufferedWriter(new FileWriter("Group.txt"));
                    file.write("");
                } catch (IOException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error Clearing,try again");
                }
            }
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



