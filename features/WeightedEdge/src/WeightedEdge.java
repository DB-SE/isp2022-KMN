import interfaces.EdgeDecorator;

public class WeightedEdge implements EdgeDecorator<Integer> {
	private int weight;

	public void setDecorator(Integer value) {
		this.weight = value;
	}

	@Override
	public Integer getValue() {
		return this.weight;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.weight);
	}
}