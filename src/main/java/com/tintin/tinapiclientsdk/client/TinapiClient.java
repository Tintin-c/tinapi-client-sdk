package com.tintin.tinapiclientsdk.client;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.tintin.tinapiclientsdk.model.User;
import com.tintin.tinapiclientsdk.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

public class TinapiClient {

    String accessKey;
    String secreatKey;

    private static final String GATEWAY_HOST = "http://localhost:8090";

    public TinapiClient(String accessKey, String secreatKey) {
        this.accessKey = accessKey;
        this.secreatKey = secreatKey;
    }

    public String getName(String name){
        String result = HttpUtil.get(GATEWAY_HOST + "/name/");
        System.out.println(result);
        return result;
    }

    public String postName(String name){
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", name);
        String result = HttpUtil.post(GATEWAY_HOST + "/name/", hashMap);
        System.out.println(result);
        return result;
    }

    public String postUsername(User user){
        String json = JSONUtil.toJsonStr(user);
        String result2 = HttpRequest.post(GATEWAY_HOST + "/name/user")
                    .body(json)
                .addHeaders(getHeaderMap(json))
                .execute().body();
        System.out.println(result2);
        return result2;
    }

    public Map<String, String> getHeaderMap(String body){
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        hashMap.put("body", body);
        hashMap.put("sign", SignUtils.getSign(body, secreatKey));

        return hashMap;
    }
    

}
