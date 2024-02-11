# Participação na Rinha de Backend, Segunda Edição: 2024/Q1 - Controle de Concorrência

<img src="https://upload.wikimedia.org/wikipedia/commons/c/c5/Nginx_logo.svg" alt="logo nginx" width="200" height="auto">
<br /><br />
<img src="https://hermes.dio.me/articles/cover/a722bd8a-4f4b-4327-b4df-2608448bb4b1.jpg" alt="logo Quarkus" width="200" height="auto">
<br /><br />
<img src="https://upload.wikimedia.org/wikipedia/commons/2/29/Postgresql_elephant.svg" alt="logo postgres" width="200" height="auto">

<br />

# Bônus

### API de Checagem de Saldo

Endpoint de Checagem de saldo dos clientes: [http://localhost:9999/q/swagger-ui/](http://localhost:9999/q/swagger-ui/)

curl http://localhost:9999/clientes/checa-saldo | jq

Disponível na view: (v_checa_saldo_cliente)

<br />

---

## Critérios de Divisão de Recursos

- **API**: X 2
  - CPU: 0.25
  - Memória: 100MB

- **PostgreSQL**:
  - CPU: 0.8
  - Memória: 300MB

- **Nginx**:
  - CPU: 0.2
  - Memória: 50MB

---


## Extra

- Performance da JVM
![image](https://github.com/zsantana/rinha-de-backend-2024-java-q1/assets/17239827/a56622a2-139f-4789-be31-5aa5275a4b05)


- Conexões do Postgres
  ![image](https://github.com/zsantana/rinha-de-backend-2024-java-q1/assets/17239827/50751dd9-9b75-4f78-8d05-6f75d90838bf)

- Startup da Aplicação
  ![image](https://github.com/zsantana/rinha-de-backend-2024-java-q1/assets/17239827/8c66fcb7-0330-441e-a159-acf5b413f195)

- Resultado Final
  ![image](https://github.com/zsantana/rinha-de-backend-2024-java-q1/assets/17239827/a5852706-a3cd-4142-9cd7-34dbd6b18e08)


## Reinaldo Santana

Submissão realizada com os seguintes componentes:

- **Nginx**: Utilizado como balanceador de carga.
- **PostgreSQL**: Utilizado como banco de dados.
- **Quarkus**: Utilizado para a API.

Link para o repositório da API: [rinha-de-backend-2024-q1-poc](https://github.com/zanfranceschi/rinha-de-backend-2024-q1-poc)
