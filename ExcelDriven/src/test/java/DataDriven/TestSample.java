package DataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExcelDataReturn d = new ExcelDataReturn();
		ArrayList<String> data= d.getData("MichalMike");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
	}

}
