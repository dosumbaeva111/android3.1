package kg.geektech.lvl5lesson1.data.models;

import com.google.gson.annotations.SerializedName;

public class Film {
    String id;
    String title;
    @SerializedName("original_title")
    String originalTitle;
    String description;
    @SerializedName("movie_banner")
    String movieBanner;
    String director;
    String producer;
    @SerializedName("release_date")
    String releaseDate;




    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMovieBanner() {
        return movieBanner;
    }

    public void setMovieBanner(String movieBanner) {
        this.movieBanner = movieBanner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
