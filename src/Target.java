public class Target extends Vector {
    public int length, height;
    public Vector CENTER;

    public Target(float _x, float _y, int _length, int _height) {
        super(_x, _y);
        length = _length;
        height = _height;
        CENTER = new Vector(x+length/2, y+height/2);
    }

    @Override
    public Vector set(float x_, float y_) {
        x = x_;
        y = y_;
        CENTER.set(x+length/2, y+height/2);
        return this;
    }
}
