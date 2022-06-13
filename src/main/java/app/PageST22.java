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
public class PageST22 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page4.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 2.2</title>";

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
                <h1>Subtask 2.2</h1>
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
      
      
      
       html = html + "<br>";
       html = html + "      <input type='checkbox' id='Option1' name='Option1' value='Aus'> <label for='Option1'> Australia</label><br>";
        html = html + "     <input type='checkbox' id='Option2' name='Option2' value='State'> <label for='Option2'> State</label><br>";
        html = html + "     <input type='checkbox' id='Option3' name='Option3' value='LGA'> <label for='Option3'> LGA</label><br>"; 
        html = html + "</select>";
        //Add options through database
        
        
        
    

// add error checking for leaving box empty, incorrect typing

  

    ArrayList<String> ageRange = jdbc.getAgeRange();
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
           
           
            html = html + "<br> <input type='radio' id='homeless' name='atRiskVsHomeless' value='homeless'>";
            html = html +  "<label for='homeless'>Homeless</label><br>";
            html = html + "<input type='radio' id='at_risk' name='atRiskVsHomeless' value='at_risk'>";
            html = html + "<label for='atrisk'>At Risk</label><br>";
           
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
               html = html + outputInfoOfLGAS(LGAS, status);
               html = html + outputCountOfAtRisk(LGAS, status, checkboxAus);
           }

           else if ("All".equals(sex_drop)){
                html = html + outputCountResultsOfLGASAndAge(LGAS, agerange_drop, status);
           }
           else if ("All".equals(agerange_drop)){
            html = html + outputCountResultsOfLGASAndSex(LGAS, sex_drop, status);
       }
       else {
        html = html + outputCountResultsOfLGASAndAgeAndSex(LGAS, agerange_drop, sex_drop, status);
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
    public String outputInfoOfLGAS(String lganame, String status) {
        String name = "test";
        int lgaCode = 1;
        String state = "test";
        String type = "t";
        int population = 1;
        double area = 1.0;
        
        
        
        String html = "";
        html = html + "<h2>Count of people aged</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<LGAST22> lgas = jdbc.getLGAInfo2016(lganame, status);

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

    public String outputInfoOfLGASNoStatus(String lganame) {
        String name = "test";
        int lgaCode = 1;
        String state = "test";
        String type = "t";
        int population = 1;
        double area = 1.0;
        
        
        
        String html = "";
        html = html + "<h2>Count of people aged</h2>";

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

    public String outputCountOfAtRisk(String LGAS, String status, String compare) {
        String html = "";
        html = html + "<h2>Count of  People</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int count = jdbc.getCountByLGAAndStatus(LGAS, status);
         
        
        // Add HTML for the movies list
        
            html = html + count;
       

        return html;
    }

    public String outputCountResultsOfSex(String sex) {
        String html = "";
        html = html + "<h2>Count of " + sex + " People</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int sexes = jdbc.getCountBySex(sex);
        
        // Add HTML for the movies list
        
            html = html + sexes;
        
       

        return html;
    }
    public String outputCountResultsOfL(String LGA, String status) {
        String html = "";
        html = html + "<h2>Count of People From " + LGA + "</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int LGAS = jdbc.getCountByLGA(LGA, status);
        
        // Add HTML for the movies list
        
            html = html + LGAS;
        
       

        return html;
    }
    public String outputCountResultsOfLGASAndAge(String LGAS, String age, String status) {
        String html = "";
        html = html + "<h2>Count of people aged " + age + " from " + LGAS + "</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int sexes = jdbc.getCountByLGAAndAge(LGAS, age, status);
        
        // Add HTML for the movies list
        
            html = html + sexes;
        
       

        return html;
    }
    public String outputCountResultsOfLGASAndSex(String LGAS, String sex, String status) {
        String html = "";
        html = html + "<h2>Count of " + sex + " People</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int sexes = jdbc.getCountByLGAAndSex(LGAS, sex, status);
        
        // Add HTML for the movies list
        
            html = html + sexes;
        
       

        return html;
    }
    public String outputCountResultsOfLGASAndAgeAndSex(String LGAS, String age, String sex, String status) {
        String html = "";
        html = html + "<h2>Count of " + sex +"'s aged " + age + " from " + LGAS + "</h2>";

        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        int allResults = jdbc.getCountByLGAAndAgeAndSex(LGAS, age, sex, status);
        
        // Add HTML for the movies list
        
            html = html + allResults;
            return html;
}
}
