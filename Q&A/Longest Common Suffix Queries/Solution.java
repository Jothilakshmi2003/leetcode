import java.util.*;

class Solution {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];

        int bestLen = Integer.MAX_VALUE;

        int bestIdx = Integer.MAX_VALUE;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        TrieNode root = new TrieNode();

        // Build reverse trie
        for (int i = 0; i < wordsContainer.length; i++) {

            String word = wordsContainer[i];

            int len = word.length();

            TrieNode curr = root;

            // Update root best match
            if (len < curr.bestLen ||
                    (len == curr.bestLen && i < curr.bestIdx)) {

                curr.bestLen = len;
                curr.bestIdx = i;
            }

            // Insert reversed word
            for (int j = len - 1; j >= 0; j--) {

                int charIdx = word.charAt(j) - 'a';

                if (curr.children[charIdx] == null) {
                    curr.children[charIdx] = new TrieNode();
                }

                curr = curr.children[charIdx];

                // Update best match
                if (len < curr.bestLen ||
                        (len == curr.bestLen && i < curr.bestIdx)) {

                    curr.bestLen = len;
                    curr.bestIdx = i;
                }
            }
        }

        int[] ans = new int[wordsQuery.length];

        // Process queries
        for (int i = 0; i < wordsQuery.length; i++) {

            String query = wordsQuery[i];

            TrieNode curr = root;

            // Traverse reversed query
            for (int j = query.length() - 1; j >= 0; j--) {

                int charIdx = query.charAt(j) - 'a';

                if (curr.children[charIdx] == null) {
                    break;
                }

                curr = curr.children[charIdx];
            }

            ans[i] = curr.bestIdx;
        }

        return ans;
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

        // Input wordsContainer
        System.out.print("Enter size of wordsContainer: ");
        int n = sc.nextInt();

        String[] wordsContainer = new String[n];

        System.out.println("Enter container words:");

        for (int i = 0; i < n; i++) {
            wordsContainer[i] = sc.next();
        }

        // Input wordsQuery
        System.out.print("Enter size of wordsQuery: ");
        int m = sc.nextInt();

        String[] wordsQuery = new String[m];

        System.out.println("Enter query words:");

        for (int i = 0; i < m; i++) {
            wordsQuery[i] = sc.next();
        }

        Solution obj = new Solution();

        int[] result = obj.stringIndices(wordsContainer, wordsQuery);

        System.out.println("Matching indices:");

        printArray(result);

        sc.close();
    }
}