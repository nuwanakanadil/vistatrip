<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Tour Guides List </h2>

<input type="text" id="searchInput" placeholder="search...">
<table>
<tr>
     
     <th>ID </th>
     <th>Name </th>
     <th>Email </th>
     <th>Password</th>
     <th>Phone</th>
     <th>Update</th>
     <th>Delete</th>
     
</tr>
<c:forEach var="guide" items="${alltourguides}">
<tr>
 <td>${guide.id}</td>
<td>${guide.name}</td>
<td>${guide.gmail}</td>
<td>${guide.maskedPassword}</td>
<td>${guide.phone}</td>
    
       <td>
        <a href="update.jsp?id=${guide.id}&name=${guide.name}&gmail=${guide.gmail}&password=${guide.password}&phone=${guide.phone}">
        <button>Update</button>
        </a>
        </td>
        <td></td>
        <td>
       <form action="TourGuideDeleteServlet" method="post">
        <input type= "hidden" name ="id" value="${guide.id}">
        <button>Delete</button>
        </form>
        
       
        
        
        </td>
    
     
 </tr>
 </c:forEach>
 
 

</table>
 
 <script>
function filterTable() {
    var input, filter, table, tr, td, i, j, txtValue, found;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    table = document.querySelector("table");
    tr = table.getElementsByTagName("tr");

    for (i = 1; i < tr.length; i++) { // Start from 1 if row 0 is the header
        td = tr[i].getElementsByTagName("td");
        found = false;
        for (j = 0; j < td.length; j++) {
            if (td[j]) {
                txtValue = td[j].textContent || td[j].innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    found = true;
                    break;
                }
            }
        }
        tr[i].style.display = found ? "" : "none";
    }
}

document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("searchInput").addEventListener("input", filterTable);
});
</script>
 
 



</body>
</html>