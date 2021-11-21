package by.lozovenko.informationhandler.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private final TextComponentType type;
    private final List<TextComponent> components;

    public TextComposite(TextComponentType type) {
        this.type = type;
        this.components = new ArrayList<>();
    }

    @Override
    public String compose() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(type.getPrefix());
        components.forEach(component -> stringBuilder.append(component.compose()));
        stringBuilder.append(type.getPostfix());
        return stringBuilder.toString();
    }

    @Override
    public TextComponent copyTextComponent() {
        TextComponent copy = new TextComposite(this.type);
        this.components.forEach(child -> copy.add(child.copyTextComponent()));
        return copy;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (type != that.type) return false;
        return components.equals(that.components);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + components.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.compose();
    }
}
