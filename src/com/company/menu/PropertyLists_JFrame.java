package com.company.menu;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.io.IOException;

public class PropertyLists_JFrame extends JFrame implements ActionListener, ListSelectionListener {
    JButton cancel, ok;
    JList<String> area;
    JScrollPane pane;

    public PropertyLists_JFrame() {
        JLabel l1 = new JLabel("Property List");
        l1.setBounds(10, 10, 100, 15);
        add(l1);
        String[] str = {"Genders", "Grade(Products)", "Health Codes", "Health Reason", "Health Treatment", "Locations" +
                "Loss Reason", "Management Codes"};
        area = new JList<>(str);
        area.setSelectedIndex(1);
        area.setFocusable(true);
        area.addListSelectionListener(this);
        pane = new JScrollPane(area);
        pane.setBounds(10, 27, 260, 200);
        add(pane);

        cancel = new JButton("Cancel");
        cancel.setBounds(160, 230, 100, 20);
        add(cancel);
        ok = new JButton("OK");
        ok.setBounds(50, 230, 100, 20);
        add(ok);
        this.setLayout(null);
        setBounds(50, 50, 300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PropertyLists_JFrame();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.dispose();
        } else if (e.getSource() == ok) {

        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (area.getSelectedValue().equals("Management Codes")) {
            try {
                new addManagementCodes().setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else if (area.getSelectedValue().equals("Genders")) {
            try {
                new addManagementCodes().setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else if (area.getSelectedValue().equals("locations")) {
            try {
                new addLocation().setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else if (area.getSelectedValue().equals("Grade(Products)")) {
            try {
                new addManagementCodes().setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else if (area.getSelectedValue().equals("Health Codes")) {
            try {
                new addHealth().setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else if (area.getSelectedValue().equals("Health Reason")) {
            try {
                new addManagementCodes().setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }
}