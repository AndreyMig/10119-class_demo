package view;

public abstract class ViewDecorator<T> implements IViewable<T> {

	
	
	private T t;
	
	public ViewDecorator (T t){
		this.t = t;
	}

	
	
	

}
