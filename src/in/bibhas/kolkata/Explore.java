package in.bibhas.kolkata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Explore extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void viewTaxiFare(View view){
    	Intent TaxiFare = new Intent(view.getContext(), FindTaxiFare.class);
    	startActivity(TaxiFare);
    }
    
    public void viewPlaces(View view){
    	Intent IntentFindPlace = new Intent(view.getContext(), FindPlace.class);
    	startActivity(IntentFindPlace);
    }
}