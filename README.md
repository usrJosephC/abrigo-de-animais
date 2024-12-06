# 🐾 **Sistema de Gerenciamento de Abrigo de Animais** 🐾

Bem-vindo ao **Sistema de Gerenciamento de Abrigo de Animais**! 🎉  
Este sistema permite o gerenciamento de um abrigo de animais, onde **usuários** podem adotar animais e **administradores** podem gerenciar o processo de adoção.

---

<p align="center">
  <a href="#️-funcionalidades">Funcionalidades</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#️-estrutura-do-projeto">Estrutura do Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-persistência-de-dados">Persistência de Dados</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-contribuição">Contribuição</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#memo-licença">Licença</a>
</p>

<p align="center">
  <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=49AA26&labelColor=000000">
</p>

---

## 🛠️ **Funcionalidades**

### Para Usuários Comuns

- **📋 Cadastro de usuário**: Registre-se no sistema com seu nome, email e senha.
- **🔐 Login de usuário**: Faça login usando seu email e senha.
- **🔍 Pesquisa de animais**: Veja a lista de animais disponíveis para adoção, filtrando por nome, espécie, porte e idade.
- **💌 Solicitação de adoção**: Escolha um animal para adoção e registre um pedido com a data de adoção.
- **✏️ Edição de dados pessoais**: Atualize suas informações pessoais, como nome, email e senha.

### Para Administradores

- **🔑 Login de administrador**: Acesse com o código de acesso ("1111").
- **➕ Cadastro de animais**: Adicione novos animais ao sistema com nome, idade, espécie, porte e descrição.
- **📜 Gerenciamento de pedidos de adoção**: Visualize, aprove ou rejeite os pedidos de adoção e remova os animais adotados da lista.

---

## 📂 **Estrutura do Projeto**

O projeto é composto pelas seguintes classes principais:

1. **`Main.java`**: Classe principal que executa o sistema, mostrando menus e interagindo com o usuário.
2. **`Abrigo.java`**: Gerencia a lista de usuários, animais e pedidos de adoção.
3. **`Usuario.java`**: Representa o usuário, com informações como nome, email e senha.
4. **`Animal.java`**: Representa um animal disponível para adoção, com atributos como nome, idade, espécie, porte e descrição.
5. **`Pedido.java`**: Representa um pedido de adoção feito por um usuário.

---

## 💾 **Persistência de Dados**

O sistema utiliza arquivos **.txt** para armazenar os dados de forma persistente:

- **`usuarios.txt`**: Contém os dados dos usuários cadastrados.
- **`animais.txt`**: Armazena os animais disponíveis para adoção.
- **`pedidos.txt`**: Armazena os pedidos de adoção realizados pelos usuários.

Esses arquivos estão localizados na pasta **`lib`** do projeto e são carregados e salvos automaticamente ao iniciar e fechar o sistema.

---

## 🚀 **Como Executar**

1. Clone o repositório em sua máquina local:

  ```bash
   git clone https://github.com/seu-usuario/abrigo-de-animais.git
  ```
2. Abra o projeto em sua IDE favorita (como Eclipse, IntelliJ IDEA ou VS Code).

3. Compile e execute o código Java. Você verá o menu interativo no console, onde pode escolher entre as seguintes opções:
  -- Cadastrar usuário
  -- Fazer login como usuário
  -- Fazer login como administrador
  -- Sair

---

## 🧰 Requisitos
-- Java 8 ou superior.
-- IDE com suporte a Java (recomendado IntelliJ IDEA, Eclipse ou VS Code).

---

## 🤝 Contribuição
Contribuições são bem-vindas! Se você tem sugestões, correções ou melhorias para o projeto, sinta-se à vontade para abrir um pull request.

---

## 📜 Licença
Este projeto é licenciado sob a MIT License.

---

## 🎨 Aparência no Console
  ```bash
    ===============================================
         🐾   Abrigo dos Animais   🐾
    ===============================================
            Seu abrigo de confiança
          onde o amor pelos animais começa! 💖
    ===============================================
  ```