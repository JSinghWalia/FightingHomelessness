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
   public int getChangeHomeless() {
    return changeHomeless;
 }
 public int getChangeAtRisk() {
    return changeAtRisk;
 }
 public int getChangeTotalPopulation() {
    return changeTotalPopulation;
 }
 public double getChangeHomelessPercent() {
    return changeHomelessPercent;
 }
 public double getChangeAtRiskPercent() {
    return changeAtRiskPercent;
 }
 public double getChangeTotalPopulationPercent() {
    return changeTotalPopulationPercent;
 }
}