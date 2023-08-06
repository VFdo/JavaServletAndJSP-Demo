package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private UserDao userDao;

    public UserServlet() {
        super();
        userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int userId = Integer.parseInt(request.getParameter("u_id_search"));
      User existingUser = userDao.getUserById(userId);
      if(existingUser.getName() != null) {
    	  request.setAttribute("status", "true");
      } else {
    	  request.setAttribute("status", "false");
      }
      request.setAttribute("user", existingUser);
		request.getRequestDispatcher("search-user.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("u_id"));
		String userName = request.getParameter("u_name");
		boolean isActive = Boolean.valueOf(request.getParameter("isActive")); 
		boolean userAdded = userDao.addUser(userId, userName, isActive);
		if(userAdded) {
			request.setAttribute("status", "User added successfully with id : " + userId);
		} else {
			request.setAttribute("status", "User adding failed");
		}
		RequestDispatcher rd = request.getRequestDispatcher("user-added.jsp");
		rd.forward(request, response);
	}

}
