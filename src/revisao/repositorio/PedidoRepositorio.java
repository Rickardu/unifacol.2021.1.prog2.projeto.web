package revisao.repositorio;

import java.util.ArrayList;
 
import revisao.dominio.Pedido;
import revisao.dominio.Produto;

public class PedidoRepositorio {
	private ArrayList<Pedido> repositorioPedido;
	
	public PedidoRepositorio(ArrayList<Pedido> pedidos) {
		this.repositorioPedido=pedidos;
	}
	
	
	public Pedido perquisarPorCodigo(int codigo) {		 
		for (Pedido pedido : repositorioPedido) {
			if(pedido.getCodigo()==codigo) {				
				return pedido;				
			}			 
		}
		return null;
	}
	
	public Pedido perquisarPorCodigoCliente(int codigoPedido,int codigoCliente) {		 
		for (Pedido pedido : repositorioPedido) {
			if(pedido.getCodigo()==codigoPedido ) {				
				return pedido;				
			}			 
		}
		return null;
	}	
	
	
	public void salvar(Pedido pedido) {
		this.repositorioPedido.add(pedido);
	}
	
	public void alterar(Pedido pedidoAlterado) {
		for (Pedido pedido : repositorioPedido) {
			if(pedido.getCodigo()==pedidoAlterado.getCodigo()  ) {				
				pedido=pedidoAlterado;				
			}			 
		}		
	}
	
	public ArrayList<Pedido> listarTodos(){
		return repositorioPedido;
	}
	
	public ArrayList<Pedido> listarPorCodigoCliente(int codigoCliente){
		ArrayList<Pedido> pedidosCLiente=new ArrayList<Pedido>();
		for (Pedido pedido : repositorioPedido) {
			if(pedido.getCliente().getCodigo()==codigoCliente ) {				
				pedidosCLiente.add(pedido); 				
			}			 
		}
		return pedidosCLiente;
		 
	}
	
	public Pedido listarPorCodigo(int codigo){
		
		for (Pedido pedido : repositorioPedido) {
			if(pedido.getCodigo()==codigo ) {				
				 return pedido;		
			}			 
		}
		return null;
		 
	}
	
	public ArrayList<Pedido> listarPorCodigoProduto(int codigoProduto){
		ArrayList<Pedido> pedidosProduto=new ArrayList<Pedido>();
			for (Pedido pedido : repositorioPedido) {
				 for(Produto produto : pedido.getProdutos()) {
					 if(produto.getCodigo()==codigoProduto) {
						 pedidosProduto.add(pedido);
						 continue; //break;
					 }
					 
				 }
			}
			return pedidosProduto;
			 
		}
	
	public int gerarCodigoPedido() {
		return repositorioPedido.size()+1;
	}
	
	 
	
	 
}
