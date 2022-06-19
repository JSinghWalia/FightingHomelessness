package app;

import java.time.Year;
import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageST22 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page4.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>LGA Information</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
         html = html + """
            <div class='topnav'>
            <a href='/'><img src="weblogoblack.png" class="navimage" alt="fighting homelessness logo"></a>
                <a href='mission.html'>Our Mission</a>
                <a href='page3.html'>LGA Rankings</a>
                <a href='page4.html'>LGA Information</a>
                <a href='page5.html'>Rate of Homelessness</a>
                <a href='page6.html'>Change in Homelessness over time</a>
            </div>
        """;

        // Add header content block
        html = html + """
            <div class="header4">
                <div class="header-text">
                    <h1>
                        LGA Information
                    </h1>
                </div>
            </div>
        """;

       // Add Div for page Content
       html = html + "<div class='content'>";

       // Look up some information from JDBC
       // First we need to use your JDBCConnection class
       JDBCConnection jdbc = new JDBCConnection();

       // Next we will ask this *class* for the LGAs
       ArrayList<LGA> lgas = jdbc.getLGAs();
       html = html + "<form action='/page4.html' method='post'>";
      
      
       html = html +"<label for='LGA'>Choose your LGA from the list:</label>" +
       "<input list='LGAS' name='LGA' id='LGA'>" +
       "<datalist id= 'LGAS'>";
               
       for (LGA lga : lgas) {
           html = html + "<option value ='" + lga.getName16() + "'>";
       }
       html = html + "</datalist>";
      



    //ArrayList<String> ageRange = jdbc.getAgeRange();
    html = html + "     <div class='form-group'>";
    html = html + "     <label for='agerange_drop'>Select the age range (Dropdown):</label>";
        html = html + "      <select id='agerange_drop' name='agerange_drop'>";
        //Add options through database
        
        
        // Add HTML for the movies list
        html = html + "<option>" + "All" + "</option>" +
        "<option value = '0_9'>" + "0-9" + "</option>"
       + "<option value = '10_19'>" + "10-19" + "</option>"
       + "<option value = '20_29'>" + "20-29" + "</option>"
       + "<option value = '30_39'>" + "30-39" + "</option>"
        +"<option value = '40_49'>" + "40-49" + "</option>"
        +"<option value = '50_59'>" + "50-59" + "</option>"
        +"<option value = '60_plus'>" + "60+" + "</option>";

        
        // Potential database
        //for (String ageGroup : ageRange) {
          //  html = html + "<option>" + ageGroup + "</option>";
        //}
        
        html = html + "      </select>";
        html = html + "   </div>";


        // sex options from database

        //ArrayList<String> sexes = jdbc.getSex();
        html = html + "     <div class='form-group'>";
        html = html + "      <label for='sex_drop'>Select the sex (Dropdown):</label>";
            html = html + "      <select id='sex_drop' name='sex_drop'>";
            //Add options through database
            
            
            // Add HTML for the sexes list
            
            //for (String sex : sexes) {
              //  html = html + "<option>" + sex + "</option>";
            //}
            html = html + "<option>" + "All" + "</option>";
            html = html +  "<option value = 'm'>" + "Male" + "</option>";
            html = html +  "<option value = 'f'>" + "Female" + "</option>";
            
            html = html + "      </select>";
            html = html + "   </div>";


            html = html + "     <div class='form-group'>";
            html = html + "     <label for='year_drop'>Select the year to view (Dropdown):</label>";
            html = html + "      <select id='year_drop' name='year_drop'>";
            html = html +  "<option value = '2016'>" + "2016" + "</option>";
            html = html +  "<option value = '2018'>" + "2018" + "</option>";
            html = html + "      </select>";
            html = html + "   </div>";
           
           
            html = html + "<br> <input type='radio' id='homeless' name='atRiskVsHomeless' value='homeless'>";
            html = html +  "<label for='homeless'>Homeless</label><br>";
            html = html + "<input type='radio' id='at_risk' name='atRiskVsHomeless' value='at_risk'>";
            html = html + "<label for='atrisk'>At Risk</label><br>";
           
           



      
      
       html = html + "Choose proportion comparisons:<br>";
       html = html + "      <input type='checkbox' id='Option1' name='Option1' value='Aus'> <label for='Option1'> Australia</label><br>";
        html = html + "     <input type='checkbox' id='Option2' name='Option2' value='State'> <label for='Option2'> State</label><br>";
        html = html + "     <input type='checkbox' id='Option3' name='Option3' value='LGA'> <label for='Option3'> LGA</label><br>"; 
        html = html + "</select>";



        html = html + "   <button type='submit' class='btn btn-primary'>Search</button>";
        html = html + "</form>";

  



//getting inputs

           String sex_drop = context.formParam("sex_drop");
           //System.out.println(sex_drop);
           String agerange_drop = context.formParam("agerange_drop");
           //System.out.println(agerange_drop);
           String LGAS = context.formParam("LGA");
           //System.out.println(LGAS);
           String status = context.formParam("atRiskVsHomeless");
           String year_drop = context.formParam("year_drop");
           String checkboxAus = context.formParam("Option1");
           String checkboxState = context.formParam("Option2");
           String checkboxLGA = context.formParam("Option3");
           //System.out.println(checkboxAus);
          if (LGAS == null || LGAS == "") {
            // If NULL, nothing to show, therefore we make some "no results" HTML
            html = html + "<h2><i>No Results to show for search, select a LGA</i></h2>";
              
          }
          else if ((status == null || status == "") && ("All".equals(sex_drop) && "All".equals(agerange_drop))) {
            html = html + outputInfoOfLGASNoStatus(LGAS, year_drop);
          }
          else if ("All".equals(sex_drop) && (status == null || status == "")) {
            html = html + outputInfoOfLGASNoStatus(LGAS, year_drop);
            html = html + outputCountResultsOfAge(LGAS, agerange_drop, year_drop);

            if ("Aus".equals(checkboxAus)) {
                html = html + outputAusProportionAge(LGAS, agerange_drop, year_drop);

            }
            if ("State".equals(checkboxState)) {
                html = html + outputStateProportionAge(LGAS, agerange_drop, year_drop);
            }

            if ("LGA".equals(checkboxLGA)) {
                html = html + outputLGAProportionAge(LGAS, agerange_drop, year_drop);
            }

           }

           else if ("All".equals(agerange_drop) && (status == null || status == "")) {
            html = html + outputInfoOfLGASNoStatus(LGAS, year_drop);
            html = html + outputCountResultsOfSex(LGAS, sex_drop, year_drop);

            if ("Aus".equals(checkboxAus)) {
                html = html + outputAusProportionSex(LGAS, sex_drop, year_drop);

            }
            if ("State".equals(checkboxState)) {
                html = html + outputStateProportionSex(LGAS, sex_drop, year_drop);
            }

            if ("LGA".equals(checkboxLGA)) {
                html = html + outputLGAProportionSex(LGAS, sex_drop, year_drop);
            }

           }
          else if ((status == null || status == "")) {
            html = html + outputInfoOfLGASNoStatus(LGAS, year_drop);
            html = html + outputCountResultsOfAgeAndSex(LGAS, agerange_drop, sex_drop, year_drop);
            if ("Aus".equals(checkboxAus)) {
                html = html + outputAusProportionAgeandSex(LGAS, agerange_drop, sex_drop, year_drop);

            }
            if ("State".equals(checkboxState)) {
                html = html + outputStateProportionAgeandSex(LGAS, agerange_drop, sex_drop, year_drop);
            }

            if ("LGA".equals(checkboxLGA)) {
                html = html + outputLGAProportionAgeandSex(LGAS, agerange_drop, sex_drop, year_drop);
            }
          }

           else if ("All".equals(sex_drop) && "All".equals(agerange_drop)){
            html = html + outputInfoOfLGASNoStatus(LGAS, year_drop);
            html = html + outputCountOfLGAAndStatus(LGAS, status, year_drop);
            if ("Aus".equals(checkboxAus)) {
                html = html + outputAusProportionStatus(LGAS, status, year_drop);

            }
            if ("State".equals(checkboxState)) {
                html = html + outputStateProportionStatus(LGAS, status, year_drop);
            }

            if ("LGA".equals(checkboxLGA)) {
                html = html + outputLGAProportionStatus(LGAS, agerange_drop, year_drop);
            }
            
           }
           

           else if ("All".equals(sex_drop)){
            html = html + outputInfoOfLGASNoStatus(LGAS, year_drop);
            html = html + outputCountResultsOfLGASAndAge(LGAS, agerange_drop, status, year_drop);
            if ("Aus".equals(checkboxAus)) {
                html = html + outputAusProportionAgeandStatus(LGAS, agerange_drop, status, year_drop);

            }
            if ("State".equals(checkboxState)) {
                html = html + outputStateProportionAgeandStatus(LGAS, agerange_drop, status, year_drop);
            }

            if ("LGA".equals(checkboxLGA)) {
                html = html + outputLGAProportionAgeandStatus(LGAS, agerange_drop, status, year_drop);
            }
            
           }
           else if ("All".equals(agerange_drop)){
            html = html + outputInfoOfLGASNoStatus(LGAS, year_drop);
            html = html + outputCountResultsOfLGASAndSex(LGAS, sex_drop, status, year_drop);
            if ("Aus".equals(checkboxAus)) {
                html = html + outputAusProportionSexandStatus(LGAS, sex_drop, status, year_drop);

            }
            if ("State".equals(checkboxState)) {
                html = html + outputStateProportionSexandStatus(LGAS, sex_drop, status, year_drop);
            }

            if ("LGA".equals(checkboxLGA)) {
                html = html + outputLGAProportionSexandStatus(LGAS, sex_drop, status, year_drop);
            }
       }
       
       else {
        html = html + outputInfoOfLGASNoStatus(LGAS, year_drop);
        html = html + outputCountResultsOfLGASAndAgeAndSex(LGAS, agerange_drop, sex_drop, status, year_drop);
        if ("Aus".equals(checkboxAus)) {
            html = html + outputAusProportionAgeandSexandStatus(LGAS, agerange_drop, sex_drop, status, year_drop);

        }
        if ("State".equals(checkboxState)) {
            html = html + outputStateProportionAgeandSexandStatus(LGAS, agerange_drop, sex_drop, status, year_drop);
        }

        if ("LGA".equals(checkboxLGA)) {
            html = html + outputLGAProportionAgeandSexandStatus(LGAS, agerange_drop, sex_drop, status, year_drop);
        }
    }
       

        // Close Content div
        html = html + "</div>";

        // Footer
        html = html + """
            <div class='footer'>
            <button class="button" onclick="location.href='https://www.redcross.org.au/donate/'" type="button">
            Donate!</button>
            </div>
        """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }
    

    public String outputInfoOfLGASNoStatus(String lganame, String year) {
        String name = "test";
        int lgaCode = 1;
        String state = "test";
        String type = "t";
        int population = 1;
        double area = 1.0;
        
        
        
        String html = "";
        html = html + "<h2>Information about " + lganame +"</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<LGAST22> lgas = jdbc.getLGAInfo2016NoStatus(lganame, year);

       for (LGAST22 lga : lgas) {
            name =  lga.getName();
            lgaCode = lga.getCode(); 
            type = lga.getType();
            
            state = lga.getState(lgaCode);
             population = lga.getPopulation();
             area = lga.getArea();
        }

        html = html + "<b>Name of LGA: </b>" + name + "<br>" + "<b>State: </b>"+ state + "<br> <b>Type: </b>"+ type +"<br> <b>Population of LGA: </b>" + population + "<br> <b>Area of LGA in sqkm: </b>" + area;
//type not working for some reason
        return html;
    }



    // counts

    public String outputCountOfLGAAndStatus(String LGA, String status, String year) {
        String html = "";
        html = html + "<h2>Count of";
        if ("homeless".equals(status)){
            html = html + " homeless";
        }
        else {
            html = html + " at risk";
        }
        html = html + " people from " + LGA + "</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int count = jdbc.getCountByLGAAndStatus(LGA, status, year);
        //double population = jdbc.getCountByLGAAndStatus(LGA, status, year);
         
        
        // Add HTML for the movies list
        
            html = html + count;
       

        return html;
    }


    public String outputCountResultsOfAge(String LGAS, String age, String year) {
        String html = "";
        html = html + "<h2>Count of";
        
        html = html + " people aged";
        

        if ("0_9".equals(age)){
            html = html + " 0-9 years old";
        }
        else if ("10_19".equals(age)) {
            html = html + " 10-19 years old";
        }
        else if ("20_29".equals(age)) {
            html = html + " 20-29 years old";
        }
        else if ("30_39".equals(age)) {
            html = html + " 30-39 years old";
        }
        else if ("40_49".equals(age)) {
            html = html + " 40-49 years old";
        }
        else if ("50_59".equals(age)) {
            html = html + " 50-59 years old";
        }
        else{
            html = html + " 60+ years old";
        }
        
        html = html + " from " + LGAS + "</h2>";
        
        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int sexes = jdbc.getCountByAge(LGAS, age, year);
        
        // Add HTML for the movies list
        
            html = html + sexes;
        
       

        return html;
    }




    public String outputCountResultsOfSex(String LGAS, String sex, String year) {
        String html = "";
        html = html + "<h2>Count of";
        
        if ("m".equals(sex)){
            html = html + " males";
        }
        else {
            html = html + " females"; 
        }
        
        html = html + " from " + LGAS + "</h2>";
        
        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int sexes = jdbc.getCountBySex(LGAS, sex, year);
        
        // Add HTML for the movies list
        
            html = html + sexes;
        
       

        return html;
    }



    
    public String outputCountResultsOfLGASAndAge(String LGAS, String age, String status, String year) {
        String html = "";
        html = html + "<h2>Count of";
        if ("homeless".equals(status)){
            html = html + " homeless";
        }
        else {
            html = html + " at risk";
        }
        html = html + " people aged";
        

        if ("0_9".equals(age)){
            html = html + " 0-9 years old";
        }
        else if ("10_19".equals(age)) {
            html = html + " 10-19 years old";
        }
        else if ("20_29".equals(age)) {
            html = html + " 20-29 years old";
        }
        else if ("30_39".equals(age)) {
            html = html + " 30-39 years old";
        }
        else if ("40_49".equals(age)) {
            html = html + " 40-49 years old";
        }
        else if ("50_59".equals(age)) {
            html = html + " 50-59 years old";
        }
        else{
            html = html + " 60+ years old";
        }
        
        html = html + " from " + LGAS + "</h2>";
        
        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int sexes = jdbc.getCountByLGAAndAge(LGAS, age, status, year);
        
        // Add HTML for the movies list
        
            html = html + sexes;
        
       

        return html;
    }
    public String outputCountResultsOfLGASAndSex(String LGAS, String sex, String status, String year) {
        String html = "";
        html = html + "<h2>Count of";
        
        if ("homeless".equals(status)){
            html = html + " homeless";
        }
        else {
            html = html + " at risk";
        }

        if ("m".equals(sex)){
            html = html + " males";
        }
        else {
            html = html + " females"; 
        }

        html = html + " from " + LGAS + "</h2>";
        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int sexes = jdbc.getCountByLGAAndSex(LGAS, sex, status, year);
        
        // Add HTML for the movies list
        
            html = html + sexes;
        
       

        return html;
    }

    public String outputCountResultsOfAgeAndSex(String LGAS, String age, String sex, String year) {
        String html = "";
        html = html + "<h2>Count of";
    

    if ("m".equals(sex)){
        html = html + " males";
    }
    else {
        html = html + " females"; 
    }
        html = html + " aged";

        if ("0_9".equals(age)){
            html = html + " 0-9 years old";
        }
        else if ("10_19".equals(age)) {
            html = html + " 10-19 years old";
        }
        else if ("20_29".equals(age)) {
            html = html + " 20-29 years old";
        }
        else if ("30_39".equals(age)) {
            html = html + " 30-39 years old";
        }
        else if ("40_49".equals(age)) {
            html = html + " 40-49 years old";
        }
        else if ("50_59".equals(age)) {
            html = html + " 50-59 years old";
        }
        else{
            html = html + " 60+ years old";
        }

        html = html + " from " + LGAS + "</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int allResults = jdbc.getCountByAgeAndSex(LGAS, age, sex, year);
        
        // Add HTML for the movies list
        
            html = html + allResults;
            return html;
}



    public String outputCountResultsOfLGASAndAgeAndSex(String LGAS, String age, String sex, String status, String year) {
        String html = "";
        html = html + "<h2>Count of";


        if ("homeless".equals(status)){
            html = html + " homeless";
        }
        else {
            html = html + " at risk";
        }
        



    if ("m".equals(sex)){
        html = html + " males";
    }
    else {
        html = html + " females"; 
    }
        html = html + " aged";

        if ("0_9".equals(age)){
            html = html + " 0-9 years old";
        }
        else if ("10_19".equals(age)) {
            html = html + " 10-19 years old";
        }
        else if ("20_29".equals(age)) {
            html = html + " 20-29 years old";
        }
        else if ("30_39".equals(age)) {
            html = html + " 30-39 years old";
        }
        else if ("40_49".equals(age)) {
            html = html + " 40-49 years old";
        }
        else if ("50_59".equals(age)) {
            html = html + " 50-59 years old";
        }
        else{
            html = html + " 60+ years old";
        }

        html = html + " from " + LGAS + "</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int allResults = jdbc.getCountByLGAAndAgeAndSex(LGAS, age, sex, status, year);
        
        // Add HTML for the movies list
        
            html = html + allResults;
            return html;
}



public String outputCountResultsOfLGAAndAgeNoStatus(String LGAS, String age, String year) {
    String html = "";
    html = html + "<h2>Count of people aged " + age + " from " + LGAS + "</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int sexes = jdbc.getCountByLGAAndAgeNoStatus(LGAS, age, year);
    
    // Add HTML for the movies list
    
        html = html + sexes;
    
   

    return html;
}

public String outputCountResultsOfLGAAndSexNoStatus(String LGAS, String sex, String year) {
    String html = "";
    html = html + "<h2>Count of ";
    
    if ("m".equals(sex)){
        html = html + " males";
    }
    else {
        html = html + " females"; 
    }
    
    
    html = html + " from " + LGAS + "</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int sexes = jdbc.getCountByLGAAndSexNoStatus(LGAS, sex, year);
    
    // Add HTML for the movies list
    
        html = html + sexes;
    
   

    return html;
}


//proportion functions


//status
public String outputAusProportionStatus(String LGA, String status, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }
    html = html + " people from " + LGA + " compared to total at risk/homeless population in Australia</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByLGAAndStatus(LGA, status, year);
    double population = jdbc.getPopulationOfAus(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputStateProportionStatus(String LGA, String status, String year) {
        int lgaCode = 1;
        String state = "test";
        int firstDigit = 1;
   
   
    String html = "";


    JDBCConnection jdbc = new JDBCConnection();
    

    ArrayList<LGAST22> lgas = jdbc.getLGAInfo2016NoStatus(LGA, year);

       for (LGAST22 lga : lgas) {
            lgaCode = lga.getCode(); 
            firstDigit = lga.getFirstDigit(lgaCode);
            state = lga.getState(lgaCode);
        }
        int count = jdbc.getCountByLGAAndStatus(LGA, status, year);
        double population = jdbc.getPopulationOfState(LGA, firstDigit, year);
        double proportion = (count/population) * 100.0;
    html = html + "<h2>Proportion of";
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }
    html = html + " people from " + LGA + " compared to total at risk/homeless population in " + state + "</h2>";

    // Look up movies from JDBC
    
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputLGAProportionStatus(String LGA, String status, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }
    html = html + " people from " + LGA + " compared to total at risk/homeless population in " + LGA + "</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByLGAAndStatus(LGA, status, year);
    double population = jdbc.getPopulationOfLGA(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}

// age

public String outputAusProportionAge(String LGA, String age, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
    
    html = html + " people aged";

    if ("0_9".equals(age)){
        html = html + " 0-9 years old";
    }
    else if ("10_19".equals(age)) {
        html = html + " 10-19 years old";
    }
    else if ("20_29".equals(age)) {
        html = html + " 20-29 years old";
    }
    else if ("30_39".equals(age)) {
        html = html + " 30-39 years old";
    }
    else if ("40_49".equals(age)) {
        html = html + " 40-49 years old";
    }
    else if ("50_59".equals(age)) {
        html = html + " 50-59 years old";
    }
    else{
        html = html + " 60+ years old";
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in Australia</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByAge(LGA, age, year);
    double population = jdbc.getPopulationOfAus(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputStateProportionAge(String LGA, String age, String year) {
        int lgaCode = 1;
        String state = "test";
        int firstDigit = 1;
   
   
    String html = "";


    JDBCConnection jdbc = new JDBCConnection();
    

    ArrayList<LGAST22> lgas = jdbc.getLGAInfo2016NoStatus(LGA, year);

       for (LGAST22 lga : lgas) {
            lgaCode = lga.getCode(); 
            firstDigit = lga.getFirstDigit(lgaCode);
            state = lga.getState(lgaCode);
        }
        int count = jdbc.getCountByAge(LGA, age, year);
        double population = jdbc.getPopulationOfState(LGA, firstDigit, year);
        double proportion = (count/population) * 100.0;
        html = html + "<h2>Proportion of";
        html = html + " people aged";
    
        if ("0_9".equals(age)){
            html = html + " 0-9 years old";
        }
        else if ("10_19".equals(age)) {
            html = html + " 10-19 years old";
        }
        else if ("20_29".equals(age)) {
            html = html + " 20-29 years old";
        }
        else if ("30_39".equals(age)) {
            html = html + " 30-39 years old";
        }
        else if ("40_49".equals(age)) {
            html = html + " 40-49 years old";
        }
        else if ("50_59".equals(age)) {
            html = html + " 50-59 years old";
        }
        else{
            html = html + " 60+ years old";
        }
        html = html + " from " + LGA + " compared to total at risk/homeless population in " + state + "</h2>";

    // Look up movies from JDBC
    
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputLGAProportionAge(String LGA, String age, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
    html = html + " people aged";

    if ("0_9".equals(age)){
        html = html + " 0-9 years old";
    }
    else if ("10_19".equals(age)) {
        html = html + " 10-19 years old";
    }
    else if ("20_29".equals(age)) {
        html = html + " 20-29 years old";
    }
    else if ("30_39".equals(age)) {
        html = html + " 30-39 years old";
    }
    else if ("40_49".equals(age)) {
        html = html + " 40-49 years old";
    }
    else if ("50_59".equals(age)) {
        html = html + " 50-59 years old";
    }
    else{
        html = html + " 60+ years old";
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in "+ LGA + "</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByAge(LGA, age, year);
    double population = jdbc.getPopulationOfLGA(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}




// age and status

public String outputAusProportionAgeandStatus(String LGA, String age, String status, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }
    html = html + " people aged";

    if ("0_9".equals(age)){
        html = html + " 0-9 years old";
    }
    else if ("10_19".equals(age)) {
        html = html + " 10-19 years old";
    }
    else if ("20_29".equals(age)) {
        html = html + " 20-29 years old";
    }
    else if ("30_39".equals(age)) {
        html = html + " 30-39 years old";
    }
    else if ("40_49".equals(age)) {
        html = html + " 40-49 years old";
    }
    else if ("50_59".equals(age)) {
        html = html + " 50-59 years old";
    }
    else{
        html = html + " 60+ years old";
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in Australia</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByLGAAndAge(LGA, age, status, year);
    double population = jdbc.getPopulationOfAus(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputStateProportionAgeandStatus(String LGA, String age, String status, String year) {
        int lgaCode = 1;
        String state = "test";
        int firstDigit = 1;
   
   
    String html = "";


    JDBCConnection jdbc = new JDBCConnection();
    

    ArrayList<LGAST22> lgas = jdbc.getLGAInfo2016NoStatus(LGA, year);

       for (LGAST22 lga : lgas) {
            lgaCode = lga.getCode(); 
            firstDigit = lga.getFirstDigit(lgaCode);
            state = lga.getState(lgaCode);
        }
        int count = jdbc.getCountByLGAAndAge(LGA, age, status, year);
        double population = jdbc.getPopulationOfState(LGA, firstDigit, year);
        double proportion = (count/population) * 100.0;
        html = html + "<h2>Proportion of";
        if ("homeless".equals(status)){
            html = html + " homeless";
        }
        else {
            html = html + " at risk";
        }
        html = html + " people aged";
    
        if ("0_9".equals(age)){
            html = html + " 0-9 years old";
        }
        else if ("10_19".equals(age)) {
            html = html + " 10-19 years old";
        }
        else if ("20_29".equals(age)) {
            html = html + " 20-29 years old";
        }
        else if ("30_39".equals(age)) {
            html = html + " 30-39 years old";
        }
        else if ("40_49".equals(age)) {
            html = html + " 40-49 years old";
        }
        else if ("50_59".equals(age)) {
            html = html + " 50-59 years old";
        }
        else{
            html = html + " 60+ years old";
        }
        html = html + " from " + LGA + " compared to total at risk/homeless population in " + state + "</h2>";

    // Look up movies from JDBC
    
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputLGAProportionAgeandStatus(String LGA, String age,  String status, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }
    html = html + " people aged";

    if ("0_9".equals(age)){
        html = html + " 0-9 years old";
    }
    else if ("10_19".equals(age)) {
        html = html + " 10-19 years old";
    }
    else if ("20_29".equals(age)) {
        html = html + " 20-29 years old";
    }
    else if ("30_39".equals(age)) {
        html = html + " 30-39 years old";
    }
    else if ("40_49".equals(age)) {
        html = html + " 40-49 years old";
    }
    else if ("50_59".equals(age)) {
        html = html + " 50-59 years old";
    }
    else{
        html = html + " 60+ years old";
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in "+ LGA + "</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByLGAAndAge(LGA, age, status, year);
    double population = jdbc.getPopulationOfLGA(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


//sex

public String outputAusProportionSex(String LGA, String sex, String year) {
    String html = "";
    html = html + "<h2>Proportion of";

    if ("m".equals(sex)){
        html = html + " males";
    }
    else {
        html = html + " females"; 
    }

    html = html + " from " + LGA + " compared to total at risk/homeless population in Australia</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountBySex(LGA, sex, year);
    double population = jdbc.getPopulationOfAus(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputStateProportionSex(String LGA, String sex, String year) {
        int lgaCode = 1;
        String state = "test";
        int firstDigit = 1;
   
   
    String html = "";


    JDBCConnection jdbc = new JDBCConnection();
    

    ArrayList<LGAST22> lgas = jdbc.getLGAInfo2016NoStatus(LGA, year);

       for (LGAST22 lga : lgas) {
            lgaCode = lga.getCode(); 
            firstDigit = lga.getFirstDigit(lgaCode);
            state = lga.getState(lgaCode);
        }
        int count = jdbc.getCountBySex(LGA, sex, year);
        double population = jdbc.getPopulationOfState(LGA, firstDigit, year);
        double proportion = (count/population) * 100.0;
    html = html + "<h2>Proportion of";

    if ("m".equals(sex)){
        html = html + " males";
    }
    else {
        html = html + " females"; 
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in " + state + "</h2>";

    // Look up movies from JDBC
    
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputLGAProportionSex(String LGA, String sex, String year) {
    String html = "";
    html = html + "<h2>Proportion of";

    if ("m".equals(sex)){
        html = html + " males";
    }
    else {
        html = html + " females"; 
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in " + LGA + "</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountBySex(LGA, sex, year);
    double population = jdbc.getPopulationOfLGA(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


// sex and status


public String outputAusProportionSexandStatus(String LGA, String sex, String status, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }

    if ("m".equals(sex)){
        html = html + " males";
    }
    else {
        html = html + " females"; 
    }

    html = html + " from " + LGA + " compared to total at risk/homeless population in Australia</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByLGAAndSex(LGA, sex, status, year);
    double population = jdbc.getPopulationOfAus(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputStateProportionSexandStatus(String LGA, String sex, String status, String year) {
        int lgaCode = 1;
        String state = "test";
        int firstDigit = 1;
   
   
    String html = "";


    JDBCConnection jdbc = new JDBCConnection();
    

    ArrayList<LGAST22> lgas = jdbc.getLGAInfo2016NoStatus(LGA, year);

       for (LGAST22 lga : lgas) {
            lgaCode = lga.getCode(); 
            firstDigit = lga.getFirstDigit(lgaCode);
            state = lga.getState(lgaCode);
        }
        int count = jdbc.getCountByLGAAndSex(LGA, sex, status, year);
        double population = jdbc.getPopulationOfState(LGA, firstDigit, year);
        double proportion = (count/population) * 100.0;
    html = html + "<h2>Proportion of";
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }

    if ("m".equals(sex)){
        html = html + " males";
    }
    else {
        html = html + " females"; 
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in " + state + "</h2>";

    // Look up movies from JDBC
    
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputLGAProportionSexandStatus(String LGA, String sex, String status, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }

    if ("m".equals(sex)){
        html = html + " males";
    }
    else {
        html = html + " females"; 
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in " + LGA + "</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByLGAAndSex(LGA, sex, status, year);
    double population = jdbc.getPopulationOfLGA(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}

// all filters

public String outputAusProportionAgeandSexandStatus(String LGA, String age, String sex, String status, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }
    



if ("m".equals(sex)){
    html = html + " males";
}
else {
    html = html + " females"; 
}
    html = html + " aged";

    if ("0_9".equals(age)){
        html = html + " 0-9 years old";
    }
    else if ("10_19".equals(age)) {
        html = html + " 10-19 years old";
    }
    else if ("20_29".equals(age)) {
        html = html + " 20-29 years old";
    }
    else if ("30_39".equals(age)) {
        html = html + " 30-39 years old";
    }
    else if ("40_49".equals(age)) {
        html = html + " 40-49 years old";
    }
    else if ("50_59".equals(age)) {
        html = html + " 50-59 years old";
    }
    else{
        html = html + " 60+ years old";
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in Australia</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByLGAAndAgeAndSex(LGA, age, sex, status, year);
    double population = jdbc.getPopulationOfAus(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputStateProportionAgeandSexandStatus(String LGA, String age, String sex, String status, String year) {
        int lgaCode = 1;
        String state = "test";
        int firstDigit = 1;
   
   
    String html = "";


    JDBCConnection jdbc = new JDBCConnection();
    

    ArrayList<LGAST22> lgas = jdbc.getLGAInfo2016NoStatus(LGA, year);

       for (LGAST22 lga : lgas) {
            lgaCode = lga.getCode(); 
            firstDigit = lga.getFirstDigit(lgaCode);
            state = lga.getState(lgaCode);
        }
        int count = jdbc.getCountByLGAAndAgeAndSex(LGA, age, sex, status, year);
        double population = jdbc.getPopulationOfState(LGA, firstDigit, year);
        double proportion = (count/population) * 100.0;
    html = html + "<h2>Proportion of";
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }
    



if ("m".equals(sex)){
    html = html + " males";
}
else {
    html = html + " females"; 
}
    html = html + " aged";

    if ("0_9".equals(age)){
        html = html + " 0-9 years old";
    }
    else if ("10_19".equals(age)) {
        html = html + " 10-19 years old";
    }
    else if ("20_29".equals(age)) {
        html = html + " 20-29 years old";
    }
    else if ("30_39".equals(age)) {
        html = html + " 30-39 years old";
    }
    else if ("40_49".equals(age)) {
        html = html + " 40-49 years old";
    }
    else if ("50_59".equals(age)) {
        html = html + " 50-59 years old";
    }
    else{
        html = html + " 60+ years old";
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in " + state + "</h2>";

    // Look up movies from JDBC
    
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputLGAProportionAgeandSexandStatus(String LGA, String age, String sex, String status, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }
    



if ("m".equals(sex)){
    html = html + " males";
}
else {
    html = html + " females"; 
}
    html = html + " aged";

    if ("0_9".equals(age)){
        html = html + " 0-9 years old";
    }
    else if ("10_19".equals(age)) {
        html = html + " 10-19 years old";
    }
    else if ("20_29".equals(age)) {
        html = html + " 20-29 years old";
    }
    else if ("30_39".equals(age)) {
        html = html + " 30-39 years old";
    }
    else if ("40_49".equals(age)) {
        html = html + " 40-49 years old";
    }
    else if ("50_59".equals(age)) {
        html = html + " 50-59 years old";
    }
    else{
        html = html + " 60+ years old";
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in " + LGA + "</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByLGAAndAgeAndSex(LGA, age, sex, status, year);
    double population = jdbc.getPopulationOfLGA(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}



// age and sex


public String outputAusProportionAgeandSex(String LGA, String age, String sex, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
    
if ("m".equals(sex)){
    html = html + " males";
}
else {
    html = html + " females"; 
}
    html = html + " aged";

    if ("0_9".equals(age)){
        html = html + " 0-9 years old";
    }
    else if ("10_19".equals(age)) {
        html = html + " 10-19 years old";
    }
    else if ("20_29".equals(age)) {
        html = html + " 20-29 years old";
    }
    else if ("30_39".equals(age)) {
        html = html + " 30-39 years old";
    }
    else if ("40_49".equals(age)) {
        html = html + " 40-49 years old";
    }
    else if ("50_59".equals(age)) {
        html = html + " 50-59 years old";
    }
    else{
        html = html + " 60+ years old";
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in Australia</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByAgeAndSex(LGA, age, sex, year);
    double population = jdbc.getPopulationOfAus(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputStateProportionAgeandSex(String LGA, String age, String sex, String year) {
        int lgaCode = 1;
        String state = "test";
        int firstDigit = 1;
   
   
    String html = "";


    JDBCConnection jdbc = new JDBCConnection();
    

    ArrayList<LGAST22> lgas = jdbc.getLGAInfo2016NoStatus(LGA, year);

       for (LGAST22 lga : lgas) {
            lgaCode = lga.getCode(); 
            firstDigit = lga.getFirstDigit(lgaCode);
            state = lga.getState(lgaCode);
        }
        int count = jdbc.getCountByAgeAndSex(LGA, age, sex, year);
        double population = jdbc.getPopulationOfState(LGA, firstDigit, year);
        double proportion = (count/population) * 100.0;
    html = html + "<h2>Proportion of";

if ("m".equals(sex)){
    html = html + " males";
}
else {
    html = html + " females"; 
}
    html = html + " aged";

    if ("0_9".equals(age)){
        html = html + " 0-9 years old";
    }
    else if ("10_19".equals(age)) {
        html = html + " 10-19 years old";
    }
    else if ("20_29".equals(age)) {
        html = html + " 20-29 years old";
    }
    else if ("30_39".equals(age)) {
        html = html + " 30-39 years old";
    }
    else if ("40_49".equals(age)) {
        html = html + " 40-49 years old";
    }
    else if ("50_59".equals(age)) {
        html = html + " 50-59 years old";
    }
    else{
        html = html + " 60+ years old";
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in " + state + "</h2>";

    // Look up movies from JDBC
    
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion)+ "%";
   

    return html;
}


public String outputLGAProportionAgeandSex(String LGA, String age, String sex, String year) {
    String html = "";
    html = html + "<h2>Proportion of";
   

if ("m".equals(sex)){
    html = html + " males";
}
else {
    html = html + " females"; 
}
    html = html + " aged";

    if ("0_9".equals(age)){
        html = html + " 0-9 years old";
    }
    else if ("10_19".equals(age)) {
        html = html + " 10-19 years old";
    }
    else if ("20_29".equals(age)) {
        html = html + " 20-29 years old";
    }
    else if ("30_39".equals(age)) {
        html = html + " 30-39 years old";
    }
    else if ("40_49".equals(age)) {
        html = html + " 40-49 years old";
    }
    else if ("50_59".equals(age)) {
        html = html + " 50-59 years old";
    }
    else{
        html = html + " 60+ years old";
    }
    html = html + " from " + LGA + " compared to total at risk/homeless population in " + LGA + "</h2>";

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    int count = jdbc.getCountByAgeAndSex(LGA, age, sex, year);
    double population = jdbc.getPopulationOfLGA(LGA, year);
    double proportion = (count/population) * 100.0;
     
    
    // Add HTML for the movies list
    
        html = html + String.format("%.3f", proportion) + "%";
   

    return html;
}





}
