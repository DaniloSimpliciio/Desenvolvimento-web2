package br.edu.ifspcjo.ads.web2.checkout.view;

import br.edu.ifspcjo.ads.web2.checkout.model.Buy;
import br.edu.ifspcjo.ads.web2.checkout.model.Card;
import br.edu.ifspcjo.ads.web2.checkout.model.Checkout;
import br.edu.ifspcjo.ads.web2.checkout.model.CieloOperator;
import br.edu.ifspcjo.ads.web2.checkout.model.EpsonPrinter;
import br.edu.ifspcjo.ads.web2.checkout.model.Operator;
import br.edu.ifspcjo.ads.web2.checkout.model.ReadCardOperator;
import br.edu.ifspcjo.ads.web2.checkout.model.XingLingPrinter;
import br.edu.ifspcjo.ads.web2.checkout.model.Printer;
//import javafx.print.Printer;

public class App {
    public static void main(String[] args) throws Exception {
        Operator operator = new ReadCardOperator();
        Printer printer = new XingLingPrinter();
        Card card = new Card("juliana", "5678.5678");

        Buy buy = new Buy("juliana", 400, "Hamburger especial");
        Checkout checkout = new Checkout(printer, operator);
        checkout.closeBuy(buy, card);   
    }
}
