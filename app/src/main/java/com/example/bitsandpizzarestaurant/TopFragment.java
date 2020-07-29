package com.example.bitsandpizzarestaurant;


import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {


    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_top,container,false);
        RecyclerView homeRecycler = layout.findViewById(R.id.recyclerhomeId);
        String[] pizzaNames = new String[2];
        for(int i=0;i<2;i++){
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }
        String[] pastaNames = new String[2];
        for(int i=0;i<2;i++){
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        int[] pizzaImages = new int[2];
        for(int i=0;i<2;i++){
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }
        int[] pastaImages = new int[2];
        for(int i=0;i<2;i++){
            pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }

        String[] names = new String[pizzaNames.length+pastaNames.length];
        System.arraycopy(pizzaNames,0,names,0,pizzaNames.length);
        System.arraycopy(pastaNames,0,names,pizzaNames.length,pastaNames.length);

        int[] imageIds = new int[pastaImages.length+pastaImages.length];
        System.arraycopy(pizzaImages,0,imageIds,0,pastaImages.length);
        System.arraycopy(pastaImages,0,imageIds,pizzaImages.length,pastaImages.length);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        homeRecycler.setLayoutManager(layoutManager);

        CaptionedImageAdapter homeAdapter = new CaptionedImageAdapter(names,imageIds);
        homeRecycler.setAdapter(homeAdapter);

        homeAdapter.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int i) {

                Toast.makeText(getActivity(),"For details visit on the pizza/pasta page",Toast.LENGTH_LONG).show();

            }
        });



        return layout;
    }

}
