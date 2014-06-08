/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.BorderLayout;
import java.awt.Robot;
import java.net.*;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ServerInterface {
    static JFrame frame = new JFrame();
    static JDesktopPane desktop = new JDesktopPane();
    public static void main(String[] args) {
        try
        {
            int port=Integer.parseInt(JOptionPane.showInputDialog("Enter Listening Port"));
            ServerSocket server=new ServerSocket(port);
            drawGUI();
            while(true)
            {
                Socket client=server.accept();
                System.out.println("New Client");
                new ClientHandler(client,desktop);
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
        static public void drawGUI(){
            frame.add(desktop,BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Show the frame in a maximized state
            frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
    }

}
