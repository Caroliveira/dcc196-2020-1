package br.ufjf.dcc196.caroliveira.filmes;

public class Movie {
    private String title;
    private String year;
    private String style;
    private String director;
    private Boolean watched;

    public Movie(String title, String year, String style, String director, Boolean watched) {
        this.title = title;
        this.year = year;
        this.style = style;
        this.director = director;
        this.watched = watched;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }
}
