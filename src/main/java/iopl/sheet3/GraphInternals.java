package iopl.sheet3;

//#if ColoredGraph 
enum Color {
	Blue, Yellow, Red, Green, Pink, White, Black, Orange, Brown, Purple
}
//#endif

class Vertex {
    private final int id;
  //#if LabeledGraph
//@    String label;
  //#endif
    
  //#if ColoredGraph
    Color color;
  //#endif 
    

    Vertex(final int id) {
        this.id = id;
    }

    int getId() {
        return this.id;
    }

    @Override
    public String toString() {
    	String out = new String();
        out = String.format("Vertex %d", this.id);
        //#ifdef  LabeledGraph
//@        out.concat(String.format("(%s)",
//@                (this.label != null)? this.label.toString() : ""));
        //#endif
        //#ifdef ColoredGraph
        out.concat(String.format("(%s)",
                (this.color != null)? this.color.toString() : ""));
        //#endif
        
        return out;
    }
    
  //#ifdef LabeledGraph
//@    public void setLabel(String label) {
//@
//@        this.label = label;
//@    }
  //#endif
    
  //#ifdef ColoredGraph
    public void setColor(Color color) {

        this.color = color;
    }
  //#endif
    
    
}

class Edge {

    protected final Vertex[] vertices;
  //#ifdef WeightedGraph
//@    private double weight;
  //#endif

  //#if !WeightedGraph
    Edge(Vertex v1, Vertex v2) {

        this.vertices = new Vertex[]{v1, v2};
    }
  //#endif
  //#if WeightedGraph
//@    Edge(Vertex v1, Vertex v2, double weight) {
//@    	
//@    	this.vertices = new Vertex[] {v1, v2};
//@        this.weight = weight;
//@    }
  //#endif
    
    public Vertex[] getVertices() {

        return this.vertices;
    }
    
  //#if WeightedGraph
//@    public double getWeight() {
//@
//@        return weight;
//@    }
//@
//@    public void setWeight(double weight) {
//@
//@        this.weight = weight;
//@    }
  //#endif

    @Override
    public String toString() {
    	
    	String out;
    	Double weight=1.0;
    	
    	//#if WeightedGraph 
//@    	weight=this.getWeight();
    	//#endif
    	
    	
    	
    	
    	out = String.format("%s --(%.2f)-- %s",
                this.vertices[0],
                weight,
                this.vertices[1]);
    	
    	
    	
    	//#if LabeledGraph && !ColoredGraph 
//@    	    	out = String.format("%s(%s) --(%.2f)-- %s(%s)",
//@    	                this.vertices[0],
//@    	                this.vertices[0].label,
//@    	                weight,
//@    	                this.vertices[1],
//@    	                this.vertices[1].label);
    	 //#endif
    	    	
    	    	//#if ColoredGraph && !LabeledGraph 
    	    	out = String.format("%s(%s) --(%.2f)-- %s(%s)",
    	                this.vertices[0],
    	                this.vertices[0].color,
    	    			weight,
    	                this.vertices[1],
    	                this.vertices[1].color);
    	 //#endif
    	
    	//#if ColoredGraph && LabeledGraph 
//@    	    	    	out = String.format("%s(%s,%s) --(%.2f)-- %s(%s,%s)",
//@    	    	                this.vertices[0],
//@    	    	                this.vertices[0].color,
//@    	    	                this.vertices[0].label,
//@    	    	                weight,
//@    	    	                this.vertices[1],
//@    	    	                this.vertices[1].color,
//@    	    	                this.vertices[1].label);
    	 //#endif
    	
        return out;
    }
}
