package prisonersdilemma;

import javax.swing.JOptionPane;

public class PrisonersDilemma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Contadores
        int beetrayAndBeetray = 0; //Trair e Trair
        int beetrayAndCooperate = 0; //Trair e Cooperar
        int cooperateAndCooperate = 0; //Cooperar e Cooperar

        int totalMatches = 0; //Total de partidas

        //Menu de estratégias, lista com espaço para 6 strings [0-5]
        String[] strategyOption = new String[6];

        strategyOption[0] = "Não Iterado";
        strategyOption[1] = "Olho por olho";
        strategyOption[2] = "Olho por dois olhos";
        strategyOption[3] = "Provador Ingênuo";
        strategyOption[4] = "Retaliador Permanente";

        //Menu de escolha, lista com espaço para 2 strings [0-1]
        String[] choiceOption = new String[2];

        choiceOption[0] = "1";
        choiceOption[1] = "2";

        //Controle de execução do programa
        boolean continueProgram = true;

        //Salva a última estratégia escolhida
        String lastStrategy = null;

        //Últimas escolhas do usuário, lista com espaço para 2 int [0-1]
        int[] lastChoice = new int[2];

        //Enquanto o usuário não encerrar o programa
        while (continueProgram) {
            //Adiciona a opção de finalizar o programa na segunda partida
            if (totalMatches == 1) {
                strategyOption[5] = "Finalizar programa";
            }

            String message = null;

            //Altera mensagem a partir sa segunda partida
            if (totalMatches >= 1) {
                message = "Selecione outra estratégia ou finalize o programa";
            }

            //Estratégia selecionada
            String selectedStrategy = null;

            //Válida estratégia escolhida por usuário, não permite cancelar
            while (selectedStrategy == null) {
                selectedStrategy = (String) JOptionPane.showInputDialog(null, message, "Estratégia", JOptionPane.QUESTION_MESSAGE, null, strategyOption, lastStrategy);

                lastStrategy = selectedStrategy;
            }

            //Decide se o programa vai encerrar
            continueProgram = !selectedStrategy.equals(strategyOption[5]);

            if (continueProgram) {
                int user = 0;

                //Valida escolha do usuário, não permite cancelar
                while (user == 0) {
                    String choiceUser = (String) JOptionPane.showInputDialog(null, null, "Trair ou Cooperar", JOptionPane.QUESTION_MESSAGE, null, choiceOption, choiceOption[0]);

                    user = choiceUser == null ? 0 : Integer.parseInt(choiceUser);
                }

                int comparsa = (int) (1 + Math.random() * 2);

                //Altera escolha do comparsa baseado na estratégia escolhida
                if (totalMatches >= 1) {
                    //Olho por olho
                    if (selectedStrategy.equals(strategyOption[1])) {
                        //Repete a última escolha do oponente
                        comparsa = lastChoice[1];
                    }

                    //Olho por dois olhos
                    if (selectedStrategy.equals(strategyOption[2])) {
                        //Semelhante ao olho por olho mas coopera enquanto usuário não trair duas vezes
                        if (lastChoice[0] == 2 && lastChoice[1] == 2) {
                            comparsa = 2;
                        } else {
                            comparsa = lastChoice[1];
                        }
                    }

                    //Provador Ingênuo
                    if (selectedStrategy.equals(strategyOption[3])) {
                        //Repete a última escolha do oponente mas as vezes trai caso o usuário cooperar
                        if (lastChoice[1] == 1) {
                            comparsa = lastChoice[1];
                        }
                    }

                    //Retaliador Permanente
                    if (selectedStrategy.equals(strategyOption[4])) {
                        //Coopera até o usuário trair
                        if (lastChoice[1] == 1) {
                            comparsa = 1;
                        }
                    }
                }

                //Incrementa contadores beseado na escolha do usuário e do comparsa(PC)
                if (user == 1 && comparsa == 1) {
                    beetrayAndBeetray++;
                } else if ((user == 1 && comparsa == 2) || (user == 2 && comparsa == 1)) {
                    beetrayAndCooperate++;
                } else if (user == 2 && user == 2) {
                    cooperateAndCooperate++;
                }

                String comparsaText = (comparsa == 1 ? "1 - Trair" : "2 - Cooperar");

                //Mostra resultado do comparsa
                JOptionPane.showMessageDialog(null, "Seu comparsa optou por " + comparsaText, "Comparsa", JOptionPane.WARNING_MESSAGE);

                totalMatches++;

                //Seta penúltima escolha do usuário
                lastChoice[0] = lastChoice[1];

                //Seta última escolha do usuário
                lastChoice[1] = user;
            } else {
                String report = "Total de partidas: " + totalMatches
                        + "\nTrair x Trair: " + ((beetrayAndBeetray * 100) / totalMatches) + "%"
                        + "\nTrair x Cooperar: " + ((beetrayAndCooperate * 100) / totalMatches) + "%"
                        + "\nCooperar x Cooperar: " + ((cooperateAndCooperate * 100) / totalMatches) + "%";

                //Mostra o relatório ao encerrar programa
                JOptionPane.showMessageDialog(null, report, "Relatório", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
