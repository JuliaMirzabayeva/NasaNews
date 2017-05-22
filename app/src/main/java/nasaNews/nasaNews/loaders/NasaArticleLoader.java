package nasaNews.nasaNews.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.IOException;

import nasaNews.nasaNews.data.RestServiceProvider;
import nasaNews.nasaNews.data.dto.NasaArticleDTO;

/**
 * Created by Julia on 22.05.2017.
 */

public class NasaArticleLoader extends AsyncTaskLoader<NasaArticleDTO> {

    public NasaArticleLoader(Context context) {
        super(context);
    }

    @Override
    public NasaArticleDTO loadInBackground() {
        try {
            return RestServiceProvider.getInstance().getNasaArticle();
        } catch (IOException e) {
            NasaArticleDTO nasaArticleDTO = new NasaArticleDTO();
            nasaArticleDTO.setHasError(true);
            return nasaArticleDTO;
        }
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
