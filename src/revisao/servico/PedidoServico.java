package revisao.servico;

import java.util.ArrayList;

import revisao.dominio.CarrinhoCompra;
import revisao.dominio.Cliente;
import revisao.dominio.Pedido;
import revisao.dominio.Produto;
import revisao.interface_.IPedido;
import revisao.interface_.IPedidoCliente;
import revisao.repositorio.ClienteRepositorio;
import revisao.repositorio.PedidoRepositorio;

public class PedidoServico  implements IPedido,IPedidoCliente  {
	private PedidoRepositorio PedidoRepo;

	public PedidoServico(ArrayList<Pedido> pedidos) {
		this.PedidoRepo = new PedidoRepositorio(pedidos);		 
	}
	
	
	@Override
	public void cadastrar( CarrinhoCompra carrinhoCompra, int codigoCliente) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public boolean cancelar(int codigo, int codigoCliente) {
		// TODO Auto-generated method stub
		Pedido pedidoCancelar=PedidoRepo.listarPorCodigo(codigo);
		if(pedidoCancelar!=null) {
			if(pedidoCancelar.getCliente().getCodigo()==codigoCliente) {
				pedidoCancelar.setStatus(false);
				PedidoRepo.alterar(pedidoCancelar);
				return true;
			}
			
		}
		
		return false;
	}

	@Override
	public ArrayList<Pedido> listar(int codigoCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido listarPorCodigo(int codigo, int codigoCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterarQuantidadeItem(int codigoPedido, int codigoProduto, int quantidade) {
		// TODO Auto-generated method stub
		Pedido pedidoQtd=PedidoRepo.listarPorCodigo(codigoPedido);
		if(pedidoQtd!=null) {
			for (Produto produto : pedidoQtd.getProdutos()) {
				if(produto.getCodigo()==codigoProduto  ) {
					 produto.setQuantidade(produto.getQuantidade()+quantidade);					  
					 return true;
					 
				}
				
			}
		 
		}
		
		return false;
	}

	@Override
	public ArrayList<Pedido> listar() {
		// TODO Auto-generated method stub
		return PedidoRepo.listarTodos();
	}

	@Override
	public Pedido listarPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return PedidoRepo.listarPorCodigo(codigo);
	}

	@Override
	public ArrayList<Pedido> listarPorCodigoProduto(int codigoProduto) {
		// TODO Auto-generated method stub		
		return PedidoRepo.listarPorCodigoProduto(codigoProduto);
	}

	@Override
	public boolean cancelar(int codigo) {
		// TODO Auto-generated method stub
		Pedido pedidoCancelar=PedidoRepo.listarPorCodigo(codigo);
		if(pedidoCancelar!=null) {			 
			pedidoCancelar.setStatus(false);
			PedidoRepo.alterar(pedidoCancelar);		
			return true;
		}
		return false;
	}

	@Override
	public void cadastrar(CarrinhoCompra carrinhoCompra) {
		// TODO Auto-generated method stub
		Cliente clientePadrao=new Cliente(00, "PADRAO", "00000000");
		Pedido pedidoNovo =new Pedido(
				PedidoRepo.gerarCodigoPedido(), 
				clientePadrao, 
				carrinhoCompra.getProdutos());
		PedidoRepo.salvar(pedidoNovo);
		
		
	}

	 

	 

}
