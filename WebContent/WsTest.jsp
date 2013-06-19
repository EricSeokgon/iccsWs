<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="sp.webservice.*" %>
<%@ page import="sp.webservice.xsd.*" %>
<%@ page import="kjf.util.*" %>
<html>
<head>
<title>smsTest </title>
</head>
<body>
<%
String sql="select * from pt_user";
WsAgentPortTypeProxy wsAgent= new WsAgentPortTypeProxy();
WsData wsData= wsAgent.select(sql);


String data= wsData.getData();
String list[] =KJFUtil.str2strs(data, "!#$");


for(int i=0; i< list.length;i++){
	
	String attrs[]=list[i].split("\t", wsData.getFieldCnt());
	System.out.println(list[i]);
	for(int j=0;j< attrs.length ;j++ ){
	
		out.println(attrs[j]+" ||");
	}
	out.println("<br>");
};

//for(int i=0.; i< wsData.length;i++){		
//	for(int j=0; j< rEntity.getFieldCnt()-1;j++ ){
		
//		rtData[i][j]=rEntity.getValue(i,j);
		
//		if((j+1)== rEntity.getFieldCnt()-1) {      							
//			//result[1] += rEntity.getValue(i,j)+"!#$";				
//		} else {
//			//result[1] += rEntity.getValue(i,j)+"\t";
//		}	
		
//	}
//}



%>



 
</body>	
</html>

