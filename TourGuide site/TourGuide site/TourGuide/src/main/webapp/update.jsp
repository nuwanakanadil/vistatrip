<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   String id = request.getParameter("id");
   String name = request.getParameter("name");
   String gmail = request.getParameter("gmail");
   String password = request.getParameter("password");
   String phone = request.getParameter("phone");
 
%>

    <form action="TourGuideUpdateServlet" method="post">
        <table>
               <tr>
                <td><label for="id">ID:</label></td>
                <td><input type="text" id="id" name="id" value="<%=id%>" readonly></td>
            </tr>
        
            <tr>
                <td><label for="name">Name:</label></td>
                <td><input type="text" id="name" name="name" value="<%=name%>" required></td>
            </tr>
            <tr>
                <td><label for="gmail">Email:</label></td>
                <td><input type="email" id="gmail" name="gmail" value="<%=gmail%>" required></td>
            </tr>
            <tr>
                <td><label for="password">Password:</label></td>
                <td><input type="password" id="password" name="password" value="<%=password%>" required></td>
            </tr>
            <tr>
                <td><label for="phone">Phone:</label></td>
                <td><input type="text" id="phone" name="phone" value="<%=phone%>" required></td>
            </tr>
          
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </form>
 


</body>
</html>