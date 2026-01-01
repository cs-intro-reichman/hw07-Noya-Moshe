/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		//// Replace this comment with your code
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.setPenColor(StdDraw.BLACK);

		double h = Math.sqrt(3) / 2;

		double x1 = 0.0, y1 = 0.0;
        double x2 = 1.0, y2 = 0.0;
        double x3 = 0.5, y3 = h;

		double[] x = { x1, x2, x3 };
        double[] y = { y1, y2, y3 };

		StdDraw.polygon(x, y);

		sierpinski(n,x1,x2,x3,y1,y2,y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		//// Replace this comment with your code
		if(n == 0) return;

		double xa = (x1 + x2) / 2;
        double ya = y1 ;

        double xb = xa + ((x2 - xa) / 2);
        double yb = y1 + ((y3 - y1) / 2);

        double xc = xa - ((xa - x1) / 2);
        double yc = y1 + ((y3 - y1) / 2);

        double[] x = { xa, xb, xc };
        double[] y = { ya, yb, yc };
	
        StdDraw.polygon(x, y);

		sierpinski(n - 1, x1, xa, xc, y1, ya, yc);
        sierpinski(n - 1, xa, x2, xb, ya, y2, yb);
        sierpinski(n - 1, xc, xb, x3, yc, yb, y3);
	}
}
