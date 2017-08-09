package model;

public class Post extends Model {

	private String uuid;
	private String title;
	private String text;

	public Post(String uuid, String title, String text) {

		super(uuid);
		this.title = title;
		this.text = text;

	}

	public Post(String title, String text) {
		this.title = title;
		this.text = text;
	}

}
