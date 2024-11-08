# Challenge Alura One ![logoAlura](https://github.com/user-attachments/assets/fad5494d-9102-46f4-8fb1-00a26c20f626)


Challenge LiterAlura -  Alura One. Desafio praticando Spring Boot.

Aplicação desenvolvida em Java utilizando Spring Boot para gerenciar livros e autores. O projeto permite que os usuários busquem livros pelo título, listem livros e autores registrados, filtrem livros por idioma e listem autores que estiveram vivos em determinado ano. Ele também integra uma API externa para buscar dados sobre livros.

## Tecnologias utilizadas:

<img  loading="lazy" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="40" height="40"/> <img  loading="lazy" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" width="40" height="40"/>

## Estrutura:

![image](https://github.com/user-attachments/assets/f58e7311-eeba-4a64-afa9-e5af658b0175)




## Clone o repositório:
   ```sh
   [https://github.com:LeanGomes/LiteAluraChallegerJava.git]
   ```

## Funcionalidades

- **Buscar livro pelo título**: Permite ao usuário buscar informações sobre um livro através de uma API externa (Gutendex).
- **Listar livros registrados**: Exibe todos os livros cadastrados no sistema, com informações como título, idioma e autor.
- **Listar autores**: Exibe todos os autores cadastrados no sistema, com seus respectivos nomes e datas de nascimento e falecimento.
- **Listar autores por ano**: Permite ao usuário consultar quais autores estavam vivos em um determinado ano.
- **Listar livros por idioma**: Exibe livros registrados em um idioma específico, ignorando diferenças de maiúsculas e minúsculas.

### 2. Configuração do Banco de Dados

1. Crie um banco de dados no PostgreSQL chamado `literalura`:
    ```sql
    CREATE DATABASE literalura;
    ```
2. No arquivo `application.properties` ou `application.yml`, configure a conexão com o banco de dados:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.driverClassName=org.postgresql.Driver
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```


## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para fazer um fork deste projeto e enviar pull requests. Todas as contribuições são apreciadas.
