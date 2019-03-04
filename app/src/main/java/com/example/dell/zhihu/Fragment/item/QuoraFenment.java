package com.example.dell.zhihu.Fragment.item;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.zhihu.Fragment.Quryde.Daliyfragment;
import com.example.dell.zhihu.Fragment.Quryde.HotFragment;
import com.example.dell.zhihu.Fragment.Quryde.Specialfragment;
import com.example.dell.zhihu.Fragment.Quryde.ThemenFragment;
import com.example.dell.zhihu.R;

import java.util.ArrayList;
import java.util.List;

public class QuoraFenment extends Fragment {
    private View view;
    private TabLayout mTab;
    private ViewPager mPage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.quoryf, null);
        initView(inflate);
        getData();
        return inflate;
    }

    private void getData() {
        Daliyfragment daliyfragment=new Daliyfragment();
        ThemenFragment themenFragment=new ThemenFragment();
        HotFragment hotFragment=new HotFragment();
        Specialfragment specialfragment=new Specialfragment();
        final List<Fragment> fragments=new ArrayList<>();
         fragments.add(daliyfragment);
         fragments.add(themenFragment);
         fragments.add(specialfragment);
         fragments.add(hotFragment);
         final List<String> strings=new ArrayList<>();
         strings.add("日报");
         strings.add("主题");
         strings.add("专栏");
         strings.add("热门");
        FragmentPagerAdapter fragmentPagerAdapter=new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        };
        mPage.setAdapter(fragmentPagerAdapter);
        mTab.setupWithViewPager(mPage);
    }

    private void initView(View inflate) {
        mTab = (TabLayout) inflate.findViewById(R.id.tab);
        mPage = (ViewPager) inflate.findViewById(R.id.page);
    }
}
