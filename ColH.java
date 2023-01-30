
class RGB {

    public int r, g, b;

    public RGB() {
        r = g = b = 0;
    }

    public RGB(int red, int green, int blue) {
        setCol(red, green, blue);
    }

    public void setCol(int red, int green, int blue) {
        r = red;
        g = green;
        b = blue;
    }
}

class HSV {

    public float h, s, v;

    public HSV() {
        h = s = v = 0;
    }

    public HSV(float hue, float sat, float val) {
        setCol(hue, sat, val);
    }

    public void setCol(float hue, float sat, float val) {
        h = hue;
        s = sat;
        v = val;
    }
}

class HSL {

    public float h, s, l;

    public HSL() {
        h = s = l = 0;
    }

    public HSL(float hue, float sat, float light) {
        setCol(hue, sat, light);
    }

    public void setCol(float hue, float sat, float val) {
        h = hue;
        s = sat;
        l = val;
    }
}

public class ColH {

    // hsv from 0-1
    public static RGB HSVtoRGB(float hue, float saturation, float value) {
        int h = (int) (hue * 6);
        float f = hue * 6 - h;
        float p = value * (1 - saturation);
        float q = value * (1 - f * saturation);
        float t = value * (1 - (1 - f) * saturation);

        RGB outCol = new RGB();

        switch (h) {
            case 0:
                outCol.setCol((int) (value * 255), (int) (t * 255), (int) (p * 255));
                return outCol;
            case 1:
                outCol.setCol((int) (q * 255), (int) (value * 255), (int) (p * 255));
                return outCol;
            case 2:
                outCol.setCol((int) (p * 255), (int) (value * 255), (int) (t * 255));
                return outCol;
            case 3:
                outCol.setCol((int) (p * 255), (int) (q * 255), (int) (value * 255));
                return outCol;
            case 4:
                outCol.setCol((int) (t * 255), (int) (p * 255), (int) (value * 255));
                return outCol;
            case 5:
            case 6:
                outCol.setCol((int) (value * 255), (int) (p * 255), (int) (q * 255));
                return outCol;
            default:
                return outCol;
        }
    }

    // hsv from 0-1
    public static HSV RGBtoHSV(int red, int green, int blue) {
        float r = red / 255f;
        float g = green / 255f;
        float b = blue / 255f;
        float cmax = Math.max(Math.max(r, g), b);
        float cmin = Math.min(Math.min(r, g), b);
        float delta = cmax - cmin;
        HSV outCol = new HSV();

        if (delta == 0) {
            outCol.h = 0;

        } else if (cmax == r) {
            outCol.h = 60 * ((g - b) / delta);
        } else if (cmax == g) {
            outCol.h = 60 * ((b - r) / delta + 2);
        } else {
            outCol.h = 60 * ((r - g) / delta + 4);
        }

        if (outCol.h < 0) {
            outCol.h += 360;
        }

        // normalize hue from 0-360 to 0-1
        outCol.h = outCol.h / 360f;

        if (cmax == 0) {
            outCol.s = 0;
        } else {
            outCol.s = delta / cmax;
        }

        outCol.v = cmax;

        return outCol;
    }

    // hsv from 0-1
    public static RGB HSLtoRGB(float hue, float saturation, float light) {
        RGB rgb = new RGB();

        if (saturation == 0) {
            rgb.r = (int) (light * 255);
            rgb.g = (int) (light * 255);
            rgb.b = (int) (light * 255);
        } else {
            float q = light < 0.5f ? light * (1 + saturation) : light + saturation - light * saturation;
            float p = 2 * light - q;
            float hk = hue / 360;
            float[] T = new float[]{hk + 1f / 3, hk, hk - 1f / 3};
            for (int i = 0; i < 3; i++) {
                if (T[i] < 0) {
                    T[i] += 1;
                }
                if (T[i] > 1) {
                    T[i] -= 1;
                }
                if (T[i] < 1f / 6) {
                    T[i] = p + (q - p) * 6 * T[i];
                } else if (T[i] < 1f / 2) {
                    T[i] = q;
                } else if (T[i] < 2f / 3) {
                    T[i] = p + (q - p) * 6 * (2f / 3 - T[i]);
                } else {
                    T[i] = p;
                }
            }
            rgb.r = (int) (T[0] * 255);
            rgb.g = (int) (T[1] * 255);
            rgb.b = (int) (T[2] * 255);
        }

        return rgb;
    }

    // hsl from 0-1
    public static HSL RGBtoHSL(int red, int green, int blue) {
        float r = red / 255f;
        float g = green / 255f;
        float b = blue / 255f;
        float cmax = Math.max(Math.max(r, g), b);
        float cmin = Math.min(Math.min(r, g), b);
        float delta = cmax - cmin;
        HSL outCol = new HSL();

        outCol.l = (cmax + cmin) / 2;

        if (delta == 0) {
            outCol.h = 0;
            outCol.s = 0;

        } else {
            if (outCol.l < 0.5) {
                outCol.s = delta / (cmax + cmin);
            } else {
                outCol.s = delta / (2 - cmax - cmin);
            }
            if (cmax == r) {
                outCol.h = ((g - b) / delta);
                if (outCol.h < 0) {
                    outCol.h += 1;
                }
            } else if (cmax == g) {
                outCol.h = (((b - r) / delta) + 2) % 6;
            } else {
                outCol.h = (((r - g) / delta) + 4) % 6;
            }
            outCol.h /= 6;
        }

        return outCol;
    }
}
