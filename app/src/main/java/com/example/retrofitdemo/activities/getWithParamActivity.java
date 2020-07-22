package com.example.retrofitdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.retrofitdemo.API.SOBAPI;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.domain.getWithParamResult;
import com.example.retrofitdemo.domain.postWithParamResult;
import com.example.retrofitdemo.utils.RetrofitManager;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class getWithParamActivity extends AppCompatActivity {

    private static final String TAG = "getWithParamActivity";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_with_param);
        button = findViewById(R.id.get_with_param);
    }

    /**
     * 使用Query，带参get请求
     * @param view
     */
    public void getWithParam(View view){

        Retrofit retrofit = RetrofitManager.getRetrofit();

        SOBAPI sobapi = retrofit.create(SOBAPI.class);

        Call<getWithParamResult> task = sobapi.getWithParam("我是关键字。。",10,"1");

        task.enqueue(new Callback<getWithParamResult>() {
            @Override
            public void onResponse(Call<getWithParamResult> call, Response<getWithParamResult> response) {
                Log.d(TAG, "onResponse...");
                int code = response.code();
                Log.d(TAG, "onResponse --> code --> "+code);
                if (code == HttpURLConnection.HTTP_OK) {
                    getWithParamResult result = response.body();
                    Log.d(TAG, "onResponse --> result -->"+result);
                }
            }

            @Override
            public void onFailure(Call<getWithParamResult> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.toString());
            }
        });
    }

    /**
     * 使用QueryMap，带参get请求
     * @param view
     */
    public void getWithParamQueryMap(View view){

        Retrofit retrofit = RetrofitManager.getRetrofit();

        SOBAPI sobapi = retrofit.create(SOBAPI.class);

        Map<String,Object> map = new HashMap<>();
        map.put("keyword","我是关键字。。");
        map.put("page",11);
        map.put("order",0);
        Call<getWithParamResult> task = sobapi.getWithParam(map);

        task.enqueue(new Callback<getWithParamResult>() {
            @Override
            public void onResponse(Call<getWithParamResult> call, Response<getWithParamResult> response) {
                Log.d(TAG, "onResponse...");
                int code = response.code();
                Log.d(TAG, "onResponse --> code --> "+code);
                if (code == HttpURLConnection.HTTP_OK) {
                    getWithParamResult result = response.body();
                    Log.d(TAG, "onResponse --> result -->"+result);
                }
            }

            @Override
            public void onFailure(Call<getWithParamResult> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.toString());
            }
        });


    }

    /**
     * post请求
     * @param view
     */
    public void postWithParam(View view){

        Retrofit retrofit = RetrofitManager.getRetrofit();

        SOBAPI sobapi = retrofit.create(SOBAPI.class);

        Call<postWithParamResult> task = sobapi.postWithParam("我是提交的内容");

        task.enqueue(new Callback<postWithParamResult>() {
            @Override
            public void onResponse(Call<postWithParamResult> call, Response<postWithParamResult> response) {
                Log.d(TAG, "onResponse...");
                int code = response.code();
                Log.d(TAG, "onResponse --> code --> "+code);
                if (code == HttpURLConnection.HTTP_OK) {
                    postWithParamResult result = response.body();
                    Log.d(TAG, "onResponse --> result -->"+result);
                }
            }

            @Override
            public void onFailure(Call<postWithParamResult> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.toString());
            }
        });
    }

    /**
     * 通过Url请求
     * @param view
     */
    public void postWithUrl(View view){
        Retrofit retrofit = RetrofitManager.getRetrofit();

        SOBAPI sobapi = retrofit.create(SOBAPI.class);

        Call<postWithParamResult> task = sobapi.postWithUrl("/post/string?string=内容测试内容");

        task.enqueue(new Callback<postWithParamResult>() {
            @Override
            public void onResponse(Call<postWithParamResult> call, Response<postWithParamResult> response) {
                Log.d(TAG, "onResponse...");
                int code = response.code();
                Log.d(TAG, "onResponse --> code --> "+code);
                if (code == HttpURLConnection.HTTP_OK) {
                    postWithParamResult result = response.body();
                    Log.d(TAG, "onResponse --> result -->"+result);
                }
            }

            @Override
            public void onFailure(Call<postWithParamResult> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.toString());
            }
        });
    }
}
