/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.Robot;
import java.awt.event.*;
import java.net.Socket;
import java.awt.Rectangle;
import java.io.PrintWriter;
import javax.swing.JPanel;

public class ClientCommands implements KeyListener,
        MouseMotionListener,MouseListener {
    Socket client;
    Rectangle rect;
    JPanel panel;
    PrintWriter writer;
    
    ClientCommands(Socket client,Rectangle rect,JPanel panel)
    {
        this.client=client;
        this.rect=rect;
        this.panel=panel;
            panel.addKeyListener(this);
            panel.addMouseListener(this);
            panel.addMouseMotionListener(this);
        try
        {
            writer=new PrintWriter(client.getOutputStream());
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void keyTyped(KeyEvent ke) {
        
    }
    public void keyPressed(KeyEvent ke) {
        System.out.println("KeyPressed :"+ ke.getKeyCode());
        writer.println(EnumCommands.PRESS_KEY.getCode());
        writer.println(ke.getModifiers());
        writer.flush();
    }
    public void keyReleased(KeyEvent ke) {
        System.out.println("KeyReleased :"+ ke.getKeyCode());
        writer.println(EnumCommands.RELEASE_KEY.getCode());
        writer.println(ke.getModifiers());
        writer.flush();
    }
    public void mouseDragged(MouseEvent me) {
    }
    public void mouseMoved(MouseEvent me) {
        int xcord=(int)(me.getX()*(rect.getWidth()/panel.getWidth()));
        int ycord=(int)(me.getY()*(rect.getHeight()/panel.getHeight()));
        writer.println(EnumCommands.MOVE_MOUSE.getCode());
        writer.println(xcord);
        writer.println(ycord);
        writer.flush();
    }
    public void mouseClicked(MouseEvent me) {
    }
    public void mousePressed(MouseEvent me) {
        double xcord=(int)(me.getX()*(rect.getWidth()/panel.getWidth()));
        double ycord=(int)(me.getY()*(rect.getHeight()/panel.getHeight()));
        writer.println(EnumCommands.PRESS_MOUSE.getCode());
        writer.println(me.getModifiers());
        writer.flush();
    }
    public void mouseReleased(MouseEvent me) {
        double xcord=(int)(me.getX()*(rect.getWidth()/panel.getWidth()));
        double ycord=(int)(me.getY()*(rect.getHeight()/panel.getHeight()));
        writer.println(EnumCommands.RELEASE_MOUSE.getCode());
        writer.println(me.getModifiers());
        writer.flush();
    }
    public void mouseEntered(MouseEvent me) {
    }
    public void mouseExited(MouseEvent me) {
    }
    
}
