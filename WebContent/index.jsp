<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%
        String message = "";
        String etat = "" ;
        int cpt = 0;
    if(request.getAttribute("msg") != null){
    	cpt = Integer.parseInt(request.getAttribute("cpt").toString());
    	message = request.getAttribute("msg").toString()+"<br>"+" la "+cpt+" tentative!";
    	if(cpt>3){
    		etat = "disabled";
    	}
    	
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="serve2" method="post">
	    <table>
	    <tr>
	       <td> Login :</td>
	       <td><input type="email" name="login"></td>
	    </tr>
	     <tr>
	       <td> Password :</td>
	       <td><input type="password" name="password"></td>
	    </tr>
	    </table>
	    <input type="submit" value="S'authentifier"  <%=etat%>>
    </form>
    <%=message%>
</body>
</html>