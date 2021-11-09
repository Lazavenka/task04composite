package by.lozovenko.informationhandler.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent{
    private TextComponentType type;
    private List<TextComponent> components = new ArrayList<>();

    public TextComposite(TextComponentType type){
        this.type = type;
    }
    @Override
    public String compose(){
        StringBuilder stringBuilder = new StringBuilder();
        components.forEach(component -> stringBuilder.append(component.compose()));
        stringBuilder.append(type.getPostfix());
        return stringBuilder.toString();
    }
    @Override
    public boolean add(TextComponent component) {
        return components.add(component);
    }

    @Override
    public boolean remove(TextComponent component) {
        return components.remove(component);
    }

    @Override
    public TextComponentType getComponentType() {
        return this.type;
    }

    @Override
    public List<TextComponent> getChildren() {
        return components;
    }
}
