package com.sslwireless.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Sheet {
    public static void open(Context context){
        Toast.makeText(context,"Bottom sheet is opened",Toast.LENGTH_SHORT).show();
        openBottomSheet(context);
    }


    public static void  openBottomSheet(final Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View view = inflater.inflate( R.layout.bottom_sheet, null );
        //View view = context.getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        ImageView imgVCompany = (ImageView) view.findViewById(R.id.imgV_company);
        ImageView imgVClose = (ImageView) view.findViewById(R.id.imgV_close);
        ImageView imgVIcon = (ImageView) view.findViewById(R.id.imgV_icon);
        TextView imgVName = (TextView) view.findViewById(R.id.tv_name);
        TextView tvInfo = (TextView) view.findViewById(R.id.tv_info);
        //mRecyclerView = (RecyclerView) view.findViewById(R.id.listItems);
        Button btnDetails = (Button) view.findViewById(R.id.btnViewDetalis);

        final Dialog mBottomSheetDialog = new Dialog(context,
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
                Toast.makeText(context, "click event occur", Toast.LENGTH_SHORT).show();

                mBottomSheetDialog.dismiss();
            }
        });

    }
}
