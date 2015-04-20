package com.wernerapps.mentorme.MentorView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.wernerapps.mentorme.API.Mentee;
import com.wernerapps.mentorme.API.Mentor;
import com.wernerapps.mentorme.R;

import java.util.List;

/**
 * Created by Tom on 4/18/2015.
 */
public class MenteeAdapter extends BaseAdapter {
    private final List<Mentee> mentorList;
    private final Context context;

    public MenteeAdapter(Context context, MenteePresenter presenter, List<Mentee> mentorList) {
        this.context = context;
        this.mentorList = mentorList;
    }

    @Override
    public int getCount() {
        return mentorList.size();
    }

    @Override
    public Object getItem(int position) {
        return mentorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Mentee mentee = mentorList.get(position);

        if (convertView == null)
        {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.mentee_item, null);
        }

        TextView menteeName = (TextView) convertView.findViewById(R.id.mentee_name);
        menteeName.setText(mentee.name);

        TextView menteeMajor = (TextView) convertView.findViewById(R.id.mentee_major);
        menteeMajor.setText(mentee.major);

        TextView menteeReason = (TextView) convertView.findViewById(R.id.mentee_reason);
        menteeReason.setText(mentee.reason);

        TextView cashBonus = (TextView) convertView.findViewById(R.id.cash_bonus);
        cashBonus.setText("+$" + mentee.bonus + " w/in 2 days");

        return convertView;
    }
}
