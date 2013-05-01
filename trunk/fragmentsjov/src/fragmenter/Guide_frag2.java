package fragmenter;

import com.androidquery.AQuery;

import dk.pyemus.fragmentsjov.R;


import aktiviteter.Hoved_akt;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Guide_frag2 extends Fragment {

	public Guide_frag2() {

	}

ImageView pil, bloodrop;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.guidefrag2, container, false);


		pil = (ImageView) v.findViewById(R.id.next_pil);
		bloodrop=(ImageView)v.findViewById(R.id.bloodDrop);
		pil.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Hoved_akt a = (Hoved_akt) getActivity();
				a.Kald_næste_frag2();
			}
		});
		
		
       
        
        
        //Animation settet bruges til flere former for animationer (scale,rotate,translate)
        AnimationSet animationSet = new AnimationSet(true);

        TranslateAnimation t = new TranslateAnimation(0, 0,0, 200);
        t.setDuration(500);
        t.setFillAfter(true);
        t.setRepeatCount(-1);
        t.setRepeatMode(t.REVERSE);
        animationSet.addAnimation(t);

        
        RotateAnimation r = new RotateAnimation(0f, 15f,0,0); // HERE 
        //r.setStartOffset(1000);
        r.setDuration(300);
        r.setRepeatCount(-1);
        r.setRepeatMode(r.REVERSE);
        animationSet.addAnimation(r);
        bloodrop.startAnimation(animationSet);

		return v;
	}
}
