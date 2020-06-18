package com.namsangmi.learning.http;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.namsangmi.learning.http.interceptor.CacheInterceptor;
import com.namsangmi.learning.utils.Tools;

import org.json.JSONException;
import org.reactivestreams.Subscriber;

import java.net.ConnectException;
import retrofit2.HttpException;

/**
 * 处理请求回调公共方法，该方法将用于之后所有的json请求回调
 */

public abstract class AbsAPICallback<T> implements Subscriber<T> {
    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;
    //出错提示
    private final String networkMsg;
    private final String parseMsg;
    private final String permissionMsg;

    protected AbsAPICallback() {
        this.networkMsg = "当前连接服务器异常，请稍后重试…";
        this.parseMsg = "服务器似乎遇到了问题，请稍后再试。";
        this.permissionMsg = "未登录或登录失效";
    }

    protected AbsAPICallback(String networkMsg, String parseMsg) {
        this.networkMsg = networkMsg;
        this.parseMsg = parseMsg;
        this.permissionMsg = "未登录或登录失效";
    }

    protected AbsAPICallback(String networkMsg, String parseMsg, String permissionMsg) {
        this.networkMsg = networkMsg;
        this.parseMsg = parseMsg;
        this.permissionMsg = permissionMsg;
    }


    @Override
    public void onError(Throwable e) {
        Throwable throwable = e;
        //获取最根源的异常
        while (throwable.getCause() != null) {
            e = throwable;
            throwable = throwable.getCause();
        }
        if (!Tools.isNetworkConnected()) {
            onError("网络连接失败，请检查网络...");
        } else if (e instanceof HttpException) {             //HTTP错误
            HttpException httpException = (HttpException) e;
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                    onError(permissionMsg);
                    break;
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    //均视为网络错误
                    onError(networkMsg);
                    break;
            }
        } else if (e instanceof ResultException) {    //服务器返回的错误
            ResultException resultException = (ResultException) e;
            String errorMsg = resultException.getMessage();
            if (errorMsg == null || errorMsg.isEmpty()) {
                errorMsg = "未知错误";
            }
            onError(errorMsg);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            //均视为解析错误  均报错服务器错误
            onError(parseMsg);
        } else {
            if (e instanceof ConnectException) {
                onError("网络异常，请检测网络设置");
            } else {
                //未知错误
                onError(e.getMessage());
            }
        }

    }

    /**
     * 下面三种错误统一处理
     */
    protected abstract void onError(String message);




    public interface Permission {
        void doNext();
    }

}
