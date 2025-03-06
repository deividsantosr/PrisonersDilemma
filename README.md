# Prisoner's Dilemma

Este projeto implementa o Dilema do Prisioneiro usando Java e a biblioteca Swing para criar uma interface de diálogo simples.

## Descrição

O Dilema do Prisioneiro é um jogo teórico em que dois indivíduos devem escolher entre cooperar ou trair um ao outro. As recompensas e punições são determinadas com base nas escolhas de ambos os participantes. Este programa permite que o usuário jogue várias partidas contra um "computador" que usa diferentes estratégias.

## Como Executar

1. Clone este repositório para sua máquina local.
2. Importe o projeto no NetBeans.
3. Compile e execute a classe `PrisonersDilemma`.

## Estrutura do Código

A principal classe do projeto é `PrisonersDilemma` localizada no pacote `prisonersdilemma`.
```java

public class PrisonersDilemma {

  public static void main(String[] args) {
    ...  
  }

}
```


## Lógica do Programa

1. O usuário escolhe uma estratégia de jogo.
2. O usuário faz sua escolha entre trair ou cooperar.
3. O comparsa (computador) faz uma escolha baseada na estratégia selecionada.
4. O programa exibe o resultado e incrementa os contadores.
5. O usuário pode continuar jogando ou finalizar o programa.
6. No final, um relatório é exibido com as estatísticas das partidas.

## Estratégias Disponíveis

- **Não Iterado**: Sem estratégia específica, escolha aleatória.
- **Olho por olho**: Repete a última escolha do oponente.
- **Olho por dois olhos**: Coopera enquanto o usuário não trair duas vezes consecutivas.
- **Provador Ingênuo**: Repete a última escolha do oponente, mas ocasionalmente trai.
- **Retaliador Permanente**: Coopera até que o usuário traia.

## Autor

Projeto criado como um exercício de lógica e programação em Java, utilizando a biblioteca Swing para interação com o usuário.
