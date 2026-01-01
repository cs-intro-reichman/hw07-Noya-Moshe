/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.setPenColor(StdDraw.BLACK);

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		/*curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		 snowFlake(Integer.parseInt(args[0]));
		StdDraw.show();
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		
		//// Write the rest of your code below.
	    if (n == 0) {
        StdDraw.line(x1, y1, x2, y2);
        return;
        }
		
		double dx = x2 - x1;
        double dy = y2 - y1;

        double bx = x1 + dx / 3;
        double by = y1 + dy / 3;

        double dxc = x1 + 2 * dx / 3;
        double dyc = y1 + 2 * dy / 3;

		double cx = (Math.sqrt(3) / 6.0) * (y1 - y2) + 0.5 * (x1 + x2);
        double cy = (Math.sqrt(3) / 6.0) * (x2 - x1) + 0.5 * (y1 + y2);

		curve(n - 1, x1, y1, bx, by);
        curve(n - 1, bx, by, cx, cy);
        curve(n - 1, cx, cy, dxc, dyc);
        curve(n - 1, dxc, dyc, x2, y2);
	}
	  


		

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		//// Write the rest of your code below.
		double x1 = 0.1, y1 = 0.3;
		double x2 = 0.9, y2 = 0.3;
        double x3 = 0.5, y3 = 0.3 + Math.sqrt(3) * 0.4;
	    

		curve(n, x2, y2, x1, y1);
	    curve(n, x3, y3, x2, y2);
	    curve(n, x1, y1, x3, y3);
	}
}
