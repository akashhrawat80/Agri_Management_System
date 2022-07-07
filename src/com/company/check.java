package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class check {
    BufferedImage image;
    int width;
    int height;

    public check() throws Exception{
        File input=new File("D:/akash/Agri_Management_System/src/com/company/images/f1.jpg");
        width=ImageIO.read(input).getWidth();
        height=ImageIO.read(input).getHeight();

        int count=0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                count++;
                Color c=new Color(ImageIO.read(input).getRGB(j,i));
                System.out.println("NO.: "+count+" Red: "+c.getRed()+" Green: "+c.getGreen()+" Blue: "+c.getBlue());
            }
        }
    }
    public static void main(String[] args) throws Exception {
        check c=new check();
    }
}
