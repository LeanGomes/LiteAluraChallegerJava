package com.AluraLiteJava.aluraLite.model;

import jakarta.persistence.*;


@Entity  // Define que a classe é uma entidade JPA (Java Persistence API), que será mapeada para uma tabela no banco de dados
@Table(name = "autor")  // Define a tabela no banco de dados associada a esta classe (tabela 'autor')
public class Autor {

    @Id  // Define o campo 'id' como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Define que o valor do 'id' será gerado automaticamente pelo banco de dados (auto incremento)
    private int id;  // Atributo que armazena o identificador do autor

    private String nome;  // Atributo que armazena o nome do autor
    private Integer dataNascimento;  // Atributo que armazena o ano de nascimento do autor (em formato inteiro)
    private Integer dataFalecimento;  // Atributo que armazena o ano de falecimento do autor (em formato inteiro, pode ser nulo se o autor estiver vivo)

    // Construtor padrão (sem argumentos), necessário para o JPA
    public Autor() {
    }

    // Construtor que recebe os parâmetros nome, dataNascimento e dataFalecimento
    // Esse construtor é utilizado para criar uma nova instância de Autor com os dados fornecidos
    public Autor(String nome, Integer dataNascimento, Integer dataFalecimento) {
        this.nome = nome;  // Atribui o nome do autor
        this.dataNascimento = dataNascimento;  // Atribui o ano de nascimento do autor
        this.dataFalecimento = dataFalecimento;  // Atribui o ano de falecimento do autor (pode ser nulo caso o autor ainda esteja vivo)
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Integer dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(Integer dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    @Override
    public String toString() {
        return
                "Autor: "+ nome + '\n' +

                "Data de Nascimento: " + dataNascimento + "\n"+
                "Data de Falecimento: " + dataFalecimento + "\n" +
                "*************************************"
                ;
    }
}