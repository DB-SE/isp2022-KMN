import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import interfaces.IVertex;
import interfaces.VertexDecorator;


public class BaseVertex implements IVertex {
	private List<VertexDecorator> decorators = new ArrayList<>();


	@Override
	public String getValue() {
		String value = String.valueOf(this.hashCode());
		for(VertexDecorator d: decorators) {
			value+=String.format("(%s)", d.getValue());
		}
		return value;
	}

	@Override
	public void addDecorator(VertexDecorator decorator) {
		this.decorators.add(decorator);
	}

	@Override
	public <T> List<VertexDecorator> getDecoratorOf(Class<T> clazz) {
	
		return this.decorators.stream().filter(d->true).collect(Collectors.toList());
	}

}
