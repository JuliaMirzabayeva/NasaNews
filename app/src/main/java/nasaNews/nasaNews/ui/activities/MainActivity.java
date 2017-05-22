package nasaNews.nasaNews.ui.activities;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import nasaNews.nasaNews.adapters.ArticleAdapter;
import nasaNews.nasaNews.data.dto.NasaArticleDTO;
import nasaNews.nasaNews.loaders.NasaArticleLoader;
import nasaNews.nasaNews.R;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<NasaArticleDTO>{

    private final static int LOADER_ARTICLE_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(LOADER_ARTICLE_ID, null, this);
    }

    @Override
    public Loader<NasaArticleDTO> onCreateLoader(int id, Bundle args) {
        if(id == LOADER_ARTICLE_ID){
            return new NasaArticleLoader(this);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<NasaArticleDTO> loader, NasaArticleDTO data) {
        if(loader.getId() == LOADER_ARTICLE_ID){
            if(!data.isHasError()) {
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_list);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                List<NasaArticleDTO> nasaArticleDTOs = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    nasaArticleDTOs.add(data);
                }
                recyclerView.setAdapter(new ArticleAdapter(nasaArticleDTOs));
            }
        }
        ProgressBar pb = (ProgressBar) findViewById(R.id.pbHeaderProgress);
        pb.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(Loader<NasaArticleDTO> loader) {

    }
}
