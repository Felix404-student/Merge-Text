package mergeText;
import java.util.*;
import java.io.*;

/**
 * @author Justin Brown
 * Backend class for text file merger project
 */
public class MergeText {
	/**
	 * Constructor intentionally left blank
	 */
	MergeText() {
		
	}
	/**
	 * Takes in two file names and combines the text files into one single output file
	 * @param questionFile name of text file 1
	 * @param answerFile name of text file 2
	 * @param solutionFile name of newly created output file
	 */
	public void MergeFiles(String questionFile, String answerFile, String solutionFile) {
		try {
			Scanner qScanner = new Scanner(new File(questionFile));
			Scanner aScanner = new Scanner(new File(answerFile));
			
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(solutionFile));
			
			File newFile = new File(solutionFile);
			newFile.createNewFile();
			
			while(qScanner.hasNextLine() && aScanner.hasNextLine()) {
				String next = qScanner.nextLine();
				fileWriter.println(next);
				
				next = aScanner.nextLine();
				fileWriter.println(next);
			}
			
			System.out.println("Done.\nThe file should be named \"" + solutionFile + "\"");
			
			qScanner.close();
			aScanner.close();
			fileWriter.close();
			
		} catch(Exception e) {
			System.out.println("Encountered a problem, exiting");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
}
