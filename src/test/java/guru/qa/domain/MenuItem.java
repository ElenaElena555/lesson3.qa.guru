package guru.qa.domain;

public enum MenuItem {
   BABY("Baby"), BOOKS("Books"), ALL("All Departments");
    public final String engName;

    MenuItem(String engName) {
        this.engName = engName;
    }
}
