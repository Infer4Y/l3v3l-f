package inferno.l3v3l_f.client.models;

import inferno.l3v3l_f.client.models.shapes.Shape;

public class Model {
    protected Shape[] shapes;

    public Model(Shape[] shapes) {
        this.shapes = shapes;
    }

    public Model(){}

    public Shape[] getShapes() {
        return shapes;
    }
}
