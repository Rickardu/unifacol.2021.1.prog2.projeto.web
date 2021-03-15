package revisao.interface_;

import java.util.ArrayList;

import revisao.dominio.Produto;

public interface IProduto {
	public void cadastrar(Produto produto);
	public boolean alterar(Produto produto );
	public boolean alterarQuantidade(int codigo, int quantidade );
	public boolean alterarPreco(int codigo, double preco);
	public ArrayList<Produto> listar();
	public  Produto listarPorCodigo();
	public boolean remover(int codigo);
	
	

}
