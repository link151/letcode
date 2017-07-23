package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import letcode.ListNode;
import letcode.TreeNode;
import letcode.Util;

public class Sol {

	Util util=new Util();
    public int findPairs(int[] nums, int k) {
        int cnt=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
        	if(k!=0){
        		while(i+1<nums.length && nums[i+1]==nums[i])
        			i++;
        		int j=i+1;
        		while(j<nums.length && nums[i]+k>nums[j]){
        			j++;
        		}
        		if(j<nums.length && nums[i]+k==nums[j])
        			cnt++;
        	}else{
        		if(i+1<nums.length && nums[i+1]==nums[i]){
        			cnt++;
        			i++;
        		}
        		while(i+1<nums.length && nums[i+1]==nums[i])
        			i++;
        	}
        }
        return cnt;
    }
    
    /**
     * 链表反转
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode nl1=reverseList(l1);
    	ListNode nl2=reverseList(l2);
    	ListNode head=null;
    	int carry=0;
    	while(nl1!=null && nl2!=null){
    		ListNode p1=nl1;
    		ListNode p2=nl2;
    		nl1=nl1.next;
    		nl2=nl2.next;
    		int sum=(p1.val+p2.val+carry)%10;
    		carry=(p1.val+p2.val+carry)/10;
    		p1.val=sum;
    		p1.next=head;
    		head=p1;
    	}
    	while(nl1!=null){
    		ListNode p1=nl1;
    		nl1=nl1.next;
    		int sum=(p1.val+carry)%10;
    		carry=(p1.val+carry)/10;
    		p1.val=sum;
    		p1.next=head;
    		head=p1;
    	}
    	while(nl2!=null){
    		ListNode p2=nl2;
    		nl2=nl2.next;
    		int sum=(p2.val+carry)%10;
    		carry=(p2.val+carry)/10;
    		p2.val=sum;
    		p2.next=head;
    		head=p2;
    	}
    	if(carry!=0){
    		ListNode node=new ListNode(carry);
    		node.next=head;
    		head=node;
    	}
//    	printList(head);
    	return head;
    }
    
    public ListNode reverseList(ListNode list){
    	ListNode head=list;
    	ListNode newHead=null;
    	while(head!=null){
    		ListNode newNode=head;
    		head=head.next;
    		newNode.next=newHead;
    		newHead=newNode;
//    		System.out.print(newHead.val);
    	}
//    	System.out.println();
    	return newHead;
    }
    
    /**
     * 使用Stack
     * */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    	Stack<Integer> s1=new Stack<Integer>();
    	Stack<Integer> s2=new Stack<Integer>();
    	while(l1!=null){
    		s1.push(l1.val);
    		l1=l1.next;
    	}
    	while(l2!=null){
    		s2.push(l2.val);
    		l2=l2.next;
    	}
    	int sum=0;
    	ListNode head=null;
    	while(!s1.isEmpty() || !s2.isEmpty()){
    		sum=s1.isEmpty()?sum:sum+s1.pop();
    		sum=s2.isEmpty()?sum:sum+s2.pop();
    		ListNode newNode=new ListNode(sum%10);
    		sum/=10;
    		newNode.next=head;
    		head=newNode;
    	}
    	if(sum!=0){
    		ListNode newNode=new ListNode(sum);
    		newNode.next=head;
    		head=newNode;
    	}
    	return head;
    }
    
    public boolean isPalindrome(ListNode head) {
    	Stack<Integer> stack=new Stack<Integer>();
    	int len=0;
    	ListNode p=head;
    	while(p!=null){
    		len++;
    		p=p.next;
    	}
    	
    	for(int i=0;i<len/2;i++){
    		stack.push(head.val);
    		head=head.next;
    	}
    	if(len%2==1 && head!=null)
    		head=head.next;
    	for(int i=0;i<len/2;i++){
    		if(stack.pop()!=head.val)
    			return false;
    		head=head.next;
    	}
    	return true;
    }
    
    public ListNode oddEvenList(ListNode head) {
    	if(head==null)
    		return head;
        ListNode oddHead=head;
        ListNode evenHead=head.next;
        ListNode p1=oddHead;
        ListNode p2=evenHead;
        while(p1!=null && p1.next!=null && p2!=null && p2.next!=null){
        	p1.next=p2.next;
        	p1=p1.next;
        	p2.next=p1.next;
        	p2=p2.next;
        }
        p1.next=evenHead;
        return oddHead;
    }
    
    public ListNode removeElements(ListNode head, int val) {
    	if(head==null)
    		return head;
    	ListNode fakeHead=new ListNode(-1);
    	fakeHead.next=head;
    	ListNode prev=fakeHead;
    	ListNode curr=prev.next;
    	while(curr!=null){
    		if(curr.val==val){
    			prev.next=curr.next;
    			curr=prev.next;
    		}else{
    			prev.next=prev.next;
    			curr=curr.next;
    		}
    	}
    	return prev.next;
    }
    
    public ListNode removeElements2(ListNode head, int val) {
    	if(head==null)
    		return head;
    	while(head!=null && head.val==val)
    		head=head.next;
    	ListNode curr=head;
    	while(curr!=null && curr.next!=null){
    		if(curr.next.val==val)
    			curr.next=curr.next.next;
    		else
    			curr=curr.next;
    	}
    	return head;
    }
    
    public ListNode removeElements3(ListNode head, int val){
    	if(head==null)
    		return head;
    	head.next=removeElements(head.next, val);
    	return head.val==val?head.next:head;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0,lenB=0;
        ListNode hA=headA,hB=headB;
        while(hA!=null){
        	lenA++;
        	hA=hA.next;
        }
        while(hB!=null){
        	lenB++;
        	hB=hB.next;
        }
        ListNode startA=headA,startB=headB;
        if(lenA>lenB){
        	for(int i=0;i<lenA-lenB;i++)
        		startA=startA.next;
        }else if(lenA<lenB){
        	for(int i=0;i<lenB-lenA;i++)
        		startB=startB.next;
        }
        while(startA!=null && startB!=null){
        	if(startA!=startB)
        		return startA;
        	startA=startA.next;
        	startB=startB.next;
        }
        return null;
    }
    
    public boolean hasCycle(ListNode head) {
    	if(head==null)
    		return false;
    	ListNode walker=head;
    	ListNode runner=head;
    	while(runner.next!=null && runner.next.next!=null){
    		walker=walker.next;
    		runner=runner.next.next;
    		if(walker==runner)
    			return true;
    	}
    	return false;
    }
    
    public void printList(ListNode list){
    	while(list!=null){
    		System.out.print(list.val+" ");
    		list=list.next;
    	}
    	System.out.println();
    }
    
    public int[] countBits(int num) {
    	int[] dp=new int[num+1];
    	int offset=1;
    	dp[0]=0;
    	for(int i=1;i<=num;i++){
    		if(2*offset==i){
    			offset*=2;
    		}
    		dp[i]=dp[i-offset]+1;
    	}
    	Util util=new Util();
    	util.printIntArr(dp);
		return dp;
    }
    
    public int numberOfArithmeticSlices(int[] A) {
    	if(A==null || A.length<3)
    		return 0;
    	int[] dtA=new int[A.length];
    	for(int i=1;i<A.length;i++){
    		dtA[i-1]=A[i]-A[i-1];
//    		System.out.print(dtA[i-1]+" ");
    	}
    	int[] dp=new int[A.length+1];
    	dp[0]=0;
    	dp[1]=0;
    	for(int i=2;i<A.length;i++){
    		dp[i]=dp[i-1]+i-1;
    	}
    	int cnt=0;
    	int tmpCnt=1;
    	int i=0;
    	for(;i<dtA.length-2;i++){
    		if(dtA[i+1]!=dtA[i]){
//    			System.out.println("tmpCnt:"+tmpCnt);
    			cnt+=dp[tmpCnt];
    			tmpCnt=1;
    		}else{
    			tmpCnt++;
    		}
    	}
    	if(i==dtA.length-2)
    		cnt+=dp[tmpCnt];
//    	System.out.println("tmpCnt0:"+tmpCnt);
		return cnt;
    }
    
    public int countNumbersWithUniqueDigits(int n) {
    	if(n==0)
    		return 1;
    	int[] dp=new int[n+1];
    	dp[0]=0;
    	if(n>=1)
    		dp[1]=10;
    	if(n>=2)
    		dp[2]=9*9;
    	for(int i=3,j=8;j>=0 && i<=n;i++,j--){
    		dp[i]=dp[i-1]*j;
    	}
    	int res=0;
    	for(int i=0;i<=n;i++)
    		res+=dp[i];
    	return res;
    }
    public int countNumbersWithUniqueDigits2(int n) {
    	if(n==0)
    		return 1;
    	int res=10;
    	int uniqueDigits=9;
    	for(int i=2,j=9;j>=0 && i<=n;i++,j--){
    		uniqueDigits=uniqueDigits*j;
    		res+=uniqueDigits;
    	}
    	return res;
    }
    
    public int integerBreak(int n) {
    	if(n==2)
    		return 1;
    	if(n==3)
    		return 2;
    	int[] dp=new int[n+1];
    	dp[1]=1;
    	dp[2]=2;
    	dp[3]=3;
    	for(int i=4;i<=n;i++){
    		dp[i]=i-1;
    		for(int j=2;j<=i/2;j++){
    			if(dp[j]*dp[i-j]>dp[i]){
    				dp[i]=dp[j]*dp[i-j];
    				System.out.println(i+"\t"+j+"\t"+(i-j));
    			}
    		}
    		System.out.println();
    	}
    	return dp[n];
    }
    
    public int integerBreak2(int n) {
    	if(n==2)
    		return 1;
    	if(n==3)
    		return 2;
    	int[] dp=new int[n+1];
    	dp[1]=1;
    	for(int i=2;i<=n;i++){
    		for(int j=2;j<=i/2;j++){
    			dp[i]=Math.max(dp[i], Math.max(j, dp[j])*Math.max(i-j, dp[i-j]));
    		}
    	}
    	return dp[n];
    }
    
    public boolean isSubsequence(String s, String t) {
    	if(s==null || s.length()==0)
    		return true;
    	char[] s_arr=s.toCharArray();
    	char[] t_arr=t.toCharArray();
    	int i=0,j=0;
    	while(j<t_arr.length && i<s_arr.length){
			if(t_arr[j]==s_arr[i]){
				i++;
			}
			j++;
    	}
    	if(i==s_arr.length && j>=1 && s_arr[s_arr.length-1]==t_arr[j-1])
    		return true;
    	return false;
    }
    
    public void testBinarySearch(List<Integer> list,int key){
    	int j=Collections.binarySearch(list, key);
    	System.out.println("j:"+j);
    }
    
    public boolean PredictTheWinner(int[] nums) {
    	if(nums.length<=2)
    		return true;
		int[][] dp=new int[nums.length][nums.length];
		for(int i=0;i<nums.length;i++)
			dp[i][i]=nums[i];
//		Util util=new Util();
//		util.printIntArr2(dp);
		for(int len=1;len<nums.length;len++){
			for(int i=0;i<nums.length-len;i++){
				int j=i+len;
				dp[i][j]=Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
			}
//			System.out.println("len:"+len);
//			util.printIntArr2(dp);
		}
		return dp[0][nums.length-1]>=0;
    }
    
    public boolean canPartition(int[] nums) {
    	int sum=0;
    	for(int i=0;i<nums.length;i++){
    		sum+=nums[i];
    	}
    	if(sum%2!=0)
    		return false;
    	int target=sum/2;
    	
    	boolean[][] dp=new boolean[nums.length][target+1];
    	for(int i=0;i<nums.length;i++)
    		dp[i][0]=true;
    	if(nums[0]<=target)
    		dp[0][nums[0]]=true;

    	for(int i=1;i<nums.length;i++){
    		for(int j=1;j<=target;j++){
				dp[i][j]=dp[i-1][j];
    			dp[i][j]=j-nums[i]>=0?dp[i-1][j-nums[i]]:dp[i][j];
    		}
    	}
    	return dp[nums.length-1][target];
    }
    
    public int findTargetSumWays(int[] nums, int S) {
    	int sum=0;
    	for(int i=0;i<nums.length;i++)
    		sum+=nums[i];
    	if((sum+S)%2!=0 || sum<S)
    		return 0;
    	int target=(sum+S)/2;
    	
    	int[] dp=new int[target+1];
    	dp[0]=1;
    	for(int i=nums.length-1;i>=0;i--){
    		for(int j=target;j>=nums[i];j--)
    			dp[j]+=dp[j-nums[i]];
    	}
		return dp[target];
    }
    
    public int longestPalindromeSubseq(String s) {
    	if(s==null || s.length()==0)
    		return 0;
    	char[] arr=s.toCharArray();
    	int[][] dp=new int[arr.length][arr.length];
    	for(int i=0;i<arr.length;i++)
    		dp[i][i]=1;
    	
    	for(int len=1;len<arr.length;len++){
    		for(int i=0;i<arr.length-len;i++){
    			int j=i+len;
    			if(arr[i]==arr[j])
    				dp[i][j]=dp[i+1][j-1]+2;
    			else
    				dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
    		}
    	}
		return dp[0][arr.length-1];
    }
    
    public int maxProfit(int[] prices) {
    	if(prices==null || prices.length<=1)
    		return 0;
    	int[] buy=new int[prices.length];
    	int[] sell=new int[prices.length];
    	buy[0]=-prices[0];
    	sell[0]=0;
    	buy[1]=Math.max(buy[0], -prices[1]);
    	sell[1]=Math.max(sell[0], prices[1]-prices[0]);
    	for(int i=2;i<prices.length;i++){
    		buy[i]=Math.max(buy[i-1], sell[i-2]-prices[i]);
    		sell[i]=Math.max(sell[i-1], buy[i-1]+prices[i]);
    	}
		return sell[prices.length-1];
    }
    public int maxProfit_2(int[] prices) {
    	if(prices==null || prices.length<=1)
    		return 0;
    	int b0=-prices[0];
    	int b1=Math.max(b0, -prices[1]);
    	int s0=0;
    	int s1=Math.max(s0, prices[1]-prices[0]);
    	int s2=0;
    	b0=Math.max(b1,s2-prices[1]);
		s0=Math.max(s1, b1+prices[1]);
		b1=b0;
		s2=s1;
		s1=s0;
    	for(int i=2;i<prices.length;i++){
    		b0=Math.max(b1,s2-prices[i]);
    		s0=Math.max(s1, b1+prices[i]);
    		b1=b0;
    		s2=s1;
    		s1=s0;
    	}
    	return s0;
    }
    
    public int maxCoins(int[] nums) {
    	if(nums==null || nums.length==0)
    		return 0;
    	int[] nums2=new int[nums.length+2];
    	int n=1;
    	for (int i : nums) {
			nums2[n++]=i;
		}
    	nums2[0]=nums2[n++]=1;
    	int[][] dp=new int[n][n];
    	for(int len=2;len<n;len++){
    		for(int i=0;i<n-len;i++){
    			int j=i+len;
    			for(int k=i+1;k<j;k++)
    				dp[i][j]=Math.max(dp[i][j], nums2[i]*nums2[k]*nums2[j]+
    						dp[i][k]+dp[k][j]);
    		}
    	}
		return dp[0][n-1];
    }
    
    public int uniquePaths(int m, int n) {
    	int[][] dp=new int[m][n];
    	for (int i = 0; i < m; i++)
			dp[i][0]=1;
    	for(int j=0;j<n;j++)
    		dp[0][j]=1;
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			dp[i][j]=dp[i-1][j]+dp[i][j-1];
    		}
    	}
		return dp[m-1][n-1];
    }
    
    public int minPathSum(int[][] grid) {
    	int[][] dp=new int[grid.length][grid[0].length];
    	dp[0][0]=grid[0][0];
    	for(int i=1;i<grid.length;i++)
    		dp[i][0]=dp[i-1][0]+grid[i][0];
    	for(int j=1;j<grid[0].length;j++)
    		dp[0][j]=dp[0][j-1]+grid[0][j];
    	
    	for(int i=1;i<grid.length;i++){
    		for(int j=1;j<grid[0].length;j++){
    			dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
    		}
    	}
		return dp[grid.length-1][grid[0].length-1];
    }
    
    public int lengthOfLIS(int[] nums) {
    	if(nums==null)
    		return 0;
    	if(nums.length<=1)
    		return nums.length;
    	int[][] len=new int[nums.length][2];
    	int[] minMax=new int[nums.length];
    	len[0][0]=0;
    	len[0][1]=1;
    	minMax[0]=Integer.MAX_VALUE;
    	for(int i=1;i<nums.length;i++){
    		if(len[i-1][0]>len[i-1][1]){
    			len[i][0]=len[i-1][0];
    			minMax[i]=minMax[i-1];
    		}else if(len[i-1][0]<len[i-1][1]){
    			len[i][0]=len[i-1][1];
    			minMax[i]=nums[i-1];
    		}else{
    			len[i][0]=len[i-1][1];
    			minMax[i]=Math.min(nums[i-1], minMax[i-1]);
    		}
    		
//    		len[i][0]=Math.max(len[i-1][0], len[i-1][1]);
    		int k=i-1;
    		while(k>=0 && nums[i]<=nums[k])
    			k--;
    		if(k!=-1)
    			len[i][1]=len[k][1]+1;
    		else
    			len[i][1]=1;
    		
    		k=i;
    		while(k>=0 && nums[i]<=minMax[k])
    			k--;
    		if(k!=-1)
    			len[i][1]=Math.max(len[i][1],len[k][0]+1);
    		else
    			len[i][1]=1;
    	}
		return Math.max(len[nums.length-1][0], len[nums.length-1][1]);
    }
    
/*    public int findMaxForm(String[] strs, int m, int n) {
		if(strs.length==0)
			return 0;
		int[][][] dp=new int[strs.length+1][m+1][n+1];
		
		int index=0;
		for(String str:strs){
			index++;
			int num1=numsOne(str);
			int num0=str.length()-num1;
			for(int j=1;j<=m;j++){
				for(int k=1;k<=n;k++){
//					dp[index][j][k]=dp[index-1][j][k];
					if(j>=num0 && k>=num1)
						dp[index][j][k]=Math.max( dp[index][j][k],dp[index-1][j-num0][k-num1]+1);
				}
			}
		}
		int max=0;
		for(int i=0;i<strs.length;i++)
			for(int j=0;j<m;j++)
				for(int k=0;k<n;k++)
					max=dp[i][m][n]>max?dp[i][m][n]:max;
		return max;
	}
    
    public int numsOne(String str){
    	int cnt=0;
    	for(int i=0;i<str.length();i++){
    		if(str.charAt(i)=='1')
    			cnt++;
    	}
    	return cnt;
    }*/
    
    public int findMaxForm(String[] strs, int m, int n) {
    	if(strs.length==0)
    		return 0;
    	int[][] dp=new int[m+1][n+1];
    	int[] cnt=new int[2];
    	for(String str:strs){
    		cnt=numsOne(str);
    		for(int i=m;i>=cnt[0];i--){
    			for(int j=n;j>=cnt[1];j--){
    				dp[i][j]=Math.max(dp[i][j], dp[i-cnt[0]][j-cnt[1]]+1);
    			}
    		}
    	}
    	return dp[m][n];
    }
    
    public int[] numsOne(String str){
    	int[] cnt=new int[2];
    	for(int i=0;i<str.length();i++){
    		if(str.charAt(i)=='1')
    			cnt[1]++;
    		else
    			cnt[0]++;
    	}
    	return cnt;
    }
    
    public int numSquares(int n) {
    	int numSqu=(int) Math.ceil(Math.sqrt(n));
    	int[] sq=new int[numSqu+1];
    	for(int i=0;i<sq.length;i++)
    		sq[i]=i*i;
    	
    	int[][] dp=new int[numSqu+1][n+1];
    	for(int j=0;j<=n;j++)
    		dp[1][j]=j;
    	
    	for(int i=2;i<=numSqu;i++){
    		dp[i][0]=0;
    		for(int j=1;j<=n;j++){
    			dp[i][j]=dp[i-1][j];
				if(j>=i*i)
					dp[i][j]=Math.min(dp[i][j-i*i]+1, dp[i-1][j]);
    		}
    	}
		return dp[numSqu][n];
    }
    
/*    public int getMoneyAmount(int n) {
    	if(n==1)
    		return 0;
    	int[][][] dp=new int[n+1][n+1][2];
    	for(int i=1;i<n;i++){
    		dp[i][i][0]=0;
    		dp[i][i][1]=0;
    		dp[i][i+1][0]=i;
    		dp[i][i+1][1]=i;
    	}
    	dp[n][n][0]=0;
    	dp[n][n][1]=0;
    	
    	for(int len=2;len<n;len++){
    		for(int i=1;i<=n-len;i++){
    			int j=i+len;
    			dp[i][j][1]=Math.max(dp[i+1][j][0],dp[i+1][j][1])+i;
    			for(int k=i+1;k<j;k++){
    				dp[i][j][0]=Math.min(dp[i][j][0], Math.max(dp[i][k-1][0], dp[i][k-1][1])+k);
    				dp[i][j][1]=Math.min(dp[i][j][1], Math.max(dp[k+1][j][0], dp[k+1][j][1])+k);
    			}
    			dp[i][j][0]=Math.max(dp[i][j-1][0],dp[i][j-1][1])+j;
    		}
    	}
    	return Math.max(dp[1][n][0], dp[1][n][1]);
    }*/
    
    public int getMoneyAmount(int n) {
    	if(n==1)
    		return 0;
    	int[][] dp=new int[n+1][n+1];
    	for(int i=1;i<n;i++){
    		dp[i][i]=0;
    		dp[i][i+1]=i;
    	}
    	dp[n][n]=0;
    	
		for(int len=2;len<n;len++){
			for(int i=1;i<=n-len;i++){
				int j=i+len;
				dp[i][j]=dp[i+1][j]+i;
				for(int k=i+1;k<j;k++){
					dp[i][j]=Math.min(dp[i][j],Math.max(dp[i][k-1],dp[k+1][j])+k);
				}
				dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+j);
			}
			
		}
		return dp[1][n];
    }
    
/*    public int findMinMoves(int[] machines) {
    	if(machines.length==1)
    		return 0;
    	int sum=0;
    	int maxNum=0;
    	for(int i=0;i<machines.length;i++){
    		sum+=machines[i];
    		maxNum=machines[i]>maxNum?machines[i]:maxNum;
    	}
    	if(sum%machines.length!=0)
    		return -1;
    	int ave=sum/machines.length;
    	int[] dt=new int[machines.length];
    	int[] dp=new int[machines.length];
    	
    	dt[0]=machines[0]-ave;
    	dp[0]=dt[0];
    	int min=dp[0];
    	for(int i=1;i<machines.length;i++){
    		dt[i]=machines[i]-ave;
    		dp[i]=dp[i-1]+dt[i];
    		min=Math.min(dp[i], min);
    	}
		return -min;
    }*/
    
    public int wiggleMaxLength(int[] nums) {
    	if(nums==null || nums.length==0)
    		return 0;
    	int[] dp=new int[nums.length];
    	dp[0]=1;
    	int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
    	for(int i=1;i<nums.length;i++){
    		if(nums[i]<nums[i-1] && (dp[i-1]>0 || dp[i-1]==1))
    			dp[i]=-(Math.abs(dp[i-1])+1);
    		else if(nums[i]>nums[i-1] && (dp[i-1]<0 || dp[i-1]==1))
    			dp[i]=Math.abs(dp[i-1])+1;
    		else{
    			dp[i]=dp[i-1];
    			max=Math.max(max, nums[i]);
    			min=Math.min(min, nums[i]);
    		}
    	}
		return Math.abs(dp[nums.length-1]);
    }
    
    public int rob2(int[] nums) {
    	if(nums==null || nums.length==0)
    		return 0;
    	if(nums.length==1)
    		return nums[0];
    	if(nums.length==2)
    		return nums[0]>nums[1]?nums[0]:nums[1];
		return Math.max(rob2Helper(nums,0,nums.length-2),rob2Helper(nums,1,nums.length-1));
    }
    public int rob2Helper(int[] nums,int start,int end){
    	int include=0,exclude=0;
    	for(int i=start;i<=end;i++){
    		int include0=include;
    		int exclude0=exclude;
    		include=exclude0+nums[i];
    		exclude=Math.max(include0, exclude0);
    	}
    	return Math.max(include, exclude);
    }
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	List<Integer> res=new ArrayList<Integer>();
    	if(nums==null || nums.length==0)
    		return res;
    	Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int[] preIndex=new int[nums.length];
        dp[0]=1;
        Arrays.fill(preIndex, -1);
        int maxIndex=0;
        int maxlen=1;
        for(int i=1;i<nums.length;i++){
        	for(int k=i-1;k>=0;k--){
        		if(nums[i]%nums[k]==0 && dp[k]+1>dp[i]){
        			dp[i]=dp[k]+1;
        			preIndex[i]=k;
        			if(dp[i]>maxlen){
        				maxlen=dp[i];
        				maxIndex=i;
        			}
        		}
        	}
        }
        int cur=maxIndex;
        do{
        	res.add(nums[cur]);
        	cur=preIndex[cur];
        }while(cur!=-1);
        Collections.sort(res, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1==o2)
					return 0;
				if(o1>o2)
					return 1;
				else
					return -1;
			}
		});
		return res;
    }
    
    public int findRotateSteps(String ring, String key) {
    	String str=ring;
    	int ringlen=str.length();
    	ring=ring+ring;
    	int start=0;
    	int cnt=0;
    	for(int i=0;i<key.length();i++){
    		char ch=key.charAt(i);
    		int firstIndex=ring.indexOf(ch, start);
    		int lastIndex=ring.lastIndexOf(ch, start+ringlen);
    		if(firstIndex==-1 || (firstIndex-start)%ringlen>=(start+ringlen-lastIndex)%ringlen){
    			cnt=cnt+(start+ringlen-lastIndex)%ringlen;
    			start=lastIndex%ringlen;
    		}else if(lastIndex==-1 || (firstIndex-start)%ringlen<(start+ringlen-lastIndex)%ringlen){
    			cnt=cnt+(firstIndex-start)%ringlen;
    			start=firstIndex%ringlen;
    		}
    	}
		return cnt+key.length();
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
    	int[] cnt=new int[triangle.size()];
    	cnt[0]=triangle.get(0).get(0);
    	for(int i=1;i<triangle.size();i++) {
			List<Integer> list=triangle.get(i);
			cnt[i]=cnt[i-1]+list.get(i);
    		for(int j=i-1;j>0;j--){
    			cnt[j]=Math.min(cnt[j-1], cnt[j])+list.get(j);
    		}
    		cnt[0]=cnt[0]+list.get(0);
//    		util.printList(list);
//    		util.printIntArr(cnt);
		}
    	int min=Integer.MAX_VALUE;
    	for(int i=0;i<cnt.length;i++)
    		min=Math.min(min, cnt[i]);
		return min;
    }
    
    public int nthUglyNumber(int n) {
    	List<Integer> list=new ArrayList<Integer>();
    	list.add(1);
    	int indexA=0,indexB=0,indexC=0;
    	int cnt=1;
    	while(cnt<n){
    		int min=Math.min(Math.min(list.get(indexA)*2,list.get(indexB)*3), list.get(indexC)*5);
    		list.add(min);
    		cnt++;
    		if(min==list.get(indexA)*2)
    			indexA++;
    		if(min==list.get(indexB)*3)
    			indexB++;
    		if(min==list.get(indexC)*5)
    			indexC++;
    	}
		return list.get(n-1);
    }
    
    public int numTrees(int n) {
    	if(n==0)
    		return 0;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
        	for(int k=1;k<=i;k++){
        		dp[i]+=dp[k-1]*dp[i-k];
        	}
        }
        return dp[n];
    }
    
    public List<TreeNode> generateTrees(int n) {
    	List<TreeNode> list=new ArrayList<TreeNode>();
    	if(n==0){
    		list.add(null);
    		return list;
    	}
		return generateTreesHelper(1, n);
    }
    
    public List<TreeNode> generateTreesHelper(int low,int high){
    	List<TreeNode> list=new ArrayList<TreeNode>();
    	if(low>high){
    		list.add(null);
    		return list;
    	}
    	if(low == high){
    		list.add(new TreeNode(low));
    		return list;
    	}
    	List<TreeNode> left,right;
    	for(int k=low;k<=high;k++){
    		left=generateTreesHelper(low, k-1);
    		right=generateTreesHelper(k+1, high);
    		for (TreeNode lnode : left) {
				for (TreeNode rnode : right) {
					TreeNode r=new TreeNode(k);
					r.left=lnode;
					r.right=rnode;
					list.add(r);
				}
			}
    	}
		return list;
    }
    
    public int uniquePathsWithObstaclesII(int[][] obstacleGrid) {
    	if(obstacleGrid==null)
    		return 0;
    	int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
    	for(int j=0;j<obstacleGrid[0].length;j++){
    		if(obstacleGrid[0][j]==1)
    			break;
    		dp[0][j]=1;
    	}
    	
    	for(int i=0;i<obstacleGrid.length;i++){
    		if(obstacleGrid[i][0]==1)
    			break;
    		dp[i][0]=1;
    	}

    	for(int i=1;i<obstacleGrid.length;i++){
    		for(int j=1;j<obstacleGrid[0].length;j++){
    			if(obstacleGrid[i][j]!=1)
    				dp[i][j]=dp[i][j-1]+dp[i-1][j];
    		}
    	}
    		
		return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
    
    /***
     * 超时
     * */
    public int findSubstringInWraproundString(String p) {
		Set<String> set=new TreeSet<String>();
		boolean[][] flag=new boolean[p.length()][p.length()];
		for(int i=0;i<p.length();i++){
			flag[i][i]=true;
			set.add(p.substring(i, i+1));
		}
//		System.out.println(set.size());
		for(int len=1;len<p.length();len++){
			for(int i=0;i<p.length()-len;i++){
				int j=i+len;
				if(flag[i][j-1]==true && (p.charAt(j)-p.charAt(j-1)==1 || p.charAt(j)-p.charAt(j-1)==-25)){
					flag[i][j]=true;
//					System.out.println(p.substring(i, j+1));
					set.add(p.substring(i, j+1));
				}else{
					i=j+len;
				}
			}
		}
    	return set.size();
    }
    
    public int findSubstringInWraproundString_2(String p){
    	if(p==null || p.length()==0)
    		return 0;
    	int[] cntP=new int[p.length()];
    	cntP[0]=1;
    	int[] cntMax=new int[26];
    	cntMax[p.charAt(0)-'a']=1;
    	for(int i=1;i<p.length();i++){
    		if(p.charAt(i)-p.charAt(i-1)==1 || p.charAt(i-1)-p.charAt(i)==25)
    			cntP[i]=cntP[i-1]+1;
    		else
    			cntP[i]=1;
    		cntMax[p.charAt(i)-'a']=Math.max(cntMax[p.charAt(i)-'a'],cntP[i]);
    	}
    	int cntSum=0;
    	for(int i=0;i<26;i++){
    		cntSum+=cntMax[i];
    	}
		return cntSum;
    }
    
    /***
     * 超时
     * */
    public boolean wordBreak(String s, List<String> wordDict) {
    	List<String> wordDictUse=new ArrayList<String>();
    	for (String string : wordDict) {
			if(s.indexOf(string)!=-1)
				wordDictUse.add(string);
		}
		return wordbreakHelper(s,wordDictUse);
    }
    
    public boolean wordbreakHelper(String s,List<String> wordDict){
    	if(s=="" || s.length()==0)
    		return true;
    	
    	for(int i=0;i<wordDict.size();i++){
    		int wordIndexStart=s.indexOf(wordDict.get(i));
    		if(wordIndexStart==-1)
    			continue;
    		int wordIndexEnd=wordIndexStart+wordDict.get(i).length();
    		String leftStr=s.substring(0, wordIndexStart);
    		String rightStr=s.substring(wordIndexEnd, s.length());
//    		System.out.println(leftStr+" "+rightStr);
    		if(wordbreakHelper(leftStr,wordDict) && wordbreakHelper(rightStr, wordDict))
    			return true;
    	}
    	return false;
    }
    
    public boolean wordBreak_2(String s, List<String> wordDict){
    	boolean[] dp=new boolean[s.length()+1];
    	dp[0]=true;
    	for(int i=1;i<=s.length();i++){
    		for(int j=0;j<i;j++){
    			if(dp[j] && wordDict.contains(s.subSequence(j, i))){
    				dp[i]=true;
    				break;
    			}
    		}
    	}
		return dp[s.length()];
    }
    
    public int maximalSquare(char[][] matrixCh) {
    	if(matrixCh==null || matrixCh.length==0)
    		return 0;
    	int[][] matrix=new int[matrixCh.length][matrixCh[0].length];
    	for(int i=0;i<matrixCh.length;i++){
    		for(int j=0;j<matrixCh[0].length;j++)
				matrix[i][j]=matrixCh[i][j]=='1'?1:0;
    	}
    	
    	int[][] rowSum=new int[matrix.length+1][matrix[0].length+1];
    	int[][] colSum=new int[matrix.length+1][matrix[0].length+1];
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[0].length;j++){
    			rowSum[i+1][j+1]=rowSum[i+1][j]+matrix[i][j];
    		}
    	}
    	for(int j=0;j<matrix[0].length;j++){
    		for(int i=0;i<matrix.length;i++){
    			colSum[i+1][j+1]=colSum[i][j+1]+matrix[i][j];
    		}
    	}
//    	util.printIntArr2(rowSum);
//    	System.out.println();
//    	util.printIntArr2(colSum);
    	
    	int maxLen=Math.min(matrix.length, matrix[0].length);
    	int[][] sumMatrix=new int[matrix.length+1][matrix[0].length+1];
    	int max=0;
    	for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				sumMatrix[i+1][j+1]=matrix[i][j];
				max=Math.max(max, matrix[i][j]);
			}
		}
//    	System.out.println();
//    	util.printIntArr2(sumMatrix[1]);
//    	System.out.println(max);
    	for(int len=2;len<=maxLen;len++){
    		for(int i=0;i<=matrix.length-len;i++){
    			for(int j=0;j<=matrix[0].length-len;j++){
    				if(sumMatrix[i+1][j+1]==(len-1)*(len-1) 
    						&& rowSum[i+len][j+len]-rowSum[i+len][j]==len 
    						&& colSum[i+len][j+len]-colSum[i][j+len]==len){
    					sumMatrix[i+1][j+1]=len*len;
    					max=Math.max(max,sumMatrix[i+1][j+1]);
    				}
    			}
    		}
//    		util.printIntArr2(sumMatrix[len]);
//    		System.out.println();
    	}
		return max;
    }
    
    public int maxProduct(int[] nums) {
    	if(nums==null || nums.length==0)
    		return 0;
    	int[] f=new int[nums.length];
    	int[] g=new int[nums.length];
    	f[0]=nums[0];
    	g[0]=nums[0];
    	int res=nums[0];
    	for(int i=1;i<nums.length;i++){
    		f[i]=Math.max(Math.max(f[i-1]*nums[i], g[i-1]*nums[i]), nums[i]);
    		g[i]=Math.min(Math.min(f[i-1]*nums[i], g[i-1]*nums[i]), nums[i]);
    		res=Math.max(res, f[i]);
    	}
		return res;
    }
    
    public int coinChange(int[] coins, int amount) {
    	if(coins==null || coins.length==0)
    		return -1;
    	int[] dp=new int[amount+1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0]=0;
    	for(int j=0;j<coins.length;j++)
	    	for(int i=1;i<=amount;i++){
	    		if(i>=coins[j] && dp[i-coins[j]]!=Integer.MAX_VALUE)
	    			dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
	    	}
		return dp[amount]==Integer.MAX_VALUE || dp[amount]<0?-1:dp[amount];
    }
    
    public int numDecodings(String s) {
    	if(s==null || s.length()==0 || s.indexOf("00")!=-1 || s.indexOf("0")==0)
    		return 0;
    	int[] dp=new int[s.length()];
    	dp[0]=1;
    	if(s.length()>=2){
    		if(s.charAt(1)!='0' && (s.charAt(0)-'0')*10+s.charAt(1)-'0'>=10 && (s.charAt(0)-'0')*10+s.charAt(1)-'0'<=26)
    			dp[1]=2;
    		else if(s.charAt(1)=='0' && (s.charAt(0)-'0')*10+s.charAt(1)-'0'>=10 && (s.charAt(0)-'0')*10+s.charAt(1)-'0'<=26)
    			dp[1]=1;
    		else if(s.charAt(1)=='0' && (s.charAt(0)-'0')*10+s.charAt(1)-'0'>26)
    			return 0;
    		else
    			dp[1]=dp[0];
    	}
//    	System.out.println(dp[0] +"  "+dp[1]);
    	for(int i=2;i<s.length();i++){
    		if(s.charAt(i)!='0' && (s.charAt(i-1)-'0')*10+s.charAt(i)-'0'>=10 && (s.charAt(i-1)-'0')*10+s.charAt(i)-'0'<=26)
    			dp[i]=dp[i-1]+dp[i-2];
    		else if(s.charAt(i)=='0' && (s.charAt(i-1)-'0')*10+s.charAt(i)-'0'>=10 && (s.charAt(i-1)-'0')*10+s.charAt(i)-'0'<=26 )
    			dp[i]=dp[i-2];
    		else if(s.charAt(i)=='0' && (s.charAt(i-1)-'0')*10+s.charAt(i)-'0'>26 )
    			return 0;
    		else
    			dp[i]=dp[i-1];
    	}
		return dp[s.length()-1];
    }
    
    /***
     * 未解决
     * */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    	if(maxChoosableInteger>=desiredTotal)
    		return true;
    	if((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal)
    		return false;
    	List<Integer> nums=new ArrayList<Integer>();
    	for(int i=1;i<=maxChoosableInteger;i++)
    		nums.add(i);
    	System.out.println(nums.size()+"  "+nums.get(0)+"   "+nums.get(nums.size()-1));
    	
		return false;
        
    }

}






/*public int findMaxForm(String[] strs, int m, int n) {
	if(strs.length==0)
		return 0;
	int[][] dp=new int[m+1][n+1];
	int[] cnt=new int[2];
	for(String str:strs){
		cnt=numsOne(str);
		for(int i=m;i>=cnt[0];i--){
			for(int j=n;j>=cnt[1];j--){
				dp[i][j]=Math.max(dp[i][j], dp[i-cnt[0]][j-cnt[1]]+1);
			}
		}
	}
	return dp[m][n];
}

public int[] numsOne(String str){
	int[] cnt=new int[2];
	for(int i=0;i<str.length();i++){
		if(str.charAt(i)=='1')
			cnt[1]++;
		else
			cnt[0]++;
	}
	return cnt;
}*/