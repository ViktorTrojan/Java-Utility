
public class Vec2 {

    public float x, y, len, angle;

    public Vec2() {
        x = y = len = angle = 0;
    }

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
        calc();
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
        calc();
    }

    public void set(float val) {
        x = y = val;
        calc();
    }

    public void set(Vec2 v) {
        x = v.x;
        y = v.y;
        calc();
    }

    public void add(float val) {
        x += val;
        y += val;
        calc();
    }

    public void sub(float val) {
        x -= val;
        y -= val;
        calc();
    }

    public void mul(float val) {
        x *= val;
        y *= val;
        calc();
    }

    public void div(float val) {
        x /= val;
        y /= val;
        calc();
    }

    public void add(Vec2 v) {
        x += v.x;
        y += v.y;
        calc();
    }

    public void sub(Vec2 v) {
        x -= v.x;
        y -= v.y;
        calc();
    }

    public void mul(Vec2 v) {
        x *= v.x;
        y *= v.y;
        calc();
    }

    public void div(Vec2 v) {
        x /= v.x;
        y /= v.y;
        calc();
    }

    public static Vec2 add(Vec2 v1, Vec2 v2) {
        return new Vec2(v1.x + v2.x, v1.y + v2.y);
    }

    public static Vec2 sub(Vec2 v1, Vec2 v2) {
        return new Vec2(v1.x - v2.x, v1.y - v2.y);
    }

    public static Vec2 mul(Vec2 v1, Vec2 v2) {
        return new Vec2(v1.x * v2.x, v1.y * v2.y);
    }

    public static Vec2 div(Vec2 v1, Vec2 v2) {
        return new Vec2(v1.x / v2.x, v1.y / v2.y);
    }

    public void normalize() {
        float len = MH.len(x, y);
        x /= len;
        y /= len;
        calc();
    }
    
    public static Vec2 normalize(float x, float y) {
        float len = MH.len(x, y);
        return new Vec2(x / len, y / len);
    }
    
    public static void normalize(Vec2 v) {
        float len = MH.len(v.x, v.y);
        v.x /= len;
        v.y /= len;
        v.calc();
    }

    public void inverseX() {
        x = -x;
        calc();
    }

    public void inverseY() {
        y = -y;
        calc();
    }

    public void inverse() {
        x = -x;
        y = -y;
        calc();
    }


    // do all calculations
    private void calc() {
        calcLen();
        calcAngle();
    }

    private void calcAngle() {
        angle = MH.atan2(y, x);
    }

    private void calcLen() {
        len = MH.len(x, y);
    }
}
