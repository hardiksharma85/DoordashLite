package com.example.hardik.doorslash.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class RecyclerItemDecoration extends RecyclerView.ItemDecoration {
        private int mSpace;
        public RecyclerItemDecoration(int space) {
            mSpace = space;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;
            outRect.top = mSpace;
        }
    }

