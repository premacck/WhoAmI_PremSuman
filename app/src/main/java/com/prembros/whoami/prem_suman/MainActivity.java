package com.prembros.whoami.prem_suman;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import io.codetail.animation.SupportAnimator;

import static io.codetail.animation.ViewAnimationUtils.createCircularReveal;

public class MainActivity extends AppCompatActivity implements FloatingActionMenu.OnClickListener {

    FloatingActionMenu floatingActionMenu;
    boolean hidden = true;
    boolean revealed = false;
    ActionBar ab;
    SupportAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ab = getSupportActionBar();

        floatingActionMenu = (FloatingActionMenu) findViewById(R.id.fab_menu);
        FloatingActionButton fab_call = (FloatingActionButton) findViewById(R.id.menu_item_1_call_me);
        FloatingActionButton fab_mail = (FloatingActionButton) findViewById(R.id.menu_item_2_mail_me);
        FloatingActionButton fab_certs = (FloatingActionButton) findViewById(R.id.menu_item_3_my_certifications);
        FloatingActionButton fab_academic = (FloatingActionButton) findViewById(R.id.menu_item_4_academic_reports);
        FloatingActionButton fab_social = (FloatingActionButton) findViewById(R.id.menu_item_5_social_handles);
        FloatingActionButton fab_cv = (FloatingActionButton) findViewById(R.id.menu_item_6_cv);

        fab_call.setOnClickListener(this);
        fab_mail.setOnClickListener(this);
        fab_certs.setOnClickListener(this);
        fab_academic.setOnClickListener(this);
        fab_social.setOnClickListener(this);
        fab_cv.setOnClickListener(this);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu_item_1_call_me:
                floatingActionMenu.close(true);
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+918233477967"));
                startActivity(Intent.createChooser(callIntent, "Choose an app to call"));
                break;
            case R.id.menu_item_2_mail_me:
                floatingActionMenu.close(true);
                Intent mailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "premsuman8@gmail.com", null));
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "I recently checked you out on WhoAmI");
                mailIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.mail_body_text));
                startActivity(Intent.createChooser(mailIntent, "Choose an email client"));
                break;
            case R.id.menu_item_3_my_certifications:
                addFragment(R.id.menu_item_3_my_certifications, "certificates");
                break;
            case R.id.menu_item_4_academic_reports:
                addFragment(R.id.menu_item_4_academic_reports, "marksheets");
                break;
            case R.id.menu_item_5_social_handles:
                addFragment(R.id.menu_item_5_social_handles, "social");
                break;
            case R.id.menu_item_6_cv:
                floatingActionMenu.close(true);
                break;
            default:
                break;
        }
    }

    public void addFragment(int resID, String which){
        animationForward(resID, (FrameLayout) findViewById(R.id.main_activity_fragment_container));
        ab.hide();
        floatingActionMenu.close(true);
        MainFragment mainFragment1 = new MainFragment();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Bundle args1 = new Bundle();
        args1.putString("param", which);
        mainFragment1.setArguments(args1);
        fragmentTransaction1.add(R.id.main_activity_fragment_container, mainFragment1, "webViewFragment").commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void animationForward(int resID, FrameLayout mRevealView){
        revealed = true;
//        fab.setBackgroundResource(R.drawable.rounded_cancel_button);
//        fab.setImageResource(R.drawable.ic_close);

        FloatingActionButton mActionView = (FloatingActionButton) findViewById(resID);
//        float pixelDensity = getResources().getDisplayMetrics().density;
        int centerX = (mActionView.getLeft() + mActionView.getRight()) / 2;
        int centerY = (mActionView.getTop() + mActionView.getBottom()) / 2;
        int startRadius = 0;
        int endRadius = (int) Math.hypot(mRevealView.getWidth(), mRevealView.getHeight());
        animator = createCircularReveal(mRevealView, centerX, centerY, startRadius, endRadius);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(400);
//                    animator.start();
        if (hidden){
            animator.start();
            mRevealView.setVisibility(View.VISIBLE);
            hidden = false;
        }
    }

    public void animationReversed(final FrameLayout mRevealView){
        if (animator != null && !animator.isRunning()){

//            fab.setBackgroundColor(Color.rgb(0, 188, 212));
//            fab.setImageResource(R.drawable.ic_add_shopping_cart);

            animator = animator.reverse();
            animator.addListener(new SupportAnimator.AnimatorListener() {
                @Override
                public void onAnimationStart() {

                }

                @Override
                public void onAnimationEnd() {
                    mRevealView.setVisibility(View.GONE);
                    hidden = true;
                    revealed = false;
                }

                @Override
                public void onAnimationCancel() {

                }

                @Override
                public void onAnimationRepeat() {

                }
            });
            animator.start();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (floatingActionMenu.isOpened()){
            floatingActionMenu.close(true);
        }
        else if (getSupportFragmentManager().findFragmentByTag("webViewFragment") != null){
            animationReversed((FrameLayout) findViewById(R.id.main_activity_fragment_container));
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .remove(getSupportFragmentManager().findFragmentByTag("webViewFragment"))
                    .commit();

            ab.show();
        }
        else super.onBackPressed();
    }
}
