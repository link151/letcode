package letcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * 注意大数据加法，乘法时的益出问题
 * */
public class BinarySearch {

	Util util=new Util();
    public int searchInsert(int[] nums, int target) {
    	if(nums==null || nums.length==0)
    		return 0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==target)
    			return i;
    		if(nums[i]>target)
    			return i;
    	}
		return nums.length;
    }
    
    public int searchInsert_2(int[] nums, int target){
    	if(nums==null || nums.length==0)
    		return 0;
    	int low=0,high=nums.length-1;
    	while(low<=high){
    		int mid=(low+high)/2;
    		if(nums[mid]==target)
    			return mid;
    		else if(nums[mid]>target)
    			high=mid-1;
    		else
    			low=mid+1;
    	}
    	return low;
    }
    
    public int firstBadVersion(int n) {
    	if(n==0)
    		return 0;
    	int low=1,high=n;
    	while(low<=high){
    		int mid=low+(high-low)/2;
    		if(isBadVersion(mid))
    			high=mid-1;
    		else
    			low=mid+1;
    	}
		return low;
    }
    
    boolean isBadVersion(int version){
    	if(version<1702766719)
    		return false;
    	return true;
    }
    
    public int mySqrt(int x) {
    	if(x==0)
    		return 0;
    	int low=1,high=x;
    	while(low<=high){
    		int mid=low+(high-low)/2;
    		if(mid>x/mid)
    			high=mid-1;
    		else{
     			if((mid+1)>x/(mid+1))
    				return mid;
    			low=mid+1;
    		}
    	}
		return low;
    }
    public int mySqrt_2(int x) {
    	if(x==0)
    		return 0;
    	long r=x;
    	while(r*r>x)
    		r=(r+x/r)/2;
    	return (int)r;
    }
    
    public int findRadius(int[] houses, int[] heaters) {
    	Arrays.sort(heaters);
    	int minRadius=0;
    	for(int house:houses){
    		int pos=Arrays.binarySearch(heaters, house);
    		if(pos<0){
    			int fistDist=-(pos+1)-1>=0?house-heaters[-(pos+1)-1]:Integer.MAX_VALUE;
    			int secdDist=-(pos+1)<heaters.length?heaters[-(pos+1)]-house:Integer.MAX_VALUE;
    			minRadius=Math.max(minRadius,Math.min(fistDist, secdDist));
    		}
    	}
		return minRadius;
    }
    
    public boolean isPerfectSquare(int num) {
    	long low=1,high=num;
    	while(low<=high){
    		long mid=low+(high-low)/2;
    		if(mid*mid==num)
    			return true;
    		if(mid*mid>num)
    			high=mid-1;
    		else
    			low=mid+1;
    	}
		return false;
    }
    
    public int guessNumber(int n) {
    	int low=1,high=n;
    	while(low<=high){
    		int mid=low+(high-low)/2;
    		int guessRes=guess(mid);
    		if(guessRes==0)
    			return mid;
    		if(guessRes==1)
    			low=mid+1;
    		else
    			high=mid-1;
    	}
		return -1;
    }
    
    public int guess(int num){
    	return 6-num;
    }
    
    public int arrangeCoins(int n) {
		return (int)((Math.sqrt(8*(long)n+1)-1)/2);
    }
    
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A==null || A.length==0)
        	return 0;
        int cnt=0;
        HashMap<Integer,Integer> sum=new HashMap<Integer, Integer>();
        for(int a:A){
        	for(int b:B){
        		if(sum.containsKey(a+b))
        			sum.put(a+b, sum.get(a+b)+1);
        		else
        			sum.put(a+b, 1);
        	}
        }
        
        for(int c:C){
        	for(int d:D){
        		if(sum.containsKey(-(c+d)))
        			cnt+=sum.get(-(c+d));
        	}
        }
        return cnt;
    }
    
    public int kthSmallest(int[][] matrix, int k){
    	int min=matrix[0][0],max=matrix[matrix.length-1][matrix[0].length-1];
    	while(min<max){
    		int mid=min+(max-min)/2;
    		int cnt=0;
    		for(int i=0;i<matrix.length;i++){
    			int j=matrix[0].length-1;
    			while(j>=0 && matrix[i][j]>mid)
    				j--;
    			cnt+=j+1;
    		}
    		if(cnt<k)
    			min=mid+1;
    		else
    			max=mid;
    	}
		return min;
    }
    
    public int findDuplicate(int[] nums) {
    	if(nums==null || nums.length<2)
    		return -1;
    	int low=1,high=nums.length-1;
    	while(low<high){
    		int mid=low+(high-low)/2;
    		int cnt=0;
    		for(int num:nums){
    			if(num<=mid)
    				cnt++;
    		}
    		if(cnt>mid)
    			high=mid;
    		else
    			low=mid+1;
    	}
		return high;
    }
    
    public int findDuplicate_2(int[] nums){
    	if(nums==null || nums.length<2)
    		return -1;
    	int slow=0,fast=0;
    	do{
    		slow=nums[slow];
    		fast=nums[nums[fast]];
//    		System.out.println(slow+"  "+fast);
    	}while(slow!=fast);
    	int find=0;
//    	System.out.println("=======");
    	while(find!=slow){
    		slow=nums[slow];
    		find=nums[find];
//    		System.out.println(slow+"   "+find);
    	}
		return slow;
    }
    
    /***
     * Time Limit Exceeded
     * */
    public int[] findRightInterval(Interval[] intervals) {
        int[] res=new int[intervals.length];
        Arrays.fill(res, Integer.MAX_VALUE);
        int i=0;
        for(Interval interval:intervals){
        	int j=0;
        	for(Interval interval2:intervals){
        		if(interval2.start>=interval.end)
        			res[i]=res[i]!=Integer.MAX_VALUE? intervals[res[i]].start>intervals[j].start?j:res[i]:j;
        		j++;
        	}
        	res[i]=res[i]==Integer.MAX_VALUE?-1:res[i];
        	i++;
        }
        return res;
    }
    
    public int[] findRightInterval_2(Interval[] intervals){
    	int[] res=new int[intervals.length];
    	int[] start=new int[intervals.length];
    	
    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    	for(int i=0;i<intervals.length;i++){
    		map.put(intervals[i].start, i);
    		start[i]=intervals[i].start;
    	}
    	
    	Arrays.sort(start);
    	
    	res[map.get(start[intervals.length-1])]=-1;
    	for(int i=0;i<=intervals.length-1;i++){
    		if(binarySearchUpper(start,intervals[i].end)!=-1)
    			res[map.get(intervals[i].start)]=map.get(start[binarySearchUpper(start,intervals[i].end)]);
			else{
				res[map.get(intervals[i].start)]=-1;
			}
    	}
		return res;
    }
    
    public int binarySearchUpper(int[] nums,int key){
    	int low=0,high=nums.length-1;
    	while(low<high){
    		int mid=low+(high-low)/2;
    		if(nums[mid]>=key)
    			high=mid;
    		else
    			low=mid+1;
    	}
    	if(nums[low]>=key)
    		return low;
    	else
    		return -1;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix==null || matrix.length==0)
    		return false;
    	int m=matrix.length,n=matrix[0].length;
    	for(int i=0,j=n-1;i<m && j>=0;i++){
    		while(j>=1 && matrix[i][j]>target)
    			j--;
    		if(matrix[i][j]==target)
    			return true;
    	}
		return false;
    }
    
    public int findPeakElement(int[] nums) {
    	if(nums==null || nums.length==0)
    		return 0;
    	for(int i=1;i<nums.length-1;i++){
    		if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
    			return i;
    	}
    	if(nums.length>=2 && nums[nums.length-1]>nums[nums.length-2])
    		return nums.length-1;
		return 0;
    }
    
    public boolean searchMatrix1(int[][] matrix, int target) {
    	if(matrix==null || matrix.length==0 || matrix[0].length==0)
    		return false;
    	for(int i=0;i<matrix.length;i++){
    		if(matrix[i][matrix[0].length-1]==target)
    			return true;
    		else if(matrix[i][matrix[0].length-1]>target){
    			int low=0,high=matrix[0].length-1;
    			while(low<=high){
    				int mid=low+(high-low)/2;
    				if(matrix[i][mid]==target)
    					return true;
    				if(matrix[i][mid]>target)
    					high=mid-1;
    				else
    					low=mid+1;
    			}
    		}
    	}
		return false;
    }
    
    public int search(int[] nums, int target) {
    	int low=0,high=nums.length-1;
    	while(low<high){
    		int mid=low+(high-low)/2;
    		if(nums[mid]>nums[high])
    			low=mid+1;
    		else
    			high=mid;
    	}
    	int rot=low;
    	
    	low=0;
    	high=nums.length-1;
    	while(low<=high){
    		int mid=low+(high-low)/2;
    		int realMid=(mid+rot)%nums.length;
    		if(nums[realMid]==target){
    			if(realMid>=1 && nums[realMid-1]==target)
    				high=mid-1;
    			else
    				return realMid;
    		}
    		else if(nums[realMid]>target)
    			high=mid-1;
    		else
    			low=mid+1;
    	}
		return -1;
    }
    
    public int findMin2(int[] nums) {
    	if(nums==null || nums.length==0)
    		return 0;
    	int low=0,high=nums.length-1;
    	while(low<high){
    		int mid=low+(high-low)/2;
    		if(nums[mid]>=nums[high])
    			low=mid+1;
    		else if(nums[mid]<=nums[high])
    			high=mid;
    	}
		return nums[low];
    }
    
    public int findMin(int[] nums) {
    	if(nums==null || nums.length==0)
    		return 0;
    	if(nums.length==1)
    		return nums[0];
    	int low=0,high=nums.length-1;
    	while(low<high){
    		int mid=low+(high-low)/2;
    		if(nums[mid]>nums[high])
    			low=mid+1;
    		else if(nums[mid]<nums[high])
    			high=mid;
    		else
    			high--;
    	}
		return nums[low];
    }
    
    public int hIndex(int[] citations) {
    	if(citations==null || citations.length==0)
    		return 0;
    	Arrays.sort(citations);
    	int low=0,high=citations.length-1;
    	while(low<=high){
    		int mid=low+(high-low)/2;
    		if(citations[mid]>=citations.length-mid)
    			high=mid-1;
    		else
    			low=mid+1;
    	}
		return citations.length-low;
    }
    public int hIndex2(int[] citations){
    	int[] arr=new int[citations.length+1];
    	for(int i=0;i<citations.length;i++){
    		if(citations[i]>citations.length)
    			arr[citations.length]++;
    		else
    			arr[citations[i]]++;
    	}
    	int cntSum=0;
    	for(int i=citations.length;i>=0;i--){
    		cntSum+=arr[i];
    		if(cntSum>=i)
    			return i;
    	}
		return 0;
    }
    
    public int hIndex_2(int[] citations) {
    	if(citations==null || citations.length==0)
    		return 0;
    	int low=0,high=citations.length-1;
    	while(low<=high){
    		int mid=low+(high-low)/2;
    		if(citations[mid]>=citations.length-mid)
    			high=mid-1;
    		else
    			low=mid+1;
    	}
		return citations.length-low;
    }
    
    public int[] searchRange(int[] nums, int target) {
    	int[] res={-1,-1};
    	int low=0,high=nums.length-1;
    	while(low<=high){
    		int mid=low+(high-low)/2;
    		if(nums[mid]<target)
    			low=mid+1;
    		else if(nums[mid]>target)
    			high=mid-1;
    		else{
    			int i=mid,j=mid;
    			while(i>low && i-1>=0 && nums[i-1]==target)
    				i--;
    			while(j<high && j+1<=nums.length-1 && nums[j+1]==target)
    				j++;
    			res[0]=i;
    			res[1]=j;
    			return res;
    		}
    	}
		return res;
    }
    
    public int[] searchRange2(int[] nums, int target){
    	int[] res={-1,-1};
    	res[0]=searchStart(nums, target);
    	res[1]=searchEnd(nums, target);
		return res;
    }
    public int searchStart(int[] nums, int target){
    	if(nums==null || nums.length==0)
    		return -1;
    	int low=0,high=nums.length-1;
    	while(low<high){
    		int mid=low+(high-low)/2;
    		if(nums[mid]<target)
    			low=mid+1;
    		else 
    			high=mid;
    	}
		return nums[low]==target?low:-1;
    }
    public int searchEnd(int[] nums, int target){
    	if(nums==null || nums.length==0)
    		return -1;
    	int low=0,high=nums.length-1;
    	while(low<=high){
    		int mid=low+(high-low)/2;
    		if(nums[mid]>target)
    			high=mid-1;
    		else
    			low=mid+1;
    	}
    	return high>=0 && nums[high]==target?high:-1;
    }
    
    public int minSubArrayLen(int s, int[] nums) {
    	int[] sum=new int[nums.length+1];
    	for(int i=0;i<nums.length;i++)
    		sum[i+1]=sum[i]+nums[i];
    	
    	int minLen=Integer.MAX_VALUE;
    	for(int i=1;i<=sum.length;i++){
    		int index=Arrays.binarySearch(sum, s+sum[i-1]);
    		int tmp=index<=0?Math.abs(index+1):index;
    		if(tmp==sum.length)
    			break;
			minLen=Math.min(minLen, tmp-i+1);
    	}
		return minLen==Integer.MAX_VALUE?0:minLen;
    }
    
    public double myPow(double x, int n) {
    	if(n==0)
    		return 1.0;
    	int tmpN=n;
    	StringBuilder sb=new StringBuilder(Integer.toBinaryString(Math.abs(tmpN)));
    	String nBin=sb.reverse().toString();
    	double[] pow=new double[nBin.length()];
    	pow[0]=x;
    	double ans=nBin.charAt(0)=='1'?pow[0]:1.0;
    	for(int i=1;i<nBin.length();i++){
    		pow[i]=pow[i-1]*pow[i-1];
    		ans=nBin.charAt(i)=='1'?ans*pow[i]:ans;
    	}
		return n<0?1.0/ans:ans;
    }

    public int divide(int dividend, int divisor) {
    	if(divisor==0 || (dividend==Integer.MIN_VALUE && divisor==-1))
    		return Integer.MAX_VALUE;
    	boolean sign=(dividend<0) ^ (divisor<0)?true:false;
    	long dvd=Math.abs((long)dividend);
    	long dvs=Math.abs((long)divisor);
    	int res=0;
    	while(dvd>=dvs){
    		int multip=1;
    		long tmp=dvs;
    		while(dvd >= (tmp<<1)){
    			tmp<<=1;
    			multip<<=1;
    		}
    		res+=multip;
    		dvd-=tmp;
    	}
		return sign==true?-res:res;
    }
    
    public int kthSmallest(TreeNode root, int k) {
    	int cnt=countNodes(root.left);
    	if(k<=cnt)
    		return kthSmallest(root.left, k);
    	else if(k>cnt+1)
    		return kthSmallest(root.right, k-1-cnt);
		return root.val;
    }
    public int countNodes(TreeNode node){
    	if(node==null)
    		return 0;
		return 1+countNodes(node.left)+countNodes(node.right);
    }
}
