/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mcmap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author WRIM
 */
public class RunMe extends Thread {
    
    static String command;
    static Window myWindow;
    
    public RunMe(String cmd, Window win)
    {
        command = cmd;
        myWindow = win;
    }
    
    public void run() {
        BufferedWriter outputWriter = null;
        BufferedReader inputReader = null;
        
        myWindow.generateMapButton.setEnabled(false);
        
        DefaultListModel jakismodel = new DefaultListModel();
        jakismodel.addElement("<html><b><font color=red>New launcher allowed</font></b></html>");
        jakismodel.addElement(command);
        myWindow.consoleList.setModel(jakismodel);
        
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();

            System.out.println("nazwa "+outputStream);
            outputWriter = new BufferedWriter(new OutputStreamWriter(
                    outputStream));
            inputReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = null;
            ArrayList<String> lines = new ArrayList<String>();
            
            
            int count = 0;
            while ((line = inputReader.readLine()) != null) {
                //lines.add(line);
                
                //jList1.setModel(new DefaultListModel());
                
                if (line.equals("")) continue;
                if (line.charAt(0) == '[')
                {
                    String liczba = line.substring(1, line.indexOf('.'));
                    myWindow.jProgressBar1.setValue(Integer.parseInt(liczba));
                }
                else
                {
                    jakismodel.addElement(line);
                    myWindow.consoleList.setModel(jakismodel);
                    myWindow.consoleList.ensureIndexIsVisible(count++);
                    //myWindow.jList1.setSelectedIndex(count++);
                }
                if (line.substring(0, 5).equals("Pass "))
                {
                    String first = line.substring(5, line.indexOf(' ', 5));
                    String last  = line.substring(line.indexOf(" of ")+4, line.indexOf('.', line.indexOf(" of ")+4));
                    
                    int really = (int) Math.ceil((Integer.parseInt(first) - 1) * (float)100 / (Integer.parseInt(last) - 1));
                    myWindow.jProgressBar2.setValue(really);
                    
                    //jakismodel.addElement(new Integer(really).toString());
                    //myWindow.jList1.setModel(jakismodel);
                    //myWindow.jList1.ensureIndexIsVisible(count++);
                }
            }
        } catch (IOException e)
        {
            System.out.println("nieudane otwieranie " + command);
        }
        finally {
            try{
                outputWriter.close();
                inputReader.close();
            }catch(Exception e){System.out.println("nieudane zamykanie "+command);}
        }
        myWindow.generateMapButton.setEnabled(true);
    }
        
      public boolean check() {
        BufferedWriter outputWriter = null;
        BufferedReader inputReader = null;
        
        myWindow.generateMapButton.setEnabled(false);
        
        DefaultListModel jakismodel = new DefaultListModel();
        jakismodel.addElement("<html><b><font color=red>New launcher allowed</font></b></html>");
        jakismodel.addElement(command);
        myWindow.consoleList.setModel(jakismodel);
        
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();

            System.out.println("nazwa "+outputStream);
            outputWriter = new BufferedWriter(new OutputStreamWriter(
                    outputStream));
            inputReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = null;
            ArrayList<String> lines = new ArrayList<String>();
            
            
            int count = 0;
            while ((line = inputReader.readLine()) != null) {
                //lines.add(line);
                
                //jList1.setModel(new DefaultListModel());
                
                if (line.equals("")) continue;
                if (line.charAt(0) == '[')
                {
                    String liczba = line.substring(1, line.indexOf('.'));
                    myWindow.jProgressBar1.setValue(Integer.parseInt(liczba));
                }
                else
                {
                    jakismodel.addElement(line);
                    myWindow.consoleList.setModel(jakismodel);
                    myWindow.consoleList.ensureIndexIsVisible(count++);
                    //myWindow.jList1.setSelectedIndex(count++);
                }
                if (line.substring(0, 5).equals("Pass "))
                {
                    String first = line.substring(5, line.indexOf(' ', 5));
                    String last  = line.substring(line.indexOf(" of ")+4, line.indexOf('.', line.indexOf(" of ")+4));
                    
                    int really = (int) Math.ceil((Integer.parseInt(first) - 1) * (float)100 / (Integer.parseInt(last) - 1));
                    myWindow.jProgressBar2.setValue(really);
                    
                    //jakismodel.addElement(new Integer(really).toString());
                    //myWindow.jList1.setModel(jakismodel);
                    //myWindow.jList1.ensureIndexIsVisible(count++);
                }
            }
        } catch (IOException e)
        {
            System.out.println("nieudane otwieranie " + command);
            return false;
        }
        finally {
            try{
                outputWriter.close();
                inputReader.close();
            }catch(Exception e){System.out.println("nieudane zamykanie "+command);}
        }
        myWindow.generateMapButton.setEnabled(true);
        return true;
    }
        
        
}
