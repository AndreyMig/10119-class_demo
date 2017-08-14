package post;

import model.IFactory;



public class PostFactory implements IFactory<Post>{

	@Override
	public Post instatiate(String ctrType, String[] args) {
		

		
		return new Post(args[0], args[1]);
		
	
//			}
		
		
	}
	
	
}