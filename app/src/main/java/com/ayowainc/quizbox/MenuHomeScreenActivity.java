package com.ayowainc.quizbox;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.ayowainc.quizbox.Background_Music.HomeWatcherServicesActivity;
import com.ayowainc.quizbox.Background_Music.MusicServiceActivity;
import com.ayowainc.quizbox.Category_Levels.All_Knowledge.AllKnowledgeQuizActivity;
import com.ayowainc.quizbox.Category_Levels.AdvanceJava.AJPBiginner;
import com.ayowainc.quizbox.Category_Levels.AdvanceJava.AJPProfessional;
import com.ayowainc.quizbox.Category_Levels.AdvanceJava.AJPWorldclass;
import com.ayowainc.quizbox.Category_Levels.Science.ScienceBiginner;
import com.ayowainc.quizbox.Category_Levels.Science.ScienceProfessional;
import com.ayowainc.quizbox.Category_Levels.Science.ScienceWorldClass;
import com.ayowainc.quizbox.Category_Levels.Management.ManagementBigginer;
import com.ayowainc.quizbox.Category_Levels.Management.ManagementProfessional;
import com.ayowainc.quizbox.Category_Levels.Management.ManagementWorldClass;
import com.ayowainc.quizbox.Category_Levels.Environment.EnvironmentBiginner;
import com.ayowainc.quizbox.Category_Levels.Environment.EnvironmentProfessional;
import com.ayowainc.quizbox.Category_Levels.Environment.EnvironmentWorldClass;
import com.ayowainc.quizbox.User.LoginActivity;
import com.ayowainc.quizbox.User.UserProfileActivity;
import com.ayowainc.quizbox.User.ratings;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MenuHomeScreenActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button navToggler_btn;
    LinearLayout linearLayout;
    Dialog dialog;
    Button allKnowledge_btn;

    private boolean mIsBound = false;

    ///////////////////////////////////////////////////////////////////  BIND BACKGROUD MUSIC HERE  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private MusicServiceActivity mServ;
    private ServiceConnection serviceConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName componentName, IBinder
                binder) {
            mServ = ((MusicServiceActivity.ServiceBinder) binder).getService();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            mServ = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); ///Eneter into fullscreen mode

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navToggler_btn = findViewById(R.id.action_menu_presenter);
        linearLayout = findViewById(R.id.main_content);
        allKnowledge_btn = findViewById(R.id.allknowledge_start);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////   ON CLICK TO ALL KNOWLEDGE QUIZ QUESTIONS SETUP HERE   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        allKnowledge_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AK = new Intent(getApplicationContext(), AllKnowledgeQuizActivity.class);
                startActivity(AK);
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        navigationDrawer();

        dialog = new Dialog(this, R.style.AnimateDialog);

        //Bind Background music here.
        doBindService();
        Intent music = new Intent();
        music.setClass(MenuHomeScreenActivity.this, MusicServiceActivity.class);
        startService(music);

        HomeWatcherServicesActivity mHomeWatcherServicesActivity;

        mHomeWatcherServicesActivity = new HomeWatcherServicesActivity(this);
        mHomeWatcherServicesActivity.setOnHomePressedListener(new HomeWatcherServicesActivity.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }

            @Override
            public void onHomeLongPressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
        });
        mHomeWatcherServicesActivity.startWatch();
    }

    void doBindService() {
        bindService(new Intent(this, MusicServiceActivity.class),
                serviceConnection, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if (mIsBound) {
            unbindService(serviceConnection);
            mIsBound = false;
        }
    }


    ///////////////////////////////////////////////////////////////////////////////  ALL CATEGORY SETUP FOR POP LEVEL DIALOG  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Dialog PopUp for Marketing Level Popup Screen setup
    public void market_start(View view) {
        Button close_btn,beginner_btn,professional_btn,worldclass_btn;
        final ProgressBar progressBar;

        dialog.setContentView(R.layout.activity_custom_popup);
        close_btn = dialog.findViewById(R.id.close_lev);
        beginner_btn = dialog.findViewById(R.id.beginner);
        professional_btn = dialog.findViewById(R.id.professional);
        worldclass_btn = dialog.findViewById(R.id.world_class);
        progressBar = dialog.findViewById(R.id.pro_gress1);

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        beginner_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
//////////////////////////On click action to MarketingBeginnerActivity Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent BG = new Intent(getApplicationContext(), ScienceBiginner.class);
                startActivity(BG);

            }
        });
        professional_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //////////////////////////On click action to MarketingProfessionalActivity Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent PRO = new Intent(MenuHomeScreenActivity.this, ScienceProfessional.class);
                startActivity(PRO);
            }


        });
        worldclass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//////////////////////////On click action to Marketing World_class Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent WC = new Intent(getApplicationContext(), ScienceWorldClass.class);
                startActivity(WC);

            }
        });

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    //Dialog PopUp for Programming Level Popup Screen setup

    public void android_start(View view) {
        Button close_btn;
        Button beginner_btn;
        Button professional_btn;
        Button worldclass_btn;
        final ProgressBar progressBar;


        dialog.setContentView(R.layout.activity_custom_popup);
        close_btn = dialog.findViewById(R.id.close_lev);
        beginner_btn = dialog.findViewById(R.id.beginner);
        professional_btn = dialog.findViewById(R.id.professional);
        worldclass_btn = dialog.findViewById(R.id.world_class);
        progressBar = dialog.findViewById(R.id.pro_gress1);

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        beginner_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
//////////////////////////On click action to MultimediaBeginnerActivity Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent BG = new Intent(getApplicationContext(), EnvironmentBiginner.class);
                startActivity(BG);

            }
        });
        professional_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//////////////////////////On click action to MultimediaProfessionalActivity Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent PRO = new Intent(MenuHomeScreenActivity.this, EnvironmentProfessional.class);
                startActivity(PRO);
            }
        });
        worldclass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//////////////////////////On click action to Programming World_class Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent WC = new Intent(getApplicationContext(), EnvironmentWorldClass.class);
                startActivity(WC);

            }
        });

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    //Dialog PopUp for History Level Popup Screen setup
    public void history_start(View view) {
        Button close_btn;
        Button beginner_btn;
        Button professional_btn;
        Button worldclass_btn;
        final ProgressBar progressBar;


        dialog.setContentView(R.layout.activity_custom_popup);
        close_btn = dialog.findViewById(R.id.close_lev);
        beginner_btn = dialog.findViewById(R.id.beginner);
        professional_btn = dialog.findViewById(R.id.professional);
        worldclass_btn = dialog.findViewById(R.id.world_class);
        progressBar = dialog.findViewById(R.id.pro_gress1);

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        beginner_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
//////////////////////////On click action to HistoryBeginnerActivity Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent BG = new Intent(getApplicationContext(), AJPBiginner.class);
                startActivity(BG);

            }
        });
        professional_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//////////////////////////On click action to HistoryProfessionalActivity Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent PRO = new Intent(MenuHomeScreenActivity.this, AJPProfessional.class);
                startActivity(PRO);
            }
        });
        worldclass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//////////////////////////On click action to History World_class Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent WC = new Intent(getApplicationContext(), AJPWorldclass.class);
                startActivity(WC);

            }
        });

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Dialog PopUp for History Level Popup Screen setup
    public void multimedia_start(View view) {
        Button close_btn;
        Button beginner_btn;
        Button professional_btn;
        Button worldclass_btn;
        final ProgressBar progressBar;


        dialog.setContentView(R.layout.activity_custom_popup);
        close_btn = dialog.findViewById(R.id.close_lev);
        beginner_btn = dialog.findViewById(R.id.beginner);
        professional_btn = dialog.findViewById(R.id.professional);
        worldclass_btn = dialog.findViewById(R.id.world_class);
        progressBar = dialog.findViewById(R.id.pro_gress1);

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        beginner_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
//////////////////////////On click action to HistoryBeginnerActivity Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent BG = new Intent(getApplicationContext(), ManagementBigginer.class);
                startActivity(BG);

            }
        });
        professional_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//////////////////////////On click action to HistoryProfessionalActivity Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent PRO = new Intent(MenuHomeScreenActivity.this, ManagementProfessional.class);
                startActivity(PRO);
            }
        });
        worldclass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//////////////////////////On click action to History World_class Activity
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(3000);
                Intent WC = new Intent(getApplicationContext(), ManagementWorldClass.class);
                startActivity(WC);

            }
        });

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }


    ///////////////////////////////////////////////////////////////////ALL ABOUT NAVIGATION DRAWER/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void navigationDrawer() {

        //Navigation Drawer

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.home);

        navToggler_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    ////////////////////////////////////////////////////////////ANIMATE NAV DRAWER////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.cat_heading));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                final float diffScaledOffset = slideOffset*(1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                linearLayout.setScaleX(offsetScale);
                linearLayout.setScaleY(offsetScale);


                final float xOffset = drawerView.getWidth()*slideOffset;
                final float xOffsetDiff = linearLayout.getWidth()*diffScaledOffset/2;
                final float xTranslation = xOffset - xOffsetDiff;
                linearLayout.setTranslationX(xTranslation);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (menuItem.getItemId() == R.id.user_profile) {

            Intent intent = new Intent(getApplicationContext(), UserProfileActivity.class);
            startActivity(intent);
            MenuHomeScreenActivity.super.onBackPressed();

        } else if (menuItem.getItemId() == R.id.rate) {
            Intent rating = new Intent(getApplicationContext(), ratings.class);
            startActivity(rating);
        } else if (menuItem.getItemId() == R.id.about) {
            //open about activity
            Intent about = new Intent(getApplicationContext(), AboutUsActivity.class);
            startActivity(about);
        } else if (menuItem.getItemId() == R.id.logout) {
            //Logout
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }
        return true;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onResume() {
        super.onResume();

        if (mServ != null) {
            mServ.resumeMusic();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        PowerManager pm = (PowerManager)
                getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;
        if (pm != null) {
            isScreenOn = pm.isScreenOn();
        }

        if (!isScreenOn) {
            if (mServ != null) {
                mServ.pauseMusic();
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        doUnbindService();
        Intent music = new Intent();
        music.setClass(this, MusicServiceActivity.class);
        stopService(music);

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
