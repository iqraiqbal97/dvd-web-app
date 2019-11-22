<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="models.Dvd"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

	<h2>All DVDS</h2>

	<%
		//You can call Dvd ANYTHING
		//scriplets - java code

		ArrayList<Dvd> dvdArray = (ArrayList<Dvd>) request.getAttribute("dvds");
	%>

	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Genre</th>
				<th>Year</th>
				
				
			</tr>
		</thead>

		<tbody>
			<%
				for (Dvd dvd : dvdArray) {
					out.print("<tr> <td>" + dvd.getTitle() + "</td> <td>" + dvd.getGenre() + "</td> <td>" + dvd.getYear()
							+ "</td></tr>");
				}
			%>

		</tbody>

	</table>
</body>
</html>