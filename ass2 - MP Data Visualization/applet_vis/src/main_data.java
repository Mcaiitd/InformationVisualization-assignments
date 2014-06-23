import prefuse.data.Table;
import prefuse.data.io.CSVTableReader;

public class main_data{
	
	public static Table reading(){
	
		Table t = null;
		try {
			// data in CSV format, so use CSVTableReader
			t = new CSVTableReader().readTable("MPTrack.csv");
		} catch (Exception e) {
			e.printStackTrace();
        	System.exit(1);
		}
		return t;
		}
	
	
	
	
	
	public static int getint(String s)
	{
		
		int n=s.length();
        char ch;
        int temp;
        int sum=0;
		for(int i=0;i<n;i++)
		{
	        ch=s.charAt(i);
			temp=ch;
			sum=(sum)+temp;
		}
		sum=(3*sum)+41;
		return(sum);
	}
	public int[] give_arr(String s1, String s2, String[] state, String[] party  )
	{
		int i1=getint(s1);
		int i2=getint(s2);
		i1=i1%36;
		i2=i2%39;
		
		while(state[i1].equals(s1)==false)
		{
			i1=(i1+1)%36;
		}
		while(party[i2].equals(s2)==false)
		{
			i2=(i2+1)%39;
		}
		int[] s= new int[2];
		s[0]=i1;
		s[1]=i2;
		return s;
		
		
		
		
		
	}
	public static Nee Coust_table()
	{
		s_p_i [][] table=new s_p_i[39][36];
		for(int i=0;i<39;i++)
		{
			
			for(int j=0;j<36;j++)
			{
				table[i][j] = new s_p_i();
				
			}
			
		}	

		
		
		Table T=reading();
		String [] State_array = new String[36];
		String [] party_array = new String[39];
		for(int r=0;r<36;r++)
		{
			State_array[r]="null";
			
		}
		for(int r=0;r<39;r++)
		{
			party_array[r]="null";
			
		}
		
		for(int r=0;r<552;r++)
		{
			////////States
			String s1=(String) T.get(r,4);
			int y1 = getint(s1);
			y1=y1%36;
			if(State_array[y1].equals("null")) 
			{
				
				State_array[y1]=s1;
			}
			else
			{
				while(State_array[y1].equals("null")==false && State_array[y1].equals(s1)==false)
				{
					y1=(y1+1)%36;
					
				}
				if(State_array[y1].equals("null")) 
				{
					State_array[y1]=s1;
				}
			}
			//////////party
			String s2=(String) T.get(r,6);
			int y2 = getint(s2);
			y2=y2%39;
			if(party_array[y2].equals("null")) 
			{
				party_array[y2]=s2;
			}
			else
			{
				while(party_array[y2].equals("null")==false && party_array[y2].equals(s2)==false)
				{
					y2=(y2+1)%39;
				}
				if(party_array[y2].equals("null")) 
				{
					party_array[y2]=s2;
				}
			}
			
			table[y2][y1].add(r); 
			
			
		}
		Nee n= new Nee();
		n.Party=party_array;
		n.State=State_array;
		n.table=table;
		
		table[5][17].show();
		return n;
		
	}
}