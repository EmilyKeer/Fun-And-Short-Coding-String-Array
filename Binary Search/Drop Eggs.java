/*
There is a building of n floors. If an egg drops from the k th floor or above, it will break. If it's dropped from any floor below, it will not break.

You're given two eggs, Find k while minimize the number of drops for the worst case. Return the number of drops in the worst case.

Clarification
For n = 10, a naive way to find k is drop egg from 1st floor, 2nd floor ... kth floor. But in this worst case (k = 10), you have to drop 10 times.

Notice that you have two eggs, so you can drop at 4th, 7th & 9th floor, in the worst case (for example, k = 9) you have to drop 4 times.

Example
Given n = 10, return 4.
Given n = 100, return 14.
*/

public class Solution {
    /*
     * @param : An integer
     * @return: The sum of a and b
     X + (X-1) + (X-2) + ... + 1 >= 100 -> X = 14
     */
    public int dropEggs(int n) {
        // write your code here
        int adder = 0;
        long sum = 0;
        while (sum < (long)n) {
            adder++;
            sum += adder;
        }
        return adder;
    }
};