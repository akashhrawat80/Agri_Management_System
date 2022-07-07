package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.company.DashBoard;
public class Welcome_Cattle extends Canvas implements Runnable {
    Thread t;
    int state;
    String msg;
    static Welcome_Cattle w;
    static JButton b;
    volatile boolean stopFlag;
    Welcome_Cattle() {
        msg = " Welcome to Cattle management ";
        t = new Thread(this);
        stopFlag = false;
        t.start();
        //wel();
    }
    public void paint(Graphics g){
        Graphics2D g2=(Graphics2D) g;
        char ch;
        ch=msg.charAt(0);
        msg=msg.substring(1,msg.length());
        msg+=ch;
        Font f=new Font("Serif",Font.PLAIN,80);
        g2.setFont(f);
        g2.drawString(msg,0,230);
    }
    @Override
    public void run(){
        for(;;){
            try{
                repaint();
                Thread.sleep(250);
                if(stopFlag)break;
            }catch(Exception e){

            }
        }
    }
}
