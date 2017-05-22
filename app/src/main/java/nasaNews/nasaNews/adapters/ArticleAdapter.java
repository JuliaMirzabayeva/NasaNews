package nasaNews.nasaNews.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nasaNews.nasaNews.data.dto.NasaArticleDTO;
import nasaNews.nasaNews.R;


/**
 * Created by Julia on 22.05.2017.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolders> {
    private List<NasaArticleDTO> articleDTOList;

    public ArticleAdapter(List<NasaArticleDTO> articleDTOList) {
        this.articleDTOList = articleDTOList;
    }

    @Override
    public ArticleAdapter.ArticleViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nasa_news_item, null);
        return new ArticleViewHolders(layoutView);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolders holder, int position) {
        holder.news.setText(articleDTOList.get(position).getTitle());
        holder.author.setText(articleDTOList.get(position).getCopyright());
    }

    @Override
    public int getItemCount() {
        return this.articleDTOList.size();
    }

    public class ArticleViewHolders extends RecyclerView.ViewHolder  {

        public TextView news;
        public TextView author;

        public ArticleViewHolders(View itemView) {
            super(itemView);
            news = (TextView) itemView.findViewById(R.id.news);
            author = (TextView) itemView.findViewById(R.id.author);
        }

    }
}

