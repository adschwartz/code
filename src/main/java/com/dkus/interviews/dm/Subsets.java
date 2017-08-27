package com.dkus.interviews.dm;

/**
 * @author anders.schwartz
 */
public class Subsets {

    /*
        Input: a set of integers S.
        Output: the number of subsets of S that sum up to an even number.
        Example: {1, 2, 5}. Subsets summing to even # are {}, {2}, {1, 5}, {1, 2, 5}. Answer is 4.
     */










    public static int subsets(int[] numbers) {
        int sum = 0;
        int i = 0;
        int j = 1;

        while (i < numbers.length && j < numbers.length) {
            if ((numbers[i] % 2 != 0) && (numbers[j] % 2 != 0)) {
                sum = numbers[i] + numbers[j];
                break;
            }
            i++;
            j++;
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] numbers = {1, 2, 5};
        System.out.println(Subsets.subsets(numbers));
    }
}


/*

    // Returns true if there is a subset of set[] with sun equal to given sum
    static boolean isSubsetSum(int set[], int n, int sum)
    {
        // The value of subset[i][j] will be true if there
        // is a subset of set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum+1][n+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in botton up manner
        for (int i = 1; i <= sum; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                subset[i][j] = subset[i][j-1];
                if (i >= set[j-1])
                    subset[i][j] = subset[i][j] ||
                            subset[i - set[j-1]][j-1];
            }
        }

        // uncomment this code to print table
         for (int i = 0; i <= sum; i++)
         {
           for (int j = 0; j <= n; j++)
               System.out.println(subset[i][j]);
         }

        return subset[sum][n];
    }

public static void main (String args[])
{
    int set[] = {3, 34, 4, 12, 5, 2};
    int sum = 9;
    int n = set.length;
    if (isSubsetSum(set, n, sum) == true)
        System.out.println("Found a subset with given sum");
    else
        System.out.println("No subset with given sum");
}
 */