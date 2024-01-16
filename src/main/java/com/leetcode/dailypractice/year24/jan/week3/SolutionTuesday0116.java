package com.leetcode.dailypractice.year24.jan.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/insert-delete-getrandom-o1/">Problem-Link</a>
 * 
 * 
 * 380. Insert Delete GetRandom O(1)
 * 
 * Medium Topics Companies
 * 
 * Implement the RandomizedSet class:
 * 
 * RandomizedSet() Initializes the RandomizedSet object. bool insert(int val)
 * Inserts an item val into the set if not present. Returns true if the item was
 * not present, false otherwise. bool remove(int val) Removes an item val from
 * the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements
 * (it's guaranteed that at least one element exists when this method is
 * called). Each element must have the same probability of being returned. You
 * must implement the functions of the class such that each function works in
 * average O(1) time complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove",
 * "insert", "getRandom"] [[], [1], [2], [2], [], [1], [2], []]
 * 
 * Output [null, true, false, true, 2, true, false, 2]
 * 
 * Explanation RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was
 * inserted successfully. randomizedSet.remove(2); // Returns false as 2 does
 * not exist in the set. randomizedSet.insert(2); // Inserts 2 to the set,
 * returns true. Set now contains [1,2]. randomizedSet.getRandom(); //
 * getRandom() should return either 1 or 2 randomly. randomizedSet.remove(1); //
 * Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set,
 * getRandom() will always return 2.
 * 
 * 
 * Constraints:
 * 
 * -231 <= val <= 231 - 1 At most 2 * 105 calls will be made to insert, remove,
 * and getRandom. There will be at least one element in the data structure when
 * getRandom is called. Seen this question in a real interview before? 1/4 Yes
 * No Accepted 798.9K Submissions 1.5M Acceptance Rate 53.8%
 */
public class SolutionTuesday0116 {
	// Mine Solution
	static class RandomizedSet1 {
		Set<Integer> values;
		List<Integer> valuesList;

		public RandomizedSet() {
			values = new HashSet<>();
			valuesList = new ArrayList<>();
		}

		public boolean insert(int val) {
			if (values.add(val)) {
				valuesList.add(val);
				return true;
			}
			return false;
		}

		public boolean remove(int val) {
			if (values.remove(val)) {
				valuesList.remove(new Integer(val));
				return true;
			}
			return false;
		}

		public int getRandom() {
			return valuesList.get(new Random().nextInt(valuesList.size()));

		}
	}
	//Best Solution
	static class RandomizedSet {
		private ArrayList<Integer> list;
		private Map<Integer, Integer> map;

		public RandomizedSet() {
			list = new ArrayList<>();
			map = new HashMap<>();
		}

		public boolean search(int val) {
			return map.containsKey(val);
		}

		public boolean insert(int val) {
			if (search(val))
				return false;

			list.add(val);
			map.put(val, list.size() - 1);
			return true;
		}

		public boolean remove(int val) {
			if (!search(val))
				return false;

			int index = map.get(val);
			list.set(index, list.get(list.size() - 1));
			map.put(list.get(index), index);
			list.remove(list.size() - 1);
			map.remove(val);

			return true;
		}

		public int getRandom() {
			Random rand = new Random();
			return list.get(rand.nextInt(list.size()));
		}
	}

	public static void main(String[] args) {
		Consumer<Boolean> cons = System.out::println;

		// Your RandomizedSet object will be instantiated and called as such:
		RandomizedSet obj = new RandomizedSet();
		cons.accept(obj.insert(1));
		cons.accept(obj.remove(2));
		cons.accept(obj.insert(2));

		System.out.println(obj.getRandom());
		cons.accept(obj.remove(1));
		cons.accept(obj.insert(2));
		System.out.println(obj.getRandom());

	}
}
