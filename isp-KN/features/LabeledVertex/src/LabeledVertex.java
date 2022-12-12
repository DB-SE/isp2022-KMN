import interfaces.VertexDecorator;

public class LabeledVertex implements VertexDecorator {

private String label;
	
	public void setDecorator(String value){
		this.label=value;
	}

	@Override
	public String getValue() {
		return this.label;
	}

	@Override
	public String toString() {
		return this.label;
	}

}
