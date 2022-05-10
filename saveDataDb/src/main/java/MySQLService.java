import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLService {
    public static Connection getDBConnection(){
        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            /**
             *
             * L'URL DELLA CONNESSIONE DEVE ESSERE DIVERSO PER OGNUNO PERCHE' DEVE CONNETTERSI AL DATABASE
             */
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/loginsignupjavadb?user=root&password=");
            if (conn == null){
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsignupjavadb?user=root&password=");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
