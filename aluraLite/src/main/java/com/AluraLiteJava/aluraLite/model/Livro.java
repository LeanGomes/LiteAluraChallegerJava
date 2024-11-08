package com.AluraLiteJava.aluraLite.model;


import jakarta.persistence.*;

@Entity  // Define que a classe é uma entidade JPA (Java Persistence API)
@Table(name = "livros")  // Define a tabela no banco de dados para armazenar os livros
public class Livro {

    @Id  // Define o campo 'Id' como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Define o modo de geração do valor da chave primária (auto incremento)
    private int Id;

    private String titulo;  // Atributo que armazena o título do livro
    private String idioma;  // Atributo que armazena o idioma do livro
    private Long download;  // Atributo que armazena o número de downloads do livro

    // Relacionamento Muitos-para-Um (Muitos livros para um autor) com a entidade Autor
    @ManyToOne(cascade = CascadeType.PERSIST) // A anotação cascade especifica que a operação de persistência será realizada na entidade relacionada (Autor)
    @JoinColumn(name = "autor_id")  // Especifica a coluna que será usada para o relacionamento com a tabela Autor
    private Autor autor;  // Atributo que representa o autor do livro

    // Construtor padrão (sem argumentos), necessário para o JPA
    public Livro() {
    }

    // Construtor que recebe um objeto DadosLivro (dados obtidos da API ou de outro sistema) e preenche os atributos da classe Livro
    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();  // Atribui o título do livro
        // Atribui o idioma do livro (verifica se o idioma não é nulo ou vazio, caso contrário, atribui um valor padrão)
        this.idioma = dadosLivro.idioma() != null && !dadosLivro.idioma().isEmpty() ? dadosLivro.idioma().get(0) : "Idioma não disponível";
        this.download = dadosLivro.download();  // Atribui o número de downloads do livro

        // Verifica se a lista de autores não é nula ou vazia e atribui o primeiro autor
        if (dadosLivro.autor() != null && !dadosLivro.autor().isEmpty()) {
            // Assumindo que autor() retorna uma lista com pelo menos um autor, atribui o primeiro autor da lista
            this.autor = new Autor(dadosLivro.autor().get(0).nome(), dadosLivro.autor().get(0).dataNascimento(), dadosLivro.autor().get(0).dataFalecimento());
        } else {
            // Caso não haja autor, atribui um autor padrão
            this.autor = new Autor("Autor Desconhecido", null, null);
        }
    }

    // Método addAutor() que supostamente deveria adicionar um autor ao livro, mas atualmente apenas chama o método getAutor()
    // (O código está incorreto, pois não está realizando nenhuma operação de adição do autor)
    public void addAutor(Autor autor) {
        getAutor();  // Aqui deveria ser feito um código para associar o autor ao livro
    }

    // Getters e Setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getDownload() {
        return download;
    }

    public void setDownload(Long download) {
        this.download = download;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return
                "Titulo: " + titulo + '\n' +
                "Autor : " + autor.getNome() + '\n' +
                "Idioma : " + idioma + '\n' +
                "Download realizados: " + download + "\n" +
                "*************************************"
                ;
    }
}
