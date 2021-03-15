package revisao.interface_;

import java.util.ArrayList;

import revisao.dominio.Pedido; 

public interface IPedido {
	public void cadastrar(Pedido pedido);	 
	public boolean alterarQuantidadeItem(int codigoPedido,int codigoProduto, int quantidade );	 
	public ArrayList<Pedido> listar();
	public  Pedido listarPorCodigo(int codigo);
	public  Pedido listarPorCodigoProduto(int codigoProduto);
	public boolean cancelar(int codigo);
}
