package crudImplementOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import crudDaoINTERFACE.CRUDintarface;
import main.ConnectTo;
import model.WaterPumpModel;

public class CrudImplementWaterPump implements CRUDintarface<WaterPumpModel> {

	private final static String SQL_CREATE = "INSERT INTO dbdf16c637ec3145c394a3a5d500dc2cd1.water_pumps VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
	private final static String SQL_GET_ALL = "SELECT * FROM dbdf16c637ec3145c394a3a5d500dc2cd1.water_pumps";
	private final static String SQL_GET_BY_ID = "SELECT * FROM dbdf16c637ec3145c394a3a5d500dc2cd1.water_pumps WHERE id=?";
	private final static String SQL_UPDATE = "UPDATE dbdf16c637ec3145c394a3a5d500dc2cd1.water_pumps SET name_of_pump=?, machine_capacity=?, fall=?, quantity_of_clacks=?, power_level=?, diameter=?, type_of_drawing_of_water=?, mass=?, input_voltage=?, maker=?, price=?, status=?, image=? WHERE id=?";
	private final static String SQL_DELETE = "DELETE FROM dbdf16c637ec3145c394a3a5d500dc2cd1.water_pumps WHERE id=?";
	/*
	1	id,              int id      
	2	name_of_pump,      String nameOfPump
	3	machine_capacity,   int machineCapacity
	4	fall,              	int fall
	5	quantity_of_clacks,    int quantityOfClacks
	6	power_level,    	 	int powerLevel
	7	diameter,       			 double diameter
	8	type_of_drawing_of_water,    String typeOfDrawingOfWater    
	9	mass,            		 	double mass
	10	input_voltage,   	 int inputVoltage
	11  maker,          	 String maker
	12	price,           int price
		
	*/
	
	
	@Override
	public WaterPumpModel create(WaterPumpModel pump) {
		Connection conn = ConnectTo.getConnection();
		PreparedStatement pstat;
		ResultSet rs;
		try{
			pstat = conn.prepareStatement("SET NAMES 'utf8'");
			pstat = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
			pstat.setString(1, pump.getNameOfPump());
			pstat.setInt(2, pump.getMachineCapacity());
			pstat.setInt(3, pump.getFall());
			pstat.setInt(4, pump.getQuantityOfClacks());
			pstat.setInt(5, pump.getPowerLevel());
			pstat.setDouble(6, pump.getDiameter());
			pstat.setString(7, pump.getTypeOfDrawingOfWater());
			pstat.setDouble(8, pump.getMass());
			pstat.setInt(9, pump.getInputVoltage());
			pstat.setString(10, pump.getMaker());
			pstat.setInt(11, pump.getPrice());
			pstat.setBoolean(12, pump.isB());
			pstat.setString(13, pump.getImage());
			pstat.executeUpdate();
			rs = pstat.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			pump.setId(id);
			rs.close();
			pstat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pump;
	}

	@Override
	public List<WaterPumpModel> getAll() {
		Connection conn = ConnectTo.getConnection();
		WaterPumpModel pump = null;
		List<WaterPumpModel> listOfPumps = new ArrayList<>();
		ResultSet rs;
		try (Statement st = conn.createStatement()){
			rs = st.executeQuery(SQL_GET_ALL);
			while (rs.next()) {
				pump = new WaterPumpModel();
				pump.setId(rs.getInt(1));
				pump.setNameOfPump(rs.getString(2));
				pump.setMachineCapacity(rs.getInt(3));
				pump.setFall(rs.getInt(4));
				pump.setQuantityOfClacks(rs.getInt(5));
				pump.setPowerLevel(rs.getInt(6));
				pump.setDiameter(rs.getDouble(7));
				pump.setTypeOfDrawingOfWater(rs.getString(8));
				pump.setMass(rs.getDouble(9));
				pump.setInputVoltage(rs.getInt(10));
				pump.setMaker(rs.getString(11));
				pump.setPrice(rs.getInt(12));
				pump.setB(rs.getBoolean(13));
				pump.setImage(rs.getString(14));
				listOfPumps.add(pump);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfPumps;
	}

	@Override
	public WaterPumpModel getByID(int id) {
		Connection conn = ConnectTo.getConnection();
		ResultSet rs;
		WaterPumpModel pump = null;
		try (PreparedStatement ps = conn.prepareStatement(SQL_GET_BY_ID)){
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String nameOfPump = rs.getString(2);
				int machineCapacity = rs.getInt(3);
				int fall = rs.getInt(4);
				int quantityOfClacks = rs.getInt(5);
				int powerLevel = rs.getInt(6);
				double diameter = rs.getDouble(7);
				String typeOfDrawingOfWater = rs.getString(8);
				double mass = rs.getDouble(9);
				int inputVoltage = rs.getInt(10);
				String maker = rs.getString(11);
				int price = rs.getInt(12);
				boolean b = rs.getBoolean(13);
				String image = rs.getString(14);
				
				pump = new WaterPumpModel();
				pump.setId(id);
				pump.setNameOfPump(nameOfPump);
				pump.setMachineCapacity(machineCapacity);
				pump.setFall(fall);
				pump.setQuantityOfClacks(quantityOfClacks);
				pump.setPowerLevel(powerLevel);
				pump.setDiameter(diameter);
				pump.setTypeOfDrawingOfWater(typeOfDrawingOfWater);
				pump.setMass(mass);
				pump.setInputVoltage(inputVoltage);
				pump.setMaker(maker);
				pump.setPrice(price);
				pump.setB(b);
				pump.setImage(image);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pump;
	}

	@Override
	public boolean update(WaterPumpModel pump) {
		Connection conn = ConnectTo.getConnection();
		int count = 0;
		try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {
			ps.setString(1, pump.getNameOfPump());
			ps.setInt(2, pump.getMachineCapacity());
			ps.setInt(3, pump.getFall());
			ps.setInt(4, pump.getQuantityOfClacks());
			ps.setInt(5, pump.getPowerLevel());
			ps.setDouble(6, pump.getDiameter());
			ps.setString(7, pump.getTypeOfDrawingOfWater());
			ps.setDouble(8, pump.getMass());
			ps.setInt(9, pump.getInputVoltage());
			ps.setString(10, pump.getMaker());
			ps.setInt(11, pump.getPrice());
			ps.setBoolean(12, pump.isB());
			ps.setString(13, pump.getImage());
			ps.setInt(14, pump.getId());
			count = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count>0?true:false;
	}
	
	

	@Override
	public boolean delete(WaterPumpModel pump) {
		Connection conn = ConnectTo.getConnection();
		int count = 0;
		try (PreparedStatement ps = conn.prepareStatement(SQL_DELETE)){
			ps.setInt(1, pump.getId());
			count = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count>0?true:false;
	}
	
	
	public List<String> getAllImagesURL() {
		Connection conn = ConnectTo.getConnection();
		WaterPumpModel pump = null;
		List<String> allURLs = new ArrayList<>();
		ResultSet rs;
		try (Statement st = conn.createStatement()){
			rs = st.executeQuery(SQL_GET_ALL);
			while (rs.next()) {
				String url = rs.getString("image");
				allURLs.add(url);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allURLs;
	}

}
