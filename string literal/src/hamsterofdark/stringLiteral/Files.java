package hamsterofdark.stringLiteral;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author michlandry
 *
 */
public class Files{
	static String defaultDirectory = "C:/Users/michlandry/Downloads/";

	public static String readFile(String filePath) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(filePath));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	/**
	  * This method creates a file in the specified filepathwith file name
	  * it will contain 2 stupid lines of text.
	  * 
	  * @param filePath the filepath with the file name included
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void createFile(String filePath, String content) throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter writer = new PrintWriter(String.format(filePath), "UTF-8");
		System.out.println("file created");
		writer.print(content);
		writer.close();
	}
	
	
	/**
	 * This file will take in a file name in the directory
	 * C:\Users\michlandry\Downloads
	 * and copy it to the same directory with the name copy - xxx
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	public static void fixFile(String fileName) throws IOException
	{
		String content = readFile(defaultDirectory + fileName);
		content = StringUtil.fixCode(content);
		createFile(defaultDirectory + "copy - " + fileName, content);
		
		
		
	}
}
