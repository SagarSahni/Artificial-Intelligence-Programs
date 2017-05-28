import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
class astarrr
{
	public static String stringy;
	public static String str;
	Queue<String> agenda = new LinkedList<String>();
	Map<String,Integer> stateDepth = new HashMap<String, Integer>();
	Map<String,String> stateHistory = new HashMap<String,String>();
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Initial State: ");
		str=br.readLine();
		System.out.println("Enter Final State: ");
		stringy=br.readLine();
		astarrr e = new astarrr();
		e.add(str, null);
		while(!e.agenda.isEmpty())
		{
			String currentState = e.agenda.remove();
			e.up(currentState);
			e.down(currentState);
			e.left(currentState);
			e.right(currentState);
		}
		System.out.println("Solution doesn't exist");
	}
	void add(String newState, String oldState)
	{
		if(!stateDepth.containsKey(newState))
		{
			int newValue = oldState == null ? 0 : stateDepth.get(oldState) + 1;
			stateDepth.put(newState, newValue);
			agenda.add(newState);
			stateHistory.put(newState,oldState);
		}
	}
	void up(String currentState)
	{
		int a = currentState.indexOf("0");
		if(a>2)
		{
			String nextState=currentState.substring(0,a-3)+"0"+
			currentState.substring(a-2,a)+currentState.charAt(a-3)+currentState.substring(a+1);
			checkCompletion(currentState,nextState);
		}
	}
	void down(String currentState)
	{
		int a = currentState.indexOf("0");
		if(a<6)
		{
			String nextState=currentState.substring(0,a)+currentState.substring(a+3,a+4)+
			currentState.substring(a+1,a+3)+"0"+currentState.substring(a+4);
			checkCompletion(currentState,nextState);
		}
	}
	void left(String currentState)
	{
		int a = currentState.indexOf("0");
		if(a!=0 && a!=3 && a!=6)
		{
			String nextState =currentState.substring(0,a-1)+"0"+
			currentState.charAt(a-1)+currentState.substring(a+1);
			checkCompletion(currentState, nextState);
		}
	}
	void right(String currentState)
	{
		int a = currentState.indexOf("0");
		if(a!=2 && a!=5 && a!=8)
		{
			String nextState=currentState.substring(0,a)+currentState.charAt(a+1)+"0"+currentState.substring(a+2);
			checkCompletion(currentState, nextState);
		}
	}
	private void checkCompletion(String oldState, String newState)
	{
		add(newState, oldState);
		if(newState.equals(stringy))
		{
			System.out.println("Solution Exists at Level "+stateDepth.get(newState)+" of the tree");
			String traceState = newState;
			while (traceState != null)
			{
				System.out.println(traceState + " at " + stateDepth.get(traceState));
				traceState = stateHistory.get(traceState);
			}
			System.exit(0);
		}
	}
}