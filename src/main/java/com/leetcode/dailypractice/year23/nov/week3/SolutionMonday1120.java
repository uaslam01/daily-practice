package com.leetcode.dailypractice.year23.nov.week3;

import java.util.function.Consumer;

/**
 * Minimum Amount of Time to Collect Garbage Medium 1.3K 185 Companies You are
 * given a 0-indexed array of strings garbage where garbage[i] represents the
 * assortment of garbage at the ith house. garbage[i] consists only of the
 * characters 'M', 'P' and 'G' representing one unit of metal, paper and glass
 * garbage respectively. Picking up one unit of any type of garbage takes 1
 * minute.
 * 
 * You are also given a 0-indexed integer array travel where travel[i] is the
 * number of minutes needed to go from house i to house i + 1.
 * 
 * There are three garbage trucks in the city, each responsible for picking up
 * one type of garbage. Each garbage truck starts at house 0 and must visit each
 * house in order; however, they do not need to visit every house.
 * 
 * Only one garbage truck may be used at any given moment. While one truck is
 * driving or picking up garbage, the other two trucks cannot do anything.
 * 
 * Return the minimum number of minutes needed to pick up all the garbage.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: garbage = ["G","P","GP","GG"], travel = [2,4,3] Output: 21
 * Explanation: The paper garbage truck: 1. Travels from house 0 to house 1 2.
 * Collects the paper garbage at house 1 3. Travels from house 1 to house 2 4.
 * Collects the paper garbage at house 2 Altogether, it takes 8 minutes to pick
 * up all the paper garbage. The glass garbage truck: 1. Collects the glass
 * garbage at house 0 2. Travels from house 0 to house 1 3. Travels from house 1
 * to house 2 4. Collects the glass garbage at house 2 5. Travels from house 2
 * to house 3 6. Collects the glass garbage at house 3 Altogether, it takes 13
 * minutes to pick up all the glass garbage. Since there is no metal garbage, we
 * do not need to consider the metal garbage truck. Therefore, it takes a total
 * of 8 + 13 = 21 minutes to collect all the garbage. Example 2:
 * 
 * Input: garbage = ["MMM","PGM","GP"], travel = [3,10] Output: 37 Explanation:
 * The metal garbage truck takes 7 minutes to pick up all the metal garbage. The
 * paper garbage truck takes 15 minutes to pick up all the paper garbage. The
 * glass garbage truck takes 15 minutes to pick up all the glass garbage. It
 * takes a total of 7 + 15 + 15 = 37 minutes to collect all the garbage.
 * 
 * 
 * Constraints:
 * 
 * 2 <= garbage.length <= 105 garbage[i] consists of only the letters 'M', 'P',
 * and 'G'. 1 <= garbage[i].length <= 10 travel.length == garbage.length - 1 1
 * <= travel[i] <= 100 Accepted 96.5K Submissions 112.1K Acceptance Rate 86.1%
 */
public class SolutionMonday1120 {
	//Mine Solution
	public int garbageCollection1(String[] garbage, int[] travel) {
		int time = 0;
		for (char c : garbage[0].toCharArray()) {
			if (c == 'P') {
				time++;
			} else if (c == 'M')
				time++;
			else if (c == 'G')
				time++;
		}
		int ptime = 0;
		int gtime = 0;
		int mtime = 0;
		for (int i = 1; i < garbage.length; i++) {
			String str = garbage[i];
			ptime += travel[i - 1];
			mtime += travel[i - 1];
			gtime += travel[i - 1];
			boolean pFlag = false, mFlag = false, gFlag = false;
			for (char c : str.toCharArray()) {
				if (c == 'P') {
					ptime++;
					pFlag = true;
				} else if (c == 'M') {
					mtime++;
					mFlag = true;
				} else if (c == 'G') {
					gtime++;
					gFlag = true;
				}
			}
			if (pFlag) {
				time += ptime;
				ptime = 0;
			}
			if (gFlag) {
				time += gtime;
				gtime = 0;
			}
			if (mFlag) {
				time += mtime;
				mtime = 0;
			}

		}
		return time;
	}
	//Best Solution
    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;

        for (String g : garbage) {
            res += g.length();
        }

        boolean m = false, p = false, g = false;

        for (int i = travel.length; i > 0; i--) {
            m = m || garbage[i].contains("M");
            p = p || garbage[i].contains("P");
            g = g || garbage[i].contains("G");

            res += travel[i-1] * ((m ? 1 : 0) + (p ? 1 : 0) + (g ? 1 : 0));
        }

        return res;      
    }
	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionMonday1120();
		cons.accept(obj.garbageCollection(new String[] { "G", "P", "GP", "GG" }, new int[] { 2, 4, 3 }));
		cons.accept(obj.garbageCollection(new String[] { "MMM", "PGM", "GP" }, new int[] { 3, 10 }));

	}
}