/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.awt.Robot;
import java.net.Socket;
import java.io.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Screenshot extends Thread {
    Socket client;
    Rectangle rect;
    Robot screen;
    Screenshot(Socket client,Rectangle rect,Robot screen)
    {
        this.client=client;
        this.rect=rect;
        this.screen=screen;
        start();
    }
    public void run() {
        try
        {
            ObjectOutputStream os=new ObjectOutputStream(client.getOutputStream());
            os.writeObject(rect);
            while(true)
            {
                BufferedImage img=screen.createScreenCapture(rect);
                ImageIcon icon=new ImageIcon(img);
                os.writeObject(icon);
                os.reset();
                Thread.sleep(1);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}