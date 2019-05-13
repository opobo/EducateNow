package com.example.educatenow;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramFragment extends Fragment {
ListView listView;
ArrayList arrayList;
ArrayAdapter arrayAdapter;

    public ProgramFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_program, container, false);


//        instatiating objects
         listView=v.findViewById(R.id.items);
         arrayList=new ArrayList();
         arrayList.add("Faculty of Computing and Informatics");
        arrayList.add("Faculty of Science");
        arrayList.add("Faculty of Medicine and Surgery");
        arrayList.add("Faculty of Applied Science");
        arrayList.add("Faculty of Business Administration");

        arrayAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

//        adddin an action listener into the arraylis
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                moving with through the selected items
                switch (position){
                    case 0:
                        AlertDialog.Builder alert=new AlertDialog.Builder(getContext())
                                .setTitle(arrayList.get(position).toString())
                                .setMessage("Programs Available:\nDegree in Information Technology\nDegree in Computer Science\nDegree in Computer Engineering")
                                .setCancelable(false)
                                .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog dialog=alert.create();
                        dialog.show();
                        break;
                    case 1:
                        AlertDialog.Builder alert2=new AlertDialog.Builder(getContext())
                                .setTitle(arrayList.get(position).toString())
                                .setMessage("Programs Available:\nDegree Education(Physical)\nDegree in Education (Biological)\nDiploma in Lab Technology")
                                .setCancelable(false)
                                .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog dialog2=alert2.create();
                        dialog2.show();
                        break;
                    case 2:
                        AlertDialog.Builder alert3=new AlertDialog.Builder(getContext())
                                .setTitle(arrayList.get(position).toString())
                                .setMessage("Programs Available:\nDegree Medicine and Surgery\nDegree in Pharmacy\nDegree in Medical Lab Science")
                                .setCancelable(false)
                                .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog dialog3=alert3.create();
                        dialog3.show();
                        break;
                    case 3:
                        AlertDialog.Builder alert4=new AlertDialog.Builder(getContext())
                                .setTitle(arrayList.get(position).toString())
                                .setMessage("Programs Available:\nDegree Electrical Engineering\nDegree in Biomedical Engineering\nDegree in Geometrical Ink")
                                .setCancelable(false)
                                .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog dialog4=alert4.create();
                        dialog4.show();
                        break;

                    case 4:
                        AlertDialog.Builder alert5=new AlertDialog.Builder(getContext())
                                .setTitle(arrayList.get(position).toString())
                                .setMessage("Programs Available:\nDegree in Business Administration\nDegree in Accounting and Finance\nDegree in Procurement")
                                .setCancelable(false)
                                .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog dialog5=alert5.create();
                        dialog5.show();
                        break;
                        default:return;
                }


            }
        });

        return v;

    }

}
