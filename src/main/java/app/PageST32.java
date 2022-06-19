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
public class PageST32 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page6.html";

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
            <div class="header6">
                <div class="header-text">
                    <h1>
                        Change in Homelessness over time
                    </h1>
                </div>
            </div>
        """;

       // Add Div for page Content
       html = html + "<div class='content'>";
       html = html + "<form action='/page6.html' method='post'>";


       html = html + "     <div class='form-group'>";
       html = html + "     <label for='state_drop'>Select the state (Dropdown):</label>";
       html = html + "      <select id='state_drop' name='state_drop'>";
       html = html +  "<option value = 'All'>" + "All" + "</option>";
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


       html = html + " <br>  <button type='submit' class='btn btn-primary'>Search</button>";
       html = html + "</form>";
      // getting inputs
      String state = context.formParam("state_drop");
      String sex = context.formParam("sex_drop");
      String age = context.formParam("agerange_drop");
      
      
      if (state == null || state == "") {
       html = html + "<h2><i>Press search or change filters to begin</i></h2>";
     }
else{
    html =  html +  outputHomeless(state, sex, age);
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

   

   public String outputHomeless(String state, String sex, String age){
       String html = "";

       JDBCConnection jdbc = new JDBCConnection();
       ArrayList<LGAST32Homeless2016> lgas = jdbc.getChangeHomeless2016(state, sex, age);
       

       html = html +"<table id='LGA'>" +
       "<tr>" +
           "<th> LGA</th>" +
           "<th> Total change in homeless people</th>" +
          "<th> Percantage change in homeless people</th>" +
          "<th> Total change in at risk people</th>" +
          "<th> Percantage change in at risk people</th>" +
          "<th> Total change in total population</th>" +
          "<th> Percantage change in total population</th>" +
       "</tr>";
for (LGAST32Homeless2016 lga : lgas) {
   int homeless2016 = lga.get2016Homeless();
   int homeless2018 = lga.get2018Homeless();
   int totalChangeHomeless = homeless2018 - homeless2016;
   // double percentChangeHomeless = ((homeless2018 - homeless2016)/homeless2016) * 100.0;
   
html = html + "<tr>" + "<td>" + lga.getName() + "</td>" +
                       "<td>" + totalChangeHomeless + "</td>" +
                      // "<td>" + percentChangeHomeless + "</td>" +
                      
               "</tr>";
           }
html = html + "</table>";


       return html;
   }


}
