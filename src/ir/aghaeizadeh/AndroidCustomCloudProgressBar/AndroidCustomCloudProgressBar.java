package ir.aghaeizadeh.AndroidCustomCloudProgressBar;

import ir.aghaeizadeh.AndroidCustomCloudProgressBar.R;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AndroidCustomCloudProgressBar extends Activity {
    /** Called when the activity is first created. */
	ImageView iV;
	Handler handler;
	int i=49;
	RelativeLayout.LayoutParams lp = null;
	RelativeLayout.LayoutParams lp1 = null;
	RelativeLayout.LayoutParams lp2 = null;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout rl = (LinearLayout)findViewById(R.id.linear);
        rl.setBackgroundColor(Color.WHITE);
        drawRect();
        handler = new Handler();
        
    }
 
    
    public void drawRect()
    {
    	Thread th =  new Thread()
    	{
    		
    		public void run() {
    			
    				///// FIRST RECTANGLE ////
    				lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
    				lp.setMargins(0, 0, 0, 0);
    			   	final Paint paint = new Paint();
			        paint.setColor(Color.parseColor("#CD5C5C"));
			        final Bitmap bg = Bitmap.createBitmap(120, 51, Bitmap.Config.ARGB_8888);
			        final Canvas canvas = new Canvas(bg); 
			        final RelativeLayout ll = (RelativeLayout) findViewById(R.id.rect);
			        iV = new ImageView(getApplicationContext());
			        canvas.drawRect(0, 50, 120, 49, paint); 
			        iV.setLayoutParams(lp);
			        iV.setImageBitmap(bg);
			        ll.addView(iV);
			        /////////////////////////
			        
	    		    /// IMAGE VIEW LOADED ///
							lp1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
			    		    lp1.setMargins(0, 0, 0, 0);
							View view = (View) findViewById(R.id.rect); //the layout you set in `setContentView()`
					        LinearLayout picLL = new LinearLayout(AndroidCustomCloudProgressBar.this);
					        picLL.layout(0, 0, 0, 0);
					       // picLL.setLayoutParams(new LayoutParams(1000, 60));
					        picLL.setOrientation(LinearLayout.HORIZONTAL);
					        ((ViewGroup) view).addView(picLL);
					        ImageView myImage = new ImageView(getBaseContext());
					        myImage.setBackgroundResource(R.drawable.cloud);
					        myImage.setLayoutParams(lp1);
					        picLL.addView(myImage);
					        ////////////////////////
					        
					        /// TEXT VIEW LOADED ///
					        final TextView msg = new TextView(AndroidCustomCloudProgressBar.this);
					     //   msg.setBackgroundResource(R.drawable.logo);
					        msg.setText("0%");
					        
					      //  msg.setPadding(10, 10, 10, 10);
					      //  msg.setTextColor(getResources().getColor(R.color.white));
					        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT , Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					        
					        // params.setMargins(0, 0, 0, 0);
					        params.gravity = Gravity.RIGHT;
					        //msg.setLayoutParams(params);
					        msg.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
					        
					        RelativeLayout chat = (RelativeLayout) findViewById(R.id.rect);
					        RelativeLayout.LayoutParams relativeParam = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
					        relativeParam.addRule(RelativeLayout.CENTER_IN_PARENT);
					        msg.setLayoutParams(relativeParam);
					        chat.addView(msg);
							////////////////////////
			        
			        
			        for( i=49;i>1;i--)
			        {
			        	try
	                    {
	                        Thread.sleep(50L);
	                    }
	                    catch(InterruptedException e)
	                    {
	                       
	                    }
				
    			handler.post(new Runnable() {
					
					@SuppressWarnings("deprecation")
					public void run() {
						
		
						 msg.setText(""+i+"%");
		
				        	
				            canvas.drawRect(0, 50, 118, i, paint); 
					        iV.setImageBitmap(bg);
					        
					        /////////////////////////
					}
				});
			        }
    		
			}
    		
    		
    		
    		
    	};
    	th.start();
    }
    
}