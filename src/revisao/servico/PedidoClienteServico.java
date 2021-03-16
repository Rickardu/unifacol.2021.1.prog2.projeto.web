package revisao.servico;

import java.util.ArrayList;

import revisao.dominio.CarrinhoCompra;
import revisao.dominio.Pedido;
import revisao.interface_.IPedidoCliente;

public class PedidoClienteServico  implements IPedidoCliente{

	@Override
	public void cadastrar( CarrinhoCompra carrinhoCompra,int codigoCliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean cancelar(int codigo,int codigoCliente) {
		// TODO Auto-generated method stub
		int x=0;
		return false;
	}

	@Override
	public ArrayList<Pedido> listar(int codigoCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido listarPorCodigo(int codigo,int codigoCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
