package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {

    private String nome;
    private String email;
    private Date dataDeNascimento;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Cliente(String nome, String email, Date dataDeNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    @Override
    public String toString() {
        return "    == Bem-Vindo, " + nome + " == \n"
                + "\n"
                + "Dados da sua conta: \n"
                + email + "\n"
                + String.format(sdf.format(dataDeNascimento))
                + "\n";
    }
}
