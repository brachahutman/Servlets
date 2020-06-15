package Hw2020;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hw7Form
 */
@WebServlet("/Hw7Form")
public class Hw7Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hw7Form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType =
					"<!DOCTYPE HTML>\n";
			String title = "Fill out the form";
			String colorPicker= "<option value=\"red\">Red</option>\r\n" + 
					"		<option value=\"orange\">Orange</option>\r\n" + 
					"		<option value=\"yellow\">Yellow</option>\r\n" + 
					"		<option value=\"green\">Green</option>\r\n" + 
					"		<option value=\"blue\">Blue</option>\r\n" + 
					"		<option value=\"indigo\">Purple</option>\r\n" + 
					"		<option value=\"pink\">Pink</option>\r\n" + 
					"		<option value=\"brown\">Brown</option>\r\n";
			out.println(docType + 
					"<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title>" + title + "</title>\r\n" + 
					"		<meta charset=\"utf-8\"/>\r\n" + 
					"		<style>\r\n" + 
					"			body\r\n" + 
					"			{\r\n" + 
					"				background-color: \"08B1CF\";\r\n" + 
					"				margin-left: auto;\r\n" + 
					"				margin-right: auto;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" +
					"<form action=\"http://localhost:8080/WebServlets2020/Hw7\" method = \"post\">\r\n" + 
					//tried using a relative url for the form action but I got an error
					"	Foreground color(text color):\r\n" + 
					"	<select name=\"foregroundColor\" > \r\n" + 
					colorPicker + "		<option value=\"white\">White</option>\r\n" + 
					"		<option value=\"black\" selected>Black</option>\r\n" + 
					"	</select><br/>" +
					"Background color:\r\n" + 
					"<select name=\"backgroundColor\" >\r\n" + 
					colorPicker +"		<option value=\"white\" selected>White</option>\r\n" + 
					"		<option value=\"black\">Black</option>\r\n" + 
					"	</select><br/>"+
					"<input type=\"submit\">\r\n" + 
					"</form>\r\n" );
			out.println(
					"	</body>\r\n" + 
					"</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
