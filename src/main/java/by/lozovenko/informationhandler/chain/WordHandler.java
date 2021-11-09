package by.lozovenko.informationhandler.chain;

import by.lozovenko.informationhandler.composite.TextComposite;

public class WordHandler extends AbstractHandler{
    private AbstractHandler successor = new SymbolHandler();
    @Override
    public void handleRequest(TextComposite composite, String text) {


        //TODO implement WordHandler! successor.handleRequest();
    }
}
