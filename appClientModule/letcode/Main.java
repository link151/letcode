package letcode;

import letcode.TreeNode;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		solution sol=new solution();
		System.out.println("5:"+sol.findComplement(5));
		System.out.println("1:"+sol.findComplement(1));
		System.out.println("5:"+sol.findComplement2(5));
		String[] words={"Hello", "Alaska", "Dad", "Peace"};
		System.out.println("str:"+sol.findWords(words).toString());
		System.out.println("fizzBuzz:"+sol.fizzBuzz(15));
		System.out.println("reverseString:" + sol.reverseString("Hello"));
		int[] find_nums={4,1,2};
		int[] nums={1,3,4,2};
		int[][]grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println("nextGreaterElement:" + sol.nextGreaterElement(find_nums,nums));
		System.out.println("islandPerimeter:" + sol.islandPerimeter(grid));
		System.out.println("canWinNim:" + sol.canWinNim(5));
		int[] nums1={1,0,1,1,0,1};
		System.out.println("findMaxConsecutiveOnes:" + sol.findMaxConsecutiveOnes(nums1));
		System.out.println("detectCapitalUse:" + sol.detectCapitalUse("USA"));
		System.out.println("detectCapitalUse:" + sol.detectCapitalUse("FlaG"));
		System.out.println("detectCapitalUse:" + sol.detectCapitalUse("leetcode"));
		int[] nums2={1,2,3,4,3,2,1};
		System.out.println("singleNumber:" + sol.singleNumber(nums2));
		int[] nums3={4,3,2,7,8,2,3,1};
		System.out.println("findDisappearedNumbers:" + sol.findDisappearedNumbers(nums3));
		TreeNode root=new TreeNode(5);
		System.out.println("maxDepth:" + sol.maxDepth(root));
		String s="abcd",t="abcde";
		System.out.println("findTheDifference:" + sol.findTheDifference(s, t));
		s="a";
		t="aa";
		System.out.println("findTheDifference:" + sol.findTheDifference(s, t));
		System.out.println("getSum:" + sol.getSum(1,2));
		System.out.println("addDigits:" + sol.addDigits(38));
		System.out.println("isHappy:" + sol.isHappy(19));
		System.out.println("constructRectangle:" + sol.constructRectangle(5)[0]);
		System.out.println("negitive:" + sol.negative(7));
		System.out.println("negitive:" + sol.negative(-7));
		System.out.println("negitive:" + sol.negative(-6));
		System.out.println("negitive:" + sol.negative(6));
		System.out.println("equalString:");
		sol.equalString();
		int[] nums4={5,2,4,3,1};
		System.out.println("findRelativeRanks:" + sol.findRelativeRanks(nums4));
		TreeNode tn=new TreeNode(1);
		System.out.println("getMinimumDifference:" + sol.getMinimumDifference(tn));
		int[] g={1,2,2,2,3};
		int[] s1={1,2,2,2};
		System.out.println("findContentChildren:" + sol.findContentChildren(g,s1));
		System.out.println("findContentChildren2:" + sol.findContentChildren2(g,s1));
		System.out.println("canConstruct:" + sol.canConstruct("aa","aab"));
		int[] nums5={4,7,9,7,6,7};
		int[] nums6={5,0,0,6,1,6,2,2,4};
		
		System.out.println("intersection:" + sol.intersection(nums5,nums6));
		int[] nums7={4,2,5,3,6,7,2};
		System.out.println("maxProfit:" + sol.maxProfit(nums7));
		System.out.println("firstUniqChar:" + sol.firstUniqChar("leetcode"));
		System.out.println("titleToNumber:" + sol.titleToNumber("AB"));
		System.out.println("convertToBase7:" + sol.convertToBase7(101));
		int[] nums8={1,1,1,1,2,2,3};
		System.out.println("majorityElement:" + sol.majorityElement(nums8));
		System.out.println("isAnagram:" + sol.isAnagram("abc","bac"));
		System.out.println("longestPalindrome:" + sol.longestPalindrome("ccc"));
		System.out.println("readBinaryWatch:" + sol.readBinaryWatch(1).toString());
		int[] nums9={1,1,2,3,4};
		System.out.println("containsDuplicate:" + sol.containsDuplicate(nums9));
		System.out.println("reverseStr:" + sol.reverseStr("abcd",5));
		ListNode head=new ListNode(0);
		ListNode p=head;
		for(int i=1;i<5;i++){
			ListNode tmp=new ListNode(i);
			p.next=tmp;
			p=p.next;
		}
		System.out.println("reverseStr:" + sol.reverseList(head));
		int[] nums10={1,2,2,1};
		int[] nums11={2,2};
		System.out.println("intersect:" + sol.intersect(nums10,nums11));
		System.out.println("romanToInt:" + sol.romanToInt("MCMLIV"));
		int[] nums12={0, 1, 0, 3, 12};
		System.out.println("moveZeroes:");
		sol.moveZeroes(nums12);
		int[] nums13={2, 7, 11, 15};
		int[] res=sol.twoSum(nums13, 9);
		System.out.println("twoSum:"+res[0]+" "+res[1]);
		int[] nums14={1,2,3,4};
		System.out.println("minMoves:"+sol.minMoves(nums14));
		
		System.out.println("MySort=======");
		MySort mySort=new MySort();
		int[] nums15={5,2,4,3,1};
		System.out.println("insertSort:");
		mySort.straightInsertionSort(nums15);
		int[] nums16={5,2,4,3,1};
		System.out.println("shellSort:");
		mySort.shellSort(nums16);
		int[] nums17={5,3,6,2,1,9,4,8,7};
		System.out.println("heapSort:");
		mySort.heapSort(nums17);
		mySort.myPrint(nums17);
		int[] nums18={5,3,6,2,1,9,4,8,7};
		System.out.println("selectSort:");
		mySort.selectSort(nums18);
		int[] nums19={5,3,6,2,1,9,4,8,7};
		System.out.println("bulleSort:");
		mySort.bulleSort(nums19);
		int[] nums20={5,3,6,2,1,9,4,8,7};
		System.out.println("quickSort:");
		mySort.quickSort(nums20,0,8);
		mySort.myPrint(nums20);
		int[] nums21={5,3,6,2,1,9,4,8,7};
		int[] tmp=new int[nums21.length];
		System.out.println("merrageSort:");
		mySort.merrageSort(nums21, 0, nums21.length-1, tmp);
		mySort.myPrint(nums21);
		int[] nums22={5,3,6,2,1,9,4,8,7};
		System.out.println("binarySort:");
		mySort.binarySort(nums22);
		System.out.println();
		mySort.myPrint(nums22);
		
		int[] numsSearch={1,2,3,4,5,6,7,8,9};
		MySearch mySearch = new MySearch();
		System.out.print("linerSearch : ");
		mySearch.linerSearch(numsSearch, 7);
		System.out.print("bSearch : ");
		mySearch.bSearch(numsSearch, 7);
		System.out.println("btreeSearch : ");
		int[] numsB={5,3,6,2,1,9,4,8,7};
		mySearch.btreeSearch(numsB, 7);
	}
}

/*static boolean resolve(int[] A) {
    int len=A.length;
    long[] sum=new long[Integer.MAX_VALUE];
    sum[0]=A[0];
    for(int i=1;i<len;i++){
    	sum[i]=sum[i-1]+A[i];
    }
    boolean flag1=false;
    boolean flag3=false;
    for(int i=1;i<len-1;i++){
    	if(sum[i-1]==sum[len-1]-sum[i]){
    		flag1=false;
    		flag3=false;
    		for(int j=1;j<i-1;j++){
    			if(sum[j-1]==(sum[i-1]-sum[j])){
    				flag1=true;
    			}
    		}
    		for(int k=i+1;k<len-1;k++){
    			if((sum[k-1]-sum[i])==(sum[len-1]-sum[k])){
    				flag3=true;
    			}
    		}
    	}
    	if(flag1&&flag3){
    		return true;
    	}
    }
    return false;
}*/