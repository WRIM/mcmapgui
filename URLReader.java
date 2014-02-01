package mcmap;

import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL site = new URL("http://wrim.pl/dl/mcmap/v.txt");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(site.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
