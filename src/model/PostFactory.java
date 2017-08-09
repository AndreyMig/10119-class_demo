package model;

import utils.IFactory;

public class PostFactory implements IFactory<Post> {

	public static final String DEFAULT_UUID = "DEFAULT_UUID_CTR";
	public static final String DEFINED_UUID = "DEFINED_UUID_CTR";

	//
	//
	// public PostFactory(String uuid, String title, String text) {
	//
	// this.uuid = uuid;
	// this.title = title;
	// this.text = text;
	//
	//
	//
	// }
	//

	@Override
	public Post instatiate(String ctrType, String[] args) throws IllegalArgumentException, IndexOutOfBoundsException {
		

		switch(ctrType) {
		
		case DEFAULT_UUID:
			
			String title = args[0].trim();
			String text = args[1].trim();
			
			return new Post(title,text);
			
			
		
		}
		
		
		
		return null;
	}

}
