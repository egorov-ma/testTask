package test_data;

public enum Links {
    YANDEX_MAIN_PAGE("https://ya.ru/");

    private final String url;

    Links(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
