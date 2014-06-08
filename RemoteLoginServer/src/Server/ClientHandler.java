/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class ClientHandler {
    JDesktopPane desktop = null;
    Socket client = null;
    JInternalFrame interFrame = new JInternalFrame("Client Screen",true, true, true);
    JPanel panel = new JPanel();
    
    public ClientHandler(Socket client, JDesktopPane desktop) {
        this.client = client;
        this.desktop = desktop;
        this.run();
    }
        public void drawGUI(){
        interFrame.setLayout(new BorderLayout());
        interFrame.getContentPane().add(panel,BorderLayout.CENTER);
        interFrame.setSize(100,100);
        panel.setSize(100, 100);
        desktop.add(interFrame);
        try {
            //Initially show the internal frame maximized
            interFrame.setMaximum(true);
        } catch (Exception e) {
            System.out.println(e);
        }
        //this allows to handle KeyListener events
        panel.setFocusable(true);
        interFrame.setVisible(true);
    }

    public void run(){
        //used to represent client screen size
        Rectangle rect = null;
        //Used to read screenshots and client screen dimension
        ObjectInputStream ois = null;
        //start drawing GUI
        drawGUI();

        try{
            //Read client screen dimension
            ois = new ObjectInputStream(client.getInputStream());
            rect =(Rectangle) ois.readObject();
        }catch(Exception e){
            System.out.println(e);
        }
        //Start recieveing screenshots
        new Screenshot(ois,panel);
        //Start sending events to the client
        new ClientCommands(client,rect,panel);
    }


    
}
