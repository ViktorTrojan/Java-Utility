public class Vec3 {

    public float x, y, z;

    public Vec3() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Vec3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public int getZ() {
        return (int) z;
    }

    public void add(float val) {
        x += val;
        y += val;
        z += val;
    }

    public void sub(float val) {
        x -= val;
        y -= val;
        z -= val;
    }

    public void mul(float val) {
        x *= val;
        y *= val;
        z *= val;
    }

    public void div(float val) {
        x /= val;
        y /= val;
        z /= val;
    }

    public static Vec3 add(Vec3 v1, Vec3 v2, Vec3 v3) {
        return new Vec3(v1.x + v2.x + v3.x, v1.y + v2.y + v3.y, v1.z + v2.z + v3.z);
    }

    public static Vec3 sub(Vec3 v1, Vec3 v2, Vec3 v3) {
        return new Vec3(v1.x - v2.x - v3.x, v1.y - v2.y - v3.y, v1.z - v2.z - v3.z);
    }

    public static Vec3 mul(Vec3 v1, Vec3 v2, Vec3 v3) {
        return new Vec3(v1.x * v2.x * v3.x, v1.y * v2.y * v3.y, v1.z * v2.z * v3.z);
    }

    public static Vec3 div(Vec3 v1, Vec3 v2, Vec3 v3) {
        return new Vec3(v1.x / v2.x / v3.x, v1.y / v2.y / v3.y, v1.z / v2.z / v3.z);
    }
    
    public void inverseX() {
        x = -x;
    }
    
    public void inverseY() {
        y = -y;
    }
    
    public void inverseZ() {
        z = -z;
    }
    
    public void inverse() {
        x = -x;
        y = -y;
        z = -z;
    }

    public void normalize() {
        float len = MH.len3(x, y, z);
        x /= len;
        y /= len;
        z /= len;
    }
}
