import java.util.ArrayList;

import javax.swing.JFrame;

public class ClassesTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <LibraryItem> Livraria = new ArrayList <LibraryItem>();
		
		Livraria.add(new PublishedItem());
		Livraria.add(new RecordedItem());
		Livraria.add(new Film());
		Livraria.add(new ComputerProgram());

		
		
		for(int i=0;i<Livraria.size();i++) {
			Livraria.get(i).itemInfo();
			System.out.println("---------------------");
		}
		
		Janela janela = new Janela();
		janela.setTitle("RecordedItens");
		janela.setSize(1500, 1050);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

}
