package post;

import java.util.Date;

public class Post extends AbstractPost<Post> {

	private String text;
	private Date creationTime;

	public Post(String title, String text) {
		this(new Date(), title, text);
	}

	public Post(Date creationDate, String title, String text) {
		super(creationDate, title);
		this.text = text;
	}

	@Override
	public int compareTo(Post o) {
		return -1;//this.title.compareTo(o.title);
	}

	@Override
	public String toString() {
		return this.title + "\n" + this.text;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}
}
