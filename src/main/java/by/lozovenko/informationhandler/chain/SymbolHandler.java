package by.lozovenko.informationhandler.chain;

import by.lozovenko.informationhandler.composite.LeafSymbol;
import by.lozovenko.informationhandler.composite.SymbolType;
import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;

public class SymbolHandler extends AbstractHandler {

    @Override
    public void handleRequest(TextComposite composite, String text) {
        char[] chars = text.toCharArray();
        for (char symbolChar : chars) {
            SymbolType symbolType = SymbolType.LETTER;
            if (Character.isDigit(symbolChar)) {
                symbolType = SymbolType.DIGIT;
            }
            LeafSymbol symbol = new LeafSymbol(symbolChar, TextComponentType.SYMBOL, symbolType);
            composite.add(symbol);
        }
    }
}
