package fragmenter;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewDebug.ExportedProperty;
import android.widget.FrameLayout;

public class FrameLayoutPct extends FrameLayout {

	public FrameLayoutPct(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public void setXPct(float x) {
		// TODO Auto-generated method stub
		Log.d("FrameLayoutPct", "xp="+x);
		super.setX(x * getWidth()/100);
	}

	public float getXPct() {
		// TODO Auto-generated method stub
		return super.getX()*100/getWidth();
	}
	
	public void setYPct(float y) {
		// TODO Auto-generated method stub
		Log.d("FrameLayoutPct", "yp="+y);
		super.setY(y * getHeight()/100);
	}
	
	
	public FrameLayoutPct(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
}
