public class Vertex {

	public String getValue() {
		String out = "";
		out += String.valueOf(this.hashCode());
		return out;
	}
}