package com.example.photosapp.asset;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;

import com.example.photosapp.Adapter.ArticleAdapter;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ArticleData extends AsyncTask<String, String, String> {
    private Context context;
    private GridView gridView;
    private static ArticleList data;

    public ArticleData(Context context, GridView gridView) {
        this.context = context;
        this.gridView = gridView;
    }

    public static Article getPhotoFromId(int id) {
        for(int i = 0; i < data.getArticles().size(); i++) {
            if(data.getArticles().get(i).getArticle_id() == id) {
                return data.getArticles().get(i);
            }
        }
        return null;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL("https://fontkeyboard.org/wsv/?json_name=articles");
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
            }
            return buffer.toString();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Gson gson = new Gson();
        data = gson.fromJson(s, ArticleList.class);
        ArticleAdapter adapter = new ArticleAdapter(data.getArticles(), context);
        gridView.setAdapter(adapter);
    }
}
