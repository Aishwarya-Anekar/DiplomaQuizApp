package com.ayowainc.quizbox.Category_Levels.Management;

import android.animation.Animator;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.ayowainc.quizbox.MenuHomeScreenActivity;
import com.ayowainc.quizbox.R;
import com.ayowainc.quizbox.User.LoginActivity;
import com.ayowainc.quizbox.User.UserProfileActivity;
import com.ayowainc.quizbox.questionsModelClass;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class ManagementWorldClass extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button navToggler_btn, ShareQuestions_btn, Next_btn;
    LinearLayout linearLayout, linearLayout1;
    TextView txtQuestions, txtQuestionsIndicator;
    Dialog dialog;
    private int count = 0;
    private int position = 0;
    private List<questionsModelClass> list;
    private int score = 0;
//    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); ///Eneter into fullscreen mode
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_questions_view);

        //All Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navToggler_btn = findViewById(R.id.action_menu_presenter);
        linearLayout = findViewById(R.id.main_content);
        linearLayout1 = findViewById(R.id.options_layout);
        txtQuestions = findViewById(R.id.question_view);
        txtQuestionsIndicator = findViewById(R.id.no_of_questions_view);
        ShareQuestions_btn = findViewById(R.id.share_que_btn);
        Next_btn = findViewById(R.id.next_btn);


        final MediaPlayer level_lose = MediaPlayer.create(this, R.raw.level_lose);///Play sound when user loses level
        final MediaPlayer level_won = MediaPlayer.create(this, R.raw.applause_wav);///Play sound when user wins level

        ShareQuestions_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = list.get(position).getQuestions() + "\n" +
                        "A :" + " " + list.get(position).getOptionA() + "\n" +
                        "B :" + " " + list.get(position).getOptionB() + "\n" +
                        "C :" + " " + list.get(position).getOptionC() + "\n" +
                        "D :" + " " + list.get(position).getOptionD();
                String shareSub = "Your subject here";
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });
        dialog = new Dialog(this, R.style.AnimateDialog);

        ////////////////////////////////////////////////////////////////////WORLD CLASS HISTORY QUESTIONS////////////////////  30 QUETIONS  ////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////ADD YOUR MULTIMEDIA WORLD CLASS QUESTIONS HERE////////////////////////////////////////////////////////////////////////////////////////
        list = new ArrayList<>();
        list.add(new questionsModelClass( "Which of the following is not a characteristic of a bureaucracy, as described by Max Weber?","Hierarchical structure","Formal rules and procedures","Flexible decision-making","Impersonal relationships","Flexible decision-making"));
        list.add(new questionsModelClass("Which of the following is not a type of decision-making environment?","Certainty","Risk","Complexity","Ambiguity","Complexity"));
        list.add(new questionsModelClass("Which of the following is not a function of organizational culture?","Providing stability and continuity","Shaping employee behavior","Limiting innovation and change","Enhancing organizational performance","Limiting innovation and change"));
        list.add(new questionsModelClass("Which of the following is not a characteristic of transformational leadership?","Inspirational motivation","Transactional exchanges","Idealized influence","Intellectual stimulation","Transactional exchanges"));
        list.add(new questionsModelClass("Which of the following is not a component of the communication process?","Encoding","Feedback","Hierarchy","Decoding","Hierarchy"));
        list.add(new questionsModelClass( "Which of the following is not a type of organizational change?","Incremental change","Radical change","Continuous change","Static change","Static change"));
        list.add(new questionsModelClass("Which of the following is not a factor influencing employee motivation, according to Herzberg's Two-Factor Theory?","Hygiene factors","Motivational factors","Social factors","Achievement","Social factors"));
        list.add(new questionsModelClass("Which of the following is not a component of the balanced scorecard?","Financial perspective","Customer perspective","Internal perspective","External perspective","External perspective"));
        list.add(new questionsModelClass("Which of the following is not a step in the strategic management process?","Strategy implementation","Strategy evaluation","Strategy formulation","Strategy elimination","Strategy elimination"));
        list.add(new questionsModelClass("Which of the following is not a type of organizational structure?","Flat","Tall","Diagonal","Circular","Circular"));
        list.add(new questionsModelClass("Which of the following is not a characteristic of effective leadership?","Adaptability","Authoritarianism","Integrity","Vision","Authoritarianism"));
        list.add(new questionsModelClass("Which of the following is not a stage of team development according to Tuckman's model?","Forming","Storming","Conforming","Performing","Conforming"));
        list.add(new questionsModelClass("Which of the following is not a component of the classical approach to management?","Scientific management","Administrative principles","Human relations","Bureaucratic organization","Human relations"));
        list.add(new questionsModelClass("Which of the following is not a principle of delegation?","Authority","Responsibility","Control","Accountability","Control"));
        list.add(new questionsModelClass("Which of the following is not a characteristic of a high-performance organization?","Clear goals and objectives","Silo mentality","Continuous improvement","Empowered employees","Silo mentality"));
        list.add(new questionsModelClass("Which of the following is not a type of control mechanism?","Feedforward control","Concurrent control","Feedback control","Sideways control","Sideways control"));
        list.add(new questionsModelClass("Which of the following is not a function of supply chain management?","Sourcing","Production","Sales","Distribution","Sales"));
        list.add(new questionsModelClass("Which of the following is not a characteristic of organizational behavior?","Multidisciplinary","Systematic","Focus on individual behavior only","Contingency-oriented","Focus on individual behavior only"));
        list.add(new questionsModelClass("Which of the following is not a type of leadership decision-making style?","Autocratic","Democratic","Laissez-faire","Authoritative","Authoritative"));
        list.add(new questionsModelClass("Which of the following is not a component of Porter's Five Forces model?","Threat of new entrants","Bargaining power of suppliers","Bargaining power of competitors","Threat of substitutes","Bargaining power of competitors"));
        list.add(new questionsModelClass( "Which of the following is not a function of project management?","Planning","Staffing","Monitoring and controlling","Closing","Staffing"));
        list.add(new questionsModelClass("Which of the following is not a characteristic of a learning organization?","Fixed mindset","Adaptability","Knowledge sharing","Experimentation","Fixed mindset"));
        list.add(new questionsModelClass("Which of the following is not a component of the SWOT analysis?","Strengths","Weaknesses","Opportunities","Transactions","Transactions"));
        list.add(new questionsModelClass("Which of the following is not a principle of total quality management?","Customer focus","Continuous improvement","Centralization","Employee involvement","Centralization"));
        list.add(new questionsModelClass("Which of the following is not a component of the marketing mix?","Product","Place","Positioning","Promotion","Positioning"));
        list.add(new questionsModelClass("Which of the following is not a stage of the product life cycle?","Introduction","Decline","Stabilization","Maturity","Stabilization"));
        list.add(new questionsModelClass("Which of the following is not a step in the negotiation process?","Preparation","Closing the deal","Postponing the decision","Bargaining","Postponing the decision"));
        list.add(new questionsModelClass("Which of the following is not a dimension of organizational structure?","Formalization","Centralization","Standardization","Collaboration","Collaboration"));
        list.add(new questionsModelClass( "Which of the following is not a component of the marketing environment?","Economic","Technological","Legal","Internal","Internal"));
        list.add(new questionsModelClass("Which of the following is not a type of organizational conflict?","Interpersonal conflict","Intrapersonal conflict","Intergroup conflict","Intra-organizational conflict ","Intrapersonal conflict"));

        for (int i = 0; i < 4; i++) {
            linearLayout1.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAns((Button) v);
                }
            });
        }

        txtQuestionsIndicator.setText(position + 1 + "/" + list.size());

        playAnim(txtQuestions, 0, list.get(position).getQuestions());
        Next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next_btn.setEnabled(false);
                Next_btn.setAlpha(0.7f);
                enableOptions(true);
                position++;
                if (position == list.size()) {
                    //Score Activities
                    if (score <= 9) {

                        Button try_again, share;
                        dialog.setContentView(R.layout.activity_fail_20_layout);
                        try_again = dialog.findViewById(R.id.try_again_btn);

                        level_lose.start();

                        try_again.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), ManagementWorldClass.class); //If User get 20% let him or her play again
                                startActivity(BG);
                            }
                        });
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    } else if (score <= 15) {

                        Button try_again, share;
                        dialog.setContentView(R.layout.activity_pass_50_layout);
                        try_again = dialog.findViewById(R.id.try_again_btn);
                        level_lose.start();

                        try_again.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), ManagementWorldClass.class); ///If User get 50% let him or her play again
                                startActivity(BG);
                            }
                        });

                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    } else if (score <= 29) {

                        Button promote_btn, share;
                        dialog.setContentView(R.layout.activity_pass_70_layout);
                        promote_btn = dialog.findViewById(R.id.nl_btn);


                        level_won.start();

                        promote_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), MenuHomeScreenActivity.class); ///If User get 70% let him to next category
                                startActivity(BG);
                            }
                        });

                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    } else if (score == 30) {

                        Button promote_btn, share;
                        dialog.setContentView(R.layout.activity_pass_100_layout);
                        promote_btn = dialog.findViewById(R.id.nl_btn);
                        level_won.start();

                        promote_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), MenuHomeScreenActivity.class); ///If User get 100% promote him or her to next category
                                startActivity(BG);
                            }
                        });
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    }
                    return;
                }

                count = 0;
                playAnim(txtQuestions, 0, list.get(position).getQuestions());
            }
        });

        navigationDrawer();
    }

    ///////////////////////////////////////////////////////////////////ANIMATING SCREEN/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void playAnim(final View view, final int value, final String data) {

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

                if (value == 0 && count < 4) {
                    String option = "";
                    if (count == 0) {
                        option = list.get(position).getOptionA();
                    } else if (count == 1) {
                        option = list.get(position).getOptionB();
                    } else if (count == 2) {
                        option = list.get(position).getOptionC();
                    } else if (count == 3) {
                        option = list.get(position).getOptionD();
                    }
                    playAnim(linearLayout1.getChildAt(count), 0, option);
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {

                if (value == 0) {

                    try {
                        ((TextView) view).setText(data);
                        txtQuestionsIndicator.setText(position + 1 + "/" + list.size());
                    } catch (ClassCastException ex) {
                        ((Button) view).setText(data);
                    }
                    view.setTag(data);


                    playAnim(view, 1, data);

                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    private void checkAns(Button selectedOptions) {
        enableOptions(false);
        Next_btn.setEnabled(true);
        Next_btn.setAlpha(1);
        if (selectedOptions.getText().toString().equals(list.get(position).getCorrectAnswer())) {
            //correct Answer
            score++;
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.ding);
            selectedOptions.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#14E39A")));
            mp.start();
        } else {
            //wrong Answer
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.wrong_buzzer);
            selectedOptions.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF2B55")));
            Button correctOption = linearLayout1.findViewWithTag(list.get(position).getCorrectAnswer());
            correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#14E39A")));

            mp.start();
        }
    }

    private void enableOptions(boolean enable) {
        for (int i = 0; i < 4; i++) {
            linearLayout1.getChildAt(i).setEnabled(enable);
            if (enable) {
                linearLayout1.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2133A0")));
            }
        }
    }


    ///////////////////////////////////////////////////////////////////ALL ABOUT NAVIGATION DRAWER/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void navigationDrawer() {

        //Navigation Drawer

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

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

        if (menuItem.getItemId() == R.id.home) {
            Intent home = new Intent(getApplicationContext(), MenuHomeScreenActivity.class);
            startActivity(home);
            ManagementWorldClass.super.onBackPressed();

        } else if (menuItem.getItemId() == R.id.rate) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=")));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.thedonuttech.tk")));
            }
        } else if (menuItem.getItemId() == R.id.user_profile) {
            Intent user_profile = new Intent(getApplicationContext(), UserProfileActivity.class);
            startActivity(user_profile);
        } else if (menuItem.getItemId() == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }
        return true;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

