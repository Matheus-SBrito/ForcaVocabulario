# Documento de acompanhamento de Atividades

O documento tem como objetivo servir como um mapa, a fim de identificar as tarefas desenvolvidas e os processos atuais no desenvolvimento do projeto

## Sprint 1

### Enquete de acompanhamento de protótipos já feitos

Selecione uma ou mais opções.

| Seleção | Tarefa |
|---|---|
| [ x ] | Login - Tela de Login |
| [ x ] | Login - Recuperar senha |
| [ x ] | Login - Cadastro do primeiro Adm |
| [ x ] | Menu - jogador |
| [ x ] | Menu - Adm |
| [ x ] | Histórico de partidas |
| [ x ] | Consulta de Ranquês |
| [ x ] | Jogar Sozinho ou para dois |
| [ x ] | ADM - Atualizar vocabulário |
| [ x ] | ADM - cadastrar jogador |
| [ x ] | Config: repositório github |
| [ x ] | Config: Relatório |
| [ x ] | Config: Fluxograma das Telas |

## Fluxo de Navegação das Telas — Jogo da Forca

### 1. Visão geral

O sistema está organizado em três áreas principais:

* **Inicial:** entrada e navegação principal.
* **Administrador:** autenticação e gerenciamento do vocabulário.
* **Jogador:** cadastro, autenticação, partidas, histórico e rankings.

---

### 2. Tela inicial

**Descrição:** ponto de entrada para acessar as funcionalidades do jogo.

```mermaid
flowchart TD
    A([Início]) --> B[Tela inicial]
    B --> C[Menu principal]
    C --> D[Área administrativa]
    C --> E[Área do jogador]
```

---

### 3. Fluxo administrativo

**Descrição:** permite autenticar o administrador e gerenciar o vocabulário.

```mermaid
flowchart TD
    A[Área administrativa] --> B{Existe administrador?}
    B -- Não --> C[Cadastro do primeiro ADM]
    B -- Sim --> D[Login ADM]
    C --> E[Menu ADM]
    D --> F{Credenciais válidas?}
    F -- Sim --> E
    F -- Não --> D
    E --> G[Gerenciar vocabulário]
    G --> H[Cadastrar palavra, dificuldade e dica]
    H --> I{Dados válidos?}
    I -- Sim --> J[Salvar palavra]
    I -- Não --> H
    J --> E
```

#### Telas administrativas

| Tela               | Descrição                                         |
| ------------------ | ------------------------------------------------- |
| Login/Cadastro ADM | Autentica ou cadastra o primeiro administrador.   |
| Menu ADM           | Centraliza as funcionalidades administrativas.    |
| Vocabulário        | Permite cadastrar palavras, dificuldades e dicas. |

---

### 4. Fluxo do jogador

**Descrição:** permite criar uma conta, entrar no sistema e acessar as funcionalidades individuais.

```mermaid
flowchart TD
    A[Área do jogador] --> B{Possui cadastro?}
    B -- Não --> C[Cadastro de jogador]
    B -- Sim --> D[Login]
    C --> D
    D --> E{Credenciais válidas?}
    E -- Não --> F[Recuperar senha ou tentar novamente]
    F --> D
    E -- Sim --> G[Menu do jogador]
```

#### Telas do jogador

| Tela            | Descrição                                   |
| --------------- | ------------------------------------------- |
| Cadastro        | Cria uma conta de jogador.                  |
| Login           | Autentica o jogador.                        |
| Recuperar senha | Inicia o processo de recuperação de acesso. |
| Menu do jogador | Apresenta as funcionalidades disponíveis.   |

---

### 5. Histórico e rankings

**Descrição:** permite consultar partidas anteriores e classificações.

```mermaid
flowchart TD
    A[Menu do jogador] --> B[Histórico de partidas]
    A --> C[Consulta de rankings]
    B --> D{Existem partidas?}
    D -- Sim --> E[Exibir histórico]
    D -- Não --> F[Histórico vazio]
    C --> G[Exibir classificação]
    E --> A
    F --> H[Iniciar partida]
    G --> A
```

#### Telas de consulta

| Tela      | Descrição                                   |
| --------- | ------------------------------------------- |
| Histórico | Exibe as partidas registradas pelo jogador. |
| Rankings  | Apresenta as classificações e pontuações.   |

---

### 6. Fluxo de jogo

**Descrição:** permite escolher a modalidade, jogar e visualizar o resultado.

```mermaid
flowchart TD
    A[Menu do jogador] --> B[Selecionar modalidade]
    B --> C{Tipo de partida}
    C -- Solo --> D[Preparar partida]
    C -- Multiplayer --> E[Preparar sessão com dois jogadores]
    D --> F[Tela de jogo]
    E --> F
    F --> G[Selecionar letra]
    G --> H{Letra correta?}
    H -- Sim --> I[Atualizar palavra]
    H -- Não --> J[Registrar erro e atualizar forca]
    I --> K{Partida terminou?}
    J --> K
    K -- Não --> G
    K -- Sim --> L[Resultado da partida]
    L --> M[Registrar histórico e atualizar pontuação]
    M --> N[Exibir significado e exemplos da palavra]
    N --> O{Próxima ação}
    O -- Jogar novamente --> B
    O -- Voltar ao menu --> A
```

#### Telas do jogo

| Tela               | Descrição                                             |
| ------------------ | ----------------------------------------------------- |
| Seleção de partida | Permite escolher entre solo e multiplayer.            |
| Jogo               | Apresenta a palavra, a dica e as tentativas.          |
| Resultado          | Exibe o desfecho e informações educativas da palavra. |

---

## 7. Fluxo resumido do sistema

```mermaid
flowchart TD
    A([Início]) --> B[Tela inicial]
    B --> C{Área de acesso}
    C --> D[Administrador]
    C --> E[Jogador]
    D --> F[Login ou cadastro inicial]
    F --> G[Menu ADM]
    G --> H[Vocabulário]
    E --> I[Cadastro ou login]
    I --> J[Menu do jogador]
    J --> K[Histórico]
    J --> L[Rankings]
    J --> M[Selecionar partida]
    M --> N[Tela de jogo]
    N --> O[Resultado]
    O --> J
```

---

## 8. Regras essenciais

* O cadastro inicial de administrador só deve estar disponível quando não existir um administrador cadastrado.
* O login deve validar as credenciais antes de liberar o acesso.
* O vocabulário deve conter as informações necessárias para as partidas.
* O histórico deve apresentar registros ou informar quando estiver vazio.
* O ranking deve seguir os critérios de pontuação definidos pelo projeto.
* A partida deve terminar quando o jogador descobrir a palavra ou atingir o limite de erros.
* Ao finalizar a partida, o sistema deve registrar os dados necessários e apresentar o resultado.
* O acesso às funcionalidades deve respeitar o perfil do usuário.
