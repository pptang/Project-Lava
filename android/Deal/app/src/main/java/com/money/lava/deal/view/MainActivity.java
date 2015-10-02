package com.money.lava.deal.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.money.lava.deal.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.main_container) != null) {
            if (savedInstanceState != null) return;

            WelcomeFragment welcomeFragment = new WelcomeFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, welcomeFragment).commit();
        }

        findWidgets();
    }

    private void findWidgets() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) setupDrawerContent(navigationView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.ic_menu);
            ab.setHomeAsUpIndicator(createMarkerIcon(drawable, "3", 100, 100));
            ab.setDisplayHomeAsUpEnabled(true);

        }

    }

    private Drawable createMarkerIcon(Drawable backgroundImage, String text,
                                      int width, int height) {

        Bitmap canvasBitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        // Create a canvas, that will draw on to canvasBitmap.
        Canvas imageCanvas = new Canvas(canvasBitmap);

        // Draw the image to our canvas
//        backgroundImage.draw(imageCanvas);

        Paint circlePaint = new Paint();
        circlePaint.setColor(getResources().getColor(android.R.color.holo_red_dark));
        imageCanvas.drawCircle(75, 25, 25, circlePaint);

        // Set up the paint for use with our Canvas
        Paint imagePaint = new Paint();
        imagePaint.setTextAlign(Paint.Align.CENTER);
        imagePaint.setTextSize(35f);
        imagePaint.setFakeBoldText(true);
        imagePaint.setColor(getResources().getColor(android.R.color.white));


        // Draw the text on top of our image
        imageCanvas.drawText(text, 75, 35, imagePaint);

        // Combine background and text to a LayerDrawable
        LayerDrawable layerDrawable = new LayerDrawable(
                new Drawable[]{backgroundImage, new BitmapDrawable(canvasBitmap)});
        return layerDrawable;

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                return false;
            }
        });
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    Fragment fragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            fragment = new WelcomeFragment();

                            break;
                        case R.id.nav_borrow:
                            fragment = new BorrowFragment();
                            break;
                        case R.id.nav_lend:
                            fragment = new LendFragment();
                            break;
                        case R.id.nav_deal:
                            fragment = new MyDealFragment();
                            break;
                    }
                    if (fragment != null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_container, fragment)
                                .addToBackStack(null)
                                .commit();
                        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
                    }
                    menuItem.setChecked(true);
                    mDrawerLayout.closeDrawers();
                    return true;

                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
