# DSClient
API REST desenvolvida em **Java 21** e **Spring Boot 3** para o gerenciamento completo (CRUD) de clientes. O projeto foca na implementação de uma arquitetura limpa em camadas e no tratamento rigoroso de exceções e validações de dados.

##  Objetivo do Projeto

Atender aos requisitos de um sistema de gerenciamento de recursos, garantindo que todas as operações básicas (Busca, Inserção, Atualização e Deleção) funcionem com persistência de dados e respostas HTTP semanticamente corretas.

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3**
* **Spring Data JPA**
* **H2 Database** (Ambiente de testes configurado)
* **Maven** (Gerenciador de dependências)
* **Bean Validation** (Jakarta Validation)

##  Domínio e Validações

A entidade **Client** segue rigorosamente a especificação técnica:

* **Nome**: Não pode ser vazio.
* **CPF**: Identificador de pessoa física.
* **Renda**: Valor numérico de rendimentos.
* **Data de Nascimento**: Não pode ser uma data futura (`@PastOrPresent`).
* **Filhos**: Quantidade de dependentes.

##  Funcionalidades e Endpoints

O sistema implementa as cinco operações básicas:

* **Busca Paginada**: `GET /clients?page=0&size=6&sort=name`
* **Busca por ID**: `GET /clients/{id}`
* **Inserção**: `POST /clients`
* **Atualização**: `PUT /clients/{id}`
* **Deleção**: `DELETE /clients/{id}`

##  Tratamento de Exceções

O projeto foi configurado para retornar códigos de status específicos conforme a situação:

* **404 Not Found**: Retornado em buscas, atualizações ou deleções quando o ID informado não existe.
* **422 Unprocessable Entity**: Retornado em erros de validação (campos vazios ou datas inválidas), acompanhado de mensagens customizadas para cada campo.

##  Banco de Dados e Seed

* Utiliza o banco de dados em memória **H2** para facilitar a execução imediata.
* Contém um **seed de 10 clientes** com dados significativos carregados automaticamente na inicialização.

---

##  Autor

**José Victor**
*Projeto desenvolvido para fins de estudo e prática de desenvolvimento Backend.*

---
