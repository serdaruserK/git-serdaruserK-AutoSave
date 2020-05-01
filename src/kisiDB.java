
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sero
 */
public class kisiDB {
	private final String connectionUrl;
	private final String user;
	private final String pass;

	public kisiDB(String connectionUrl, String user, String pass) {
		this.connectionUrl = connectionUrl;
		this.user = user;
		this.pass = pass;
	}
	
	public ArrayList<Kisi> KisiListesi(){
		ArrayList<Kisi> Listem = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(connectionUrl, user, pass))
		{
		    Statement stmt = con.createStatement(); 
                    String SQL = "SELECT [kisiNo]" +"      ,[kisiAd]" +"      ,[kisiSoyad]" +"      ,[cinsiyet]" +"      ,[medeniHal]" +"      ,[telNo]" +"      ,[telBilgi]" +"      ,[eMail]" +"      ,[webAdres]" +"      ,[sosyalMedya] FROM [AutoSave].[dbo].[kimlikBilgileri]";
                        ResultSet rs = stmt.executeQuery(SQL);
       
			
			while(rs.next()){
				Kisi k=new Kisi();
				//Retrieve by column name
				k.setId(rs.getInt("kisiNo"));
				k.setAdi(rs.getString("kisiAd"));
				k.setSoyad(rs.getString("kisiSoyad"));
                                k.setcinsiyet(rs.getString("cinsiyet"));
				k.setmedeniHal(rs.getString("medeniHal"));
				k.settelNo(rs.getString("telNo"));
                                k.settelBilgi(rs.getString("telBilgi"));
				k.seteMail(rs.getString("eMail"));
				k.setwebAdres(rs.getString("webAdres"));
                                k.setsosyalMedya(rs.getString("sosyalMedya"));
				Listem.add(k);
			}
			rs.close();
			//con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return Listem;
	}
		
	public int KisiSil(String kisiNo)
	{
        int say = -1;
		Boolean giris_hazir = 
			(kisiNo.length()>0);		
		
		int id=-1;
		
		try {
			id = Integer.valueOf(kisiNo);
		} catch (Exception e) {
			return say;
		}
				
		if (!giris_hazir)
			return say;

        try (  Connection con = DriverManager.getConnection(connectionUrl,user,pass); ) 
        {
			String SQL1 = "DELETE FROM dbo.kimlikBilgileri WHERE kisiNo=?";
			PreparedStatement stmt = con.prepareStatement(SQL1);
			stmt.setInt(1, id);			
            say = stmt.executeUpdate();
			stmt.close();
            con.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
		
    	return say;
	}

	public int KisiGuncellle(String kisiNo, String kisiAd, String kisiSoyad,String cinsiyet, String medeniHal, String telNo, String telBilgi, String eMail, String webAdres, String sosyalMedya)
	{
        int say = -1;
		Boolean giris_hazir = 
			((kisiNo.length()>0) &&
			(kisiAd.length()>0) &&		
			(kisiSoyad.length()>0)&&
                        (cinsiyet.length()>0)&&
                        (medeniHal.length()>0)&&
                        (telNo.length()>0)&&
                        (telBilgi.length()>0)&&
                        (eMail.length()>0)&&
                        (webAdres.length()>0)&&
                        (sosyalMedya.length()>0));	
		
		int id=-1;
		
		try {
			id = Integer.valueOf(kisiNo);
		} catch (Exception e) {
			return say;
		}
				
		if (!giris_hazir)
			return say;

        try (  Connection con = DriverManager.getConnection(connectionUrl,user,pass); ) 
        {
			String SQL1 = "UPDATE dbo.kimlikBilgileri SET kisiAd=?,kisiSoyad=?,cinsiyet=?,medeniHal=?,telNo=?,telBilgi=?,eMail=?,webAdres=?,sosyalMedya=?, WHERE kisiNo= ?";
			PreparedStatement stmt = con.prepareStatement(SQL1);
			stmt.setString(1, kisiNo);		
			stmt.setString(2, kisiAd);		
			stmt.setString(3, kisiSoyad);
                        stmt.setString(4, cinsiyet );		
			stmt.setString(5, medeniHal);
                        stmt.setString(6, telNo);		
			stmt.setString(7, telBilgi);		
			stmt.setString(8, eMail);
                        stmt.setString(9, webAdres );		
			stmt.setString(10, sosyalMedya);

            say = stmt.executeUpdate();
			stmt.close();
            con.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
		
        return say;
	}

	public int KisiEkle(String kisiNo, String kisiAd, String kisiSoyad,String cinsiyet, String medeniHal, String telNo, String telBilgi, String eMail, String webAdres, String sosyalMedya)
	{
        int say = -1;
		Boolean giris_hazir = 
			((kisiNo.length()>0) &&
			(kisiAd.length()>0) &&		
			(kisiSoyad.length()>0)&&
                        (cinsiyet.length()>0)&&
                        (medeniHal.length()>0)&&
                        (telNo.length()>0)&&
                        (telBilgi.length()>0)&&
                        (eMail.length()>0)&&
                        (webAdres.length()>0)&&
                        (sosyalMedya.length()>0));
		
		if (!giris_hazir)
			return say;

        try (  Connection con = DriverManager.getConnection(connectionUrl,user,pass); ) 
        {
			String SQL1 = "INSERT INTO dbo.kimlikBilgileri (kisiNo,kisiAd,kisiSoyad,cinsiyet,medeniHal,telNo,telBilgi,eMail,webAdres,sosyalMedya) VALUES (?,?)";
			PreparedStatement stmt = con.prepareStatement(SQL1);
			stmt.setString(1, kisiNo);		
			stmt.setString(2, kisiAd);		
			stmt.setString(3, kisiSoyad);
                        stmt.setString(4, cinsiyet );		
			stmt.setString(5, medeniHal);
                        stmt.setString(6, telNo);		
			stmt.setString(7, telBilgi);		
			stmt.setString(8, eMail);
                        stmt.setString(9, webAdres );		
			stmt.setString(10, sosyalMedya);
            say = stmt.executeUpdate();
			stmt.close();
            con.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
		
		return say;
	}


    }
