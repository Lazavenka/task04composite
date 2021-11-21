package by.lozovenko.informationhandler.composite;

public enum TextComponentType {
    TEXT("", ""),
    PARAGRAPH("    ", "\n"),
    SENTENCE("", ""),
    LEXEME("", " "),
    WORD("", ""),
    SYMBOL("", "");
    private final String prefix;
    private final String postfix;

    TextComponentType(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getPostfix() {
        return postfix;
    }
}
