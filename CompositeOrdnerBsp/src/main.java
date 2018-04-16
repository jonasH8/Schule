
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Datei Datei1=new Datei();
		Datei Datei2=new Datei();
		Datei Datei3=new Datei();
		Datei Datei4=new Datei();
		
		Ordner Ordner1=new Ordner();
		Ordner Ordner2=new Ordner();
		Ordner Ordner3=new Ordner();
		
		Ordner1.add(Datei1);
		Ordner1.add(Datei2);
		
		Ordner2.add(Datei3);
		
		Ordner3.add(Datei4);
		Ordner1.add(Ordner2);
		Ordner1.add(Ordner3);
		
		
		Ordner1.showContent();

	}

}
