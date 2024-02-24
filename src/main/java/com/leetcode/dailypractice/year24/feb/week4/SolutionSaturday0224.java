package com.leetcode.dailypractice.year24.feb.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/cheapest-flights-within-k-stops/">Problem-Link</a>
 * 
 * 787. Cheapest Flights Within K Stops
 * 
 * Medium Topics Companies
 * 
 * There are n cities connected by some number of flights. You are given an
 * array flights where flights[i] = [fromi, toi, pricei] indicates that there is
 * a flight from city fromi to city toi with cost pricei.
 * 
 * You are also given three integers src, dst, and k, return the cheapest price
 * from src to dst with at most k stops. If there is no such route, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="cheapest-flights-within-k-stops-1drawio.png" width="80%"/>
 * 
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]],
 * src = 0, dst = 3, k = 1 
 * 
 * Output: 700
 * 
 * Explanation: The graph is shown above. The optimal path with at most 1 stop
 * from city 0 to 3 is marked in red and has cost 100 + 600 = 700. Note that the
 * path through cities [0,1,2,3] is cheaper but is invalid because it uses 2
 * stops.
 * 
 * 
 * Example 2:
 * 
 * <img src="cheapest-flights-within-k-stops-2drawio.png" width="80%"/>
 * 
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k= 1 
 * 
 * Output: 200
 * 
 * Explanation: The graph is shown above. The optimal path with at most 1 stop
 * from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
 * 
 * 
 * Example 3:
 *
 * <img src="cheapest-flights-within-k-stops-3drawio.png" width="80%"/>
 * 
 * 
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k= 0 
 * 
 * Output: 500
 * 
 * Explanation: The graph is shown above. The optimal path with no stops from
 * city 0 to 2 is marked in red and has cost 500.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 100 0 <= flights.length <= (n * (n - 1) / 2) flights[i].length == 3
 * 0 <= fromi, toi < n fromi != toi 1 <= pricei <= 104 There will not be any
 * multiple flights between two cities. 0 <= src, dst, k < n src != dst
 * 
 * 
 * Seen this question in a real interview before? 1/4 Yes No Accepted 490.9K
 * Submissions 1.3M Acceptance Rate 38.4%
 */
public class SolutionFriday0223 {
	// Mine Solution
	public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
		return 0;
	}
	//Best Solution
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int stops = 0;

        while (!q.isEmpty() && stops <= k) {
            int sz = q.size();
            while (sz-- > 0) {
                int[] curr = q.poll();
                int node = curr[0];
                int distance = curr[1];

                if (!adj.containsKey(node)) continue;

                for (int[] next : adj.get(node)) {
                    int neighbour = next[0];
                    int price = next[1];
                    if (price + distance >= dist[neighbour]) continue;
                    dist[neighbour] = price + distance;
                    q.offer(new int[] {neighbour, dist[neighbour]});
                }
            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
	public static void main(String[] args) {
		Consumer cons = System.out::println;
		var obj = new SolutionFriday0223();
		cons.accept(obj.findCheapestPrice(4, new int[][] { {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200 } }, 0, 3, 1));
		cons.accept(obj.findCheapestPrice(3, new int[][] { {0,1,100},{1,2,100},{0,2,500 } }, 0, 2, 1));
		cons.accept(obj.findCheapestPrice(3, new int[][] { {0,1,100},{1,2,100},{0,2,500 } }, 0, 2, 0));
		
	}
}