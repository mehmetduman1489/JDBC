package jdbsPractise;


import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1. Adım: Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2. Adım: Database'e bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "fatmanur6594");

        //3. Adım: Statement oluştur.
        Statement st = con.createStatement();

        //4) ResultSet
        ResultSet veri = st.executeQuery("SELECT * FROM ogrenciler");
        //sonucları al
        while (veri.next()) {
            //index kullanarak
            System.out.println(veri.getInt(1) + veri.getString(2) + veri.getString(3) + veri.getString(4));
            // sütun ismini kullanarak
            System.out.println(veri.getInt("okul_no") + veri.getString("ogrenci_ismi") + veri.getString("sinif") + veri.getString("cinsiyet"));
        }
        // kapatma
        con.close();
        st.close();
        veri.close();


    }


}
