package Assign3;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

import org.junit.jupiter.api.Test;

import Assign1.Texalaassig1;

class Junit {

	@Test
	public void testing() throws IOException {
		URL url = new URL("https://phptravels.com");
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
		String s =  Texalaassig1.getWebPageSource("https://phptravels.com");
System.out.println(sb.toString());
		assertEquals(sb.toString() , s);
		
	}

}
