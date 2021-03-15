package revisao.dominio;

public class Produto {
	private int codigo;
	private String nome;	
	private double preco;
	private boolean status;
	public Produto(int codigo,String nome, double preco) {
		 
		this.nome = nome;
		this.preco = preco;
		this.codigo=codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	
}
