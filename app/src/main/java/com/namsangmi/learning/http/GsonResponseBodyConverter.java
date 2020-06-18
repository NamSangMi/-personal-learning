package com.namsangmi.learning.http;

import android.util.Log;

import com.google.gson.Gson;
import com.namsangmi.learning.BuildConfig;
import com.namsangmi.learning.http.bean.ResultBean;
import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 自定义Gson 解析,方便于统一处理服务端的错误
 */

public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        try {
            //ResultResponse 只解析result字段
            ResultBean resultResponse = gson.fromJson(response, ResultBean.class);
            if (resultResponse.getCode() == 0) {
                //result==0表示成功返回，继续用本来的Model类解析
                return gson.fromJson(response, type);
            } else {
                //ErrResponse 将msg解析为异常消息文本
                throw new ResultException(resultResponse.getCode(), resultResponse.getMsg());
            }
        } finally {
            if (BuildConfig.DEBUG){
                Log.d("convert", response);
            }
        }
    }
}
