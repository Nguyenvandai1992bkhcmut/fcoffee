package com.example.dainguyen.fcoffee;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.dainguyen.fcoffee.Constant.ConstantDictionary;
import com.example.dainguyen.fcoffee.DatabaseManager.Dictionary;
import com.example.dainguyen.fcoffee.DatabaseManager.IData;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private ArrayList<IData> result;
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.dainguyen.fcoffee", appContext.getPackageName());
        Dictionary dictionary = new Dictionary(appContext, "", null, 1);

        result = dictionary.SearchData(ConstantDictionary.TABLE_STORE);
        result = dictionary.SearchData(ConstantDictionary.TABLE_STORE, ConstantDictionary.SELECT_1_STORE,"1");

        result = dictionary.SearchData(ConstantDictionary.TABLE_CUSTOMER);
        result = dictionary.SearchData(ConstantDictionary.TABLE_CUSTOMER, ConstantDictionary.SELECT_1_CUSTOMER,"1");

        result = dictionary.SearchData(ConstantDictionary.TABLE_CONTACT);
        result= dictionary.SearchData(ConstantDictionary.TABLE_CONTACT,ConstantDictionary.SELECT_1_CONTACTSTORE,"2");

       result = dictionary.SearchData(ConstantDictionary.TABLE_REVIEW);
        result = dictionary.SearchData(ConstantDictionary.TABLE_REVIEW,ConstantDictionary.SELECT_REVIEW_STORE,"1");

       result = dictionary.SearchData(ConstantDictionary.TABLE_VIEWSTORE);
        result = dictionary.SearchData(ConstantDictionary.TABLE_VIEWSTORE,ConstantDictionary.SELECT_1_VIEWSTORE,"1");

        System.out.println(result);
    }
}
