/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8quanhau;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Hassasin
 */
public class Image2 extends JFrame{
    //JFrame frame
    BufferStrategy bs=getBufferStrategy();
    Graphics g=null;
    //default
    
    public void creat(){
        if (bs==null){
            createBufferStrategy(2);
            bs=getBufferStrategy();
        }       
        g=bs.getDrawGraphics();      
    }
    public void draw(BufferedImage img,int x,int y){
        g.drawImage(img, x, y, 60, 60, null);
        //g.dispose();
        bs.show();
    }
    public static void main(String args[]){
        
        //default Image
        BufferedImage imageB=null,imageW=null,imageQ=null,imageWalp=null;
        try {
            imageWalp=new BufferedImage(60,60,BufferedImage.TYPE_INT_ARGB);
            imageWalp=ImageIO.read(new File("D:\\Code\\Java\\NetBeans\\8QuanHau\\src\\pkg8quanhau\\wallpaper.png"));
            imageB=new BufferedImage(60,60,BufferedImage.TYPE_INT_ARGB);
            imageB=ImageIO.read(new File("D:\\Code\\Java\\NetBeans\\8QuanHau\\src\\pkg8quanhau\\black.png"));
            imageW=new BufferedImage(60,60,BufferedImage.TYPE_INT_ARGB);
            imageW=ImageIO.read(new File("D:\\Code\\Java\\NetBeans\\8QuanHau\\src\\pkg8quanhau\\white.png"));
            imageQ=new BufferedImage(60,60,BufferedImage.TYPE_INT_ARGB);
            imageQ=ImageIO.read(new File("D:\\Code\\Java\\NetBeans\\8QuanHau\\src\\pkg8quanhau\\queen.png"));
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        Image2 test= new Image2();
        test.setSize(514,514);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
        test.setTitle("Test");
        test.creat();
        test.draw(imageQ, 60, 60);
    }
    
}
