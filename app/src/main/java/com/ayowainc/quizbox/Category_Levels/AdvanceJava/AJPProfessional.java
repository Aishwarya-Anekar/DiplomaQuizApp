package com.ayowainc.quizbox.Category_Levels.AdvanceJava;

import android.animation.Animator;
import android.annotation.SuppressLint;
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
import java.util.Objects;

public class AJPProfessional extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button navToggler_btn, ShareQue_btn, Next_btn;
    LinearLayout content, options_Container;
    TextView Questions, questions_no_indicator;
    Dialog dialog;
    private int count = 0;
    private int position = 0;
    private List<questionsModelClass> list;
    private int score = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); ///Eneter into fullscreen mode
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_questions_view);

        //All Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navToggler_btn = findViewById(R.id.action_menu_presenter);
        content = findViewById(R.id.main_content);
        options_Container = findViewById(R.id.options_layout);
        Questions = findViewById(R.id.question_view);
        questions_no_indicator = findViewById(R.id.no_of_questions_view);
        ShareQue_btn = findViewById(R.id.share_que_btn);
        Next_btn = findViewById(R.id.next_btn);

        final MediaPlayer level_lose = MediaPlayer.create(this, R.raw.level_lose);///Play sound when user loses level
        final MediaPlayer level_won = MediaPlayer.create(this, R.raw.applause_wav);///Play sound when user wins level

        ShareQue_btn.setOnClickListener(new View.OnClickListener() {
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


        list = new ArrayList<>();

        ///////////////////////////////////////////////////////////////////// ADD YOUR QUESTIONS HERE FOR HISTORY PROFESSIONAL CATEGORY////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////PROFESSIONAL HISTORY QUESTIONS////////////////////////////////////////////////////////////////////////////////////////
        list.add(new questionsModelClass( "What is the purpose of the setPreferredSize() method in Java Swing?" ,"To set the preferred size of a component" ,"To set the minimum size of a component" ,"To set the maximum size of a component" ,"To set the initial size of a component" ,"To set the preferred size of a component"));
        list.add(new questionsModelClass("Which layout manager allows components to be aligned horizontally or vertically?" ,"BorderLayout" ,"FlowLayout" ,"BoxLayout" ,"GridLayout" ,"BoxLayout"));
        list.add(new questionsModelClass("Which method is used to display a message dialog in Java Swing?" ,"showMessageDialog()" ,"showInputDialog()" ,"showConfirmDialog()" ,"showOptionDialog()" ,"showMessageDialog()"));
        list.add(new questionsModelClass( "What is the purpose of the setBackground() method in Java Swing?" ,"To set the background color of a frame" ,"To set the background color of a component" ,"To set the background image of a frame" ,"To set the background image of a component" ,"To set the background color of a component"));
        list.add(new questionsModelClass(    "Which Swing component is used to create a slider?" ,"JSlider" ,"JScrollBar" ,"JProgressBar" ,"JSpinner" ,"JSlider"));
        list.add(new questionsModelClass("What is the purpose of the setEnabled() method in Java Swing?" ,"To enable or disable a component" ,"To set the enabled state of a frame" ,"To set the enabled state of a window" ,"To enable or disable a layout manager" ,"To enable or disable a component"));
        list.add(new questionsModelClass("Which method is used to add a menu to a JFrame in Java Swing?" ,"addMenu()" ,"addMenuBar()" ,"setMenu()" ,"setJMenuBar()" ,"setJMenuBar()"));
        list.add(new questionsModelClass("What is the purpose of the setIcon() method in Java Swing?" ,"To set the icon of a frame" ,"To set the icon of a component" ,"To set the icon of a button" ,"To set the icon of a label" ,"To set the icon of a component"));
        list.add(new questionsModelClass("Which Swing component is used to create a menu?" ,"JMenu" ,"JMenuItem" ,"JMenuBar" ,"JPopupMenu" ,"JMenu"));
        list.add(new questionsModelClass("What is the purpose of the setToolTipText() method in Java Swing?" ,"To set the text of a tooltip" ,"To set the text of a label" ,"To set the text of a button" ,"To set the text of a menu item" ,"To set the text of a tooltip"));
        list.add(new questionsModelClass("Which method is used to add an action listener to a button in Java Swing?" ,"addButtonListener()" ,"addActionListener()" ,"addClickListener()" ,"addMouseListener()" ,"addActionListener()"));
        list.add(new questionsModelClass( "What is the purpose of the setOpaque() method in Java Swing?" ,"To set the opacity of a frame" ,"To set the opacity of a component" ,"To set the opacity of a button" ,"To set the opacity of a label" ,"To set the opacity of a component"));
        list.add(new questionsModelClass("Which Swing component is used to create a tabbed pane?" ,"JTabbedPane" ,"JTabComponent" ,"JTabPanel" ,"JTabContainer" ,"JTabbedPane"));
        list.add(new questionsModelClass("What is the purpose of the setBorder() method in Java Swing?" ,"To set the border of a frame" ,"To set the border of a component" ,"To set the border of a button" ,"To set the border of a label" ,"To set the border of a component"));
        list.add(new questionsModelClass("Which method is used to add an action listener to a menu item in Java Swing?" ,"addActionListener()" ,"addItemListener()" ,"addMenuListener()" ,"addMouseListener()" ,"addActionListener()"));
        list.add(new questionsModelClass("What layout manager is used to position components at specific coordinates within a container?" ,"BorderLayout" ,"FlowLayout" ,"GridLayout" ,"AbsoluteLayout" ,"AbsoluteLayout"));
        list.add(new questionsModelClass( "Which Swing component is used to display a tooltip for another component?" ,"JToolTip" ,"JPopup" ,"JDialog" ,"JOptionPane" ,"JToolTip"));
        list.add(new questionsModelClass("What event listener interface should be implemented to handle mouse clicks on a button in Java Swing?" ,"ActionListener" ,"MouseListener" ,"ActionListener" ,"KeyListener" ,"ActionListener"));
        list.add(new questionsModelClass("What method is used to set the text of a JLabel in Java Swing?" ,"setText()" ,"setLabel()" ,"setCaption()" ,"setTitle()" ,"setText()"));
        list.add(new questionsModelClass("Which event listener interface is used to handle changes in the state of a checkbox in Java Swing?" ,"ActionListener" ,"MouseListener" ,"ItemListener" ,"CheckboxListener" ,"ItemListener"));

        for (int i = 0; i < 4; i++) {
            options_Container.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAns((Button) v);
                }
            });
        }
        questions_no_indicator.setText(position + 1 + "/" + list.size());

        playAnim(Questions, 0, list.get(position).getQuestions());
        Next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next_btn.setEnabled(false);
                Next_btn.setAlpha(0.7f);
                enableOptions(true);
                position++;
                if (position == list.size()) {
                    if (score <= 7) {

                        Button try_again, share;
                        dialog.setContentView(R.layout.activity_fail_20_layout);
                        try_again = dialog.findViewById(R.id.try_again_btn);
                        level_lose.start();

                        try_again.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), AJPProfessional.class); //If User get 20% let him or her play again
                                startActivity(BG);
                            }
                        });

                        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    } else if (score <= 12) {

                        Button try_again, share;
                        dialog.setContentView(R.layout.activity_pass_50_layout);
                        try_again = dialog.findViewById(R.id.try_again_btn);
                        level_lose.start();

                        try_again.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), AJPProfessional.class); ///If User get 50% let him or her play again
                                startActivity(BG);
                            }
                        });
                        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    } else if (score <= 19) {

                        Button promote_btn, share;
                        dialog.setContentView(R.layout.activity_pass_70_layout);
                        promote_btn = dialog.findViewById(R.id.nl_btn);
//                        share = dialog.findViewById(R.id.share_btn);

                        level_won.start();

                        promote_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), AJPProfessional.class); ///If User get 70% let him to next level
                                startActivity(BG);
                            }
                        });

                        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    } else if (score == 20) {

                        Button promote_btn, share;
                        dialog.setContentView(R.layout.activity_pass_100_layout);
                        promote_btn = dialog.findViewById(R.id.nl_btn);
//                        share = dialog.findViewById(R.id.share_btn);

                        level_won.start();

                        promote_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), AJPProfessional.class); ///If User get 100% promote him or her to next level
                                startActivity(BG);
                            }
                        });


                        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.onBackPressed();
                        dialog.show();
                    }
                    return;
                }

                count = 0;
                playAnim(Questions, 0, list.get(position).getQuestions());
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
                    playAnim(options_Container.getChildAt(count), 0, option);
                    count++;
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onAnimationEnd(Animator animation) {

                if (value == 0) {

                    try {
                        ((TextView) view).setText(data);
                        questions_no_indicator.setText(position + 1 + "/" + list.size());
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
            Button correctOption = options_Container.findViewWithTag(list.get(position).getCorrectAnswer());
            correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#14E39A")));

            mp.start();
        }
    }

    private void enableOptions(boolean enable) {
        for (int i = 0; i < 4; i++) {
            options_Container.getChildAt(i).setEnabled(enable);
            if (enable) {
                options_Container.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2133A0")));
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
                content.setScaleX(offsetScale);
                content.setScaleY(offsetScale);


                final float xOffset = drawerView.getWidth()*slideOffset;
                final float xOffsetDiff = content.getWidth()*diffScaledOffset/2;
                final float xTranslation = xOffset - xOffsetDiff;
                content.setTranslationX(xTranslation);

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
            AJPProfessional.super.onBackPressed();

        } else if (menuItem.getItemId() == R.id.rate) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=")));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.elifcoding.blogspot.com")));
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

