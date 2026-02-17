💱 Conversor de Moedas - Java

## 📌 Descrição

Projeto desenvolvido para consumir uma API de câmbio e converter moedas
dinamicamente.

O sistema permite selecionar opções prefixadas de conversão (ex: USD -\>
BRL) e calcular o valor convertido com base nas taxas retornadas pela
API.
------------------------------------------------------------------------

## 🏗 Estrutura do Projeto

-   Principal → Ponto de entrada (main)
-   Menu → Interface com usuário
-   Conversao → Chamada da API e lógica de conversão
-   ParMoeda (record) → Representa par de moedas
-   ExchangeResponse (record) → Representa resposta da API

------------------------------------------------------------------------

## ⚙️ Funcionamento

1.  Usuário escolhe uma opção do menu.
2.  O Map associa o número a um ParMoeda.
3.  A classe Conversao chama a API usando a moeda base.
4.  O JSON é convertido para ExchangeResponse com Gson.
5.  A taxa é extraída do Map\<String, Double\> conversion_rates.
6.  O valor é multiplicado pela taxa.
7.  O resultado é exibido formatado.

------------------------------------------------------------------------

## 👨‍💻 Autor

Caio Martins
