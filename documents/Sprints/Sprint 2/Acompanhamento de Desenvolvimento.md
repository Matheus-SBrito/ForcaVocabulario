# Documento de acompanhamento de Atividades

O documento tem como objetivo servir como um mapa, a fim de identificar as tarefas desenvolvidas e os processos atuais no desenvolvimento do projeto

## Sprint 2

### Enquete de acompanhamento de protótipos já feitos

Selecione uma ou mais opções.

| Seleção | Tarefa |
|---|---|
| [   ] | Tela Login - HTML e CSS |
| [   ] | Cadastro 1º ADM - HTML e CSS |
| [   ] | Esqueceu a Senha - HTML e CSS |
| [   ] | Pagina Inicial - HTML e CSS |
| [   ] | Levantamento de Dados, Persistidos no Sistema |
| [   ] | Diagrama Entidade Relacionamento |
| [   ] | Relatório Sprint 2 |

## Dados Persistidos no Sistema

```mermaid
erDiagram

# Susgestão - Tanto Jogador quanto Administrador são especializações de Usuário


Usuario {

    email VARCHAR(100) PK
    nome_de_usuario VARCHAR(100) "NN"
    senha VARCHAR(200) "NN"
    tipo_usuario VARCHAR(30) "NN"

}


Vocabulario {

    id INT PK "AUT"
    palavra VARCHAR(30) "NN, UN"
    dificuldade INT "NN"
    dica TEXT 

}


Historico_De_Partidas {
    
}
```