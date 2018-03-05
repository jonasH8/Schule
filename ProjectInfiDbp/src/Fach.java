
public class Fach {
	private static final String Student = null;
	int FID;
	String  Fachname;
	int Studentenanzahl;
	
	
	
	public int getFID(){
		return FID;
	}
	
	public String getFachname(){
		return Fachname;
	}
	public void setFID(int FID){
		this.FID=FID;
	}
	
	public void setFachname(String Fachname){
		this.Fachname=Fachname;
	}
	
	public int getStudentenanzahl(){
		int studentenanzahl=0;
		for(Student Student : Student.studentenliste){
			studentenanzahl++;
			
		}
		return studentenanzahl;
	}

}
