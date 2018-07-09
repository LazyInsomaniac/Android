package com.abc.listviewcustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentArrayList.add(new Student("sambhav", "android", "123", "delhi"));
        studentArrayList.add(new Student("dasdas", "web", "456", "delhi"));
        studentArrayList.add(new Student("czxcxz", "c++", "789", "delhi"));
        studentArrayList.add(new Student("qweqwe", "android", "101112", "delhi"));
        studentArrayList.add(new Student("mbjmb", "web", "131415", "delhi"));
        studentArrayList.add(new Student("sgigyj", "c++", "161718", "delhi"));
        studentArrayList.add(new Student("utyuty", "c++", "1192021", "delhi"));
        studentArrayList.add(new Student("sbvnvc", "android", "222324", "delhi"));
        studentArrayList.add(new Student("sghkghkgh", "web", "252627", "delhi"));
        studentArrayList.add(new Student("suiuiou", "web", "282930", "delhi"));
        studentArrayList.add(new Student("pyuouyiy", "c++", "303132", "delhi"));

        class MyCustomAdapter extends BaseAdapter {


            @Override
            public int getCount() {
                return studentArrayList.size();   // returns size of arraylist
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                LayoutInflater li =(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

                View rowView = li.inflate(R.layout.item_row,viewGroup,false);
                Student currentStudent = studentArrayList.get(i);

                TextView studentname = rowView.findViewById(R.id.sname);
                TextView studentbatch = rowView.findViewById(R.id.sbatch);
                TextView studentNumber = rowView.findViewById(R.id.snum);
                TextView studentLocation= rowView.findViewById(R.id.sloc);

                studentname.getText(currentStudent.getName());
                studentNumber.getText(currentStudent.getBatch



            return rowView;
            }
        }
    }
}
