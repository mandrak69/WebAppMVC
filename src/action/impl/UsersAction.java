package action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import domain.City;
import domain.User;
import validator.Validator;
import validator.impl.CityValidator;
import validator.impl.UserValidator;

public class UsersAction extends AbstractAction {
	private static Validator validator = new UserValidator();
	@Override
	public String execute(HttpServletRequest request) {
		String page = "";
		if (request.getParameter("operation").equals("allUsers")) {
			page = "../allUsers.jsp";
		} else if (request.getParameter("operation").equals("addUser")) {
			page = "../addNewUser.jsp";
		} else if (request.getParameter("operation").equals("login")) {
			request.getSession().invalidate();
			page = "../login.jsp";
		}else if (request.getParameter("operation").equals("saveUser")) {
			page = saveUser(request);
		} else if (request.getParameter("operation").equals("Save")) {
			page = saveUser(request);
		}
		else if (request.getParameter("operation").equals("back")) {
			page = "../index.jsp";
		}
		return page;
	}
		public String saveUser(HttpServletRequest request) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String page = "";
			System.out.println("username"+"-----"+username);
			List<User> users = (List<User>) request.getServletContext().getAttribute("users");
			try {
				User user = new User(username,password);
				validator.validateObject(user);
				if (users.contains(user)) {
					request.setAttribute("validationError", "User already exists!");
					page = "/WEB-INF/pages/allUsers.jsp";
				} else {
					users.add(user);
					page = "../index.jsp";
				}
				return page;
			} catch (Exception e) {
				request.setAttribute("validationError", e.getMessage());
				page = "/WEB-INF/pages/allUsers.jsp";
				return page;
			}

		}
}
