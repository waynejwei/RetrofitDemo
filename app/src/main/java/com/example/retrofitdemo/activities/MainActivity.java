package com.example.retrofitdemo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.retrofitdemo.API.SOBAPI;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.adapters.JsonResultAdapter;
import com.example.retrofitdemo.domain.JsonResult;
import com.example.retrofitdemo.utils.RetrofitManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button button;

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private JsonResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.get_request);
        initView();
    }

    /**
     * 加载RecyclerView布局
     */
    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //分割线
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.bottom = 5;
                outRect.top = 5;
            }
        });
        adapter = new JsonResultAdapter();
        recyclerView.setAdapter(adapter);
    }

    public void getRequest(View view){

        Retrofit retrofit = new RetrofitManager().getRetrofit();

        SOBAPI sobapi = retrofit.create(SOBAPI.class);
        Call<JsonResult> task = sobapi.getJson();

        task.enqueue(new Callback<JsonResult>() {
            @Override
            public void onResponse(Call<JsonResult> call, Response<JsonResult> response) {
                Log.d(TAG, "onResponse...");
                int code = response.code();
                Log.d(TAG, "onResponse --> code --> "+code);
                if (code == HttpURLConnection.HTTP_OK) {
//                    try {
//                        String body = response.body().string();
//                        Log.d(TAG, "onResponse --> body --> "+body);
//                        Gson gson = new Gson();
//                        JsonResult jsonResult = gson.fromJson(body,JsonResult.class);
//                        loadToView(jsonResult);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                    JsonResult body = response.body();
                    loadToView(body);
                }
            }

            @Override
            public void onFailure(Call<JsonResult> call, Throwable t) {
                Log.d(TAG, "onFailure...");
            }
        });
    }

    /**
     * 将JsonResult对象显示到view中
     * @param jsonResult
     */
    private void loadToView(JsonResult jsonResult) {
        adapter.setData(jsonResult);
    }
}
