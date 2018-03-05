
import java.util.ArrayList;
import java.util.List;

public class Student {
	
	List <Student>studentenliste= new ArrayList<Student>();
	
	String nachname;
	String vorname;
	int jahre;
	int SID;
	
	public int getSID(){
		return SID;
	}
	
	public void setSID(int SID){
		this.SID=SID;
	}
	public String getNachname(String nachname){
		return nachname;
	}
	
	public void setNachname(String nachname){
		this.nachname=nachname;
		
	}
	
	public String getVorname(String vorname){
		return vorname;
	}

	public void setVorname(String vorname){
		this.vorname=vorname;
	}
	
	public void setJahre(int jahre){
		this.jahre=jahre;
	}
	
	public int jahre(){
		return jahre;
	}
	
	
}
