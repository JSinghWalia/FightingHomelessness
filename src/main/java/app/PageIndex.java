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
public class PageIndex implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Homepage</title>";

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
                <h1>
                    <img src='homelessman.jpg' class='top-image' alt='Homeless man lying on bench'>
                    Homepage
                </h1>
            </div>
        """;

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add HTML for the list of pages (as well as topnav)
        html = html + """
         <div class="big-box">
            <p class="bigpara">
                Homelessness is a predicament that is beyond the condition 
                of having access to no home.  
            </p>   
            
            <p class="smallpara">
                Homelessness impacts more men than women, and it impacts them 
                differently. Domestic violence is the number one cause of 
                homelessness for women, while men are more likely to experience 
                chronic homelessness. Women often have young children and nearly 
                half of all homeless are under the age of 25. 
                A disproportionate number are indigenous, or born overseas. Facing 
                barriers to things like employment and private rental, or 
                lacking in strong social support networks place people at a higher 
                risk of homelessness. This is why specialised community supports are 
                a vital part of addressing the issue.
            </p>
         </div>
        
         <div class="big-box">
            <div class="box1">
            <img class="factpic" src="fact1.jpg">
                <p class= "facts">
                    Fact #1 
                </p>

                <p class= "facts">
                    In 2018 the age range of 20-29 had the highest number 
                    of people who were most prone to becoming homeless 
                    (with almost 20,000 being at risk Australia wide)
                </p>
            </div>

            <div class="box1">
            <img class ="factpic" src="fact2.jpg">
                <p class= "facts">
                    Fact #2 
                </p>

                <p class= "facts">
                    In 2016 females had the highest number of people 
                    who were prone to becoming homeless 
                    (with over 20,000 being at risk across Australia)
                </p>
            </div>

            <div class="box1">
            <img class="factpic" src="fact3.webp">
                <p class= "facts">
                    Fact #3
                </p>

                <p class= "facts">
                    In 2018, approximately 43, 429 children aged between
                    0 and 9 were either homeless or at risk of 
                    being homeless
                </p>
            </div>
        </div>



            
            
            """;
            JDBCConnection jdbc = new JDBCConnection();
            
            html = html + "Total number of LGAs: " + jdbc.countLGAs()

            + "<br>" + "Total population in 2016: " + jdbc.totalPopulation2016()

            + "<br>" + "Total population in 2018: " + jdbc.totalPopulation2018();

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
