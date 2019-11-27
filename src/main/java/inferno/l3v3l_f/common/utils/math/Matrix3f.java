package inferno.l3v3l_f.common.utils.math;

public class Matrix3f {
    private float[] values;

    public Matrix3f(float[] values) {
        this.values = values;
    }

    public Matrix3f multiply(Matrix3f other) {
        float[] result = new float[9];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                for (int i = 0; i < 3; i++) {
                    result[row * 3 + col] +=
                            this.values[row * 3 + i] * other.values[i * 3 + col];
                }
            }
        }
        return new Matrix3f(result);
    }

    public Vector3f transform(Vector3f in) {
        return new Vector3f(
                in.getX() * values[0] + in.getY() * values[3] + in.getZ() * values[6],
                in.getX() * values[1] + in.getY() * values[4] + in.getZ() * values[7],
                in.getX() * values[2] + in.getY() * values[5] + in.getZ() * values[8]
        );
    }
}
