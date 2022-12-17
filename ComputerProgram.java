

public class ComputerProgram extends RecordedItem {
	private float version = 5;
	private String platform = "Windows";
	
	public void acquire(int catalogueNumber, int numberCopies, String title, String medium, float version, String platform ) {
		
		this.version = version;
		this.platform = platform;
		
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
		return super.toString() + "Versao: " + version + "_Plataforma: " + platform;
	}
}
