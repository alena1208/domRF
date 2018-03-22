package enums;

public enum MainPageMenuItemsEnums {

    DEYATELNOST("деятельность"),
    RAZVITIE("развитие"),
    MEDIA("медиа"),
    ABOUT_COMPANY("о компании"),
    INVESTORS("инвесторам"),
    CARIER("карьера"),
    CONTACTS("контакты");

    public String text;

    MainPageMenuItemsEnums(String text) {
        this.text = text;
    }
}
