package com.example.dell.zhihu;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.dell.zhihu.Fragment.item.CollectFeagment;
import com.example.dell.zhihu.Fragment.item.DryCognFrangment;
import com.example.dell.zhihu.Fragment.item.InregaidFragment;
import com.example.dell.zhihu.Fragment.item.QuoraFenment;
import com.example.dell.zhihu.Fragment.item.Raenfragment;
import com.example.dell.zhihu.Fragment.item.SettingFreagment;
import com.example.dell.zhihu.Fragment.item.VtwoexFragment;
import com.example.dell.zhihu.Fragment.item.WechatFegment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FrameLayout mFranet;
    private TabLayout mMainTab;
    private FragmentManager supportFragmentManager;
    private QuoraFenment quoraFenment;
    private Toolbar toolbar;
    private List<String> strings;
    private TextView mTeOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        strings = new ArrayList<>();
        strings.add("知乎日报");
        strings.add("微信精选");
        strings.add("干货集中营");
        strings.add("稀土掘金");
        strings.add("V2EX");
        strings.add("收藏");
        strings.add("设置");
        strings.add("关于");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTeOn.setText(strings.get(0));
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getFrament();
    }

    private void getFrament() {
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        quoraFenment = new QuoraFenment();
        fragmentTransaction.add(R.id.franet, quoraFenment);
        fragmentTransaction.commit();
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



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (id == R.id.nav_camera) {
           mTeOn.setText(strings.get(0));
                    fragmentTransaction.replace(R.id.franet, quoraFenment);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            mTeOn.setText(strings.get(1));
            WechatFegment wechatFegment = new WechatFegment();
            fragmentTransaction.replace(R.id.franet, wechatFegment);
        } else if (id == R.id.Re_nuggets) {
            mTeOn.setText(strings.get(2));
            Raenfragment raenfragment = new Raenfragment();
            fragmentTransaction.replace(R.id.franet, raenfragment);
        } else if (id == R.id.nav_slideshow) {
            mTeOn.setText(strings.get(3));
            DryCognFrangment dryCognFrangment = new DryCognFrangment();
            fragmentTransaction.replace(R.id.franet, dryCognFrangment);
        } else if (id == R.id.nav_manage) {
            mTeOn.setText(strings.get(4));
            VtwoexFragment vtwoexFragment = new VtwoexFragment();
            fragmentTransaction.replace(R.id.franet, vtwoexFragment);
        } else if (id == R.id.nav_Colow) {
            mTeOn.setText(strings.get(5));
            CollectFeagment collectFeagment = new CollectFeagment();
            fragmentTransaction.replace(R.id.franet, collectFeagment);
        } else if (id == R.id.nav_send) {
            mTeOn.setText(strings.get(6));
            SettingFreagment settingFreagment = new SettingFreagment();
            fragmentTransaction.replace(R.id.franet, settingFreagment);
        } else if (id == R.id.guan_yu) {
            mTeOn.setText(strings.get(7));
            InregaidFragment inregaidFragment = new InregaidFragment();
            fragmentTransaction.replace(R.id.franet, inregaidFragment);
        }
        fragmentTransaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initView() {
        mFranet = (FrameLayout) findViewById(R.id.franet);

        mTeOn = (TextView) findViewById(R.id.te_on);
    }
}
