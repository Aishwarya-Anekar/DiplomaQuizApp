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

public class AJPWorldclass extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button navToggler_btn, ShareQue_btn, Next_btn;
    LinearLayout linearLayout, linearlayout1;
    TextView txtQuestions, txtQuestionIndicator;
    Dialog dialog;
    private int count = 0;
    private int position = 0;
    private List<questionsModelClass> list;
    private int score = 0;
//    private InterstitialAd mInterstitialAd;


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
        linearLayout = findViewById(R.id.main_content);
        linearlayout1 = findViewById(R.id.options_layout);
        txtQuestions = findViewById(R.id.question_view);
        txtQuestionIndicator = findViewById(R.id.no_of_questions_view);
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


        ////////////////////////////////////////////////////////////////////WORLD CLASS HISTORY QUESTIONS////////////////////  30 QUETIONS  ////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////ADD YOUR HISTORY WORLD CLASS HERE////////////////////////////////////////////////////////////////////////////////////////
        list = new ArrayList<>();
        list.add(new questionsModelClass("What is the purpose of the setEnabled() method in Java Swing?" ,"To enable or disable a component" ,"To set the enabled state of a frame" ,"To set the enabled state of a window" ,"To enable or disable a layout manager" ,"To enable or disable a component"));
        list.add(new questionsModelClass("Which method is used to add a menu item to a menu in Java Swing?" ,"addItem()" ,"addMenuItem()" ,"add()" ,"addMenuItem()" ,"add()"));
        list.add(new questionsModelClass("What is the purpose of the setToolTipText() method in Java Swing?" ,"To set the text of a tooltip" ,"To set the text of a label" ,"To set the text of a button" ,"To set the text of a menu item" ,"To set the text of a tooltip"));
        list.add(new questionsModelClass("Which Swing component is used to create a scrollable list of items?" ,"JList" ,"JScrollPane" ,"JScrollList" ,"JScrollPane" ,"JScrollPane"));
        list.add(new questionsModelClass("What method is used to set the font of a component in Java Swing?" ,"setFont()" ,"setStyle()" ,"setFontStyle()" ,"setComponentFont()" ,"setFont()"));
        list.add(new questionsModelClass("What is the purpose of the setVisible() method in Java Swing?" ,"To set the visibility of a component" ,"To set the visibility of a frame" ,"To set the visibility of a window" ,"To set the visibility of a layout manager" ,"To set the visibility of a component"));
        list.add(new questionsModelClass("Which Swing component is used to create a progress bar?" ,"JProgressBar" ,"JStatus" ,"JProgress" ,"JStatusBar" ,"JProgressBar"));
        list.add(new questionsModelClass("What method is used to set the background color of a component in Java Swing?" ,"setBackground()" ,"setBGColor()" ,"setBackColor()" ,"setComponentColor()" ,"setBackground()"));
        list.add(new questionsModelClass( "Which event listener interface is used to handle changes in the state of a radio button in Java Swing?" ,"ActionListener" ,"ItemListener" ,"RadioButtonListener" ,"RadioListener" ,"ItemListener"));
        list.add(new questionsModelClass( "What is the purpose of the setResizable() method in Java Swing?" ,"To set the size of a component" ,"To set the size of a frame" ,"To set the resizable state of a frame" ,"To set the resizable state of a component" ,"To set the resizable state of a frame"));
        list.add(new questionsModelClass("Which Swing component is used to create a combo box?" ,"JComboBox" ,"JDropDown" ,"JCombo" ,"JSelection" ,"JComboBox"));
        list.add(new questionsModelClass("What method is used to add a change listener to a tabbed pane in Java Swing?" ,"addChangeListener()" ,"addActionListener()" ,"addTabChangeListener()" ,"addTabListener()" ,"addChangeListener()"));
        list.add(new questionsModelClass( "What is the purpose of the setHorizontalAlignment() method in Java Swing?" ,"To set the horizontal alignment of text in a component" ,"To set the horizontal alignment of a component within its container" ,"To set the horizontal alignment of a frame" ,"To set the horizontal alignment of a window" ,"To set the horizontal alignment of text in a component"));
        list.add(new questionsModelClass("Which Swing component is used to create a menu bar?" ,"JMenuBar" ,"JMenu" ,"JMenuItem" ,"JPopupMenu" ,"JMenuBar"));
        list.add(new questionsModelClass("What method is used to add a component to a tabbed pane in Java Swing?" ,"addTab()" ,"addComponent()" ,"addComponentToTab()" ,"add()" ,"addTab()"));
        list.add(new questionsModelClass("What is the purpose of the setPreferredSize() method in Java Swing?" ,"To set the preferred size of a component" ,"To set the minimum size of a component" ,"To set the maximum size of a component" ,"To set the initial size of a component" ,"To set the preferred size of a component"));
        list.add(new questionsModelClass("Which Swing component is used to create a container for other components with a border?" ,"JPanel" ,"JFrame" ,"JContainer" ,"JBorder" ,"JPanel"));
        list.add(new questionsModelClass("What is the purpose of the setVerticalAlignment() method in Java Swing?" ,"To set the vertical alignment of text in a component" ,"To set the vertical alignment of a component within its container" ,"To set the vertical alignment of a frame" ,"To set the vertical alignment of a window" ,"To set the vertical alignment of a component within its container"));
        list.add(new questionsModelClass("Which method is used to add a component to a toolbar in Java Swing?" ,"addToToolbar()" ,"addComponent()" ,"add()" ,"addToBar()" ,"add()"));
        list.add(new questionsModelClass( "What is the purpose of the setBorder() method in Java Swing?" ,"To set the border of a frame" ,"To set the border of a component" ,"To set the border of a menu item" ,"To set the border of a dialog box" ,"To set the border of a component"));
        list.add(new questionsModelClass("Which Swing component is used to create a multi-line text input area?" ,"JTextArea" ,"JTextField" ,"JTextPane" ,"JEditorPane" ,"JTextArea"));
        list.add(new questionsModelClass("What method is used to add an icon to a button in Java Swing?" ,"setIcon()" ,"addIcon()" ,"setButtonIcon()" ,"addButtonIcon()" ,"setIcon()"));
        list.add(new questionsModelClass( "What is the purpose of the setBackground() method in Java Swing?" ,"To set the background color of a frame" ,"To set the background color of a component" ,"To set the background color of a menu item" ,"To set the background color of a dialog box" ,"To set the background color of a component"));
        list.add(new questionsModelClass("Which Swing component is used to create a menu item separator?" ,"JSeparator" ,"JSeparatorMenuItem" ,"JMenuItemSeparator" ,"JMenuSeparator" ,"JSeparator"));
        list.add(new questionsModelClass("What method is used to set the layout manager for a container in Java Swing?" ,"setLayoutManager()" ,"setLayout()" ,"setContainerLayout()" ,"setContainerManager()" ,"setLayout()"));
        list.add(new questionsModelClass( "What is the purpose of the setMinimumSize() method in Java Swing?" ,"To set the minimum size of a component" ,"To set the minimum size of a frame" ,"To set the minimum size of a window" ,"To set the minimum size of a layout manager" ,"To set the minimum size of a component"));
        list.add(new questionsModelClass( "Which Swing component is used to create a label with an icon?" ,"JLabel" ,"ImageIcon" ,"IconLabel" ,"ImageLabel" ,"JLabel"));
        list.add(new questionsModelClass("In which country are you most likely to die from a scorpion sting", "Mexico", "Argentina", "Colombia", "Peru", "Mexico"));
        list.add(new questionsModelClass("Which Swing component is used to display formatted text with styles and attributes?" ,"JTextArea" ,"JTextField" ,"JTextPane" ,"JEditorPane" ,"JTextPane"));
        list.add(new questionsModelClass( "What layout manager is commonly used to arrange components vertically or horizontally in a single line?" ,"BorderLayout" ,"FlowLayout" ,"GridLayout","BoxLayout" ,"FlowLayout"));
        list.add(new questionsModelClass( "Which event listener interface is used to handle mouse movement over a component in Java Swing?" ,"MouseListener","MouseMotionListener" ,"ActionListener" ,"KeyListener","MouseMotionListener"));
        list.add(new questionsModelClass("What method is used to add an item to a combo box in Java Swing?" ,"addItem()" ,"add()" ,"addComponent()" ,"addComboItem()" ,"addItem()"));
        list.add(new questionsModelClass("What is the purpose of the setToolTipText() method in Java Swing?" ,"To set the text of a tooltip" ,"To set the text of a label" ,"To set the text of a button" ,"To set the text of a menu item" ,"To set the text of a tooltip"));
        list.add(new questionsModelClass("Which Swing component is used to create a slider that allows selecting a range of values?" ,"JSlider" ,"JScrollBar" ,"JRangeSlider" ,"JSpinSlider" ,"JRangeSlider"));
        list.add(new questionsModelClass("What method is used to add a change listener to a spinner component in Java Swing?" ,"addChangeListener()" ,"addActionListener()" ,"addSpinnerListener()" ,"addValueListener()" ,"addChangeListener()"));
        list.add(new questionsModelClass( "What is the purpose of the setIcon() method in Java Swing?" ,"To set the icon of a frame" ,"To set the icon of a component","To set the icon of a button" ,"To set the icon of a label" ,"To set the icon of a component"));
        list.add(new questionsModelClass( "Which Swing component is used to create a menu item with an icon?" ,"JMenuItem" ,"JMenuIcon" ,"JMenuItemIcon" ,"JIconMenuItem" ,"JMenuItem"));
        list.add(new questionsModelClass("What method is used to set the font of a component in Java Swing?" ,"setFont()" ,"setStyle()" ,"setFontStyle()" ,"setComponentFont()","setFont()"));
        list.add(new questionsModelClass( "What is the purpose of the setVisible() method in Java Swing?" ,"To set the visibility of a component" ,"To set the visibility of a frame" ,"To set the visibility of a window" ,"To set the visibility of a layout manager" ,"To set the visibility of a component"));
        list.add(new questionsModelClass("Which Swing component is used to create a panel that contains a scrollbar?" ,"JScrollPanel" ,"JScrollPane" ,"JScrollBarPanel" ,"JScrollBarPane" ,"JScrollPane"));


        for (int i = 0; i < 4; i++) {
            linearlayout1.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAns((Button) v);
                }
            });
        }

        txtQuestionIndicator.setText(position + 1 + "/" + list.size());

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
//                        share = dialog.findViewById(R.id.share_btn);

                        level_lose.start();

                        try_again.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), AJPWorldclass.class); //If User get 20% let him or her play again
                                startActivity(BG);
                            }
                        });

                        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    } else if (score <= 15) {

                        Button try_again, share;
                        dialog.setContentView(R.layout.activity_pass_50_layout);
                        try_again = dialog.findViewById(R.id.try_again_btn);

                        level_lose.start();

                        try_again.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), AJPWorldclass.class); ///If User get 50% let him or her play again
                                startActivity(BG);
                            }
                        });


                        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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

                        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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
                        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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
                    playAnim(linearlayout1.getChildAt(count), 0, option);
                    count++;
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onAnimationEnd(Animator animation) {

                if (value == 0) {

                    try {
                        ((TextView) view).setText(data);
                        txtQuestionIndicator.setText(position + 1 + "/" + list.size());
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
            Button correctOption = linearlayout1.findViewWithTag(list.get(position).getCorrectAnswer());
            correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#14E39A")));

            mp.start();
        }
    }

    private void enableOptions(boolean enable) {
        for (int i = 0; i < 4; i++) {
            linearlayout1.getChildAt(i).setEnabled(enable);
            if (enable) {
                linearlayout1.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2133A0")));
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
            AJPWorldclass.super.onBackPressed();

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

