package com.example.sassydesign;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    ArrayList<Item> items = new ArrayList<Item>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int ViewType){
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item_daily_list, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Item item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(){
        items.clear();
        this.notifyDataSetChanged();
    }

    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    public Item getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Item item){
        items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemTitle;
        TextView itemCacheOrCard;
        TextView itemDetail;
        TextView itemCategory;
        TextView itemPrice;
        TextView itemQuantity;

        public ViewHolder(View itemView){
            super(itemView);

            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemCacheOrCard = itemView.findViewById(R.id.itemCacheOrCard);
            itemDetail = itemView.findViewById(R.id.itemDetail);
            itemCategory = itemView.findViewById(R.id.itemCategory);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
        }

        public void setItem(Item item){

            String items="";
            String categories = "";
            String quantities = "";
            String price = "";

            itemTitle.setText(item.getTitle());
            itemCacheOrCard.setText(item.getCacheOrCard());
            for(int i = 0; i < item.subCursor; i++){

                if (i != item.subCursor) {
                    items += item.getItemList().get(i)+"\n";
                    categories += item.getCategoryList().get(i)+"\n";
                    quantities += item.getQuantityList().get(i)+"\n";
                    price += item.getPriceList().get(i)+"\n";
                }
                else{
                    items += item.getItemList().get(i);
                    categories += item.getCategoryList().get(i);
                    quantities += item.getQuantityList().get(i);
                    price += item.getPriceList().get(i);
                }

                itemDetail.setText(items);
                itemCategory.setText(categories);
                itemPrice.setText(price);
                itemQuantity.setText(quantities);

            }

        }

    }

}