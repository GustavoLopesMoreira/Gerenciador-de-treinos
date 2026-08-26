# 🏋️‍♂️ Gerenciador de Treinos

Um sistema prático para criação, edição e gerenciamento de rotinas de exercícios. Desenvolvido inicialmente como uma aplicação de terminal (CLI) em Java, este projeto permite organizar treinos e séries de forma simples e rápida.

> **Status do Projeto:** 🚧 Funcional, mas em constante evolução (Em Construção).

## 💻 Sobre o projeto

O projeto nasceu com o objetivo de facilitar o acompanhamento de treinos na academia. Atualmente, ele funciona via linha de comando, salvando todos os dados localmente em um arquivo de texto (`.txt`). Isso garante que as informações não sejam perdidas ao fechar o programa. 

A arquitetura atual serve como base para a **fase 2 do projeto**, onde o sistema será transformado em uma aplicação robusta com interface e banco de dados.

## ✨ Funcionalidades Atuais

- **Listagem de Treinos:** Visualize todos os treinos cadastrados e seus respectivos exercícios.
- **Criação de Treino:** Adicione novos treinos personalizados.
- **Edição de Treino:** 
  - Adicione novos exercícios a um treino existente (incluindo o número de séries).
  - Remova exercícios específicos de um treino.
- **Exclusão:** Apague treinos inteiros que não são mais utilizados.
- **Persistência de Dados:** Salvamento automático das informações em um arquivo `meus-treinos.txt` ao encerrar a aplicação.

## 🚀 Tecnologias

**Tecnologias utilizadas atualmente:**
- Java (Standard Edition)
- Paradigma de Orientação a Objetos (POO)
- File I/O (BufferedReader / BufferedWriter) para persistência em `.txt`
- Tratamento de Exceções (Try/Catch)

## 🗺️ Roadmap (Próximos Passos)

O projeto está sendo atualizado para se tornar uma aplicação web moderna. As próximas atualizações incluem:

- [x] CRUD completo via terminal em Java.
- [x] Persistência de dados em arquivo de texto.
- [ ] **Migração para Spring Boot:** Criação de uma API REST para gerenciamento dos treinos.
- [ ] **Banco de Dados Relacional:** Substituir o salvamento em `.txt` pela integração com **MySQL**.
- [ ] **Interface Gráfica/Web:** Desenvolvimento de um Front-end para consumo da API.

Feito por: Gustavo Lopes Moreira.
-GitHub: https://github.com/GustavoLopesMoreira
-LinkedIn: https://www.linkedin.com/in/gustavo-lopes-moreira/
