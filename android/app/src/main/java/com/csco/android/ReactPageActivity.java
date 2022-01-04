package com.csco.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.bridge.ReadableMap;

import androidx.annotation.Nullable;

public class ReactPageActivity extends ReactActivity implements IJSBridge {
    private static String moduleName;
    DataToJSPresenter dataToJSPresenter;

    public static void start(Context context, String moduleName, String initParams) {
        ReactPageActivity.moduleName = moduleName;
        Intent intent = new Intent(context, ReactPageActivity.class);
        intent.putExtra("initParams", initParams);
        context.startActivity(intent);
    }

    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName()) {
            @Nullable
            @Override
            protected Bundle getLaunchOptions() {
                if (getIntent() != null) {
                    // RN初始化时传递给JS的初始化数据
                    Bundle bundle = new Bundle();
                    bundle.putString("params", getIntent().getStringExtra("initParams"));
                    return bundle;
                }
                return super.getLaunchOptions();
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataToJSPresenter = new DataToJSPresenter(getReactInstanceManager(), this, "By ReactActivity -> ReactApplication");
    }

    @Nullable
    @Override
    protected String getMainComponentName() {
        return moduleName;
    }

    @Override
    public void sendMessage(ReadableMap params) {
        Toast.makeText(this, params.toString(), Toast.LENGTH_LONG).show();
    }

}