package com.example.sassydesign;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemDetailAdapter extends RecyclerView.Adapter<ItemDetailAdapter.ViewHolder>{

    ArrayList<ItemDetail> items = new ArrayList<ItemDetail>();
    String productName;
    String productCost;
    String productQuantity;
    String selectedCategory;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.hand_add_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ItemDetail item = items.get(position);
        viewHolder.setItem(item);

        viewHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(position);
            }
        });

        parsingData(position);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(ItemDetail item) {
        items.add(item);
    }

    public void setItems(ArrayList<ItemDetail> items) {
        this.items = items;
    }

    public ItemDetail getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, ItemDetail item) {
        items.set(position, item);
    }

    //아이템 삭제
    public void deleteItem(int position){
        items.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, items.size());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        EditText productName;
        EditText productCost;
        EditText productQuantity;
        String selectedCategory;
        Spinner category;
        ImageButton deleteButton;

        public ViewHolder(View itemView){
            super(itemView);

            productName = itemView.findViewById(R.id.productName);
            productCost = itemView.findViewById(R.id.productCost);
            category = itemView.findViewById(R.id.categorySpinner);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            productQuantity = itemView.findViewById(R.id.productQuantity);

        }

        public void setItem(ItemDetail item){
            productName.setText(item.getProductName());
            productCost.setText(item.getProductCost());
            productQuantity.setText(item.getProductQuantity());
            selectedCategory = category.getSelectedItem().toString();

        }

    }

    //데이터베이스 넘겨줄 데이터 받아오기
    public ItemDetail parsingData(int position) {
        return items.get(position);
    }
}
