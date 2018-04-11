import java.util.*;
import java.io.*;
public class Container {
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		input.useDelimiter("\\D"); //Allows you to input the regular IP format instead of each octet individually
		int oct[] = new int[4];
		
		System.out.println("Enter the ip address (. excluded)");
		
		
		for(int i = 0; i < 4; i++) {
			oct[i] = input.nextInt();
		}
		input.close();
		
		
		//Printing IP
		System.out.println("Network Address:");
		for(int i = 0; i < 4; i++) {
			System.out.print(oct[i] + ".");
		}
		
		
		System.out.println("\n");
		
		//Printing IP Class
		ClassId id = new ClassId(oct[0]);
		System.out.println("Address Class: " + id.getClassId());
		
		//Printing Default Subnet Mask
		Defaults subnetMask = new Defaults(id.getClassId());
			
		int[] defaultMaskArray = subnetMask.getDefaultMask();
		System.out.println("Default Subnet Mask:");
		
		for(int i = 0; i < 4; i++) {
			System.out.print(defaultMaskArray[i] + ".");
		}
		
		//Exporting data	
		FileWriter writing = new FileWriter("test.csv");
		writing.append("testing");
		writing.close();

		
	}	
}
