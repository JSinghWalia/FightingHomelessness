package app;

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
public class PageST32 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page6.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 3.2</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        html = html + """
            <div class='topnav'>
                <a href='/'>Homepage</a>
                <a href='mission.html'>Our Mission</a>
                <a href='page3.html'>Sub Task 2.1</a>
                <a href='page4.html'>Sub Task 2.2</a>
                <a href='page5.html'>Sub Task 3.1</a>
                <a href='page6.html'>Sub Task 3.2</a>
            </div>
        """;

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>Subtask 3.2</h1>
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
            html = html + outputInfoOfLGASNoStatus(LGAS);
          }
           else if ("All".equals(sex_drop) && "All".equals(agerange_drop)){
            html = html + outputInfoOfLGASNoStatus(LGAS);
            html = html + outputCountOfLGAAndStatus(LGAS, status, year_drop);
            if ("Aus".equals(checkboxAus)) {
                html = html + outputInfoOfLGASNoStatus(LGAS);
    
            }
            if ("State".equals(checkboxState)) {
                html = html + outputInfoOfLGASNoStatus(LGAS);
            }
    
            if ("LGA".equals(checkboxLGA)) {
                html = html + outputInfoOfLGASNoStatus(LGAS);
            }
                
           }
    
    
    
           else if ("All".equals(sex_drop)){
            html = html + outputInfoOfLGASNoStatus(LGAS);
            html = html + outputCountResultsOfLGASAndAge(LGAS, agerange_drop, status, year_drop);
                
            }
           else if ("All".equals(agerange_drop)){
            html = html + outputInfoOfLGASNoStatus(LGAS);
            html = html + outputCountResultsOfLGASAndSex(LGAS, sex_drop, status, year_drop);
       }
           
       else {
        html = html + outputInfoOfLGASNoStatus(LGAS);
        html = html + outputCountResultsOfLGASAndAgeAndSex(LGAS, agerange_drop, sex_drop, status, year_drop);
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



    public String outputInfoOfLGASNoStatus(String lganame) {
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
        ArrayList<LGAST22> lgas = jdbc.getLGAInfo2016NoStatus(lganame);

       for (LGAST22 lga : lgas) {
            name =  lga.getName();
            lgaCode = lga.getCode(); 
            type = lga.getType();
            state = lga.getState(lgaCode);
             population = lga.getPopulation();
             area = lga.getArea();
        }

        html = html + name + " " + state + " "+ type +" " + population + " " + area;
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
        html = html + " people from" + LGA + "</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int count = jdbc.getCountByLGAAndStatus(LGA, status, year);
        //double population = jdbc.getCountByLGAAndStatus(LGA, status, year);
         
        
        // Add HTML for the movies list
        
            html = html + count;
       

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
        html = html + "<h2>Count of " + sex + " People</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int sexes = jdbc.getCountByLGAAndSex(LGAS, sex, status, year);
        
        // Add HTML for the movies list
        
            html = html + sexes;
        
       

        return html;
    }
    public String outputCountResultsOfLGASAndAgeAndSex(String LGAS, String age, String sex, String status, String year) {
        String html = "";
        html = html + "<h2>Count of " + sex +"'s aged " + age + " from " + LGAS + "</h2>";

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

}
