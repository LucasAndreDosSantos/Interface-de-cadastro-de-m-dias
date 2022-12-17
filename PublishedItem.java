
public class PublishedItem extends LibraryItem {
	private String title = "Rei do Gado";
	private String publisher = "Globo";
	
	public void acquire(int catalogueNumber, int numberCopies, String title, String publisher ) {
		this.title = title;
		this.publisher = publisher;
		
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
		return super.toString() + "Titulo: "+ title + "_Editora: " + publisher + "_";
	}
}
