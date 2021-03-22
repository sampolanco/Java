package ejemplosJackson.fromObjectToJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Alumno;

public class Main {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		Alumno alumno = new Alumno();
		try {
			String jsonAlumno = objectMapper.writeValueAsString(alumno);
			System.out.println(jsonAlumno);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		//Car car = objectMapper.readValue(json, Car.class);
	}

}
