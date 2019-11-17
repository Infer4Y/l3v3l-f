package inferno.l3v3l_f.client.models;

import inferno.l3v3l_f.common.utils.math.Vector3f;

public class ModelCube extends Model {
    public ModelCube(float x, float y, float z){
        float l = (float)0;
        this.vertexes = new Vector3f[] {
                new Vector3f(x,l,l),
                new Vector3f(x, y, l),
                new Vector3f(x, y, z),
                new Vector3f(l,y,l),
                new Vector3f(x,l,l),


                new Vector3f(x,l,z),
                new Vector3f(x, l, l),
                new Vector3f(x, y, z),
                new Vector3f(l,l,z),
                new Vector3f(x,l,z),


                new Vector3f(x,l,l),
                new Vector3f(x, y, l),
                new Vector3f(x, y, z),
                new Vector3f(x,l,z),
                new Vector3f(x,l,l),


                new Vector3f(l,l,z),
                new Vector3f(l, y, z),
                new Vector3f(l, y, l),
                new Vector3f(l,l,l),
                new Vector3f(l,l,z),


                new Vector3f(x, l, l),
                new Vector3f(x, l, z),
                new Vector3f(l,l,z),
                new Vector3f(l,l,l),
                new Vector3f(x,l,l),


                new Vector3f(x, l, l),
                new Vector3f(x, l, z),
                new Vector3f(l, y, z),
                new Vector3f(l,l,l),
                new Vector3f(x,l,l)
        };
    }

    public ModelCube(float x, float y, float z, Vector3f off){
        float l = (float)0;
        this.vertexes = new Vector3f[] {
                new Vector3f(x  + off.getX(),l + off.getY(),l + off.getZ()),
                new Vector3f(x  + off.getX(), y  + off.getY(), l + off.getZ()),
                new Vector3f(x  + off.getX(), y + off.getY(), z + off.getZ()),
                new Vector3f(l + off.getX(),y + off.getY(), l + off.getZ()),
                new Vector3f(x  + off.getX(),l + off.getY(),l + off.getZ()),


                new Vector3f(x + off.getX(),l + off.getY(),z + off.getZ()),
                new Vector3f(x + off.getX(), l + off.getY(), 0f + off.getZ()),
                new Vector3f(x + off.getX(), y + off.getY(), z + off.getZ()),
                new Vector3f(l + off.getX(),l + off.getY(),z + off.getZ()),
                new Vector3f(x + off.getX(),l + off.getY(),z + off.getZ()),


                new Vector3f(x + off.getX(),l + off.getY(),l + off.getZ()),
                new Vector3f(x + off.getX(), y + off.getY(), l + off.getZ()),
                new Vector3f(x + off.getX(), y + off.getY(), z + off.getZ()),
                new Vector3f(x + off.getX(),l + off.getY(),z + off.getZ()),
                new Vector3f(x + off.getX(),l + off.getY(),l + off.getZ()),


                new Vector3f(l + off.getX(),l + off.getY(),z + off.getZ()),
                new Vector3f(l + off.getX(), y + off.getY(), z + off.getZ()),
                new Vector3f(l + off.getX(), y + off.getY(), l + off.getZ()),
                new Vector3f(l + off.getX(),l + off.getY(),l + off.getZ()),
                new Vector3f(l + off.getX(),l + off.getY(),z + off.getZ()),


                new Vector3f(x + off.getX(), l + off.getY(), l + off.getZ()),
                new Vector3f(x + off.getX(), l + off.getY(), z + off.getZ()),
                new Vector3f(l + off.getX(),l + off.getY(),z + off.getZ()),
                new Vector3f(l + off.getX(),l + off.getY(),l + off.getZ()),
                new Vector3f(x + off.getX(),l + off.getY(),l + off.getZ()),


                new Vector3f(x + off.getX(), l + off.getY(), l + off.getZ()),
                new Vector3f(x + off.getX(), l + off.getY(), z + off.getZ()),
                new Vector3f(l + off.getX(), y + off.getY(), z + off.getZ()),
                new Vector3f(l + off.getX(),l + off.getY(),l + off.getZ()),
                new Vector3f(x + off.getX(),l + off.getY(),l + off.getZ())
        };
    }
}
