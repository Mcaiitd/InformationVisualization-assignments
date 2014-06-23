
String.prototype.splitCSV = function(sep) {
  for (var foo = this.split(sep = sep || ","), x = foo.length - 1, tl; x
>= 0; x--) {
    if (foo[x].replace(/"\s+$/, '"').charAt(foo[x].length - 1) == '"') {
      if ((tl = foo[x].replace(/^\s+"/, '"')).length > 1 && tl.charAt(0)
== '"') {
        foo[x] = foo[x].replace(/^\s*"|"\s*$/g, '').replace(/""/g, '"');
      } else if (x) {
        foo.splice(x - 1, 2, [foo[x - 1], foo[x]].join(sep));
      } else foo = foo.shift().split(sep).concat(foo);
    } else foo[x].replace(/""/g, '"');
  } return foo;
};
var fnum=0;
function rem()
{
	var Scr  = new ActiveXObject("Scripting.FileSystemObject");
	var CTF  = Scr .OpenTextFile("C:\\Users\\Sony\\Documents\\Workstation_Eclipse\\Hypo\\WebContent\\Gyan.txt", 1, true);
	fnum=CTF .ReadLine(); 
	CTF .Close();
}



function make_acc()
{
	var importer=new Array();
	var one=0;
	var two=1;
		Read(fnum);
		var x=new Array();
		var const2 =0;
		var f1=fnum;
	    if(f1==0 || f1==1 || f1==2 || f1==3 || 5) const2=553;
	    if(f1==3) const2=300;
	    if(f1==4) const2=551;
 	
		x[0]=new Array();
		x[0][0]='Age';
		x[0][1]='Weight';

		
		var ix=0;
		var i=0;
		while(ix<(const2-1))
		{
			var str1=maindata[ix][one];	
			var str2=maindata[ix][two];	
			if(str1.charAt(1)=='%' ||str1.charAt(2)=='%'||str1.charAt(3)=='%')
			{
				var mySplitResult = str1.split("%");
				str1=mySplitResult[0];
			}
			if(str2.charAt(1)=='%' ||str2.charAt(2)=='%'||str2.charAt(3)=='%')
			{
				var mySplitResult2 = str2.split("%");
				str2=mySplitResult2[0];
			}
			if(str1=="N/A" || str2=="N/A")
			{}
			else
			{
				x[i]=new Array();
				x[i][0]=1*str1;
				x[i][1]=1*str2; 
				i++;
			}
			ix++;
		
		}	
		importer=x;

 	return importer;
}

var maindata = new Array();



function Read(f)
{
	var sr="C:\\Users\\Sony\\Documents\\Workstation_Eclipse\\Hypo\\data"+ f +".csv" ;
	var i=0;
    var Scr  = new ActiveXObject("Scripting.FileSystemObject");
    var CTF  = Scr .OpenTextFile(sr, 1, true);
    var data="o";
    var const1 =0;
    if(f==0 || f==1 || f==2 || f==3 || 5) const1=553;
    if(f==3) const1=300;
    if(f==4) const1=551;
    while(i<const1)
    {
        data = CTF .ReadLine();
        var parsed = data.splitCSV();
        maindata[i]=parsed;
        i++;
    }
    CTF .Close();
}


