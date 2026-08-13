---
name: obsidian-to-md
description: 'Converte um arquivo Markdown do Obsidian para Markdown padrão na pasta docs/ do projeto.'
---

# Converter Obsidian MD para docs/

Sua tarefa é converter o arquivo Obsidian MD informado pelo usuário (${args}) para Markdown padrão e salvá-lo em `docs/` no projeto atual.

## Passos

1. **Leia o arquivo** Obsidian informado em ${args}

2. **Extraia o frontmatter YAML** (entre `---`) e colete:
   - `link:` → se for URL do YouTube, use o Bash tool com curl para extrair o título e canal:
     ```
     curl -s "<url>" | grep -oP '(?<="title":{"runs":\[{"text":")[^"]+' | head -1
     curl -s "<url>" | grep -oP '(?<="ownerChannelName":")[^"]+' | head -1
     ```
     Use essas informações para montar o item na seção `## Referências` no final do documento.
     Formato: `- [<Título do Vídeo> - <Nome do Canal>](<url>)`
   - **Refactoring Guru**: sempre inclua como **primeiro item** da seção `## Referências` o link do Refactoring Guru para o pattern.
     Derive o nome do pattern a partir do nome do arquivo (sem extensão), em letras minúsculas e com hífens no lugar de espaços.
     Formato: `- [<NomeDoPattern> - Refactoring Guru](https://refactoring.guru/pt-br/design-patterns/<nome-do-pattern>)`
     Exemplo para `Proxy.md`: `- [Proxy - Refactoring Guru](https://refactoring.guru/pt-br/design-patterns/proxy)`
   - `example:` → vira um blockquote logo após o texto da primeira seção `## O que é ...?`
     Formato: `> 💡 [Exemplo prático](<url>)`
   - `tags:` → descarte (não aparece no MD final)

3. **Converta a sintaxe Obsidian para Markdown padrão:**
   - `![[imagem.png]]` → `![](images/imagem.png)`
   - `![[imagem.png|largura]]` → `![](images/imagem.png)` (remova o parâmetro de largura)
   - `[[wikilink]]` → texto simples ou link relativo se existir arquivo correspondente em docs/
   - Qualquer outra sintaxe específica do Obsidian deve ser adaptada para Markdown padrão

4. **Copie as imagens** referenciadas no arquivo:
   - Localize as imagens originais no workspace do Obsidian (geralmente em `Outros/Imagens/`)
   - Copie-as para `docs/images/` no projeto atual usando o Bash tool

5. **Salve o arquivo convertido** em `docs/<NomeDoArquivo>.md` (mesmo nome do original)

6. **Atualize o README.md** na raiz do projeto:
   - Adicione uma linha na tabela de Design Patterns com:
     - Nome do pattern (nome do arquivo sem extensão)
     - Categoria (Estrutural, Criacional ou Comportamental — infira pelo conteúdo)
     - Breve descrição (extraia do conteúdo do arquivo)
     - Link relativo para `docs/<NomeDoArquivo>.md`
   - Se o pattern já existir na tabela, atualize a linha existente

## Resultado esperado

Ao final, confirme ao usuário:
- O arquivo criado em `docs/`
- As imagens copiadas (se houver)
- A linha adicionada/atualizada no README.md