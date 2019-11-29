package inferno.l3v3l_f.common.utils.math;

public class Vector2f {
    private float x, y;

    public Vector2f(float x, float y) {
        this.x= x;
        this.y= y;
    }

    public Vector2f add(Vector2f vector2f){
        this.x+= vector2f.getX();
        this.y+= vector2f.getY();
        return this;
    }
    public Vector2f add(float x, float y){
        this.x+= x;
        this.y+= y;
        return this;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
