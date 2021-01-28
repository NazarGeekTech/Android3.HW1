package com.example.android3lesson.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.example.android3lesson.R;
import com.example.android3lesson.data.Card;

public class MainActivity extends AppCompatActivity implements  EmojiAdapter.Listener{

    private EmojiAdapter adapter;
    private EmogiGame game;
    private RecyclerView recyclerView;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_cards);
        game = new EmogiGame();
        adapter = new EmojiAdapter(game, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void cardClick(Card<String> card) {
        game.choose(card);
        adapter.notifyDataSetChanged();

    }
}