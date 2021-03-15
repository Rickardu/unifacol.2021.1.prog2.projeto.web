package revisao.repositorio;

import java.util.ArrayList;

import revisao.dominio.Cliente;

public class ClienteRepositorio {
	
	private ArrayList<Cliente> repositorioCliente;
	
	public ClienteRepositorio(ArrayList<Cliente> clientes) {
		this.repositorioCliente=clientes;
	}
	
	
	public Cliente perquisarPorCPf(String cpf) {		 
		for (Cliente cliente : repositorioCliente) {
			if(cliente.getCpf().equals(cpf)) {				
				return cliente;				
			}			 
		}
		return null;
	}
	
	public void salvar(Cliente cliente) {
		this.repositorioCliente.add(cliente);
	}
	
	public Cliente pesquisarPorCodigo(int codigoCliente) {
		for (Cliente cliente : repositorioCliente) {
			if(cliente.getCodigo()==codigoCliente) {				
				return cliente;				
			}
		}
		return null;
	}
}
