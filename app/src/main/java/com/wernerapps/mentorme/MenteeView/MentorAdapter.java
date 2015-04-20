package com.wernerapps.mentorme.MenteeView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.wernerapps.mentorme.API.Mentor;
import com.wernerapps.mentorme.R;

import java.util.List;

/**
 * Created by Tom on 4/18/2015.
 */
public class MentorAdapter extends BaseAdapter {
    private final List<Mentor> mentorList;
    private final Context context;

    public MentorAdapter(Context context, MainPresenter presenter, List<Mentor> mentorList) {
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
        final Mentor mentor = mentorList.get(position);

        if (convertView == null)
        {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.mentor_item, null);
        }

        TextView mentorName = (TextView) convertView.findViewById(R.id.mentor_name);
        mentorName.setText(mentor.name);

        TextView mentorMajor = (TextView) convertView.findViewById(R.id.mentor_major);
        mentorMajor .setText(mentor.major);

        TextView gpa = (TextView) convertView.findViewById(R.id.mentor_gpa);
        gpa.setText(mentor.gpa + " GPA");

        RatingBar rating = (RatingBar) convertView.findViewById(R.id.ratingBar);
        rating.setRating(mentor.rating);

        return convertView;
    }
}
