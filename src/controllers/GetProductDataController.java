package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import crudImplementOperations.CrudImplementWaterPump;
import model.WaterPumpModel;

//@WebServlet("/API/GetProductData")
public class GetProductDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CrudImplementWaterPump crud = new CrudImplementWaterPump();
	private List<WaterPumpModel> listOfPumps = crud.getAll();

	public GetProductDataController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charet=UTF-8");
		
		buildJSON(request, response);
	}


	private void buildJSON(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer;
		writer = response.getWriter();
		
		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();

		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

		for (WaterPumpModel pumpModel : listOfPumps) {

			JsonObjectBuilder pumpBuilder = Json.createObjectBuilder();
			JsonObject pumpJson = pumpBuilder.add("id", crud.getByID(pumpModel.getId()).getId())
					.add("name_of_pump", pumpModel.getNameOfPump())
					.add("machine_capacity", pumpModel.getMachineCapacity()).add("fall", pumpModel.getFall())
					.add("quantity_of_clacks", pumpModel.getQuantityOfClacks())
					.add("power_level", pumpModel.getPowerLevel()).add("diameter", pumpModel.getDiameter())
					.add("type_of_drawing_of_water", pumpModel.getTypeOfDrawingOfWater())
					.add("mass", pumpModel.getMass()).add("input_voltage", pumpModel.getInputVoltage())
					.add("maker", pumpModel.getMaker()).add("price", pumpModel.getPrice())
					.add("status", pumpModel.isB()).add("image", pumpModel.getImage()).add("action", "").build();

			arrayBuilder.add(pumpJson);
		}

		JsonObject root = rootBuilder.add("products", arrayBuilder).build();

		writer.print(root);
		writer.flush();
		writer.close();
	}
}
