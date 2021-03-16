package revisao.interface_;

import java.util.ArrayList;

import revisao.dominio.CarrinhoCompra;
import revisao.dominio.Pedido;

public interface IPedidoCliente {
	public void cadastrar(CarrinhoCompra carrinhoCompra,int codigoCliente);
	public boolean cancelar(int codigo,int codigoCliente);
	public ArrayList<Pedido> listar(int codigoCliente);
	public  Pedido listarPorCodigo(int codigo,int codigoCliente);
}
