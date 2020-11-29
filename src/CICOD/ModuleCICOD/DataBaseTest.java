package CICOD.ModuleCICOD;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseTest {
    static Connection con = null;
    private static Statement stmt;
    public static String DB_URL = "jdbc:driver://wfm-saas-db-staging.ctcp4ul1byzu.eu-west-1.rds.amazonaws.com:3306";
    public static String DB_USER = " wfm";
    public static String DB_PASSWORD = "Int3ractiv3@1";

    @BeforeTest
    public void setUp() throws Exception {
        try{
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass).newInstance();
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try{
            String query = "select * from testingdata";
            ResultSet res = stmt.executeQuery(query);
            while (res.next())
            {
                System.out.print(res.getString(1));
                System.out.print(" " + res.getString(2));
                System.out.print(" " + res.getString(3));
                System.out.println(" " + res.getString(4));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() throws Exception {
        if (con != null) {
            con.close();
        }
    }
}
