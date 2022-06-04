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

       html = html + "      <label for='ausvsstatevslga_drop'>Select Australia, State or LGA (Dropdown):</label>";
        html = html + "      <select id='ausvsstatevslga_drop' name='ausvsstatevslga_drop'>";
        //Add options through database
        
        
        // Add HTML for the movies list
        html = html +  "<option>" + "Australia" + "</option>"
       + "<option>" + "State" + "</option>"
       + "<option>" + "LGA" + "</option>"
    + "      </select>";

   html = html + "<label for='LGA'>Choose your LGA from the list:</label>" +
   "<input list='LGAS' name='LGA' id='LGA'>" +
   "<datalist id= 'LGAS'>";
           
   for (LGA lga : lgas) {
       html = html + "<option value ='" + lga.getName16() + "'>";
   }
   html = html + "</datalist>" +
"<input type='submit'>" +"</form>";

// add error checking for leaving box empty, incorrect typing

 

   ArrayList<String> ageRange = jdbc.getAgeRange();
   html = html + "      <label for='agerange_drop'>Select the age range (Dropdown):</label>";
       html = html + "      <select id='agerange_drop' name='agerange_drop'>";
       //Add options through database
       
       
       // Add HTML for the movies list
       html = html +  "<option>" + "0-9" + "</option>"
      + "<option>" + "10-19" + "</option>"
      + "<option>" + "20-29" + "</option>"
      + "<option>" + "30-39" + "</option>"
       +"<option>" + "40-49" + "</option>"
       +"<option>" + "50-59" + "</option>"
       +"<option>" + "60+" + "</option>";

       
       // Potential database
       //for (String ageGroup : ageRange) {
         //  html = html + "<option>" + ageGroup + "</option>";
       //}
       
       html = html + "      </select>";



       // sex options from database

       ArrayList<String> sexes = jdbc.getSex();
       html = html + "      <label for='movietype_drop'>Select the sex (Dropdown):</label>";
           html = html + "      <select id='movietype_drop' name='movietype_drop'>";
           //Add options through database
           
           
           // Add HTML for the movies list
           
           for (String sex : sexes) {
               html = html + "<option>" + sex + "</option>";
           }
           
           html = html + "      </select>";
           
           html = html + "<p>" +
           "<input type='radio' id='At Risk' name='At Risk vs Homeless' value='At Risk'>" +
           "<label for='At Risk'>At Risk</label><br>" +
          "<input type='radio' id='Homeless' name='At Risk vs Homeless' value='Homeless'>" +
          "<label for='Homeless'>Homeless</label><br>" +
          "</p>"
          ;
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

}
