package fragmenter;

import com.androidquery.AQuery;

import dk.pyemus.fragmentsjov.R;

import aktiviteter.Hoved_akt;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class Guide_frag3 extends Fragment {
	
	public Guide_frag3() {
		
	}

	ImageView pil;
	Button noteknap;
//	public String note = "";
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.guidefrag3, container, false);

		 pil = (ImageView) v.findViewById(R.id.next_pil);
		 noteknap = (Button) v.findViewById(R.id.note_knap);
		pil.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Hoved_akt a = (Hoved_akt) getActivity();
				a.Kald_hovedskærm();
			}
		});
		
		
		noteknap.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				bygDialog();
			}
		});

		return v;
	}
	
	public void bygDialog(){
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Indtast note");

		// Set up the input
		final EditText input = new EditText(getActivity());
		// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
		input.setInputType(InputType.TYPE_CLASS_TEXT );
		builder.setView(input);

		// Set up the buttons
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { 
		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		    	Hoved_akt a = (Hoved_akt) getActivity();
		         a.note_input= input.getText().toString();
		    }
		});
//		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//		    @Override
//		    public void onClick(DialogInterface dialog, int which) {
//		        dialog.cancel();
//		    }
//		});

		builder.show();
	}
}
