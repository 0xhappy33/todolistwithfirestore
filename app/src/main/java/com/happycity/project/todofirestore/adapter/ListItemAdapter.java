package com.happycity.project.todofirestore.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.happycity.project.todofirestore.ui.MainActivity;
import com.happycity.project.todofirestore.R;
import com.happycity.project.todofirestore.model.ToDo;

import java.util.List;

/**
 * Created by Ha Truong on 10/16/2017.
 * This is a ToDoFireStore
 * into the com.happycity.project.todofirestore.adapter
 */

class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener{

    private ItemClickListener itemClickListener;
    TextView item_title, item_description;
    public ListItemViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);

        item_title = itemView.findViewById(R.id.item_title);
        item_description = itemView.findViewById(R.id.item_description);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.setHeaderTitle("Select the action");
        contextMenu.add(0,0,getAdapterPosition(), "DELETE");
    }
}

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder>{

    private MainActivity mainActivity;
    private List<ToDo> toDoList;

    public ListItemAdapter(MainActivity mainActivity, List<ToDo> toDoList) {
        this.mainActivity = mainActivity;
        this.toDoList = toDoList;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mainActivity.getBaseContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ListItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
//        set data to item
        holder.item_title.setText(toDoList.get(position).getTitle());
        holder.item_description.setText(toDoList.get(position).getDescription());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                // when user select item, data will auto set for edit text view
                mainActivity.title.setText(toDoList.get(position).getTitle());
                mainActivity.description.setText(toDoList.get(position).getDescription());
                mainActivity.isUpdate = true;
                mainActivity.idUpdate = toDoList.get(position).getId();
            }
        });
    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}
