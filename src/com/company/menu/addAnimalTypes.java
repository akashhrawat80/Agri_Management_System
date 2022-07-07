package com.company.menu;

import com.company.Calf_Management;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class addAnimalTypes extends JFrame implements ActionListener{
    JPanel p1, p2, p3;
    JTextField t2, t3;
    JComboBox<String> b1;
    JCheckBox l4;
    File f;
    JButton cancel, add, clear, remove;
    BufferedWriter writer;
    BufferedReader br;

    addAnimalTypes(){
        p1 = new JPanel();
        p1.setBounds(10, 10, 450, 100);
        p1.setLayout(null);
        p1.setBorder(BorderFactory.createTitledBorder("Animal Types"));

        JLabel l1 = new JLabel("Add Animal Type");
        l1.setBounds(20, 40, 150, 20);
        p1.add(l1);
       String[] type=new String[1];
        b1 = new JComboBox<>(type);
        b1.setBounds(180, 35, 210, 30);
        p1.add(b1);
        add(p1);

        p2 = new JPanel();
        p2.setBounds(10, 120, 450, 150);
        p2.setLayout(null);
        p2.setBorder(BorderFactory.createTitledBorder("New Description"));

        JLabel l2 = new JLabel("Description");
        l2.setBounds(20, 40, 150, 20);
        p2.add(l2);
        t2 = new JTextField();
        t2.setBounds(180, 35, 210, 30);
        p2.add(t2);

        JLabel l3 = new JLabel("Icon group");
        l3.setBounds(20, 80, 150, 20);
        p2.add(l3);
        t3 = new JTextField();
        t3.setBounds(180, 75, 210, 30);
        t3.setEnabled(false);
        p2.add(t3);
        add(p2);
        p3 = new JPanel();
        p3.setBounds(10, 280, 450, 70);
        p3.setLayout(null);
        p3.setBorder(BorderFactory.createTitledBorder(""));
        l4 = new JCheckBox("All animals have ID number or names");
        l4.setBounds(35, 10, 300, 20);
        p3.add(l4);
        add(p3);
        cancel = new JButton("Done");
        cancel.setBounds(10, 370, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        clear = new JButton("Clear");
        clear.setBounds(110, 370, 80, 20);
        clear.addActionListener(this);
        add(clear);
        remove = new JButton("Delete");
        remove.setBounds(205, 370, 80, 20);
        remove.addActionListener(this);
        add(remove);
        add = new JButton("Record");
        add.setBounds(310, 370, 80, 20);
        add.addActionListener(this);
        add(add);
        setUndecorated(true);
        setLayout(null);
        setBounds(50, 50, 500, 500);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new addAnimalTypes();
    }

        @Override
        public void actionPerformed (ActionEvent e){
            if (e.getSource() == cancel) {
                try {
                    writer.close();
                    this.dispose();

                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(this, ee.getMessage());
                }
                this.dispose();
            } else if (e.getSource() == add) {
                try {
                    String s = t2.getText();
                    Calf_Management c=new Calf_Management();
                    c.comboAnimalTypes.addElement(s);
                    writer = new BufferedWriter(new FileWriter("Animal_types.txt", true));
                    writer.write(s);
                    writer.newLine();
                    writer.flush();
                    try {
                        f = new File("D:/akash/Agri_Management_System/Animal_types.txt");
                        f.createNewFile();
                        br = new BufferedReader(new FileReader(f));
                        while (br.readLine() != null) {
                            c.comboAnimalTypes.addElement(br.readLine());
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    b1 = new JComboBox<>(c.comboAnimalTypes);
                    b1.setBounds(180, 35, 210, 30);
                    p1.add(b1);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            } else if (e.getSource() == clear) {
                int i = JOptionPane.showConfirmDialog(this, "Are you sure?");
                t2.setText("");
            } else if (e.getSource() == remove) {

            }
        }
    }
