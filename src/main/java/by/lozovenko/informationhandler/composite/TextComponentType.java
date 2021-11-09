package by.lozovenko.informationhandler.composite;

public enum TextComponentType {
    TEXT("\n"),
    PARAGRAPH("\n\t"),
    SENTENCE(""),
    LEXEME(" "),
    WORD(""),
    SYMBOL("");
    private final String postfix;

    TextComponentType(String postfix){
        this.postfix = postfix;
    }

    public String getPostfix() {
        return postfix;
    }
}
