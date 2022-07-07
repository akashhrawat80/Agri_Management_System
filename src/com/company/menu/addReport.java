package com.company.menu;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.*;

public class addReport extends JFrame implements ActionListener {
    JList<String> list;
    JTextField title;
    BufferedWriter file;
    BufferedReader reader;
    JList area,area2;
    JScrollPane pane,pane2;
    DefaultListModel<String> l,l2;
    JPanel p1;
    JButton add,remove,up,down,ascending,descending,clearsort,print,record,done,help;
    addReport() throws Exception
    {
        p1 = new JPanel();
        p1.setBounds(10, 10, 750, 400);
        p1.setLayout(null);
        p1.setBorder(BorderFactory.createTitledBorder(""));
        this.setBounds(50,50,800,600);
        JLabel label=new JLabel("Report Title");
        label.setBounds(12,5,100,20);
        p1.add(label);
        title=new JTextField();
        title.setBounds(115,5,200,20);
        p1.add(title);
        try {
            file = new BufferedWriter(new FileWriter("CustomReport.txt", true));
        } catch (IOException iOexception) {
            iOexception.printStackTrace();
        }

        l = new DefaultListModel<>();
        File f = new File("D:/akash/Agri_Management_System/CustomReport.txt");
        reader = new BufferedReader(new FileReader(f));
        while (reader.readLine() != null) {
            l.addElement(reader.readLine());
        }
        area = new JList<>(l);
        area.setFocusable(true);
        pane = new JScrollPane(area);
        pane.setBounds(10, 27, 270, 310);
        p1.add(pane);

        l2 = new DefaultListModel<>();

        area2 = new JList<>(l2);
        area2.setFocusable(true);
        pane2 = new JScrollPane(area2);
        pane2.setBounds(300, 27, 270, 310);
        p1.add(pane2);
        add(p1);

        add=new JButton("Add >>");
        add.setBounds(140,340,100,20);
        add.addActionListener(this);
        p1.add(add);

        remove=new JButton("<< Remove");
        remove.setBounds(340,340,100,20);
        p1.add(remove);
        up=new JButton("Up");
        up.setBounds(600,30,100,20);
        p1.add(up);

        down=new JButton("Down");
        down.setBounds(600,70,100,20);
        p1.add(down);

        ascending=new JButton("Ascending");
        ascending.setBounds(600,110,100,20);
        p1.add(ascending);

        descending=new JButton("<html>Descending</html>");
        descending.setBounds(600,150,100,20);
        p1.add(descending);

        clearsort=new JButton("Clear Sort");
        clearsort.setBounds(600,190,100,20);
        p1.add(clearsort);

        print=new JButton("Print");
        print.setBounds(50,440,100,20);
        add(print);
        record=new JButton("Record");
        record.setBounds(170,440,100,20);
        add(record);
        done=new JButton("Done");
        done.setBounds(300,440,100,20);
        add(done);
        help=new JButton("Help");
        help.setBounds(440,440,100,20);
        add(help);

        this.setLayout(null);
        this.setVisible(true);
    }
    public static void main(String args[]) throws Exception{
        new addReport();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String i=(String)area.getSelectedValue();
            l2.addElement(i);
        }
    }
}
