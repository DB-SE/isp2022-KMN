package interfaces;

public interface IVertex {

	String toString();
	
	String getValue();
	
	void addDecorator(VertexDecorator decorator);
}
