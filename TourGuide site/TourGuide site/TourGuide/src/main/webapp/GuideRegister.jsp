<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tour Guide Register</title>
    <link rel="stylesheet" type="text/css" href="CSS/GuideRegister.css">


</head>
<body>
   <h2>Tour Guide Register </h2>
    <form action="NewTourGuideInsertServlet" method="post">
        <table>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><input type="text" id="name" name="name" required></td>
            </tr>
            <tr>
                <td><label for="gmail">Email:</label></td>
                <td><input type="email" id="gmail" name="gmail"  required></td>
            </tr>
            <tr>
                <td><label for="password">Password:</label></td>
                <td><input type="password" id="password" name="password" required></td>
            </tr>
            <tr>
                <td><label for="phone">Phone:</label></td>
                <td><input type="text" id="phone" name="phone" required></td>
            </tr>
          
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Register">
                </td>
            </tr>
        </table>
    </form>
   
</body>
</html>