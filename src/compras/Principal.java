package compras;
import java.util.ArrayList;
import java.util.Scanner;

//import lista.Lista;

public class Principal{
public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	//instancia uma nova lista
	CDinamicArrayList listaDinamica = new CDinamicArrayList();
	int op = 0;
	
	//inicia loop de repeticao
	do {
		//chama o menu
		Principal.menu();
		System.out.println("Digite a opção:");
		op = scan.nextInt();
		
	//inicia o switch case
	switch (op) {
//-------------inserir elemento na lista-------------------------
	  case 1:
	    listaDinamica.insereElemento(null, 0, 0);//chmama metodo de insercao
	    System.out.println("Produto inserido com sucesso!"); 
	    break;
	    
//--------------busca elemento----------------------------------	    
	  case 2:
	    System.out.println("Digite a Posição do produto que deseja Buscar:");
	    listaDinamica.imprimeBusca(scan.nextInt());//imprime a busca
	    
	    break;
//--------------- Edita elemento -----------------------------------
	  case 3:
		    System.out.println("Digite a Posição do produto que deseja editar:");
		    listaDinamica.editaElemento(scan.nextInt());//ler a opcao que deseja editar
		    System.out.println("Produto alterado com sucesso!"); 
		    
		    break;
//----------------- Remove elemento----------------------------------
	  case 4:
		  listaDinamica.imprimeLista();//imprime a lista antes de remover
		  System.out.println("Digite a posição do produto que deseja Remover:");
		    listaDinamica.removeElemento(scan.nextInt());//ler a posicao que deseja remover
		    System.out.println("Produto Removido com sucesso!");
		    
	    break;
///-----------------Imprime na lista -------------------------------------
	  case 5:
	    listaDinamica.imprimeLista();
	    break;
	}
	}while (op != 6);

}
//--------------------- Menu de opces -------------------------------
public static void menu() {
System.out.println("*************************************************************************");
System.out.println("░█─── ─▀─ █▀▀ ▀▀█▀▀ █▀▀█ 　 █▀▀▄ █▀▀ 　 ░█▀▀█ █▀▀█ █▀▄▀█ █▀▀█ █▀▀█ █▀▀█ █▀▀ ");
System.out.println("░█─── ▀█▀ ▀▀█ ──█── █▄▄█ 　 █──█ █▀▀ 　 ░█─── █──█ █─▀─█ █──█ █▄▄▀ █▄▄█ ▀▀█ ");
System.out.println("░█▄▄█ ▀▀▀ ▀▀▀ ──▀── ▀──▀ 　 ▀▀▀─ ▀▀▀ 　 ░█▄▄█ ▀▀▀▀ ▀───▀ █▀▀▀ ▀─▀▀ ▀──▀ ▀▀▀");
System.out.println("*************************************************************************");
System.out.println("O que você deseja fazer?");
System.out.println("Digite 1 para incluir produto");
System.out.println("Digite 2 para Buscar produto");
System.out.println("Digite 3 para editar produto");
System.out.println("Digite 4 para excluir produto");
System.out.println("Digite 5 para mostrar lista de compras");
System.out.println("Digite 6 para Sair");
}
}