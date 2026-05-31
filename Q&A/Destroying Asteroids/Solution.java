import java.util.*;

class Solution {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        Arrays.sort(asteroids);

        long currentMass = mass;

        for (int i = 0; i < asteroids.length; i++) {

            if (asteroids[i] > currentMass)
                return false;

            currentMass += asteroids[i];
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial mass: ");
        int mass = sc.nextInt();

        System.out.print("Enter number of asteroids: ");
        int n = sc.nextInt();

        int[] asteroids = new int[n];

        System.out.println("Enter asteroid masses:");

        for (int i = 0; i < n; i++) {
            asteroids[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        boolean result = obj.asteroidsDestroyed(mass, asteroids);

        System.out.println("Can destroy all asteroids: " + result);

        sc.close();
    }
}