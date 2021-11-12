package by.lozovenko.informationhandler.composite;

import java.util.List;

public class LeafSymbol implements TextComponent{
    private SymbolType symbolType;
    private TextComponentType componentType;
    private char symbol;
    public LeafSymbol(char symbol, TextComponentType componentType, SymbolType symbolType){
        this.symbol = symbol;
        this.componentType = componentType;
        this.symbolType = symbolType;

    }
    @Override
    public String compose() {
        return String.valueOf(symbol + " '" + symbolType + "' "); //TODO return String.valueOf(symbol);
    }

    @Override
    public boolean add(TextComponent component) {
        throw new UnsupportedOperationException("Can't add component to leaf element!");
    }

    @Override
    public boolean remove(TextComponent component) {
        throw new UnsupportedOperationException("Can't remove component from leaf element!");
    }

    @Override
    public TextComponentType getComponentType() {
        return null;
    }

    @Override
    public List<TextComponent> getChildren() {
        throw new UnsupportedOperationException("Can't return children from leaf element!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeafSymbol that = (LeafSymbol) o;

        if (symbol != that.symbol) return false;
        if (symbolType != that.symbolType) return false;
        return componentType == that.componentType;
    }

    @Override
    public int hashCode() {
        int result = symbolType.hashCode();
        result = 31 * result + componentType.hashCode();
        result = 31 * result + symbol;
        return result;
    }
}
