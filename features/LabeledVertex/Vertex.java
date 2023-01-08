public class Vertex {

	private String label = "";

	public String getValue() {
		String out = original();
		out += " \"label\" ";
		return out;
	}

	
	public void setLabel(String label) {
		this.label = label;
	}
}