package letcode;

public class HammingDistance {
	
	public int hamingDistance(int x,int y){
		int xor = x ^ y;
		int count=0;
		for(int i=0;i<32;i++){
			System.out.println("i:"+i+"  "+((xor>>i)&1));
			count+=(xor>>i)&1;
		}
		System.out.println("count:"+count);
		return count;
	}
	
	public int hamingDistance2(int x,int y){
		return Integer.bitCount(x^y);
	}
}
