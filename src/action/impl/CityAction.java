package action.impl;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import domain.City;
import validator.Validator;
import validator.impl.CityValidator;
import validator.impl.UserValidator;

public class CityAction extends AbstractAction {
	private static Validator validator = new CityValidator();

	@Override
	public String execute(HttpServletRequest request) {
		String page = "";
		System.out.println("oper"+request.getParameter("operation"));
		if (request.getParameter("operation").equals("allCities")) {
			page = "/WEB-INF/pages/allcity.jsp";
		} else if (request.getParameter("operation").equals("NewCity")) {
			page = "/WEB-INF/pages/newcity.jsp";
		} else if (request.getParameter("operation").equals("back")) {
			page = "/WEB-INF/pages/home.jsp";
		} else if (request.getParameter("operation").equals("edit")) {
			page = "/WEB-INF/pages/edit.jsp";
		} else if (request.getParameter("operation").equals("remove")) {
			page = removeCity(request);
		} else if (request.getParameter("operation").equals("addCity")) {
			page = saveCity(request);
		} else if (request.getParameter("operation").equals("Save")) {
			page = saveCity(request);
		} else if (request.getParameter("operation").equalsIgnoreCase("editcity")){
			page = editCity(request);
		}
		return page;
	}

	public String removeCity(HttpServletRequest request) {
		String message = "";
		List<City> cities = (List<City>) request.getServletContext().getAttribute("cities");
		String ptt = (String) request.getParameter("ptt");
		City city = new City(ptt);
		cities.remove(city);
		if (cities.isEmpty()) {
			message = "List of cities is empty";
		}
		request.setAttribute("listIsEmpty", message);
		request.getServletContext().setAttribute("cities", cities);
		String page = "/WEB-INF/pages/allcity.jsp";
		return page;
	}
	public String saveCity(HttpServletRequest request) {
		String ptt = request.getParameter("number");
		String name = request.getParameter("name");
		String page = "";
		System.out.println("ptt"+"-----"+name);
		List<City> cities = (List<City>) request.getServletContext().getAttribute("cities");
		try {
			City city = new City(ptt, name);
			validator.validateObject(city);
			if (cities.contains(city)) {
				request.setAttribute("validationError", "City already exists!");
				page = "/WEB-INF/pages/allcity.jsp";
			} else {
				cities.add(city);
				page = "home";
			}
			return page;
		} catch (Exception e) {
			request.setAttribute("validationError", e.getMessage());
			page = "/WEB-INF/pages/allcity.jsp";
			return page;
		}

	}

	public String editCity(HttpServletRequest request) {
		String name = (String) request.getParameter("name");
		String ptt = (String) request.getParameter("number");
		System.out.println("name"+name+"ptt"+ptt);
		List<City> cities = (List<City>) request.getServletContext().getAttribute("cities");
		for (City c : cities) {
			if (c.getPtt().equals(ptt.trim()))
				c.setName(name);
		}
		request.getServletContext().setAttribute("cities", cities);
		String page = "city?operation=allCities";
		return page;
	}
}