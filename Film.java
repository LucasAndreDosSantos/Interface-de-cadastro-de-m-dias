import java.text.DateFormat;
import java.util.Date;

public class Film extends RecordedItem {
	private String director = "Galder Gaztelu-Urrutia";
	private Date dateRelease = new Date();
	private String distributor = "Netflix";
	
	public void acquire(int catalogueNumber, int numberCopies, String title, String medium, String director, Date dateRelease, String distributor ) {
		this.director = director;
		this.dateRelease = dateRelease;
		this.distributor = distributor;
		
		super.acquire(catalogueNumber, numberCopies, title, medium);
	}
	
	@Override
	public void itemInfo() {
		String Valores[] = 	toString().split("_");
		for(int j=0;j<Valores.length;j++) {
			System.out.println(Valores[j]);
		}
	}
	
	@Override
	public String toString() {
		DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT); 
		return super.toString() + "Diretor: " + director + "_Data de lancamento: " + 
		formatoData.format(dateRelease) + "_Distribuidora: " + distributor;
	}	
}
