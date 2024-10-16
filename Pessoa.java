package org.senai.model;

public class Pessoa {

   // Atributos
    private int id;
    private String nome;
    private String email;
    private String matricula;

    // Constructor
    public Pessoa(int id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", matricula=" + matricula +"]";
    }

}