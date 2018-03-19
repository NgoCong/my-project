package com.ntc.tancong.detai;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by tanco on 3/11/2018.
 */

public class CreateAccountFragment extends Fragment {
    String arrRoom[]={"201A","202A","203A","204A","205A","206A","207A","209A","210A","201B","202B","203B"};
    EditText edtEmail,edtPass,edtUserName,edtBirthday;
    Button btnCreate,btnReset,btnBirthday;
    AutoCompleteTextView actvRoom;
    ProgressBar progressBar;
    FirebaseAuth auth;
    private DatePicker datePicker;
    private Calendar calendar;
    Date dateFinish;
    private int year, month, day;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_account,null);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtEmail=(EditText)view.findViewById(R.id.edtEmail_cna);
        edtPass=(EditText)view.findViewById(R.id.edtPassword_cna);
        edtBirthday=(EditText)view.findViewById(R.id.edtDate);
        edtUserName=(EditText)view.findViewById(R.id.edtUsername_cna);

        btnCreate = (Button)view.findViewById(R.id.btnCreate);
        btnReset = (Button)view.findViewById(R.id.btnReset);
        btnBirthday = (Button)view.findViewById(R.id.btnBirthday);

        actvRoom=(AutoCompleteTextView)view.findViewById(R.id.actv_Room);

        auth =FirebaseAuth.getInstance();
        loadAutoComplete();

        calendar=Calendar.getInstance();
        SimpleDateFormat dft=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate=dft.format(calendar.getTime());
        edtBirthday.setText(strDate);
        dateFinish=calendar.getTime();
        btnBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDatePickerDialog();
            }
        });




       btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String pass = edtPass.getText().toString();
                // String username=edit_cna_username.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(CreateAccountFragment.this.getActivity(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(CreateAccountFragment.this.getActivity(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pass.length() < 6) {
                    Toast.makeText(CreateAccountFragment.this.getActivity(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(CreateAccountFragment.this.getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(CreateAccountFragment.this.getActivity(), "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(CreateAccountFragment.this.getActivity(), "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(CreateAccountFragment.this.getActivity(), "Authentication Successful." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtEmail.setText("");
                edtPass.setText("");
                edtUserName.setText("");
            }

        });
    }
    public void showDatePickerDialog()
    {
        DatePickerDialog.OnDateSetListener callback=new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear,
                                  int dayOfMonth) {
                //Mỗi lần thay đổi ngày tháng năm thì cập nhật lại TextView Date
                edtBirthday.setText(
                        (dayOfMonth) +"/"+(monthOfYear+1)+"/"+year);
                //Lưu vết lại biến ngày hoàn thành
                calendar.set(year, monthOfYear, dayOfMonth);
                dateFinish=calendar.getTime();
            }
        };
        //các lệnh dưới này xử lý ngày giờ trong DatePickerDialog
        //sẽ giống với trên TextView khi mở nó lên
        String s=edtBirthday.getText()+"";
        String strArrtmp[]=s.split("/");
        int ngay=Integer.parseInt(strArrtmp[0]);
        int thang=Integer.parseInt(strArrtmp[1])-1;
        int nam=Integer.parseInt(strArrtmp[2]);
        DatePickerDialog pic=new DatePickerDialog(
                getView().getContext(),
                callback, nam, thang, ngay);

        pic.show();
    }
    void loadAutoComplete(){
        //Gán Data source (arr) vào Adapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (
                        CreateAccountFragment.this.getActivity(),
                        android.R.layout.simple_dropdown_item_1line,
                        arrRoom
                );
        actvRoom.setAdapter(adapter);
        actvRoom.setThreshold(1);
    }

}
