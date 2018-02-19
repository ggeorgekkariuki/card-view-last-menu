package com.example.android.cardview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static com.example.android.cardview.R.id.nav_viewer_menu;

public class MainActivity extends AppCompatActivity implements CardFragment.OnFragmentInteractionListener {
    private NavigationView navigationView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment[] fragment = {fragmentManager.findFragmentById(R.id.fragmentContainer)};

        navigationView = findViewById(R.id.nav_viewer_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                item.setChecked(true);

                Log.d("Original Lucy id ", String.valueOf(R.id.lucy_item));

                if(id == R.id.steven_item){
                         Toast.makeText(getApplicationContext(),"You clicked on "+ id,
                                Toast.LENGTH_SHORT).show();
                        Log.d(" Steven item id  ", String.valueOf(id));
                        Log.d("Original Steven id ", String.valueOf(R.id.lucy_item));
                } else if(id == R.id.amethyst_item){
                        Toast.makeText(getApplicationContext(),"You clicked on "+ id,
                                Toast.LENGTH_SHORT).show();
                        Log.d(" Amethyst item id  ", String.valueOf(id));
                        Log.d("Original Amethyst id ", String.valueOf(R.id.lucy_item));
                } else if (id == R.id.connie_item){
                    Toast.makeText(getApplicationContext(),"You clicked on "+ id,
                                Toast.LENGTH_SHORT).show();
                        Log.d(" Connie item id  ", String.valueOf(id));
                        Log.d("Original Connie id ", String.valueOf(R.id.lucy_item));
                } else if (id == R.id.lucy_item){
                    Toast.makeText(getApplicationContext(),"You clicked on "+ id,
                                Toast.LENGTH_SHORT).show();
                        Log.d(" Lucy item id  ", String.valueOf(id));
                        Log.d("Original Lucy id ", String.valueOf(R.id.lucy_item));
                }

                return true;
            }
        });


        if (fragment[0] == null){
            fragment[0] = new CardFragment();
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment[0]).commit();
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            item.setChecked(true);
            int id = item.getItemId();
            switch (item.getItemId()){

                case R.id.steven_item:
                    Toast.makeText(getApplicationContext(),"You clicked on "+ id,
                            Toast.LENGTH_SHORT).show();
                    Log.d(" Steven item id  ", String.valueOf(id));
                    Log.d("Original Steven id ", String.valueOf(R.id.lucy_item));
                    break;

                case R.id.amethyst_item:
                    Toast.makeText(getApplicationContext(),"You clicked on "+ id,
                            Toast.LENGTH_SHORT).show();
                    Log.d(" Steven item id  ", String.valueOf(id));
                    Log.d("Original Steven id ", String.valueOf(R.id.lucy_item));
                    break;
                case R.id.connie_item:
                    Toast.makeText(getApplicationContext(),"You clicked on "+ id,
                            Toast.LENGTH_SHORT).show();
                    Log.d(" Steven item id  ", String.valueOf(id));
                    Log.d("Original Steven id ", String.valueOf(R.id.lucy_item));
                    break;
                case R.id.lucy_item:
                    Toast.makeText(getApplicationContext(),"You clicked on "+ id,
                            Toast.LENGTH_SHORT).show();
                    Log.d(" Steven item id  ", String.valueOf(id));
                    Log.d("Original Steven id ", String.valueOf(R.id.lucy_item));
                    break;
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
