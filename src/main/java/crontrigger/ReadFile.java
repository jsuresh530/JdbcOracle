package crontrigger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFile implements Runnable{
	private static ReadFile file =null;
	Properties properties =new Properties();
	
	private ReadFile()
	{
		//new Thread(new ReadFile()).start();
	}

	public static  ReadFile getInstance()
	{
		if(file == null)
		{
			//synchronized (ReadFile.class) {
				if(file == null)
				{
					file =new ReadFile();
				}
			//}
		}
		return file;
	}

	@Override
	public void run() {
		long modifyTime =0;
		while(true)
		{
			File f = new File("src/main/resources/database.properties");
			try {
				if(!f.exists())
				{
					System.out.println("file not exists");
				}
				
				if(modifyTime != f.lastModified())
				{
					modifyTime = f.lastModified();
					properties.load(new FileInputStream(f));
					System.out.println("DATA "+properties.getProperty("driverclass"));
					
				}
			} catch ( IOException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
