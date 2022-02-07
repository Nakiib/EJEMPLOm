package com.example.ejemplom.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemplom.AdaptadorPersonajes;
import com.example.ejemplom.PersonajeVo;
import com.example.ejemplom.R;
import com.example.ejemplom.Utilidades;
import com.example.ejemplom.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    ArrayList<PersonajeVo> listaPersonajes;
    RecyclerView recyclerPersonajes;


    private void llenarPersonajes () {
        listaPersonajes.add(new PersonajeVo("Distrito 91 001","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discoprimeroo));
        listaPersonajes.add(new PersonajeVo("Distrito 91 002","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discosegundoo));
        listaPersonajes.add(new PersonajeVo("Distrito 91 003","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discoterceroo));
        listaPersonajes.add(new PersonajeVo("Distrito 91 004","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discocuartoo));
        listaPersonajes.add(new PersonajeVo("Hooded Rec 001","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discoquintoo));
        listaPersonajes.add(new PersonajeVo("Hooded Rec 002","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discosextoo));
        listaPersonajes.add(new PersonajeVo("Hooded Rec 003","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discoseptimoo));
        listaPersonajes.add(new PersonajeVo("Hooded Rec 004","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discooctavoo));
        listaPersonajes.add(new PersonajeVo("Hooded Rec 005","BlaBlaBlaBlaInfoInfoInfo",R.drawable.disconovenoo));

    }
    private View construirRecycler(LayoutInflater inflater, ViewGroup container,
                                   Bundle savedInstanceState) {
        //instanciamos listapersoinajes
        listaPersonajes = new ArrayList<>();

        View view = inflater.inflate(R.layout.item_list_personajes, container, false);
       // FloatingActionButton floatingActionButton = view.findViewById(R.id.fabAgregarGasto);
        recyclerPersonajes = view.findViewById(R.id.RecyclerId);

        if (Utilidades.visualizacion== Utilidades.LIST){
            recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));
        } else {
            recyclerPersonajes.setLayoutManager(new GridLayoutManager(getContext(),3));
        }
        /* COMENTAMOS ESTAS DOS LINEAS PORQUE SON DEL PRIMER RECYCLER SENCILLO.
         LO QUE HACEMOS ES METER LAS DOS EN EL IF PARA GENERAR LA LOGICA DE SELECCION DEPENDIENDO DE QUE BOTON PULSEMOS. lIST O GRID
        //recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this)); lo comentamos para probar el gridLayout a priori lo volveremos a activar
        //recyclerPersonajes.setLayoutManager(new GridLayoutManager(this,3));//gridlayout con cantidad de columnas*/
        llenarPersonajes();

        AdaptadorPersonajes adapter = new AdaptadorPersonajes(listaPersonajes);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Seleccion: "+
                        listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();

            }
        });
        recyclerPersonajes.setAdapter(adapter);


        return view;
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // final TextView textView = binding.textHome;
       /* homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
           public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

    }*/

        /*public void onDestroyView () {
            super.onDestroyView();
            binding = null;
        }*/
        construirRecycler(inflater, container, savedInstanceState);
        return root;
    }


}