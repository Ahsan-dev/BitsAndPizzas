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

public class PastaDetailActivity extends Activity {

    private ShareActionProvider shareActionProvider;
    public static final String EXTRA_PASTANO = "pastaNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_detail);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        int pastaNo = (int) getIntent().getExtras().get(EXTRA_PASTANO);

        String pastaName = Pasta.pastas[pastaNo].getName();
        TextView textView = findViewById(R.id.pastaTitleId);
        textView.setText(pastaName);

        int pastaImageId = Pasta.pastas[pastaNo].getImageResourceId();

        ImageView imageView = findViewById(R.id.pastaImageId);
        imageView.setImageDrawable(getResources().getDrawable(pastaImageId));
        imageView.setContentDescription(pastaName);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        TextView textView = findViewById(R.id.pastaTitleId);
        CharSequence charSequence = textView.getText();
        MenuItem menuItem = menu.findItem(R.id.share_actionId);
        ShareActionProvider shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,charSequence);
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
