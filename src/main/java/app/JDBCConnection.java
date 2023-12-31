package app;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class JDBCConnection {

    // Name of database file (contained in database folder)
    //private static final String DATABASE = "jdbc:sqlite:database/ctg.db";

    // If you are using the Homelessness data set replace this with the below
    private static final String DATABASE = "jdbc:sqlite:database/homelessness.db";

    /**
     * This creates a JDBC Object so we can keep talking to the database
     */
    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    /**
     * Get all of the LGAs in the database.
     * @return
     *    Returns an ArrayList of LGA objects
     */
    public ArrayList<LGA> getLGAs() {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> lgas = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code16     = results.getInt("lga_code16");
                String name16  = results.getString("lga_name16");

                // Create a LGA Object
                LGA lga = new LGA(code16, name16);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    public int countLGAs() {
        int count = 0;
        // Create the ArrayList of LGA objects to return
        

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT COUNT(*) AS lgacount FROM LGA";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code16     = results.getInt("lgacount");
                

               ;

                // Add the lga object to the array
                
                count = code16;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        System.out.print(count);
        return count;
    }

    public int totalPopulation2016() {
        int count = 0;
        // Create the ArrayList of LGA objects to return
        

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(2016) AS Population2016 FROM Population";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code16     = results.getInt("Population2016");
                

               ;

                // Add the lga object to the array
                
                count = code16;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        System.out.print(count);
        return count;
    }

    public int totalPopulation2018() {
        int count = 0;
        // Create the ArrayList of LGA objects to return
        

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(2018) AS Population2018 FROM Population";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code16     = results.getInt("Population2018");
                

               ;

                // Add the lga object to the array
                
                count = code16;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        System.out.print(count);
        return count;
    }

    public ArrayList<String> getAgeRange() {
        // Create the ArrayList of LGA objects to return
        ArrayList<String> ageRange = new ArrayList<String>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DISTINCT age_group FROM HomelessGroup ORDER BY age_group";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String ageGroup  = results.getString("age_group");

                // Create a LGA Object
                
                ageRange.add(ageGroup);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return ageRange;
    }


    public ArrayList<String> getSex() {
        // Create the ArrayList of LGA objects to return
        ArrayList<String> sexes = new ArrayList<String>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DISTINCT sex FROM HomelessGroup ORDER BY sex";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String sex  = results.getString("sex");

                // Create a LGA Object
                
                sexes.add(sex);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return sexes;
    }

    public int getCountBySex(String lga_name16, String sex, String year) {
        // Create the ArrayList of LGA objects to return
        int sexCount = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup JOIN LGA L ON lga_code = lga_code16 WHERE lga_name16 = '" + lga_name16 + "' AND sex = '" + sex + "'AND year = '" + year + "'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int sexresult  = results.getInt("Count");

                // Create a LGA Object
                
                sexCount = sexresult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return sexCount;
    }
    public int getCountByAge(String lga_name16, String age, String year) {
        // Create the ArrayList of LGA objects to return
        int count = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup JOIN LGA L ON lga_code = lga_code16 WHERE lga_name16 = '" + lga_name16 + "'AND age_group = '_" + age + "'AND year = '" + year + "'";
            System.out.println(query);
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int ageResult  = results.getInt("Count");

                // Create a LGA Object
                
                count = ageResult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return count;
    }



    public int getCountByLGAAndStatus(String lga_name16, String status, String year) {
        // Create the ArrayList of LGA objects to return
        int lgaCount = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup H JOIN LGA L ON lga_code = lga_code16 WHERE lga_name16 = '" + lga_name16 + "' AND status = '" + status + "'AND year ='" + year + "'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int lgaResult  = results.getInt("Count");

                // Create a LGA Object
                
                lgaCount = lgaResult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgaCount;
    }
    public int getCountByLGAAndAge(String lga_name16, String age, String status, String year) {
        // Create the ArrayList of LGA objects to return
        int lgaCount = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup H JOIN LGA L ON lga_code = lga_code16 WHERE lga_name16 = '" + lga_name16 + "' AND age_group ='_" + age + "'AND status = '" + status + "'AND year ='" + year + "'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int lgaResult  = results.getInt("Count");

                // Create a LGA Object
                
                lgaCount = lgaResult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgaCount;
    }
    
    public int getCountByLGAAndAgeNoStatus(String lga_name16, String age, String year) {
        // Create the ArrayList of LGA objects to return
        int lgaCount = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup H JOIN LGA L ON lga_code = lga_code16 WHERE lga_name16 = '" + lga_name16 + "' AND age_group ='_" + age + "AND year ='" + year + "'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int lgaResult  = results.getInt("Count");

                // Create a LGA Object
                
                lgaCount = lgaResult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgaCount;
    }


    public int getCountByLGAAndAgeAndSex(String lga_name16, String age, String sex, String status, String year) {
        // Create the ArrayList of LGA objects to return
        int lgaCount = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup H JOIN LGA L ON lga_code = lga_code16 WHERE lga_name16 = '" + lga_name16 + "' AND age_group ='_" + age + "' AND sex = '" + sex + "'AND status = '" + status + "'AND year ='" + year + "'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int lgaResult  = results.getInt("Count");

                // Create a LGA Object
                
                lgaCount = lgaResult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgaCount;
    }


    public int getCountByAgeAndSex(String lga_name16, String age, String sex, String year) {
        // Create the ArrayList of LGA objects to return
        int lgaCount = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup H JOIN LGA L ON lga_code = lga_code16 WHERE lga_name16 = '" + lga_name16 + "' AND age_group ='_" + age + "' AND sex = '" + sex + "'AND year ='" + year + "'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int lgaResult  = results.getInt("Count");

                // Create a LGA Object
                
                lgaCount = lgaResult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgaCount;
    }


    public int getCountByLGAAndSex(String lga_name16, String sex, String status, String year) {
        // Create the ArrayList of LGA objects to return
        int lgaCount = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup H JOIN LGA L ON lga_code = lga_code16 WHERE lga_name16 = '" + lga_name16 + "' AND sex ='" + sex + "'AND status = '" + status + "'AND year ='" + year + "'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int lgaResult  = results.getInt("Count");

                // Create a LGA Object
                
                lgaCount = lgaResult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgaCount;
    }

    public int getCountByLGAAndSexNoStatus(String lga_name16, String sex, String year) {
        // Create the ArrayList of LGA objects to return
        int lgaCount = 0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup H JOIN LGA L ON lga_code = lga_code16 WHERE lga_name16 = '" + lga_name16 + "' AND sex ='" + sex + "'AND year ='" + year+ "'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int lgaResult  = results.getInt("Count");

                // Create a LGA Object
                
                lgaCount = lgaResult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgaCount;
    }
    
    public ArrayList<LGAST21> getLGAFromAllFactors(String age, String sex, String status, String order, String year) {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGAST21> lgas = new ArrayList<LGAST21>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE age_group = '_" + age + "'AND sex = '" + sex + "' AND status = '" + status + "' AND year ='" + year + "'GROUP BY h.lga_code ORDER BY count " + order;
            
            // Get Result
            ResultSet results = statement.executeQuery(query);
            System.out.println(query);
            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String name  = results.getString("lga_name16");
                int count = results.getInt("count");
                double population = 0.0;
                if ("2016".equals(year)){
                    population = results.getDouble("pop2016");
                }
                else{
                    population = results.getDouble("pop2018");
                }
                double proportion = ((count / population) * 100.0);

                // Create a LGA Object
                LGAST21 lga = new LGAST21(name, count, proportion);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    public ArrayList<LGAST21> getLGAFromAge(String age, String status, String order, String year) {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGAST21> lgas = new ArrayList<LGAST21>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE age_group = '_" + age + "' AND status = '" + status + "' AND year ='" + year + "'GROUP BY h.lga_code ORDER BY count " + order;
            
            // Get Result
            ResultSet results = statement.executeQuery(query);
            System.out.println(query);
            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String name  = results.getString("lga_name16");
                int count = results.getInt("count");
                double population = 0.0;
                if ("2016".equals(year)){
                    population = results.getDouble("pop2016");
                }
                else{
                    population = results.getDouble("pop2018");
                }
                double proportion = ((count / population) * 100.0);

                // Create a LGA Object
                LGAST21 lga = new LGAST21(name, count, proportion);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    public ArrayList<LGAST21> getLGAFromSex(String sex, String status, String order, String year) {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGAST21> lgas = new ArrayList<LGAST21>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE sex = '" + sex + "' AND status = '" + status + "' AND year ='" + year + "'GROUP BY h.lga_code ORDER BY count " + order;
            
            // Get Result
            ResultSet results = statement.executeQuery(query);
            System.out.println(query);
            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String name  = results.getString("lga_name16");
                int count = results.getInt("count");
                double population = 0.0;
                if ("2016".equals(year)){
                    population = results.getDouble("pop2016");
                }
                else{
                    population = results.getDouble("pop2018");
                }
                double proportion = ((count / population) * 100.0);

                // Create a LGA Object
                LGAST21 lga = new LGAST21(name, count, proportion);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    public ArrayList<LGAST21> getLGAFromStatus(String status, String order, String year) {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGAST21> lgas = new ArrayList<LGAST21>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE status = '" + status + "' AND year ='" + year + "'GROUP BY h.lga_code ORDER BY count " + order;
            
            // Get Result
            ResultSet results = statement.executeQuery(query);
            System.out.println(query);
            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String name  = results.getString("lga_name16");
                int count = results.getInt("count");
                double population = 0.0;
                if ("2016".equals(year)){
                    population = results.getDouble("pop2016");
                }
                else{
                    population = results.getDouble("pop2018");
                }
                double proportion = ((count / population) * 100.0);

                // Create a LGA Object
                LGAST21 lga = new LGAST21(name, count, proportion);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }


    

    public ArrayList<LGAST22> getLGAInfo2016NoStatus(String lganame, String year) {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGAST22> lgas = new ArrayList<LGAST22>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_name16 = '" + lganame + "' AND year = '" + year +"'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);
            System.out.println(query);
            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String name  = results.getString("lga_name16");
                String type = results.getString("lga_type16");
                String state = "";
                int population = 0;
                if ("2016".equals(year)){
                    population = results.getInt("pop2016");
                }
                else{
                    population = results.getInt("pop2018");
                }
                double area = results.getDouble("area_sqkm");
                int lgaCode = results.getInt("lga_code16");
                // Create a LGA Object
                LGAST22 lga = new LGAST22(name, state, type, area, population, lgaCode);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    public double getPopulationOfLGA(String lga_name16, String year) {
        // Create the ArrayList of LGA objects to return
        double lgaCount = 0.0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup H JOIN LGA L ON lga_code = lga_code16 WHERE lga_name16 = '" + lga_name16 + "' AND year ='" + year + "'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                double lgaResult  = results.getInt("Count");

                // Create a LGA Object
                
                lgaCount = lgaResult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgaCount;
    }


    public double getPopulationOfState(String lga_name16, int firstDigit, String year) {
        // Create the ArrayList of LGA objects to return
        double lgaCount = 0.0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup H JOIN LGA L ON lga_code = lga_code16 WHERE lga_code16 LIKE '" + firstDigit + "%' AND year ='" + year + "'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);
            System.out.println(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                double lgaResult  = results.getInt("Count");

                // Create a LGA Object
                
                lgaCount = lgaResult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgaCount;
    }


    public double getPopulationOfAus(String lga_name16, String year) {
        // Create the ArrayList of LGA objects to return
        double lgaCount = 0.0;

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT SUM(COUNT) AS Count FROM HomelessGroup H JOIN LGA L ON lga_code = lga_code16 WHERE year ='" + year + "'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                double lgaResult  = results.getInt("Count");

                // Create a LGA Object
                
                lgaCount = lgaResult;
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgaCount;
    }


// subtask 3.1


public ArrayList<LGAST31> getRatioHomeless(String state, String year, String sortBy, String orderBy, String incomeMin, String incomeMax, String ageMin, String ageMax, String mortgageMin, String mortgageMax, String rentMin, String rentMax, String sex, String age) {
    // Create the ArrayList of LGA objects to return
    ArrayList<LGAST31> lgas = new ArrayList<LGAST31>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        


        // The Query
        String query; 
        
        if ("All".equals(state) && "All".equals(sex) &&"All".equals(age)){
            query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
        }
        else if ("All".equals(sex) && "All".equals(age)) {
        
       query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
        }
        else if ("All".equals(state) && "All".equals(sex)){
          query =   "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " AND age_group = '_" + age + "' GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
        }
        else if ("All".equals(state) && "All".equals(age)){
            query =   "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " AND sex = '" + sex + "' GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
          }
         
         else if ("All".equals(state)){
            query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " AND age_group = '_" + age + "' AND sex = '" + sex + "' GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
        }

          else if ("All".equals(age)){
            query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " AND age_group = '_" + age + "' GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
          }
          else {
              query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " AND sex = '" + sex + "' GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
          }
        // Get Result
        ResultSet results = statement.executeQuery(query);
        System.out.println(query);
        // Process all of the results
        while (results.next()) {
            // Lookup the columns we need
            String name  = results.getString("lga_name16");
            int totalHomeless = results.getInt("sumCount");
           double totalNumber = 0.0;
           
           
           
           if ("2016".equals(year)){
               totalNumber = results.getDouble("pop2016");
           }
           else{
               totalNumber = results.getDouble("pop2018");
           }
           double ratioHomelesstoTotal = 0.0;
           int weeklyIncome = results.getInt("median_household_weekly_income");
           int medianAge = results.getInt("median_age");
           int mortgageRepay = results.getInt("median_mortgage_repay_monthly");
           int rentWeekly = results.getInt("median_rent_weekly");
           
           
            // Create a LGA Object
            LGAST31 lga = new LGAST31(name, totalHomeless, totalNumber, ratioHomelesstoTotal, weeklyIncome, medianAge, mortgageRepay, rentWeekly);

            // Add the lga object to the array
            lgas.add(lga);
        }

        // Close the statement because we are done with it
        statement.close();
    } catch (SQLException e) {
        // If there is an error, lets just pring the error
        System.err.println(e.getMessage());
    } finally {
        // Safety code to cleanup
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    // Finally we return all of the lga
    return lgas;
 }





public ArrayList<LGAST31Age> getRatioHomelessAgeandSex(String state, String year, String sortBy, String orderBy, String incomeMin, String incomeMax, String ageMin, String ageMax, String mortgageMin, String mortgageMax, String rentMin, String rentMax, String sex, String age) {
    // Create the ArrayList of LGA objects to return
    ArrayList<LGAST31Age> lgasAge = new ArrayList<LGAST31Age>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        


        // The Query
        String query; 
        
        if ("All".equals(state) && "All".equals(sex) &&"All".equals(age)){
            query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
        }
        else if ("All".equals(sex) && "All".equals(age)) {
        
       query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
        }
        else if ("All".equals(state) && "All".equals(sex)){
          query =   "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " AND age_group = '_" + age + "' GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
        }
        else if ("All".equals(state) && "All".equals(age)){
            query =   "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " AND sex = '" + sex + "' GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
          }
          else if ("All".equals(age)){
            query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " AND age_group = '_" + age + "' GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
          }
          else {
              query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '" + year + "' AND status = 'homeless' AND median_household_weekly_income >="+ incomeMin + " AND median_household_weekly_income <=" + incomeMax + " AND median_age >="+ ageMin + " AND median_age <=" + ageMax + " AND median_mortgage_repay_monthly >="+ mortgageMin + " AND median_mortgage_repay_monthly <=" + mortgageMax + " AND median_rent_weekly >="+ rentMin + " AND median_rent_weekly <=" + rentMax + " AND sex = '" + sex + "' GROUP BY i.lga_code ORDER BY " + sortBy + " " + orderBy;
          }
        // Get Result
        ResultSet results = statement.executeQuery(query);
        System.out.println(query);
        // Process all of the results
        while (results.next()) {
            // Lookup the columns we need
           int totalHomelessAgeandSex = results.getInt("sumCount");
           double totalNumber = 0.0;
           double ratioHomelesstoTotalAgeandSex = 0.0;
           
           
           if ("2016".equals(year)){
               totalNumber = results.getDouble("pop2016");
           }
           else{
               totalNumber = results.getDouble("pop2018");
           }
           
           
            // Create a LGA Object
                LGAST31Age lgaAge = new LGAST31Age(totalNumber, totalHomelessAgeandSex, ratioHomelesstoTotalAgeandSex);

            // Add the lga object to the array
            lgasAge.add(lgaAge);
        }

        // Close the statement because we are done with it
        statement.close();
    } catch (SQLException e) {
        // If there is an error, lets just pring the error
        System.err.println(e.getMessage());
    } finally {
        // Safety code to cleanup
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    // Finally we return all of the lga
    return lgasAge;
}


/*public ArrayList<LGAST31> getRatioHomelessNoState(String year, String sortby, String orderby) {
    // Create the ArrayList of LGA objects to return
    ArrayList<LGAST31> lgas = new ArrayList<LGAST31>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        String query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code JOIN income i ON i.lga_code = h.lga_code WHERE year = '" + year + "' AND status = 'homeless' GROUP BY i.lga_code ORDER BY " + sortby + " " + orderby;
        
        // Get Result
        ResultSet results = statement.executeQuery(query);
        System.out.println(query);
        // Process all of the results
        while (results.next()) {
            // Lookup the columns we need
            String name  = results.getString("lga_name16");
            int totalHomeless = results.getInt("sumCount");
           double totalNumber = 0.0;
           if ("2016".equals(year)){
               totalNumber = results.getDouble("pop2016");
           }
           else{
               totalNumber = results.getDouble("pop2018");
           }
           double ratioHomelesstoTotal = 0.0;
           int weeklyIncome = results.getInt("median_household_weekly_income");
           int medianAge = results.getInt("median_age");
           int mortgageRepay = results.getInt("median_mortgage_repay_monthly");
           int rentWeekly = results.getInt("median_rent_weekly");
            // Create a LGA Object
            LGAST31 lga = new LGAST31(name, totalHomeless, totalNumber, ratioHomelesstoTotal, weeklyIncome, medianAge, mortgageRepay, rentWeekly);

            // Add the lga object to the array
            lgas.add(lga);
        }

        // Close the statement because we are done with it
        statement.close();
    } catch (SQLException e) {
        // If there is an error, lets just pring the error
        System.err.println(e.getMessage());
    } finally {
        // Safety code to cleanup
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    // Finally we return all of the lga
    return lgas;
}
*/
// subtask 3.2


public ArrayList<LGAST32Homeless2016> getChangeHomeless2016(String state, String sex, String age) {
    // Create the ArrayList of LGA objects to return
    ArrayList<LGAST32Homeless2016> lgas = new ArrayList<LGAST32Homeless2016>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        


        // The Query
        String query; 
        
       
        if ("All".equals(sex) && "All".equals(age)) {
        
       query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2016' AND status = 'homeless' GROUP BY h.lga_code";
        }
         
         else if ("All".equals(sex)){
            query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2016' AND status = 'homeless' AND age_group = '_" + age + "' GROUP BY h.lga_code";
        }

          else if ("All".equals(age)){
            query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2016' AND status = 'homeless' AND sex = '" + sex + " GROUP BY h.lga_code";
          }
          else {
              query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2016' AND status = 'homeless' AND age_group = '_" + age + "' AND sex = '" + sex + " GROUP BY h.lga_code";
          }
        // Get Result
        ResultSet results = statement.executeQuery(query);
        System.out.println(query);
        // Process all of the results
        while (results.next()) {
            // Lookup the columns we need
            String name  = results.getString("lga_name16");
            int homeless2016 = results.getInt("sumCount");
            int homeless2018 = 0;
           
            // Create a LGA Object
            LGAST32Homeless2016 lga = new LGAST32Homeless2016(name, homeless2016, homeless2018);

            // Add the lga object to the array
            lgas.add(lga);
        }

   // Close the statement because we are done with it
        statement.close();
    } catch (SQLException e) {
        // If there is an error, lets just pring the error
        System.err.println(e.getMessage());
    } finally {
        // Safety code to cleanup
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }
         
    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        
        String query; 
       
        if ("All".equals(sex) && "All".equals(age)) {
        
        query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2018' AND status = 'homeless' GROUP BY h.lga_code";
        }
         
         else if ("All".equals(sex)){
            query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2018' AND status = 'homeless' AND age_group = '_" + age + "' GROUP BY h.lga_code";
        }

          else if ("All".equals(age)){
            query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2018' AND status = 'homeless' AND sex = '" + sex + " GROUP BY h.lga_code";
          }
          else {
              query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2018' AND status = 'homeless' AND age_group = '_" + age + "' AND sex = '" + sex + " GROUP BY h.lga_code";
          }
        // Get Result
         ResultSet results = statement.executeQuery(query);
        System.out.println(query);
        // Process all of the results
        while (results.next()) {
            // Lookup the columns we need
            String name  = results.getString("lga_name16");
            int homeless2016 = 0;
            int homeless2018 = results.getInt("sumCount");
           
           
            // Create a LGA Object
            LGAST32Homeless2016 lga2 = new LGAST32Homeless2016(name, homeless2016, homeless2018);

            // Add the lga object to the array
            lgas.add(lga2);
        }

        // Close the statement because we are done with it
        statement.close();
    } catch (SQLException e) {
        // If there is an error, lets just pring the error
        System.err.println(e.getMessage());
    } finally {
        // Safety code to cleanup
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    // Finally we return all of the lga
    return lgas;
 }

 public ArrayList<LGAST32Homeless2018> getChangeHomeless2018(String state, String sex, String age) {
    // Create the ArrayList of LGA objects to return
    ArrayList<LGAST32Homeless2018> lgas = new ArrayList<LGAST32Homeless2018>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        


        // The Query
        String query; 
        
       
        if ("All".equals(sex) && "All".equals(age)) {
        
       query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2018' AND status = 'homeless' GROUP BY h.lga_code";
        }
         
         else if ("All".equals(sex)){
            query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2018' AND status = 'homeless' AND age_group = '_" + age + "' GROUP BY h.lga_code";
        }

          else if ("All".equals(age)){
            query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2018' AND status = 'homeless' AND sex = '" + sex + " GROUP BY h.lga_code";
          }
          else {
              query = "SELECT sum(count) AS sumCount, * FROM HomelessGroup h JOIN LGA L ON h.lga_code = lga_code16 JOIN Population P ON p.lga_code = h.lga_code WHERE lga_code16 LIKE '" + state + "%' AND year = '2018' AND status = 'homeless' AND age_group = '_" + age + "' AND sex = '" + sex + " GROUP BY h.lga_code";
          }
        // Get Result
        ResultSet results = statement.executeQuery(query);
        System.out.println(query);
        // Process all of the results
        while (results.next()) {
            // Lookup the columns we need
            String name  = results.getString("lga_name16");
            int homeless2018 = results.getInt("sumCount");
           
           
            // Create a LGA Object
            LGAST32Homeless2018 lga = new LGAST32Homeless2018(name, homeless2018);

            // Add the lga object to the array
            lgas.add(lga);
        }

        // Close the statement because we are done with it
        statement.close();
    } catch (SQLException e) {
        // If there is an error, lets just pring the error
        System.err.println(e.getMessage());
    } finally {
        // Safety code to cleanup
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    // Finally we return all of the lga
    return lgas;
 }


// personas

public ArrayList<Persona> getPersonas(String personaName) {
    // Create the ArrayList of LGA objects to return
    ArrayList<Persona> personas = new ArrayList<Persona>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        String query = "SELECT * from persona p JOIN personaattributes pa ON p.name = pa.name WHERE p.name = '" + personaName +"'";
        
        // Get Result
        ResultSet results = statement.executeQuery(query);
        System.out.println(query);
        // Process all of the results
        while (results.next()) {
            // Lookup the columns we need
            String name  = results.getString("Name");
            String imageFilepath = results.getString("imagelink");
            String description = results.getString("description");
           String needs = results.getString("description");
           String goals = results.getString("description");
           String skillsandxp = results.getString("description");
            // Create a LGA Object
            Persona personaInfo = new Persona(name, imageFilepath, description, needs, goals, skillsandxp);

            // Add the lga object to the array
            personas.add(personaInfo);
        }

        // Close the statement because we are done with it
        statement.close();
    } catch (SQLException e) {
        // If there is an error, lets just pring the error
        System.err.println(e.getMessage());
    } finally {
        // Safety code to cleanup
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    // Finally we return all of the lga
    return personas;
}

    // TODO: Add your required methods here
}
