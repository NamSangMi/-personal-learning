package com.namsangmi.learning.http;


import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 * 网络请求工具类封装
 */


/**
 * RxHttpUtils
 *         .getInstance()
 *         .addHeader(map)
 *         .createApi(ApiService.class)
 *         .getData()
 *         .subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
 *                 .observeOn(AndroidSchedulers.mainThread())
 *                 .subscribe(new Subscriber<ResultBean>() {
 *                     @Override
 *                     public void onCompleted() {
 *                     }
 *
 *                     @Override
 *                     public void onError(Throwable e) {
 *                       
 *                     }
 *
 *                     @Override
 *                     public void onNext(ResultBean rspBean) {
 *
 *                     }
 *                 });
 */

public class RxHttpUtils {

    private static Map<String, Object> mHeaderMaps = new TreeMap<>();

    private static class SingletonHolder {
        private static final RxHttpUtils INSTANCE = new RxHttpUtils();
    }

    public RxHttpUtils() {
        mHeaderMaps.clear();
    }

    public static RxHttpUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <K> K createApi(final Class<K> cls) {
        return RetrofitClient.getInstance(mHeaderMaps).create(cls);
    }

    public synchronized RxHttpUtils addHeader(Map<String, Object> headerMaps) {
        mHeaderMaps = headerMaps;
        return this;
    }

}
