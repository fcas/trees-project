package ARN;
import java.util.Scanner;

import ABB.No;

import exceptions.ChaveInvalidaException;
import exceptions.NoJaExisteException;
import exceptions.PredecessorNotFoundException;
import exceptions.SuccessorNotFoundException;
import exceptions.VerificacaoFalhouException;


public class Menu {

	private ARN arn;
	private int option;
	Scanner in = new Scanner(System.in);
	
	public Menu() {
		arn = new ARN();
	}
	
	public void mainMenu(){
		System.out.println("\n------------------------\n");
		System.out.println("Arvore Rubro Negra:");
		System.out.println("0- Sair");
		System.out.println("1- Inserir");
		System.out.println("2- Remover");
		System.out.println("3- Imprimir Percurso Em Ordem");
		System.out.println("4- Imprimir Percurso Pre Ordem");
		System.out.println("5- Imprimir Percurso Pos Ordem");
		System.out.println("6- Buscar No");
		System.out.println("7- Verificar se Arvore e uma ARN valida");
	}
	
	public void init() throws NoJaExisteException, PredecessorNotFoundException, SuccessorNotFoundException, VerificacaoFalhouException{
		
		do{
			mainMenu();
			option = in.nextInt();
			
			switch(option){
				case 1: insercao();
						break;
				case 2: remocao();
						break;
				case 3: inOrdem();
						break;
				case 4: preOrdem();
						break;
				case 5: posOrdem();
						break;
				case 6: buscaNo();
						break;
				case 7: validacao();
						break;
				case 0: in.close();
						System.out.println("Ate logo!");
						return;
				default: 
						break;
					
			}
			
		}while (option != 0);
	}
	
	private void validacao() throws VerificacaoFalhouException {
		System.out.println("Arvore Rubro Negra Valida: " + arn.arvoreRubroNegraValida());
	}

	private void buscaNo() {
		int numero;
		System.out.println("Digite o numero do no a ser buscado");
		numero = in.nextInt();
		
		No result = arn.busca(numero);
		System.out.println("no " + result.getNumero());
		if (result.getEsquerda()!=null)
			System.out.println("filho esquerdo "+ result.getEsquerda().getNumero());
		else
			System.out.println("sem filho esquerdo");
		if (result.getDireita()!=null)
			System.out.println("filho direito "+ result.getDireita().getNumero());
		else
			System.out.println("sem filho direito");
	}

	private void posOrdem() {
		arn.printPos();
	}

	private void preOrdem() {
		arn.printPre();
	}

	private void inOrdem() {
		arn.print();
	}

	private void remocao() {
		int numero;
		System.out.println("Digite o numero a ser removido da arvore");
		numero = in.nextInt();
		
		
		if (arn.remover(numero) != null)
			System.out.println("remocao bem sucedida");
		else
			System.out.println("remocao falhou");
	}

	private void insercao() throws NoJaExisteException {
		int numero;
		System.out.println("Digite o numero a ser inserido na arvore");
		numero = in.nextInt();
		
		try {
			arn.inserir(numero);
		} catch (ChaveInvalidaException e) {
			System.out.println("Valor inserido invalido.\nPor favor insira um numero nao negativo");
		}
	}

	public static void main(String[] args) throws NoJaExisteException, PredecessorNotFoundException, SuccessorNotFoundException, VerificacaoFalhouException {
		Menu menu = new Menu();
		menu.init();
	}
	
}