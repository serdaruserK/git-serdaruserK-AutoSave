
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
public class aracDB {
    private final String connectionUrl;
	private final String user;
	private final String pass;

	public aracDB(String connectionUrl, String user, String pass) {
		this.connectionUrl = connectionUrl;
		this.user = user;
		this.pass = pass;
	}
	
	public ArrayList<arac> AracListesi(){
		ArrayList<arac> Listem = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(connectionUrl, user, pass))
		{
		    Statement stmt = con.createStatement(); 
                    String SQL = "SELECT [aracNo]" +"      [model]" +"      [beygirGucu]" +"      [motorBilgi]" +"      [aMKaydı]" +"      [uretimYeri]" +"      [uretimYili]" +"  FROM [AutoSave].[dbo].[aracBilgileri]";
                        ResultSet rs = stmt.executeQuery(SQL);
       
			
			while(rs.next()){
				arac k=new arac();
				//Retrieve by column name
				k.setaracNo(rs.getInt("aracNo"));
				k.setmodel(rs.getString("model"));
				k.setbeygirGucu(rs.getString("beygirGucu"));
                                k.setmotorBilgi(rs.getString("motorBilgi"));
				k.setaMKaydı(rs.getString("aMKaydı"));
				k.seturetimYeri(rs.getString("uretimYeri"));
                                k.seturetimYili(rs.getString("uretimYili"));
				Listem.add(k);
			}
			rs.close();
			//con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return Listem;
	}
		
	public int AracSil(String aracNo)
	{
        int say = -1;
		Boolean giris_hazir = 
			(aracNo.length()>0);		
		
		int id=-1;
		
		try {
			id = Integer.valueOf(aracNo);
		} catch (Exception e) {
			return say;
		}
				
		if (!giris_hazir)
			return say;

        try (  Connection con = DriverManager.getConnection(connectionUrl,user,pass); ) 
        {
			String SQL1 = "DELETE FROM dbo.aracBilgileri WHERE aracNo=?";
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

	public int AracGuncellle(String aracNo, String model, String beygirGucu,String motorBilgi, String aMKaydı, String uretimYeri, String uretimYili)
	{
        int say = -1;
		Boolean giris_hazir = 
			((aracNo.length()>0) &&
			(model.length()>0) &&		
			(beygirGucu.length()>0)&&
                        ( motorBilgi.length()>0)&&
                        (aMKaydı.length()>0)&&
                        (uretimYeri.length()>0)&&
                        (uretimYili.length()>0));	
		
		int id=-1;
		
		try {
			id = Integer.valueOf(aracNo);
		} catch (Exception e) {
			return say;
		}
				
		if (!giris_hazir)
			return say;

        try (  Connection con = DriverManager.getConnection(connectionUrl,user,pass); ) 
        {
			String SQL1 = "UPDATE dbo.aracBilgileri SET model=?, beygirGucu=?,motorBilgi=?,aMKaydı=?,uretimYeri=?,uretimYili=?, WHERE aracNo= ?";
			PreparedStatement stmt = con.prepareStatement(SQL1);
			stmt.setString(1, aracNo);		
			stmt.setString(2, model);		
			stmt.setString(3, beygirGucu);
                        stmt.setString(4, motorBilgi );		
			stmt.setString(5, aMKaydı);
                        stmt.setString(6, uretimYeri);		
			stmt.setString(7, uretimYili);		

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

	public int AracEkle(String aracNo, String model, String beygirGucu,String motorBilgi, String aMKaydı, String uretimYeri, String uretimYili)
	{
        int say = -1;
		Boolean giris_hazir = 
			((aracNo.length()>0) &&
			(model.length()>0) &&		
			(beygirGucu.length()>0)&&
                        (motorBilgi.length()>0)&&
                        (aMKaydı.length()>0)&&
                        (uretimYeri.length()>0)&&
                        (uretimYili.length()>0));
		
		if (!giris_hazir)
			return say;

        try (  Connection con = DriverManager.getConnection(connectionUrl,user,pass); ) 
        {
			String SQL1 = "INSERT INTO dbo.aracBilgileri (aracNo,model,beygirGucu,motorBilgi,aMKaydı,uretimYeri,uretimYili) VALUES (?,?)";
			PreparedStatement stmt = con.prepareStatement(SQL1);
			stmt.setString(1, aracNo);		
			stmt.setString(2, model);		
			stmt.setString(3, beygirGucu);
                        stmt.setString(4, motorBilgi);		
			stmt.setString(5, aMKaydı);
                        stmt.setString(6, uretimYeri);		
			stmt.setString(7, uretimYili);		
			
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
