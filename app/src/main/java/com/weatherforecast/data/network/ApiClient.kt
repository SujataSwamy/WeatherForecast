package com.weatherforecast.data.network

import com.weatherforecast.domain.Constants.Companion.DEFAULT_CONNECT_TIMEOUT_IN_MS
import com.weatherforecast.domain.Constants.Companion.DEFAULT_READ_TIMEOUT_IN_MS
import com.weatherforecast.domain.Constants.Companion.DEFAULT_WRITE_TIMEOUT_IN_MS
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object ApiClient {

    private var retrofit:  Retrofit? = null

    /**
     * Returns the object for API handles classes with retrofit client.
     *
     * @param apiServiceClass
     * @param <T>
     * @return
     </T> */
    fun <T> getAPIService(apiServiceClass: Class<T>?): T {




        return client!!.create(apiServiceClass)
    }

    /**
     * Binds and returns the retorfit client object. We declares global headers, logger and other
     * required interceptors.
     *
     * @return
     */
    public val client: Retrofit?
        public get() {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val oktHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
                .connectTimeout(
                    DEFAULT_CONNECT_TIMEOUT_IN_MS,
                    TimeUnit.MILLISECONDS
                )
                .writeTimeout(DEFAULT_WRITE_TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
            oktHttpClient.addInterceptor(logging)
            oktHttpClient.addInterceptor(
                object : Interceptor {
                    @Throws(IOException::class)
                    override fun intercept(chain: Interceptor.Chain): Response {
                        val original: Request = chain.request()
                        val request: Request = original.newBuilder()
                            .method(original.method(), original.body())
                            .build()
                        return chain.proceed(request)
                    }
                }
            )
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("http://newsapi.org/v2/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(oktHttpClient.build())
                    .build()
            }
            return retrofit
        }
}
