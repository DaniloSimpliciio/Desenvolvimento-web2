package br.edu.ifspcjo.ads.web2.checkout.model;

public class ReadCardOperator implements Operator {
    @Override
    public boolean authorize(Authorizable authorizable, Card card) {

        return card.getCardNumber().startsWith("5678")
         && authorizable.getTotal() < 1000;
    }

}
