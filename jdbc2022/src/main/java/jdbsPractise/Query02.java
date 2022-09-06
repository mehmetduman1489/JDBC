package jdbsPractise;

import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //1. Adım: Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2. Adım: Database'e bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "fatmanur6594");

        //SORU: ogrenciler tablosundaki erkek ogrencileri listeleyiniz
        Statement st = con.createStatement();


        ResultSet data = st.executeQuery("SELECT * FROM ogrenciler where cinsiyet='E'");
        while (data.next()) {
            //index kullanarak
            System.out.println(data.getInt(1) +
                    data.getString(2) +
                    data.getString(3) +
                    data.getString(4));
            // sütun ismini kullanarak
            while (data.next()) {
                //index kullanarak
                System.out.println(data.getInt("okul_no") +
                        data.getString("ogrenci_ismi") +
                        data.getString("sinif") +
                        data.getString("cinsiyet"));

            }
        }


    }
}
