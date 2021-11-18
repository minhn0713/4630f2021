package com.example.new_world;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.CategoryClickedInterface{

    //create varialbes recycleview and progressbar
    private RecyclerView hotNews, allNews, regularNews, categoryRV;
    private ProgressBar loadingBar;
    private ArrayList<Articles> articlesArrayList;
    private ArrayList<CategoryTypes> categoryTypesArrayList;
    private CategoryAdapter categoryAdapter;
    private HotNewsAdapter hotNewsAdapter;
    private AllnewsAdapter allnewsAdapter;
    private RegularNewsAdapter regularNewsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hotNews = findViewById(R.id.main_hot_news_RV);
        allNews = findViewById(R.id.main_all_news_RV);
        regularNews = findViewById(R.id.main_regular_news_RV);
        loadingBar =findViewById(R.id.idLoadingBar);

        //implement arrayList
        articlesArrayList = new ArrayList<>();
        categoryTypesArrayList = new ArrayList<>();

        //adapter
        hotNewsAdapter = new HotNewsAdapter(articlesArrayList, this);
        allnewsAdapter = new AllnewsAdapter(articlesArrayList,this);
        regularNewsAdapter = new RegularNewsAdapter(articlesArrayList,this);
        categoryAdapter = new CategoryAdapter(categoryTypesArrayList,this,this::onCategoryClickLister);

        //set adapter to recycleView
        hotNews.setLayoutManager(new LinearLayoutManager(this));
        hotNews.setAdapter(hotNewsAdapter);
        allNews.setLayoutManager(new LinearLayoutManager(this));
        allNews.setAdapter(allnewsAdapter);
        regularNews.setLayoutManager(new LinearLayoutManager(this));
        regularNews.setAdapter(regularNewsAdapter);

        categoryRV.setAdapter(categoryAdapter);
        getCategories();
        getNews("All");
        regularNewsAdapter.notifyDataSetChanged();

    }

    private void getCategories(){
//
        categoryTypesArrayList.add(new CategoryTypes("All","https://media.istockphoto.com/photos/television-streaming-multimedia-wall-concept-picture-id1287677376?b=1&k=20&m=1287677376&s=170667a&w=0&h=wvu0lKn4WbfHtKId83KzrHvGmBP7zn7ZwGEWmU99HWE="));
        categoryTypesArrayList.add(new CategoryTypes("Technology","https://media.istockphoto.com/photos/abstract-science-circle-global-network-connection-in-hands-on-sunset-picture-id672310452?b=1&k=20&m=672310452&s=170667a&w=0&h=IxGtS_G2_-b4bbpn_9llft2UslYFJMfT-cPZzdzy8Mk="));
        categoryTypesArrayList.add(new CategoryTypes("Science","https://media.istockphoto.com/photos/female-chemist-at-work-in-laboratory-picture-id637785818?b=1&k=20&m=637785818&s=170667a&w=0&h=BFOAFUMdVxMWc-a3w-m_00djwLalBINEHGNHToflXMM="));
        categoryTypesArrayList.add(new CategoryTypes("Sports","https://media.istockphoto.com/photos/various-sport-equipments-on-grass-picture-id949190736?b=1&k=20&m=949190736&s=170667a&w=0&h=f3ofVqhbmg2XSVOa3dqmvGtHc4VLA_rtbboRGaC8eNo="));
        categoryTypesArrayList.add(new CategoryTypes("General","https://images.unsplash.com/photo-1432821596592-e2c18b78144f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjB8fGdlbmVyYWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"));
        categoryTypesArrayList.add(new CategoryTypes("Business","https://media.istockphoto.com/photos/businessman-receive-counseling-from-colleague-it-is-a-picture-of-the-picture-id1271491361?b=1&k=20&m=1271491361&s=170667a&w=0&h=h3GU6-TmUtsqOfqoVpgYpxt3rO-Rx66kWLCOpymW5wI="));
        categoryTypesArrayList.add(new CategoryTypes("Entertainment","https://media.istockphoto.com/photos/the-best-fans-a-band-could-want-picture-id502131959?b=1&k=20&m=502131959&s=170667a&w=0&h=8efBzeqguArASWGYfWhK5EdgNIJvZm-nvZ42i9DsS1A="));
        categoryTypesArrayList.add(new CategoryTypes("Health","https://media.istockphoto.com/photos/exercising-and-healthy-food-raibow-colored-fruits-vegetables-and-picture-id1276373624?b=1&k=20&m=1276373624&s=170667a&w=0&h=Zq8zG8hV2xmgILYtEzgES-w4Glu7vgWYhq9HttgF5ew="));
        //Step39: after link the imageUrl with adapter, we need to notify the adapter that the data inside the arrayList has been channged

        categoryAdapter.notifyDataSetChanged();
        //Here
    }

    //Get news method
    private void getNews(String category){
        loadingBar.setVisibility(View.VISIBLE);
        articlesArrayList.clear();
        String categoryURL = "https://newsapi.org/v2/top-headlines?country=us&category="+category+"&apiKey=77bab70f038d411583882e4711138d78";
        String regular_news_url = "https://newsapi.org/v2/top-headlines?country=us&excludeDomain=stackoverflow.com&sortBy=publishedAt&language=en&apikey=77bab70f038d411583882e4711138d78";
        String hot_news_url ="https://newsapi.org/v2/top-headlines?country=us&apiKey=77bab70f038d411583882e4711138d78";
        String all_news_url ="https://newsapi.org/v2/everything?q=apple&from=2021-11-16&sortBy=popularity&apiKey=77bab70f038d411583882e4711138d78&language=en";
        String Base_URL = "https://newsapi.org/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Step47: create Retrofit API class
        API retrofitAPI = retrofit.create(API.class);
        Call<Model> call;

        if(category.equals("All")){
            call = retrofitAPI.getRegularNews(regular_news_url);
          //  call = retrofitAPI.getHotNews(hot_news_url);
          //  call = retrofitAPI.getAllNews(all_news_url);
        }else{
            call = retrofitAPI.getCategoryNews(categoryURL);
        }

        //Use call-back to enqueue the method
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Model model = response.body();
                loadingBar.setVisibility(View.GONE);
                ArrayList<Articles> articles = model.getArticles();
                for(int i=0; i<articles.size();i++){
                    articlesArrayList.add(new Articles(articles.get(i).getTitle(),articles.get(i).getDescription(),articles.get(i).getUrlToImage(),
                            articles.get(i).getUrl(),articles.get(i).getContent()));
                }
                //notify adapter
                regularNewsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error to get Data", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onCategoryClickLister(int position) {
        String category = categoryTypesArrayList.get(position).getCategory();
        getNews(category);
    }
}