package Assign1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

public class Texalaassig1 {
	public static String getWebPageSource(String sURL) throws IOException {
        URL url = new URL(sURL);
        URLConnection urlCon = url.openConnection();
        BufferedReader in = null;

        if (urlCon.getHeaderField("Content-Encoding") != null
                && urlCon.getHeaderField("Content-Encoding").equals("gzip")) {
            in = new BufferedReader(new InputStreamReader(new GZIPInputStream(
                    urlCon.getInputStream())));
        } else {
            in = new BufferedReader(new InputStreamReader(
                    urlCon.getInputStream()));
        }

        String inputLine;
        StringBuilder sb = new StringBuilder();

        while ((inputLine = in.readLine()) != null)
            sb.append(inputLine);
        in.close();

        return sb.toString();

	}
	public static void main(String[] args){

		  try{

			  String r= new String(getWebPageSource("https://phptravels.com"));
			  System.out.println(r);
			  PrintWriter out = new PrintWriter(new FileWriter("web-content.txt"));
	   out.println(r);

		      out.close();
		      
		  }catch(Exception e){
		  }
	}
}

