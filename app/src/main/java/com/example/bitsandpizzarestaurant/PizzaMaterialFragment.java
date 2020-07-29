package com.example.bitsandpizzarestaurant;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaMaterialFragment extends Fragment {


    public PizzaMaterialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pizza_material,container,false);
        String[] pizzaNames = new String[Pizza.pizzas.length];
        for(int i = 0; i< pizzaNames.length; i++){
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }
        int[] pizzaImageIds = new int[Pizza.pizzas.length];
        for(int i = 0; i< pizzaImageIds.length;i++){
            pizzaImageIds[i] = Pizza.pizzas[i].getImageResourceId();
        }
        CaptionedImageAdapter pizzaAdapter = new CaptionedImageAdapter(pizzaNames,pizzaImageIds);
        pizzaRecycler.setAdapter(pizzaAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        pizzaRecycler.setLayoutManager(layoutManager);

        pizzaAdapter.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int i) {
                Intent intent = new Intent(getActivity(),PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO,i);
                getActivity().startActivity(intent);

            }
        });
        return pizzaRecycler;
    }

}
