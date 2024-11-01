public class TableHachage<Clef, Valeur>
{
	
	public Couple<Clef, Valeur>[] donnees;
	
	public TableHachage()
	{
		this.donnees = new Couple[15];
	}

	public boolean testerClef(Clef c)
	{
		for(Couple<Clef, Valeur> d: donnees)
		{
			if(d.cle.equals(c))
			{
				return true;
			}
		}
		return false;
	}
	
	public Valeur recupererValeur(Clef c) throws ExceptionClefIntrouvable
	{
		for(Couple<Clef, Valeur> d: donnees)
		{
			if(d.cle.equals(c))
			{
				return (Valeur) d.val;
			}
		}
		throw new ExceptionClefIntrouvable();
	}
	
	public void insererCouple(Couple<Clef, Valeur> c)
	{
		int code = c.cle.hashCode() % 15;
		donnees[code] = c;
	}
	
	public void supprimerCouple(Clef c) throws ExceptionClefIntrouvable
	{
		for(int i = 0; i < donnees.length; i++)
		{
			Couple<Clef, Valeur> d = donnees[i];
			
			if(d.cle.equals(c))
			{
				donnees[i] = null;
				break;
			}
		}
		throw new ExceptionClefIntrouvable();
	}
	
	public String toString()
	{
		String sortie = "";
		
		for(int i = 0; i < donnees.length; i++)
		{
			Couple<Clef, Valeur> d = donnees[i];
			
			if(d == null)
			{
				sortie += i + " -\n";
			}
			else
			{
				sortie += i + " - <" + d.cle + ", " + d.val + ">\n";
			}
		}
		
		return sortie;
	}
	
	public static void main(String[] args)
	{
		Couple<String, String> c1 = new Couple<>("USB", "Universal Serial Bus");
		Couple<String, String> c2 = new Couple<>("BIOS", "Basic Input-Output System");
		Couple<String, String> c3 = new Couple<>("IP", "Internet Protocol");
		Couple<String, String> c4 = new Couple<>("BYTE", "A byte is a storage unit for data");
		Couple<String, String> c5 = new Couple<>("PC", "Personal Computer");
		Couple<String, String> c6 = new Couple<>("MAC", "Media Access Control");
		Couple<String, String> c7 = new Couple<>("ROM", "Read-Only Memory");
		Couple<String, String> c8 = new Couple<>("CPU", "Central Processing Unit");
		
		TableHachage<String, String> table = new TableHachage<String, String>();
		table.insererCouple(c1);
		table.insererCouple(c2);
		table.insererCouple(c3);
		table.insererCouple(c4);
		table.insererCouple(c5);
		table.insererCouple(c6);
		table.insererCouple(c7);
		table.insererCouple(c8);
		
		System.out.print(table);
	}
	
}
