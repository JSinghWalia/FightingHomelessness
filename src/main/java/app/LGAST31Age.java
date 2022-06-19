package app;

public class LGAST31Age {
   private double totalNumber;
   private int totalHomelessAgeandSex;
   private double ratioHomelesstoTotalAgeandSex;



   public LGAST31Age(double totalNumber, int totalHomelessAgeandSex, double ratioHomelesstoTotalAgeandSex) {
    this.totalNumber = totalNumber;
    this.totalHomelessAgeandSex = totalHomelessAgeandSex;
    this.ratioHomelesstoTotalAgeandSex = ratioHomelesstoTotalAgeandSex;
   }



   public int getTotalHomelessAgeandSex() {
    return totalHomelessAgeandSex;
}

 public double getTotalNumber() {
        return totalNumber;
     }


     public double getRatioHomelesstoTotalAgeandSex(int totalHomelessAgeandSex,double totalNumber) {
        ratioHomelesstoTotalAgeandSex = totalHomelessAgeandSex/totalNumber;
        
        return ratioHomelesstoTotalAgeandSex;

}

}
