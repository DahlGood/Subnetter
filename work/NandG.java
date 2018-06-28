package work;

import java.lang.Math;
public class NandG {
	
    int exponent;
    int base;
    int gHosts = -1;
    int gSubnets = -1;
    int hExp = 2;
   
   
    //Constructor
    public NandG(int h, int s, int dZ, int dB) {
    	
    	//Case of both.
    	if(h > 0 && s > 0) {
    		hostsNeeded(h);
        	subnetsNeeded(s);
    	}
    	
    	else if(h == 0 && s > 0 ) {
    		subnetsNeeded(s);
    		int zeros = dZ - getBB();
    		gHosts = (int)Math.pow(2, zeros);
    	}
    	
    	else if(h > 0 && s == 0) {
    		hostsNeeded(h);
    		int ones = dZ - hExp;
    		gSubnets = (int)Math.pow(2, ones);
    	}
   }
   
    //Methods
    //Getting Hosts.
    public int hostsNeeded(int hh) {
    	base = 2;
        exponent = 2;
        
        while(gHosts < 0) {
        	if(hh <= (Math.pow(base, exponent) -2)) {
        		gHosts = (int)Math.pow(base, exponent);
        	}
        	exponent++;
        	hExp = exponent-1;
        }
        return gHosts;
        
    }
    
    //Getting Subnets.
    public int subnetsNeeded(int ss) {
    	base = 2;
        exponent = 2;
        while(gSubnets < 0) {
        	if(ss <= (Math.pow(base, exponent))) {
        		gSubnets = (int)Math.pow(base, exponent);
        	}
        	exponent++;
        }
        return gSubnets;
    }
    
    //Calculating Hosts When Only Subnets Are Present.
    public int hostCalc(int ss, int b) {
    	
    	return ss;
    }
    
    //Calculating Subnets When Only Hosts Are Present.
    public int subnetCalc(int hh, int z) {
    	
    	return hh;
    }
   
    //Mutators
    public void setGHosts(int gHosts) {
    	this.gHosts = gHosts;
    }
   
    public void setGSubnets(int gSubnets) {
    	this.gSubnets = gSubnets;
    }
   
    //Accessors
    public int getGHosts() {
    	return gHosts;
    }
    
    public int getGSubnets() {
    	return gSubnets;
    }
   
    public int getBB() {
    	return exponent-1;
    }
   
}