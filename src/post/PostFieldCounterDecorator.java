package post;

import java.util.Date;

public class PostFieldCounterDecorator implements
		Comparable<PostFieldCounterDecorator> {

	public static final String TEXT_FIELD = "text";

	private Post post;
	private int count;

	private String field;

	public PostFieldCounterDecorator(Post p, String field) {

		this.post = p;
		this.field = field;
		this.count = 0;

	}

	public void plus1() {
		this.count++;
	}

	public String getCountableField() {
		switch (field) {
		case TEXT_FIELD:

			return post.getText();
		}
		return post.getText();
	}

//	@Override
//	public boolean equals(Object obj) {
//
//		if (obj instanceof PostFieldCounterDecorator) {
//			PostFieldCounterDecorator other = (PostFieldCounterDecorator) obj;
//			return getField().equals(other.getField());
//		}
//		return false;
//	}

	// this is needed to use objects as keys
//	@Override
//	public int hashCode() {
//		return getField().hashCode();
//	}

	public Post getPost() {
		return this.post;
	}

	/**
	 * helper method to return the field of post that we want to count
	 */
	private String getField() {
		switch (field) {
		case TEXT_FIELD:

			return post.getText();
		}
		return null;
	}

	@Override
	public int compareTo(PostFieldCounterDecorator p) {

		return getField().compareTo(p.getField());

	}
}
