package Details;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.spinnerwidget.R;
import com.example.spinnerwidget.report;


public class PersonalDetails extends Fragment implements AdapterView.OnItemSelectedListener {


    Spinner spinner;
    Button btnSubmit;
    EditText etAge, etEducation,etFatherName, etGrandFatherName, etOccupation, etMotherName, etSpouseName;

    public PersonalDetails() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate (R.layout.fragment_personal_details, container, false);
        spinner = view.findViewById (R.id.religious);
        btnSubmit = view.findViewById(R.id.submit);
        etAge = view.findViewById(R.id.age);
        etEducation = view.findViewById(R.id.education);
        etFatherName = view.findViewById(R.id.fathername);
        etGrandFatherName = view.findViewById(R.id.grandfathername);
        etMotherName = view.findViewById(R.id.mothername);
        etOccupation = view.findViewById(R.id.occupation);
        etSpouseName = view.findViewById(R.id.husbandorwifename);


        ArrayAdapter adapter = ArrayAdapter.createFromResource (getActivity (), R.array.religion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter (adapter);
        spinner.setOnItemSelectedListener (this);


        return view;

  }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition (position).toString ();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), report.class);
                intent.putExtra("age",etAge.getText().toString());
                intent.putExtra("education",etEducation.getText().toString());
                intent.putExtra("Fathername",etFatherName.getText().toString());
                intent.putExtra("GrandFathername",etGrandFatherName.getText().toString());
                intent.putExtra("mothername",etMotherName.getText().toString());
                intent.putExtra("occupation",etOccupation.getText().toString());
                intent.putExtra("spousename",etSpouseName.getText().toString());
                intent.putExtra("religion",spinner.getSelectedItem().toString());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
