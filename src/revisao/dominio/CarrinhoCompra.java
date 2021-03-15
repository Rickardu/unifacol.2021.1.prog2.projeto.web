package revisao.dominio;

import java.util.ArrayList;

public class CarrinhoCompra {
	private int codigo;	 
	private ArrayList<Produto> produtos;
	
	public CarrinhoCompra(int codigo, ArrayList<Produto> produtos) {
		 
		this.codigo = codigo;
		this.produtos = produtos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	

}
