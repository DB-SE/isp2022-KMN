package interfaces;

public interface IEdge {

	IVertex getOriginVertex();
	
	IVertex getTargetVertex();
	
	boolean allowsTwoWayTraversal();
	
	String toString();
	
	int getValue();
	
	void addDecorator(EdgeDecorator<?> decorator);
}
