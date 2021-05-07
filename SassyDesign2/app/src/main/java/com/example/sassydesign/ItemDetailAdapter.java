package com.example.sassydesign;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemDetailAdapter extends RecyclerView.Adapter<ItemDetailAdapter.ViewHolder>{

    ArrayList<ItemDetail> items = new ArrayList<ItemDetail>();


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

        //parsingData(position);

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

            deleteButton = itemView.findViewById(R.id.deleteButton);
            productName = itemView.findViewById(R.id.productName);
            productCost = itemView.findViewById(R.id.productCost);
            category = itemView.findViewById(R.id.categorySpinner);
            productQuantity = itemView.findViewById(R.id.productQuantity);


        }

        public void setItem(ItemDetail item){
            productName.setText(item.getProductName());
            productName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    item.setProductName(productName.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            productCost.setText(item.getProductCost());
            productCost.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    item.setProductCost(productCost.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            productQuantity.setText(item.getProductQuantity());
            productQuantity.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    item.setProductQuantity(productQuantity.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            //category.setSelection(0);
            //selectedCategory = category.getSelectedItem().toString();
            category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    //category.setSelection(position);

                    selectedCategory = category.getSelectedItem().toString();
                    if(selectedCategory.equals("카테고리")){
                        //
                    }
                    else{
                        selectedCategory = category.getSelectedItem().toString();
                        item.setProductCategory(selectedCategory);
                        item.setCategory(category);
                        item.setPosition(position);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            int position = item.getPosition();
            category.setSelection(position);
        }


    }

//    //데이터베이스 넘겨줄 데이터 받아오기
//    public ItemDetail parsingData(int position) {
//        return items.get(position);
//    }
}