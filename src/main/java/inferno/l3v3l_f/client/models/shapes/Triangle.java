package inferno.l3v3l_f.client.models.shapes;

import inferno.l3v3l_f.common.utils.math.Vector3f;

public class Triangle extends Shape {
    public Triangle(Vector3f corner0,
                    Vector3f corner1,
                    Vector3f corner2) {
        super (new Vector3f[]{corner0, corner1, corner2});
    }
}
