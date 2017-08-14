package post;

import java.util.Date;

public class Post implements Comparable<Post>{

	private String title;
	private String text;
	private Date creationTime;
	
	public Post(String title, String text) {
		this(new Date(), title, text);
	}
	
	public Post(Date creationDate, String title, String text) {
		this.title = title;
		this.text = text;
		this.creationTime = creationDate;
	}

	@Override
	public int compareTo(Post o) {
//		return this.creationTime.compareTo(o.creationTime);
		
		
	}
	
	

	

	
}
