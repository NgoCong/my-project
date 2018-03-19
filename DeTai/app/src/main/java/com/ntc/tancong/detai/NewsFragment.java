package com.ntc.tancong.detai;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by tanco on 3/11/2018.
 */

public class NewsFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navigationView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //ánh xạ và xét sự kiện chọn item của BottomNavigationView
        navigationView=(BottomNavigationView)view.findViewById(R.id.bottom_navigation);
        getActivity().getSupportFragmentManager()
                .beginTransaction().replace(R.id.fragment_containter,new HomeFragment())
                .commit();
        navigationView.setOnNavigationItemSelectedListener(this);

    }
    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
         getActivity().getSupportFragmentManager()
                 .beginTransaction().replace(R.id.fragment_containter,fragment)
                 .commit();
         return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.action_Home:
                fragment=new HomeFragment();
                break;
            case R.id.action_Newsfeed:
                fragment=new WriteNewsfeedFragment();
                break;
            case R.id.action_Messages:
                fragment=new MessagesFragment();
                break;
            case R.id.action_people:
                fragment=new PeopleFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
