package work;

import java.lang.Math;
public class NandG {
   
   int exponent;
   int base;
   int gHosts = -1;
   int gSubnets = -1;
   
   
   //Constructor
   public NandG(int h, int s) {
      hostsNeeded(h);
      subnetsNeeded(s);
   }
   
   //Methods
   public int hostsNeeded(int hh) {
      base = 2;
      exponent = 2;
      while(gHosts < 0) {
         if(hh <= (Math.pow(base, exponent) -2)) {
            gHosts = (int)Math.pow(base, exponent);
         }
         exponent++;
      }
      return gHosts;
   }
   
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