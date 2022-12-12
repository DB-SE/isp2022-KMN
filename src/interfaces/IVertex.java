package interfaces;
import java.util.List;

public interface IVertex {

	String toString();
	
	String getValue();
	
	void addDecorator(VertexDecorator decorator);
	
	public List<VertexDecorator> getDecorators();
}