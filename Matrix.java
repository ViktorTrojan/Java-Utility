
public class Matrix {

    static void print(double m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (j == 0) {
                    System.out.print("(" + m[i][j] + " ");
                } else if (j == m[i].length - 1) {
                    System.out.print(m[i][j] + ")\n");
                } else {
                    System.out.print(m[i][j] + " ");
                }
            }
        }
    }

    public static double[][] mult(double m1[][], double m2[][]) {
        double d[][];

        if (m1.length > m2.length) {
            d = m2;
            m2 = m1;
            m1 = d;
        }

        double m[][] = new double[m1.length][m1[0].length];
        if (m1[0].length != m2[0].length) {
            System.out.println("[ERROR] Matrix multiplication didn't work!");
            return m;
        }

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                for (int k = 0; k < m1[1].length; k++) {
                    m[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        return m;
    }
}
