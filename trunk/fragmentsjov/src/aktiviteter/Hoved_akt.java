package aktiviteter;

import java.io.IOException;
import com.androidquery.AQuery;

import dk.pyemus.fragmentsjov.R;

import fragmenter.Guide_frag;
import fragmenter.Guide_frag2;
import fragmenter.Guide_frag3;

import android.os.Bundle;
import android.os.Handler;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.TextView;

public class Hoved_akt extends Activity {
	ActionBar ab=null;
	private FragmentManager fm;
	public String note_input;
	TextView note_inn_textview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		AQuery aq = new AQuery(this);
		fm = getFragmentManager();
		ab = getActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#4980F5"));//blå farve til actionbar
		ab.setBackgroundDrawable(colorDrawable);
		aq.id(R.id.button1).clicked(this,"clickkkk");
		note_inn_textview=(TextView) findViewById(R.id.note_input);
	}		
	
	public void clickkkk(View view) throws IOException, InterruptedException{
		
		//Prøver at fjerne status & actionbar
		try{
			hideStatusBar(view);
		}catch (Exception e){
			e.printStackTrace();
		}

		//Kalder første fragment
		if(fm.findFragmentById(R.id.guidefrag)==null ){
			FragmentTransaction ft = fm.beginTransaction();
			Guide_frag gf = new Guide_frag();
			ft
			.setCustomAnimations(R.anim.slide_in_buttom, R.anim.slide_out_top,R.anim.slide_in_buttom, R.anim.slide_out_top)
			.replace(R.id.main_layout, gf)
			.addToBackStack(null)
			.commit();
			
			LayoutParams p;
			view.getX();
		}
		else{
			showStatusBar(view);
		}
	}
	
	
	public void hideStatusBar(View view) {
		try
		   {((View)findViewById(R.id.guidefrag).getParent()).setVisibility(View.GONE);
		   }
		catch (Exception e) {}
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		ab.hide();
	}
	
	public void showStatusBar(View view){ 
		try
		   {((View)findViewById(R.id.guidefrag).getParent()).setVisibility(View.VISIBLE);
		   }
		catch (Exception e) {}
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		ab.show();
	}
	


	public void Kald_næste_frag() {

		Guide_frag2 gf2 = new Guide_frag2();
		fm.findFragmentById(R.id.guidefrag2);
		FragmentTransaction ft = fm.beginTransaction();
				
		ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,R.anim.slide_ind_left, R.anim.slide_out_right)
			.replace(R.id.main_layout, gf2)
			.addToBackStack(null)
			.commit();

	}
	
	public void Kald_næste_frag2() {

		Guide_frag3 gf3 = new Guide_frag3();
		fm.findFragmentById(R.id.guidefrag3);
		FragmentTransaction ft = fm.beginTransaction();
				
		ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,R.anim.slide_ind_left, R.anim.slide_out_right)
			.replace(R.id.main_layout, gf3)
			.addToBackStack("hej")
			.commit();
	}
	
	public void Kald_hovedskærm(){
		Guide_frag3 gf3 = new Guide_frag3();
		
		note_inn_textview.setText("Tilføjet note: "+note_input);
		fm.findFragmentById(R.id.guidefrag3);
		FragmentTransaction ft = fm.beginTransaction();
				
		ft.setCustomAnimations(R.anim.slide_out_buttom, R.anim.slide_out_buttom)
			.replace(R.id.main_layout, gf3)
			.addToBackStack(null)
			.commit();
		
		//Fjerne alle fragmenter fra backstacken efter animation
		Handler handler = new Handler(); 
	    handler.postDelayed(new Runnable() { 
	         public void run() { 
	        	 dismissAlleFragmenter();
	         } 
	    }, 1000); 
	}
	
	public void dismissAlleFragmenter(){
		fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
	}
	

}
