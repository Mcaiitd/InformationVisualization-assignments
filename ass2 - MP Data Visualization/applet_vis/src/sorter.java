
import java.applet.*;
import java.awt.*;
import java.io.File;

import javax.swing.JFrame;

public class sorter extends Applet

{
  String s1=null, s2=null,s3=null;
  List y = new List(5,false);
  List x = new List(5,false);
  List basis = new List(4,false);


  public void init()
	{
	 
	  fillthelist();
	  add(x);
	  add(new Label("Select the criteria to sort States in descending order\r\n"));

	  add(y);
	  add(new Label("Select the criteria to sort Parties in descending order\r\n"));

	  add(basis);
	  add(new Label("Select the basis\r\n"));

	  add(new Button(">>>>"));
	  add(new Button("Clear"));

	}
public void fillthelist()
{
  x.addItem("0.Population");
  x.addItem("1.Age");
  x.addItem("2.Debates");
  x.addItem("3.Private Member Bills");
  x.addItem("4.Questions");
  x.addItem("5.Attendance");

  y.addItem("0.Population");
  y.addItem("1.Age");
  y.addItem("2.Debates");
  y.addItem("3.Private Member Bills");
  y.addItem("4.Questions");
  y.addItem("5.Attendance");

  basis.addItem("1.Age");
  basis.addItem("2.Debates");
  basis.addItem("3.Private Member Bills");
  basis.addItem("4.Questions");
  basis.addItem("5.Attendance");

}

	 public void paint(Graphics g)
	 {

	 }


public boolean action(Event evt, Object whatAction)
	{
	    if(!(evt.target instanceof Button))
	    {
	      return false;
	    }

	    String buttonLabel = (String) whatAction;
	    if (buttonLabel == ">>>>")
	      {
	    	s1=x.getSelectedItem();
	    	s2=y.getSelectedItem();
	    	s3=basis.getSelectedItem();

	    	int i,j,k;
	    	s1= s1.substring(0,1);
	    	s2=s2.substring(0,1);
	    	s3=s3.substring(0,1);

	    	i=Integer.parseInt(s1);
	    	j=Integer.parseInt(s2);
	    	k=Integer.parseInt(s3);

	    
	        ScatterPlot6 demo = null;
	   		try {
	   			demo.mainer(i,j,k);
	   		} catch (Exception e) {
	   		e.printStackTrace();
	   		}

	         	return true;
	       }
	    else
	    {
	      x.clear();
	   	  y.clear();
	   	basis.clear();
	   	  fillthelist();

	    	return false;

	    }

	}
}