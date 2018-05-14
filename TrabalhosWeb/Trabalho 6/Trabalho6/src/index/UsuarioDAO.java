package index;

import java.util.ArrayList;

public class UsuarioDAO {
	ArrayList<Usuario> pessoas = new ArrayList<Usuario>();
	
	public void cadastrarPessoas(){
		Usuario barbara = new Usuario("barbara_neves", "123");
		Usuario julio = new Usuario("julio_martins", "456");
		
		pessoas.add(barbara);
		pessoas.add(julio);
		
		//Pessoa p = new Pessoa(login, senha);
		//pessoas.add(p);
	}
	
	public Usuario buscarPessoa(String login, String senha) {
		for (Usuario pessoa : pessoas) {
			if(pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
				return pessoa;
			}
		}
		return null;
	}

	public ArrayList<Usuario> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Usuario> pessoas) {
		this.pessoas = pessoas;
	}
}

