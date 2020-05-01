/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sero
 */
public class Kisi {
        private int kisiNo;
	private String kisiAd;
	private String kisiSoyad;
        private String cinsiyet;
        private String medeniHal;
        private String telNo;
        private String telBilgi;
        private String eMail;
        private String webAdres;
        private String sosyalMedya;

	public Kisi() {
		this.kisiNo = -1;
		this.kisiAd = "";
		this.kisiSoyad = "";
                this.cinsiyet ="";
                this.medeniHal="";
                this.telNo="";
                this.telBilgi="";
                this.eMail = "";
                this.webAdres="";
                this.sosyalMedya="";
	}
	
	public Kisi(int kisiNo, String kisiAd, String kisiSoyad, String cinsiyet, String medeniHal, String telNo, String telBilgi, String eMail, String webAdres, String sosyalMedya) {
		this.kisiNo = kisiNo;
		this.kisiAd = kisiAd;
		this.kisiSoyad = kisiSoyad;
                this.cinsiyet =cinsiyet;
                this.medeniHal=medeniHal;
                this.telNo=telNo;
                this.telBilgi=telBilgi;
                this.eMail = eMail;
                this.webAdres=webAdres;
                this.sosyalMedya=sosyalMedya;
	}

	public String getTel() {
		return telNo;
	}

	public void setTel(String Tel) {
		this.telNo = telNo;
	}

	public int getId() {
		return kisiNo;
	}

	public void setId(int kisiNo) {
		this.kisiNo = kisiNo;
	}

	public String getAdi() {
		return kisiAd;
	}

	public void setAdi(String kisiAd) {
		this.kisiAd = kisiAd;
	}
        public String getSoyad() {
		return kisiSoyad;
	}

	public void setSoyad(String kisiSoyad) {
		this.kisiSoyad = kisiSoyad;
	}
        public String getcinsiyet() {
		return cinsiyet;
	}

	public void setcinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
        public String getmedeniHal() {
		return medeniHal;
	}

	public void setmedeniHal(String medeniHal) {
		this.medeniHal = medeniHal;
	}
        public String telNo() {
		return telNo;
	}

	public void settelNo(String telNo) {
		this.telNo = telNo;
	}
        public String gettelBilgi() {
		return telBilgi;
	}

	public void settelBilgi(String telBilgi) {
		this.telBilgi = telBilgi;
	}
        public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
        public String getwebAdres() {
		return webAdres;
	}

	public void setwebAdres(String webAdres) {
		this.webAdres = webAdres;
	}
        public String getsosyalMedya() {
		return sosyalMedya;
	}

	public void setsosyalMedya(String sosyalMedya) {
		this.sosyalMedya = sosyalMedya;
	}
        
	
	

    
}
