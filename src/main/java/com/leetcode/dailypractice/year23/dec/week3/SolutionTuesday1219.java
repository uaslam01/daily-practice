package com.leetcode.dailypractice.year23.dec.week3;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * <pre>
 * <a href= "https://leetcode.com/problems/image-smoother/">Problem-Link</a>
 * 661. Image Smoother
 * 
 * Easy 888 2.6K Companies
 * 
 * An image smoother is a filter of the size 3 x 3 that can be applied to each
 * cell of an image by rounding down the average of the cell and the eight
 * surrounding cells (i.e., the average of the nine cells in the blue smoother).
 * If one or more of the surrounding cells of a cell is not present, we do not
 * consider it in the average (i.e., the average of the four cells in the red
 * smoother).
 * 
 * <img src="smoother-grid.jpg" width="80%"/>
 * 
 * Given an m x n integer matrix img representing the grayscale of an image,
 * return the image after applying the smoother on each cell of it.
 * 
 * 
 * 
 * Example 1:
 * 
 * <img src="smooth-grid.jpg" width="80%"/>
 * 
 * Input: img = [[1,1,1],[1,0,1],[1,1,1]] Output: [[0,0,0],[0,0,0],[0,0,0]]
 * Explanation: For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) =
 * floor(0.75) = 0 For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) =
 * floor(0.83333333) = 0 For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Example 2:
 * 
 * <img src="smooth2-grid.jpg" width="80%"/>
 * 
 * Input: img = [[100,200,100],[200,50,200],[100,200,100]] Output:
 * [[137,141,137],[141,138,141],[137,141,137]] Explanation: For the points
 * (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6)
 * = floor(141.666667) = 141 For the point (1,1):
 * floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 * 
 * 
 * Constraints:
 * 
 * m == img.length n == img[i].length 1 <= m, n <= 200 0 <= img[i][j] <= 255
 * Accepted 126.7K Submissions 196.8K Acceptance Rate 64.4%
 */
public class SolutionTuesday1219 {
	// Mine
	public int[][] imageSmoother1(int[][] img) {
		int[][] res = new int[img.length][img[0].length];
		for (int i = 0; i < img.length; i++) {
			for (int j = 0; j < img[0].length; j++) {
				int sum = img[i][j];
				short count = 1;
				// Up
				if (i - 1 >= 0) {
					sum += img[i - 1][j];
					count++;
					// Up Left
					if (j - 1 >= 0) {
						sum += img[i - 1][j - 1];
						count++;
					}
					// Up Right
					if (j + 1 < img[0].length) {
						sum += img[i - 1][j + 1];
						count++;
					}
				}
				// Down
				if (i + 1 < img.length) {
					sum += img[i + 1][j];
					count++;
					// Down Left
					if (j - 1 >= 0) {
						sum += img[i + 1][j - 1];
						count++;
					}
					// Down Right
					if (j + 1 < img[0].length) {
						sum += img[i + 1][j + 1];
						count++;

					}
				}
				// Left
				if (j - 1 >= 0) {
					sum += img[i][j - 1];
					count++;
				}
				// Right
				if (j + 1 < img[0].length) {
					sum += img[i][j + 1];
					count++;
				}
				res[i][j] = sum / count;

			}
		}
		return res;
	}
	
	//Best Solution
    public int[][] imageSmoother2(int[][] img) {
        int res[][] = new int[img.length][img[0].length];
        for(int i = 0; i < img.length; i++) {
            for(int j = 0; j < img[0].length; j++) {
                res[i][j] = smoothen(img, i, j);
            }
        }
        return res;
    }
    
    int smoothen(int[][] img, int x, int y) {
        int m = img.length; 
        int n = img[0].length;
        int sum = 0;
        int count = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                sum += img[nx][ny];
                count++;
            }
        }
        return sum/count;
        
    }
    
	//Best Solution 2
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;

        // Apply the average function to each pixel in the image matrix
        int[][] result = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result[r][c] = calculateAverage(img, r, c, rows, cols);
            }
        }

        return result;        
    }

    private int calculateAverage(int[][] img, int r, int c, int rows, int cols) {
        int total = 0;
        int count = 0;

        // Define the boundaries for the neighboring pixels
        int top = Math.max(0, r - 1);
        int bottom = Math.min(rows, r + 2);
        int left = Math.max(0, c - 1);
        int right = Math.min(cols, c + 2);

        // Iterate over the neighboring pixels and calculate the sum and count
        for (int row = top; row < bottom; row++) {
            for (int col = left; col < right; col++) {
                total += img[row][col];
                count += 1;
            }
        }

        // Calculate and return the average value for the pixel
        return total / count;
    } 
    
	public static void main(String[] args) {
		Consumer cons = i -> Arrays.stream((int[][]) i)
				.forEach(j -> Arrays.stream((int[]) j).forEach(System.out::print));
		var obj = new SolutionTuesday1219();
		cons.accept(obj.imageSmoother(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }));
		System.out.println();
		cons.accept(obj.imageSmoother(new int[][] { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } }));
	}	
}
