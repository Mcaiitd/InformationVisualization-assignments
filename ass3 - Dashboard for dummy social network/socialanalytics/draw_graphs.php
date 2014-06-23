
<?php

mysql_connect("localhost", "alpha", "csp301") or die(mysql_error());
mysql_select_db("social_net") or die(mysql_error());
$boundq=$_POST['num'];
function return_data($i)
{	

	
	$type=$_POST['typ'];
	$topic_name = $_POST['topic'];
	
	$bound=$_POST['num'];
	
	//echo $type ;
	//echo $topic_name ;
	//echo $bound ;
	
	
	if($type=="day")
	{
		$result = mysql_query("SELECT * FROM cumtable
		WHERE topic_name  ='$topic_name'") or die(allert());  
		$row = mysql_fetch_array($result);
		$temp="day_";
		if($i>$bound) 
		{
			$totable=0;
		}
		else
		{
			$temp="day_";
			$temp=$temp.$i;			
			$totable=$row[$temp];			
		
		}
		
		return $totable;		
	}
	elseif($type=="week")
	{
		$result = mysql_query("SELECT * FROM week
		WHERE topic_name = '$topic_name'") or die(mysql_error());  
		$row = mysql_fetch_array( $result );
		
		if($i>$bound) 
		{
			$totable=0;
		}
		else
		{
			$temp="week_";
			$temp=$temp.$i;			
			$totable=$row[$temp];			
		
		}
		return $totable;
	}
	elseif($type=="month")
	{
		$result = mysql_query("SELECT * FROM monthtable
		WHERE topic_name = '$topic_name'") or die(mysql_error());  
		$row = mysql_fetch_array( $result );
		if($i>$bound) 
		{
			$totable=0;
		}
		else
		{
			$temp="month_";
			$temp=$temp.$i;			
			$totable=$row[$temp];			
		
		}
		return $totable;		
	}		
}

?>

<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
	document.write("Ameyarockd");
		var xy=new Array();
xy[0]=new Array();
xy[1]=new Array();
xy[2]=new Array();
xy[4]=new Array();
xy[5]=new Array();
xy[6]=new Array();
xy[7]=new Array();
xy[3]=new Array();
//document.write(<?PHP echo (return_data(1)) ?>);
xy[0][0]=1;
xy[0][1]=<?PHP echo (return_data(1)) ?>;
xy[1][0]=1;
xy[1][1]=<?PHP echo (return_data(1)) ?>;
xy[2][0]=2;
xy[2][1]=<?PHP echo (return_data(2)) ?>;
xy[3][0]=3;
xy[3][1]=<?PHP echo (return_data(3)) ?>;
xy[4][0]=4;
xy[4][1]=<?PHP echo (return_data(4)) ?>;
xy[5][0]=5;
xy[5][1]=<?PHP echo (return_data(5)) ?>;
xy[6][0]=6;
xy[6][1]=<?PHP echo (return_data(6)) ?>;
xy[7][0]=7;
xy[7][1]=<?PHP echo (return_data(7)) ?>;
var t=1;
var x=new Array();
x[0]=new Array();
x[0][0]='X';
x[0][1]='Y';

while(t<=<?PHP echo $boundq ?>)
{
	document.write("Ameyarockd");
	x[t]=new Array();
	x[t][0]=xy[t][0];
	x[t][1]=xy[t][1];
	document.write(x[t][0] );
	document.write(x[t][1] );
	t++;
}
	
	
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable(x);

        var options = {
          title: 'Company Performance',
          hAxis: {title: 'Year',  titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>

