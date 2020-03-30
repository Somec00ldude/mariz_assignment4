package mariz_problem1;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
	Set<String> uniquewords;
	public void remove(String dataFile) 
	{
		try 
		{
			File inpfile = new File(dataFile);
			Scanner fileinput = new Scanner(inpfile);
			uniquewords = new LinkedHashSet<>();
			while(fileinput.hasNextLine()) {
				String line = fileinput.nextLine();
				String[] word = line.split(" ");
				for(int i = 0; i < word.length; i++) 
				{
					String string = word[i].toLowerCase();
					uniquewords.add(string);
				}
			}
			fileinput.close();
		}
		catch(Exception x)
		{
			System.out.println("Error while opening file: " + dataFile);
			System.exit(1);
		}
	}
	public void write(String outputFile)
	{
		try 
		{
			FileWriter outputdoc = new FileWriter(outputFile);
			for(String outwords:uniquewords)
				outputdoc.write(outwords + "\n");
			outputdoc.close();
		}
		catch(Exception xx)
		{
			System.out.println("Error while writing to file: " + outputFile);
			System.exit(1);
		}
	}

}
