/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.ws;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;

/**
 *
 * @author Nicolás Galindo
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    
    private EditText et;
    
    public DatePickerFragment(EditText et) {
        this.et = et;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        String any = Integer.toString(year);
        String mes = month > 9 ? Integer.toString(month) : "0" + Integer.toString(month);
        String dia = day > 9 ? Integer.toString(day) : "0" + Integer.toString(day);
        et.setText(any + "-" + mes + "-" + dia, TextView.BufferType.NORMAL);
    }
}
