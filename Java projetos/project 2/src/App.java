import java.util.Random;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
         Random numberGenerator = new Random();
         
         int die1, die2, sum, attempts, option, guess;
         boolean isCorrect;

         // laço do jogo

         do{
            //inicialização do jogo
            die1 = numberGenerator.nextInt(6) + 1;
            die2 = numberGenerator.nextInt(6) + 1;
            sum = die1 + die2;
            attempts = 3;

            System.out.println("dado1: " + die1 + " - dado 2: " + die2 
                + "soma: " + sum
            );
            
            isCorrect = false;

            while (!isCorrect && attempts > 0) {
                attempts--;
                guess = Integer.parseInt(JOptionPane.showInputDialog(null,"digite sua aposta:"));

                if(guess == sum){
                    isCorrect = true;
                }else{
                    JOptionPane.showMessageDialog(null,"Você errou! você tem ainda " + attempts + "tentativas(s)");
                }
            }

            if(isCorrect){
                JOptionPane.showInputDialog(null,"Parabéns! Você ganhou!");
            }
            else{
                JOptionPane.showInputDialog(null,"Infelizmente você perdeu!");
            }


            option = JOptionPane.showConfirmDialog(null, "deseja jogar novamente?");
         }while (option == 0);

        }
    }
    
