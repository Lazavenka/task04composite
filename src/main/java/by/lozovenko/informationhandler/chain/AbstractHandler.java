package by.lozovenko.informationhandler.chain;

import by.lozovenko.informationhandler.composite.TextComposite;

public abstract class AbstractHandler {
    public abstract void handleRequest(TextComposite composite, String text);
}
