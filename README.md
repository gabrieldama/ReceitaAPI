# ReceitaAPI

API REST em Java com Spring Boot para cadastrar e consultar receitas culinárias, com ingredientes e modo de preparo.

## Tecnologias

Java 21, Spring Boot, Spring Data JPA, MySQL, Lombok, Springdoc OpenAPI (Swagger UI) e Maven.

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| GET | /api/receitas | Lista todas as receitas |
| GET | /api/receitas/{id} | Busca uma receita pelo id |
| POST | /api/receitas | Cria uma receita |

Exemplo de corpo para POST:

```json
{
  "nome": "Macarrão ao alho e óleo",
  "descricao": "Receita rápida",
  "tempoPreparo": 20,
  "porcoes": 2,
  "categoria": "MASSA",
  "ingrediente": [{ "nome": "Macarrão", "quantidade": "200 g" }],
  "modoPreparo": ["Cozinhe o macarrão", "Refogue o alho no óleo", "Misture tudo"]
}
```

Categorias disponíveis: ENTRADA, PRATO_PRINCIPAL, SOBREMESA, BEBIDA, LANCHE, MASSA e SALADA.

## Como rodar

Requisitos: JDK 21 e MySQL em execução na porta 3306.

1. Ajuste usuário e senha do banco em `src/main/resources/application.yaml` (o padrão é root/root; o banco `receita_api` é criado automaticamente).
2. Execute `./mvnw spring-boot:run`.
3. Acesse a documentação interativa em `http://localhost:8080/swagger-ui.html`.

## Próximos passos

Atualizar e excluir receitas (PUT e DELETE), validação dos dados de entrada e tratamento de erros com respostas HTTP adequadas.
