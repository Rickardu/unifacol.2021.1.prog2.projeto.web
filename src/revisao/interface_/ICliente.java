package revisao.interface_;

import java.util.ArrayList;

import revisao.dominio.Cliente;

public interface ICliente {
	public void cadastrar(Cliente cliente);
	public boolean alterar(Cliente cliente );	 
	public ArrayList<Cliente> listar();
	public  Cliente listarPorCpf();
	public boolean suspenderPorCodigo(int codigo);
	public boolean suspenderPorCpf(int cpf);
}
