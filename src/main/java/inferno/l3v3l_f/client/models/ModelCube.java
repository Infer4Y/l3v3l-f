package inferno.l3v3l_f.client.models;

import inferno.l3v3l_f.client.models.shapes.Shape;
import inferno.l3v3l_f.client.models.shapes.Triangle;
import inferno.l3v3l_f.common.utils.math.Vector3f;


public class ModelCube extends Model {
    public ModelCube(float x, float y, float z, float scale){
        Vector3f[] corners = new Vector3f[8];
        corners[0] = new Vector3f(x, y, z); // 0,0,0
        corners[1] = new Vector3f(x+scale, y, z); // 1,0,0
        corners[2] = new Vector3f(x+scale, y, z+scale); // 1,0,1
        corners[3] = new Vector3f(x, y, z+scale); // 0,0,1
        corners[4] = new Vector3f(x, y+scale, z+scale); // 0,1,1
        corners[5] = new Vector3f(x+scale, y+scale, z+scale); // 1,1,1
        corners[6] = new Vector3f(x+scale, y+scale, z); // 1,1,0
        corners[7] = new Vector3f(x, y+scale, z); // 0,1,0
        makeTrigs(corners);
    }

    private void makeTrigs(Vector3f[] corners){
        Triangle[] trigs = new Triangle[12];
        trigs[0] = new Triangle(corners[0], corners[1], corners[2]); // 0,0,0 | 1,0,0 | 1,0,1
        trigs[1] = new Triangle(corners[0], corners[3], corners[2]); // 0,0,0 | 0,0,1 | 1,0,1

        trigs[2] = new Triangle(corners[0], corners[1], corners[6]); // 0,0,0 | 1,0,0 | 1,1,0
        trigs[3] = new Triangle(corners[0], corners[7], corners[6]); // 0,0,0 | 0,1,0 | 1,1,0

        trigs[4] = new Triangle(corners[0], corners[3], corners[4]); // 0,0,0 | 0,0,1 | 0,1,1
        trigs[5] = new Triangle(corners[0], corners[7], corners[4]); // 0,0,0 | 0,1,0 | 0,1,1

        trigs[6] = new Triangle(corners[2], corners[1], corners[6]); // 1,0,1 | 1,0,0 | 1,1,0
        trigs[7] = new Triangle(corners[2], corners[5], corners[6]); // 1,0,1 | 1,1,1 | 1,1,0

        trigs[8] = new Triangle(corners[2], corners[3], corners[4]); // 1,0,1 | 0,0,1 | 0,1,1
        trigs[9] = new Triangle(corners[2], corners[5], corners[4]); // 1,0,1 | 1,1,1 | 0,1,1

        trigs[10] = new Triangle(corners[7], corners[4], corners[2]); // 0,1,0 | 0,1,1 | 1,1,1
        trigs[11] = new Triangle(corners[7], corners[5], corners[2]); // 0,1,0 | 1,1,0 | 1,1,1

        super.shapes = trigs;
    }
}
