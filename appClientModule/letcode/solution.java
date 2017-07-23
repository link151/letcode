package letcode;

import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import letcode.TreeNode;

public class solution {

	private static final int Comparator = 0;
	private static final int Pair = 0;

	public static void main(String[] args) {
		HammingDistance hmd=new HammingDistance();
		hmd.hamingDistance(1, 8);
		System.out.println("hamingDistance2:"+hmd.hamingDistance2(1, 8));
	}
	
    public int findComplement(int num) {
    	int _num=0,j=0;
    	while(_num<num){
    		_num+=Math.pow(2, j);
    		j++;
    	}
    	return _num-num;
    }
    public int findComplement2(int num) {
    	System.out.println("highestOneBit:"+Integer.highestOneBit(num));
    	System.out.println("highestOneBit:"+Integer.toBinaryString(Integer.highestOneBit(num)));
    	System.out.println("highestOneBit-1:"+(Integer.highestOneBit(num)-1));
    	System.out.println("highestOneBit-1:"+Integer.toBinaryString((Integer.highestOneBit(num)-1)));
    	return 0;
    }

    public String[] findWords(String[] words) {
    	List<String> res=new LinkedList<String>();
        String[] strs={"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<strs.length;i++){
        	for(char c:strs[i].toCharArray()){
        		map.put(c, i);
        	}
        }
        for(String word:words){
        	if(word.equals(""))
        		continue;
        	int index=map.get(word.toUpperCase().charAt(0));
        	for(char c:word.toUpperCase().toCharArray()){
        		if(map.get(c)!=index){
        			index=-1;
        			break;
        		}
        	}
        	if(index!=-1){
        		res.add(word);
        	}
        }
        return res.toArray(new String[0]);
    }
    
    public List<String> fizzBuzz(int n) {
    	List<String> res=new ArrayList<String>();
        for(int i=1;i<=n;i++){
        	if(i%15==0){
        		res.add("FizzBuzz");
        		continue;
        	}
        	if(i%3==0){
        		res.add("Fizz");
        		continue;
        	}
        	if(i%5==0){
        		res.add("Buzz");
        		continue;
        	}
        	res.add(Integer.toString(i));
        }
        return res;
    }
    
    public String reverseString(String s) {
        String res=new String();
        StringBuffer strbuff=new StringBuffer();
        int len=s.length();
        for(int i=len-1;i>=0;i--){
        	strbuff.append(s.charAt(i));
        }
        res=strbuff.toString();
        return res;
    }
    
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
    	int[] res=new int[findNums.length];
    	
    	for(int i=0;i<findNums.length;i++){
    		res[i]=-1;
    		boolean flag_equal=false;
    		for(int j=0;j<nums.length;j++){
    			if(findNums[i]==nums[j]){
    				flag_equal=true;
    			}
    			if(flag_equal && nums[j]>findNums[i]){
    				res[i]=nums[j];
    				break;
    			}
    		}
    	}
        return res;
    }
    
    public int islandPerimeter(int[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length-1;j++){
        		if((grid[i][j]^grid[i][j+1])==1){
        			res+=1;
        		}
        	}
        }
        for(int i=0;i<grid.length-1;i++){
        	for(int j=0;j<grid[0].length;j++){
        		if((grid[i][j]^grid[i+1][j])==1){
        			res+=1;
        		}
        	}
        }
        for(int i=0,j=0;j<grid[0].length;j++){
        	if(grid[i][j]==1)
        		res+=1;
        }
        for(int i=grid.length-1,j=0;j<grid[0].length;j++){
        	if(grid[i][j]==1)
        		res+=1;
        }
        for(int j=0,i=0;i<grid.length;i++){
        	if(grid[i][j]==1)
        		res+=1;
        }
        for(int j=grid[0].length-1,i=0;i<grid.length;i++){
        	if(grid[i][j]==1)
        		res+=1;
        }
        return res;
    }
    
    public boolean canWinNim(int n) {
        return n%4 !=0;
    }
    
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==0){
        		max=max>cnt?max:cnt;
        		cnt=0;
//        		System.out.println("max:"+max);
        	}else{
        		cnt++;
        	}
        }
        return max>cnt?max:cnt;
    }
    
    public boolean detectCapitalUse(String word) {
        int len=word.length();
        char[] word_arr=word.toCharArray();
        if(word_arr.length==1)
        	return true;
        if(word_arr[0]>='A' && word_arr[0]<='Z' && word_arr[1]>='A' && word_arr[1]<='Z'){
        	for(int i=2;i<len;i++){
    			if(word_arr[i]>='a' && word_arr[i]<='z'){
    				return false;
    			}
    		}
        	return true;
        }
        if(word_arr[0]>='A' && word_arr[0]<='Z' && word_arr[1]>='a' && word_arr[1]<='z'){
        	for(int i=2;i<len;i++){
    			if(word_arr[i]>='A' && word_arr[i]<='Z'){
    				return false;
    			}
    		}
        	return true;
        }
        if(word_arr[0]>='a' && word_arr[0]<='z'){
        	for(int i=1;i<len;i++){
    			if(word_arr[i]>='A' && word_arr[i]<='Z'){
    				return false;
    			}
    		}
        	return true;
        }
		return false;
    }
    
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
        	res=res^nums[i];
        }
        return res;
    }
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
        	int index=Math.abs(nums[i])-1;
        	if(nums[index]>0)
        		nums[index]=-nums[index];
        }
        for(int i=0;i<nums.length;i++){
        	if(nums[i]>0){
        		res.add(i+1);
        	}
        }
        return res;
    }
    
    public int maxDepth(TreeNode root) {
        int depth=0;
        if(root==null)
        	return depth;
        int left_max_depth=maxDepth(root.left);
        int right_max_depth=maxDepth(root.right);
        depth=left_max_depth>=right_max_depth?left_max_depth+1:right_max_depth+1;
        return depth;
    }
    
    public char findTheDifference(String s, String t) {
        char ch = 0;
        Map<Character, Integer> t_map=new HashMap<Character, Integer>();
        char[] t_arr=t.toCharArray();
        for(int i=0;i<t_arr.length;i++){
        	if(!t_map.containsKey(t_arr[i])){
        		Integer tmp=1;
        		t_map.put(t_arr[i], tmp);
        	}else{
        		Integer tmp=t_map.get(t_arr[i])+1;
        		t_map.put(t_arr[i], tmp);
        	}
        }
        char[] s_arr=s.toCharArray();
        for(int i=0;i<s_arr.length;i++){
        	if(t_map.containsKey(s_arr[i])){
        		Integer tmp2=t_map.get(s_arr[i])-1;
        		t_map.put(s_arr[i], tmp2);
        	}
        }
        for(int i=0;i<t_arr.length;i++){
        	if(t_map.get(t_arr[i])!=0)
        		ch=t_arr[i];
        }
        return ch;
    }
    
    public int getSum(int a, int b) {
    	if(b==0)
    		return a;
        int sum=a^b;
        int carry=(a&b)<<1;
        return getSum(sum,carry);
    }
    
    public int addDigits(int num) {
        if(num==0)
        	return num;
        else if(num%9==0)
        	return 9;
        else
        	return num%9;
    }
    
    public boolean isHappy(int n) {
    	Set<Integer> inLoop = new HashSet<Integer>();
    	int sum=0;
    	while(inLoop.add(n)){
			sum=0;
			while(n!=0){
				sum+=Math.pow(n%10.0, 2);
				n/=10;
			}
    		if(sum==1)
    			return true;
    		n=sum;
    	}
    	return false;
    }
    
    public int[] constructRectangle(int area) {
    	int[] res = new int[2];
    	int L=(int) Math.sqrt(area);
    	for(int i=L;i<=area;i++){
    		int W=area/i;
    		if(area==i*W){
    			res[0]=i>W?i:W;
    			res[1]=W<=i?W:i;
    			break;
    		}
    	}
    	return res;
    }
    
    public String negative(int n){
    	return Integer.toBinaryString(n);
    }
    
    public void equalString(){
    	String a="abc";
    	String b="abc";
    	String c=new String("abc");
    	System.out.println(a==b);
    	System.out.println(a==c);
    	System.out.println(b==c);
    	System.out.println(a.equals(b));
    	System.out.println(a.equals(c));
    	System.out.println(b.equals(c));
    	a=a+"d";
    	System.out.println("a:"+a+"\tb:"+b);
    	
    }
    
    public String[] findRelativeRanks(int[] nums) {
    	class Pair{
    		int score;
    		int index;
    	}
    	Pair[] pair=new Pair[nums.length];
    	String[] res=new String[nums.length];
    	for(int i=0;i<nums.length;i++){
    		pair[i]=new Pair();
    		pair[i].score=nums[i];
    		pair[i].index=i;
    	}
    	Arrays.sort(pair,new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.score-o1.score;
			}
		});
    	
    	for(int i=0;i<nums.length;i++){
    		if(i==0){
    			res[pair[0].index]="Gold Medal";
    		}else if(i==1){
    			res[pair[1].index]="Silver Medal";
    		}else if(i==2){
    			res[pair[2].index]="Bronze Medal";
    		}else
    			res[pair[i].index]=Integer.toString(i+1);
    	}
    	return res;
    }
    public String[] findRelativeRanksList(int[] nums) {
    	class Pair{
    		int score;
    		int index;
    	}
    	List<Pair> list=new ArrayList<Pair>();
    	String[] res=new String[nums.length];
    	for(int i=0;i<nums.length;i++){
    		Pair tmp=new Pair();
    		tmp.score=nums[i];
    		tmp.index=i;
    		list.add(tmp);
    	}
    	Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.score-o1.score;
			}
		});
    	for(int i=0;i<list.size();i++){
			if(i==0){
				res[list.get(0).index]="Gold Medal";
			}else if(i==1){
				res[list.get(1).index]="Silver Medal";
			}else if(i==2){
				res[list.get(2).index]="Bronze Medal";
			}else
				res[list.get(i).index]=Integer.toString(i+1);
		}
    	return res;
    }
    public String[] findRelativeRanksMap(int[] nums) {
    	class Pair{
    		int score;
    		int index;
    	}
    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    	String[] res=new String[nums.length];
    	for(int i=0;i<nums.length;i++){
    		map.put(nums[i],i );
    	}
    	return res;
    }
        
    /**
     * 二叉排序树BST
     * */
    int min=Integer.MAX_VALUE;
    Integer prev=null;
    public int getMinimumDifference(TreeNode root) {
    	if(root==null)
    		return min;
    	getMinimumDifference(root.left);
    	if(prev!=null){
    		min=Math.min(min, Math.abs(root.val-prev));
    	}
    	prev=root.val;
    	getMinimumDifference(root.right);
		return min;
    }
    
    /**
     *二叉树BT 
     * */
    TreeSet<Integer> set=new TreeSet<Integer>();
    public int getMinimumDifference2(TreeNode root) {
    	if(root==null)
    		return min;
		if(!set.isEmpty()){
			if(set.floor(root.val)!=null){
				min=Math.min(min, Math.abs(root.val-set.floor(root.val)));
			}
			if(set.ceiling(root.val)!=null){
				min=Math.min(min, Math.abs(root.val-set.ceiling(root.val)));
			}
		}
		set.add(root.val);
		getMinimumDifference2(root.left);
		getMinimumDifference2(root.right);
    	return min;
    }
    
    /**
     * findContentChildren
     * */
    public int findContentChildren(int[] g, int[] s) {
        int cnt=0;
        TreeMap<Integer, Integer> tree=new TreeMap<Integer, Integer>();
        for(int i=0;i<s.length;i++){
        	Integer num=tree.get(s[i]);
        	num=num==null?1:num.intValue()+1;
        	tree.put(s[i], num);
        }

    	for(int i=0;i<g.length;i++){
    		Integer greater=tree.ceilingKey(g[i]);
    		if(greater!=null){
    			Integer num=tree.get(greater);
    			if(num>0){
    				cnt++;
    				if(num==1){
    					tree.remove(greater);
    				}else{
    					tree.put(greater, num-1);
    					
    				}
    			}
    		}
    	}
    	return cnt;
    }
    
    public int findContentChildren2(int[] g, int[] s) {
    	int cnt=0;
    	Arrays.sort(g);
    	Arrays.sort(s);
    	for(int i=0,j=0;i<g.length && j<s.length;j++){
    		if(g[i]<=s[j]){
    			i++;
    			cnt++;
    		}
    	}
    	return cnt;
    }
    
    public boolean canConstruct(String ransomNote, String magazine) {
        boolean flag=true;
        char[] ran_arr=ransomNote.toCharArray();
        char[] mag_arr=magazine.toCharArray();
        Map<Character, Integer> mag_map=new HashMap<Character, Integer>();
        for(int i=0;i<mag_arr.length;i++){
        	Integer num=mag_map.get(mag_arr[i]);
        	num= num==null?0:num;
        	mag_map.put(mag_arr[i], num+1);
        }
        
        for(int i=0;i<ran_arr.length;i++){
        	Integer num=mag_map.get(ran_arr[i]);
        	if(num==null)
        		return false;
        	if(num==1)
        		mag_map.remove(ran_arr[i]);
        	else
        		mag_map.put(ran_arr[i], num-1);
        }
        
        return flag;
    }
    
    private int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
        	return 0;
        if(root.left!=null && (root.left.left==null && root.left.right==null))
        	sum+=root.left.val;
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }
    
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1_set=new TreeSet<Integer>();
        Set<Integer> nums2_set=new TreeSet<Integer>();
        Set<Integer> ans_set=new TreeSet<Integer>();

        for(int i=0;i<nums1.length;i++){
        	nums1_set.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
        	nums2_set.add(nums2[i]);
        }
        
        Iterator<Integer> it=nums2_set.iterator();
        while(it.hasNext()){
        	int tmp=it.next();
        	if(!nums1_set.add(tmp))
        		ans_set.add(tmp);
        }
        Iterator<Integer> it2=ans_set.iterator();
        int[] ans=new int[ans_set.size()];
        int i=0;
        while(it2.hasNext()){
        	ans[i++]=it2.next();
        }
		return ans;
    }
    
    public int[] intersection2(int[] nums1, int[] nums2) {
    	Set<Integer> ans_set=new TreeSet<Integer>();
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	int i=0,j=0;
    	while(i<nums1.length && j<nums2.length){
    		if(nums1[i]<nums2[j])
    			i++;
    		else if(nums1[i]>nums2[j])
    			j++;
    		else if(nums1[i]==nums2[j]){
    			ans_set.add(nums1[i]);
    			i++;
    			j++;
    		}
    	}
		int[] ans=new int[ans_set.size()];
		Iterator<Integer> it=ans_set.iterator();
        int k=0;
        while(it.hasNext()){
        	ans[k++]=it.next();
        }
    	return ans;
    }
    
    public int maxProfit(int[] prices) {
        int ans=0;
        for(int i=0;i<prices.length-1;i++){
        	if(prices[i]<prices[i+1])
        		ans+=prices[i+1]-prices[i];
        }
        return ans;
    }
    
    public int firstUniqChar(String s) {
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++)
        	if(s.indexOf(arr[i])==s.lastIndexOf(arr[i]))
        		return i;
		return -1;
    }
    
    public int firstUniqChar2(String s) {
        char[] arr=s.toCharArray();
        int[] cnt=new int[26];
        for(int i=0;i<arr.length;i++)
        	cnt[arr[i]-'a']++;
        for(int i=0;i<arr.length;i++)
        	if(cnt[arr[i]-'a']==1)
        		return i;
		return -1;
    }
    
    public int titleToNumber(String s) {
        int num=0;
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
        	num=num*26+(arr[i]-'A'+1);
        }
        return num;
    }
    
    public void deleteNode(ListNode node) {
     
    	if(node!=null && node.next!=null){
    		node.val=node.next.val;
    		node.next=node.next.next;
    	}
    }
    
    public String convertToBase7(int num) {
        StringBuffer sb=new StringBuffer();
        int tmp=num;
        String op = "";
        if(num<0){
        	op="-";
        	tmp=Math.abs(tmp);
        }
        do{
        	sb.append(tmp%7);
        	tmp/=7;
        }while(tmp!=0);
        return op+sb.reverse().toString();
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p==null && q==null)
    		return true;
    	if(p!=null && q!=null && p.val==q.val){
    	    return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    	}else{
    	    return false;
    	}
    }
    
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> nums_map=new HashMap<Integer, Integer>();
        int len=nums.length;
        int len_2=len/2;
        for(int i=0;i<nums.length;i++){
        	Integer cnt=nums_map.get(nums[i]);
        	cnt=cnt==null?1:cnt+1;
        	if(cnt>=len_2)
        		return nums[i];
        	nums_map.put(nums[i], cnt);
        }
    	return 0;
    }
    
    public boolean isAnagram(String s, String t) {
        char[] s_arr=s.toCharArray();
        char[] t_arr=t.toCharArray();
        Arrays.sort(s_arr);
        Arrays.sort(t_arr);
        s=new String(s_arr);
        t=new String(t_arr);
    	return s.equals(t);
    }
    
    public int longestPalindrome(String s) {
        char[] arr=s.toCharArray();
        int[] cnt=new int [60];
        int num=0;
        for(int i=0;i<arr.length;i++){
        	cnt[arr[i]-'A']++;
        	if(cnt[arr[i]-'A']==2){
        		num+=2;
        		cnt[arr[i]-'A']=0;
        	}
        }
        if(num<s.length())
        	num++;
    	return num;
    }
    
    /***
     * readBinaryWatch
     * */
    public List<String> readBinaryWatch(int num) {
        List<String> res=new ArrayList<String>();
        int[] nums1={8,4,2,1};
        int[] nums2={32,16,8,4,2,1};
        for(int i=0;i<=num;i++){
        	List<Integer> list1=generateDigit(nums1,i);
        	List<Integer> list2=generateDigit(nums2,num-i);
        	for(Integer h:list1){
        		if(h>12)
        			continue;
        		for(Integer m:list2){
        			if(m>60)
        				continue;
        			res.add(h+":"+(m<10?"0"+m:m));
        		}
        	}
        }
        return res;
    }
    public List<Integer> generateDigit(int[] nums,int count){
    	List<Integer> res=new ArrayList<Integer>();
    	generateDigitHelper(nums,count,0,0,res);
    	return res;
    }
    
    public void generateDigitHelper(int nums[],int count,int pos,int sum,List<Integer> res){
    	if(count==0){
    		res.add(sum);
    		return;
    	}
    	for(int i=pos;i<nums.length;i++){
    		generateDigitHelper(nums, count-1, i+1, sum+nums[i], res);
    	}
    }
    /***
     * readBinaryWatch 结束
     * */
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	if(!set.add(nums[i]))
        		return true;
        }
    	return false;
    }
    
    public String reverseStr(String s, int k) {
    	StringBuffer sb=new StringBuffer();
    	int i=0;
    	while(i+2*k<s.length()){
    		StringBuffer tmp=new StringBuffer(s.substring(i,i+k)).reverse();
    		sb.append(tmp.toString());
    		sb.append(s.substring(i+k, i+2*k));
    		i=i+2*k;
    	}
    	if(i+k>=s.length()){
    		StringBuffer tmp=new StringBuffer(s.substring(i,s.length())).reverse();
    		sb.append(tmp.toString());
    		i=i+k;
    	}else{
    		StringBuffer tmp=new StringBuffer(s.substring(i,i+k)).reverse();
    		sb.append(tmp.toString());
    		i=i+k;
    		sb.append(s.substring(i, s.length()));
    	}
    	return sb.toString();
    }
    
    /***
     * 迭代
     * */
    public ListNode reverseList(ListNode head) {
        ListNode newHead=null;
        while(head!=null){
        	ListNode next=head.next;
        	head.next=newHead;
        	newHead=head;
        	head=next;
        }
    	return newHead;
    }
    
    /***
     * 递归
     * */
    public ListNode reverseList2(ListNode head) {
    	return reverseListHelper(head,null);
    }
    
    public ListNode reverseListHelper(ListNode head,ListNode newHead){
    	if(head==null)
    		return newHead;
    	ListNode next=head.next;
    	head.next=newHead;
    	return reverseListHelper(next,head);
    }
    
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res=new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
        	if(nums1[i]<nums2[j])
        		i++;
        	else if(nums1[i]==nums2[j]){
        		res.add(nums1[i]);
        		i++;
        		j++;
        	}
        	else
        		j++;
        }
        int[] ans=new int[res.size()];
        for(int index=0;index<res.size();index++){
        	ans[index]=res.get(index);
        }
        return ans;
    }
    
    public int romanToInt(String s) {
    	int num=0;
    	char[] arr=s.toCharArray();
    	HashMap<Character, Integer> map=new HashMap<Character, Integer>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	for(int i=arr.length-1;i>=0;){
    		int tmp=map.get(arr[i]);
    		num+=tmp;
    		i--;
    		while(i>=0 && map.get(arr[i])<tmp){
    			num-=map.get(arr[i]);
    			i--;
    		}
    	}
    	return num;
    }
    
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
        	return root;
        TreeNode tmp=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(tmp);
    	return root;
    }
    
    public TreeNode invertTree2(TreeNode root) {
    	if(root==null)
    		return root;
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode node=stack.pop();
    		TreeNode left=node.left;
    		node.left=node.right;
    		node.right=left;
    		if(node.left!=null){
    			stack.push(node.left);
    		}
    		if(node.right!=null){
    			stack.push(node.right);
    		}
    	}
    	return root;
    }
    
    public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) return;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]!=0)
        		continue;
        	for(int j=i+1;j<nums.length;j++){
        		if(nums[j]==0)
        			continue;
        		int tmp=nums[i];
        		nums[i]=nums[j];
        		nums[j]=tmp;
        		break;
        	}
        }
    }
    public void moveZeroes2(int[] nums) {
    	int j=0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]!=0){
    			nums[j++]=nums[i];
    		}
    	}
    	while(j<nums.length)
    		nums[j]=0;
    }
    
    public int[] twoSum(int[] numbers, int target) {
        int[] res=new int[2];
        Map<Integer, List<Integer>> map=new HashMap<Integer, List<Integer>>();
        for(int i=0;i<numbers.length;i++){
        	List<Integer> num=map.get(numbers[i]);
        	if(num==null){
        		num=new ArrayList<Integer>();
        	}
        	num.add(i);
    		map.put(numbers[i], num);
        }
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()){
        	int tmp=target-entry.getKey();
        	List<Integer> num=map.get(tmp);
        	if(tmp!=entry.getKey() && num!=null){
    			res[0]=entry.getValue().get(0)>num.get(0)?num.get(0)+1:entry.getValue().get(0)+1;
    			res[1]=entry.getValue().get(0)<=num.get(0)?num.get(0)+1:entry.getValue().get(0)+1;
    			return res;
        	}else if(num!=null && num.size()>=2){
        		res[0]=num.get(0)+1;
        		res[1]=num.get(1)+1;
        		return res;
        	}
        }
        return res;
    }
    
    public int minMoves(int[] nums){
    	int[] cnt=new int[nums.length];
    	int res=0;
    	if(nums==null || nums.length==1)
        	return res;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
        	cnt[i]=cnt[i-1]+nums[i]-nums[i-1];
        	res+=cnt[i];
        }
    	return res;
    }
    public int minMoves2(int[] nums){
    	int res=0;
    	if(nums==null || nums.length==1)
    		return res;
    	Arrays.sort(nums);
    	for(int i=1;i<nums.length;i++){
    		res=res+nums[i]-nums[0];
    	}
    	return res;
    }
}





/*public int[] testMapIntegerList(int[] findNums, int[] nums) {
	Map<Integer, List<Integer>> nums_map=new HashMap<Integer, List<Integer>>();
	int[] res=new int[findNums.length];
	for(int i=0;i<nums.length;i++){
		List<Integer> tmp_list=new ArrayList<Integer>();
		if(!nums_map.containsKey(nums[i])){
			tmp_list.add(i);
			nums_map.put(nums[i], tmp_list);
		}else{
			tmp_list=nums_map.get(nums[i]);
			tmp_list.add(i);
			nums_map.put(nums[i], tmp_list);
		}
	}
	if(findNums.length>0){
		res[findNums.length-1]=-1;
	}
	for(int i=0;i<findNums.length-1;i++){
		List<Integer> tmp_list=nums_map.get(findNums[i+1]);
		res[i]=-1;
//		System.out.println("tmp_list:"+tmp_list.size()+" "+tmp_list.toString());
		for(int j=0;j<tmp_list.size();j++){
//			System.out.println("get(j):"+tmp_list.get(j)+" "+i);
			if(tmp_list.get(j)>i){
				res[i]=tmp_list.get(j);
				break;
			}
			continue;
		}
	}
	for(int i=0;i<res.length;i++)
		System.out.println(res[i]);
    return res;
}*/