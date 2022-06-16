package mergeText;
import java.util.Scanner;
import java.io.*;

/**
 * @author Justin Brown
 * User interface class for text file merger project
 */
public class MergeTextDriver {
	private MergeText user = new MergeText();
	private static MergeTextDriver driver = new MergeTextDriver();
	private static final String menu = "Please make a selection:\nEnter 1 to provide the file names for the text documents to be combined\nEnter 2 to quit the program.";
	private Scanner input;
	
	/**
	 * Constructor
	 */
	private MergeTextDriver() {
		input = new Scanner(System.in);
	}
	
	/**
	 * Manages the menu flow of control
	 */
	public void run() {
		int choice;
		choice = GetChoice();
		
		switch(choice) {
		case(1):
			GetFileNames();
			break;
		case(2):
			System.exit(0);
			break;
		default:
			System.out.println("Error in role selection");
			break;
		}		
	}
	
	/**
	 * Prompts the user to pick a menu option and makes sure the User picks one of the menu options available
	 * @return An integer representing the User's choice from the menu
	 */
	public int GetChoice() {
		int choice = -1;
		
		while (choice < 1 || choice > 2) {
			System.out.println(menu);
			String choiceString = input.nextLine();
			try {
				choice = Integer.parseInt(choiceString);
			} catch (Exception e) {
				choice = GetChoice();
			}
		}
		return choice;
	}
	
	/**
	 * Prompts the user to enter the file names of the question and answer files and runs MergeText.java on them
	 */
	public void GetFileNames() {
		Scanner scanner = new Scanner(System.in);
		
		String userInput1 = new String("");
		String userInput2 = new String("");
		String userInput3 = new String("");
		
		while (!(userInput1.endsWith(".txt"))) {
			System.out.println("Enter the file name of the Question file:");
			userInput1 = scanner.nextLine();
		}
		
		while (!(userInput2.endsWith(".txt"))) {
			System.out.println("Enter the file name of the Answers file:");
			userInput2 = scanner.nextLine();
		}
		
		while (!(userInput3.endsWith(".txt"))) {
			System.out.println("Enter a file name for your Output file:");
			userInput3 = scanner.nextLine();
		}
		
		user.MergeFiles(userInput1, userInput2, userInput3);
		
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Text File Merger!\nThis will combine a question file and an answer file, alternating lines.");
		
		driver.run();
	}
	
	
}
