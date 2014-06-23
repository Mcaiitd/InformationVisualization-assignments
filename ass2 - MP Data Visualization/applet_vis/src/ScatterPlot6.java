
import java.util.*;

import javax.swing.*;

import prefuse.*;
import prefuse.action.ActionList;
import prefuse.action.RepaintAction;
import prefuse.action.assignment.ColorAction;
import prefuse.action.assignment.DataShapeAction;
import prefuse.action.assignment.DataSizeAction;
import prefuse.action.layout.AxisLabelLayout;
import prefuse.action.layout.AxisLayout;
import prefuse.controls.ToolTipControl;
import prefuse.data.Table;
import prefuse.render.*;
import prefuse.render.Renderer;
import prefuse.util.ColorLib;
import prefuse.util.ui.UILib;
import prefuse.visual.VisualItem;
import prefuse.visual.expression.VisiblePredicate;
import prefuse.visual.sort.ItemSorter;

public class ScatterPlot6 

{
	public static float getavg(String s1, String s2,String [] State_array,String [] party_array,main_data cl,s_p_i [][] table,Table t,int kk)
	{
		
		int[] p = cl.give_arr(s1, s2, State_array, party_array);
		Object f;int aa=0,ans;
		int i,j,k;
		i=p[0];
		j=p[1];
		int h=0;
		int sum=0;int counter=0;
		while(table[j][i].s[h]!=-1)
		{
			k=table[j][i].s[h];
			f =   t.get(k,kk+9);
			if(f.equals("N/A")||f.equals("")){h++;}
			else if(f.equals("N/A")==false){
				if(kk==1){aa=((Integer) f).intValue();}
			if(kk==5){		
			f=((String) f).substring(0,((String) f).length()-1);
			aa=Integer.parseInt((String) f);
			}
			if(kk==2||kk==3||kk==4){	
			aa=Integer.parseInt((String) f);
			}
			sum = sum + aa ;
			counter++;
			h++;
			}
		}
		if (counter==0)ans=0;
		else ans = sum/counter;
		return ans;	
	}

	
	public static String[] sorter1(int i,String[] s_d,String [] State_array,String [] party_array,main_data cl,s_p_i [][] table,Table t)
	{
		float[] count = new float[s_d.length];
		int cc=0;String s1,s2;int w;
		while(cc<s_d.length)
		{
			w=0;int ans=0;int k;Object f;int cont=0;
			while(w<party_array.length)
			{
				s1=s_d[cc];
				s2=party_array[w];
				int[] p = cl.give_arr(s1, s2, State_array, party_array);
				int jj=0;
				while(table[p[1]][p[0]].s[jj]!=-1)
				{
					int aa=0;
					if(i==0)
						{ans++;}
					else
					{
						k=table[p[1]][p[0]].s[jj];
						f=t.get(k, i+9);
						if(f.equals("N/A")){aa=0;}
						else if (f.equals("N/A")==false)
						{
							if(i==1)
								{aa=((Integer) f).intValue();}
							if(i==5)
							{		
								f=((String) f).substring(0,((String) f).length()-1);
								aa=Integer.parseInt((String) f);
							}
							if(i==2||i==3||i==4)
							{
								aa=Integer.parseInt((String) f);
							}
						}
					ans=ans+aa;if(aa!=0)cont++;
					}
					jj++;
				}
				w++;
			}

			if(i==0){count[cc]=ans;}
			else {if(cont!=0)count[cc]=ans/cont;else count[cc]=0;}
			cc++;
		}
		int u1=0;int j;
		while(u1<count.length)
		{
			j=u1;float max=0;int maxind=u1;
			while(j<count.length)
			{
				if(count[j]>max){max=count[j];maxind=j;}
				j++;
			}
			String temp = s_d[u1];
			s_d[u1]=s_d[maxind];
			s_d[maxind]=temp;
			float temp1 = count[u1];
			count[u1]=count[maxind];
			count[maxind]=temp1;
			u1++;
		}
		return s_d;	
	}
	public static String[] sorter2(int j,String[] p_d,String [] State_array,String [] party_array,main_data cl,s_p_i [][] table,Table t)
	{
				float[] count = new float[p_d.length];
				int cc=0;String s1,s2;int w;
				while(cc<p_d.length)
				{
					w=0;int ans=0;int k;Object f;int cont=0;
					while(w<State_array.length)
					{
						s1=State_array[w];
						s2=p_d[cc];
						int[] p = cl.give_arr(s1, s2, State_array, party_array);
						int jj=0;
						while(table[p[1]][p[0]].s[jj]!=-1)
						{
							int aa=0;
							if(j==0)
								{ans++;}
							else
							{
								k=table[p[1]][p[0]].s[jj];
								f=t.get(k, j+9);
								if(f.equals("N/A")){aa=0;}
								else if (f.equals("N/A")==false)
								{
									if(j==1)
										{aa=((Integer) f).intValue();}
									if(j==5)
									{		
										f=((String) f).substring(0,((String) f).length()-1);
										aa=Integer.parseInt((String) f);
									}
									if(j==2||j==3||j==4)
									{
										aa=Integer.parseInt((String) f);
									}
								}
							ans=ans+aa;if(aa!=0)cont++;
							}
							jj++;
						}
						w++;
					}
					if(j==0)
					count[cc]=ans;
					else if(cont!=0)count[cc]=ans/cont;else count[cc]=0;
					cc++;
				}
				
				int u1=0;int ji;
				while(u1<count.length)
				{
					ji=u1;float max=0;int maxind=u1;
					while(ji<count.length)
					{
						if(count[ji]>max){max=count[ji];maxind=ji;}
						ji++;
					}
					String temp = p_d[u1];
					p_d[u1]=p_d[maxind];
					p_d[maxind]=temp;
					float temp1 = count[u1];
					count[u1]=count[maxind];
					count[maxind]=temp1;
					u1++;
				}
				return p_d;		}

	private static Table generateTable(int ii,int jj,int kk)
	{
		main_data md= new main_data();
		Nee m=new Nee();
		m=md.Coust_table();
		Table table = new Table();
		Table t = md.reading();

		table.addColumn("Party", String.class);
		table.addColumn("State", String.class);
		table.addColumn("Average", float.class);

		int ji=1404;
		table.addRows(ji);
		int k=0;
		String s1,s2;
		float avg=0;
		int i=0;int j=0;
		int count=0;
		String[] s_d= new String[m.State.length];
		String[] p_d =new String[m.Party.length];
		int ie=0;
		while(ie<m.State.length)
		{
			s_d[ie]=m.State[ie];
			ie++;
		}ie=0;
		while(ie<m.Party.length)
		{
			p_d[ie]=m.Party[ie];
			ie++;
		}

		s_d=sorter1(ii,s_d,m.State,m.Party,md,m.table,t);
		p_d=sorter2(jj,p_d,m.State,m.Party,md,m.table,t);
		
		while(i<36)
		{
			j=0;
			while(j<39)
			{
				s1=s_d[i];
				s2=p_d[j];
				avg = getavg(s1,s2,m.State,m.Party,md,m.table,t,kk);

				if (avg==0) {count++;j++;}
				else{
				if(i>9)
				s1 = Integer.toString(i) + "." + s1 ;
				else
					s1 = "0"+Integer.toString(i) + "." + s1 ;
				
				if(j>9)
					s2 = Integer.toString(j) + "." + s2 ;
					else
						s2 = "0"+Integer.toString(j) + "." + s2 ;
				table.set(k, 0, s1);
				table.set(k, 1, s2);
				table.set(k, 2, avg);
				k++;
				j++;}
			}
			i++;
		}
		i=0;
		while(i<count){
		table.removeRow(ji-1-i);
		i++;
		}
		return table;
	}

	private static JComponent createVisualization(Table data) {
		Visualization vis = new Visualization();
		Display display = new Display(vis);
		vis.add("data", data);
		vis.setRendererFactory(new RendererFactory() {
			AbstractShapeRenderer sr = new ShapeRenderer(7);
			Renderer arY = new AxisRenderer(Constants.FAR_LEFT,
					Constants.CENTER);
			Renderer arX = new AxisRenderer(Constants.CENTER,
					Constants.FAR_BOTTOM);

			public Renderer getRenderer(VisualItem item) {
				return item.isInGroup("ylab") ? arY
						: item.isInGroup("xlab") ? arX : sr;
			}
		});

		AxisLayout x_axis = new AxisLayout("data", "Party", Constants.X_AXIS,
				VisiblePredicate.TRUE);

		AxisLayout y_axis = new AxisLayout("data", "State", Constants.Y_AXIS,
				VisiblePredicate.TRUE);

		AxisLabelLayout x_labels = new AxisLabelLayout("xlab", x_axis);

		AxisLabelLayout y_labels = new AxisLabelLayout("ylab", y_axis);

		ColorAction color = new ColorAction("data", VisualItem.FILLCOLOR,
				ColorLib.rgb(100, 100, 255));

		int[] palette = { Constants.SHAPE_STAR, Constants.SHAPE_ELLIPSE };
		DataSizeAction size = new DataSizeAction("data", "Average");
		
		ActionList draw = new ActionList();
		draw.add(x_axis);
		draw.add(y_axis);
		draw.add(x_labels);
		draw.add(y_labels);
		draw.add(color);
		draw.add(size);
		draw.add(new RepaintAction());
		vis.putAction("draw", draw);

		display.setHighQuality(true);
		display.setSize(1150, 700);

		display.setBorder(BorderFactory.createEmptyBorder(30, 200, 30, 100));

		// show data items in front of axis labels
		display.setItemSorter(new ItemSorter() {
			public int score(VisualItem item) {
				int score = super.score(item);
				if (item.isInGroup("data"))
					score++;
				return score;
			}
		});

		String[] tooltipparams = { "State", "Party" ,"Average"};
		ToolTipControl ttc = new ToolTipControl(tooltipparams);
		display.addControlListener(ttc);

		vis.run("draw");

		return display;
	}

	private static void createAndShowGUI(JComponent display) {
		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("p r e f u s e | s c a t t e r   p l o t");

		frame.getContentPane().add(display);

		frame.pack();
		frame.setVisible(true);
	}

	public static void mainer(int i,int j,int k) {
		Locale.setDefault(Locale.US);
		UILib.setPlatformLookAndFeel();

		Table table = generateTable(i,j,k);
		final JComponent display = createVisualization(table);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(display);
			}
		});
	}

}
