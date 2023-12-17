package com.leetcode.dailypractice.year23.dec.week3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href=
 * "https://leetcode.com/problems/design-a-food-rating-system/">Problem-Link</a>
 * 
 * 2353. Design a Food Rating System Medium 831 161 Companies Design a food
 * rating system that can do the following:
 * 
 * Modify the rating of a food item listed in the system. Return the
 * highest-rated food item for a type of cuisine in the system. Implement the
 * FoodRatings class:
 * 
 * FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the
 * system. The food items are described by foods, cuisines and ratings, all of
 * which have a length of n. foods[i] is the name of the ith food, cuisines[i]
 * is the type of cuisine of the ith food, and ratings[i] is the initial rating
 * of the ith food. void changeRating(String food, int newRating) Changes the
 * rating of the food item with the name food. String highestRated(String
 * cuisine) Returns the name of the food item that has the highest rating for
 * the given type of cuisine. If there is a tie, return the item with the
 * lexicographically smaller name. Note that a string x is lexicographically
 * smaller than string y if x comes before y in dictionary order, that is,
 * either x is a prefix of y, or if i is the first position such that x[i] !=
 * y[i], then x[i] comes before y[i] in alphabetic order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input ["FoodRatings", "highestRated", "highestRated", "changeRating",
 * "highestRated", "changeRating", "highestRated"] [[["kimchi", "miso", "sushi",
 * "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek",
 * "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"],
 * ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]] Output [null,
 * "kimchi", "ramen", null, "sushi", null, "ramen"]
 * 
 * Explanation FoodRatings foodRatings = new FoodRatings(["kimchi", "miso",
 * "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese",
 * "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
 * foodRatings.highestRated("korean"); // return "kimchi" // "kimchi" is the
 * highest rated korean food with a rating of 9.
 * foodRatings.highestRated("japanese"); // return "ramen" // "ramen" is the
 * highest rated japanese food with a rating of 14.
 * foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
 * foodRatings.highestRated("japanese"); // return "sushi" // "sushi" is the
 * highest rated japanese food with a rating of 16.
 * foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
 * foodRatings.highestRated("japanese"); // return "ramen" // Both "sushi" and
 * "ramen" have a rating of 16. // However, "ramen" is lexicographically smaller
 * than "sushi".
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 2 * 104 n == foods.length == cuisines.length == ratings.length 1 <=
 * foods[i].length, cuisines[i].length <= 10 foods[i], cuisines[i] consist of
 * lowercase English letters. 1 <= ratings[i] <= 108 All the strings in foods
 * are distinct. food will be the name of a food item in the system across all
 * calls to changeRating. cuisine will be a type of cuisine of at least one food
 * item in the system across all calls to highestRated. At most 2 * 104 calls in
 * total will be made to changeRating and highestRated. Accepted 34.3K
 * Submissions 84.5K Acceptance Rate 40.6%
 */
public class SolutionSunday1217 {
	// Mine Solution Getting Timeout
	static class FoodRatings1 {
		String[] foods;
		Map<String, Integer> foodMap = new HashMap<>();
		Map<String, List<Integer>> cuisinesFoodMap = new HashMap<>();
		int[] ratings;

		public FoodRatings1(String[] foods, String[] cuisines, int[] ratings) {
			this.foods = foods;
			for (int i = 0; i < foods.length; i++) {
				foodMap.put(foods[i], i);
			}
			for (int i = 0; i < cuisines.length; i++) {
				cuisinesFoodMap.computeIfAbsent(cuisines[i], k -> new LinkedList<>()).add(i);
			}
			this.ratings = ratings;
		}

		int findFood(String foodItem) {

			for (int i = 0; i < foods.length; i++) {
				if (foods[i].equals(foodItem)) {
					return i;
				}
			}
			return -1;
		}
		/*
		 * I used this approach first to find out hightest rating by iterating over the
		 * returned list of this method List<Integer> findCuisine(String cuisine) {
		 * List<Integer> list = new LinkedList<>(); for (int i = 0; i < cuisines.length;
		 * i++) { if (cuisines[i].equals(cuisine)) { list.add(i); } } return list; }
		 */

		public void changeRating(String food, int newRating) {
			int index = foodMap.get(food);
			if (index != -1)
				ratings[index] = newRating;
		}

		public String highestRated(String cuisine) {
			int highestRating = 0, highestRatingIndex = 0;
			List<Integer> foodList = cuisinesFoodMap.get(cuisine);
			for (int i = 0; i < foodList.size(); i++) {
				if (ratings[foodList.get(i)] >= highestRating) {
					if (ratings[foodList.get(i)] != highestRating || ratings[foodList.get(i)] == highestRating
							&& (foods[highestRatingIndex].compareTo(foods[foodList.get(i)]) > 0)) {
						highestRating = ratings[foodList.get(i)];
						highestRatingIndex = foodList.get(i);
					}
				}
			}
			return foods[highestRatingIndex];

		}
	}
	//Best Solution
	static class FoodRatings {
		public class Info {
			String food;
			String cuisine;
			int rating;

			public Info(String food, String cuisine, int rating) {
				this.food = food;
				this.cuisine = cuisine;
				this.rating = rating;
			}
		}

		Map<String, PriorityQueue<Info>> cuisineMap;
		Map<String, Info> foodMap;

		public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
			cuisineMap = new HashMap<>();
			foodMap = new HashMap<>();
			for (int i = 0; i < foods.length; i++) {
				Info combo = new Info(foods[i], cuisines[i], ratings[i]);
				foodMap.put(foods[i], combo);
				if (cuisineMap.containsKey(cuisines[i])) {
					cuisineMap.get(cuisines[i]).add(combo);
				} else {
					PriorityQueue<Info> pq = new PriorityQueue<Info>(new Comparator<Info>() {
						@Override
						public int compare(Info a, Info b) {
							int result = b.rating - a.rating;
							if (result == 0) {
								return (a.food).compareTo(b.food);
							}
							return result;
						}
					});
					pq.add(combo);
					cuisineMap.put(cuisines[i], pq);
				}
			}
		}

		public void changeRating(String food, int newRating) {
			Info prev = foodMap.get(food);
			Info curr = new Info(food, prev.cuisine, newRating);
			foodMap.put(food, curr);
			prev.food = "";
			cuisineMap.get(prev.cuisine).add(curr);

		}

		public String highestRated(String cuisine) {
			while (cuisineMap.get(cuisine).peek().food.equals("")) {
				cuisineMap.get(cuisine).remove();
			}
			return cuisineMap.get(cuisine).peek().food;

		}

	}

	/**
	 * Your FoodRatings object will be instantiated and called as such: FoodRatings
	 * obj = new FoodRatings(foods, cuisines, ratings);
	 * obj.changeRating(food,newRating); String param_2 = obj.highestRated(cuisine);
	 */
	public static void main(String[] args) {
		Consumer<String> cons = System.out::println;
		var obj = new FoodRatings1(new String[] { "kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi" },
				new String[] { "korean", "japanese", "japanese", "greek", "japanese", "korean" },
				new int[] { 9, 12, 8, 15, 14, 7 });
		cons.accept(obj.highestRated("korean"));
		cons.accept(obj.highestRated("japanese"));

	}

}
