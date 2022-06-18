package app;

import java.lang.reflect.Array;
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
public class PageST21 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page3.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";
        html = html + "<!DOCTYPE html>";
        

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 2.1</title>";

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
                <a href='page3.html'>LGA Rankings</a>
                <a href='page4.html'>LGA Information</a>
                <a href='page5.html'>Rate of Homelessness</a>
                <a href='page6.html'>Change in Homelessness over time</a>
            </div>
        """;

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>LGA Rankings</h1>
            </div>
        """;

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

        // Next we will ask this *class* for the LGAs
        ArrayList<LGA> lgas = jdbc.getLGAs();
        html = html + "<form action='/page3.html' method='post'>";
        
    

// add error checking for leaving box empty, incorrect typing

  

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
            html = html + "     <label for='orderby_drop'>Select the order (Dropdown):</label>";
            html = html + "      <select id='orderby_drop' name='orderby_drop'>";
            html = html +  "<option value = 'desc'>" + "Most" + "</option>";
            html = html +  "<option value = 'asc'>" + "Least" + "</option>";
            html = html + "      </select>";
            html = html + "   </div>";
           

            html = html + "     <div class='form-group'>";
            html = html + "     <label for='year_drop'>Select the year to view (Dropdown):</label>";
            html = html + "      <select id='year_drop' name='year_drop'>";
            html = html +  "<option value = '2016'>" + "2016" + "</option>";
            html = html +  "<option value = '2018'>" + "2018" + "</option>";
            html = html + "      </select>";
            html = html + "   </div>";
           
           
            html = html + " <br> <input type='radio' id='homeless' name='atRiskVsHomeless' value='homeless'>";
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
           String status = context.formParam("atRiskVsHomeless");
           //System.out.println(atRiskVsHomeless)
           String orderby_drop = context.formParam("orderby_drop");
           //System.out.println(sex_drop);
           String year_drop = context.formParam("year_drop");

          if (status == null || status == "") {
            html = html + "<h2><i>No Results to show for search, select homeless or at risk</i></h2>";
          }
           else if ("All".equals(sex_drop) && "All".equals(agerange_drop)){
               html = html + outputLGAFromStatus(status,orderby_drop,year_drop);
           }

           else if ("All".equals(sex_drop)){
                html = html + outputLGAFromAge(agerange_drop, status,orderby_drop,year_drop);
           }
           else if ("All".equals(agerange_drop)){
            html = html + outputLGAFromSex(sex_drop, status, orderby_drop,year_drop);
       }
       else {
        html = html + outputLGAFromAllFactors(agerange_drop, sex_drop, status,orderby_drop,year_drop);
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
   
    public String outputLGAFromStatus(String status, String order, String year) {
        String html = "";
        html = html + "<h2>LGA Table of";

        if ("homeless".equals(status)){
            html = html + " homeless";
        }
        else {
            html = html + " at risk";
        }
        html = html + " people</h2>";
        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<LGAST21> lgas = jdbc.getLGAFromStatus(status, order, year);
        
        // Add HTML for the movies list
        
        html = html +"<table id='LGA'>" +
        "<tr>" +
            "<th> LGA</th>" +
            "<th> Count</th>" +
           "<th> Proportional Value</th>" +
        "</tr>";
for (LGAST21 lga : lgas) {
 html = html + "<tr>" + "<td>" + lga.getName() + "</td>" +
                        "<td>" + lga.getCount() + "</td>" +
                        "<td>" + String.format("%.3f", lga.getProportion()) + "%</td>" +
                "</tr>";
            }
html = html + "</table>";

            return html;
}

public String outputLGAFromSex(String sex, String status, String order, String year) {
    String html = "";
    html = html + "<h2>LGA Table of";

    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }

    if ("m".equals(sex)){
        html = html + " males</h2>";
    }
    else {
        html = html + " females</h2>"; 
    }
    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    ArrayList<LGAST21> lgas = jdbc.getLGAFromSex(sex, status, order, year);
    
    // Add HTML for the movies list
    
    html = html +"<table id='LGA'>" +
    "<tr>" +
        "<th> LGA</th>" +
        "<th> Count</th>" +
       "<th> Proportional Value</th>" +
    "</tr>";
for (LGAST21 lga : lgas) {
html = html + "<tr>" + "<td>" + lga.getName() + "</td>" +
                    "<td>" + lga.getCount() + "</td>" +
                    "<td>" + String.format("%.3f", lga.getProportion()) + "%</td>" +
            "</tr>";
        }
html = html + "</table>";

        return html;
}


public String outputLGAFromAge(String age, String status, String order, String year) {
    String html = "";
    html = html + "<h2>LGA Table of";
    
    if ("homeless".equals(status)){
        html = html + " homeless";
    }
    else {
        html = html + " at risk";
    }
    
    
    html = html + " people aged"; 
    
    if ("0_9".equals(age)){
        html = html + " 0-9 years old</h2>";
    }
    else if ("10_19".equals(age)) {
        html = html + " 10-19 years old</h2>";
    }
    else if ("20_29".equals(age)) {
        html = html + " 20-29 years old</h2>";
    }
    else if ("30_39".equals(age)) {
        html = html + " 30-39 years old</h2>";
    }
    else if ("40_49".equals(age)) {
        html = html + " 40-49 years old</h2>";
    }
    else if ("50_59".equals(age)) {
        html = html + " 50-59 years old</h2>";
    }
    else{
        html = html + " 60+ years old</h2>";
    }

    // Look up movies from JDBC
    JDBCConnection jdbc = new JDBCConnection();
    ArrayList<LGAST21> lgas = jdbc.getLGAFromAge(age, status, order, year);
    
    // Add HTML for the movies list
    
    html = html +"<table id='LGA'>" +
    "<tr>" +
        "<th> LGA</th>" +
        "<th> Count</th>" +
       "<th> Proportional Value</th>" +
    "</tr>";
for (LGAST21 lga : lgas) {
html = html + "<tr>" + "<td>" + lga.getName() + "</td>" +
                    "<td>" + lga.getCount() + "</td>" +
                    "<td>" + String.format("%.3f", lga.getProportion()) + "%</td>" +
            "</tr>";
        }
html = html + "</table>";

        return html;
}


    public String outputLGAFromAllFactors(String age, String sex, String status, String order, String year) {
        String html = "";
        html = html + "<h2>LGA Table of";


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
            html = html + " 0-9 years old</h2>";
        }
        else if ("10_19".equals(age)) {
            html = html + " 10-19 years old</h2>";
        }
        else if ("20_29".equals(age)) {
            html = html + " 20-29 years old</h2>";
        }
        else if ("30_39".equals(age)) {
            html = html + " 30-39 years old</h2>";
        }
        else if ("40_49".equals(age)) {
            html = html + " 40-49 years old</h2>";
        }
        else if ("50_59".equals(age)) {
            html = html + " 50-59 years old</h2>";
        }
        else{
            html = html + " 60+ years old</h2>";
        }


        // Look up movies from JDBC
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<LGAST21> lgas = jdbc.getLGAFromAllFactors(age, sex, status, order, year);
        
        // Add HTML for the movies list
        
        html = html +"<table id='LGA'>" +
        "<tr>" +
            "<th> LGA</th>" +
            "<th> Count</th>" +
           "<th> Proportional Value</th>" +
        "</tr>";
for (LGAST21 lga : lgas) {
 html = html + "<tr>" + "<td>" + lga.getName() + "</td>" +
                        "<td>" + lga.getCount() + "</td>" +
                        "<td>" + String.format("%.3f", lga.getProportion()) + "%</td>" +
                "</tr>";
            }
html = html + "</table>";

            return html;
}
}
