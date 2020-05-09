package com.weiyu.demoview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {
    private Button btn_add;
    private EditText edit_one;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        btn_add = (Button) findViewById(R.id.btn_add);
        edit_one = (EditText) findViewById(R.id.editText3);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString spanStr = new SpannableString("imge");
                Drawable drawable = Activity2.this.getResources().getDrawable(R.drawable.f045);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
                spanStr.setSpan(span,0,4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                int cursor = edit_one.getSelectionStart();
                edit_one.getText().insert(cursor, spanStr);
            }
        });
        Button btnstart = (Button)findViewById(R.id.button);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this,Activity3.class));
            }
        });
    }

    public class EditTextWithDel extends EditText {

        private final static String TAG = "EditTextWithDel";
        private Drawable imgInable;
        private Drawable imgAble;
        private Context mContext;

        public EditTextWithDel(Context context) {
            super(context);
            mContext = context;
            init();
        }

        public EditTextWithDel(Context context, AttributeSet attrs) {
            super(context, attrs);
            mContext = context;
            init();
        }

        public EditTextWithDel(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            mContext = context;
            init();
        }

        private void init() {
            imgInable = mContext.getResources().getDrawable(R.drawable.delete_gray);
            addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    setDrawable();
                }
            });
            setDrawable();
        }

        // 设置删除图片
        private void setDrawable() {
            if (length() < 1)
                setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            else
                setCompoundDrawablesWithIntrinsicBounds(null, null, imgInable, null);
        }

        // 处理删除事件
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (imgInable != null && event.getAction() == MotionEvent.ACTION_UP) {
                int eventX = (int) event.getRawX();
                int eventY = (int) event.getRawY();
                Log.e(TAG, "eventX = " + eventX + "; eventY = " + eventY);
                Rect rect = new Rect();
                getGlobalVisibleRect(rect);
                rect.left = rect.right - 100;
                if (rect.contains(eventX, eventY))
                    setText("");
            }
            return super.onTouchEvent(event);
        }
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }
}
