package work;

import java.lang.Math;
public class NandG {
   
   int exponent;
   int base;
   int gHosts = -1;
   int gSubnets = -1;
   
   
   //Constructor
   public NandG(int x, int y) {
      hostsNeeded(x);
      subnetsNeeded(y);
   }
   
   //Methods
   public int hostsNeeded(int xx) {
      base = 2;
      exponent = 2;
      while(gHosts < 0) {
         if(xx <= (Math.pow(base, exponent) -2)) {
            gHosts = (int)Math.pow(base, exponent);
         }
         exponent++;
      }
      return gHosts;
   }
   
   public int subnetsNeeded(int yy) {
      base = 2;
      exponent = 2;
      while(gSubnets < 0) {
         if(yy <= (Math.pow(base, exponent))) {
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
   
}