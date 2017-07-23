package letcode;

public class MySort {
	/**
	 * 插入排序
	 * 直接插入排序
	 * */
	public int[] straightInsertionSort(int[] nums){
		myPrint(nums); 
		for(int i=1;i<nums.length;i++){
			if(nums[i]<nums[i-1]){
				int tmp=nums[i];
				System.out.println("nums["+i+"]"+nums[i]);
				int j=i-1;
				do{
					nums[j+1]=nums[j];
					j--;
				}while(j>=0 && nums[j]>tmp);
				nums[j+1]=tmp;
			}
		}
		myPrint(nums);
		return nums;
	}
	
	/**
	 * 插入排序
	 * 希尔排序
	 * */
	public int[] shellSort(int[] nums){
		myPrint(nums);
		int dt=nums.length/2;
		while(dt!=0){
			System.out.println("dt:"+dt);
			for(int i=dt;i<nums.length;i++){
				if(nums[i]<nums[i-dt]){
					int tmp=nums[i];
					int j=i-dt;
					do{
						nums[j+dt]=nums[j];
						j=j-dt;
					}while(j>=0 && nums[j]>tmp);
					nums[j+dt]=tmp;
				}
			}
			myPrint(nums);
			dt/=2;
		}
		return nums;
	}
	
	/**
	 * 选择式排序
	 * 堆排序
	 * */
	public void heapSort(int[] nums){
		int len=nums.length;
		for(int i=0;i<nums.length;i++){
			createMaxHeap(nums, len-1-i);
			swap(nums, 0,len-1-i);
//			myPrint(nums);
		}
	}
	public void createMaxHeap(int[] nums,int lastIndex){
		for(int i=(lastIndex-1)/2;i>=0;i--){
			int k=i;
			while(2*k+1<=lastIndex){
				int biggerIndex=2*k+1;
				if(biggerIndex<lastIndex && nums[biggerIndex]<nums[biggerIndex+1])
					biggerIndex++;
				if(nums[k]<nums[biggerIndex]){
					swap(nums, k, biggerIndex);
					k=biggerIndex;
				}else{
					break;
				}
			}
		}
	}
	
	/**
	 * 选择式排序
	 * 选择排序
	 * */
	public void selectSort(int[] nums){
		int maxKey=0;
		for(int i=nums.length-1;i>=0;i--){
			maxKey=i;
			for(int j=0;j<i;j++){
				if(nums[j]>nums[maxKey]){
					maxKey=j;
				}
			}
			int tmp=nums[i];
			nums[i]=nums[maxKey];
			nums[maxKey]=tmp;
		}
		myPrint(nums);
	}
	
	/**
	 * 交换式排序
	 * 冒泡排序
	 * */
	public void bulleSort(int[] nums){
		for(int i=0;i<nums.length-1;i++){
			for(int j=0;j<nums.length-1-i;j++){
				if(nums[j]>nums[j+1]){
					int tmp=nums[j+1];
					nums[j+1]=nums[j];
					nums[j]=tmp;
				}
			}
		}
		myPrint(nums);
	}
	/**
	 * 交换式排序
	 * 快速排序
	 * */
	public int partition(int[] nums,int low,int high){
		int key=nums[low];
		while(low<high){
			while(low<high && nums[high]>=key)
				high--;
			nums[low]=nums[high];
			while(low<high && nums[low]<=key)
				low++;
			nums[high]=nums[low];
		}
		nums[high]=key;
		return high;
	}
	public void quickSort(int[] nums,int low,int high){
		if(low>=high)
			return;
		int index=partition(nums,low,high);
		quickSort(nums, low, index-1);
		quickSort(nums, index+1, high);
	}
	
	/**
	 * 插入排序
	 * 归并排序
	 * */
	public void merageArr(int[] nums,int first,int middle,int last,int[] tmp){
		int i=first,j=middle+1;
		int m=middle,n=last;
		int k=0;
		while(i<=m && j<=n){
			if(nums[i]<nums[j])
				tmp[k++]=nums[i++];
			else
				tmp[k++]=nums[j++];
		}
		while(i<=m){
			tmp[k++]=nums[i++];
		}
		while(j<=n){
			tmp[k++]=nums[j++];
		}
		for(i=0;i<k;i++)
			nums[first+i]=tmp[i];
	}
	public void merrageSort(int[] nums,int first,int last,int[] tmp){
		if(first<last){
			int middle=(first+last)/2;
			merrageSort(nums,first,middle,tmp);
			merrageSort(nums,middle+1,last,tmp);
			merageArr(nums,first,middle,last,tmp);
		}
	}
	
	/**
	 * 插入式排序
	 * 二叉树排序
	 * */
	public int[] binarySort(int[] nums){
		int[] tmp=new int[100];
		tmp[0]=nums[0];
		for(int i=1;i<nums.length;i++){
			int k=0;
			while(k<tmp.length && tmp[k]!=0){
				if(nums[i]<tmp[k])
					k=2*k+1;
				else
					k=2*k+2;
			}
			if(k<tmp.length)
				tmp[k]=nums[i];
		}
//		inOrder(nums,tmp,0);
		return tmp;
	}
	
	int cnt=0;
	public void inOrder(int[] nums,int[] tmp,int pos){
		if(pos<tmp.length && tmp[pos]!=0){
			inOrder(nums,tmp, 2*pos+1);
			System.out.print(tmp[pos]+" ");
			nums[cnt++]=tmp[pos];
			inOrder(nums,tmp, 2*pos+2);
		}
	}
	
	public void swap(int[] nums,int index1,int index2){
		if(index1==index2)
			return ;
		nums[index1]=nums[index1]+nums[index2];
		nums[index2]=nums[index1]-nums[index2];
		nums[index1]=nums[index1]-nums[index2];
//		System.out.println("a:"+nums[index1]+"\tb:"+nums[index2]);
	}
	public void swap(int a,int b){
		b=a+b;
		a=b-a;
		b=b-a;
//		System.out.println("a:"+a+"\tb:"+b);
	}
	
	public void myPrint(int[] nums){
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}
}
