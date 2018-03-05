import static org.junit.Assert.*;

import org.junit.Test;

public class dbaccessTest {

	@Test
	public void testConnection() {
		assert(new dbaccess.conn()!=null);
	}
	
	public void testcreateprof()
	{
		assert(new Professor()!=null);
	}
	public void testcreatestu()
	{
		assert(new Student()!=null);
	}
}
