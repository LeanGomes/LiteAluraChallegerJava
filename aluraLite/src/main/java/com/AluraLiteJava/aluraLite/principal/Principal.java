package com.AluraLiteJava.aluraLite.principal;

import com.AluraLiteJava.aluraLite.model.*;
import com.AluraLiteJava.aluraLite.repository.AutorRepository;
import com.AluraLiteJava.aluraLite.repository.LivroRepository;
import com.AluraLiteJava.aluraLite.service.ConsumoAPI;
import com.AluraLiteJava.aluraLite.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@Service
public class Principal {

    // URL base da API para buscar livros
    private final String ENDERECO = "https://gutendex.com/books/?search=";

    // Scanner para capturar entradas do usuário
    private final Scanner scanner = new Scanner(System.in);

    // Objetos auxiliares para consumir a API e converter dados
    private final ConsumoAPI consumo = new ConsumoAPI();
    private final ConverteDados conversor = new ConverteDados();

    // Listas para armazenar livros e autores temporariamente
    private List<Livro> livros = new ArrayList<Livro>();
    private List<Autor> autores = new ArrayList<Autor>();

    // Repositórios para acessar o banco de dados
    private final LivroRepository repositorioLivro;
    private final AutorRepository repositorioAutor;

    // Construtor que usa injeção de dependência para os repositórios
    @Autowired
    public Principal(LivroRepository repositorioLivro, AutorRepository repositorioAutor) {
        this.repositorioLivro = repositorioLivro;
        this.repositorioAutor = repositorioAutor;
    }

    // Exibe o menu de opções para o usuário
    public void exibirMenu() {
        int opcao = -1;  // Variável para armazenar a opção escolhida pelo usuário

        // Laço de repetição que mostra o menu até o usuário escolher sair (opção 0)
        while (opcao !=0) {
            System.out.println("Bem-vindo ao LiterAlura!");  // Saudação
            System.out.println("Escolha uma opção:");  // Apresentação das opções
            System.out.println("1. Buscar livro pelo título");
            System.out.println("2. Listar livros registrados");
            System.out.println("3. Listar autores");
            System.out.println("4. Listar autores por ano ");
            System.out.println("5. Listar livros por idioma");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();  // Captura a opção escolhida pelo usuário
            scanner.nextLine();  // Limpeza do buffer para capturar corretamente strings

            // Switch para chamar o método correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    buscarLivro();  // Buscar livro pelo título
                    break;
                case 2:
                    listarLivros();  // Listar todos os livros
                    break;
                case 3:
                    listarAutor();  // Listar todos os autores
                    break;
                case 4:
                    listarAutorPorAno();  // Listar autores vivos por ano
                    break;
                case 5:
                    listaTituloPorIdioma();  // Listar livros por idioma
                    break;
                case 0:
                    System.out.println("Saindo...");  // Mensagem de saída
                    System.exit(0);  // Encerra a aplicação
                default:
                    System.out.println("Opção inválida. Tente novamente.");  // Caso a opção não seja válida
            }
        }
    }

    // Método para listar livros de acordo com o idioma fornecido pelo usuário
    private void listaTituloPorIdioma() {
        System.out.println("Digite o idioma para busca: ");
        String idioma = scanner.nextLine();  // Lê o idioma informado pelo usuário

        // Chama o repositório para buscar livros no idioma especificado, ignorando maiúsculas/minúsculas
        List<Livro> livros = repositorioLivro.findByIdiomaIgnoreCase(idioma);
        if (livros.isEmpty()) {
            System.out.println("Não há livros registrados para o idioma especificado.");
        } else {
            livros.forEach(System.out::println);  // Exibe os livros encontrados
        }
    }

    // Método para listar autores vivos em determinado ano
    private void listarAutorPorAno() {
        System.out.println("Digite o ano para busca: ");
        int ano = scanner.nextInt();  // Lê o ano informado pelo usuário
        try {
            // Chama o repositório para buscar autores vivos no ano informado
            List<Autor> autorVivo = repositorioAutor.searchAliveAutorByYear(ano);
            if (autorVivo.isEmpty())
                System.out.println("Não há autores registrados.");
            else
                autorVivo.forEach(System.out::println);  // Exibe os autores encontrados
        } catch (NullPointerException e) {
            System.out.println("\nLista vazia!\n");  // Caso a lista de autores esteja vazia
        }
    }

    // Método para listar todos os autores registrados
    private void listarAutor() {
        // Busca todos os autores no banco de dados
        autores = repositorioAutor.findAll();
        // Ordena os autores pelo nome e exibe
        autores.stream()
                .sorted(Comparator.comparing(Autor::getNome))
                .forEach(System.out::println);
    }

    // Método para listar todos os livros registrados
    private void listarLivros() {
        // Busca todos os livros no banco de dados
        livros = repositorioLivro.findAll();
        // Ordena os livros pelo título e exibe
        livros.stream()
                .sorted(Comparator.comparing(Livro::getTitulo))
                .forEach(System.out::println);
    }

    // Método para buscar um livro pelo título e salvar no banco de dados
    private void buscarLivro() {
        DadosLivro dadosLivro = getDadosLivro();  // Chama o método para obter os dados do livro
        Livro livro = new Livro(dadosLivro);  // Cria o objeto Livro com os dados obtidos

        // Salva o livro no banco de dados
        repositorioLivro.save(livro);
        System.out.println(dadosLivro);  // Exibe os dados do livro
    }

    // Método para capturar os dados do livro (usando a API para buscar informações)
    private DadosLivro getDadosLivro() {
        System.out.println("Digite o título do livro para busca");
        var nomeLivro = scanner.nextLine();  // Lê o título do livro informado pelo usuário
        var json = consumo.obterDados(ENDERECO + nomeLivro.replace(" ", "+"));  // Chama a API para obter os dados do livro
        ResultadoDados resultadoDados = conversor.obterDados(json, ResultadoDados.class);  // Converte os dados da API para um objeto
        return resultadoDados.livros().get(0);  // Retorna o primeiro livro da lista
    }
}

