package practise.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//Fileutiles: It will scan the json file and convert that into string variable
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\practise\\data\\DataReader.java"),
				StandardCharsets.UTF_8);
		
		//Convert string to hashmap: with existing dependecies its not possible
		//It can be done through new dependecies called Jackson Databind (Add dependency for mvn repository: Jackson Databind)
		ObjectMapper mapper = new ObjectMapper();
		//We are reading the value we have create object of class as mapper (readvalue: which can read the string and convert to hashmap) 
		//In read method there are 2 arguments: first argument is the string what want to coverted into Hashmap
		//Second argument u need to tell how u want to convert it
		//There are 2 arrays present in json with 2 indexes, go and create 2 hashmap, it will create a list and it will give us back
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {});
		//What this data stores: This data is list now with 2 argument: in 1 argument it has 1st hashmap and in 2nd argument it has 2nd hashmap
		//This is what we are going to get  {{map} , {map1}} in the list here it is returning data
		return data;
		
	}
}
