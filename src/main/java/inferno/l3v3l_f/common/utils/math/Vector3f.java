package inferno.l3v3l_f.common.utils.math;

public class Vector3f {
    private float x, y, z;

    public Vector3f(float x, float y, float z) {
        this.x= x;
        this.y= y;
        this.z= z;
    }


    public Vector3f add(Vector3f vector3f){
        this.x+= vector3f.x;
        this.y+= vector3f.y;
        this.z+= vector3f.z;
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

    public Vector2f toVector2F(Vector3f vector3f){
        float eX = this.x - vector3f.x;
        float eY = this.y - vector3f.y;
        float eZ = this.z - vector3f.z;

        float cosX = (float) Math.cos(eX);
        float cosY = (float) Math.cos(eY);
        float cosZ = (float) Math.cos(eZ);

        float sinX = (float) Math.sin(eX);
        float sinY = (float) Math.sin(eY);
        float sinZ = (float) Math.sin(eZ);

        float dX = ((cosY*sinZ*eY) + (cosY*cosZ*eX)) - (sinY * eZ);
        float dY = ((sinX*cosY*eZ) + (sinX*sinY*sinZ*eY) + (sinX*sinY*cosZ*eX)) + ((cosX*cosZ*eY) - (cosX*sinZ*eX));
        float dZ = ((cosX*cosY*eZ) + (cosX*sinY*sinZ*eY) + (cosX*sinY*cosZ*eX)) - ((sinX*cosZ*eY) - (sinX*sinZ*eX));

        float bX = (((eZ / dZ) * dX) - eX);
        float bY = (((eZ / dZ) * dY) - eY);

        System.out.println(bX + " " + bY);

        return new Vector2f(bX, bY);
    }
}
