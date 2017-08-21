package post;

import java.util.UUID;

public class PostDecorator implements Comparable<Post> {

	private Post post;

//	private long numberOfTextLengthRepetitions;
	
	private int count;
	
	public PostDecorator(Post p) {

		this.post = p;

	}
	
	public Post getPost() {
		return post;
	}

	@Override
	public int compareTo(Post p) {
		// TODO Auto-generated method stub
		return this.post.compareTo(p);
	}

}
