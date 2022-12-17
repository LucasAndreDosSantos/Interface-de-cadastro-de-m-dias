
public class RecordedItem extends LibraryItem {
	private String title = "O poço";
	private String medium = "Cinema";
	
	public void acquire(int catalogueNumber, int numberCopies, String title, String medium ) {
		this.title = title;
		this.medium = medium;
		
		super.acquire(catalogueNumber, numberCopies);
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
		return super.toString() + "Titulo: "+ title + "_Meio: " + medium + "_";
	}	
}
