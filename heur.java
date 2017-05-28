import java.util.*;
public class heur
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int A[][]=new int[3][3];
		System.out.println("Enter the tiles. Depict empty space by 0");
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				A[i][j]=in.nextInt();
		movegen(A,A);	
	}
	public static int heuristic(int AA[][])
	{
		int count=1;
		int h=0;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
			{
				if(i==2&&j==2)
					break;
				if(AA[i][j]!=count)
					h++;
				count+=1;
			}
		return h;
	}
	public static void movegen(int AA[][],int aa[][])
	{
		int i=0,j=0;
		outer: for(i=0;i<3;i++)
			for(j=0;j<3;j++)
				if(AA[i][j]==0)
					break outer;
		int temp[][],bestmove[][]=copy(AA);
		int temph;
		int hbest=10;
		if(i-1>=0)
		{
			temp=copy(AA);
			temp[i][j]=temp[i-1][j];
			temp[i-1][j]=0;
			temph=heuristic(temp);
			if(!same(temp,aa) && temph<hbest)
			{
				hbest=temph;
				bestmove=copy(temp);
			}
		}
		if(i+1<=2)
		{
			temp=copy(AA);
			temp[i][j]=temp[i+1][j];
			temp[i+1][j]=0;
			temph=heuristic(temp);
			if(!same(temp,aa) && temph<hbest)
			{
				hbest=temph;
				bestmove=copy(temp);
			}
		}	
		if(j-1>=0)
		{
			temp=copy(AA);
			temp[i][j]=temp[i][j-1];
			temp[i][j-1]=0;
			temph=heuristic(temp);
			if(!same(temp,aa) && temph<hbest)
			{
				hbest=temph;
				bestmove=copy(temp);
			}
		}	
		if(j+1<=2)
		{
			temp=copy(AA);
			temp[i][j]=temp[i][j+1];
			temp[i][j+1]=0;
			temph=heuristic(temp);
			if(!same(temp,aa) && temph<hbest)
			{
				hbest=temph;
				bestmove=copy(temp);
			}
		}
		print(bestmove);
		System.out.println(heuristic(bestmove));
		if(heuristic(bestmove)==0)
			return;
		else
			movegen(bestmove,AA);
	}
	public static int[][] copy(int x[][])
	{
		int y[][]=new int[3][3];
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				y[i][j]=x[i][j];
		return y;
	}
	public static boolean same(int x[][],int y[][])
	{
		boolean flag=true;
		outer: for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(x[i][j]!=y[i][j])
				{
					flag=false;
					break outer;
				}
		return flag;
	}
	public static void print(int ab[][])
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
				System.out.print(ab[i][j]+"\t");
			System.out.println();
		}
	}
}