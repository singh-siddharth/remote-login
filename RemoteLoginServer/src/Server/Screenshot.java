/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.io.ObjectInputStream;

public class Screenshot extends Thread {
    ObjectInputStream input;
    JPanel panel;
    Screenshot(ObjectInputStream input,JPanel p)
    {
        this.input=input;
        this.panel=p;
        start();
    }
    public void run() {
        try {
                 while(true)
                 {
                    ImageIcon imageIcon = (ImageIcon) input.readObject();
                    System.out.println("New image recieved");
                    Image image = imageIcon.getImage();
                    image = image.getScaledInstance(panel.getWidth(),panel.getHeight(),Image.SCALE_FAST);
                    Graphics graphics = panel.getGraphics();
                    graphics.drawImage(image, 0, 0, panel.getWidth(),panel.getHeight(),panel);
                }
            } catch (Exception e) 
            {
                System.out.println(e);
            }
    }
}
