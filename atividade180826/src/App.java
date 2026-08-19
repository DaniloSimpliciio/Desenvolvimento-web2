public class App {
    public static void main(String[] args) throws Exception {
        X x1,x2,x3;

        x1 = new X();
        x1.inc();
        x2=new X();
        x2.dec();
        x3=x2;
        x2=x1;
        x2.inc();
        x3.inc();
        System.out.println("apresente: " + x3.cont );

        
    }
}
