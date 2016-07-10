package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import crudImplementOperations.CrudImplementWaterPump;
import model.WaterPumpModel;

/**
 * Servlet implementation class SaveProductData
 */
@WebServlet("/API/SaveProductData")
public class SaveProductDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CrudImplementWaterPump crud = new CrudImplementWaterPump();
	private List<WaterPumpModel> listOfPumps = crud.getAll();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charet=UTF-8");
		
		parseJSON(request, response);
	}
	
	private void parseJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("APP says:  Method:  doPost(); request:  " + request);

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jb.append(line);
			}
		} catch (IOException e) {
			System.out.println("There was exception has been thrown while reading the JSON");
			e.printStackTrace();
		}
		System.out.println("APP says:  Json string has read successfully");

		JSONParser parser = new JSONParser();
		System.out.println("APP says:  JSONParser has launched");
		JSONObject objFromJSON = null;
		JSONArray productsIn = null;
		try {
			System.out.println("APP says:  JSONObject is creating where the JSONParser's object is parsing the string from json.....");
			objFromJSON = (JSONObject) parser.parse(jb.toString());

			System.out.println("APP says:  JSONArray is creating... JSONObject's object gets array from the json");
			productsIn = (JSONArray) objFromJSON.get("products");

			System.out.println(productsIn.toJSONString());
			System.out.println("APP says:  JSONArray has got successfully");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Iterator<?> it = productsIn.iterator();
		WaterPumpModel wp = null;
		String action = null;
		JSONObject pump = null;
		
		while (it.hasNext()) {
			pump = (JSONObject) it.next();
			
			int id = (int) (long) pump.get("id");
			String nameOfPump = (String) pump.get("name_of_pump");
			int machineCapacity = (int) (long) pump.get("machine_capacity");
			int fall = (int) (long) pump.get("fall");
			int quantityOfClacks = (int) (long) pump.get("quantity_of_clacks");
			int powerLevel = (int) (long) pump.get("power_level");
			double diameter = ((Number) pump.get("diameter")).doubleValue();
			String typeOfDrawingOfWater = (String) pump.get("type_of_drawing_of_water");
			double mass = ((Number) pump.get("mass")).doubleValue();
			int inputVoltage = (int) (long) pump.get("input_voltage");
			String maker = (String) pump.get("maker");
			int price = (int) (long) pump.get("price");
			boolean b = (boolean) pump.get("status");
			String image = (String) pump.get("image");
			
			action = (String) pump.get("action");

			switch (action) {
			case "":
				continue;
			case "add":
				wp = new WaterPumpModel(id, nameOfPump, machineCapacity, fall, quantityOfClacks, powerLevel, diameter, typeOfDrawingOfWater, mass, inputVoltage, maker, price, b, image);
				createNewProduct(wp);
				break;
			case "delete":
				wp = new WaterPumpModel(id, nameOfPump, machineCapacity, fall, quantityOfClacks, powerLevel, diameter, typeOfDrawingOfWater, mass, inputVoltage, maker, price, b, image);
				deleteProduct(wp);
				break;
			case "update":
				wp = new WaterPumpModel(id, nameOfPump, machineCapacity, fall, quantityOfClacks, powerLevel, diameter, typeOfDrawingOfWater, mass, inputVoltage, maker, price, b, image);
				updateProduct(wp);
				break;
			default:
				break;
			}
		}
	}
	

	private void createNewProduct(WaterPumpModel wp) {
		System.out.println("APP says:  This product will be created:");
		System.out.println("product id" + wp.getId() + ", product name " + wp.getNameOfPump());
		crud.create(wp);
		crud.getAll();
	}
	
	private void updateProduct(WaterPumpModel wp) {
		System.out.println("APP says:  This product will be updated:");
		System.out.println("product id" + wp.getId() + ", product name " + wp.getNameOfPump());
		crud.update(wp);
		System.out.println(crud.getAll());
	}

	private void deleteProduct(WaterPumpModel wp) {
		System.out.println("APP says:  This product will be deleted:");
		System.out.println("product id" + wp.getId() + ", product name " + wp.getNameOfPump());
		crud.delete(wp);
		System.out.println(crud.getAll());
	}	
}
