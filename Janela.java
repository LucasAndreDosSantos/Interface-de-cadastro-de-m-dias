import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Janela extends JFrame {
	private static final long serialVersionUID = 3530938260548014468L;
	
	private JPanel lista,texto,botao, dados;
	private JComboBox<String> opcoes, indexValores;
	private String[] nomesOpcoes = {"------------","Item registrado","Filme","Programa de Computador"};
	private JLabel selecao, escolhaCatalogo, escolhaNumeroCopias, escolhaTitulo, escolhaMeio, escolhaDiretorVersao, 
	escolhaDataLancamentoPlataforma, escolhaDistribuidora;
	private JTextField catalogo, numeroCopias, titulo, meio, diretorVersao, dataLancamentoPlataforma, distribuidora;
	private JButton salvar;
	private int index = 0;
	
	private JLabel resultadoCatalogo, resultadoNumeroCopias, resultadoTitulo, resultadoMeio, resultadoDiretorVersao, resultadoDataLancamentoPlataforma, resultadoDistribuidora;
	private JLabel [] valores = {resultadoCatalogo, resultadoNumeroCopias, resultadoTitulo, resultadoMeio, resultadoDiretorVersao, resultadoDataLancamentoPlataforma, resultadoDistribuidora};
	
	private ArrayList<RecordedItem> itemsRegistrados = new ArrayList<RecordedItem>();
	
	public Janela() {
		this.setLayout(new GridLayout(4,1));
		lista = new JPanel();
		texto = new JPanel();
		botao = new JPanel();
		dados = new JPanel();
		
		lista.setLayout(new GridLayout(4,1));
		texto.setLayout(new FlowLayout(FlowLayout.CENTER));
		botao.setLayout(new FlowLayout(FlowLayout.CENTER));
		dados.setLayout(new GridLayout(8,1));
		
		
		this.add( lista );
		this.add( texto );
		this.add( botao );
		this.add( dados );
		
		inicializaElementos();
		selecionaOpcao();
		salvaValores();
		selecionaElementoLista();

		lista.add(selecao);
		lista.add(new JLabel(" "));
		lista.add(opcoes);
		lista.add(new JLabel(" "));

		texto.add(escolhaCatalogo);
		texto.add(catalogo);	
		texto.add(escolhaNumeroCopias);
		texto.add(numeroCopias);
		texto.add(escolhaTitulo);
		texto.add(titulo);
		texto.add(escolhaMeio);
		texto.add(meio);
		texto.add(escolhaDiretorVersao);
		texto.add(diretorVersao);
		texto.add(escolhaDataLancamentoPlataforma);
		texto.add(dataLancamentoPlataforma);
		texto.add(escolhaDistribuidora);
		texto.add(distribuidora);
		
		JLabel espaco = new JLabel("                                                   ");
		espaco.setFont(new Font("Times new Roman", Font.BOLD, 70));
		botao.add(espaco);
		botao.add(salvar);
		dados.add(indexValores);
		
		for(int i=0;i<valores.length;i++)dados.add(valores[i]);
		
		this.addWindowListener(new WindowAdapter() {
			@Override

			public void windowClosing(WindowEvent e) {
				EscreverArquivo arquivo = new EscreverArquivo();
				arquivo.escreve(itemsRegistrados);
				
			}

		});
	}
	
	private void inicializaElementos() {
		valores[0] = new JLabel("");
		valores[0].setFont(new Font("Times new Roman", Font.BOLD, 25));
		valores[1] = new JLabel("");
		valores[1].setFont(new Font("Times new Roman", Font.BOLD, 25));
		valores[2] = new JLabel("");
		valores[2].setFont(new Font("Times new Roman", Font.BOLD, 25));
		valores[3] = new JLabel("");
		valores[3].setFont(new Font("Times new Roman", Font.BOLD, 25));
		valores[4] = new JLabel("");
		valores[4].setFont(new Font("Times new Roman", Font.BOLD, 25));
		valores[5] = new JLabel("");
		valores[5].setFont(new Font("Times new Roman", Font.BOLD, 25));
		valores[6] = new JLabel("");
		valores[6].setFont(new Font("Times new Roman", Font.BOLD, 25));
		
		selecao = new JLabel("Selecione o que deseja adicionar:");
		selecao.setFont(new Font("Times new Roman", Font.BOLD, 40));
		
		escolhaCatalogo = new JLabel("Digite o numero de catalogo:");
		escolhaCatalogo.setFont(new Font("Times new Roman", Font.BOLD, 25));
		escolhaCatalogo.setVisible(false);
		escolhaNumeroCopias = new JLabel("Digite o numero de copias:");
		escolhaNumeroCopias.setFont(new Font("Times new Roman", Font.BOLD, 25));
		escolhaNumeroCopias.setVisible(false);
		escolhaTitulo = new JLabel("Digite o titulo:");
		escolhaTitulo.setFont(new Font("Times new Roman", Font.BOLD, 25));
		escolhaTitulo.setVisible(false);
		escolhaMeio = new JLabel("Digite o meio:");
		escolhaMeio.setFont(new Font("Times new Roman", Font.BOLD, 25));
		escolhaMeio.setVisible(false);
		escolhaDiretorVersao = new JLabel("");
		escolhaDiretorVersao.setFont(new Font("Times new Roman", Font.BOLD, 25));
		escolhaDiretorVersao.setVisible(false);
		escolhaDataLancamentoPlataforma = new JLabel("");
		escolhaDataLancamentoPlataforma.setFont(new Font("Times new Roman", Font.BOLD, 25));
		escolhaDataLancamentoPlataforma.setVisible(false);
		escolhaDistribuidora  = new JLabel("Digite a distribuidora do filme:");
		escolhaDistribuidora.setFont(new Font("Times new Roman", Font.BOLD, 25));
		escolhaDistribuidora.setVisible(false);
		
		catalogo = new JTextField();
		catalogo.setFont(new Font("Times new Roman", Font.BOLD, 25));
		catalogo.setPreferredSize(new Dimension(1065,25));
		catalogo.setVisible(false);
		numeroCopias = new JTextField();
		numeroCopias.setFont(new Font("Times new Roman", Font.BOLD, 25));
		numeroCopias.setPreferredSize(new Dimension(1095,25));
		numeroCopias.setVisible(false);
		titulo = new JTextField();
		titulo.setFont(new Font("Times new Roman", Font.BOLD, 25));
		titulo.setPreferredSize(new Dimension(1270,25));
		titulo.setVisible(false);
		meio = new JTextField();
		meio.setFont(new Font("Times new Roman", Font.BOLD, 25));
		meio.setPreferredSize(new Dimension(1280,25));
		meio.setVisible(false);
		diretorVersao = new JTextField();
		diretorVersao.setFont(new Font("Times new Roman", Font.BOLD, 25));
		diretorVersao.setPreferredSize(new Dimension(1068,25));
		diretorVersao.setVisible(false);
		dataLancamentoPlataforma = new JTextField();
		dataLancamentoPlataforma.setFont(new Font("Times new Roman", Font.BOLD, 25));
		dataLancamentoPlataforma.setPreferredSize(new Dimension(925,25));
		dataLancamentoPlataforma.setVisible(false);
		distribuidora = new JTextField();
		distribuidora.setFont(new Font("Times new Roman", Font.BOLD, 25));
		distribuidora.setPreferredSize(new Dimension(1042,25));
		distribuidora.setVisible(false);
		
		opcoes = new JComboBox<String>(nomesOpcoes);
		opcoes.setFont(new Font("Times new Roman", Font.BOLD, 25));
		
		indexValores = new JComboBox<String>();
		indexValores.setFont(new Font("Times new Roman", Font.BOLD, 25));
		indexValores.addItem("------");
		
		salvar = new JButton("Salvar");
		salvar.setFont(new Font("Times new Roman", Font.BOLD, 80));
		salvar.setPreferredSize(new Dimension(1100,100));
	}
	
	private void selecionaOpcao() {
		opcoes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				catalogo.setVisible(true);
				escolhaCatalogo.setVisible(true);
				numeroCopias.setVisible(true);
				escolhaNumeroCopias.setVisible(true);
				titulo.setVisible(true);
				escolhaTitulo.setVisible(true);
				meio.setVisible(true);
				escolhaMeio.setVisible(true);
				if(opcoes.getSelectedIndex() == 1) {
					diretorVersao.setVisible(false);
					escolhaDiretorVersao.setVisible(false);
					dataLancamentoPlataforma.setVisible(false);
					escolhaDataLancamentoPlataforma.setVisible(false);
					distribuidora.setVisible(false);
					escolhaDistribuidora.setVisible(false);
				}else if(opcoes.getSelectedIndex() == 2) {
					diretorVersao.setVisible(true);
					escolhaDiretorVersao.setVisible(true);
					escolhaDiretorVersao.setText("Digite o/a diretor/a do filme :");
					dataLancamentoPlataforma.setVisible(true);
					escolhaDataLancamentoPlataforma.setVisible(true);
					escolhaDataLancamentoPlataforma.setText("Digite a data de lançamento do filme : ");
					distribuidora.setVisible(true);
					escolhaDistribuidora.setVisible(true);
				}else if(opcoes.getSelectedIndex() == 3) {
					diretorVersao.setVisible(true);
					escolhaDiretorVersao.setVisible(true);
					escolhaDiretorVersao.setText("Digite a versão do programa:");
					dataLancamentoPlataforma.setVisible(true);
					escolhaDataLancamentoPlataforma.setVisible(true);
					escolhaDataLancamentoPlataforma.setText("Digite as plataformas programa de PC :");
					distribuidora.setVisible(false);
					escolhaDistribuidora.setVisible(false);
				}else{
					catalogo.setVisible(false);
					escolhaCatalogo.setVisible(false);
					numeroCopias.setVisible(false);
					escolhaNumeroCopias.setVisible(false);
					titulo.setVisible(false);
					escolhaTitulo.setVisible(false);
					meio.setVisible(false);
					escolhaMeio.setVisible(false);	
					diretorVersao.setVisible(false);
					escolhaDiretorVersao.setVisible(false);
					dataLancamentoPlataforma.setVisible(false);
					escolhaDataLancamentoPlataforma.setVisible(false);
					distribuidora.setVisible(false);
					escolhaDistribuidora.setVisible(false);
				}
			}
		});
	}
	private void salvaValores() {
		salvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(opcoes.getSelectedIndex() == 1) {
						RecordedItem item = new RecordedItem();
						item.acquire(Integer.parseInt(catalogo.getText()),Integer.parseInt(numeroCopias.getText()),titulo.getText(),meio.getText());
						itemsRegistrados.add(item);
						index++;
						indexValores.addItem(Integer.toString(index));
					}else if(opcoes.getSelectedIndex() == 2) {
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						Date data = null;
						try {
							data = formatter.parse(dataLancamentoPlataforma.getText());
						} catch (ParseException e1) {
							try {
								data = formatter.parse("00/00/0000");
							} catch (ParseException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}
						Film filme = new Film();
						filme.acquire(Integer.parseInt(catalogo.getText()),Integer.parseInt(numeroCopias.getText()),titulo.getText(),meio.getText(),diretorVersao.getText(),data, distribuidora.getText());
						itemsRegistrados.add(filme);
						index++;
						indexValores.addItem(Integer.toString(index));
					} else if(opcoes.getSelectedIndex() == 3) {
						ComputerProgram programa = new ComputerProgram();
						programa.acquire(Integer.parseInt(catalogo.getText()),Integer.parseInt(numeroCopias.getText()),titulo.getText(),meio.getText(),Float.parseFloat(diretorVersao.getText()),dataLancamentoPlataforma.getText());
						itemsRegistrados.add(programa);
						index++;
						indexValores.addItem(Integer.toString(index));
					}
				}catch(Exception e3){
					JOptionPane.showMessageDialog(null, "Insira valores validos");
				}
				catalogo.setText("");
				titulo.setText("");
				diretorVersao.setText("");
				dataLancamentoPlataforma.setText("");
				distribuidora.setText("");
				numeroCopias.setText("");
				meio.setText("");
				
				opcoes.setSelectedIndex(0);
				indexValores.setSelectedIndex(0);
			}
			
		});	
	}
	
	private void selecionaElementoLista() {
		indexValores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(indexValores.getSelectedIndex() != 0) {
					String Valores[] = 	itemsRegistrados.get(indexValores.getSelectedIndex()-1).toString().split("_");
			
					for(int i=0;i<Valores.length;i++) {
						valores[i].setText(Valores[i]);
						valores[i].setVisible(true);
					}
					
					for(int i=Valores.length;i<valores.length;i++) {
						valores[i].setVisible(false);
					}
					
				}else {
					for(int i=0;i<valores.length;i++) {
						valores[i].setVisible(false);
					}
				}
			}
		});		
	}
}
