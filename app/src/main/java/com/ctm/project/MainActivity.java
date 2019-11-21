package com.ctm.project;


import android.app.LauncherActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ViewFlipper mFlip;
    RelativeLayout page1;
    ImageButton Webtoon;
    TextView textId;
    DbHelper dbHelper;
    Intent intentlog;
    String Ids;
    ViewPager nvp,tvp,danhangvp,Main;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DbHelper(getApplicationContext());
        intentlog = getIntent();

        Ids = intentlog.getStringExtra("id");

        Main = (ViewPager)findViewById(R.id.Mainbanner);
        MainPager mainadapter = new MainPager(getSupportFragmentManager());
        MainBanner1 banner1 = new MainBanner1();
        MainBanner2 banner2 = new MainBanner2();
        MainBanner3 banner3 = new MainBanner3();

        mainadapter.addItem(banner1);
        mainadapter.addItem(banner2);
        mainadapter.addItem(banner3);

        Main.setAdapter(mainadapter);



        SharedPreferences pref= getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("ID",Ids);
        editor.commit();

        danhangvp = (ViewPager)findViewById(R.id.danhangvp);
        danhangvp.setClipToPadding(false);
        pagerAdapter dadapter = new pagerAdapter(getSupportFragmentManager());
        int dpValue = 16;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        danhangvp.setPadding(margin, 0, margin, 0);
        danhangvp.setPageMargin(margin/2);


        tvp = (ViewPager)findViewById(R.id.toonvp);
        tvp.setClipToPadding(false);
        pagerAdapter tadapter = new pagerAdapter(getSupportFragmentManager());
        dfirst DFirst = new dfirst();
        dadapter.addItem(DFirst);
        danhangvp.setAdapter(dadapter);

        nvp = (ViewPager)findViewById(R.id.novelvp);
        pagerAdapter nadapter = new pagerAdapter(getSupportFragmentManager());
        nvp.setClipToPadding(false);


        nfirst NFirst = new nfirst();
        nadapter.addItem(NFirst);
        nsecond NSecond = new nsecond();
        nadapter.addItem(NSecond);
        nthird NThird = new nthird();
        nadapter.addItem(NThird);
        nforth NForth = new nforth();
        nadapter.addItem(NForth);

        nvp.setAdapter(nadapter);

        tfirst TFirst = new tfirst();
        tadapter.addItem(TFirst);
        tsecond TSecond = new tsecond();
        tadapter.addItem(TSecond);
        tThird TThird = new tThird();
        tadapter.addItem(TThird);
        tforth TForth = new tforth();
        tadapter.addItem(TForth);
        tvp.setAdapter(tadapter);



        login = (Button) findViewById(R.id.login);

        Webtoon = (ImageButton) findViewById(R.id.Webtoon);
        page1 = (RelativeLayout) findViewById(R.id.page1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    /*    mFlip = (ViewFlipper) findViewById(R.id.flip);
        mFlip.startFlipping();
        mFlip.setFlipInterval(3000);
*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);



        textId = (TextView) headerView.findViewById(R.id.textId);
        textId.setText(pref.getString("ID","로그인 해주세요"));


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*  @Override
      public boolean onCreateOptionsMenu(Menu menu) {
          getMenuInflater().inflate(R.menu.main, menu);
          return true;
      }

     @Override
      public boolean onOptionsItemSelected(MenuItem item) {

          int id = item.getItemId();

          if (id == R.id.gotohome) {

              return true;
          }

          return super.onOptionsItemSelected(item);
      }*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.CouponNavi) {
            Intent CouponIntent = new Intent(MainActivity.this, Coupon.class);
            startActivity(CouponIntent);
        } else if (id == R.id.Service) {
            Intent ServiceIntent = new Intent(MainActivity.this, Service_center.class);
            startActivity(ServiceIntent);

        } else if (id == R.id.Option) {
            Intent OptionIntent = new Intent(MainActivity.this, Option.class);
            startActivity(OptionIntent);
        } else if (id == R.id.invenbtn) {
            Intent intent = new Intent(MainActivity.this, Inventory.class);
            startActivity(intent);
        } else if (id == R.id.searchbtn) {
            Intent intentSearch = new Intent(MainActivity.this, Search.class);
            startActivity(intentSearch);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void mOnClick(View v) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        switch (v.getId()) {
            case R.id.login:
                Intent intentLogin = new Intent(MainActivity.this, LoginAct.class);
                startActivity(intentLogin);
                break;
            case R.id.moviebtn:
                Intent intentmoive = new Intent(MainActivity.this, MoiveAct.class);
                startActivity(intentmoive);
                break;

            case R.id.Webtoon:
                Intent intentWebtoon = new Intent(MainActivity.this, webtoon.class);
                startActivity(intentWebtoon);
                break;

            case R.id.novelbtn:
                Intent intentnovel = new Intent(MainActivity.this,Novel.class);
                startActivity(intentnovel);
                break;



        }
    }
    class MainPager extends  FragmentStatePagerAdapter{
        ArrayList<Fragment> items = new ArrayList<Fragment>();
        public MainPager(FragmentManager fm){super(fm); }



        public void addItem(Fragment item) {
            items.add(item);
        }
        public float getPageWidth(int postion){
            return 1;
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }
    }

    class pagerAdapter extends FragmentStatePagerAdapter{

    ArrayList<Fragment> items = new ArrayList<Fragment>();
        public pagerAdapter(FragmentManager fm){super(fm); }



    public void addItem(Fragment item) {
            items.add(item);
    }
        public float getPageWidth(int postion){
            return (0.3f);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }




