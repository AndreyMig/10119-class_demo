import java.util.Scanner;

public class App {

	private static final String END_COMMAND = "end";
	
	
	public static void main(String[] args) {
		

		
		while(true) {
			
			printWelcomeMessage();
			
			printOptions();
			
			
			String op  = getUserInput();
			if (op.compareToIgnoreCase(END_COMMAND) == 0) {
				return;
			}
			
			
			
			processUserInput(op);
			
			
			
			
			
			Scanner s = new Scanner(System.in);
			
			String op = s.nextLine();
			
			switch(op){
			
			case "new-post" :
			
				System.out.println("title?");

				String postTitle = s.nextLine();
				
				System.out.println("text?");
				String postText = s.nextLine();
				
			break;
			
			
			}
			
			
			
		}
		
		}

	private static void processUserInput(String op) {
		// TODO Auto-generated method stub
		
	}

	private static String getUserInput() {
		// TODO Auto-generated method stub
		return null;
	}

	private static void printOptions() {
		System.out.println("Please.....");
		
		System.out.println("1: new post");
		
	}

	private static void printWelcomeMessage() {
		System.out.println("Hi");
		
	}
	
	
	
	
}
