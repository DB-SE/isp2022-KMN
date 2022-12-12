import java.util.ArrayList;
import java.util.List;

import interfaces.EdgeDecorator;
import interfaces.IEdge;
import interfaces.IVertex;


public class UndirectedEdge implements IEdge {
	private IVertex origin;
	private IVertex target;
	private List<EdgeDecorator<?>> decorators = new ArrayList<>();
	
	public void setEdge(IVertex origin, IVertex target) {
		this.origin=origin;
		this.target=target;
	}
	
	@Override
	public IVertex getOriginVertex() {
		return origin;
	}

	@Override
	public IVertex getTargetVertex() {
		return target;
	}

	@Override
	public boolean allowsTwoWayTraversal() {
		return true;
	}

	@Override
	public int getValue() {
		int value=1;
		for(EdgeDecorator<?> d: decorators) {
			try {
				value*=(int)d.getValue();
			} catch (NumberFormatException e) {
				//pass
			}
			
		}
		return value;
	
	}

	@Override
	public void addDecorator(EdgeDecorator<?> decorator) {
		this.decorators.add(decorator);

	}

}
