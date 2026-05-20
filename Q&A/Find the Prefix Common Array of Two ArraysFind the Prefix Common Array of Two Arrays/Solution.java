import java.util.*;

class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        int count = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] == B[i]) {

                mp.put(A[i],
                        mp.getOrDefault(A[i], 0) + 2);

                count++;
            }

            else {

                mp.put(A[i],
                        mp.getOrDefault(A[i], 0) + 1);

                mp.put(B[i],
                        mp.getOrDefault(B[i], 0) + 1);

                if (mp.get(A[i]) == 2) {
                    count++;
                }

                if (mp.get(B[i]) == 2) {
                    count++;
                }
            }

            A[i] = count;
        }

        return A;
    }

    // Helper method to print array
    public static void printArray(int[] arr) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of arrays: ");
        int n = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];

        System.out.println("Enter elements of array A:");

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println("Enter elements of array B:");

        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        int[] result = obj.findThePrefixCommonArray(A, B);

        System.out.println("Prefix Common Array:");

        printArray(result);

        sc.close();
    }
}