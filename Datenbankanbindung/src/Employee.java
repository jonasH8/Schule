
import java.util.Scanner;

public class Employee {
	public int id;
	public String vorname;
	public String nachname;
	public int alter;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public int getAlter() {
		return alter;
	}
	
	public void setAlter(int alter) {
		this.alter = alter;
	}
}