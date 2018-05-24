package tm.charlie.expandabletextview.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import tm.charlie.expandabletextview.ExpandableTextView;
import tm.charlie.expandabletextview.ExpandableTextView.State;


public class JavaActivity extends AppCompatActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setTitle(getClass().getSimpleName());
		setContentView(R.layout.java_activity_main);
		setupExpandableTextView();
	}
	
	void setupExpandableTextView(){
		final ExpandableTextView expandableTextView = findViewById(R.id.expandable_textview);
		
		// Make ExpandableTextView expand/collapse on click
		expandableTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				expandableTextView.toggle();
			}
		});

		expandableTextView.onStateChange(new Function3<ExpandableTextView, State, State, Unit>(){
			@Override
			public Unit invoke(ExpandableTextView expandableTextView, State oldState, State newState){
				Toast.makeText(getApplicationContext(), oldState.toString() + " -> " + newState.toString(), Toast.LENGTH_SHORT).show();
				return null;
			}
		});
	}
}
