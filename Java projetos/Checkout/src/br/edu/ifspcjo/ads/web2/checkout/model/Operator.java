package br.edu.ifspcjo.ads.web2.checkout.model;

public interface Operator {

    boolean authorize(Authorizable authorizable, Card card);

}
