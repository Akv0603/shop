package ru.akv.rest.shop.exceptions;

public class ShowcaseNotFoundException extends RuntimeException {

    public ShowcaseNotFoundException(Integer showcaseId){
        super(String.format("Витрина по id %d отсутствует", showcaseId));
    }
}
