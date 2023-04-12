/******************************************************************************
 * Bellevue Class: CS 210
 *           Term: Winter 2014
 *     Instructor: Robert Main
 *     
 *  Textbook: Building Java Programs, A Back to Basics Approach
 *   Edition: 3rd
 *   Authors: Stuart Reges and Marty Stepp
 *   
 *   Chapter: 9
 * Exercises: 5, 6, 7, and 8
 *      Page: 643
 *
 * Instructor Project Solution
 * Assigned Project: 10
 *
 * Class Name: Project10_EventTickets
 *  File Name: Project10_EventTickets.java
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     03/12/2014  Initial Release
 *
 * File Description
 * ----------------
 * This file defines the the class "Project10_EventTickets", which includes all
 * methods, variables, and constant values. Specifically, this class contains
 * the Console application entry method, main(), which is a static method,
 * since no object of the class type is ever instantiated.
 * 
 * Class Methods
 * -------------
 *     Name                                Description
 * ------------  --------------------------------------------------------------
 * main          The OS transfers control to this method upon program execution
 * introduction  Describes the Project Solution to the User
 *
 ******************************************************************************
 */
// Imported Packages
package Chapter9;
import java.util.Scanner;


public class Project10_EventTickets
{	
	/**************************************************************************
	 * Method: main(String[])
	 * 
	 * Program Description
	 * -------------------
	 * This program tests the implementation of the abstract "Ticket" class
	 * and its derived, concrete classes "WalkupTicket", "AdvanceTicket", and
	 * "StudentAdvanceTicket", which is derived from "AdvanceTicket".
	 * 
	 * Concrete objects are created and references to them are stored in an
	 * array of "Ticket" reference elements. The objects created are picked
	 * to test the various advance date requirements for the price of the
	 * ticket (based on the purchase days before the ticket event).
	 * 
	 * Once the array is established, it is iterated and the results of each
	 * object displayed via the overridden class "Object", "toString()" method.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * void
	 *
	 * ------------------------------- Arguments ------------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * String[]  args          Array of "string" argument(s) passed to main()
	 *                         when the Console program is invoked by the User.
	 * 
	 * Invoked Methods
	 * ---------------
	 * None
	 *
	 **************************************************************************
	 */
	public static void main(String[] args)
	{
		// Create ticket objects of the three ticket types
		WalkupTicket walkup =    new WalkupTicket(1);
		AdvanceTicket advance1 = new AdvanceTicket(2, 12);
		AdvanceTicket advance2 = new AdvanceTicket(3, 5);
		StudentAdvanceTicket student1 = new StudentAdvanceTicket(4, 15);
		StudentAdvanceTicket student2 = new StudentAdvanceTicket(5,3);
		
		// Create an array of references to event Tickets, the element references
		// to the sub-class ticket objects created above
        Ticket[] tickets = { walkup, advance1, advance2, student1, student2 };
        
        
        
        // Describe the Project Solution to the User
        introduction();
        
        // Now iterate the list, displaying the ticket number and price
        for (Ticket ticket : tickets)
        	System.out.println(ticket);
 
	}   // End method: main(String[])
	
	
	/**************************************************************************
	 * Method: introduction()
	 * 
	 * Method Description
	 * ------------------
	 * This static method describes the Project solution to the User.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * void
	 *
	 * ------------------------------- Arguments ------------------------------
	 *  None: All required "parameters" defined as "static", at Class scope
	 * 
	 * Invoked Methods
	 * ---------------
	 * None
	 *
	 **************************************************************************
	 */
	private static void introduction()
	{
		// Construct the first line of the Introduction: The Project #
		String line1 = "CS-" + COURSE_NUMBER + ": Project #" + PROJECT_NUMBER +
					   " Solution";
		
		// Construct the second line of the Introduction: Chapter, Exercise(s)
		// and the page number in the text
		// Start the second line with the text Chapter number and page number
		String line2 = "Chapter " + CHAPTER_NUMBER + ", page " + PAGE_NUMBER +
					   ", Exercise";
		// Now add the Exercise number(s)
		if (EXERCISE_NUMBERS.length == 1)
		{	// Only 1 Exercise number
			line2 += (" #" + EXERCISE_NUMBERS[0]);
		}
		else
		{	// Multiple Exercise numbers to display...
			line2 += "s ";  // Add the 's' to "Exercise"
			// Now add the Exercise number(s) to the second line
			for (int index = 0; index < EXERCISE_NUMBERS.length - 1; ++index)
				line2 += ("#" + EXERCISE_NUMBERS[index] + ", " );
			line2 += ("and #" + EXERCISE_NUMBERS[EXERCISE_NUMBERS.length - 1]);
		}
		
		// Now determine the field width of the first line so that it is centered
		// above the second line
		int line1FieldWidth = line1.length() + (CONSOLE_LINE_LENGTH - line1.length()) / 2;
		int line2FieldWidth = line2.length() + (CONSOLE_LINE_LENGTH - line2.length() ) / 2;
		String line1Format = "%" + line1FieldWidth + 's';
		String line2Format = "%" + line2FieldWidth + 's';
		
		// Now display both lines
		System.out.printf(line1Format + "\n" + line2Format + "\n\n", line1, line2);
		
		// Next, format the text "String" to have lines that are approximately
		// the length of Line #2
		Scanner parser = new Scanner(DESCRIPTION_TEXT);
		int lineLength = 0;
		String nextLine = "";
		while (parser.hasNext() )
		{
			String token = parser.next();
			int tokenLength = token.length();
			if (lineLength + tokenLength < (CONSOLE_LINE_LENGTH + LINE_LENGTH_TOLERANCE) )
			{
				nextLine += (token + " ");
				lineLength += (tokenLength + 1);
			}
			else
			{
				System.out.println(nextLine);
				nextLine = (token + " ");
				lineLength = token.length() + 1;
			}
		}
		parser.close();
		if (nextLine.length() > 0)
			System.out.println(nextLine);
		
		System.out.println("\n");
	}
	
	
	// Class Private "static", constant "final" Values
	// Project Description items
	// 1. CS Course Number
	private static final int COURSE_NUMBER = 210;
	// 2. Textbook Project Number, Chapter Number, Page Number, and Exercise Number(s)
	private static final int PROJECT_NUMBER = 10;
	private static final int CHAPTER_NUMBER = 9;
	private static final int PAGE_NUMBER = 643;
	private static int[] EXERCISE_NUMBERS = { 5, 6, 7, 8 };
	// 3. Description text
	private static String DESCRIPTION_TEXT =
			"This program tests the implementation of the abstract \"Ticket\" class " +
					"and its derived, concrete classes \"WalkupTicket\", \"AdvanceTicket\", and " +
					"\"StudentAdvanceTicket\", which is derived from \"AdvanceTicket\".";

	private static final int CONSOLE_LINE_LENGTH = 68;
	private static final int LINE_LENGTH_TOLERANCE = 5;
	
}   // End class definition: Project10_EventTickets