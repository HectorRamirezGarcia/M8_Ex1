package com.example.m8_ex1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.m8_ex1.DB.IncidenciaDBHelper;

import static com.example.m8_ex1.DB.IncidenciaContract.IncidenciaEntry.TABLE_NAME;

@SuppressWarnings("ALL")
public class MenuAplication extends Fragment {

    protected androidx.fragment.app.Fragment[] menuFragments;

    private final int[] BTNMENU = {R.id.btnAdd, R.id.idButtonList, R.id.idButtonRemove};

    public MenuAplication() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View menu = inflater.inflate(R.layout.activity_menu_aplication, container, false);

        final Button btnAfegir = menu.findViewById(R.id.btnAdd);
        btnAfegir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fragmentAdd = new AddProblem();
                menuTransaction.replace(R.id.fragmentID, fragmentAdd );
                menuTransaction.commit();
            }
        });

        final Button btnLlistar = menu.findViewById(R.id.idButtonList);
        btnLlistar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fragmentViewIn = new ViewIn();
                menuTransaction.replace(R.id.fragmentID, fragmentViewIn );
                menuTransaction.commit();
            }
        });

        final Button btnEliminar = menu.findViewById(R.id.idButtonRemove);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainActivity)getActivity()).db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME+";");
                ((MainActivity)getActivity()).db.execSQL(((MainActivity)getActivity()).SQL_CREATE_ENTRIES);
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fragmentViewIn = new ViewIn();
                menuTransaction.replace(R.id.fragmentID, fragmentViewIn );
                menuTransaction.commit();
            }
        });

        return menu;
    }
}
