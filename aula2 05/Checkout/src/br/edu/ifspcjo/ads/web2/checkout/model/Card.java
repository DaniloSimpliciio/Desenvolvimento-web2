package br.edu.ifspcjo.ads.web2.checkout.model;

public class Card {

    private String titulrName;
    private String cardNumber;
    
    public Card(String titulrName, String cardNumber) {
        this.titulrName = titulrName;
        this.cardNumber = cardNumber;
    }

    public String getTitulrName() {
        return titulrName;
    }

    public void setTitulrName(String titulrName) {
        this.titulrName = titulrName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    
}
