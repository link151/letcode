package letcode;

import java.util.List;

public class Util {
	public void printIntArr(int[] nums){
		for(int i=0;i<nums.length;i++){
			System.out.printf(nums[i]+" ");
		}
		System.out.println();
	}
	public void printIntArr2(int[][] nums){
		for(int i=0;i<nums.length;i++){
			for(int j=0;j<nums[0].length;j++)
				System.out.printf("%-15d",nums[i][j]);
			System.out.println();
		}
	}
	
	public void printBooleanArr2(boolean[][] dp){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
	}
	
	public void printList(List<Integer> list){
		for (Integer integer : list) {
			System.out.printf("%-10d",integer);
		}
		System.out.println();
	}
	
	public void printInterval(Interval[] intervals){
		for(Interval interval:intervals)
			System.out.println(interval.start+"\t"+interval.end);
	}
}
