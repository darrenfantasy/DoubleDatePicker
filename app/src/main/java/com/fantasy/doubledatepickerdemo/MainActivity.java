package com.fantasy.doubledatepickerdemo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fantasy.doubledatepicker.DoubleDateSelectDialog;

/**
 * Created by darrenfantasy on 2018/01/20.
 */
public class MainActivity extends AppCompatActivity {
    private Button mShowDatePickBtn;
    private DoubleDateSelectDialog mDoubleTimeSelectDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowDatePickBtn = findViewById(R.id.show_date_pick_btn);
        mShowDatePickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomTimePicker();
            }
        });
    }

    public void showCustomTimePicker() {
        String beginDeadTime = "2017-01-01";
        if (mDoubleTimeSelectDialog == null) {
            mDoubleTimeSelectDialog = new DoubleDateSelectDialog(this, beginDeadTime, "", "");
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
            mDoubleTimeSelectDialog.recoverButtonState();
            mDoubleTimeSelectDialog.show();
        }
    }
}
