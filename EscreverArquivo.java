import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EscreverArquivo {
	public void escreve(ArrayList<RecordedItem>itemsRegistrados ) {
		try {
			File fileEscrita = new File (".\\src\\DadosLista.txt");
			FileWriter fileEscrever = new FileWriter(fileEscrita);
			PrintWriter escrita = new PrintWriter(fileEscrever);
			
			for(int i = 0;i<itemsRegistrados.size();i++) {
				String Valores[] = itemsRegistrados.get(i).toString().split("_");
				for (int j=0; j<Valores.length; j++) {
					escrita.println(Valores[j] + " ");
				}
				escrita.println(" ");
			}
			escrita.close();
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
