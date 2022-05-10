import java.sql.*;

public class SignupService {
    public static String registraAccount(String email, String password, String nome, String cognome, Data birthDate, char genere){
        try {
            String searchQuery = "SELECT email FROM accounts WHERE email=?";
            Connection conn = MySQLService.getDBConnection();
            PreparedStatement pst = conn.prepareStatement(searchQuery);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()){
                conn.close();
                return "E' gia' presente un account con questa email!";
            }else{
                String addQuery = "INSERT INTO accounts (email, password, nome, cognome, birthDate, genere) VALUES (?, ?, ?, ?, ?, ?)";
                conn.close();
                Connection conn2 = MySQLService.getDBConnection();
                pst = conn2.prepareStatement(addQuery);
                pst.setString(1, email);
                pst.setString(2, password);
                pst.setString(3, nome);
                pst.setString(4, cognome);
                pst.setString(5, birthDate.toString());
                pst.setString(6, genere + "");
                pst.executeUpdate();
                conn2.close();
                return "Success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}
