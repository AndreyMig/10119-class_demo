package post;

import java.util.Comparator;
import java.util.Date;

public class PostTitleIgnoreCaseCompartor implements Comparator<Post> {

	@Override
	public int compare(Post p1, Post p2) {
		return p1.getTitle().compareToIgnoreCase(p2.getTitle()) >= 0 ? 1 : -1;
	}

}
