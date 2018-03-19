package com.ntc.tancong.detai;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v4.app.ActivityCompat;
import java.util.ArrayList;
/**
 * Created by tanco on 3/11/2018.
 */

public class PeopleFragment extends Fragment {

    private final  int REQUEST_CALL=1;
    ArrayList<Item> list;
    AdapterPeople adapter;
    String number;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_people,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list=new ArrayList<Item>();
        list.add(new Item("Nguyen Van B","01264104431",R.drawable.ic_edtuser20));
        adapter= new AdapterPeople(getActivity(),list);
        final ListView lvPeople  = (ListView) view.findViewById(R.id.lvpeople);
        lvPeople.setAdapter(adapter);
        lvPeople.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                number = list.get(position).getPeople_phone().trim().toString();
                MakeCall(number);

            }
        });
    }
    private void MakeCall(String number)
    {

        if(number.length()>0) {
            if (ContextCompat.checkSelfPermission(getContext(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
        else
        {
            Toast.makeText(getContext(), "number : " +number, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CALL)
        {
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                MakeCall(number);
            }
            else
            {
                Toast.makeText(getContext(), "ERMISSION_DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
