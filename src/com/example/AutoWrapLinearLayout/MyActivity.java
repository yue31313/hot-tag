package com.example.AutoWrapLinearLayout;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test1.R;

public class MyActivity extends Activity {
	private ArrayList<String> list;
	private AutoWrapLinearLayout tagContainer;
	private TextView tagView;
	private EditText ed;
	private View btn;
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initTag();
	}
	private void initTag(){
	list = new ArrayList<String>();
		list.add("复古");
		list.add("IT民工");
		list.add("文艺");
		list.add("贾静雯迷");
		list.add("恋爱ING");
		list.add("文艺");
		list.add("大大咧咧");
		list.add("颓废ING");
		list.add("攒钱ING");
		list.add("完美主义");
		list.add("薇迷");
		list.add("日剧");
		list.add("Justin迷");
		list.add("柔情似水");
		list.add("爬山");
		
		//LayoutInflater mLayoutInflater = getLayoutInflater();
		 tagContainer = (AutoWrapLinearLayout) findViewById(R.id.tag_container);
		 ed=(EditText)findViewById(R.id.edittext);
		 btn=(Button)findViewById(R.id.btn);
		 btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(ed.getText().toString()!=null){
					list.add(ed.getText().toString());
					notifyChange();
				};
			}
		});
		 showView();
	}
	
	
	
	public void notifyChange(){
		tagContainer.removeAllViews();
		showView();
	};
	public void showView(){
		tagContainer.removeAllViews();
		for (int i=0;i<list.size();i++) {
			String tag=list.get(i);
			
			tagView = (TextView) getLayoutInflater().inflate(R.layout.tag, tagContainer, false);
			tagView.setText(tag);
			tagView.setTag(""+i);
			tagView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					int j=Integer.valueOf((String) v.getTag());
					list.remove(j);
					notifyChange();
				}
			});
			tagContainer.addView(tagView);
		}
	}
	
}
