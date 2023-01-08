public class Vertex {
	private String color = "pink";

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getValue() {
		String out = original();
		out += String.format(" (%s)", this.color);
		return out;
	}
}