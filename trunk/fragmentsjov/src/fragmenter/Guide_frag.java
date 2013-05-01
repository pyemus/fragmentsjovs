package fragmenter;

import com.androidquery.AQuery;

import dk.pyemus.fragmentsjov.R;



import aktiviteter.Hoved_akt;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.Toast;

public class Guide_frag extends Fragment {

	public Guide_frag() {

	}

	Button but;
	Hoved_akt main;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.guidefrag, container, false);
		ImageView pil = (ImageView)v.findViewById(R.id.next_pil);
		Button hjemknap = (Button)v.findViewById(R.id.hjem_knap);
		
		pil.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Hoved_akt a = (Hoved_akt) getActivity();
				a.Kald_næste_frag();
			}
			});
		
		hjemknap.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Hoved_akt a = (Hoved_akt) getActivity();
				a.dismissAlleFragmenter();
				
				Toast.makeText(getActivity(), 
						"Kalder dismissAlleFragmenter", 
						Toast.LENGTH_SHORT).show();
			}
		});
//		
//		Animation rotation = AnimationUtils.loadAnimation(this, R.anim.rotation_arrow);
//		pil.startAnimation(rotation);

		return v;
	}
	
	@Override
	public void onDetach(){
		super.onDetach();
		try{
			Hoved_akt a = (Hoved_akt) getActivity();
			a.showStatusBar(null);
			Log.d("FragmentFulleScreen", "Kalder showStatusBar");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	


//	public void lul(View view) {
//
//		main.showStatusBar(view);
//	}

	// static Guide_frag newInstance() {
	// Guide_frag gf = new Guide_frag();
	// return gf;
	// }
	//
	// public View onCreateView(LayoutInflater infl, ViewGroup container,
	// Bundle savedInstanceState) {
	//
	// View v = infl.inflate(R.layout.guidefrag, container, false);
	// return v;
	// }

}
