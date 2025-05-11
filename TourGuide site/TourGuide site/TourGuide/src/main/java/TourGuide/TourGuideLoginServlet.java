package TourGuide;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TourGuideLoginServlet")
public class TourGuideLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gmail = request.getParameter("gmail");
		String password = request.getParameter("password");
 
		
		try {
			List<TourGuideModel> tourguidelogin = TourGuideController.loginValidate(gmail , password);
			if(tourguidelogin != null && ! tourguidelogin.isEmpty()) {
			   
				request.getSession().setAttribute("Tour Guide",tourguidelogin.get(0));
				response.sendRedirect("GetAllTourGuides");
				

				
			}
			else {
				
				String alertMessage = "Invalid Credentials,please try again";
				response.getWriter().println("<script>alert('"+alertMessage+"');window.location.href='login.jsp'</script>");
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	
	}

}
