package com.bluebell.bottom_sheet;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_bottomsheet).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bottomsheet:
                openBottomSheet();

                break;
        }
    }

    public void openBottomSheet() {

        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        ImageView imgVCompany = (ImageView) view.findViewById(R.id.imgV_company);
        ImageView imgVClose = (ImageView) view.findViewById(R.id.imgV_close);
        ImageView imgVIcon = (ImageView) view.findViewById(R.id.imgV_icon);
        TextView imgVName = (TextView) view.findViewById(R.id.tv_name);
        TextView tvInfo = (TextView) view.findViewById(R.id.tv_info);
        //mRecyclerView = (RecyclerView) view.findViewById(R.id.listItems);
        Button btnDetails = (Button) view.findViewById(R.id.btnViewDetalis);

        final Dialog mBottomSheetDialog = new Dialog(this,
                R.style.MaterialDialogSheet);
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
        mBottomSheetDialog.show();

        imgVClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog.dismiss();
            }
        });

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "click event occur", Toast.LENGTH_SHORT).show();

                mBottomSheetDialog.dismiss();
            }
        });

    }
}
