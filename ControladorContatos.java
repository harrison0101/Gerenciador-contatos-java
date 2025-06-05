import java.util.*;

public class ControladorContatos {
    private List<Contato> contatos;
    private RepositorioContatos repo;

    public ControladorContatos() {
        repo = new RepositorioContatos();
        contatos = repo.carregar();
    }

    public void adicionar(String nome, String telefone, String email) {
        contatos.add(new Contato(nome, telefone, email));
        repo.salvar(contatos);
    }

    public void remover(int i) {
        contatos.remove(i);
        repo.salvar(contatos);
    }

    public List<Contato> filtrarPorNome(String nome) {
        return contatos.stream().filter(c -> c.getNome().equalsIgnoreCase(nome)).toList();
    }

    public List<Contato> listar() {
        return contatos;
    }
}
