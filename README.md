# 网络连接框架——Retrofit

> 参考视频：<https://www.bilibili.com/video/BV19J411p7pY?p=1>
>
> 参考网址：<https://www.sunofbeach.net/a/1202592838370578432>
>
> Android网络编程后台程序：<https://github.com/TrillGates/SOBAndroidMiniWeb
>
> 依赖：<https://github.com/square/retrofit>
>
> 不同依赖版本：<https://github.com/square/retrofit/releases

**Android案例：`RetrofitDemo`**

Retrofit注解：

![图片描述](https://imgs.sunofbeaches.com/group1/M00/00/0C/rBsADV3xAMuAcjC2AAE3pqYX9Es260.png)

## 发起get请求

1. 创建API接口

API接口使用了注释的方式，具体注释看上方Retrofit注解

```java
public interface SOBAPI {

    @GET("/get/text")
    Call<ResponseBody> getJson();
}
```

2. 在主活动中Build出Retrofit实体

```java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:9102")
                .build();
```

注意这里的url是基本的URL不是全部

3. 通过实体create出之前写的API接口

```java
SOBAPI sobapi = retrofit.create(SOBAPI.class);
```

4. 获得请求任务(调用接口中的方法)

```java
Call<ResponseBody> task = sobapi.getJson();
```

5. 执行任务(同步/异步)——方法和OkHttp类似

```java
task.enqueue(new Callback<ResponseBody>() {
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        Log.d(TAG, "onResponse...");
        int code = response.code();
        Log.d(TAG, "onResponse --> code --> "+code);
        if (code == HttpURLConnection.HTTP_OK) {
            try {
                String body = response.body().string();
                Log.d(TAG, "onResponse --> body --> "+body);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Log.d(TAG, "onFailure...");
    }
});
```

6. 最后不要忘了权限问题

:bomb:注意：这个需要`java8`以上的版本，不是，则需要在`gradle`中的android里加上

```xml
compileOptions {
sourceCompatibility 1.8
targetCompatibility 1.8
}
```

## 使用转换器快速转换不同格式

> 依赖：https://github.com/square/retrofit

这里使用的是 `implementation 'com.squareup.retrofit2:converter-gson:2.7.0'`

有了这个之后就不再需要GSON来转换了

API的返回值直接改为最终的实体类,而不再是ResponseBody

```java
@GET("/get/text")
Call<JsonResult> getJson();
```

然后在主活动中获取的时候也是直接获取的对象类

```java
Call<JsonResult> task = sobapi.getJson();
```

这样请求成功后response.body()就直接是`JsonResult`对象

```java
JsonResult body = response.body();
loadToView(body);
```

## get的带参请求

**通过Query传参**

- **API接口**

```java
@GET("/get/param")
Call<getWithParamResult> getWithParam(@Query("keyword")String keyword,@Query("page")int page,@Query("order")String order);
```

其它地方一样

**通过`QueryMap`传参**

- **API接口**

```java
@GET("/get/param")
Call<getWithParamResult> getWithParam(@QueryMap Map<String,Object> params);
```

使用接口的时候只需传入map即可，不需要再每个参数依次传入

```java
Map<String,Object> map = new HashMap<>();
map.put("keyword","我是关键字。。");
map.put("page",11);
map.put("order",0);
Call<getWithParamResult> task = sobapi.getWithParam(map);
```

## post请求

将GET改为POST，其它不变

```java
@POST("/post/string")
Call<postWithParamResult> postWithParam(@Query("string") String str);
```

```java
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
```



- 通过URL请求

```java
@POST
Call<postWithParamResult> postWithUrl(@Url String url);
```

使用的时候：

```java
Call<postWithParamResult> task = sobapi.postWithUrl("/post/string?string=内容测试内容");
```

