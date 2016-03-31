package br.com.placesnap.controller.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.placesnap.R;

public class NewPostActivity extends AppCompatActivity {
    private TextView mTextViewInstruction;
    private EditText mEditTextDescription;
    private ImageView mImageViewPost;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        this.bindViews();
    }

    private void bindViews() {
        mTextViewInstruction = (TextView) findViewById(R.id.textview_new_post_instruction);
        mEditTextDescription = (EditText) findViewById(R.id.edittext_new_post_description);
        mImageViewPost = (ImageView) findViewById(R.id.imageview_new_post_image);
    }
}
