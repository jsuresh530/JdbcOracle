
package com.urlreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class URLReading
{

	public static void main(String[] args)
	{
		System.out.println("\nOutput: \n" + callUrl("http://cdn.crunchify.com/wp-content/uploads/code/json.sample.txt"));
	}

	public static String callUrl(String urls)
	{
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader isr = null;

		try
		{
			URL url = new URL(urls);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setConnectTimeout(1000 * 60);
			if (urlConn != null && urlConn.getInputStream() != null)
			{
				isr = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				BufferedReader br = new BufferedReader(isr);
				if (br != null)
				{
					int cp;
					while ((cp = br.read()) != -1)
					{
						sb.append((char) cp);
					}
					br.close();
				}
			}
			isr.close();

		} catch (Exception e)
		{
			throw new RuntimeException("Exception while calling URL:"+ urls, e);
		}

		return sb.toString();
	}

}
