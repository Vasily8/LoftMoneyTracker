package com.vasily.loftmoneyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int REQUEST_CODE = 100;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MainPagesAdapter adapter;
    private Toolbar toolbar;
    private FloatingActionButton fab;


    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: ");

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        fab = findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = viewPager.getCurrentItem();

                String type = null;

                switch (page) {
                    case MainPagesAdapter.PAGE_INCOMES:
                        type = Item.TYPE_INCOME;
                        break;
                    case MainPagesAdapter.PAGE_EXPENSES:
                        type = Item.TYPE_EXPENSE;
                        break;

                }

                if (type != null) {
                    Intent intent = new Intent(MainActivity.this, AddActivity.class);
                    intent.putExtra(AddActivity.KEY_TYPE, type);
                    startActivityForResult(intent, REQUEST_CODE);
                }

            }
        });

        setSupportActionBar(toolbar);

        adapter = new MainPagesAdapter(getSupportFragmentManager(), this);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new PageListener());
    }

    class PageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case MainPagesAdapter.PAGE_INCOMES:
                case MainPagesAdapter.PAGE_EXPENSES:
                    fab.show();
                    break;

                case MainPagesAdapter.PAGE_BALANCE:

                    fab.hide();
                    break;

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (Fragment fragment : fragments) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }

    }
}