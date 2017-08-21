import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import post.Post;
import post.PostDecorator;
import post.PostFactory;
import model.IFactory;
import user.User;

public class ConsoleView {
	private static final String END_COMMAND = "binyamin";
	private static final String NEW_POST_COMMAND = "1";
	private static final String SHOW_FEED_COMMAND = "2";

	private User debugUser = new User("TEST");
	private IFactory<Post> postFactory = new PostFactory();
	private final static Scanner s = new Scanner(System.in);

	public void init() {

		String op = "";
		while (op.compareToIgnoreCase(END_COMMAND) != 0) {

			printWelcomeMessage();

			printOptions();

			op = getUserInput();

			processUserInput(op);

		}
		System.out.println("Facebook over");
		s.close();

	}

	private void processUserInput(String op) {

		switch (op) {

		case NEW_POST_COMMAND:
			newPost();
			break;
		case SHOW_FEED_COMMAND:

			showFeed();

			break;

		}

	}

	private void newPost() {
		System.out.println("title?");

		String postTitle = s.nextLine();

		System.out.println("text?");
		String postText = s.nextLine();

		String[] postArgs = { postTitle, postText };

		debugUser.addPost(postFactory.instatiate("", postArgs));

	}

	private void showFeed() {

		Map<String, Post> postsMap = debugUser.getPosts();

		Set<Entry<String, Post>> postsEntrySet = postsMap.entrySet();

		ArrayList<PostDecorator> postsDecs = new ArrayList<PostDecorator>();

		Map<String, PostDecorator> mySortedMap = new TreeMap<String, PostDecorator>();

		for (Entry<String, Post> entry : postsEntrySet) {
			entry.getKey();
			entry.getValue();

			PostDecorator postDec = new PostDecorator(entry.getValue());
			postsDecs.add(postDec);
		}

		Map<String, Integer> utilsMapForCounting = new HashMap<String, Integer>();

		for (PostDecorator postDecorator : postsDecs) {

			String title = postDecorator.getPost().getTitle();

			if (utilsMapForCounting.get(title) == null) {

				utilsMapForCounting.put(title, 1);

			}

		}

		// set itertaions
		// for (Post post : postsCollection) {
		// System.out.println(post);
		// }
		//
		// Iterator<Post> postsIterator = postsCollection.iterator();
		// while (postsIterator.hasNext()) {
		// Post post = postsIterator.next();
		// System.out.println(post);
		// }

	}

	private String getUserInput() {
		// Scanner s = new Scanner(System.in);

		String op = s.nextLine();

		return op;
	}

	private void printOptions() {
		System.out.println("Please.....");

		System.out.println(NEW_POST_COMMAND + ": new post");

		System.out.println(SHOW_FEED_COMMAND + ": show feed");
		System.out.println(END_COMMAND + ": end app");

	}

	private void printWelcomeMessage() {
		System.out.println("Hi");

	}

}
