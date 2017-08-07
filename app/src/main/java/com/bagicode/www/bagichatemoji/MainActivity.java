package com.bagicode.www.bagichatemoji;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;

public class MainActivity extends AppCompatActivity {

    EmojiconEditText emojiconEditText;
    ImageView emojiImageView;
    ImageView submitButton;

    EmojIconActions emojIcon;
    private static final String TAG = MainActivity.class.getSimpleName();
    View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.root_view);
        emojiconEditText = (EmojiconEditText) findViewById(R.id.emojicon_edit_text);
        submitButton = (ImageView) findViewById(R.id.submit_btn);
        emojiImageView = (ImageView) findViewById(R.id.emoji_btn);

        emojIcon = new EmojIconActions(this, rootView, emojiconEditText, emojiImageView);
        emojIcon.ShowEmojIcon();
        emojIcon.setIconsIds(R.drawable.ic_action_keyboard, R.drawable.smiley);
        emojIcon.setKeyboardListener(new EmojIconActions.KeyboardListener() {
            @Override
            public void onKeyboardOpen() {
                Log.e(TAG, "Keyboard opened!");
            }

            @Override
            public void onKeyboardClose() {
                Log.e(TAG, "Keyboard closed");
            }
        });
    }
}
