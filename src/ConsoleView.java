import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import model.User;
import post.Post;
import post.PostFieldCounterDecorator;
import post.PostTitleIgnoreCaseCompartor;
import utils.Config;

public class ConsoleView {

	private User user = new User();
	private Scanner s = new Scanner(System.in);

	public void init() {

		String op = "";

		while (op.compareToIgnoreCase(Config.END_COMMAND) != 0) {

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

		case Config.NEW_POST_COMMAND:
			handleNewPost();
			break;

		case Config.SHOW_FEED_COMMAND:
			handleShowFeed();
			break;

		case Config.POST_TITLE_COUNT_COMMAND:
			countUserPostsByTitle();
			break;

		case Config.SORT_POSTS_BY_TITLE_NO_CASE:
			sortPostsByTitleIgnoreCase();
			break;

		case Config.SORT_POSTS_BY_TITLE_OCCURENCE:
			sortPostsByTitleOccurence();
			break;

		}

	}

	private void sortPostsByTitleOccurence() {
		Collection<Post> userPosts = user.getPosts();

		Map<PostFieldCounterDecorator, Integer> map = new HashMap<PostFieldCounterDecorator, Integer>();

		Iterator<Post> it = userPosts.iterator();

		while (it.hasNext()) {

			Post p = it.next();

			PostFieldCounterDecorator pd = new PostFieldCounterDecorator(p,
					PostFieldCounterDecorator.TEXT_FIELD);

			Integer count = map.get(pd);

			if (count == null) {
				map.put(pd, 1);
			} else {
				map.put(pd, count + 1);
			}


		}


		Map<Integer, Post> tm = new TreeMap<Integer, Post>(
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						if (o1 - o2 >= 0)
							return 1;
						else {
							return -1;
						}
					}
				});

		for (Entry<PostFieldCounterDecorator, Integer> e : map.entrySet()) {
			tm.put(e.getValue(), e.getKey().getPost());
		}

		for (Entry<Integer, Post> e : tm.entrySet()) {
			System.out.println(e.getKey() + "  " + e.getValue().getTitle());
		}

	}

	private void sortPostsByTitleIgnoreCase() {
		Collection<Post> userPosts = user.getPosts();

		Set<Post> ts = new TreeSet<Post>(new PostTitleIgnoreCaseCompartor());

		for (Post post : userPosts) {
			ts.add(post);

		}

		for (Post post : ts) {
			System.out.println(post.getTitle());
		}

	}

	private void countUserPostsByTitle() {

		Collection<Post> userPosts = user.getPosts();

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (Post post : userPosts) {
			String title = post.getTitle();
			Integer count = map.get(title);
			if (count == null) {
				map.put(title, 1);
			} else {
				map.put(title, count + 1);
			}

		}

		Set<Entry<String, Integer>> entrySet = map.entrySet();

		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}

	}

	private void handleShowFeed() {
		Collection<Post> userPosts = user.getPosts();

		// iterate over any collection with iterator
		Iterator<Post> userPostIterator = userPosts.iterator();
		while (userPostIterator.hasNext()) {
			Post post = userPostIterator.next();
			System.out.println(post);
		}

		// foreach on collection
		// for (Post post : userPosts) {
		// System.out.println(post);
		// }

	}

	private void handleNewPost() {

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

		// System.out.println("new post, command", NEW_POST_COMMAND);

		System.out.println(Config.NEW_POST_COMMAND + ". new post, command "
				+ Config.NEW_POST_COMMAND);

		System.out.println(Config.SHOW_FEED_COMMAND + ". show feed, command "
				+ Config.SHOW_FEED_COMMAND);

		System.out.println(Config.POST_TITLE_COUNT_COMMAND
				+ ". count posts by title, command "
				+ Config.POST_TITLE_COUNT_COMMAND);

		System.out.println(Config.SORT_POSTS_BY_TITLE_NO_CASE
				+ ". count posts by title, command "
				+ Config.SORT_POSTS_BY_TITLE_NO_CASE);

		System.out.println(Config.SORT_POSTS_BY_TITLE_OCCURENCE
				+ ". count posts by title, command "
				+ Config.SORT_POSTS_BY_TITLE_OCCURENCE);

	}

	private void printWelcomeMessage() {
		System.out.println("Hi welcome to facebook");

	}

}
