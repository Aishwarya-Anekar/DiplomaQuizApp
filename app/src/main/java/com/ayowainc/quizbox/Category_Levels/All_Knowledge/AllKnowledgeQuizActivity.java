package com.ayowainc.quizbox.Category_Levels.All_Knowledge;

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
import android.util.Log;
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
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class AllKnowledgeQuizActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button navToggler_btn, ShareQue_btn, Next_btn;
    LinearLayout linearLayout, linearLayout1;
    TextView txtQuestions, txtnumberIndicator;
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


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navToggler_btn = findViewById(R.id.action_menu_presenter);
        linearLayout = findViewById(R.id.main_content);
        linearLayout1 = findViewById(R.id.options_layout);
        txtQuestions = findViewById(R.id.question_view);
        txtnumberIndicator = findViewById(R.id.no_of_questions_view);
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

        ///////////////////////////////////////////////////////////////////// ADD YOUR QUESTIONS HERE FOR ALL KNOWLEDGE CATEGORY//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////ALL KNOWLEDGE QUESTIONS////////////////////  70 QUETIONS  ////////////////////////////////////////////////////////////////////
        list = new ArrayList<>();
        list.add(new questionsModelClass( "What technology is primarily responsible for the development of self-driving cars?","Artificial Intelligence","Blockchain","Virtual Reality","Quantum Computing","Artificial Intelligence"));
        list.add(new questionsModelClass( "Which technology enables the creation of decentralized applications (DApps) and smart contracts?","Machine Learning","Cloud Computing","Blockchain","Internet of Things (IoT)","Blockchain"));
        list.add(new questionsModelClass("What technology is used to analyze large sets of data to uncover patterns and insights?","Virtual Reality","Quantum Computing","Big Data Analytics","Augmented Reality","Big Data Analytics"));
        list.add(new questionsModelClass("Which technology aims to simulate human-like intelligence in machines?","Virtual Reality","Quantum Computing","Artificial Intelligence","Edge Computing","Artificial Intelligence"));
        list.add(new questionsModelClass("What technology allows devices to communicate and exchange data over the internet?","Internet of Things (IoT)","Augmented Reality","Edge Computing","Cloud Computing","Internet of Things (IoT)"));
        list.add(new questionsModelClass("Which technology focuses on improving the efficiency and speed of data processing by processing data closer to the source?","Edge Computing","Quantum Computing","Blockchain","Virtual Reality","Edge Computing"));
        list.add(new questionsModelClass("What technology involves the creation of immersive, computer-generated environments?","Augmented Reality","Virtual Reality","Artificial Intelligence","Machine Learning","Virtual Reality"));
        list.add(new questionsModelClass("Which technology aims to enhance the security and transparency of digital transactions?","Quantum Computing","Big Data Analytics","Blockchain","Internet of Things (IoT)","Blockchain"));
        list.add(new questionsModelClass( "What technology focuses on enabling devices to make decisions and perform tasks without human intervention?","Machine Learning","Cloud Computing","Edge Computing","Artificial Intelligence","Artificial Intelligence"));
        list.add(new questionsModelClass("Which technology has the potential to revolutionize encryption and data security?","Blockchain","Quantum Computing","Augmented Reality","Big Data Analytics","Quantum Computing"));


        list.add(new questionsModelClass( "What technology aims to simulate human-like intelligence in machines?","Virtual Reality","Quantum Computing","Artificial Intelligence","Edge Computing","Artificial Intelligence"));
        list.add(new questionsModelClass("Which subfield of AI focuses on enabling computers to understand, interpret, and generate human-like language?","Machine Learning","Natural Language Processing (NLP)","Robotics","Computer Vision","Natural Language Processing (NLP)"));
        list.add(new questionsModelClass("What technology enables the creation of secure, tamper-proof records of transactions?","Augmented Reality","Quantum Computing","Big Data Analytics","Blockchain","Blockchain"));
        list.add(new questionsModelClass( "Which consensus mechanism is commonly used in blockchain networks to validate transactions without the need for a central authority?","Proof of Work (PoW)","Proof of Stake (PoS)","Proof of Authority (PoA)","Proof of Concept (PoC)","Proof of Work (PoW)"));
        list.add(new questionsModelClass("What technology focuses on the development of interconnected devices and systems that communicate with each other?","Quantum Computing","Internet of Things (IoT)","Big Data Analytics","Cloud Computing","Internet of Things (IoT)"));
        list.add(new questionsModelClass("Which wireless communication protocol is commonly used for IoT devices due to its low power consumption and long-range capability?","Bluetooth","Wi-Fi","Zigbee","NFC","Zigbee"));
        list.add(new questionsModelClass( "What technology involves the analysis of large and complex datasets to uncover patterns and insights?","Machine Learning","Augmented Reality","Big Data Analytics","Edge Computing","Big Data Analytics"));
        list.add(new questionsModelClass("Which programming language is commonly used for processing and analyzing big data?","Java","Python","C++","Ruby","Python"));
        list.add(new questionsModelClass("What technology involves the use of algorithms and statistical models to perform tasks without explicit programming?","Edge Computing","Blockchain","Machine Learning","Virtual Reality","Machine Learning"));
        list.add(new questionsModelClass("Which type of machine learning algorithm is suitable for identifying patterns in unlabeled data?","Supervised Learning","Unsupervised Learning","Reinforcement Learning","Deep Learning","Unsupervised Learning"));
        list.add(new questionsModelClass( "What technology involves the integration of digital information with the user's environment in real-time?","Augmented Reality","Cloud Computing","Artificial Intelligence","Edge Computing","Augmented Reality"));
        list.add(new questionsModelClass( "Which technology allows for the creation of immersive, computer-generated environments?","Augmented Reality","Virtual Reality","Artificial Intelligence","Machine Learning","Virtual Reality"));
        list.add(new questionsModelClass("What technology focuses on processing and analyzing data at the edge of the network, closer to the data source?","Edge Computing","Big Data Analytics","Quantum Computing","Internet of Things (IoT)","Edge Computing"));
        list.add(new questionsModelClass( "Which benefit of edge computing improves response time and reduces latency for critical applications?","Scalability","Security","Low Latency","Cost Reduction","Low Latency"));
        list.add(new questionsModelClass("What technology involves the use of quantum-mechanical phenomena to perform computation tasks?","Quantum Computing","Machine Learning","Edge Computing","Big Data Analytics","Quantum Computing"));
        list.add(new questionsModelClass( "Which characteristic of quantum computing allows it to perform calculations much faster than classical computers for certain types of problems","Superposition","Entanglement","Interference","Qubit","Entanglement"));

        list.add(new questionsModelClass( "What technology allows for the delivery of computing services over the internet, including storage, databases, and servers?","Cloud Computing","Blockchain","Artificial Intelligence","Internet of Things (IoT)","Cloud Computing"));
        list.add(new questionsModelClass("Which cloud computing service model provides access to virtualized computing resources over the internet on a pay-as-you-go basis?","Infrastructure as a Service (IaaS)","Platform as a Service (PaaS)","Software as a Service (SaaS)","Function as a Service (FaaS)","Infrastructure as a Service (IaaS)"));
        list.add(new questionsModelClass("What technology focuses on protecting computer systems, networks, and data from unauthorized access or attacks?","Augmented Reality","Quantum Computing","Cybersecurity","Big Data Analytics","Cybersecurity"));
        list.add(new questionsModelClass("Which type of cyber attack involves tricking individuals into revealing sensitive information such as passwords or financial details?","Phishing","DDoS Attack","Ransomware","Malware","Phishing"));
        list.add(new questionsModelClass("What technology promises faster data speeds, lower latency, and greater capacity for wireless networks?","4G LTE","5G Technology","Wi-Fi 6","Bluetooth","5G Technology"));
        list.add(new questionsModelClass("Which feature of 5G technology enables simultaneous connections to multiple devices with varying bandwidth requirements?","High Bandwidth","Massive Connectivity","Low Latency","Network Slicing","Network Slicing"));
        list.add(new questionsModelClass("What technology involves the use of unique physical or behavioral characteristics for user authentication?","Blockchain","Artificial Intelligence","Biometric Authentication","Edge Computing","Biometric Authentication"));
        list.add(new questionsModelClass("Which biometric modality identifies individuals based on their facial features?","Fingerprint Recognition","Facial Recognition","Iris Recognition","Voice Recognition","Facial Recognition"));
        list.add(new questionsModelClass("What technology involves the deployment of artificial intelligence algorithms directly onto edge devices?","Cloud Computing","Quantum Computing","Edge AI","Internet of Things (IoT)","Edge AI"));
        list.add(new questionsModelClass("Which advantage of edge AI improves privacy by processing data locally on devices without sending it to centralized servers?","Low Latency","Cost Reduction","Privacy Protection","Scalability","Privacy Protection"));
        list.add(new questionsModelClass("What technology enables employees to work from locations outside of the traditional office environment?","Remote Work Technology","Virtual Reality","Augmented Reality","Edge Computing","Remote Work Technology"));
        list.add(new questionsModelClass("Which tool facilitates real-time communication and collaboration among remote team members through instant messaging, video conferencing, and file sharing?","Virtual Private Network (VPN)","Project Management Software","Video Conferencing Software","Remote Desktop Protocol (RDP)","Video Conferencing Software"));
        list.add(new questionsModelClass(  "What technology focuses on safeguarding internet-connected systems and data from cyber threats?","Internet Security","Blockchain","Artificial Intelligence","Big Data Analytics","Internet Security"));
        list.add(new questionsModelClass( "Which measure of internet security involves verifying the identity of users and granting them access to specific resources or systems?","Encryption","Authentication","Authorization","Firewall","Authentication"));

        list.add(new questionsModelClass("What technology aims to create a global network based on the principles of quantum mechanics for secure communication?","Quantum Computing","Quantum Internet","5G Technology","Blockchain","Quantum Internet"));
        list.add(new questionsModelClass( "Which property of quantum communication allows for the transmission of information with absolute security?","Superposition","Entanglement","Interference","Qubit","Entanglement"));
        list.add(new questionsModelClass(  "What technology involves the creation of virtual representations of physical objects, processes, or systems?","Digital Twins","Artificial Intelligence","Big Data Analytics","Internet of Things (IoT)","Digital Twins"));
        list.add(new questionsModelClass("Which industry commonly uses digital twins for simulation, optimization, and predictive maintenance of equipment and assets?","Healthcare","Manufacturing","Retail","Education","Manufacturing"));
        list.add(new questionsModelClass( "What technology involves the use of software robots to automate repetitive tasks and business processes?","Virtual Reality","Robotic Process Automation (RPA)","Artificial Intelligence","Edge Computing","Robotic Process Automation (RPA)"));
        list.add(new questionsModelClass("Which benefit of RPA increases operational efficiency by reducing errors and processing time in business workflows?","Cost Reduction","Scalability","Accuracy","Flexibility","Accuracy"));
        list.add(new questionsModelClass("What term refers to unstructured or untapped data that organizations collect but do not use for analysis or decision-making?","Dark Data","Open Data","Big Data","Metadata","Dark Data"));
        list.add(new questionsModelClass("Which challenge associated with dark data highlights the potential risk of data breaches and compliance violations?","Data Silos","Data Privacy","Data Quality","Data Governance","Data Privacy"));
        list.add(new questionsModelClass("What term encompasses the spectrum of immersive technologies, including virtual reality (VR), augmented reality (AR), and mixed reality (MR)?","Extended Reality (XR)","Quantum Computing","Cloud Computing","Natural Language Processing (NLP)","Extended Reality (XR)"));
        list.add(new questionsModelClass( "Which application of extended reality allows users to interact with digital objects overlaid onto the real world in real-time?","Virtual Reality (VR)","Augmented Reality (AR)","Mixed Reality (MR)","Artificial Reality (AR)","Augmented Reality (AR)"));

         for (int i = 0; i < 4; i++) {
            linearLayout1.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAns((Button) v);
                }
            });
        }

        txtnumberIndicator.setText(position + 1 + "/" + list.size());

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
                    if (score <= 30) {

                        Button try_again, share;
                        dialog.setContentView(R.layout.activity_fail_20_layout);
                        try_again = dialog.findViewById(R.id.try_again_btn);

                        level_lose.start();

                        try_again.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), AllKnowledgeQuizActivity.class); //If User get 20% let him or her play again
                                startActivity(BG);
                                finish();
                            }
                        });
                        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    } else if (score <= 50) {

                        Button try_again, share;
                        dialog.setContentView(R.layout.activity_pass_50_layout);
                        try_again = dialog.findViewById(R.id.try_again_btn);
                        level_lose.start();

                        try_again.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), AllKnowledgeQuizActivity.class); ///If User get 50% let him or her play again
                                startActivity(BG);
                                finish();
                            }
                        });

                        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    } else if (score <= 69) {

                        Button promote_btn, share;
                        dialog.setContentView(R.layout.activity_pass_70_layout);
                        promote_btn = dialog.findViewById(R.id.nl_btn);

                        level_won.start();

                        promote_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent BG = new Intent(getApplicationContext(), MenuHomeScreenActivity.class); ///If User get 70% let him to next category
                                startActivity(BG);
                                finish();
                            }
                        });

                        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    } else if (score == 70) {

                        Button promote_btn, share;
                        dialog.setContentView(R.layout.activity_pass_100_layout);
                        promote_btn = dialog.findViewById(R.id.nl_btn);
//                       share = dialog.findViewById(R.id.share_btn);

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

            @SuppressLint("SetTextI18n")
            @Override
            public void onAnimationEnd(Animator animation) {

                if (value == 0) {

                    try {
                        ((TextView) view).setText(data);
                        txtnumberIndicator.setText(position + 1 + "/" + list.size());
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
            AllKnowledgeQuizActivity.super.onBackPressed();

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

