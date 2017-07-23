package letcode;

public class MySearch {
	/**
	 * 线性查找 
	 * */
	public void linerSearch(int[] data,int key){
		int i;
		for(i=0;i<data.length;i++){
			if(data[i]==key){
				System.out.println(i+ " "+data[i]);
				break;
			}
		}
		if(i==data.length)
			System.out.println("未找到");
	}
	
	/**
	 * 二分查找 
	 * */
	public void bSearch(int[] data,int key){
		int low=0,high=data.length-1;
		while(low<=high){
			int middle=(low+high)/2;
			if(data[middle]==key){
				System.out.println(middle+ " "+data[middle]);
				break;
			}else if(data[middle]<key){
				low=middle+1;
			}else{
				high=middle-1;
			}
		}
		if(low>high)
			System.out.println("未找到");
	}
	
	public void btreeSearch(int[] data,int key){
		int[] tmp=new int[100];
		MySort mySort=new MySort();
		tmp=mySort.binarySort(data);
		mySort.myPrint(tmp);
		int i=0;
		while(i<tmp.length && tmp[i]!=0){
			if(key==tmp[i]){
				System.out.println(i+ " "+tmp[i]);
				return;
			}else if(key>tmp[i]){
				i=2*i+2;
			}else{
				i=2*i+1;
			}
		}
		System.out.println("未找到");
	}
}
