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
public class PageMission implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/mission.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Our Mission</title>";

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
                <h1>Our Mission</h1>
            </div>
        """;

        // Add Div for page Content
        html = html + "<div class='content'>";

         // Add HTML for the list of pages (as well as topnav)
         html = html + """
         <div class="bigbox2">   
            <p class="title"> 
                The Mission
            </p>

            <p class="reason"> 
                The reason we dedicated this website to homelessness is, because 
                it is a massive issue in Australia and is caused by many other 
                problems such as PTSD, domestic violence, gambling, Covid-19, and 
                natural disasters. It is important for us to educate people who 
                believe that people who are homeless are only homeless due to their 
                own fault. The aim of our website is to help spread awareness 
                and educate people in Australia about homelessness.  
            </p>

            <p class="title">
                Adressing the Social Challenge
            </p>

            <p class="reason">
                We address the social challenge of homeless in Australia through 
                technology. The website we created will provide basic information 
                about homelessness in Australia, as well as data, to uneducated readers. 
                It will also provide advanced statistics to those who may require it 
                for professional reasons. Users who want support our cause of fighting 
                homelessness in Australia can make donations at the bottom of our 
                page via the Red Cross.
            </p>

            <p class="title">
                Site Use
            </p>
        
            <ul class="reason">
                <li> Basic Information &#38; statistics </li>
                <li> Advanced Data </li>
                <li> Donations </li>
            </ul>
        </div>
    
        <div class="bigbox2">
            <p class="title">
                Sample Users
            </p>
            <div class="persona">
                <img class="personapic" src="hamid.jpg">

                <p class="name">
                    <strong> Name: </strong> Hamid the Baker 
                </p>

                <p class="description">
                    <strong> Description: </strong> Hamid is a 35-year-old refugee from Afghanistan 
                    due to hardships due to the war. He is a baker that 
                    occasionally gives away bread to homeless people, 
                    he wonders why there is such a large population of 
                    homeless people.
                </p>

                <p class="needs">
                    <strong> Needs: </strong> Needs general information on homeless people, 
                    nothing too complicated and information on how to help  
                </p>

                <p class="goals">
                    <strong> Goals: </strong> To learn about the homeless epidemic 
                    and what he can do to help 
                </p>

                <p class="sande">
                    <strong> Skills and experience: </strong> Basic computer knowledge, 
                    can use non-complex websites without issues 
                    but can struggle with complex or messy websites.
                </p>
            </div>   

            <div class="persona">
                <img class="personapic" src="sally.jpg">

                <p class="name">
                    <strong> Name: </strong> Sally the Student 
                </p>

                <p class="description">
                    <strong> Description: </strong> Sally is a 20-year-old university student 
                    studying at Latrobe University. She is doing a presentation 
                    on the homelessness epidemic in Australia. 
                </p>

                <p class="needs">
                    <strong> Needs: </strong> Needs statistics, graphs, and more in-depth 
                    information on homeless people in Australia as well 
                    as homelessness.
                </p>

                <p class="goals">
                    <strong> Goals: </strong> To create a presentation about homelessness 
                    for her university class on social issues.
                </p>

                <p class="sande">
                    <strong> Skills and experience: </strong> Skilled with most software 
                    related to university, good at finding necessary 
                    information on websites. 
                </p>
            </div>   
        </div>  
            """;

        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();
        
        


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
