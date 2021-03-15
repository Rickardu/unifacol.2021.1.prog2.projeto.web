package revisao.dominio;

public class Cliente extends Pessoa{
	private int codigo;
	private boolean status=false;
	 
	public Cliente(int codigo,String nome, String cpf) {
		super(nome,cpf);
		this.codigo = codigo;
		 
	}
	public Cliente(int codigo,String nome, String cpf,boolean status) {
		super(nome,cpf);
		this.codigo = codigo;
		this.status = status;
		 
	}
	
	 
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		
		this.status = status;
	}
	 
	
	

}
