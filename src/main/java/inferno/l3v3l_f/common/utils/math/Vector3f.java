package inferno.l3v3l_f.common.utils.math;

public class Vector3f {
    private float x, y, z;

    public Vector3f(float x, float y, float z) {
        this.x= x;
        this.y= y;
        this.z= z;
    }


    public Vector3f add(Vector3f vector3f){
        this.x+= vector3f.getX();
        this.y+= vector3f.getY();
        this.z+= vector3f.getZ();
        return this;
    }
    public Vector3f add(float x, float y, float z){
        this.x+= x;
        this.y+= y;
        this.z+= z;
        return this;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }
}
