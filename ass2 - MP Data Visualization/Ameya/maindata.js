
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
var imporer=new Array();
var one;
var two;
var typ;

//////////////
function rem()
{
	var Scr  = new ActiveXObject("Scripting.FileSystemObject");
	var CTF  = Scr .OpenTextFile("C:\\Users\\Sony\\Documents\\Workstation_Eclipse\\Ameya\\WebContent\\Gyan.txt", 1, true);
	one=CTF .ReadLine(); 
	two=CTF .ReadLine(); 
	typ=CTF .ReadLine(); 
	one=(1*one)+9;
	two=(1*two)+9;
	CTF .Close();
}
function get1()
{
	return one;
}
function get2()
{
	return two;
}
function make_acc()
{
	if(typ==1)
	{
		Read();
		var x=new Array();
		
 	
		x[0]=new Array();
		x[0][0]='Age';
		x[0][1]='Weight';

		
		var ix=0;
		var i=0;
		while(ix<552)
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
	}
 	if(typ==2)
 	{
 		Read();
 		var x=new Array();
 		
 		x[0]=new Array();
		x[0][0]='Age';
		x[0][1]='Weight';
		var par=0;
		var pa=0;
		var sum1 =0;
		var sum2 =0;
		while(par<39)
		{
			
			var count=0;
			var ja=1;
			while(ja<s_party[par].length)
			{
				sum1 =0;
				sum2 =0;
				var str1=maindata[s_party[par][ja]][one];
				var str2=maindata[s_party[par][ja]][two];
				if(str2.charAt(1)=='%' ||str2.charAt(2)=='%'||str2.charAt(3)=='%')
				{
					var mySplitResult2 = str2.split("%");
					str2=mySplitResult2[0];
					
				}
				if(str1.charAt(1)=='%' ||str1.charAt(2)=='%'||str1.charAt(3)=='%')
				{
					var mySplitResult2 = str1.split("%");
					str1=mySplitResult2[0];
					
				}
				if(str1=="N/A" || str2=="N/A")
				{}
				else
				{
					sum1 =sum1 + 1*str1; 
					sum2 =sum2 + 1*str2;
					count++;
				}
				
				
				ja++;
			}
			if(count==0)
			{
				
			}
			else
			{
				sum1=sum1/count;
				sum2=sum2/count;
				x[pa]=new Array();
				x[pa][0]=1*str1;
				x[pa][1]=1*str2;
				pa++;
			}
			par++;
		}
		
		importer=x;
		
 	}
 	///////////////fdsssssss
 	if(typ==3)
 	{
 		Read();
 		var x=new Array();
 		
 		x[0]=new Array();
		x[0][0]='Age';
		x[0][1]='Weight';
		var par=0;
		var pa=0;
		var sum1 =0;
		var sum2 =0;
		while(par<36)
		{
			
			var count=0;
			var ja=1;
			while(ja<s_data[par].length)
			{
				sum1 =0;
				sum2 =0;
				var str1=maindata[s_data[par][ja]][one];
				var str2=maindata[s_data[par][ja]][two];
				if(str2.charAt(1)=='%' ||str2.charAt(2)=='%'||str2.charAt(3)=='%')
				{
					var mySplitResult2 = str2.split("%");
					str2=mySplitResult2[0];
					
				}
				if(str1.charAt(1)=='%' ||str1.charAt(2)=='%'||str1.charAt(3)=='%')
				{
					var mySplitResult2 = str1.split("%");
					str1=mySplitResult2[0];
					
				}
				if(str1=="N/A" || str2=="N/A")
				{}
				else
				{
					sum1 =sum1 + 1*str1; 
					sum2 =sum2 + 1*str2;
					count++;
				}
				
				
				ja++;
			}
			if(count==0)
			{
				
			}
			else
			{
				sum1=sum1/count;
				sum2=sum2/count;
				x[pa]=new Array();
				x[pa][0]=1*str1;
				x[pa][1]=1*str2;
				pa++;
			}
			par++;
		}
		
		importer=x;
		
 	}
 	return importer;
}

var maindata = new Array();
var s_data = new Array();
var s_party = new Array();


function Read()
{
	var i=0;
    var Scr  = new ActiveXObject("Scripting.FileSystemObject");
    var CTF  = Scr .OpenTextFile("C:\\Users\\Sony\\Documents\\Workstation_Eclipse\\Ameya\\WebContent\\MPTrack.csv", 1, true);

    while(i<553)
    {
        data = CTF .ReadLine();
        var parsed = data.splitCSV();
        maindata[i]=parsed;
        i++;
    }
    CTF .Close();

    var Nos = 0;
    var lund=0;
    for(var q=1; q<553; q++)
    {
        lund=0;
        for(var w=1; w<Nos+1; w++)
        {
            if(maindata[q][4]==s_data[w-1][0])
            {
                s_data[w-1][s_data[w-1].length]=q;
                lund=1;
                break;
            }
        }
        if(lund==0)
        {
            s_data[Nos]=new Array();
            s_data[Nos][0]=maindata[q][4];
            s_data[Nos][1]=q;
            Nos++;
        }
    }

    var Nop = 0;
    lund=0;
    for(var q1=1; q1<553; q1++)
    {
        lund=0;
        for(var w1=1; w1<Nop+1; w1++)
        {
            if(maindata[q1][6]==s_party[w1-1][0])
            {
                
                s_party[w1-1][s_party[w1-1].length]=q1;
                lund=1;
                break;
            }
        }
        if(lund==0)
        {
            s_party[Nop]=new Array();
            s_party[Nop][0]=maindata[q1][6];
            s_party[Nop][1]=q1;
            Nop++;
        }
    }
    
    var use=0;
    var value=0;
    for(var z1=0;z1<39;z1++)
    {

        use=z1;
         value=s_party[z1].length;
        for(var z=z1;z<39;z++)
        {

           
            if(s_party[z].length>value)
            {
                value=s_party[z].length;
                use=z;
                
            }
        }
      
        var temp=s_party[use];
        s_party[use]=s_party[z1];
        s_party[z1]=temp;
    }
    
    
}