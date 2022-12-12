package interfaces;

public interface EdgeDecorator<T> {
	
	public void setDecorator(Integer value);

	String toString();
	
	T getValue();
}
