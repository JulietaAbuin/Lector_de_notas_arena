package conexion_http;


import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelo.Tarea;
import modelo.TareaHttp;

public class TareasHttpToTarea {
	public Tarea pasarATarea(TareaHttp tareaHttp) {
		Tarea tarea = new Tarea(tareaHttp.getNombre(), tareaHttp.getDescription());
		tarea.setId(tareaHttp.getId());
		String output = tareaHttp.toString();
		Type tareaType = new TypeToken<Tarea>(){}.getType();    
	 	List<Tarea> tareas = new Gson().fromJson(output,tareaType);
	 	
		for(int i=0; i< tareas.size() ; i++) {
			
		}
		
		return tarea;
		
	}

}
