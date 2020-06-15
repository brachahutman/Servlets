package Hw2020;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Hw7
 */
@WebServlet("/Hw7")
public class Hw7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hw7() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static String getValue(HttpServletRequest request, String cookieName) {
    	Cookie[]cookies=request.getCookies();
    	if (cookies != null) {
    		for (Cookie cookie: cookies) {
    			if (cookieName.contentEquals(cookie.getName())) {
    				return cookie.getValue();
    			}
    		}
    	}
    	return null;
    }
    public static String getPageText(String foreground, String background) {
		String docType =
				"<!DOCTYPE HTML>\n";
		String title = "Homework 7";
    	String docText=docType + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<title>" + title + "</title>\r\n" + 
				"		<meta charset=\"utf-8\"/>\r\n" + 
				"		<style>\r\n" + 
				"			body\r\n" + 
				"			{\r\n" + 
				"				color: " + foreground + ";\r\n"+
				"				background-color: " + background+ ";\r\n" + 
				"				margin-left: auto;\r\n" + 
				"				margin-right: auto;\r\n" + 
				"			}\r\n" + 
				"		</style>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<h1>" + title + "</h1>\r\n" + 
				"		<h4>Here is some random information:</h4>\r\n" + 
				"		<ul>\r\n" + 
				"			<li>There are eight planets.</li>\r\n" + 
				"			<li>Chocolate is made from cacao beans.</li>\r\n" + 
				"			<li>Buy low, sell high.</li>\r\n" + 
				"		</ul>\r\n" + 
				"		<a href=\"Hw7Form\">Click to change colors</a>\r\n"+
				"	</body>\r\n" + 
				"</html>";
    	return docText;

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final int COOKIE_LIFE=60*60*24*7;
		
		String foreground="black";
		String background="white";
		
		String userForeground=request.getParameter("foregroundColor");
		String userBackground=request.getParameter("backgroundColor");
		String colorChanged="no";
		
		//couldn't make it work with a relative referer value. For some reason I kept getting a 500 error
		String thisReferer= request.getHeader("referer");
		if (thisReferer != null) {
			if (thisReferer.equals("http://localhost:8080/WebServlets2020/Hw7Form")) {
				colorChanged="yes";
				System.out.println("Color has been changed. Referer is equal to Hw7Form");
			}
		}
		
		if (colorChanged=="yes") {//if sent here from the form
			foreground=userForeground;
			Cookie fground= new Cookie("foregroundCookie", userForeground);//make a cookie using input
			fground.setMaxAge(COOKIE_LIFE);
			response.addCookie(fground);
		}
		else if(getValue(request, "foregroundCookie") != null) {
			foreground=getValue(request, "foregroundCookie");
		}
				
		if (colorChanged=="yes") {
			background=userBackground;
			Cookie bground= new Cookie("backgroundCookie", userBackground);
			bground.setMaxAge(COOKIE_LIFE);
			response.addCookie(bground);
		}
		else if(getValue(request, "backgroundCookie") != null) {
			background=getValue(request, "backgroundCookie");
		}
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(getPageText(foreground, background));
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
