package post;

import java.util.UUID;

public class Post implements Comparable<Post> {

	private String title;
	private String text;
	private String uuid;

	// UUID idOne =

	public Post(String title, String text) {
		this(UUID.randomUUID().toString(), title, text);
	}

	public Post(String uuid, String title, String text) {
		this.title = title;
		this.text = text;
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return this.title;
	}

	public String getUuid() {
		return uuid;
	}

	@Override
	public int compareTo(Post o) {
		// TODO Auto-generated method stub
		return this.title.compareTo(o.title) >= 0 ? 1 : -1;
	}

	public String getText() {
		return text;
	}

	public String getTitle() {
		return title;
	}

}
