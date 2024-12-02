package openAPI.naver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import javax.swing.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaverBookSearch {
    public List<Map<String, Object>> searchBooks(String query) {
        List<Map<String,Object>> list = null;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://openapi.naver.com/v1/search/book.json"+"?query="+query)
                .addHeader("X-Naver-Client-Id", "cXo0_LIWIljK5FqlP24I")
                .addHeader("X-Naver-Client-Secret", "Dde77rglEu")
                .build();
        try(Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String json = response.body().string();
                Gson gson = new Gson();
                //JSON응답에서 items 배열만 추출하여 List<Map<String,Object>>형태로 변환
                Type listType = new TypeToken<List<HashMap<String,Object>>>(){}.getType();
                Map<String,Object> resultMap = gson.fromJson(json, Map.class);
                list = gson.fromJson(gson.toJson(resultMap.get("items")), listType);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static void main(String[] args) {
        NaverBookSearch nbs = new NaverBookSearch();
        String query = "java";
        query = JOptionPane.showInputDialog("Insert Book Name");
        List<Map<String, Object>> result = nbs.searchBooks(query);
        System.out.println(result);
    }
}
