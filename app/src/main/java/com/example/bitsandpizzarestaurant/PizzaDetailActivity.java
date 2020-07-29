package com.example.bitsandpizzarestaurant;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class PizzaDetailActivity extends Activity {

    private ShareActionProvider shareActionProvider;
    public static final String EXTRA_PIZZANO = "pizzaNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        int pizzano = (Integer) getIntent().getExtras().get(EXTRA_PIZZANO);
        String pizzaname = Pizza.pizzas[pizzano].getName();
        TextView textView = findViewById(R.id.pizzaTitleId);
        textView.setText(pizzaname);
        int pizzaImage =  Pizza.pizzas[pizzano].getImageResourceId();
        ImageView imageView = findViewById(R.id.pizzaImageId);
        imageView.setImageDrawable(getResources().getDrawable(pizzaImage));
        imageView.setContentDescription(pizzaname);

        int detail = Pizza.pizzas[pizzano].getDetails();

        TextView detailText = findViewById(R.id.pizzadetailText);

        detailText.setText(getResources().getText(detail));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        TextView textView = findViewById(R.id.pizzaTitleId);
        CharSequence pizzaName = textView.getText();
        MenuItem menuItem = menu.findItem(R.id.share_actionId);
        ShareActionProvider shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,pizzaName);
        shareActionProvider.setShareIntent(intent);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_create_orderId:
                Intent intent = new Intent(this,OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
