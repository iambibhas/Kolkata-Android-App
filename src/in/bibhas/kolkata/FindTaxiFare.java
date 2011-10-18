package in.bibhas.kolkata;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class FindTaxiFare extends Activity {
	
	private RadioButton rbtn_bykm, rbtn_bymeter;
	private TextView txt_result, txt_num;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taxi_fare);
        
        rbtn_bykm = (RadioButton) findViewById(R.id.radioByKm);
        rbtn_bymeter = (RadioButton) findViewById(R.id.radioByMeter);
        txt_result = (TextView) findViewById(R.id.textViewResult);
        txt_num = (TextView) findViewById(R.id.editTextKmMeter);
    }
	
	public void calculateFare(View view){
		double dbl_num;
		double result = 0.00;
		if(txt_num.getText().toString().equals("")){
			txt_result.setText("Please Enter a Number.");
			return;
		}else{
			Float num = new Float(txt_num.getText().toString());
			dbl_num = num.doubleValue();
		}
		
		try{			
			if(rbtn_bykm.isChecked()){
				result = 10 + (dbl_num-1)*5;
				result = result*2 + 2;
			}else if(rbtn_bymeter.isChecked()){
				if(dbl_num<10){
					notify("Meter reading cannot be less than 10.00 .");
					return;
				}else{
					result = dbl_num*2 + 2;
				}
			}
			String res = "Your fare should be \nRs. " + Math.rint(result);
			txt_result.setText(res);
			notify(res);
		}catch(Exception e){
			txt_result.setText(e.getMessage());
		}
	}
	
	public void notify(String msg){
		Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
		toast.show();
	}
}
