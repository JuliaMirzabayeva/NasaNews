package nasaNews.nasaNews.data.dto;

/**
 * Created by Julia on 22.05.2017.
 */

public class NasaArticleDTO {
    private String copyright;
    private String title;
    private boolean isHasError;

    public NasaArticleDTO() {

    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHasError() {
        return isHasError;
    }

    public void setHasError(boolean hasError) {
        isHasError = hasError;
    }
}
