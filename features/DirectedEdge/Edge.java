public class Edge {

	private Vertex origin;
	private Vertex target;
	
	public void setEdge(Vertex origin, Vertex target) {
		this.origin=origin;
		this.target=target;
	}

	public Vertex getOriginVertex() {
		return origin;
	}
	
	public Vertex getTargetVertex() {
		return target;
	}

	public boolean allowsTwoWayTraversal() {
		return false;
	}

	public int getValue() {
		int value=1;

		return value;
	}
}