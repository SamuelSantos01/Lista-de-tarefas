## Padrão de Commits

Para garantir um histórico de commits organizado e de fácil compreensão, adotamos o padrão [Conventional Commits](https://www.conventionalcommits.org/). Aqui estão as categorias e exemplos de como usar cada uma delas:

### Tipos de Commit

- **feat**: Usado para adicionar uma nova funcionalidade ao projeto.
  - Exemplo: `feat: adicionar endpoint para listar tarefas`

- **fix**: Usado para corrigir um erro ou bug.
  - Exemplo: `fix: corrigir erro ao atualizar tarefa`

- **docs**: Usado para alterações na documentação do projeto.
  - Exemplo: `docs: atualizar README com novos exemplos de endpoints`

- **style**: Usado para alterações de estilo (como formatação de código, espaçamentos, etc.) que não afetam a lógica ou funcionalidade.
  - Exemplo: `style: corrigir indentação do código`

- **refactor**: Usado para refatoração de código que não altera a funcionalidade, mas melhora a legibilidade ou estrutura do código.
  - Exemplo: `refactor: refatorar função de validação de dados`

- **test**: Usado para adicionar ou modificar testes automatizados.
  - Exemplo: `test: adicionar testes para a criação de novas tarefas`

- **chore**: Usado para tarefas gerais que não se encaixam nas categorias acima, como atualizações de dependências ou configurações do projeto.
  - Exemplo: `chore: atualizar dependências do projeto`

### Regras para Mensagens de Commit

1. **Formato da mensagem**: A mensagem de commit deve seguir o formato: 

- Exemplo: `feat: adicionar autenticação de usuários`

2. **Descrição do commit**:
- A descrição deve ser concisa, mas explicativa o suficiente para entender o que foi feito.
- Use a forma imperativa (não use "adicionando" ou "corrigido", por exemplo, mas "adicionar" ou "corrigir").

3. **Referência a issues**: 
- Quando necessário, inclua um número de issue no final da mensagem de commit, como por exemplo:
