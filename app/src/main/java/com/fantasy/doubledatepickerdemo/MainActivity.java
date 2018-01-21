package com.fantasy.doubledatepickerdemo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fantasy.doubledatepicker.DoubleDateSelectDialog;

/**
 * Created by darrenfantasy on 2018/01/20.
 */
public class MainActivity extends AppCompatActivity {
    private Button mShowDatePickBtn;
    private DoubleDateSelectDialog mDoubleTimeSelectDialog;
    private TextView allowedSmallestTimeText, allowedBiggestTimeText, defaultChooseDateText;
    private String allowedSmallestTime, allowedBiggestTime, defaultChooseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowDatePickBtn = findViewById(R.id.show_date_pick_btn);
        allowedSmallestTimeText = findViewById(R.id.allowedSmallestTimeText);
        allowedBiggestTimeText = findViewById(R.id.allowedBiggestTimeText);
        defaultChooseDateText = findViewById(R.id.defaultChooseDateText);
        allowedSmallestTime = "2017-11-12";
        allowedBiggestTime = "2018-02-11";
        defaultChooseDate = "2018-01-18";
        allowedSmallestTimeText.setText("起始日期: "+allowedSmallestTime);
        allowedBiggestTimeText.setText("结束日期: "+allowedBiggestTime);
        defaultChooseDateText.setText("默认选中日期: "+defaultChooseDate);
        mShowDatePickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomTimePicker();
            }
        });
    }

    public void showCustomTimePicker() {

        if (mDoubleTimeSelectDialog == null) {
            mDoubleTimeSelectDialog = new DoubleDateSelectDialog(this, allowedSmallestTime, allowedBiggestTime, defaultChooseDate);
            mDoubleTimeSelectDialog.setOnDateSelectFinished(new DoubleDateSelectDialog.OnDateSelectFinished() {
                @Override
                public void onSelectFinished(String startTime, String endTime) {
                    mShowDatePickBtn.setText(startTime.replace("-", ".") + "至\n" + endTime.replace("-", "."));

                }
            });

            mDoubleTimeSelectDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                }
            });
        }
        if (!mDoubleTimeSelectDialog.isShowing()) {
            mDoubleTimeSelectDialog.show();
        }
    }
}
