package app;

public class LGAST32Homeless2016 {
    private String name;
    private int homeless2016;
    private int homeless2018;
   
    public LGAST32Homeless2016(String name, int homeless2016, int homeless2018) {
        this.name = name;
        this.homeless2016 = homeless2016;
        this.homeless2018 = homeless2018;
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
 
 }