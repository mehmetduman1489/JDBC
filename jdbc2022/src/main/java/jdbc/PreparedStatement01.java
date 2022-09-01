package jdbc;

import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "fatmanur6594");
        Statement st = con.createStatement();

//1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees
// değerini 9999 olarak güncelleyin.
        //1. adım. preparedStatement querysini olustur.
        String sql1 = "UPDATE companies SET number_of_employees = ? WHERE company = ?";

        //2. adım: preparedStatementobjesini olustur
        PreparedStatement pst1 = con.prepareStatement(sql1);
        // 3. adım: set... () methodları ile ? yerine değer gir
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        //4. adım: ExecuteQuery
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println("updateRowSayisi = " + updateRowSayisi);



        String sql2="select * from companies";

        ResultSet result1=st.executeQuery(sql2);
        while (result1.next())  {
            System.out.println(result1.getInt(1)+"---"+result1.getString(2)+"----"+result1.getInt(3));
        }

        //google için değişiklik
        pst1.setInt(1, 15000);
        pst1.setString(2, "GOOGLE");

        //4. adım: ExecuteQuery
        int updateRowSayisi1 = pst1.executeUpdate();
        System.out.println("updateRowSayisi = " + updateRowSayisi1);



        String sql3="select * from companies";

        ResultSet result3=st.executeQuery(sql3);
        while (result3.next())  {
            System.out.println(result3.getInt(1)+"---"+result3.getString(2)+"----"+result3.getInt(3));
        }
        //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.

        String sql4="select*from ?";
        PreparedStatement pst3=con.prepareStatement(sql4);
        pst3.setString(1,"companies");

        ResultSet result4=pst3.executeQuery();
        while(result4.next())   {
            System.out.println(result4.getInt(1)+"---"+result4.getString(2)+"----"+result4.getInt(3));
        }



    }
}
