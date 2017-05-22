package nasaNews.nasaNews.data;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import nasaNews.nasaNews.data.dto.NasaArticleDTO;


/**
 * Created by Julia on 22.05.2017.
 */

public class RestServiceProvider {
    private static volatile RetrofitInterface service;
    private static volatile RestServiceProvider instance;

    public static RestServiceProvider getInstance() {
        RestServiceProvider restServiceProvider = instance;
        if (instance == null) {
            synchronized (RestServiceProvider.class) {
                restServiceProvider = instance;
                if (restServiceProvider == null) {
                    restServiceProvider = new RestServiceProvider();
                    instance = restServiceProvider;
                }
            }
        }

        return restServiceProvider;
    }

    private static RetrofitInterface getRetrofitInstance() {
        RetrofitInterface retrofitService = service;
        if (service == null) {
            synchronized (RetrofitInterface.class) {
                retrofitService = service;
                if (retrofitService == null) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.baseUrlPointer).addConverterFactory(JacksonConverterFactory.create(
                            objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT, JsonTypeInfo.As.PROPERTY))).build();
                    retrofitService = retrofit.create(RetrofitInterface.class);
                    service = retrofitService;
                }
            }
        }
        return retrofitService;
    }

    public NasaArticleDTO getNasaArticle() throws IOException {
        Call<NasaArticleDTO> call = getRetrofitInstance().getNasaArticle(Constants.urlPointer);
        Response<NasaArticleDTO> responseDTO = call.execute();
        if(responseDTO.isSuccessful()){
            return responseDTO.body();
        }
        else{
            NasaArticleDTO nasaArticleDTO = new NasaArticleDTO();
            nasaArticleDTO.setHasError(true);
            return nasaArticleDTO;
        }
    }
}
