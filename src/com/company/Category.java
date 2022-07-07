package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Category extends JFrame implements ActionListener {
    JMenuBar menu;
    JMenu m1,m2,m3,m4;
    JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi11,mi12;

    Category(){
        menu=new JMenuBar();
        menu.setForeground(Color.gray);
        add(menu);
        m1=new JMenu("AGRI MANAGEMENT");
        m1.setForeground(Color.BLUE);
        menu.add(m1);

        m2=new JMenu("ADMIN");
        m2.setForeground(Color.BLUE);
        menu.add(m2);

        m3=new JMenu("HELP and SUPPORT");
        m3.addActionListener(this);
        m3.setForeground(Color.BLUE);
        menu.add(m3);

        m4=new JMenu("SOFTWARE INFO");
        m4.addActionListener(this);
        m4.setForeground(Color.BLUE);
        m4.getPopupMenu();
        menu.add(m4);

        mi11=new JMenuItem("DashBoard");
        mi11.addActionListener(this);
        m1.add(mi11);

        mi12=new JMenuItem("ABOUT");
        mi12.addActionListener(this);
        m4.add(mi12);

        mi1=new JMenuItem("CONTACT US");
        mi1.addActionListener(this);
        m1.add(mi1);

        mi2=new JMenuItem("REQUESTS");
        mi2.addActionListener(this);
        m2.add(mi2);

        mi3=new JMenuItem("ADD AUTHORITY");
        mi3.addActionListener(this);
        m2.add(mi3);

        mi4=new JMenuItem("FARMER LOAN");
        mi4.addActionListener(this);
        m2.add(mi4);

        mi5=new JMenuItem("AGRICULTURE SCHEMES");
        mi5.addActionListener(this);
        m2.add(mi5);

        mi6=new JMenuItem("LAND MEASURING");
        mi6.addActionListener(this);
        m2.add(mi6);
        mi7=new JMenuItem("LAND POSITIONING");
        mi7.addActionListener(this);
        m2.add(mi7);

        menu.setBounds(0,0,741,30);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("com/company/images/indian-farmers-1.jpg"));
        Image i=img.getImage().getScaledInstance(741,384,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i);
        JLabel l=new JLabel(i2);
        l.setLocation(0,0);
        l.setSize(741,384);
        add(l);

        JLabel pensionlabel=new JLabel("UTTARAKHAND KISAN PENSION YOJNA");
        pensionlabel.setFont(new Font("serif",Font.ITALIC,25));
        pensionlabel.setForeground(Color.WHITE);
        pensionlabel.setBounds(5,40,600,30);
        l.add(pensionlabel);

        setLayout(null);
        setBounds(50,50,741,414);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("ADD AUTHORITY")){
            new IncludeAuthority().setVisible(true);
        }else if(e.getActionCommand().equals("REQUESTS")){

        }else if(e.getActionCommand().equals("FARMER LOAN")){
            //new LoanInfo().setVisible(true);    kis kis ne loan ke liye apply kara hai
        }else if(e.getActionCommand().equals("ADD AUTHORITY")){
            new IncludeAuthority().setVisible(true);
            this.dispose();
        }else if(e.getActionCommand().equals("ABOUT")){
           new About().setVisible(true);//About app
        }else if(e.getActionCommand().equals("CONTACT US")){
            new Helpline().setVisible(true);//help -->related app
        }else if(e.getActionCommand().equals("AGRICULTURE SCHEMES")){
            new Schemes().setVisible(true);    //new upcoming schemes for farmers
        }else if(e.getActionCommand().equals("LAND MEASURING")){
            new LandMeasure().setVisible(true);//to measure the land of the farmer
        }else if(e.getActionCommand().equals("LAND POSITIONING")){
            new LandPosition().setVisible(true);//to know the position of farmer land
        }else if(e.getActionCommand().equals("DashBoard")){
            new DashBoard().setVisible(true);
            this.dispose();
        }
    }

    public static void main(String args[]){
        Category category=new Category();
    }
}
