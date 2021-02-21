public class Vector {
    public float x, y, mag;
    public Vector(float x_, float y_) {
        x = x_;
        y = y_;
        mag = 1;
    }
    public Vector set(float x_, float y_) {
        x = x_;
        y = y_;
        return this;
    }
    public Vector add(Vector v) {
        x += v.x;
        y += v.y;
        return this;
    }
    public Vector mult(Vector v) {
        x *= v.x;
        y *= v.y;
        return this;
    }
    public Vector mult(float o) {
        x *= o;
        y *= o;
        return this;
    }
    public void setMag(float mag_) {
        mag = mag_;
        mult(mag);
    }
    @Override
    public String toString() {
        return String.format("(%s, %s) %s", x, y, mag);
    }
    public static Vector random() {
        float random = (float) (Math.random()*360);
        float x = (float) Math.sin(Math.toRadians(random));
        float y = (float) Math.cos(random);
        return new Vector(x, y);
        // return new Vector((float) Math.random()*4, Math.random()*);
    }
    // private static float random(float min, float max) {

    // }
}
