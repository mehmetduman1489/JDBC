package jdbsPractise;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Class.forName("org.postgresql.Driver");

        //2. Adım: Database'e bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "fatmanur6594");
        Statement st = con.createStatement();
        //Statement st=con.createStatement();
        PreparedStatement ps = con.prepareStatement("select*from ogrenciler");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("surun sayisi: " + rsmd.getColumnCount());
        System.out.println("1. sutunun ismi: " + rsmd.getColumnName(1));
        System.out.println("2. sutunun ismi: " + rsmd.getColumnName(2));
        System.out.println("3. sutunun ismi: " + rsmd.getColumnName(3));
        System.out.println("4. sutunun ismi: " + rsmd.getColumnName(4));
        System.out.println("1.sutunun data tipi: " + rsmd.getColumnTypeName(1));
        System.out.println("2.sutunun data tipi: " + rsmd.getColumnTypeName(2));
        System.out.println("3.sutunun data tipi: " + rsmd.getColumnTypeName(3));
        System.out.println("4.sutunun data tipi: " + rsmd.getColumnTypeName(4));
        System.out.println("tablo ismin: " + rsmd.getTableName(2));


    }
}
