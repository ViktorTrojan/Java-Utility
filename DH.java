
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

// DRAWHELPER CLASS
public class DH {

    public static void drawOval(Graphics2D g2, float x1, float y1, float w, float h, boolean centered) {
        if (centered) {
            float xoff = w * 0.5f;
            float yoff = h * 0.5f;
            x1 -= xoff;
            y1 -= yoff;
            g2.drawOval((int) x1, (int) y1, (int) w, (int) h);
        } else {
            g2.drawOval((int) x1, (int) y1, (int) w, (int) h);
        }
    }

    public static void drawOval_(Graphics2D g2, float x1, float y1, float x2, float y2, boolean centered) {
        if (x2 < x1) {
            float temp = x2;
            x2 = x1;
            x1 = temp;
        }

        if (y2 < y1) {
            float temp = y2;
            y2 = y1;
            y1 = temp;
        }

        if (centered) {
            float xoff = (x2 - x1) / 2;
            float yoff = (y2 - y1) / 2;
            x1 -= xoff;
            y1 -= yoff;
            g2.drawOval((int) x1, (int) y1, (int) (x2 - x1 - xoff), (int) (y2 - y1 - yoff));
        } else {
            g2.drawOval((int) x1, (int) y1, (int) (x2 - x1), (int) (y2 - y1));
        }
    }

    public static void fillOval(Graphics2D g2, float x1, float y1, float w, float h, boolean centered) {
        if (centered) {
            float xoff = w * 0.5f;
            float yoff = h * 0.5f;
            x1 -= xoff;
            y1 -= yoff;
            g2.fillOval((int) x1, (int) y1, (int) w, (int) h);
        } else {
            g2.fillOval((int) x1, (int) y1, (int) w, (int) h);
        }
    }

    public static void fillOval_(Graphics2D g2, float x1, float y1, float x2, float y2, boolean centered) {
        {
            if (x2 < x1) {
                float temp = x2;
                x2 = x1;
                x1 = temp;
            }

            if (y2 < y1) {
                float temp = y2;
                y2 = y1;
                y1 = temp;
            }
        }

        if (centered) {
            float xoff = (x2 - x1) / 2;
            float yoff = (y2 - y1) / 2;
            x1 -= xoff;
            y1 -= yoff;
            g2.fillOval((int) x1, (int) y1, (int) (x2 - x1 - xoff), (int) (y2 - y1 - yoff));
        } else {
            g2.fillOval((int) x1, (int) y1, (int) (x2 - x1), (int) (y2 - y1));
        }
    }

    public static void drawRect(Graphics2D g2, int x1, int y1, int x2, int y2, boolean centered) {
        {
            if (x2 < x1) {
                int f = x2;
                x2 = x1;
                x1 = f;
            }

            if (y2 < y1) {
                int f = y2;
                y2 = y1;
                y1 = f;
            }
        }

        if (centered) {
            int xoff = (x2 - x1) / 2;
            int yoff = (y2 - y1) / 2;
            x1 -= xoff;
            y1 -= yoff;
            g2.drawRect(x1, y1, x2 - x1 - xoff, y2 - y1 - yoff);
        } else {
            g2.drawRect(x1, y1, x2 - x1, y2 - y1);
        }
    }

    public static void fillRect(Graphics2D g2, int x1, int y1, int x2, int y2, boolean centered) {
        {
            if (x2 < x1) {
                int f = x2;
                x2 = x1;
                x1 = f;
            }

            if (y2 < y1) {
                int f = y2;
                y2 = y1;
                y1 = f;
            }
        }

        if (centered) {
            int xoff = (x2 - x1) / 2;
            int yoff = (y2 - y1) / 2;
            x1 -= xoff;
            y1 -= yoff;
            g2.fillRect(x1, y1, x2 - x1 - xoff, y2 - y1 - yoff);
        } else {
            g2.fillRect(x1, y1, x2 - x1, y2 - y1);
        }
    }

    public static void drawPolygon(Graphics2D g2, int[] xvals, int[] yvals, boolean centered) {
        if (xvals.length != yvals.length) {
            System.out.println("drawPolygon xvals length doesn't match yvals length! aborting");
            return;
        }
        g2.drawPolygon(xvals, yvals, xvals.length);
    }

    public static void fillPolygon(Graphics2D g2, int[] xvals, int[] yvals, boolean centered) {
        if (xvals.length != yvals.length) {
            System.out.println("drawPolygon xvals length doesn't match yvals length! aborting");
            return;
        }
        g2.fillPolygon(xvals, yvals, xvals.length);
    }

    public static void drawString(Graphics2D g2, String s, int x, int y, String fontName, int f, int size) {
        if (!fontName.isEmpty()) {
            g2.setFont(new Font(fontName, f, size));
        } else {
            g2.setFont(new Font("Calibri", f, size));
        }

        g2.drawString(s, x, y + size);
    }

    public static void drawLine(Graphics2D g2, float x1, float y1, float x2, float y2, float size, boolean centered) {
        Stroke s = g2.getStroke();
        g2.setStroke(new BasicStroke(size));
        if (centered) {
            float xoff = (x2 - x1) / 2;
            float yoff = (y2 - y1) / 2;
            x1 -= xoff;
            y1 -= yoff;
            g2.drawLine((int) x1, (int) y1, (int) (x2 - xoff), (int) (y2 - yoff));
        } else {
            g2.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
        g2.setStroke(s);
    }

    public static void drawLine(Graphics g, float x1, float y1, float x2, float y2, boolean centered) {
        if (centered) {
            float xoff = (x2 - x1) / 2;
            float yoff = (y2 - y1) / 2;
            x1 -= xoff;
            y1 -= yoff;
            g.drawLine((int) x1, (int) y1, (int) (x2 - xoff), (int) (y2 - yoff));
        } else {
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }
}
