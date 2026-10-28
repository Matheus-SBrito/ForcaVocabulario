# Projeto de POO – 2026.2

## 1. Descrição do Projeto

O projeto consiste em um sistema que permitirá que jogadores de forca compitam entre si ou disputem partidas solo. Os usuários deverão se cadastrar informando, pelo menos, um login e uma senha. Após entrar no sistema, poderão consultar o histórico de partidas, consultar os rankings de jogadores ou jogar. As partidas poderão ser disputadas contra outro jogador — que também deverá se autenticar antes da partida — ou individualmente.

## 2. Requisitos Funcionais

### Cadastro do administrador

Quando o sistema for iniciado pela primeira vez, não haverá usuários cadastrados e o fluxo deverá ser direcionado para a tela de cadastro do administrador. Nas inicializações seguintes, se já houver um usuário cadastrado, o sistema deverá exibir a tela de login. O administrador deverá informar, pelo menos, um e-mail e uma senha. Outras informações poderão ser incluídas conforme necessário.

### Cadastro de jogador

Para utilizar o jogo, o usuário deverá se cadastrar informando, pelo menos, um login, uma senha e um e-mail. Não poderá haver usuários com login ou e-mail repetidos.

### Login

Para acessar as funções do sistema, o usuário deverá passar por uma tela de autenticação. Ele informará seu e-mail e sua senha. Se as credenciais estiverem corretas, o sistema o direcionará para a tela inicial correspondente ao seu perfil.

### Recuperação de senha

O usuário poderá solicitar a redefinição da senha pela opção disponível na tela de login. Após solicitar a redefinição, receberá um código numérico por e-mail. Esse código deverá ser informado na tela de cadastro da nova senha para confirmar sua identidade. Se o código estiver correto, o usuário poderá cadastrar uma nova senha.

### Atualização da base de vocábulos (somente administrador)

O administrador poderá enviar um arquivo CSV com novos vocábulos para a plataforma. Cada linha deverá seguir esta estrutura:

```text
operação (0 = cadastrar, 1 = editar, 2 = excluir), palavra, nível de dificuldade (0 = fácil, 1 = médio, 2 = difícil), dica
```

Exemplo:

```text
0, bola, 0, objeto usado em atividades esportivas
```

O arquivo deverá ser analisado linha por linha. Linhas inválidas serão ignoradas e listadas em um relatório ao final do processo, com o motivo da rejeição. Não será possível cadastrar palavras já existentes nem editar ou excluir palavras que ainda não estejam cadastradas. A dificuldade de uma palavra não poderá ser alterada.

### Partida solo

Após se autenticar, o jogador poderá iniciar uma partida solo e escolher um dos três níveis de dificuldade. O sistema sorteará uma palavra previamente cadastrada. Se não houver palavras cadastradas, não será possível iniciar a partida. O sistema deverá garantir que o mesmo jogador nunca visualize a mesma palavra duas vezes, seja em partidas solo ou competitivas.

A pontuação das partidas solo será calculada da seguinte forma:

#### Fórmula da pontuação

Pontuação = pontos da palavra + bônus de eficiência

Os pontos da palavra serão definidos pelo comprimento:

| Comprimento | Pontos |
| --- | ---: |
| 3 a 4 letras | 100 |
| 5 a 6 letras | 150 |
| 7 a 8 letras | 200 |
| 9 ou mais letras | 300 |

O multiplicador será definido pela dificuldade da palavra:

O multiplicador deverá ser aplicado aos pontos definidos pelo comprimento da palavra.

| Dificuldade | Multiplicador |
| --- | ---: |
| Fácil | ×1,0 |
| Médio | ×1,5 |
| Difícil | ×2,0 |

O bônus de eficiência será calculado de acordo com a quantidade de erros:

| Erros | Bônus |
| --- | ---: |
| Nenhum | +100 pontos |
| 1 | +75 pontos |
| 2 | +50 pontos |
| 3 | +25 pontos |
| 4 ou 5 | 0 ponto |
| 6 | −100 pontos (derrota automática) |

### Partida contra outro jogador

Um jogador autenticado poderá consultar a lista de jogadores cadastrados e escolher um oponente. Para confirmar que está presente no mesmo espaço físico que o jogador autenticado, o oponente deverá informar suas credenciais (login e senha).

Em partidas competitivas, serão sorteadas duas palavras com o mesmo nível de dificuldade e o mesmo número de letras. O confronto será composto por duas partidas, cada uma iniciada por um jogador diferente. O jogador continuará dando palpites até errar; nesse momento, a vez passará ao oponente. A pontuação será calculada da mesma forma que na partida solo. Se o segundo jogador não tiver a oportunidade de informar uma letra, receberá 100 pontos. Ao fim das duas partidas, os jogadores compararão a pontuação acumulada para determinar o vencedor. O vencedor receberá 3 pontos no ranking competitivo; em caso de empate, cada jogador receberá 1 ponto.

### Rankings solo e competitivo

O sistema deverá manter dois rankings independentes: um de pontuação solo e outro de pontuação competitiva. O ranking solo considerará a soma dos pontos obtidos pelo jogador em todas as partidas solo. O ranking competitivo considerará os pontos obtidos em partidas contra outros jogadores, conforme definido em **Partida contra outro jogador** (3 pontos por vitória e 1 por empate).

O sistema deverá ordenar os jogadores por pontuação em cada ranking e permitir identificar a posição de cada um. As partidas de jogadores cujas contas forem posteriormente inativadas continuarão sendo consideradas nos rankings. Todos os jogadores poderão visualizar os rankings.

### Histórico de partidas

O sistema deverá armazenar as informações das partidas solo e competitivas. Para cada partida, deverão ser armazenados, pelo menos:

- Data e hora da partida;
- Jogadores envolvidos;
- Tipo de partida;
- Palavras utilizadas;
- Nível de dificuldade;
- Registros das operações realizadas durante a partida;
- Resultado da partida;
- Pontuação obtida por cada jogador.

No caso de partidas competitivas, também deverão ser armazenadas as informações das duas partidas que compõem o confronto e o resultado final entre os jogadores. O histórico deverá permanecer disponível mesmo que a conta de um jogador seja posteriormente inativada.

### Lista de jogadores com filtro por nome

O sistema deverá permitir que os usuários consultem a lista de jogadores cadastrados. A listagem deverá apresentar, pelo menos, o nome ou login do jogador, a situação da conta e a posição nos rankings solo e competitivo. Deverá haver um campo para filtrar os jogadores pelo nome, permitindo localizar um jogador sem percorrer toda a lista. Jogadores com contas inativadas deverão permanecer registrados e identificados como inativos.

### Lista de partidas com filtros (somente administrador)

O administrador poderá consultar as partidas registradas no histórico e filtrá-las por período e pelo nome de um dos jogadores envolvidos. O sistema deverá apresentar, pelo menos, a data da partida, o tipo, os jogadores envolvidos, o resultado e a pontuação obtida. Os filtros poderão ser utilizados individualmente ou em conjunto. Será possível abrir uma partida da lista para consultar todos os seus detalhes.

### Edição ou inativação do perfil de jogador (somente administrador)

O administrador poderá acessar o perfil detalhado de um jogador para alterar seus dados cadastrais ou inativar sua conta. Após a inativação, o jogador não poderá fazer login nem iniciar novas partidas. O login ficará disponível para um novo cadastro. As partidas anteriores à inativação não deverão ser excluídas e continuarão sendo consideradas no histórico, nos rankings e nos relatórios da plataforma.

### Envio de avisos (somente administrador)

O administrador poderá cadastrar e enviar avisos para todos os jogadores ou para um jogador específico. Cada aviso deverá possuir, pelo menos, um título, uma mensagem, a data de envio, o status (ENVIADO ou LIDO) e a data em que foi visualizado. Avisos destinados a todos os jogadores deverão ficar disponíveis para todos os jogadores com conta ativa. Avisos destinados a um jogador específico deverão ser acessíveis somente por esse jogador.

### Visualização de avisos

O jogador autenticado poderá consultar os avisos destinados a ele, incluindo os avisos enviados para todos os jogadores e os enviados especificamente para sua conta. Os avisos deverão apresentar, pelo menos, o título, a mensagem e a data de envio. O sistema deverá indicar quais avisos ainda não foram visualizados pelo jogador.

### Dashboard de palpites por letra

O sistema deverá registrar os palpites realizados durante as partidas e utilizar esses dados em um dashboard estatístico. Para cada letra do alfabeto, o dashboard deverá apresentar a quantidade e/ou a taxa de vezes em que ela foi escolhida, bem como a quantidade e/ou a taxa de vezes em que estava ou não presente na palavra sorteada. As informações deverão considerar as partidas realizadas na plataforma.

### Relatório de palavras mais e menos acertadas (somente administrador)

O administrador poderá gerar um relatório com as palavras que apresentam as maiores quantidades de acertos e erros. O relatório deverá apresentar, pelo menos, cada palavra e a quantidade de vezes em que foi acertada ou errada. As informações deverão ser obtidas do histórico das partidas, e o relatório deverá permitir exportação em PDF.

### Exportação de dados dos jogadores (somente administrador)

O administrador poderá gerar uma planilha com os dados dos jogadores cadastrados. A planilha deverá apresentar, pelo menos, o login, o e-mail ou outro dado de contato e o total de pontos obtidos pelo jogador na plataforma. O arquivo deverá ser disponibilizado no formato XLS.

### Desenho da forca durante as partidas (desafio)

Durante uma partida, o sistema deverá apresentar visualmente o desenho da forca e atualizá-lo de acordo com a quantidade de erros. O desenho deverá ser construído progressivamente, contendo a cabeça, o tronco, os dois braços e as duas pernas, na ordem definida pelo sistema. Ao atingir a quantidade máxima de erros permitida, o desenho deverá estar completo e a partida será considerada perdida.

### Armazenamento de arquivos online (desafio)

Os arquivos utilizados para armazenar e disponibilizar os dados necessários à execução da aplicação deverão ser mantidos em um serviço de armazenamento online, como Google Drive ou Dropbox. O sistema deverá permitir armazenar e recuperar os arquivos pelo serviço escolhido, garantindo a disponibilidade dos dados mesmo quando a aplicação for executada em outro computador.

### Relógio e bônus de tempo (desafio)

Durante as partidas solo e competitivas, o sistema deverá apresentar um relógio indicando o tempo disponível para o jogador realizar seus palpites. O jogador iniciará a partida com 120 pontos de tempo. A cada segundo transcorrido, será descontado 1 ponto. Ao final da partida, os pontos de tempo restantes serão adicionados à pontuação como bônus. Se o saldo chegar a zero, o jogador não receberá bônus de tempo. O relógio deverá funcionar tanto nas partidas solo quanto nas competitivas.

## 3. Algumas classes do sistema (sugestões)

Esta seção será elaborada posteriormente.

## 4. Como começar este projeto

### Primeiro estágio

- Crie classes para representar as entidades manipuladas no projeto, com seus atributos e métodos (construtores, getters e setters, `equals`, `toString` etc.).
- Crie uma classe chamada `Central`, com listas de jogadores e partidas e quaisquer outras informações que precisem ser persistidas. Essa classe reunirá as informações manipuladas e armazenadas pelo sistema.
- Na classe `Central`, crie métodos para adicionar um jogador, cadastrar uma partida, buscar um jogador pelo nome, listar partidas e jogadores, excluir um jogador, salvar uma partida etc. Esses métodos devem corresponder às funcionalidades do projeto e ser implementados da forma mais simples possível. Não devem imprimir no console nem solicitar dados ao usuário pelo console. Dê preferência a métodos que recebam como parâmetros todas as informações necessárias.
- Se optar pela persistência com XStream, pesquise a biblioteca e como salvar e recuperar objetos.
- **Parte 1:** crie uma classe que receba um objeto `Jogador` e o salve em um arquivo XML. Verifique se o arquivo representa o objeto. Em seguida, adapte a classe para receber uma `Central` em vez de um jogador.
- **Parte 2:** crie uma classe que recupere do arquivo o objeto gravado.

### Segundo estágio

- Crie métodos para imprimir no console as informações dos relatórios. Em seguida, pesquise como gerar os relatórios nos formatos solicitados.
- Crie um método para enviar um e-mail, recebendo o texto da mensagem e o destinatário.
- Planeje a navegação do projeto. Desenhe cada tela e indique como navegar entre elas. Para facilitar, imagine que a janela principal possui uma barra de menus com acesso a todas as funções do projeto.
- Escreva o relatório final.
- Apresente o projeto.

## 5. Interface gráfica

O aluno deverá desenvolver o projeto para uma destas três plataformas: desktop (utilizando Swing), web ou mobile. Para as duas últimas, poderá escolher a tecnologia, embora sejam recomendados JSF e Android, respectivamente.

## 6. Persistência de dados

A persistência de dados deverá ser implementada utilizando arquivos em um destes formatos: binário, XML, JSON ou TXT. Para persistência em XML ou JSON, recomenda-se o uso do XStream.

## 7. Sobre os grupos

Os alunos poderão realizar o trabalho individualmente ou em trio. A avaliação de cada aluno levará em conta sua contribuição para o projeto final.

## 8. Relatórios

### 8.1. Relatório quinzenal

A cada 15 dias, o aluno deverá entregar um relatório com pelo menos 10 linhas, em fonte Times New Roman, tamanho 12, explicando:

- O que cada aluno fez no projeto;
- As dificuldades encontradas;
- O planejamento.

### 8.2. Relatório final

No dia anterior à apresentação, todas as equipes deverão disponibilizar o executável do projeto para que o professor possa se familiarizar com a aplicação.

Na apresentação, cada aluno deverá entregar um relatório final com pelo menos quatro páginas, descrevendo:

- O que o aluno fez no projeto;
- Quais funcionalidades o grupo conseguiu implementar;
- Quais funcionalidades o grupo não conseguiu implementar e por quê;
- A experiência do aluno no desenvolvimento do projeto (o que mais gostou, as maiores dificuldades e se o projeto contribuiu para seu aprendizado);
- Quais bibliotecas o grupo utilizou e por que as escolheu;
- As referências consultadas (links de tutoriais, perguntas em fóruns etc.);
- A impressão de uma classe considerada importante no projeto;
- A documentação dessa classe (JavaDoc).

## 9. Sobre a nota

A nota do aluno levará em consideração a quantidade de requisitos funcionais implementados e as decisões relativas aos requisitos não funcionais. Também serão avaliados aspectos relacionados ao código e à postura do aluno em sala e durante a apresentação.

### 9.1. Dimensões avaliadas

| Dimensão | Critério |
| --- | --- |
| D1 | Código |
| D2 | Abstrações de orientação a objetos |
| D3 | Completude e corretude funcional |
| D4 | Interface com o usuário |
| D5 | Tratamento de situações de erro |
| D6 | Diferencial do projeto |
| D7 | Avaliação individual do aluno |
| D8 | Trabalho em grupo |
| D9 | Defesa oral |

## 10. Sugestões de referências

A seguir, algumas sugestões de bibliotecas que podem ser utilizadas no projeto.

### 10.1. Geração de arquivos em PDF

A API nativa de manipulação de arquivos do Java pode ser usada para criar arquivos PDF simples. A biblioteca iText oferece os mesmos recursos de forma mais completa, incluindo tabelas e cabeçalhos.

Tutorial de iText: [Usando a API iText para gerar documentos PDF em Java](http://www.forumweb.com.br/artigo/223/java/usando-a-api-itext-para-gerar-documentos-pdf-em-java).

### 10.2. Persistência de dados com XStream

Tutorial de XStream: [Criando e lendo arquivo XML em Java com XStream](http://deixaeuprogramar.weebly.com/home/criando-e-lendo-arquivo-xml-em-java-com-xstream).

### 10.3. Rankings de jogadores

As referências para geração de rankings poderão ser incluídas posteriormente.
