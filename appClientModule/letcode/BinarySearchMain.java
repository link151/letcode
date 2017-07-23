package letcode;

import java.util.Arrays;

public class BinarySearchMain {
	public static void main(String[] args) {
		BinarySearch bs=new BinarySearch();
		int[] nums={1,3,5,6,7};
		System.out.println("searchInsert:"+bs.searchInsert(nums, 5));
		System.out.println("searchInsert:"+bs.searchInsert_2(nums, 2));
		System.out.println("firstBadVersion:"+bs.firstBadVersion(2126753390));
		System.out.println("mySqrt:"+bs.mySqrt(2147483647));
		int[] houses={1,7};
		int[] heaters={1,7};
		System.out.println("TestBinarySearch:"+Arrays.binarySearch(houses, 0));
		System.out.println("findRadius:"+bs.findRadius(houses,heaters));
		System.out.println("isPerfectSquare:"+bs.isPerfectSquare(2147483647));
		System.out.println("guessNumber:"+bs.guessNumber(10));
		System.out.println(">>:"+(int)(-10>>1));
		System.out.println(">>>:"+(int)(-10>>>1));
		System.out.println("arrangeCoins:"+bs.arrangeCoins(1804289383));
		System.out.println(Math.floor(3.5));
		System.out.println(Math.ceil(3.4));
		int[] A={1,2};
		int[] B={-2,-1};
		int[] C={-1,2};
		int[] D={0,2};
		System.out.println("fourSumCount:"+bs.fourSumCount(A,B,C,D));
		int[] nums2={1,1};
		System.out.println("findDuplicate:"+bs.findDuplicate(nums2));
		int[] nums3={2,5,1,1,4,3};
//		{1,4,0,0,3,2};
		System.out.println("findDuplicate_2:"+bs.findDuplicate_2(nums3));
		int[][] matrix={{1,5,9},{10,11,13},{12,13,15}};
		System.out.println("kthSmallest:"+bs.kthSmallest(matrix,1));
		System.out.println("kthSmallest:"+bs.kthSmallest(matrix,9));
		Interval[] intervals={new Interval(3,4),new Interval(2,3),new Interval(1,2)};
//		Interval[] intervals={new Interval(1,12),new Interval(2,9),new Interval(3,10),
//				new Interval(13,14),new Interval(15,16),new Interval(16,17)};
		bs.findRightInterval_2(intervals);
		System.out.println("findRightInterval:"+bs.findRightInterval(intervals));
		int[] nums4={1,2,3,4,4,6,7};
		System.out.println("binarySearchUpper:"+bs.binarySearchUpper(nums4,5));
		int[][] matrix2={{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
		System.out.println("searchMatrix:"+bs.searchMatrix(matrix2,5));
		System.out.println("searchMatrix:"+bs.searchMatrix(matrix2,20));
		int[] nums6={4,4,4,5,6,7,0,0,1,2};
		System.out.println("search:"+bs.search(nums6,4));
		int[] nums1={3,3,1,3};
		System.out.println("findMin:"+bs.findMin(nums1));
		int[] nums5={5,6,7,1,2,3,4};
		System.out.println("findMin2:"+bs.findMin2(nums5));
		int[] citations={4,4, 0, 6, 1, 5};
		System.out.println("hIndex:"+bs.hIndex(citations));
		System.out.println("hIndex2:"+bs.hIndex2(citations));
		System.out.println("hIndex_2:"+bs.hIndex_2(citations));
		int[] nums7={5,7,7,8,8,10};
		System.out.println("searchRange:"+bs.searchRange(nums7,8));
		System.out.println("searchStart:"+bs.searchStart(nums7,8));
		System.out.println("searchEnd:"+bs.searchEnd(nums7,8));
		System.out.println("searchRange2:"+bs.searchRange2(nums7,8));
		int[] nums8={2,3,1,2,4,3};
		System.out.println("minSubArrayLen:"+bs.minSubArrayLen(7,nums8));
		System.out.println("myPow:"+bs.myPow(2,6));
		System.out.println("divide:"+bs.divide(-2147483648,1));
	}
}
