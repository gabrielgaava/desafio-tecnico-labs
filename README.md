# Desafio Tecnico Labs
> [Link](docs/) com instruções de como executar o projeto

## Cenário do projeto
Temos uma demanda para integrar dois sistemas. Um desses sistemas é legado e possui um arquivo de pedidos desnormalizados. Sendo assim, precisamos transforma-los em um arquivo json normalizado para então enviar para o outro sistema. Para que isso seja possível, precisamos satisfazer alguns requisitos.

### Objetivo:
Faça um sistema que receba um arquivo ou diretório e processe-os para um novo formato.

### Entrada de Dados:
O arquivo do sistema legado possui uma estrutura em que cada linha representa uma parte de um pedido. Os dados estão padronizados por tamanho de seus valores, respeitando a seguinte tabela:

| campo         | tamanho  | tipo                |
|:--------------|:---------|:--------------------|
| id usuário    | 10       | numérico            |
| nome          | 45       | texto               |
| id pedido     | 10       | numérico            |
| id produto    | 10       | numérico            |
| valor produto | 12       | decimal             |
| data compra   | 8        | numérico (yyyymmdd) |

![Arquivo De Dados](./docs/Data.gif)

### Saída de Dados
O formato de saída esperado deve seguir a seguinte estrutura:

```json
[
  {
    "user_id": 1,
    "name": "Zarelli",
    "orders": [
      {
        "order_id": 123,
        "total": "1024.48",
        "date": "2021-12-01",
        "products": [
          {
            "product_id": 111,
            "value": "512.24"
          },
          {
            "product_id": 122,
            "value": "512.24"
          }
        ]
      }
    ]
  }
]
```