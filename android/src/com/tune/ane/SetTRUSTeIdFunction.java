package com.tune.ane;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class SetTRUSTeIdFunction implements FREFunction {
    public static final String NAME = "setTRUSTeId";

    @Override
    public FREObject call(FREContext context, FREObject[] passedArgs) {
        try {
            String tpid = null;
            if (passedArgs[0] != null) {
                tpid = passedArgs[0].getAsString();
            }

            Log.i(TuneExtensionContext.TAG, "Call " + NAME);
            TuneExtensionContext tec = (TuneExtensionContext)context;
            tec.tune.setTRUSTeId(tpid);

            return FREObject.newObject(true);
        } catch (Exception e) {
            Log.d(TuneExtensionContext.TAG, "ERROR: " + e);
            e.printStackTrace();
        }
        return null;
    }
}