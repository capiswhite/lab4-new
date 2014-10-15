<%@ page language="java" import="java.util.*,lab2.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	 <br>
  <table width="200" border="0" align="center" height="100">
    <tr>
      <td colspan="6"><strong>查询作者</strong></td>
    </tr>
    <tr>
      <td align="left" width="200"> <form  name="form" method="post" action="querybook"> 
      	<input type="text" name="name">
      	<input type="submit"  value="查询" ></form></td>
      	
    </tr>
  </table>
  </body>
</html>