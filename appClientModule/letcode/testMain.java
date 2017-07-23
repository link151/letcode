package letcode;

import java.util.Scanner;

public class testMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int x11=sc.nextInt();
			int y11=sc.nextInt();
			int x12=sc.nextInt();
			int y12=sc.nextInt();
			int line1=0;
			int len1=0;
			if(y11==y12){
				line1=1;
				len1=Math.abs(x12-x11);
			}
			if(x11==x12){
				line1=-1;
				len1=Math.abs(y12-y11);
			}
			
			int x21=sc.nextInt();
			int y21=sc.nextInt();
			int x22=sc.nextInt();
			int y22=sc.nextInt();
			int line2=0;
			int len2=0;
			if(y21==y22){
				line2=1;
				len2=Math.abs(x22-x21);
			}
			if(x21==x22){
				line2=-1;
				len2=Math.abs(y22-y21);
			}
			
			int x31=sc.nextInt();
			int y31=sc.nextInt();
			int x32=sc.nextInt();
			int y32=sc.nextInt();
			int line3=0;
			int len3=0;
			if(y31==y32){
				line3=1;
				len3=Math.abs(x32-x31);
			}
			if(x31==x32){
				line3=-1;
				len3=Math.abs(y32-y31);
			}
			
			int x41=sc.nextInt();
			int y41=sc.nextInt();
			int x42=sc.nextInt();
			int y42=sc.nextInt();
			int line4=0;
			int len4=0;
			if(y41==y42){
				line4=1;
				len4=Math.abs(x42-x41);
			}
			if(x41==x42){
				line4=-1;
				len4=Math.abs(y42-y41);
			}
//			System.out.println(line1+" "+line2+"  "+line3+"  "+line4);
//			System.out.println(len1+" "+len2+"  "+len3+"  "+len4);
			if(line1==line2 && len1==len2 && line3==line4 && len3==len4){
				System.out.println("YES");
			}else if(line1==line3 && len1==len3 && line2==line4 && len2==len4){
				System.out.println("YES");
			}else if(line1==line4 && len1==len4 && line2==line2 && len2==len4){
				System.out.println("YES");
			}else
				System.out.println("NO");
		}
	}

}
