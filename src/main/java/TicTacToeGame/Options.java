package TicTacToeGame;

public enum Options {
    X("X"),
    O("O"),
    EMPTY(" ");

    private final String meaning;

    Options(String meaning) {
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

    @Override
    public String toString() {
        return meaning;
    }
}
