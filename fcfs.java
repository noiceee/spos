import java.util.*;
public class fcfs 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of process: ");
		int n=sc.nextInt();
		int pid[]=new int[n];
		int at[]=new int[n];
		int bt[]=new int[n];
		int ct[]=new int[n];
		int tat[]=new int[n];
		int wt[]=new int[n];
		int temp;
		float avg_wt=0,avg_tat=0;
 
		for(int i=0; i<n; i++)
		{
			System.out.println("Enter arrival time of process " +(i+1)+ ":");
			at[i]=sc.nextInt();
			System.out.println("Enter burst time of process " +(i+1)+ ":");
			bt[i]=sc.nextInt();
			pid[i]=i+1;
		}
 
		for(int i=0 ; i<n; i++)
		{
			for(int j=0;  j< n-(i+1) ; j++)
			{
				if(at[j] > at[j+1] )
				{
					temp = at[j];
					at[j] = at[j+1];
					at[j+1] = temp;
					temp = bt[j];
					bt[j] = bt[j+1];
					bt[j+1] = temp;
					temp = pid[j];
					pid[j] = pid[j+1];
					pid[j+1] = temp;
				}
			}
		}
		
		for(int i=0 ; i<n; i++)
		{
			if( i == 0)
			{	
				ct[i]= at[i]+bt[i];
			}
			else
			{
				if( at[i]>ct[i-1])
				{
					ct[i]= at[i] +bt[i];
				}
				else
					ct[i]= ct[i-1] +bt[i];
			}
			tat[i] = ct[i] - at[i] ;
			wt[i] = tat[i] - bt[i] ;
			avg_wt += wt[i] ;
			avg_tat += tat[i] ;
		}
		
		System.out.println("Pid\tAT\tBT\tCT\tTAT\tWT\n");
		for(int i=0 ; i<n; i++)
		{
			System.out.println(pid[i] + "  \t " + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t"  + wt[i] ) ;
		}
		System.out.println("\nAverage TAT (turn around time) :"+(avg_tat/n));
		System.out.println("\nAverage WT (waiting time) : "+ (avg_wt/n));
		
		sc.close();
	}
	
}

