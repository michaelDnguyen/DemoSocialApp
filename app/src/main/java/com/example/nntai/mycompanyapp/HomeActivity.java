package com.example.nntai.mycompanyapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.nntai.mycompanyapp.fragment.DaskboardFragment;
import com.example.nntai.mycompanyapp.fragment.HomeFragment;
import com.example.nntai.mycompanyapp.fragment.NotificationFragment;

import java.util.HashMap;
import java.util.Stack;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private HashMap<String, Stack<Fragment>> mStacks;
    private String mCurrentTab;

    public static final String TAB_HOME  = "tab_home";
    public static final String TAB_DASHBOARD  = "tab_dashboard";
    public static final String TAB_NOTIFICATIONS  = "tab_notifications";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;


            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedTab(TAB_HOME);
                    return true;
                case R.id.navigation_dashboard:
                    selectedTab(TAB_DASHBOARD);
                    return true;
                case R.id.navigation_notifications:
                    selectedTab(TAB_NOTIFICATIONS);
                    return true;
            }
            return false;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mStacks = new HashMap<String, Stack<Fragment>>();
        mStacks.put(TAB_HOME, new Stack<Fragment>());
        mStacks.put(TAB_DASHBOARD, new Stack<Fragment>());
        mStacks.put(TAB_NOTIFICATIONS, new Stack<Fragment>());
    }

    private void gotoFragment(Fragment selectedFragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, selectedFragment);
        fragmentTransaction.commit();
    }

    private void selectedTab(String tabId)
    {
        mCurrentTab = tabId;

        if(mStacks.get(tabId).size() == 0){
      /*
       *    First time this tab is selected. So add first fragment of that tab.
       *    Dont need animation, so that argument is false.
       *    We are adding a new fragment which is not present in stack. So add to stack is true.
       */
            if(tabId.equals(TAB_HOME)){
                pushFragments(tabId, new HomeFragment(),true);
            }else if(tabId.equals(TAB_DASHBOARD)){
                pushFragments(tabId, new DaskboardFragment(),true);
            }else if(tabId.equals(TAB_NOTIFICATIONS)){
                pushFragments(tabId, new NotificationFragment(),true);
            }
        }else {
      /*
       *    We are switching tabs, and target tab is already has atleast one fragment.
       *    No need of animation, no need of stack pushing. Just show the target fragment
       */
            pushFragments(tabId, mStacks.get(tabId).lastElement(),false);
        }
    }

    public void pushFragments(String tag, Fragment fragment, boolean shouldAdd){
        if(shouldAdd)
            mStacks.get(tag).push(fragment);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.main_container, fragment);
        ft.commit();
    }

    public void popFragments(){
  /*
   *    Select the second last fragment in current tab's stack..
   *    which will be shown after the fragment transaction given below
   */
        Fragment fragment = mStacks.get(mCurrentTab).elementAt(mStacks.get(mCurrentTab).size() - 2);

  /*pop current fragment from stack.. */
        mStacks.get(mCurrentTab).pop();

  /* We have the target fragment in hand.. Just show it.. Show a standard navigation animation*/
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.main_container, fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if(mStacks.get(mCurrentTab).size() == 1){
            // We are already showing first fragment of current tab, so when back pressed, we will finish this activity..
            finish();
            return;
        }

    /* Goto previous fragment in navigation stack of this tab */
        popFragments();
    }
}
