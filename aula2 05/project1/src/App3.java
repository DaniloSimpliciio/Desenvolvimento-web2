import javax.swing.JOptionPane;

public class App3 {
    public static void main(String[] args) throws Exception {
        int number1, number2, sum;

        
        number1 = Integer.parseInt(JOptionPane.showInputDialog("digite um numero: "));
        
        number2 = Integer.parseInt(JOptionPane.showInputDialog("digite outro numero: "));

        sum = number1 + number2;

        JOptionPane.showMessageDialog(null,"soma = " + sum);
    }
}
    