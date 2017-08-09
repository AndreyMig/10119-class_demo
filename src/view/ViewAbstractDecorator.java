package view;

public abstract class ViewAbstractDecorator<T> implements IViewable<T> {

	
	
	private T t;
	
	public ViewAbstractDecorator (T t){
		this.t = t;
	}

	
	public T getContainedObject(){
		return t;
	}
	
	
	
	

}
