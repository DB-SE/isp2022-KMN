package iopl.sheet1;

class Vertex {
    private final int id;

    Vertex(final int id) {
        this.id = id;
    }

    int getId() {
        return this.id;
    }

    @Override
    public String toString() {

        return String.format("Vertex %d", this.id);
    }
}


class LabeledVertex<T> extends Vertex {

    T label;

    LabeledVertex(int id) {
        super(id);
    }

    public void setLabel(T label) {

        this.label = label;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)",
                super.toString(),
                (this.label != null)? this.label.toString() : "");
    }
}


class Edge {

    protected final Vertex[] vertices;

    Edge(Vertex v1, Vertex v2) {

        this.vertices = new Vertex[]{v1, v2};
    }
    public Vertex[] getVertices() {

        return this.vertices;
    }

    @Override
    public String toString() {

        return String.format("%s ----- %s",
                this.vertices[0],
                this.vertices[1]);
    }
}


class WeightedEdge extends Edge {

    private double weight;

    WeightedEdge(Vertex v1, Vertex v2, double weight) {

        super(v1,v2);
        this.weight = weight;
    }

    public double getWeight() {

        return weight;
    }

    public void setWeight(double weight) {

        this.weight = weight;
    }

    @Override
    public String toString() {

        return String.format("%s --%.2f-- %s",
                this.vertices[0],
                this.weight,
                this.vertices[1]);
    }
}