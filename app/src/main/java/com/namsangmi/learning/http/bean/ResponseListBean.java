package com.namsangmi.learning.http.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 列表响应类
 */

public class ResponseListBean<T> implements Serializable {

    /**
     * result : [{"brief":"qqqq","ext":{},"thumb":"http://img.qi1game.com/mg_group/869af2d1059d4aa48eb67f990825feb0.jpg@220w_220h","resType":103,"link":"xbmg://parentclass/series?orid=qqqq","vprice":1,"orid":"qqqq","title":"qqqq","url":"http://mgxbvideo-in.oss-cn-hangzhou.aliyuncs.com/e47b9e07808a407eaee5500f2796df56.mp4","authorTitle":"台湾著名育儿专家","modifyTime":1479994385000,"maxAge":1,"authorName":"花婆婆","detailImg":"http://img.qi1game.com/classroom_carouse/095dc49733bb4f50a97f159b6b9bcce3.jpg, http://img.qi1game.com/classroom_carouse/6d1c9735289e4a629f915677ab1dce23.jpg","price":1,"minAge":1,"clickNum":0,"tag":"1","vipFlag":0},{"brief":"动物世界","ext":{},"thumb":"http://img.qi1game.com/mg_group/a2f99a911c70474cb086451fa749d0c6.jpg@220w_220h","resType":103,"link":"xbmg://parentclass/series?orid=979addc1fd7d45a28c09bcfb24c9b9c1","vprice":1000,"orid":"979addc1fd7d45a28c09bcfb24c9b9c1","title":"专辑001","authorTitle":"通过Excel导入的新人，还没有实质性的介绍~","modifyTime":1479977983000,"maxAge":6,"authorName":"星小宝","price":2000,"minAge":1,"clickNum":5,"tag":"儿童","vipFlag":0}]
     * resultCode : 0
     * resultMsg : 操作成功！
     */
    @SerializedName("data")
    private List<T> data;
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
