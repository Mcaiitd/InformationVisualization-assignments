<html>
<head>
<title>My First PHP Page</title>
</head>
<body>
<?php
// Make a MySQL Connection
mysql_connect("localhost", "alpha", "csp301") or die(mysql_error());
mysql_select_db("social_net") or die(mysql_error());

function cluster()
{
	$myFile = "graph.lc";
	$fh = fopen($myFile, 'r');
	while(!feof($fh))
	{
		ini_set('max_execution_time', 900);
		$line = fgets($fh);
		$line_parts = explode(" ", $line);
		$node = $line_parts[0];
		$cluster = $line_parts[4];
		insert($node,$cluster);
	}
	fclose($fh);
}

create();
cluster();
function create()
{
	mysql_query("CREATE TABLE cluster(
	id INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY(id),
	NodeID INT,
	ClusterID INT)")
	or die(mysql_error());
	echo "Table Created!";
}
function insert($node,$cluster)
{
	mysql_query("INSERT INTO cluster
	(NodeID,ClusterID) VALUES('$node','$cluster') ")
	or die(mysql_error());
	echo "Data Inserted!";
}

?>
</body>
</html>