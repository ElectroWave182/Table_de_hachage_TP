import static org.junit.Assert.*;
import org.junit.Test;

public class TableHachageTest
{

	TableHachage<String, String> table;
	
	public void setUp() throws Exception
	{
		Couple<String, String> c1 = new Couple<>("USB", "Universal Serial Bus");
		Couple<String, String> c2 = new Couple<>("BIOS", "Basic Input-Output System");
		Couple<String, String> c3 = new Couple<>("IP", "Internet Protocol");
		Couple<String, String> c4 = new Couple<>("BYTE", "A byte is a storage unit for data");
		Couple<String, String> c5 = new Couple<>("PC", "Personal Computer");
		Couple<String, String> c6 = new Couple<>("MAC", "Media Access Control");
		Couple<String, String> c7 = new Couple<>("ROM", "Read-Only Memory");
		Couple<String, String> c8 = new Couple<>("CPU", "Central Processing Unit");
		
		table = new TableHachage<String, String>();
		table.insererCouple(c1);
		table.insererCouple(c2);
		table.insererCouple(c3);
		table.insererCouple(c4);
		table.insererCouple(c5);
		table.insererCouple(c6);
		table.insererCouple(c7);
		table.insererCouple(c8);
	}

	public void tearDown() throws Exception
	{
	}

	public void test1() throws ExceptionClefIntrouvable
	{
		assertEquals(table.testerClef("BIOS"), true);
		assertEquals(table.recupererValeur("BIOS") == "Basic Input-Output System", true);
		
		assertEquals(table.testerClef("PC"), true);
		assertEquals(table.recupererValeur("PC") == "Personal Computer", true);
	}
	
	public void test2()
	{
		assertEquals(table.testerClef("PCI"), false);

		assertEquals(table.testerClef("PDF"), false);
	}
	
	@Test (expected = ExceptionClefIntrouvable.class)
	public void test3() throws ExceptionClefIntrouvable
	{
		table.recupererValeur("WYSIWYG");
	}
	
	public void test4() throws ExceptionClefIntrouvable
	{
		table.supprimerCouple("BYTE");
		assertEquals(table.testerClef("BYTE"), false);
	}
	
}
