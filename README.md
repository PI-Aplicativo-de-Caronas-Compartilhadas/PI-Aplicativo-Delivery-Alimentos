# 🥗 NutriGo - Plataforma de Delivery de Alimentos Saudáveis



## 📋 Sobre o Projeto

O **NutriGo** é uma API REST desenvolvida para uma plataforma de delivery focada em alimentação saudável. O sistema permite o cadastro de usuários, o gerenciamento de categorias de alimentos e o controle de um cardápio focado em bem-estar, trazendo informações nutricionais como a contagem de calorias dos produtos.

---

## 🧠 Lógica de Recomendação (Java Random)

Para incentivar hábitos alimentares saudáveis de forma dinâmica, implementamos um sistema simples de **Recomendação de Produtos** utilizando a classe `java.util.Random`. 

* **Como funciona:** A API busca os produtos saudáveis disponíveis no banco de dados e, através de uma lógica em Java puro, seleciona e exibe itens de forma aleatória para o usuário na tela principal, garantindo uma experiência nova a cada acesso.

---

## 🗄️ Estrutura do Banco de Dados (DER)

A API é composta por três tabelas principais integradas:

1. **`tb_usuario`**: Armazena as credenciais de acesso (`nome`, `usuario` (e-mail), `senha` e link da `foto`).
2. **`tb_produtos`**: Contém os pratos e bebidas do cardápio (`nome`, `preco`, `calorias`, `descricao`), vinculando qual usuário cadastrou o produto e a qual categoria ele pertence.
3. **`tb_categoria`**: Organiza os tipos de alimentos (`nome`), como "Vegano", "Zero Açúcar", "Proteicos", etc.

---

## 🛣️ Principais Rotas da API

### 👤 Usuários (`/usuario`)
* `GET /usuario` — Lista todos os usuários.
* `POST /usuario` — Cadastra um novo usuário.

### 📂 Categorias (`/categoria`)
* `GET /categoria` — Lista todas as categorias.
* `POST /categoria` — Cria uma nova categoria.

### 🥗 Produtos e Recomendações (`/produto`)
* `GET /produto` — Lista todo o cardápio.
* `POST /produto` — Adiciona um novo produto saudável.
* `GET /produto/recomendacoes` — Rota que executa a lógica do **Random em Java** para sugerir pratos ao usuário de forma aleatória.

---

## 🚀 Tecnologias Utilizadas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white) ![Insomnia](https://img.shields.io/badge/Insomnia-black?style=for-the-badge&logo=insomnia&logoColor=5849BE)

---

## 📚 Documentação

A documentação completa do projeto está disponível em:

- docs/Documentacao_NutriGo.pdf

## 🧪 Testes da API

A Collection do Insomnia utilizada para validação dos endpoints está disponível em:

- docs/Collection_Insomnia.json
<p align="center">NutriGo: Alimentação saudável a um clique de distância! 🥑✨</p>