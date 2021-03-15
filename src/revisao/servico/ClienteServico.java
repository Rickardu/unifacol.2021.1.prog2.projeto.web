package revisao.servico;

import java.util.ArrayList;

import revisao.dominio.Cliente;
import revisao.repositorio.ClienteRepositorio;

public class ClienteServico {
	private ClienteRepositorio cliRepo;
	
	public ClienteServico(ArrayList<Cliente> clientes) {
		this.cliRepo = new ClienteRepositorio(clientes);
		 
	}
	
	public void cadastrar(int codigo, String nome, String cpf) {
		boolean cpfRepetido=false;
		Cliente buscaCLiente=this.cliRepo.perquisarPorCPf(cpf);
		 
		if(buscaCLiente!=null)
			cpfRepetido=true;
		
		if(!cpfRepetido) {
			if(nome!=null && nome.length()>3 && cpf!=null && cpf.length()>5) {
				Cliente clienteA = new Cliente(codigo,nome,cpf);
				this.cliRepo.salvar(clienteA);
				System.out.println("Cliente Salvo");
			}else
				System.out.println("Cliente NAO Salvo");			
			
		}else
			System.out.println("CPF JA CADASTRADO");
			System.out.println("CPF JA CADASTRADO");
		
	}
	
	public Cliente perquisarPorCPf(String cpf) {
		if(vericarCpf(cpf)) {
			Cliente cliPesquisado=this.cliRepo.perquisarPorCPf(cpf);
			if(cliPesquisado!=null)
				return cliPesquisado;
			else
				return null;
		}
		else
			return null;
	}
	
	private boolean vericarCpf(String cpf) {
		return true;
	}
	
	public Cliente pesquisarPorCodigo(int codigoCliente) {
		Cliente cliente=null; 
		if(codigoCliente>0) {
			cliente = this.cliRepo.pesquisarPorCodigo(codigoCliente);
			if(cliente.getCodigo()>100) {
				cliente.setCpf(anonimizarCpf(cliente.getCpf()));
				return cliente; 
			}
			else
				return null;
		}
		
		else
			return null;
	}
	
	private String anonimizarCpf(String cpf) {
		String cpfAnonimizado=cpf.substring(0,3)+"063********";
		return cpfAnonimizado;
	}
	
	
}
