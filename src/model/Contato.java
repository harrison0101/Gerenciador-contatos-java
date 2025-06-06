public class Contato {
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String toString() {
        return nome + ";" + telefone + ";" + email;
    }

    public static Contato fromString(String linha) {
        String[] p = linha.split(";");
        return new Contato(p[0], p[1], p[2]);
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
}
