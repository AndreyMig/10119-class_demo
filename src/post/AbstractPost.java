package post;

import java.util.Date;

public abstract class AbstractPost<T> implements Comparable<T> {

	protected String title;
	protected Date creationTime;

	public AbstractPost(String title) {
		this(new Date(), title);
	}

	public AbstractPost(Date creationDate, String title) {
		this.title = title;
		this.creationTime = creationDate;
	}

	@Override
	public abstract String toString();

	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}


}
