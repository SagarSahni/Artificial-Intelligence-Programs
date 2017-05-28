import java.io.*;
import java.util.*;
public class prog2
{
	static ArrayList<Integer> J1;
	static ArrayList<Integer> J2;
	static int maxA,maxB,A,B;
	public static void main(String args[])throws IOException
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Jug A:");
		maxA=in.nextInt();
		System.out.print("Jug B:");
		maxB=in.nextInt();
		System.out.print("Reqd.:");
		int req=in.nextInt();
		if(req%gcd(maxA,maxB)==0)
			System.out.println("Problem Solvable!");
		else
		{
			System.out.println("Problem Not Solvable!");
			System.exit(0);
		}
		System.out.print("In Jug:");
		char c=(char)System.in.read();
		if(c=='A')
		{
			A=req;
			B=0;
		}
		else
		{
			A=0;
			B=req;
		}
		J1=new ArrayList<Integer>();
		J2=new ArrayList<Integer>();
		J1.add(0);
		J2.add(0);
		for(int x=0;x<J1.size();x++)
		{
			int a=J1.get(x);
			int b=J2.get(x);
			System.out.print("("+a+","+b+")-->");
			if(a==A && b==B)
				break;
			applyRules(a,b);
		}
		System.out.println("goal state");
	}
	public static void applyRules(int j1, int j2)
	{
		if(j1+j2<=maxA && j2>0)
			check(j1+j2,0);
		if(j1+j2<=maxB && j1>0)
			check(0,j1+j2);
		if(j1>0)
			check(0,j2);
		if(j2>0)
			check(j1,0);
		if(j1<maxA)
			check(maxA,j2);
		if(j2<maxB)
			check(j1,maxB);
		if(j1+j2>=maxA && j2>0)
			check(maxA,j2-(maxA-j1));
		if(j1+j2>=maxB && j1>0)
			check(j1-(maxB-j2),maxB);
	}
	public static void check(int ju1,int ju2)
	{
		int flag=0;
		for(int x=0;x<J1.size();x++)
		{
			int a=J1.get(x);
			int b=J2.get(x);
			if(a==ju1 && b==ju2)
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			J1.add(ju1);
			J2.add(ju2);
		}
	}
	public static int gcd(int a, int b)
	{
		if(a%b==0)
			return b;
		else
			return gcd(b,a%b);
	}
}