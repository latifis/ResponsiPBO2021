
import java.sql.*;

public class Connector {
    String DBurl = "jdbc:mysql://localhost/perpustakaan";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    public Connector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.err.println("Koneksi gagal " + ex.getMessage());
        }
    }

    
}