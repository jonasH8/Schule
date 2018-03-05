import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class dbaccess {

	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost/Projekt";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "password";
	static Professor prof = new Professor();
	static Student stu = new Student();

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Um einen Professor zu erstellen, schreiben Sie die Zahl '1'");
			System.out.println("Um einen Professor auszugeben, schreiben Sie die Zahl '2'");
			System.out.println("Um einen Professor zu löschen Schreiben Sie die Zahl '3'");
			System.out.println("Um Studenten zu erstellen, Schreiben Sie die Zahl '4'");
			
			System.out.println("Um Student auszugeben, Schreiben Sie die Zahl '5'");
			System.out.println("Um Student zu updaten schreiben sie die Zahl '6'");
			System.out.println("Um Professor zu updaten schreiben sie die Zahl '7'");
			System.out.println("Um Student zu löschen schreiben sie die Zahl '8'");
			Scanner sc = new Scanner(System.in);
			String entsch = sc.next();

			System.out.println("creating statement");
			stmt = conn.createStatement();
			String sql;
			sql = "Select PID, vorname,nachname, wohnort from Professor";
			sql = "CREATE TABle Professor (" + "PID SERIAL primary key,"
					+ "vorname character varying not null," + "nachname character varying not null,"
					+ "wohnort character varying not null)";

			ResultSet rs = stmt.executeQuery(sql);

			
				//entscheiden zwischen Erzeugen von PROF/Stu oder Update prof/stu oder Delete prof/stu oder Read Prof/stu
			switch (entsch) {
			case "1":
				CREATEprof();
				sql = "Insert into Professor value(" + prof.getPID() + "," + "'" + prof.getVorname() + "'," + "'"
						+ prof.getNachname() + "'," + "'" + prof.getWohnort() + ")";

				ResultSet rs2 = stmt.executeQuery(sql);
				System.out.println("Es wurde der Professor" + prof.getVorname() + "" + prof.getNachname() + "erstellt");
				break;

			case "2":
				READprof();
				sql = "SELECT PID, vorname, nachname,wohnort from Professor";
				ResultSet rs3 = stmt.executeQuery(sql);
				// STEP 5: Extract data from result set
				while (rs.next()) {
					// Retrieve by column name
					int pid = rs.getInt("PID");
					String vorname = rs.getString("vorname");
					String nachname = rs.getString("name");
					String wohnort = rs.getString("wohnort");

					// Display values
					System.out.print("PID:	" + pid + "\t |");
					System.out.print("	Wohnort	" + wohnort + "\t |");
					System.out.print("	Vorname	" + vorname + "\t \t \t |");
					System.out.println("	Nachname: " + nachname + "\t ");
				}
				break;

			case "3":
				DELETEprof();
				sql = "DELETE FROM Project WHERE pid = (" + pid.getId() + ")";
				ResultSet rs4 = stmt.executeQuery(sql);
				System.out.println("test");
				break;

			case "4":
				CREATEstu();
				sql = "Insert into Student value(" + stu.getSID() + "," + "'" + stu.getVorname() + "'," + "'"
						+ stu.getNachname() + "'," + "'" + stu.getAlter() + ")";

				ResultSet rs5 = stmt.executeQuery(sql);
				System.out.println("Es wurde der Student" + stu.getVorname() + "" + stu.getNachname() + "erstellt");
				break;

			case "5":
				READstu();
				sql = "SELECT SID, vorname, nachname,alter from Student";
				ResultSet rs6 = stmt.executeQuery(sql);
				// STEP 5: Extract data from result set
				while (rs.next()) {
					// Retrieve by column name
					int pid = rs.getInt("SID");
					String vorname = rs.getString("vorname");
					String nachname = rs.getString("name");
					String alter = rs.getString("alter");

					// Display values
					System.out.print("SID:	" + pid + "\t |");
					System.out.print("	alter	" + alter + "\t |");
					System.out.print("	Vorname	" + vorname + "\t \t \t |");
					System.out.println("	Nachname: " + nachname + "\t ");
				}
				break;
				
			case"6":
				UPDATEstu();
				break;
				
				
			case"7":
				UPDATEprof();
				break;
				
			case"8": 
				DELETEstu();
				sql = "DELETE FROM Project WHERE sid = (" + sid.getId() + ")";
				ResultSet rs8 = stmt.executeQuery(sql);
				System.out.println("test");
				break;
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	
	//methoden die beim Switch ausgeführt werden
	
	public static void CREATEprof() {
		Scanner sc = new Scanner(System.in);

		System.out.println("PID:");
		int pid = sc.nextInt();

		System.out.println("Vorname:");
		String vorname = sc.next();

		System.out.println("Nachname:");
		String nachname = sc.next();

		System.out.println("Wohnort:");
		String wohnort = sc.next();

		prof.setPID(pid);
		prof.setVorname(vorname);
		prof.setNachname(nachname);
		prof.setWohnort(wohnort);

	}

	public static void READprof() {

		Scanner sc=new Scanner(System.in);
		System.out.println("Welche PID");
		int id=sc.nextInt();
		id=prof.getPID()
	}

	public static void READstu() {

		Scanner sc=new Scanner(System.in);
		System.out.println("Welche SID");
		int id=sc.nextInt();
		
	
	}

	public static void CREATEstu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("SID:");
		int SID = sc.nextInt();

		System.out.println("Vorname:");
		String vorname = sc.next();

		System.out.println("Nachname:");
		String nachname = sc.next();

		System.out.println("Alter:");
		String alterEingabe = sc.next();
		int alter = Integer.parseInt(alterEingabe);

		stu.setSID(SID);
		stu.setVorname(vorname);
		stu.setNachname(nachname);
		stu.setAlter(alter);
	}
	
	public static void UPDATEprof(){
		Scanner sc= new Scanner(System.in);
		System.out.println("Welche ProfessorID soll upgedated werden?");
		int id=sc.nextInt();
		prof.setPID(id);
		System.out.println("Was soll geupdatet werden(Vorname/Nachname/Wohnort)");
		String entscheit=sc.next();
		if (entscheit=="Vorname"){
			System.out.println("Welchen neuen Vornamen soll er bekommen");
			String neuervor= sc.next();
			prof.setVorname(neuervor);
			
		}
				
		else if(entscheit=="Nachname"){
			System.out.println("Welchen neuen Nachnamen soll er bekommen");
			String neuernach=sc.next();
			prof.setNachname(neuernach);
		}
		
		else if(entscheit=="Wohnort"){
			System.out.println("Welchen neuen Wohnort soll er bekommen");
			String neuerort=sc.next();
			prof.setWohnort(neuerort);
		}
		else{
			System.out.println("Eingabe kontrollieren(Vorname/Nachname/Wohnort)");
		}
	}
	public static void UPDATEstu(){
		Scanner sc= new Scanner(System.in);
		System.out.println("Welche StudendenID soll upgedated werden?");
		int id=sc.nextInt();
		stu.setSID(id);
		System.out.println("Was soll geupdatet werden(Vorname/Nachname/Wohnort)");
		String entscheit=sc.next();
		if (entscheit=="Vorname"){
			System.out.println("Welchen neuen Vornamen soll er bekommen");
			String neuervor= sc.next();
			stu.setVorname(neuervor);
			
		}
				
		else if(entscheit=="Nachname"){
			System.out.println("Welchen neuen Nachnamen soll er bekommen");
			String neuernach=sc.next();
			stu.setNachname(neuernach);
		}
		
		else if(entscheit=="Alter"){
			System.out.println("Welches neues Alter soll er bekommen");
			int neuesalter=sc.nextInt();
			stu.setAlter(neuesalter);
		}
		else{
			System.out.println("Eingabe korrigieren(Vorname/ Nachname/ Alter)");
		}
		
	}
	
	public static void DELETEprof(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Welche ProfessorID wollen sie Löschen?");
		int id=sc.nextInt();
		prof.setPID(id);
		
	}
	public static void DELETEstu(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Welche StudentenID wollen sie Löschen?");
		int id=sc.nextInt();
		stu.setSID(id);
	}

}
