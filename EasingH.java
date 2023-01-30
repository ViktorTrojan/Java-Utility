
public class EasingH {
    // Also known as Interpolation Curves
    // example easings: https://easings.net
    
    public static float smoothstep(float edge0, float edge1, float x) {
    float t = Math.max(0, Math.min(1, (x - edge0) / (edge1 - edge0)));
    return t * t * (3 - 2 * t);
}
}
