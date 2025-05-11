package TourGuide;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TourGuideUpdateServlet")
public class TourGuideUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String name= request.getParameter("name");
		String gmail= request.getParameter("gmail");
		String password= request.getParameter("password");
		String phone= request.getParameter("phone");

		
		boolean isTrue;
		isTrue = TourGuideController.updatedata(id,name,gmail,password,phone);
		
		if(isTrue==true) {
			List<TourGuideModel> guides = TourGuideController.getById(id);
			request.setAttribute("tourguides", guides);
			
			String alertMessage = "Data Update Successful";
			response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='GetAllTourGuides'</script>");
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
		    dis2.forward(request, response);
		}

		
	}

}
