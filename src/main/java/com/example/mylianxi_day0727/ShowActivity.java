package com.example.mylianxi_day0727;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class ShowActivity extends AppCompatActivity {

    private WebView webview;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //获取资源ID
        webview =findViewById(R.id.webview);
        String ss = getIntent().getStringExtra("s");
        webview.loadUrl(ss);

        button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowActivity.this, CarActivity.class);
                startActivity(intent);
            }
        });
    }
}
