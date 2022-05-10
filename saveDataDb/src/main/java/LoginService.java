import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    public static Account authenticateUser(String email, String password){
        Account account;
        String query = "SELECT * FROM accounts WHERE email=?";
        Connection conn = MySQLService.getDBConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            //System.out.println(rs.toString());
            if (rs.next()){
                System.out.println(rs.getString(2) + "    "  + password);
                if (rs.getString(2).equals(password)){
                    System.out.println("Sono uguali");
                    resultAccount = new ResultAccount(new Account(email, password, rs.getString(3), rs.getString(4), new Data(rs.getDate(5).toString()), rs.getString(6).charAt(0)), "Success");
                    conn.close();
                    return resultAccount;
                }else{
                    System.out.println("Sono diversi");
                    conn.close();
                    return new ResultAccount(null, "Password Errata");
                }
            }else{
                conn.close();
                return new ResultAccount(null, "Account Inesistente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResultAccount(null, "Error");
    }
}
