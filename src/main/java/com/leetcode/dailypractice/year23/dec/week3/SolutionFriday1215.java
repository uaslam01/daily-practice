package com.leetcode.dailypractice.year23.dec.week3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * <pre>
1436. Destination City
Easy
1.9K
91
Companies
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

 

Example 1:

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo" 
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
Example 2:

Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are: 
"D" -> "B" -> "C" -> "A". 
"B" -> "C" -> "A". 
"C" -> "A". 
"A". 
Clearly the destination city is "A".
Example 3:

Input: paths = [["A","Z"]]
Output: "Z"
 

Constraints:

1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.
*/
public class SolutionFriday1215 {
	//Mine
    public String destCity1(List<List<String>> paths) {
    	String nextCity = paths.get(0).get(1);
    	int nextInd = -1;
    	while((nextInd = checkCityInPaths(paths, nextCity))!=-1) {
    		nextCity = paths.get(nextInd).get(1);
    	}
        return nextCity;
    }
    private int checkCityInPaths(List<List<String>> paths, String nextCity) {
    	for(int i=0;i<paths.size();i++) {
    		if(paths.get(i).get(0).equals(nextCity)) {
    			return i;
    		}
    	}
		return -1;
	}
    //Best Solution
    public String destCity(List<List<String>> paths) {
        Set<String> cities = new HashSet<>(); 
        for (List<String> path : paths) {
            cities.add(path.get(0)); 
        }
        
        for (List<String> path : paths) {
            String dest = path.get(1); 
            if (!cities.contains(dest)) {
                return dest; 
            }
        }
        return "";
    }

	public static void main(String[] args) {
		Consumer<String> cons = System.out::println;
		var obj = new SolutionFriday1215();
		cons.accept(obj.destCity(Arrays.asList(
                Arrays.asList("London","New York"),
                Arrays.asList("New York","Lima"),
                Arrays.asList("Lima","Sao Paulo")
        )));
		cons.accept(obj.destCity(Arrays.asList(
                Arrays.asList("B","C"),
                Arrays.asList("D","B"),
                Arrays.asList("C","A")
        )));
		cons.accept(obj.destCity(Arrays.asList(
                Arrays.asList("A","Z")
        )));
	}
}
