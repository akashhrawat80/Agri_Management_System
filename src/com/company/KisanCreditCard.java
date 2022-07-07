package com.company;
import java.io.IOException;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class KisanCreditCard extends JFrame implements ActionListener{
    JButton back;
    private final String text="Visit site to apply for KCC";
    private final JLabel hyperlink=new JLabel(text);
    private final JEditorPane para;//a blank final variable must always be assigned at the ned of every contructor pf the class in which it is declared otherwise a compile time error occurs.
    KisanCreditCard() throws HeadlessException{
        super();
        back=new JButton("Back");
        back.setBounds(250,350,120,20);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        hyperlink.setForeground(Color.BLUE.darker());
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hyperlink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    Desktop.getDesktop().browse(new URI("https://www.sbi.co.in/web/agri-rural/agriculture-banking/crop-loan/kisan-credit-card"));
                }catch(IOException | URISyntaxException excep){
                    JOptionPane.showMessageDialog(null,
                            excep.getMessage());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href=''>"+text+"</a></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setText(text);
            }
        });

        getContentPane().add(hyperlink);

        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("com/company/images/kcc.jpg"));
        Image i=icon.getImage().getScaledInstance(741,340,Image.SCALE_DEFAULT);
        ImageIcon ii=new ImageIcon(i);
        JLabel l=new JLabel(ii);
        add(l);

        this.setTitle("KISAN CREDIT CARD");
        getContentPane().setBackground(Color.PINK);
        setLayout(new FlowLayout());
        setBounds(50,50,741,414);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        para=null;
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new KisanCreditCard().setVisible(true));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new DashBoard().setVisible(true);
            this.dispose();
        }
    }
}
