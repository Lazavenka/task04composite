package by.lozovenko.informationhandler.composite;

import java.util.List;

public interface TextComponent {
    String compose();

    TextComponent copyTextComponent();

    boolean add(TextComponent component);

    boolean remove(TextComponent component);

    TextComponentType getComponentType();

    List<TextComponent> getChildren();
}
