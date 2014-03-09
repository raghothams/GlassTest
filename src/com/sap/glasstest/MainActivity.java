package com.sap.glasstest;
import java.util.ArrayList;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends Activity {

	private CardScrollAdapter mCardScrollAdapter;
	private ArrayList<Card> mCards;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 mCards = new ArrayList<Card>();
		
		Card card = new Card(this);
		card.setText("Hello World, this is Glass");
		card.setFootnote("Scroll Next");
		mCards.add(card);
		
		card = new Card(this);
		card.setText("This is a sample Glass App");
		card.setFootnote("Scroll Next");
		mCards.add(card);
		
		card = new Card(this);
		card.setText("Should add ability to capture Voice");
		card.setFootnote("End");
		mCards.add(card);
		
		createAdapter();
		CardScrollView scrollView = new CardScrollView(this);
		scrollView.setAdapter(mCardScrollAdapter);
		scrollView.activate();
		
		setContentView(scrollView);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	public void createAdapter(){
		this.mCardScrollAdapter = new CardScrollAdapter() {
			
			@Override
			public View getView(int pos, View convertView, ViewGroup parent) {
				return mCards.get(pos).toView();
			}
			
			@Override
			public Object getItem(int pos) {
				return mCards.get(pos);
			}
			
			@Override
			public int getCount() {
				return mCards.size();
			}
			
			@Override
			public int findItemPosition(Object item) {
				return mCards.indexOf(item);
			}
			
			@Override
			public int findIdPosition(Object arg0) {
				return -1;
			}
		};
	}

	
}
