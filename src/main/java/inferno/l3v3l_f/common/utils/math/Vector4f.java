package inferno.l3v3l_f.common.utils.math;

public class Vector4f {
    private float w, x, y, z;

    public Vector4f add(Vector4f vector4f){
        this.w+= vector4f.w;
        this.x+= vector4f.x;
        this.y+= vector4f.y;
        this.z+= vector4f.z;
        return this;
    }

    public Vector4f add(float w, float x, float y, float z){
        this.w+= w;
        this.x+= x;
        this.y+= y;
        this.z+= z;
        return this;
    }
}
