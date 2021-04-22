package compras;
import java.util.Scanner;

class CElemento
{
	private String nome;
	private int qtd;
	private double preco;
	
	//variavel de referencia que vai apontar p um obj do tipo Celemento, 
	//guarda o endereco do proximo
	private CElemento prox;
	//construtor de classe
	CElemento()
	{
		 nome = "";
		qtd = 0;
		preco = 0;
		prox = null;
	}
//-----------------Getters e Setters da classe -----------------------
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String dado) {
		this.nome = dado;
	}
	public CElemento getProx() {
		return prox;
	}
	public void setProx(CElemento prox) {
		this.prox = prox;
	}
	
}
//################################ Lista Dinamica ###########################

public class CDinamicArrayList {
	Scanner scan = new Scanner(System.in);
	//definindo quem é o primeiro e o ultimo da lista
	
	CElemento primeiro = null;
	CElemento ultimo = null;
	int contadorElementos = 0;
	
//************************** Metodos*****************************	
	
//-----------------insere elemento no final da lista---------------------
	void insereElemento(String nome, int qtd, double preco) {
		
		//atualiza o total de elementos
		contadorElementos ++;
		
		//cria o novo elemento (nó) a ser inserido na lista
		CElemento novo = new CElemento();
		System.out.println("Qual o nome do produto que você deseja adicionar?");
		novo.setNome(scan.next());
		System.out.println("Qual a quantidade?");
		novo.setQtd(scan.nextInt());
		System.out.println("Qual o preço estimado do produto?");
		novo.setPreco(scan.nextDouble());
		
		//insere na lista vazia
		if (primeiro == null && ultimo == null) {
			primeiro = novo;
			ultimo = novo;
			return;
		}
		//quando a lista não é vazia
		//o ultimo proximo aponta para a vatiavel nova
		ultimo.setProx(novo);
		//o ultimo aponta para o novo
		ultimo = novo;
	}
//----------------------Remove um elemento-----------------------
	
		public String removeElemento(int posicao) {
			String dado = "";
			//verifica se a posicao é valida
			if(posicao < 0 || posicao >= contadorElementos) {
				return null;
			}
			
			// se remocao ocorrer na primeira posicao
			if(posicao == 0) {
				
				dado = primeiro.getNome();
				
				//quando e o Primeiro e unico elemento da lista
				if (primeiro.getProx() == null) {
					primeiro = null;
					ultimo = null;
					return dado;
				}
				
				else {
					//quando o primeiro não é o unico da lista
					CElemento copia = primeiro.getProx();
					primeiro.setProx(null);
					primeiro = copia;
					}
				contadorElementos--;
				return dado;
				
				}
			//Busca a referencia do elemenro anterior ao que foi recebido
			CElemento anterior = buscaElemento(posicao - 1);
			//guarda o dado do no que sera removido
			dado = anterior.getProx().getNome();
			
			//revalida a variavel proximo para excluir o elemento
			//vai setar para o proximo do proximo
			anterior.setProx(anterior.getProx().getProx());
			
			//verifica se a remocao foi no ultimo elemento
			if (posicao == contadorElementos -1) {
				//mudar o endereco do ultimo para o anterior dele
				ultimo = anterior;
			}
			contadorElementos --;
			return dado;
		}
//---------------Busca um elemento em uma posicao aleatória------------------
		
		public CElemento buscaElemento(int posicao) {
			
			//verifica se a posicao é valoda
			if(posicao < 0 || posicao >= contadorElementos) {
				return null;
			}
			//cria um obj temporario p guardar o endereco do primeiro nó
			CElemento copia = primeiro;
			
			//
			for (int pulos = 0; pulos < posicao; pulos++) {
				copia = copia.getProx();
			
			}
			return copia;
		}
//----------------------------Imprime busca-----------
		void imprimeBusca(int posicao) {
			//verifica se a posicao é valoda
			if(posicao < 0 || posicao >= contadorElementos) {
				return;
			}
			CElemento elemento = buscaElemento(posicao);
			System.out.println("***********************************************************");
			System.out.print("| Posição: "+posicao +" |");
			System.out.print("| Nome do Produto: "+elemento.getNome()+" |");
			System.out.print("| Quantidade: "+elemento.getQtd()+" |");
			System.out.println("| Preço estimado: "+elemento.getPreco()+" |");
			System.out.println("************************************************************");
			
		
			}
		
//---------------Editar Elemento------------------
		
		void editaElemento(int posicao) {
					//verifica se a posicao é valoda
					if(posicao < 0 || posicao >= contadorElementos) {
						return;
					}
					CElemento elemento = buscaElemento(posicao);
					System.out.println("Qual o nome do produto que você deseja adicionar?");
					elemento.setNome(scan.next());
					System.out.println("Qual a quantidade?");
					elemento.setQtd(scan.nextInt());
					System.out.println("Qual o preço estimado do produto?");
					elemento.setPreco(scan.nextDouble());
					
				
					}
				

//---------Passa por todos elementos da lista imprimindo um a um---------------
	
	void imprimeLista() {
		int cont=0;
		double total = 0;
		CElemento copia = primeiro;
		while(copia!= null) {
				cont ++;
				total = total + copia.getPreco();
		
			System.out.println("***********************************************************");
			System.out.print("| Posição: "+(cont -1) +" |");
			System.out.print("| Nome do Produto: "+copia.getNome()+" |");
			System.out.print("| Quantidade: "+copia.getQtd()+" |");
			System.out.println("| Preço estimado: "+copia.getPreco()+" |");
			System.out.println("************************************************************");
			copia = copia.getProx();
		
		}
		System.out.println("| Total estimado da compra : "+total+" |");
		}
	
//----------------Qual é o tamanho da lista----------------------
	int tamanhoLista()
	{
		return contadorElementos;
	}


}

