## O que é o Singleton?

O design pattern singleton é um **padrão criacional** que possibilita gerar uma **única instância** de uma classe para o projeto todo, sendo criada apenas em sua primeira chamada e **reutilizada a mesma instância posteriormente**.

> 💡 [Exemplo prático](https://github.com/maykeesa/design-patterns/tree/main/src/main/java/br/com/design/patterns/creational/singleton)

### Quando usar?

A utilização do singleton vai depender do qual custoso é seguir o fluxo normal de criar, usar e deletar uma instância, contra a de ocupar um espaço de memória permanentemente enquanto a aplicação funciona. Para DTOs a utilização de singleton não é o ideal, visto que são instâncias temporárias e devem ser individuais/específicas de cada requisição, mas para um pool de conexão ao bd é ideal, visto que criar a conexão e autenticar com o banco de dados leva de 100ms a 500ms, e fazer isso para cada chamada ao bd é inviável em grande escala.

Em caso de ociosidade do singleton por muito tempo ou utilização excessiva da memória por outras partes que não envolve o singleton, é possível implementar o mesmo utilizando **referências fracas**, dando a possibilidade do Garbage Collector (no contexto do Java) realizar a coleta daquela instância.

### Anti-pattern?

Tem pontos importantes que fazem a não adoção da implementação clássica do singleton, e sim o uso de singletons de frameworks que tem todos esses problemas resolvidos. **Dificuldade de consistência em testes**, um dos testes podem influenciar no estado do singleton criado para o suíte de testes fazendo os seus posteriores quebrarem.

É um variável global disfarçada de classe, se guardar um estado mutável pode afetar outras partes do sistema ou quebrar a ordem dos testes.

Concorrência, se o primeiro `getInstance()` for chamado duas vezes no mesmo milissegundo é possível criar duas instâncias, possíveis soluções são **Bill Pugh Holder** ou **Enums**.

Viola o **S** e o **D** do **SOLID**, o singleton assume duas responsabilidades, a regra de negócio tida nele e o gerenciamento do próprio ciclo de vida, ferindo o **Single Responsibility**. No caso do **Dependency Inversion Principle**, as classes dependentes estão amarradas pelo Singleton concreto e não uma abstração dela.

## Aplicabilidade

- **Logging e auditoria**: Como log é algo que utilizamos em todo o projeto, ter um singleton de uma classe de log é ideal para o reaproveitamento da instância e a manipulação de escrita de dados.
- **Pool de conexão do BD**: Como o acesso ao banco de dados não é algo que ocorre instantaneamente, a criação de um singleton para se ter uma pool a pronta entrega ao usuário é um boa forma de utilização do pattern.

## Diagrama

![](images/Pasted%20image%2020260813160015.png)

![](images/Pasted%20image%2020260813160042.png)

## Referências

- [Singleton - Refactoring Guru](https://refactoring.guru/pt-br/design-patterns/singleton)
- [Padrão de Projeto Singleton: Multithreading & Testes Unitários Expõem os Riscos deste Design Pattern - Renato Augusto](https://www.youtube.com/watch?v=E8ey3HjSthg&list=PLNHxHgB-_LTt67szNmMsZwqBKq9jH4uKJ&index=4)
