package controllers;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import crudImplementOperations.CRUDuser;
import crudImplementOperations.CrudImplementWaterPump;
import model.User;
import model.WaterPumpModel;

//@WebServlet("/login")
public class VerificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CRUDuser crudUser = new CRUDuser();
	private List<User> listOfUser = crudUser.getAll();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charet=UTF-8");
		request.setCharacterEncoding("UTF-8");
				
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		
		String action = request.getParameter("action");
		int userIDbyRoleFromDB = crudUser.find(login, password);
		request.getRequestDispatcher("admin.jsp").forward(request, response);
		
	}

}
