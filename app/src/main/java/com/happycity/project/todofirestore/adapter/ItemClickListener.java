package com.happycity.project.todofirestore.adapter;

import android.view.View;

/**
 * Created by Ha Truong on 10/16/2017.
 * This is a ToDoFireStore
 * into the com.happycity.project.todofirestore.adapter
 */

public interface ItemClickListener {
    void onClick(View view, int position, boolean isLongClick);
}
