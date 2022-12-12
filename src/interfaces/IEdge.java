package interfaces;

public interface IEdge {

	IVertex getOriginVertex();
	
	IVertex getTargetVertex();
	
	public void setEdge(IVertex origin, IVertex target);
	
	boolean allowsTwoWayTraversal();
	
	String toString();
	
	int getValue();
	
	void addDecorator(EdgeDecorator<?> decorator);
}