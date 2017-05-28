import java.util.*;
import java.io.*;
public class aostar
{
	public static void main(String args[])throws IOException
	{
		Scanner in=new Scanner(System.in);
		char c='A';
		System.out.println("Initial Node: A");
		System.out.print("Number of children of A:");
		int n=in.nextInt();
		int child[]=new int[n];
		System.out.println("Level 0:A\nLevel 1:");
		System.out.println("Enter the initial costs for child nodes");
		int small=500;
		char bestchild='\u0000';
		
		for(int i=0;i<n;i++)
		{
			System.out.print(++c+":");
			child[i]=in.nextInt();
			if(small>child[i])
			{
				small=child[i];
				bestchild=c;
			}	
		}
		System.out.println("\nBest Node without expanding level 1:"+bestchild+"\n\nExpanding each node into 2 terminal nodes");
		char f=c;
		c='A';
		int a,b;
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the cost of children of"+(++c)+"\n"+(++f)+":");
			a=in.nextInt();
			System.out.print((++f)+":");
			b=in.nextInt();
			System.out.print("Is it an \"and\" node (y/n):");
			char d=(char) System.in.read();
			if(d=='y')
			{
				child[i]=a+b+2;
			}
			else
			{
				int x=(a<b)?a:b;
				child[i]=x+1;
			}
			System.out.println("New value of"+c+"after expansion:"+child[i]);
		}
		small=child[0];
		c='A';
		bestchild='B';
		for(int i=0;i<n;i++)
		{
			++c;
			if(small>child[i])
			{
				small=child[i];
				bestchild=c;
			}
		}
		System.out.println("\nBest Node after expansion:"+bestchild);
	}
}