package edu.iss.nus.medipaldemo;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.iss.nus.medipaldemo.dummy.DummyHealthBio;
import edu.iss.nus.medipaldemo.dummy.DummyHealthBios;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private boolean isAdd = false;

    /**
     * The dummy conditonName this fragment is presenting.
     */
    private DummyHealthBio mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy conditonName specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load conditonName from a conditonName provider.
            mItem = DummyHealthBios.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            if (mItem == null)
            {
                isAdd = true;
                mItem = new DummyHealthBio();
                mItem.id = "6";
                mItem.startDate = new Date();
                mItem.conditionType = "A";
            }


            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                //appBarLayout.setTitle(mItem.conditonName);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy conditonName as text in a TextView.
        final EditText edtCondition = (EditText)rootView.findViewById(R.id.editTextCondition);
        final DatePicker edtStartDate = (DatePicker)rootView.findViewById(R.id.editTextStartDate);
        final Spinner spinner = (Spinner)rootView.findViewById(R.id.ddlHealthCondition);
        final FloatingActionButton btnSave =(FloatingActionButton)getActivity().findViewById(R.id.fabsave);
        final FloatingActionButton btnEnableEdit = (FloatingActionButton)getActivity().findViewById(R.id.fab);

        //populate Health Condition Type
        final String[] items = new String[]{"A", "C"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into datepicker
        edtStartDate.init(year, month, day, null);

        //should be able to show save button if isAdd == true
        btnEnableEdit.setVisibility(View.INVISIBLE);
        btnSave.setVisibility(View.VISIBLE);

        if (mItem != null && isAdd==false) {
            //((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.description);

            btnEnableEdit.setVisibility(View.VISIBLE);
            btnSave.setVisibility(View.INVISIBLE);

            edtCondition.setText(mItem.description);
            edtCondition.clearFocus();
            edtCondition.setEnabled(false);

            //edtStartDate.updateDate(mItem.startDate.getYear(),mItem.startDate.getMonth(),mItem.startDate.getDay());
            //TODO
            edtStartDate.setEnabled(false);

            if (!mItem.conditionType.equals(null)) {
                int spinnerPosition = adapter.getPosition(mItem.conditionType);
                spinner.setSelection(spinnerPosition);
            }
            spinner.setEnabled(false);


        }



        btnEnableEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText test = (EditText)getActivity().findViewById(R.id.editTextCondition);
                //test.setEnabled(true);
                edtCondition.setEnabled(true);
                edtStartDate.setEnabled(true);
                spinner.setEnabled(true);
                btnEnableEdit.setVisibility(View.INVISIBLE);
                btnSave.setVisibility(View.VISIBLE);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO, STORE DATE AND RETURN TO LIST
                if (isAdd) {
                    int i = DummyHealthBios.ITEMS.size() + 1;
                    mItem.id = Integer.toString(i);
                    mItem.description = edtCondition.getText().toString();
                    mItem.conditionType = spinner.getSelectedItem().toString();
                    int day = edtStartDate.getDayOfMonth();
                    int month = edtStartDate.getMonth();
                    int year = edtStartDate.getYear();
                    mItem.startDate = new Date();//TODO;
                    DummyHealthBios.addItem(mItem);
                }
                else {
                    mItem.description = edtCondition.getText().toString();
                    mItem.conditionType = spinner.getSelectedItem().toString();
                    int day = edtStartDate.getDayOfMonth();
                    int month = edtStartDate.getMonth();
                    int year = edtStartDate.getYear();
                    mItem.startDate = new Date();//TODO;
                }
                String message = isAdd?"Add Health Condition Successfully":"Modify Health Condition Successfully";
                Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        return rootView;
    }
}
