package work;

public class Defaults {
	
	int bb = 0;
	int z = 0;
	int[] defaultSubnetMask = new int[4];
	
	//Contructor
	//Sending info to methods
	public Defaults(String x) {
		if(x == "A") {
			bitsborrowed("A");
			zeros("A");
		}
		else if(x == "B") {
			bitsborrowed("B");
			zeros("B");
		}
		else if(x == "C") {
			bitsborrowed("C");
			zeros("C");
		}
		
		subnetMask(x);
		
	}
	
	//Solving for default bitsborrowed
	public int bitsborrowed(String x) {
		if(x == "A") {
			bb = 8;
		}
		
		if(x == "B") {
			bb = 16;
		}
		
		if(x == "C") {
			bb = 24;
		}
		
		return bb;
	}
	
	//Solving for default zeros
	public int zeros(String x) {
		if(x == "A") {
			z = 24;
		}
		
		if(x == "B") {
			z = 16;
		}
		
		if(x == "C") {
			z = 8;
		}
		
		return z;
	}
	
				
	//===============================================================
	//NEED TO BEABLE TO PRINT OUT DEFAULT SUBNET MASK FOR EACH CLASS
	//===============================================================
	public int[] subnetMask(String x) {	
		if(x == "A") {
			defaultSubnetMask[0] = 255;
			defaultSubnetMask[1] = 0;
			defaultSubnetMask[2] = 0;
			defaultSubnetMask[3] = 0;
		}
		
		else if(x == "B") {
			defaultSubnetMask[0] = 255;
			defaultSubnetMask[1] = 255;
			defaultSubnetMask[2] = 0;
			defaultSubnetMask[3] = 0;
		}
		
		else if(x == "C") {
			defaultSubnetMask[0] = 255;
			defaultSubnetMask[1] = 255;
			defaultSubnetMask[2] = 255;
			defaultSubnetMask[3] = 0;
		}
		
		return defaultSubnetMask;
	}
	
	//Mutators
	public void setDefaultBB(int bb) {
		this.bb = bb;
	}
	public void setDefaultZ(int z) {
		this.z = z;
	}
	public void setDefaultSubnetMask(int[] defaultSubnetMask) {
		this.defaultSubnetMask = defaultSubnetMask;
	}
		
	//Accessors
	public int getDefaultBB() {
		return bb;
	}
	public int getDefaultZ() {
		return z;
	}
	public int[] getDefaultMask() {
		return defaultSubnetMask;
	}
	
}