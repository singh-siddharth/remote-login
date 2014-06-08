/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.net.Socket;
import java.util.Scanner;

class ServerCommands extends Thread{
    Socket client=null;
    Robot robot=null;
    boolean continueLoop=true;
    ServerCommands(Socket client,Robot robot)
    {
        //System.out.println("hell");
        this.client=client;
        this.robot=robot;
        start();
        
    }

    public void run() {
        try
        {
            Scanner sc=new Scanner(client.getInputStream());
            while(continueLoop)
            {
            int command=sc.nextInt();
                switch(command)
                {
                    case -1 :robot.mousePress(sc.nextInt());
                             break;
                    case -2 :robot.mouseRelease(sc.nextInt());
                             break;
                    case -3 :robot.keyPress(sc.nextInt());
                             break;
                    case -4 :robot.keyRelease(sc.nextInt());
                             break;
                    case -5 :robot.mouseMove(sc.nextInt(),sc.nextInt());
                }
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}