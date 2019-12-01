package inferno.l3v3l_f.client.models.shapes;

import inferno.l3v3l_f.common.utils.math.Vector3f;
import org.jetbrains.annotations.NotNull;

public class Shape {
    protected Vector3f[] vertexes;

    public Shape(@NotNull Vector3f[] vertexes) {
        this.vertexes = vertexes;
    }

    public boolean intersects(){
        return false;
    }

    public Vector3f[] getVertexes() {
        return vertexes;
    }
}
