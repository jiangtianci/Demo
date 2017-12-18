package com.example.chenzhengjun.wechatlogindemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.mm.sdk.modelmsg.SendAuth;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sendWxAuthRequest();
            }
        });
    }

    /**
     * 微信登录
     */
    private void sendWxAuthRequest() {
        if (WXManager.instance().isWXAppInstalled()) {
            final SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "wechat_sdk_demo";
            //拉起微信授权，授权结果在WXEntryActivity中接收处理
            WXManager.instance().sendReq(req);
        } else {
            Toast.makeText(this, R.string.wechat_not_installed, Toast.LENGTH_SHORT).show();
        }
    }
}

