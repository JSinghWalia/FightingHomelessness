package app;


public class LGAST22 {
   private String name;
   private String state;
   private String type;
   private double area;
   private int population;
   private int lgaCode;

  
   public LGAST22(String name, String state, String type, double area, int population, int lgaCode) {
      this.name = name;
      this.state = state;
      this.type = type;
      this.area = area;
      this.population = population;
      this.lgaCode = lgaCode;
   }

   public String getName() {
      return name;
   }

public int getCode() {
   return lgaCode;
}

   public String getState(int lgaCode) {
    int firstDigit;

    int digits = (int)(Math.log10(lgaCode));
    firstDigit = (int)(lgaCode / (int)(Math.pow(10, digits)));

    if (firstDigit == 1) {
      state = "New South Wales";
    }

    else if (firstDigit == 2) {
      state = "Victoria";
    }
    else if (firstDigit == 3) {
      state = "Queensland";
    }
    else if (firstDigit == 4) {
      state = "South Australia";
    }
    else if (firstDigit == 5) {
      state = "Western Australia";
    }
    else if (firstDigit == 6) {
      state = "Tasmania";
    }
    else if (firstDigit == 7) {
      state = "Nothern Territory";
    }

    else if (firstDigit == 8) {
      state = "ACT";
    }

    else if (firstDigit == 9) {
      state = "Other Australian Territories";
    }

    else {
       state = "fix ur code lad";
    }
      return state;
 }

public int getFirstDigit(int lgaCode){
   int firstDigit;

   int digits = (int)(Math.log10(lgaCode));
   firstDigit = (int)(lgaCode / (int)(Math.pow(10, digits)));

   return firstDigit;

}

public String getType() {
    return type;
}

 public double getArea() {
    return area;
 }

public int getPopulation() {
    return population;
}

}