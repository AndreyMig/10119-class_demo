package model;

import java.util.Collection;
import java.util.TreeSet;

import post.Post;

public class User {

	private TreeSet<Post> posts = new TreeSet<Post>();
	
	public User(){
		
	}
	
	public void addPost(Post p){
		posts.add(p);
	}

	public Collection<Post> getPosts() {
		return posts;
	}
	
	
	
	
}
