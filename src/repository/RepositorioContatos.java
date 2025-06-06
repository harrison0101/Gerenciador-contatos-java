import model.Contato;
import java.io.*;
import java.util.*;

public class RepositorioContatos {
    private final String arquivo = "contatos.txt";

    public List<Contato> carregar() {
        List<Contato> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(Contato.fromString(linha));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar contatos: " + e.getMessage());
        }
        return lista;
    }

    public void salvar(List<Contato> contatos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Contato c : contatos) {
                bw.write(c.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos: " + e.getMessage());
        }
    }
}
