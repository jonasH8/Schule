//STEP 1. Import required packages
import java.sql.*;
import java.util.Scanner;


public class dbaccess {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";  
	static final String DB_URL = "jdbc:postgresql://localhost/Employee";

	//  Database credentials
	static final String USER = "postgres";
	static final String PASS = "password";
	static Employee em1 = new Employee();

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			System.out.println("Um Daten zu erstellen, schreiben Sie die Zahl '1'");
			System.out.println("Um Daten der DB auszugeben, schreiben Sie die Zahl '2'");
			System.out.println("Um Daten zu updaten Schreiben Sie die Zahl '3'");
			System.out.println("Um Daten zu löschen Schreiben Sie die Zahl '4'");
			Scanner sc = new Scanner(System.in);
			String entsch = sc.next();
		

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			System.out.println();
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, first, last, age FROM Employee";
			
			ResultSet rs = stmt.executeQuery(sql);

		


			stmt = conn.createStatement();
			String sql2;

			
			/**
			 * Switcht die Entscheidung mittels dem String "entsch" (Scan-Eingabe)
			 * 
			 * 1: CREATE
			 * 2: READ
			 * 3: UPDATE
			 * 4: DELETE
			 * 
			 */
			switch(entsch){
				case "1": Create();
					sql = "INSERT INTO Employee values("
						+ em1.getId()+","
						+ "'"+em1.getVorname()+"'," 
						+ "'"+em1.getNachname()+"',"
						+ em1.getAlter()+")";
				ResultSet rs2 = stmt.executeQuery(sql);

				System.out.println("Es wurde der Benutzer " + em1.getVorname() + " " + em1.getNachname() + "erstellt");break;
				
				case "2": //READ
					sql= "SELECT id, age, first, last from Employee";
					ResultSet rs3 = stmt.executeQuery(sql);
					//STEP 5: Extract data from result set
					while(rs.next()){
						//Retrieve by column name
						int id  = rs.getInt("id");
						int age = rs.getInt("age");
						String first = rs.getString("first");
						String last = rs.getString("last");

						//Display values
						System.out.print("ID:	" + id+"\t |");
						System.out.print("	Alter:	" + age +"\t |");
						System.out.print("	Vorname:	" + first +"\t \t \t |");
						System.out.println("	Nachname:		" + last+"\t ");
					}break;

					
				/**	
				 * Leider gibt es mir hier bei der UPDATE Syntax einen Fehler aus
				 * 
				 * Ich hoffe, Sie können mir hier während der Stunde helfen den Fehler zu finden.
				 */
				case "3": Update();
//				sql = "UPDATE Employee SET first = ("+em1.getVorname()+", SET last = ("+em1.getVorname()+",) Set last ="
//								+ " ("+em1.getNachname()+",) SET age = ("+em1.getAlter()+",)
//				WHERE id = ("
//						+ em1.getId()+")";
//				
////						+ "'"+ em1.getVorname()+"',"
////						+ "'"+ em1.getNachname()+"',"
////						+ em1.getAlter()+") WHERE id = ("
////						+ em1.getId()+")";
//					ResultSet rs4 = stmt.executeQuery(sql);
//					
//					System.out.println("Der Benutzer wurde upgedatet und heißt nun: " + em1.getVorname() + " " + em1.getNachname());
					break;
					
					
						
				
				case "4": Delete();
					sql = "DELETE FROM Employee WHERE id = ("
							+ em1.getId()+")";
					ResultSet rs5 = stmt.executeQuery(sql);
					System.out.println("test");
					break;
					
					
			}

			//STEP 6: Clean-up environment


			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		//System.out.println("Goodbye!");
	}//end main

	public static void Create() {
		Scanner sc = new Scanner(System.in);

		System.out.println("ID:");
		int id = sc.nextInt();

		System.out.println("Vorname:");
		String vorname = sc.next();

		System.out.println("Nachname:");
		String nachname = sc.next();

		System.out.println("Alter:");
		int alter = sc.nextInt();

		em1.setId(id);
		em1.setVorname(vorname);
		em1.setNachname(nachname);
		em1.setAlter(alter);
	}

	public static void Update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Welchen Benutzer wollen Sie updaten? (Bitte ID eingeben!):");
		int id = sc.nextInt();
		
		
		System.out.println("Neuer Vorname:");
		String vorname = sc.next();

		System.out.println("Neuer Nachname:");
		String nachname = sc.next();

		System.out.println("Neues Alter:");
		int alter = sc.nextInt();

		em1.setId(id);
		em1.setVorname(vorname);
		em1.setNachname(nachname);
		em1.setAlter(alter);
	}

	public static void Delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Welchen Benutzer wollen Sie löschen? (Bitte ID eingeben!):");
		int id = sc.nextInt();
		
		em1.setId(id);
	}
}//end FirstExample

