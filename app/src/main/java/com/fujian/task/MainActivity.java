package com.fujian.task;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.fujian.task.model.FeedItem;
import com.fujian.task.service.AbstractedService;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        new JSONTask().execute();
    }

    public class JSONTask extends AsyncTask<Void,Void, List<FeedItem> >{

        @Override
        protected List<FeedItem> doInBackground(Void... voids) {
            AbstractedService service = new AbstractedService();
            List<FeedItem> feedItemList = new ArrayList<>();
            try {
                feedItemList = service.parserJsonToFeedItem(service.getFeed()); //parsing JSON file
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return feedItemList;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Parsing");
        }

        @Override
        protected void onPostExecute(List<FeedItem> feedItems) {
            super.onPostExecute(feedItems);
            textView.setText("The json has been parsed, we got "+ feedItems.size()+" FeedItem.");
        }
    }
}
