package fragmenter;

import dk.pyemus.fragmentsjov.R;

import aktiviteter.Hoved_akt;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Guide_frag4 extends Fragment {

	public Guide_frag4() {

	}

	Button but;
	Hoved_akt main;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.guidefrag4, container, false);

		return v;
	}
}
