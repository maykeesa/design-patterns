## O que é o Proxy?

O proxy é um design pattern estrutural que intermedia a comunicação entre dois pontos através de um substituto/cópia. O proxy controla o acesso ao objeto original, podendo realizar ações previamente ou posteriormente.

> 💡 [Exemplo prático](https://github.com/maykeesa/design-patterns/tree/main/src/main/java/br/com/design/patterns/structural/proxy)

## Aplicabilidade

- **Inicialização lenta**: Adia a criação/carregamento de um objeto custoso até o momento em que ele é realmente necessário.
- **Controle de acesso**: Validações previamente para verificar se o usuário que está realizando a operação tem permissão de realizar.
- **Auditoria de chamadas**: Antes e após realizar a operação principal registrar a utilização de funcionalidade.
- **Cache**: Utilização de cache em retorno de método para uma melhor experiência de usuário.
- **Framework**: No Spring Boot é um pattern extremamente usado, quando anotamos um método com **@Transactional**, o Spring cria um Proxy ao redor do seu **@Service**. Quando o controller chama o serviço, ele chama o Proxy primeiro, que abre a transação no BD, executa o seu método real e faz o **commit** ou **rollback** no final.

## Diagrama

![](images/Pasted%20image%2020260811213107.png)

![](images/Pasted%20image%2020260811213148.png)

## Referências
- [Proxy - Refactoring Guru](https://refactoring.guru/pt-br/design-patterns/proxy)
- [Padrão de Projeto Proxy: Melhore a Arquitetura do Seu Código Usando Orientação a Objetos! - Renato Augusto](https://www.youtube.com/watch?v=el1MtIPXTqo&list=PLNHxHgB-_LTt67szNmMsZwqBKq9jH4uKJ)