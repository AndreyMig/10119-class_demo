package user;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import post.Post;

public class User {

	private String name;
	// private Set<Post> posts;

	private Map<String, Post> postMap;

	// private String text;

	public User(String name) {
		this.name = name;

		this.postMap = new HashMap<String, Post>();
		// this.posts = new TreeSet<Post>();
	}

	public void addPost(Post p) {
		// this.posts.add(p);

		this.postMap.put(p.getUuid(), p);

	}

	//
	// public Collection<Post> getPosts() {
	// return posts;
	// }

	public Map<String, Post> getPosts() {
		return postMap;
	}

}
