import interfaces.VertexDecorator;

public class ColoredVertex implements VertexDecorator {
	private String color;
	
	public void setDecorator(String value){
		this.color=value;
	}

	@Override
	public String getValue() {
		return this.color;
	}

	@Override
	public String toString() {
		return this.color;
	}
}