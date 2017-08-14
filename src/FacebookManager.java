import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.xml.sax.HandlerBase;

import model.User;
import post.Post;

public class FacebookManager {

	private static int optionsCount = 1;
	private static final String END_COMMAND = "end";
	private static final String NEW_POST_COMMAND = "1";
	private static final String SHOW_FEED_COMMAND = "2";
	private static final String POST_TITLE_COUNT_COMMAND = "3";

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
			handleNewPost();
			break;

		case SHOW_FEED_COMMAND:
			handleShowFeed();
			break;

		case POST_TITLE_COUNT_COMMAND:
			countUserPostsByTitle();
			break;

		}
		
		

	}

	private void countUserPostsByTitle() {
		
		Collection<Post> userPosts = user.getPosts();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Post post : userPosts) {
			String title = post.getTitle();
			Integer count = map.get(title);
			if(count == null){
				map.put(title, 1);
			} else {
				map.put(title, count+1);
			}
			
		}
		
		Set< Entry<String, Integer> > entrySet = map.entrySet();
		
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		
		
	}

	private void handleShowFeed() {
		Collection<Post> userPosts = user.getPosts();

		//iterate over any collection with iterator
		Iterator<Post> userPostIterator = userPosts.iterator();
		while (userPostIterator.hasNext()) {
			Post post = userPostIterator.next();
			System.out.println(post);
		}

		//foreach on collection
		// for (Post post : userPosts) {
		// System.out.println(post);
		// }
		
	}

	private void handleNewPost(){

		System.out.println("title?");

		String postTitle = s.nextLine();

		System.out.println("text?");
		String postText = s.nextLine();
		Post newPost = new Post(postTitle, postText);

		user.addPost(newPost);
	}
	
	public String getUserInput() {
		String op = s.nextLine();

		return op;
	}

	private void printOptions() {
		System.out.println("Please.....");

//		System.out.println("new post, command", NEW_POST_COMMAND);
		
		System.out.println(NEW_POST_COMMAND+". new post, command " + NEW_POST_COMMAND);

		System.out.println(SHOW_FEED_COMMAND+". show feed, command " + SHOW_FEED_COMMAND);
		
		System.out.println(POST_TITLE_COUNT_COMMAND+". count posts by title, command " + POST_TITLE_COUNT_COMMAND);

	}
	
//	private String createOption(String optionDesc, String Command){
//		
//		String option = optionsCount + ". " + optionDesc
//		
//	}

	private void printWelcomeMessage() {
		System.out.println("Hi welcome to facebook");

	}

}
