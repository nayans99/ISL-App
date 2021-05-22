package com.example.islapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islapp.Adapter.CustomAdapter;
import com.example.islapp.Pojo.CustomPojo;

import java.util.ArrayList;

public class Ae extends AppCompatActivity {
    private final ArrayList<CustomPojo> listContentArr = new ArrayList<>();
    //Declare the Adapter, RecyclerView and our custom ArrayList
//    RecyclerView recyclerView;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ae);
        Intent i = new Intent(Ae.this, A.class);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(Ae.this, A.class);
//                i.putExtra("pos", "0");
//                startActivity(i);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(Ae.this, A.class);
//                i.putExtra("pos", "1");
//                startActivity(i);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                i.putExtra("pos", "2");
//                startActivity(i);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                i.putExtra("pos", "3");
//                startActivity(i);
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                i.putExtra("pos", "4");
//                startActivity(i);
            }
        });
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                i.putExtra("pos", "5");
//                startActivity(i);
            }
        });
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                i.putExtra("pos", "6");
//                startActivity(i);
            }
        });
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                i.putExtra("pos", "7");
//                startActivity(i);
            }
        });
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                i.putExtra("pos", "8");
//                startActivity(i);
            }
        });
        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                i.putExtra("pos", "9");
//                startActivity(i);
            }
        });

//        recyclerView = findViewById(R.id.recycleView);
        //As explained in the tutorial, LineatLayoutManager tells the RecyclerView that the view
        //must be arranged in linear fashion
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        /**
         * RecyclerView: Implementing single item click and long press (Part-II)
         * */
  /*      recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                //Values are passing to activity & to fragment as well
                Toast.makeText(Ae.this, "Single Click on position :" + position,
                        Toast.LENGTH_SHORT).show();*/
//                Intent i = new Intent(Ae.this, A.class);
//                i.putExtra("pos", position);
//                startActivity(i);
/*            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(Ae.this, "Long press on position :" + position,
                        Toast.LENGTH_LONG).show();
            }
        }));

        adapter = new CustomAdapter(this);
        //Method call for populating the view
        populateRecyclerViewValues();*/
    }
//
//    private void populateRecyclerViewValues() {
//        /** This is where we pass the data to the adpater using POJO class.
//         *  The for loop here is optional. I've just populated same data for 50 times.
//         *  You can use a JSON object request to gather the required values and populate in the
//         *  RecyclerView.
//         * */
//        for (int iter = 0; iter <= 9; iter++) {
//            //Creating POJO class object
//            CustomPojo pojoObject = new CustomPojo();
//            //Values are binded using set method of the POJO class
//            pojoObject.setName(String.valueOf(iter));
//
//            //After setting the values, we add all the Objects to the array
//            //Hence, listConentArr is a collection of Array of POJO objects
//            listContentArr.add(pojoObject);
//        }
//        //We set the array to the adapter
//        adapter.setListContent(listContentArr);
//        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));
//        //We in turn set the adapter to the RecyclerView
//        recyclerView.setAdapter(adapter);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * RecyclerView: Implementing single item click and long press (Part-II)
     * <p>
     * - creating an Interface for single tap and long press
     * - Parameters are its respective view and its position
     */

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    /**
     * RecyclerView: Implementing single item click and long press (Part-II)
     * <p>
     * - creating an innerclass implementing RevyvlerView.OnItemTouchListener
     * - Pass clickListener interface as parameter
     */

    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private final ClickListener clicklistener;
        private final GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener) {

            this.clicklistener = clicklistener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clicklistener != null) {
                        clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clicklistener != null && gestureDetector.onTouchEvent(e)) {
                clicklistener.onClick(child, rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
