import java.util.Scanner;

import model.User;
import post.Post;

public class FacebookManager {

	private static final String END_COMMAND = "end";
	private static final String NEW_POST_COMMAND = "new-post";

	private User user = new User();
	private Scanner s = new Scanner(System.in);

	public void init() {

		String op = "";

		while (op.compareToIgnoreCase(END_COMMAND) != 0) {

			printWelcomeMessage();

			printOptions();

			op = getUserInput();

			processUserInput(op);
		}

		s.close();
		System.out.println("FACEBOOK OVER");
	}

	private void processUserInput(String op) {

		switch (op) {

		case NEW_POST_COMMAND:

			System.out.println("title?");

			String postTitle = s.nextLine();
			

			System.out.println("text?");
			String postText = s.nextLine();
			Post newPost = new Post(postTitle, postText);

			break;
		}

	}

	public String getUserInput() {
		String op = s.nextLine();

		return op;
	}

	private void printOptions() {
		System.out.println("Please.....");

		System.out.println("1. new post, command " + NEW_POST_COMMAND);

	}

	private void printWelcomeMessage() {
		System.out.println("Hi welcome to facebook");

	}

}
