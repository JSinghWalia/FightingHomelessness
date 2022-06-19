package app;

public class LGAST31 {
    private String name;
   private int totalHomeless;
   private double totalNumber;
   private double ratioHomelesstoTotal;
   private int weeklyIncome;
   private int medianAge;
   private int mortgageRepay;
   private int rentWeekly;


public LGAST31(String name, int totalHomeless, double totalNumber, double ratioHomelesstoTotal, int weeklyIncome, int medianAge, int mortgageRepay, int rentWeekly) {
    this.name = name;
    this.totalHomeless = totalHomeless;
    this.totalNumber = totalNumber;
    this.ratioHomelesstoTotal = ratioHomelesstoTotal;
    this.weeklyIncome = weeklyIncome;
    this.medianAge = medianAge;
    this.mortgageRepay = mortgageRepay;
    this.rentWeekly = rentWeekly;


}


public String getName() {
    return name;
 }

 public int getTotalHomeless() {
     return totalHomeless;
 }

 

 public double getTotalNumber() {
        return totalNumber;
     }



public double getRatioHomelesstoTotal(int totalHomeless,double totalNumber) {
        ratioHomelesstoTotal = totalHomeless/totalNumber;
        
        return ratioHomelesstoTotal;

}

public int getWeeklyIncome(){
    return weeklyIncome;
}

public int getMedianAge(){
    return medianAge;
}

public int getMortgageRepay(){
    return mortgageRepay;
}

public int getRentWeekly(){
    return rentWeekly;
}

}