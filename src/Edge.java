public   class  Edge {
	
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
		return true;
	}

	
	
	public Integer getValue  () {
		return this.weight;
	}

	

	private int weight = 1;

	
	
	public void setWeight(int weight) {
		this.weight = weight;
	}


}
