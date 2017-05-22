package nasaNews.nasaNews.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import nasaNews.nasaNews.data.dto.NasaArticleDTO;

/**
 * Created by Julia on 22.05.2017.
 */

public interface RetrofitInterface {

    @GET
    Call<NasaArticleDTO> getNasaArticle(@Url String url);
}
