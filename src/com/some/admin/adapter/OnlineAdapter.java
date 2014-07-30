package com.some.admin.adapter;

import java.util.List;

import com.some.admin.R;
import com.some.admin.model.Online;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class OnlineAdapter extends BaseAdapter{

	private Context mContext;
	private LayoutInflater mInflater;
	private List<Online> mListOnline;
	public OnlineAdapter(Context context) {
		super();
		this.mContext = context;
		mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public void setListOnline(List<Online> listOnline){
		if(listOnline != null && !listOnline.isEmpty()){
			mListOnline = listOnline;
		}else{
			mListOnline = null;
		}
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListOnline != null ? mListOnline.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mListOnline.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.layout_item_online, null);
			holder = new ViewHolder();
			holder.mNamePlayer = (TextView)convertView.findViewById(R.id.tvNameOnline);
			holder.mMoneyPlayer = (TextView)convertView.findViewById(R.id.tvMoneyOnline);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		
		final Online item = mListOnline.get(position);
		holder.mNamePlayer.setText(item.getNamePlayer());
		holder.mMoneyPlayer.setText(item.getMoneyPlayer());
		return convertView;
	}
	
	private class ViewHolder{
		private TextView mNamePlayer;
		private TextView mMoneyPlayer;
	}

}
