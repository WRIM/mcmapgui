/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mcmap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author WRIM
 */
public class Controller extends Thread{

    static int licznik = 0;
    
    public static void runProcess(String command) {
        if (0==0)return;
        
        BufferedWriter outputWriter = null;
        BufferedReader inputReader = null;
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();
            
            System.out.println("nazwa "+command);
            outputWriter = new BufferedWriter(new OutputStreamWriter(
                    outputStream));
            inputReader = new BufferedReader(new InputStreamReader(inputStream));
 
            String line = null;
            while ((line = inputReader.readLine()) != null) {
                processLine(line);
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
    }

    private static void processLine(String line) {
        System.out.println(++licznik + ": " + line);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException   
    {
     
        File appdata = new File(System.getenv("APPDATA")+"");
        if (System.getenv("APPDATA") == null)
        {
            appdata = new File(System.getProperty("user.home")+"");
        }
        File[] files = appdata.listFiles();
        for (File file: files)
        {
            if (file.isDirectory())
            System.out.println(file.getName());
        }
        
        
        new Window();

        for (int i = 0; i < 0; i++) {
            new Controller().start();
        }

        
        Thread.sleep(100);
        runProcess("d:/dropbox/path/mcmap.exe");
        Thread.sleep(100);
        runProcess("d:\\dropbox\\komlogo\\comlogo.exe");
        
        System.out.println(System.getenv("APPDATA"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("os.name"));
        
        System.out.println(System.getProperties().toString().replace(',', '\n'));
        System.out.println("--------------------------------------");
        System.out.println(System.getenv().toString().replace(',', '\n'));
        
        
        System.out.println(System.getProperty("user.language"));
        System.out.println(System.getProperty("file.separator"));
        

    }
    
    public void run()
    {
        System.out.println("runnąłem się");
        runProcess("d:\\dropbox\\path\\mcmap.exe c:\\users\\tomek\\appdata\\roaming\\.minecraft\\saves\\m -file testmcmapjava.png");
        
    }
    
}


/*

    public static void runProcess(String command) throws IOException {
        BufferedWriter outputWriter = null;
        BufferedReader inputReader = null;
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();
            outputWriter = new BufferedWriter(new OutputStreamWriter(
                    outputStream));
            inputReader = new BufferedReader(new InputStreamReader(inputStream));
 
            String line = null;
            while ((line = inputReader.readLine()) != null) {
                processLine(line);
            }
        } finally {
            outputWriter.close();
            inputReader.close();
        }
    }

    private static void processLine(String line) {
        System.out.println(line);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("");
        runProcess("top -b -n 1");
 
    }


*/