public   class  Vertex {
	

	 private String  getValue__wrappee__BaseVertex  () {
		String out = "";
		out += String.valueOf(this.hashCode());
		return out;
	}

	
	
	 private String  getValue__wrappee__ColoredVertex  () {
		String out = getValue__wrappee__BaseVertex();
		out += String.format(" (%s)", this.color);
		return out;
	}

	

	public String getValue() {
		String out = getValue__wrappee__ColoredVertex();
		out += " \"label\" ";
		return out;
	}

	
	private String color = "pink";

	

	public void setColor(String color) {
		this.color = color;
	}

	

	private String label = "";

	

	
	public void setLabel(String label) {
		this.label = label;
	}


}
