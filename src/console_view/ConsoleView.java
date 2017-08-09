package console_view;

import java.util.Scanner;

import view.ViewBase;

public class ConsoleView extends ViewBase {

	private static final String NEW_POST_COMMAND = "post";
	private static final int INITIAL_OPTION_NUMBER = 1;
	private static final String ASK_INPUT_MESSAGE = "Type in one of the following operations:";
	private int currentOption = INITIAL_OPTION_NUMBER;

	public ConsoleView(String[] editableFields, String[] presentaAbleStrings) {
		super(editableFields, presentaAbleStrings);
	}

	public void init() {

		while (true) {

			showOptions();

			String op = waitForUserInput();
			if (op.compareToIgnoreCase("end") == 0) {
				return;
			}

			handleOptions(op);

		}

	}

	private void handleOptions(String op) {
		switch (op) {
		case NEW_POST_COMMAND:
			newPost();
			break;

		default:
			break;
		}

	}

	private void newPost() {
		// TODO Auto-generated method stub
		
	}

	private String waitForUserInput() {

		Scanner s = new Scanner(System.in);

		String op = s.nextLine();

		s.close();
		return op.trim();
	}

	private void showOptions() {

		System.out.println(ASK_INPUT_MESSAGE);
		printOption(NEW_POST_COMMAND);
	}

	private void printOption(String op) {
		System.out.println(currentOption++ + ": " + op);

		currentOption = INITIAL_OPTION_NUMBER;
	}

}
