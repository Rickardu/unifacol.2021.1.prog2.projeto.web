package revisao.dominio;

import java.util.ArrayList;

public class Pedido {
	private int codigo;
	private Cliente cliente;	
	private ArrayList<Produto> produtos;
	public Pedido(int codigo, Cliente cliente, ArrayList<Produto> produtos) {		 
		this.codigo = codigo;
		this.cliente = cliente;
		this.produtos = produtos;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	

}
