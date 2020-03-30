package mariz_problem2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter 
{
	HashMap<String, Integer> wordcounter = new HashMap<>();
	public void count(String dataFile) 
	{
	       try 
	       {
	    	   File inputfile = new File(dataFile);
	    	   Scanner fileinput = new Scanner(inputfile);
	    	   while (fileinput.hasNext()) 
	    	   {
		           String word = fileinput.next();
		           if (word != null && !word.isEmpty()) 
		           {
		               word = word.toLowerCase();
		               if (wordcounter.containsKey(word)) 
		               {
		                   wordcounter.put(word, wordcounter.get(word) + 1);
		               } 
		               else
		               {
		                   wordcounter.put(word, 1);
		               }
		            }
		        }
	    	   fileinput.close();
	    	}
	       catch(FileNotFoundException fx) 
	       {
	    	   System.out.println("Error while opening file: " + dataFile);
	    	   System.exit(1);
	       }	       
	}


	public void write(String outputFile) 
	{
		try {
			FileWriter fileoutput = new FileWriter(outputFile);
			for (Map.Entry<String, Integer> entry : wordcounter.entrySet())
				fileoutput.write("Times that \"" + entry.getKey() + "\" occurs is: " + entry.getValue() + ".\n");
			fileoutput.close();
			}
		catch(IOException ix) 
		{
			System.out.println("Error in writing to file: " + outputFile);
			System.exit(1);
		}
	}
}