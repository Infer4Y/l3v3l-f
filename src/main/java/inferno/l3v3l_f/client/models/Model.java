package inferno.l3v3l_f.client.models;

import inferno.l3v3l_f.common.utils.math.Vector3f;

public class Model {
    protected Vector3f[] vertexes;

    public Model(Vector3f[] vertexes) {
        this.vertexes = vertexes;
    }

    public Model(){}

    public Vector3f[] getVertexes() {
        return vertexes;
    }
}
