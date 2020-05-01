/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sero
 */
public class arac {
    private int aracNo;
	private String model;
	private String beygirGucu;
        private String motorBilgi;
        private String aMKaydı;
        private String uretimYeri;
        private String uretimYili;

	public arac() {
		this.aracNo = -1;
		this.model = "";
		this.beygirGucu = "";
                this.motorBilgi ="";
                this.aMKaydı="";
                this.uretimYeri="";
                this.uretimYili="";
                
	}
	
	public arac(int aracNo, String model, String beygirGucu, String motorBilgi, String aMKaydı, String uretimYeri, String uretimYili) {
		this.aracNo = aracNo;
		this.model = model;
		this.beygirGucu = beygirGucu;
                this.motorBilgi =motorBilgi;
                this.aMKaydı=aMKaydı;
                this.uretimYeri=uretimYeri;
                this.uretimYili=uretimYili;
                
	}

	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}

	public int getaracNo() {
		return aracNo;
	}

	public void setaracNo(int aracNo) {
		this.aracNo = aracNo;
	}

	public String getbeygirGucu() {
		return beygirGucu;
	}

	public void setbeygirGucu(String beygirGucu) {
		this.beygirGucu = beygirGucu;
	}
        public String getmotorBilgi() {
		return motorBilgi;
	}

	public void setmotorBilgi(String motorBilgi) {
		this.motorBilgi = motorBilgi;
	}
        public String getaMKaydı() {
		return aMKaydı;
	}

	public void setaMKaydı(String aMKaydı) {
		this.aMKaydı = aMKaydı;
	}
        public String geturetimYeri() {
		return uretimYeri;
	}

	public void seturetimYeri(String uretimYeri) {
		this.uretimYeri = uretimYeri;
	}
        public String geturetimYili() {
		return uretimYili;
	}

	public void seturetimYili(String uretimYili) {
		this.uretimYili= uretimYili;
	}
        
}
