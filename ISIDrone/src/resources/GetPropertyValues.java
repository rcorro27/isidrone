package resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author samue
 */
public class GetPropertyValues {

    String result = "";
    InputStream inputStream;

    public String getPropValues() throws IOException {
        // https://crunchify.com/java-properties-file-how-to-read-config-properties-values-in-java/ pour le tutoriel de base 
        try {
            Properties prop = new Properties();
            String propFileName = "configs.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            String db_name = prop.getProperty("DB_NAME");
            String db_ip = prop.getProperty("DB_IP");
            String db_port = prop.getProperty("DB_PORT");
            String db_username = prop.getProperty("DB_USERNAME");
            String db_password = prop.getProperty("DB_PASSWORD");

            System.out.println("db_name = " + db_name);

            result = "db info: db name= " + db_name + ", db ip= " + db_ip + ", db port=" + db_port + ", db username" + db_username + ", db password" + db_password;
            System.out.println(result + "\nProgram Ran on " + time + " by user=samuel");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

        }
        return result;
    }
}
