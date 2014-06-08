/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Apurv and Debashish
 */
import java.awt.*;
import java.net.Socket;
import java.io.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ClientInterface {
    static Socket client;
    public static void main(String[] args) {
        String ip=JOptionPane.showInputDialog("Enter Server IP");
        int port=Integer.parseInt(JOptionPane.showInputDialog("Enter Server Port"));
        try
        {
            client= new Socket(ip,port);
            GraphicsEnvironment gen=GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gdev=gen.getDefaultScreenDevice();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rect=new Rectangle(dim);
            Robot robot=new Robot(gdev);
            drawGUI();
            Screenshot screenshot = new Screenshot(client,rect,robot);
            ServerCommands serverCommands = new ServerCommands(client,robot);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    static public void drawGUI()
    {
        JFrame jf=new JFrame("Terminate");
        JButton button=new JButton();
        button.setBounds(100, 100, 200, 75);
        button.setText("Terminate");
        jf.getContentPane().add(button);
        jf.setBounds(100, 100, 200, 75);
        jf.setVisible(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jf.setVisible(true);
    }
}