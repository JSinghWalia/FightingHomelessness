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
public class PageST31 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page5.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";
        html = html + "<!DOCTYPE html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Rate of Homelessness</title>";

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
                <h1>Rate of Homelessness</h1>
            </div>
        """;

        // Add Div for page Content
        html = html + "<div class='content'>";
        html = html + "<form action='/page5.html' method='post'>";
        

        html = html + "     <div class='form-group'>";
        html = html + "     <label for='state_drop'>Select the state (Dropdown):</label>";
        html = html + "      <select id='state_drop' name='state_drop'>";
        html = html +  "<option value = '1'>" + "All" + "</option>";
        html = html +  "<option value = '1'>" + "New South Wales" + "</option>";
        html = html +  "<option value = '2'>" + "Victoria" + "</option>";
        html = html +  "<option value = '3'>" + "Queensland" + "</option>";
        html = html +  "<option value = '4'>" + "South Australia" + "</option>";
        html = html +  "<option value = '5'>" + "Western Australia" + "</option>";
        html = html +  "<option value = '6'>" + "Tasmania" + "</option>";
        html = html +  "<option value = '7'>" + "Northern Territory" + "</option>";
        html = html +  "<option value = '8'>" + "ACT" + "</option>";
        html = html +  "<option value = '9'>" + "Other Australian Territories" + "</option>";
        html = html + "      </select>";
        html = html + "   </div>";



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



     html = html + " <br> <div class='form-group'>";
     html = html + "     <label for='incomerangemin'>Select the income range: </label>";
     html = html + "     <input type = 'number' value = '0' id ='incomerangemin' name = 'incomerangemin' min = '0' max = '3481'>";
     html = html + "     <label for='incomerangemax'> to</label>";
     html = html + "     <input type = 'number' value = '3481' id ='incomerangemax' name = 'incomerangemax' min = '0' max = '3481'>";
     html = html + "   </div>";

     


     html = html + "  <br>   <div class='form-group'>";
     html = html + "     <label for='agerangemin'>Select the median age: </label>";
     html = html + "     <input type = 'number' value = '0' id ='agerangemin' name = 'agerangemin' min = '0' max = '60'>";
     html = html + "     <label for='agerangemax'> to</label>";
     html = html + "     <input type = 'number' value = '60' id ='agerangemax' name = 'agerangemax' min = '0' max = '60'>";
     html = html + "   </div>";

  

     html = html + " <br> <div class='form-group'>";
     html = html + "     <label for='mortgagerangemin'>Select the mortgage: </label>";
     html = html + "     <input type = 'number' value = '0' id ='mortgagerangemin' name = 'mortgagerangemin' min = '0' max = '3250'>";
     html = html + "     <label for='mortgagerangemax'> to</label>";
     html = html + "     <input type = 'number' value = '3250' id ='mortgagerangemax' name = 'mortgagerangemax' min = '0' max = '3250'>";
     html = html + "   </div>";



    

    

     



     html = html + "  <br>  <div class='form-group'>";
     html = html + "     <label for='rentweeklymin'>Select the median weekly rent </label>";
     html = html + "     <input type = 'number' value = '0' id ='rentweeklymin' name = 'rentweeklymin' min = '0' max = '650'>";
     html = html + "     <label for='rentweeklymax'> to</label>";
     html = html + "     <input type = 'number' value = '650' id ='rentweeklymax' name = 'rentweeklymax' min = '0' max = '650'>";
     html = html + "   </div>";

  



     html = html + " <br> <div class='form-group'>";
     html = html + "     <label for='sortby_drop'>Sort by (Dropdown):</label>";
     html = html + "      <select id='sortby_drop' name='sortby_drop'>";
     html = html +  "<option value = 'median_household_weekly_income'>" + "Weekly income" + "</option>";
     html = html +  "<option value = 'median_age'>" + "Median age" + "</option>";
     html = html +  "<option value = 'median_mortgage_repay_monthly'>" + "Mortagage repayment" + "</option>";
     html = html +  "<option value = 'median_rent_weekly'>" + "Weekly rent" + "</option>";
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


        html = html + " <br>  <button type='submit' class='btn btn-primary'>Search</button>";
        html = html + "</form>";
       // getting inputs
       String state = context.formParam("state_drop");
       String sex = context.formParam("sex_drop");
       String incomeMin = context.formParam("incomerangemin");
       String incomeMax = context.formParam("incomerangemax");
       String ageMin = context.formParam("agerangemin");
       String ageMax = context.formParam("agerangemax");
       String mortgageMin = context.formParam("mortgagerangemin");
       String mortgageMax = context.formParam("mortgagerangemax");
       String rentMin = context.formParam("rentweeklymin");
       String rentMax = context.formParam("rentweeklymax");
       String sortBy = context.formParam("sortby_drop");
       String orderBy = context.formParam("orderby_drop");
       String year = context.formParam("year_drop");
       
       if ("All".equals(state)){
        html = html + outputRatioHomelessNoState(year, sortBy, orderBy);
    }
       
      else if ("All".equals(sex)){
           html = html + outputRatioHomeless(state, year, sortBy, orderBy, incomeMin, incomeMax, ageMin, ageMax, mortgageMin, mortgageMax, rentMin, rentMax);
       }
       
       else {
           System.out.print("no");
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

    public String outputRatioHomelessNoState(String year, String sortby, String orderby){
        String html = "";

        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<LGAST31> lgas = jdbc.getRatioHomelessNoState(year, sortby, orderby);


        html = html +"<table id='LGA'>" +
        "<tr>" +
            "<th> LGA</th>" +
            "<th> Ratio of homeless to total people</th>" +
           "<th> Median Weekly Income</th>" +
           "<th> Median age</th>" +
           "<th> Median Mortgage repayments</th>" +
           "<th> Median Weekly Rent</th>" +
        "</tr>";
for (LGAST31 lga : lgas) {
    int totalHomeless = lga.getTotalHomeless();
    double totalNumber = lga.getTotalNumber();
 html = html + "<tr>" + "<td>" + lga.getName() + "</td>" +
                        "<td>" + lga.getRatioHomelesstoTotal(totalHomeless, totalNumber) + "</td>" +
                        "<td>" + lga.getWeeklyIncome() + "</td>" +
                        "<td>" + lga.getMedianAge() + "</td>" +
                        "<td>" + lga.getMortgageRepay() + "</td>" +
                        "<td>" + lga.getRentWeekly() + "</td>" +
                "</tr>";
            }
html = html + "</table>";


        return html;
    }

    public String outputRatioHomeless(String state, String year, String sortBy, String orderBy, String incomeMin, String incomeMax, String ageMin, String ageMax, String mortgageMin, String mortgageMax, String rentMin, String rentMax){
        String html = "";

        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<LGAST31> lgas = jdbc.getRatioHomeless(state, year, sortBy, orderBy, incomeMin, incomeMax, ageMin, ageMax, mortgageMin, mortgageMax, rentMin, rentMax);


        html = html +"<table id='LGA'>" +
        "<tr>" +
            "<th> LGA</th>" +
            "<th> Ratio of homeless to total people</th>" +
           "<th> Median Weekly Income</th>" +
           "<th> Median age</th>" +
           "<th> Median Mortgage repayments</th>" +
           "<th> Median Weekly Rent</th>" +
        "</tr>";
for (LGAST31 lga : lgas) {
    int totalHomeless = lga.getTotalHomeless();
    double totalNumber = lga.getTotalNumber();
 html = html + "<tr>" + "<td>" + lga.getName() + "</td>" +
                        "<td>" + lga.getRatioHomelesstoTotal(totalHomeless, totalNumber) + "</td>" +
                        "<td>" + lga.getWeeklyIncome() + "</td>" +
                        "<td>" + lga.getMedianAge() + "</td>" +
                        "<td>" + lga.getMortgageRepay() + "</td>" +
                        "<td>" + lga.getRentWeekly() + "</td>" +
                "</tr>";
            }
html = html + "</table>";


        return html;
    }


}
