
public class Professor {
	public int PID;
	public String nachname;
	public String vorname;
	public int jahre;
	public String wohnort;


	public int getPID(){
		return PID;
	
	}
	
	public void setPID(int PID){
		this.PID=PID;
	}
	public String getVorname(){
		return vorname;
	}
	public String getNachname(){
		return nachname;
	}
	
	public String getWohnort(){
		return wohnort;
	}
	
	public void setVorname(String vorname){
		this.vorname=vorname;
	}
	
	public void setNachname(String nachname){
		this.nachname=nachname;
	}
	
	public void setWohnort(String wohnort){
		this.wohnort=wohnort;
	}

	public int getJahre() {
		return jahre;
	}

	public void setJahre(int jahre) {
		this.jahre = jahre;
	}
	
}