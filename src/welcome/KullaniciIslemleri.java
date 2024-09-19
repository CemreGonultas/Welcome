/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package welcome;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class KullaniciIslemleri {
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ArrayList<Kullanicilar> kullanicilariGetir(){
        ArrayList<Kullanicilar> cikti = new ArrayList<Kullanicilar>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select*from kullanicilar";
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String country = rs.getString("country");
                String city = rs.getString("city");
                String mail = rs.getString("mail");
                cikti.add(new Kullanicilar(id,name,surname,country,city,mail));

            }
            return cikti;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KullaniciIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public void kullaniciSil(int id){
        String sorgu = "Delete from kullanicilar where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1,id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KullaniciIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
     public void kullaniciEkle(String name,String surname,String country,String city,String mail,String username,String password) {
        String sorgu = "Insert Into kullanicilar (name,surname,country,city,mail,username,password) VALUES(?,?,?,?,?,?,?)";
        try {
            
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, country);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, mail);
            preparedStatement.setString(6, username);
            preparedStatement.setString(7, password);
            preparedStatement.executeUpdate();
           
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KullaniciIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     }
    
    public boolean girisYap(String kullanici_adi,String parola) {
        
        try {
            String sorgu =  "Select * From adminler where username = ? and password = ?";
            
            
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1,kullanici_adi);
            preparedStatement.setString(2,parola);
            
            ResultSet rs =  preparedStatement.executeQuery();
           return rs.next();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;

        }
     public boolean girisYapTwo(String kullanici_adi,String parola) {
        
        try {
            String sorgu =  "Select * From kullanicilar where username = ? and password = ?";
            
            
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1,kullanici_adi);
            preparedStatement.setString(2,parola);
            
            ResultSet rs =  preparedStatement.executeQuery();
           return rs.next();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;

        }
    
     public KullaniciIslemleri() {
        
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }
        
        
        try {
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Bağlantı Başarılı...");
            
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            //ex.printStackTrace();
        }
        
        
    }
    
}
