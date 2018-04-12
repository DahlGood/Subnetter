import java.util.*;
import java.io.*;
public class Container {
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		input.useDelimiter("\\D"); //Allows you to input the regular IP format instead of each octet individually
		int oct[] = new int[4];
      int nHosts = 0;
      int nSubnets = 0;
		
		System.out.println("Enter the ip address (. excluded)");
		
		
		for(int i = 0; i < 4; i++) {
			oct[i] = input.nextInt();
		}
      
      
      Scanner second = new Scanner(System.in);
      System.out.println("Enter Hosts Needed: ");
      nHosts = second.nextInt();
      
      System.out.println("Enter Subnets Needed: ");
      nSubnets = second.nextInt();
      
      
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
      
      System.out.println("\n");
      
      //Printing Given / Needed Subnets and Hosts
      NandG gan = new NandG(nHosts, nSubnets);
      System.out.println("Needed Hosts:");
      System.out.println(nHosts);
      System.out.println("Needed Subnets:");
      System.out.println(nSubnets);
      
      System.out.println("");
      
      System.out.println("Usable Hosts:");
      System.out.println((gan.getGHosts() -2));
      System.out.println("Usable Subnets:");
      System.out.println(gan.getGHosts());
		
		//Exporting data	
		FileWriter writing = new FileWriter("test.csv");
		writing.append("testing");
		writing.close();

		input.close();
		second.close();
	}	
}