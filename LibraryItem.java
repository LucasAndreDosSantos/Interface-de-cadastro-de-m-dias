
public abstract class LibraryItem {
	private int catalogueNumber = 9425;
	private int numberCopies = 1080;
	
	public void acquire(int catalogueNumber, int numberCopies) {
		this.catalogueNumber = catalogueNumber;
		this.numberCopies = numberCopies;
	}
	
	public void returned() {
		
	}
	
	public void itemInfo() {
		String Valores[] = 	toString().split("_");
		for(int j=0;j<Valores.length;j++) {
			System.out.println(Valores[j]);
		}
	}
	
	@Override
	public String toString() {
		return "Catalogo: "+ catalogueNumber + "_Numero de Copias: " + numberCopies + "_";
	}
	
	
}
