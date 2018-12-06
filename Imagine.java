/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8quanhau;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Hassasin
 */
public class Imagine {
    private String linkFile=null;
    private int width,height;
    private File f=null;
    private BufferedImage image=null;
    public Imagine(String s) {
        linkFile=s;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int height) {
        this.height = height;
    }
    public void paint(Graphics g){
        try {
            image=new BufferedImage(312,312,BufferedImage.TYPE_INT_ARGB);
            image=ImageIO.read(new File(linkFile));
            g.drawImage(image,0, 0, 312, 312, null);
        } catch (IOException ex) {
            Logger.getLogger(InterFace.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
