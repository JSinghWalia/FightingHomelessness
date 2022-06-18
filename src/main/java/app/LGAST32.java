package app;


public class LGAST32 {
   private String name;
   private int homeless2016;
   private int homeless2018;
   private int changeHomeless;
   private int atRisk2016;
   private int atRisk2018;
   private int changeAtRisk;
   private int totalPopulation2016;
   private int totalPopulation2018;
   private int changeTotalPopulation;
   private double changeHomelessPercent;
   private double changeAtRiskPercent;
   private double changeTotalPopulationPercent;
  
   public LGAST32(String name, int homeless2016, int homeless2018, int changeHomeless, int atRisk2016, int atRisk2018, int changeAtRisk, int totalPopulation2016, int totalPopulation2018, int changeTotalPopulation, double changeHomelessPercent, double changeAtRiskPercent, double changeTotalPopulationPercent) {
      this.name = name;
      this.changeHomeless = changeHomeless;
      this.changeAtRisk = changeAtRisk;
      this.changeTotalPopulation = changeTotalPopulation;
      this.changeHomelessPercent = changeHomelessPercent;
      this.changeAtRiskPercent = changeAtRiskPercent;
      this.changeTotalPopulationPercent = changeTotalPopulationPercent;
   }

   public String getName() {
      return name;
   }

   public int get2016Homeless() {
       return homeless2016;
   }

   public int get2018Homeless() {
      return homeless2018;
  }

   public int getatRisk2016() {
   return atRisk2016;
  }

   public int getatRisk2018() {
   return atRisk2018;
  }

   public int gettotalPopulation2016() {
   return totalPopulation2016;
  }

   public int gettotalPopulation2018() {
   return totalPopulation2018;
  }

   public int getChangeHomeless(int homeless2018, int homeless2016) {
      changeHomeless = homeless2018 - homeless2016;
    return changeHomeless;
 }
 public int getChangeAtRisk(int atRisk2018, int atRisk2016) {
      changeAtRisk = atRisk2018 - atRisk2016;
    return changeAtRisk;
 }
 public int getChangeTotalPopulation(int totalPopulation2018, int totalPopulation2016) {
      changeTotalPopulation = totalPopulation2018 - totalPopulation2016;
    return changeTotalPopulation;
 }
 public double getChangeHomelessPercent(int homeless2018, int homeless2016) {
      changeHomelessPercent = ((homeless2018 - homeless2016)/(homeless2016)) * 100;
    return changeHomelessPercent;
 }
 public double getChangeAtRiskPercent(int atRisk2018, int atRisk2016) {
      changeAtRiskPercent = ((atRisk2018 - atRisk2016)/(atRisk2016)) * 100;
    return changeAtRiskPercent;
 }
 public double getChangeTotalPopulationPercent(int totalPopulation2018, int totalPopulation2016) {
      changeTotalPopulationPercent = ((totalPopulation2018 - totalPopulation2016)/(totalPopulation2016)) * 100;
    return changeTotalPopulationPercent;
 }
}