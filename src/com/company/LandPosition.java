package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LandPosition extends JFrame implements ActionListener{
    JLabel latl, lngl;
    JTextField lat, lng;
    JButton search, cancel;
    JPanel box;

    LandPosition() {
        setTitle("Positioning of the land");
        latl = new JLabel("Latitude:");
        latl.setBounds(30, 30, 120, 20);
        latl.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(latl);

        lat = new JTextField();
        lat.setBounds(170, 30, 150, 20);
        add(lat);

        lngl = new JLabel("Latitude:");
        lngl.setBounds(30, 60, 120, 20);
        lngl.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lngl);

        lng = new JTextField();
        lng.setBounds(170, 60, 150, 20);
        add(lng);

        search = new JButton("Search");
        search.setBounds(40, 90, 120, 20);
        search.addActionListener(this);
        add(search);

        box = new JPanel();
        box.setBounds(3, 120, 720, 255);
        add(box);

        cancel = new JButton("Cancel");
        cancel.setBounds(0, 0, 100, 20);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setBounds(50, 50, 741, 414);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LandPosition position = new LandPosition();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            try{
                String latitude=lat.getText();
                String longitude=lng.getText();
                String imgURL="https://maps.googleapis.com/maps/api/staticmap?key=AIzaSyBPwY3B5-h7_RVQabeH3alvosflO6CBAQM&center="+latitude+","+longitude+"&zoom=11&size=612x612&scale=2&maptype=roadmap";
                String destinationFile="image.jpg";
                URL url=new URL(imgURL);
                InputStream is=url.openStream();
                OutputStream os=new FileOutputStream(destinationFile);

                byte[] b=new byte[2048];
                int length;

                while((length=is.read(b))!=-1){
                    os.write(b,0,length);
                }
                is.close();
                os.close();
            }catch(IOException ie){
                JOptionPane.showMessageDialog(this,ie.getMessage());
            }
            ImageIcon i=new ImageIcon((new ImageIcon("image.jpg").getImage().getScaledInstance(710,245,Image.SCALE_SMOOTH)));
            box.add(new JLabel(i));
            this.setVisible(true);
            this.pack();
        }else if(e.getSource()==cancel){
            new DashBoard().setVisible(true);
            this.dispose();
        }
    }
}