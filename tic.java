import java.util.*;
public class tic
{
	public static char A[][];
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		A=new char[3][3];
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				A[i][j]='-';
		display();
		o:for(int i=0;i<9;i+=2)
		{
			System.out.print("Row:");
			int a=in.nextInt();
			System.out.print("Column:");
			int b=in.nextInt();
			if(A[a][b]=='-')
			{
				A[a][b]='X';
				display();
				char c=win();
				if(c!='-')
				{
					System.out.println(c+"wins");
					System.exit(0);
				}
			}
			else
			{
				i-=2;
				System.out.println("Already filled");
				continue o;
			}
			if(i==8)
			{
				System.out.println("DRAW");
				System.exit(0);
			}
			System.out.println("Computer");
			String turn=check('O');
			if(turn.charAt(0)==' ')
				turn=check('X');
			if(turn.charAt(0)==' ')
			{
				p:for(int h=0;h<3;h++)
					for(int j=0;j<3;j++)
						if(A[h][j]=='-')
						{
							A[h][j]='O';
							break p;
						}
			}
			else
			{
				a=Integer.parseInt(turn.substring(0,1));
				b=Integer.parseInt(turn.substring(1,2));
				A[a][b]='O';
			}
			display();
			char c=win();
			if(c!='-')
			{
				System.out.println(c+"wins");
				System.exit(0);
			}
		}
	}
	public static String check(char w)
	{
		if(A[0][0]=='-'&& ((A[0][1]==w&&A[0][2]==w)||(A[1][0]==w&&A[2][0]==w)||(A[1][1]==w&&A[2][2]==w)))
			return "00";
		if(A[0][1]=='-'&& ((A[0][0]==w&&A[0][2]==w)||(A[1][1]==w&&A[2][1]==w)))
			return "01";
		if(A[0][2]=='-'&& ((A[0][0]==w&&A[0][1]==w)||(A[1][2]==w&&A[2][2]==w)||(A[1][0]==w&&A[1][1]==w)))
			return "02";
		if(A[1][0]=='-'&& ((A[1][1]==w&&A[1][2]==w)||(A[0][0]==w&&A[2][0]==w)))
			return "10";
		if(A[1][1]=='-'&& ((A[1][0]==w&&A[1][2]==w)||(A[0][1]==w&&A[2][1]==w)||(A[0][0]==w&&A[2][2]==w)||(A[2][0]==w&&A[0][2]==w)))
			return "11";
		if(A[1][2]=='-'&& ((A[1][0]==w&&A[1][1]==w)||(A[0][2]==w&&A[2][2]==w)))
			return "12";
		if(A[2][0]=='-'&& ((A[2][1]==w&&A[2][2]==w)||(A[0][0]==w&&A[1][0]==w)||(A[1][1]==w&&A[0][2]==w)))
			return "20";
		if(A[2][1]=='-'&& ((A[2][0]==w&&A[2][2]==w)||(A[0][1]==w&&A[1][1]==w)))
			return "21";
		if(A[2][2]=='-'&& ((A[2][0]==w&&A[2][1]==w)||(A[0][2]==w&&A[1][2]==w)||(A[0][0]==w&&A[1][1]==w)))
			return "22";
		return " ";
	}
	public static char win()
	{
		if(A[0][0]==A[0][1]&&A[0][0]==A[0][2])
			return A[0][0];
		if(A[1][0]==A[1][1]&&A[1][0]==A[1][2])
			return A[1][0];
		if(A[2][0]==A[2][1]&&A[0][0]==A[2][2])
			return A[2][0];
		if(A[0][0]==A[1][0]&&A[0][0]==A[2][0])
			return A[0][0];
		if(A[0][1]==A[1][1]&&A[0][1]==A[2][1])
			return A[0][1];
		if(A[0][2]==A[1][2]&&A[0][2]==A[2][2])
			return A[0][2];
		if(A[0][0]==A[1][1]&&A[0][0]==A[2][2])
			return A[0][0];
		if(A[2][0]==A[1][1]&&A[2][0]==A[0][2])
			return A[2][0];
		return '-';
	}
	public static void display()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
				System.out.print(A[i][j]+"\t");
			System.out.println();
		}
	}
}