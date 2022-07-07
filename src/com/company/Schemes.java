package com.company;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.URL;

public class Schemes extends JFrame implements ActionListener {

    JEditorPane pane;
    JTextField txtURL;
    JButton btn, back;

    Schemes() {
        txtURL = new JTextField();
        txtURL.setBounds(0, 0, 300, 30);
        getContentPane().add(txtURL);

        pane = new JEditorPane();
        pane.setContentType("text/html");
        pane.setEditable(false);
        JPanel p = new JPanel();

        JScrollPane sc = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc.setSize(700, 324);
        sc.setLocation(0, 30);

        p.add(pane);
        add(sc);

        btn = new JButton("Go");
        btn.setBounds(0, 355, 50, 20);
        add(btn);
        btn.addActionListener(this);

        back = new JButton("cancel");
        back.setBounds(60, 355, 120, 20);
        add(back);
        back.addActionListener(this);

        setBounds(50, 50, 741, 414);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        Schemes scheme = new Schemes();
        scheme.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            String url = txtURL.getText();
            try {
                pane.setPage(new URL(url));
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(this,ee.getMessage());
            }
        }else if(e.getSource()==back){
            //new DashBoard().setVisible(true);
            this.dispose();
        }
    }
}