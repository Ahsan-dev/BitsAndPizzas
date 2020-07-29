package com.example.bitsandpizzarestaurant;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PastaMaterialFragment extends Fragment {


    public PastaMaterialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RecyclerView pastaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pasta_material,container,false);
        String[] pastaNames = new String[Pasta.pastas.length];
        for (int i =0; i<pastaNames.length;i++){
            pastaNames[i] = Pasta.pastas[i].getName();
        }
        int[] pastaImageIds = new int[Pasta.pastas.length];
        for(int i=0; i<pastaNames.length;i++){
            pastaImageIds[i] = Pasta.pastas[i].getImageResourceId();
        }

        CaptionedImageAdapter pastaAdapter = new CaptionedImageAdapter(pastaNames,pastaImageIds);
        pastaRecycler.setAdapter(pastaAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        pastaRecycler.setLayoutManager(gridLayoutManager);
        pastaAdapter.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int i) {
                Intent intent = new Intent(getActivity(),PastaDetailActivity.class);
                intent.putExtra(PastaDetailActivity.EXTRA_PASTANO,i);
                getActivity().startActivity(intent);
            }
        });
        return pastaRecycler;
    }

}
