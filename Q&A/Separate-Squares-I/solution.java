public class solution {

    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = 2e9; // large value
        double high = 0;

        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];

            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double halfArea = totalArea / 2.0;

        for (int i = 0; i < 100; i++) {
            double mid = low + (high - low) / 2.0;

            if (calculateArea(squares, mid) >= halfArea) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

    private double calculateArea(int[][] squares, double currentY) {
        double area = 0;

        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            double top = y + l;

            if (y >= currentY) {
                continue;
            } else if (top <= currentY) {
                area += l * l;
            } else {
                area += l * (currentY - y);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        solution sol = new solution();

        // Example input: [x, y, side length]
        int[][] squares = {
                { 0, 0, 2 },
                { 1, 1, 2 }
        };

        double result = sol.separateSquares(squares);
        System.out.println("Y-coordinate separating equal area: " + result);
    }
}
