public class Person{
	private static Person instance=null;
	private static  String name;
	private Person(String name){
		Person.name=name;
		
	}
	
	public static Person getInstance(){
		if (Person.instance==null ){
			Person.instance=new Person(name);
		}
		return Person.instance;
	}
	
	
	
}