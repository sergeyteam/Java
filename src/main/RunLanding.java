package main;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.json.simple.JSONObject;

import crudImplementOperations.CrudImplementWaterPump;
import model.WaterPumpModel;

public class RunLanding {

	public static void main(String[] args) {
		
		CrudImplementWaterPump crud = new CrudImplementWaterPump();
		
		WaterPumpModel pump1 = new WaterPumpModel(1, "\"Водограй\" БВ-0,12 -40", 6, 50, 1, 220, 100., "верхний", 3.80, 220, "Украина, Харьков", 335, true, "");
		WaterPumpModel pump2 = new WaterPumpModel(2, "\"Ручеек\" БВ-0,12 -40", 7, 40, 1, 260, 100., "верхний", 3.40, 220, "Украина, Харьков", 340, true, "");
		WaterPumpModel pump3 = new WaterPumpModel(2, "\"Ручеек\" БВ-0,12 -40", 7, 40, 1, 260, 100., "нижний", 3.40, 220, "Украина, Харьков", 350, true, "");
		WaterPumpModel pump4 = new WaterPumpModel(2, "\"Малыш\" БВ-0,1 -63", 6, 63, 1, 230, 100., "верхний", 3.10, 220, "Украина, Харьков", 350, true, "");
		WaterPumpModel pump5 = new WaterPumpModel(2, "\"Малыш-бриз\" БВ-0,1 -63", 6, 63, 1, 230, 100., "нижний", 3.10, 220, "Украина, Харьков", 350, true, "");
		WaterPumpModel pump6 = new WaterPumpModel(2, "\"Урожай\" БВ-0,2 -40", 12, 80, 2, 350, 100., "верхний", 3.40, 220, "Украина, Харьков", 355, true, "");
		WaterPumpModel pump7 = new WaterPumpModel(2, "\"Урожай\" БВ-0,2 -40", 12, 80, 2, 350, 100., "нижний", 3.40, 220, "Украина, Харьков", 355, true, "");
		WaterPumpModel pump8 = new WaterPumpModel(2, "\"Гейзер\" БВ-0,15 -63", 9, 80, 2, 350, 100., "нижний", 3.40, 220, "Украина, Харьков", 370, true, "");
		WaterPumpModel pump9 = new WaterPumpModel(2, "\"Дачник\" БВ-0,12 -50", 9, 60, 1, 240, 100., "верхний", 3.60, 220, "Украина, Харьков", 370, true, "");
		WaterPumpModel pump10 = new WaterPumpModel(2, "\"Фонтан\" БВ-0,2 -40", 12, 80, 3, 350, 100., "нижний", 3.40, 220, "Украина, Харьков", 380, true, "");
		WaterPumpModel pump11 = new WaterPumpModel(2, "\"Дачник-2\" БВ-0,12 -50", 9, 70, 2, 240, 100., "верхний", 3.60, 220, "Украина, Харьков", 385, true, "");
		WaterPumpModel pump12 = new WaterPumpModel(2, "\"Скат-3\" БВ-0,1 -40", 6, 70, 3, 300, 100., "верхний", 3.75, 220, "Украина, Киев", 450, true, "");
		WaterPumpModel pump13 = new WaterPumpModel(2, "\"Каштан-2п\" БВ-0,12 -40", 7, 40, 2, 180, 100., "верхний", 3.80, 220, "Украина, Киев", 460, true, "");
		WaterPumpModel pump14 = new WaterPumpModel(2, "\"Водолей\" БВ-0,1 -63", 6, 63, 1, 220, 100., "верхний", 3.15, 220, "Украина, Винница", 520, true, "");
		WaterPumpModel pump15 = new WaterPumpModel(2, "\"Акула\" БВ-0,2 -40", 12, 75, 2, 300, 100., "нижний", 3.75, 220, "Украина, Киев", 530, true, "");
		WaterPumpModel pump16 = new WaterPumpModel(2, "Водолей \"Алфей\" БВ-0,1 -40", 6, 40, 1, 150, 86., "нижний", 2.25, 220, "Украина, Винница", 535, true, "");
		WaterPumpModel pump17 = new WaterPumpModel(2, "Босна Ел Джі \"Цвиркун\" БВ-0,16 -30", 15, 50, 1, 220, 86., "нижний", 3.00, 220, "Украина, Киев", 545, true, "");
		WaterPumpModel pump18 = new WaterPumpModel(2, "Босна Ел Джі \"Тайфун-2\" БВ-0,25 -40", 15, 90, 2, 300, 100., "нижний", 4.00, 220, "Украина, Киев", 565, true, "");
		WaterPumpModel pump19 = new WaterPumpModel(2, "Водолей БВ-0,14 -63", 8, 63, 2, 320, 100., "верхний", 3.50, 220, "Украина, Винница", 565, false, "");
		WaterPumpModel pump20 = new WaterPumpModel(2, " Водолей \"Посейдон\" БВ-0,14 -63", 9, 63, 4, 320, 100., "верхний", 3.80, 220, "Украина, Винница", 610, false, "");
		
//		crud.create(pump1);
//		crud.create(pump2);
//		crud.create(pump3);
//		crud.create(pump4);
//		crud.create(pump5);
//		crud.create(pump6);
//		crud.create(pump7);
//		crud.create(pump8);
//		crud.create(pump9);
//		crud.create(pump10);
//		crud.create(pump11);
//		crud.create(pump12);
//		crud.create(pump13);
//		crud.create(pump14);
//		crud.create(pump15);
//		crud.create(pump16);
//		crud.create(pump17);
//		crud.create(pump18);
//		crud.create(pump19);
//		crud.create(pump20);
//		System.out.println(crud.getAll());
//		System.out.println(crud.getByID(pump.getId()));
//		System.out.println(crud.update(pumpUpdate ));
//		System.out.println(crud.delete(pump));
		
//		 JSONObject obj = new JSONObject();
//
//	    
//
//	      List<WaterPumpModel> listOfPumps = crud.getAll();
//	      obj.put("list", listOfPumps);
//	      
//	      StringWriter out = new StringWriter();
//	      try {
//			obj.writeJSONString(out);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	      
//	      String jsonText = out.toString();
//	      System.out.print(jsonText);
	}
	
}
