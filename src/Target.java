public class Target {
    public float x, y;
    public int length, height;
    public Vector CENTER;

    public Target(float _x, float _y, int _length, int _height) {
        x = _x;
        y = _y;
        length = _length;
        height = _height;
        CENTER = new Vector(x+length/2, y+height/2);
    }
}
