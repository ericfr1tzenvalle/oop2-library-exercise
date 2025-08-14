# Exercício: Sistema de Livraria em Java (POO)

Este projeto implementa um sistema simples de gerenciamento de exemplares para uma livraria, como parte de um exercício de Programação Orientada a Objetos. O sistema modela publicações (livros e revistas), exemplares físicos (impressões) e a própria livraria que gerencia o estoque.

## ✨ Funcionalidades Principais

- **Modelagem OO:** Utiliza herança (`Publicacao` como classe base para `Livro` e `Revista`) e composição (uma `Livraria` contém um `Estoque` de `Impressao`).
- **Gerenciamento de Estoque:** A classe `Livraria` permite adicionar exemplares únicos ou em lote, consultar a quantidade de um determinado título e vender exemplares.
- **Identidade de Objetos:** Implementação robusta dos métodos `equals()` e `hashCode()` em todas as classes do modelo para garantir o comportamento correto em coleções e comparações lógicas.
- **Geração de ID Único:** Cada `Impressao` (exemplar) recebe um código sequencial e único no momento de sua criação (ex: `R0`, `L1`, `L2`, ...).
- **Validação e Robustez:** Os construtores das classes possuem validações para prevenir a criação de objetos com dados inválidos (ex: títulos nulos, edições negativas), lançando `IllegalArgumentException`.

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Maven** para gerenciamento do projeto.
- **JUnit** (implícito no `TestaApp`) para testes unitários e validação da lógica.

## 🚀 Como Executar o Projeto

1.  **Pré-requisitos:**
    * JDK 17 ou superior instalado.
    * Apache Maven instalado.

2.  **Clonar o repositório:**
    ```bash
    git clone https://github.com/ericfr1tzenvalle/oop2-library-exercise.git
    cd oop2-library-exercise
    ```

3.  **Compilar o projeto:**
    ```bash
    mvn compile
    ```

4.  **Executar a classe de testes (`TestaApp`):**
    O projeto foi desenhado para ser validado pela classe `TestaApp.java`, que simula as operações e verifica se os resultados estão corretos. Para executá-la (assumindo que está no classpath de teste):
    ```bash
    # (Instruções específicas podem variar dependendo da IDE ou configuração)
    # Pela linha de comando, após compilar, você pode precisar executar os testes via Maven:
    mvn test
    ```

##  UML Diagrama de Classes

O projeto segue a seguinte estrutura de classes:

```mermaid
classDiagram
    class Publicacao {
        <<abstract>>
        -String titulo
        -LocalDate data
        +getTitulo() String
        +getData() LocalDate
    }

    class Livro {
        -int numPaginas
        -String[] autores
        +getNumPaginas() int
        +getAutores() String[]
    }

    class Revista {
        -int edicao
        -String editora
        +getEdicao() int
        +getEditora() String
    }

    class Impressao {
        -LocalDate data
        -Publicacao publicacao
        -String codigo
        -static int contador
        +getData() LocalDate
        +getPublicacao() Publicacao
        +getCodigo() String
    }

    class Livraria {
        -String nome
        -ArrayList<Impressao> estoque
        +getExemplares(Publicacao pub) int
        +addEstoque(Publicacao pub) void
        +addEstoque(Publicacao pub, int quantidade) void
        +vende(Publicacao pub) Impressao
    }

    Publicacao <|-- Livro
    Publicacao <|-- Revista
    Livraria o-- "0..*" Impressao : contém
    Impressao --> "1" Publicacao : é uma impressão de
