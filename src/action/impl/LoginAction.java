package action.impl;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import action.AbstractAction;
import domain.User;
import validator.Validator;
import validator.impl.UserValidator;

	public class LoginAction extends AbstractAction {

		@Override
		public String execute(HttpServletRequest request) {
			String paramUsername = request.getParameter("username");
			String paramPassword = request.getParameter("password");

			String page = "../login.jsp";
			User checkUser = new User(paramUsername, paramPassword);

			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) request.getServletContext().getAttribute("users");

			for (User credentials : users) {

				if (credentials.getUsername().equals(checkUser.getUsername())) {

					if (credentials.getPassword().equals(checkUser.getPassword())) {
						String token = String.valueOf(Math.random());
						HttpSession session = request.getSession();
						session.setAttribute("token", token);
						session.setAttribute("username", checkUser.getUsername());
						page = "../index.jsp";
					//	page = "/WEB-INF/pages/home.jsp";

					}

				}

			}

			checkUser.setPassword("");

			request.setAttribute("error", "Pogresan password");
			request.setAttribute("credentials", checkUser);
			
			
			
			
			
			return page;
			
		}

	}
