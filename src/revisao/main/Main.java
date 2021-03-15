package revisao.main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import revisao.dominio.Cliente;
import revisao.dominio.Pedido;
import revisao.dominio.Produto;

public class Main {
	public static ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
	public static ArrayList<Cliente> clientes=new ArrayList<Cliente>();
	public static ArrayList<Produto> produtos=new ArrayList<Produto>();
	
	
	public static List<Pedido> filtrarPedidos(int codigoPedido){
		return  pedidos.stream()
				.filter(p->p.getCodigo()==codigoPedido )
				.collect(Collectors.toList());
		
	}
	public Pedido localizarPedido(int codigo) { 

		for (Pedido  pedido  : pedidos) {
			if (pedido  != null && pedido  .getCodigo() == (codigo)) {
				return pedido ;
			}
		}
		System.out.println("Pedido não encontrado");
		return null;
	}
	
	public static void menu() {
		Scanner sc1 = new Scanner(System.in);
		int opcao=-1;
		 
		
		do {
			
			System.out.println("Digite a opcao:"
					+ "\n1 Cadastrar Produto"
					+ "\n2 Cadastrar Cliente"
					+ "\n3 Cadastrar Pedido"
					+ "\n4 Adicionar Produto ao Pedido"
					+ "\n5 SAIR");
			opcao=sc1.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Digite o codigo do produto:");
				int codigo=sc1.nextInt();
				System.out.println("Digite o nome do produto:");
				String nome= sc1.next();
				System.out.println("Digite o preco do produto:");
				double preco=sc1.nextDouble();;
				cadastrarProduto( codigo,  nome,  preco);
				break;
			
			case 2:	
				System.out.println("Digite o codigo do Cliente:");
				int codigoCliente=sc1.nextInt();
				System.out.println("Digite o nome do Cliente:");
				String nomeCliente=sc1.next();
				System.out.println("Digite o cpf do Cliente:");
				String cpfCliente=sc1.next();
				cadastrarCliente( codigoCliente,  nomeCliente,  cpfCliente) ;
				break;
			
			case 3:	
				System.out.println("Digite o codigo do Pedido:");
				int codigoPedido=sc1.nextInt();			 
				System.out.println("Digite o cpf do Cliente:");
				String cpfPedido=sc1.next();
				int[] carrinhoCompras=new int[0];
				FazerPedidoDinamico( codigoPedido, cpfPedido , carrinhoCompras);
				break;
			
			case 4:
				System.out.println("Digite o codigo do Pedido:");
				codigoPedido=sc1.nextInt();
				System.out.println("Digite o codigo do Prduto do Pedido:");
				int codigoProdutoPedido=sc1.nextInt();
				
				List<Pedido> pedFiltro= filtrarPedidos(codigoPedido );
				 
				
				 
				Pedido pe=null;
				if (pedFiltro.size()>0)
					pe=pedFiltro.get(0);
				
				List<Produto> prod=null;
				prod=produtos.stream()
				.filter(p->p.getCodigo()==codigoProdutoPedido )
				.collect(Collectors.toList());
					 
				if(prod.size()>0) {
					pe.getProdutos().add(prod.get(0));				 
					System.out.println("PRODUTO   IDENTIFICADO:"+prod.get(0).getNome());
					for (Produto p : pe.getProdutos()) {
						System.out.println("PRODUTO:"+p.getNome());
						
					}
				}			
				else
					System.out.println("PRODUTO NAO IDENTIFICADO:"+codigoProdutoPedido);
			 
						 
				break;
			case 5:
				opcao=0;
				System.out.println("SAINDO");
			default:
				break;
				
			}
		}while(opcao!=0);
		
	}
	
	public static void cadastrarProduto(int codigo, String nome, double preco) {
		if(nome!=null && nome.length()>3 && preco>=100 ) {			  
			produtos.add(new Produto(codigo,nome, preco));
			System.out.println("Produto Salvo");
		}else
			System.out.println("Produto NAO Salvo");
		
	}
	
	
	public static void cadastrarCliente(int codigo, String nome, String cpf) {
		boolean cpfRepetido=false;
		for (Cliente cliente : clientes) {
			if(cliente.getCpf().equals(cpf)) {
				cpfRepetido=true;
			}
		}
		if(!cpfRepetido) {
			if(nome!=null && nome.length()>3 && cpf!=null && cpf.length()>5) {
				Cliente clienteA = new Cliente(codigo,nome,cpf);
				clientes.add(clienteA);
				System.out.println("Cliente Salvo");
			}else
				System.out.println("Cliente NAO Salvo");			
			
		}else
			System.out.println("CPF JA CADASTRADO");
		
	}
	public static void FazerPedido() {
		Cliente clienteA = new Cliente(1,"Fulano","0100");
		Produto produtoA=new Produto(1,"TV 32",333.58);
		Produto produtoB=new Produto(2,"Smartphone",900.01);
		ArrayList<Produto> produtos=new ArrayList<Produto>();
		produtos.add(produtoA);	
		produtos.add(produtoB);
		Pedido pedido1= new Pedido(1,clienteA,produtos);		
		pedidos.add(pedido1);
		System.out.println("----------------------------");
		for (Pedido pedido : pedidos) {
			System.out.println("NOME:"+pedido.getCliente().getNome());
			System.out.println("CPF:"+pedido.getCliente().getCpf());
			for (Produto produto : pedido.getProdutos()) {
				System.out.println(">>PRODUTO:"+produto.getNome());
				System.out.println(">>PRECO:"+produto.getPreco());
				System.out.println("===========================");
				
			}
		}
		System.out.println("----------------------------");
	}
	public static void FazerPedidoDinamico(int codigo, String cpf ,int[] carrinhoCompras) {
		 
		 
		
		Cliente clienteP1=clientes
				.stream()
				.filter(c->c.getCpf().equals(cpf))
				.collect(Collectors.toList())
				.get(0);
		System.out.println("SITUACAO DO CLIENTE:"+clienteP1.isStatus());
		if(clienteP1.isStatus()) {
		ArrayList<Produto> produtosPedido=new ArrayList<Produto>();
		for (int codigoProduto : carrinhoCompras) {
			List<Produto> prod=null;
			prod=produtos.stream()
			.filter(p->p.getCodigo()==codigoProduto )
			.collect(Collectors.toList())
					;
			 
			if(!prod.isEmpty() || prod.size()>0 ) {
				produtosPedido.add(prod.get(0));				 
				System.out.println("PRODUTO   IDENTIFICADO:"+prod.get(0).getNome());
			}			
			else
				System.out.println("PRODUTO NAO IDENTIFICADO:"+codigoProduto);
		}
		
		
		 
		Pedido pedidoRealizado= new Pedido(codigo,clienteP1,produtosPedido);		
		pedidos.add(pedidoRealizado);
		System.out.println("----------------------------");
		 
		System.out.println("NOME:"+pedidoRealizado.getCliente().getNome());
		System.out.println("CPF:"+pedidoRealizado.getCliente().getCpf());
		double totalPedido=0;
		for (Produto produto : pedidoRealizado.getProdutos()) {
			System.out.println(">>PRODUTO:"+produto.getNome());
			System.out.println(">>PRECO:"+produto.getPreco());
			System.out.println("===========================");
			totalPedido+= produto.getPreco();
				
			 
		}
		System.out.println("TOTAL PEDIDO:"+totalPedido); 
		System.out.println("----------------------------"); 
		}
		else {
			System.out.println("Cliente inativo"); 
		}
	}

	public static void main(String[]args) {
		
		FazerPedido();
		cadastrarCliente(11, "Ciclano", "004146545");
		cadastrarCliente(12, "Beltrano", "0999999");
		cadastrarCliente(15, "Beltrano12", "0999999");
		System.out.println("----------------------------");
		for (Cliente cliente : clientes) {
			
			System.out.println("NOME:"+cliente.getNome());
			System.out.println("CPF:"+cliente.getCpf());
			System.out.println("----------------------------");
		}
		 
		cadastrarProduto(1,"TV 32",333.58);
		cadastrarProduto(2,"Smartphone 3g",900.01);
		cadastrarProduto(3,"TV 52",333.58);
		cadastrarProduto(4,"Smartphone 5g",900.01);
		for (Produto produto : produtos) {
			
			System.out.println("NOME:"+produto.getNome());
			System.out.println("Preco:"+produto.getPreco());
			System.out.println("----------------------------");
		}
		//menu();
		int [] codProdutos= {1,4,8};	
		
		 for (Cliente cliente : clientes) {
			if(cliente.getCpf().equalsIgnoreCase("0999999")) {
				cliente.setStatus(true);
				}
			
		} 
		FazerPedidoDinamico(1,"0999999",codProdutos);
		
		
		
		
	}
}
