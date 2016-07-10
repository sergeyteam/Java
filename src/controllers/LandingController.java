package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import crudImplementOperations.CrudImplementWaterPump;
import model.WaterPumpModel;

/**
 * Servlet implementation class LandingController
 */
//@WebServlet("/page/*")
public class LandingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CrudImplementWaterPump crudPump = new CrudImplementWaterPump();
	List<WaterPumpModel> listOfProductes = crudPump.getAll();
   
    public LandingController() { }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		request.setAttribute("products", listOfProductes);
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		
	
	}

	

}
