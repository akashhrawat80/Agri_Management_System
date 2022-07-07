package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Insurance extends JFrame implements ActionListener{
    JButton back,Calculate,addd;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,error;
    JComboBox b1,b2,b3,b4,b5,b6,b8;
    JTextField area;
    JEditorPane result;
    Insurance(){
        setTitle("Insurance Premium");
        l1=new JLabel("Season");
        l1.setFont(new Font("serif",Font.BOLD,20));
        l1.setBounds(20,10,100,25);
        add(l1);

        String[] s1={"","Kharif","Rabi","Zaid"};
        b1=new JComboBox<String>(s1);
        b1.setBounds(140,10,300,25);
        add(b1);

        l2=new JLabel("Year");
        l2.setFont(new Font("serif",Font.BOLD,20));
        l2.setBounds(20,40,100,25);
        add(l2);

        String[] s2={"","2021","2020","2019","2018"};
        b2=new JComboBox<String>(s2);
        b2.setBounds(140,40,300,25);
        add(b2);

        l3=new JLabel("Scheme");
        l3.setFont(new Font("serif",Font.BOLD,20));
        l3.setBounds(20,70,100,25);
        add(l3);

        String[] s3={"","Pradhan Mantri Fasal Bima Yojana","Weather Based Crop Insurance Scheme"};
        b3=new JComboBox<String>(s3);
        b3.setBounds(140,70,300,25);
        add(b3);

        l4=new JLabel("State");
        l4.setFont(new Font("serif",Font.BOLD,20));
        l4.setBounds(20,100,100,25);
        add(l4);

        String[] s4={"","Uttarakhand"};
        b4=new JComboBox<String>(s4);
        b4.setBounds(140,100,300,25);
        add(b4);

        l5=new JLabel("District");
        l5.setFont(new Font("serif",Font.BOLD,20));
        l5.setBounds(20,130,100,25);
        add(l5);

        String[] s5={"","Almora","Bageshwar","Chamoli","Champawat","Dehradun","Pauri Garhwal","Nainital","Pithoragarh","Rudraprayag","Tehri Garhwal","Uttarkashi","Udham Singh Nagar"};
        b5=new JComboBox<String>(s5);
        b5.setBounds(140,130,300,25);
        add(b5);

        l6=new JLabel("Crop");
        l6.setFont(new Font("serif",Font.BOLD,20));
        l6.setBounds(20,160,100,25);
        add(l6);

        String[] s6={"","Food Crop","Cash Crop","Paddy(Dhan)"};
        b6=new JComboBox<String>(s6);
        b6.setBounds(140,160,300,25);
        add(b6);

        l7=new JLabel("Area(acre)");
        l7.setFont(new Font("serif",Font.BOLD,20));
        l7.setBounds(20,190,100,25);
        add(l7);

        area=new JTextField();
        area.setBounds(140,190,300,25);
        add(area);

        l8=new JLabel("Insurance Company");
        l8.setFont(new Font("serif",Font.BOLD,20));
        l8.setBounds(20,220,100,25);
        add(l8);

        String[] s8={"","Agriculture Insurance Company","SBI Insurance"};
        b8=new JComboBox<String>(s8);
        b8.setBounds(140,220,300,25);
        add(b8);

        Calculate=new JButton("Calculate");
        Calculate.setBounds(240,280,150,25);
        Calculate.setForeground(Color.WHITE);
        Calculate.setBackground(Color.BLACK);
        Calculate.addActionListener(this);
        add(Calculate);

        back=new JButton("Back");
        back.setBounds(20,280,100,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        addd=new JButton("Add");
        addd.setBounds(140,280,100,25);
        addd.setForeground(Color.WHITE);
        addd.setBackground(Color.BLACK);
        addd.addActionListener(this);
        add(addd);

        JPanel p=new JPanel();
        p.setBounds(450,0,290,414);
        result=new JEditorPane();
        result.setContentType("text/html");
        result.setEditable(false);
        p.add(result);
        add(p);

        error=new JLabel();
        error.setBounds(20,310,100,20);
        add(error);

        setLayout(null);
        setBounds(50,50,741,414);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Insurance().setVisible(true);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Float rate=0.0f;
        String farmer_share=null;
        String gov_share=null;
        if(e.getSource()==addd){
            try {
                String Season=(String)b1.getSelectedItem();
                String Year=(String)b2.getSelectedItem();
                String Scheme=(String)b3.getSelectedItem();
                String State=(String)b4.getSelectedItem();
                String District=(String)b5.getSelectedItem();
                String Crop=(String)b6.getSelectedItem();
                String ar=area.getText();
                Connect c = new Connect();
                //create table FarmerInsurance in the sql database
                String str="create table if not exists" +
                        " FarmerInsurance(Season varchar(30),Year varchar(10)," +
                        "Scheme varchar(100),State varchar(30),District varchar(40)," +
                        "Crop varchar(40),Area varchar(4))";
                c.st.executeUpdate(str);
                String str2="insert into FarmerInsurance " +
                        "values('"+Season+
                        "','"+Year+"','"+Scheme+"','"+State+"','"+District+"','"+Crop+"','"+ar+"')";
                c.st.executeUpdate(str2);
                JOptionPane.showMessageDialog(this,"Info Added");
            }catch(Exception ae) {
                JOptionPane.showMessageDialog(this,ae.getMessage());
            }
        }
        if(e.getSource()==Calculate){
            try {
                Connect c=new Connect();
                //create table in the sql database insurance with prefilled data.
                ResultSet rs=c.st.executeQuery("Select * from insurance where company='"+(String)b8.getSelectedItem()+"'and crop='"+(String)b6.getSelectedItem()+"'");
                while(rs.next()){
                    if(rs.getString("company").equals((String)b8.getSelectedItem())&&rs.getString("crop").equals((String)b6.getSelectedItem())){
                        rate=rs.getFloat("rate");
                        farmer_share=rs.getString("farmer_share");
                        gov_share=rs.getString("gov_share");
                        break;
                    }
                };
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            result.setText("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Insurance Premium</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <table>\n" +
                    "        <tr>\n" +
                    "            <th>Insurance Company</th>\n" +
                    "            <td id=\"company\"></td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <th>Crop</th>\n" +
                    "            <td id=\"crop\"></td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <th>Area</th>\n" +
                    "            <td id=\"area\"></td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <th colspan=\"2\">premium paid by</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td>farmer(Rs)</td>\n" +
                    "            <td>Government(Rs)</td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td id=\"pref\"></td>\n" +
                    "            <td id=\"preg\"></td>\n" +
                    "        </tr>\n" +
                    "         <tr>\n" +
                    "            <th>Sum Assured(Ruppees/Hectare)</th>\n" +
                    "            <td id=\"sum\"></td>\n" +
                    "        </tr>\n" +
                    "\n" +
                    "    </table>\n" +
                    "\n" +
                    "    <script>\n" +
                    "        var company='"+(String)b8.getSelectedItem()+"';\n" +
                    "        var sum;\n" +
                    "        var crop='"+(String)b6.getSelectedItem()+"';\n" +
                    "        var area='"+area.getText()+"';\n" +
                    "        var pref='"+farmer_share+"';\n" +
                    "        var preg='"+gov_share+"';\n" +
                    "        sum=pref+preg;\n" +
                    "        document.getElementById(\"#company\").innerHTML=company;\n" +
                    "        document.getElementById(\"#sum\").innerHTML=sum;\n" +
                    "        document.getElementById(\"#crop\").innerHTML=crop;\n" +
                    "        document.getElementById(\"#area\").innerHTML=area;\n" +
                    "        document.getElementById(\"#pref\").innerHTML=pref;\n" +
                    "        document.getElementById(\"#preg\").innerHTML=preg;\n" +
                    "    </script>\n" +
                    "</body>\n" +
                    "</html>");
            //result.setPage(Insurance.class.getResource("calculate.html"));
        }else if(e.getSource()==back){
            new DashBoard().setVisible(true);
            this.dispose();
        }
    }
}

