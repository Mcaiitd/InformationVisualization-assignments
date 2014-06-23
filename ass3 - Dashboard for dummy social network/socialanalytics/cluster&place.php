<html>
<head>
</head>
<body>
<?php
// Make a MySQL Connection
mysql_connect("localhost", "alpha", "csp301") or die(mysql_error());
mysql_select_db("social_net") or die(mysql_error());

$result= mysql_query("SELECT Place,ClusterID,COUNT(1) NoOfNodes
FROM
    cluster
GROUP BY
    Place,ClusterID") or die(mysql_error());

$ii=0;$prevplace="Default";
	while($row = mysql_fetch_array($result))
	{
		$place=$row['Place']; $nodeid = $row['ClusterID']; $no=$row['NoOfNodes'];
		$info[$ii][0] =$place;
		$info[$ii][1] =$nodeid;
		$info[$ii][2] =$no;
		$ii++;$prevplace=$place;
	}

	echo("PLACE"."--"."CLUSTER"."--"."No. of such Nodes")."<br/>"."<br/>";
	for($i=0;$i<$ii;$i++)
	{
	echo($info[$i][0]."--".$info[$i][1]."--".$info[$i][2])."<br/>";
	}




/*

	$result= mysql_query("SELECT * from cluster  ORDER BY ClusterID, Place") or die(mysql_error());

	$c0=0;$c1=0;$c2=0;$c3=0;$c4=0;$c5=0;$c6=0;$c7=0;$prevplace = "Default";
	$i0=0;$i1=0;$i2=0;$i3=0;$i4=0;$i5=0;$i6=0;$i7=0;
	$clust0=range(0,0);$clust1=range(0,0);$clust2=range(0,0);$clust3=range(0,0);$clust4=range(0,0);$clust5=range(0,0);$clust6=range(0,0);$clust7=range(0,0);
	//$clust0[0][0]="Default";$clust1[0][0]="Default";$clust2[0][0]="Default";$clust3[0][0]="Default";$clust4[0][0]="Default";$clust5[0]="Default";$clust6[0]="Default";$clust7[0]="Default";

	while($row = mysql_fetch_array($result))
	{
		$c=$row['ClusterID']; $place = $row['Place'];
		if($c==0){if($place!=$prevplace){$i0++;$clust0[$i0]=0;}$c0++;$clust0[$i0]++;}
		if($c==1){if($place!=$prevplace){$i1++;$clust1[$i1]=0;}$c1++;$clust1[$i1]++;}
		if($c==2){if($place!=$prevplace){$i2++;$clust2[$i2]=0;}$c2++;$clust2[$i2]++;}
		if($c==3){if($place!=$prevplace){$i3++;$clust3[$i3]=0;}$c3++;$clust3[$i3]++;}
		if($c==4){if($place!=$prevplace){$i4++;$clust4[$i4]=0;}$c4++;$clust4[$i4]++;}
		if($c==5){if($place!=$prevplace){$i5++;$clust5[$i5]=0;}$c5++;$clust5[$i5]++;}
		if($c==6){if($place!=$prevplace){$i6++;$clust6[$i6]=0;}$c6++;$clust6[$i6]++;}
		if($c==7){if($place!=$prevplace){$i7++;$clust7[$i7]=0;}$c7++;$clust7[$i7]++;}

		$prevplace = $place;
  	}

  	echo("Total for Cluster 0 == ".$c0)."<br />";
  	for($i=0;$i<=$i0;$i++)
  	{
  			echo($clust0[$i])."<br />";
  	}
  	echo("Total for Cluster 1 == ".$c1)."<br />";
  	for($i=0;$i<=$i1;$i++)
  	{
  			echo($clust1[$i])."<br/>";
  	}
  	echo("Total for Cluster 2 == ".$c2)."<br />";
  	for($i=0;$i<=$i2;$i++)
  	{
  			echo($clust2[$i])."<br/>";
  	}
  	echo("Total for Cluster 3 == ".$c3)."<br />";
  	for($i=0;$i<=$i3;$i++)
  	{
  			echo($clust3[$i])."<br/>";
  	}
  	echo("Total for Cluster 4 == ".$c4)."<br />";
  	for($i=0;$i<=$i4;$i++)
  	{
  			echo($clust4[$i])."<br/>";
  	}
  	echo("Total for Cluster 5 == ".$c5)."<br />";
  	for($i=0;$i<=$i5;$i++)
  	{
  			echo($clust5[$i])."<br/>";
  	}
  	echo("Total for Cluster 6 == ".$c6)."<br />";
  	for($i=0;$i<=$i6;$i++)
  	{
  			echo($clust6[$i])."<br/>";
  	}
  	echo("Total for Cluster 7 == ".$c7)."<br />";
  	for($i=0;$i<=$i7;$i++)
  	{
  			echo($clust7[$i])."<br/>";
  	}

*/

?>
</body>
</html>