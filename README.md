# Empresa

Gerenciamento de Patrimônio Empresarial.

## Descrição

API Gerenciamento de Patrimônio Empresarial.

## EndPoints:

* **Patrimônio:**

GET patrimonios - Obter todos os patrimônios

GET patrimonios/{id} - Obter um patrimônio por ID

POST patrimonios - Inserir um novo patrimônio

PUT patrimonios/{id} - Alterar os dados de um patrimônio

DELETE patrimonios/{id} - Excluir um patrimônio

* **Marcas:**

GET marcas - Obter todas as marcas

GET marcas/{id} - Obter uma marca por ID

GET marcas/{id}/patrimônios - Obter todos os patrimônios de uma marca

POST marcas - Inserir uma nova marca

PUT marca/{id} - Alterar os dados de uma marca

DELETE marca/{id} - Excluir uma marca

* **Usuários:**

GET usuarios – Listar os usuários

POST usuarios – Criar um usuário

DELETE usuários/{id} – Excluir um usuário

## Autenticação:

* **URL:** 
http://localhost:8080/login

* **Body:**
{
    "username" : "admin",
    "password" : "password"
}

* **Authorization Type:** Bearer Token

## Banco de dados:

* **SGBD:** PostgreSQL
* **script:** /empresa/script/empresa.sql

### Requisitos

* Java 8
* Maven

### Executar

./mvn spring-boot:run 

## Autor

* **Rhandy Mendes Ferreira** - *Desenvolvedor* - [rhandymf](https://github.com/rhandymf)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
