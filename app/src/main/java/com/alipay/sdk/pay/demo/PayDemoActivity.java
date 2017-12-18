package com.alipay.sdk.pay.demo;

import java.util.Map;

import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.pay.demo.util.OrderInfoUtil2_0;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class PayDemoActivity extends FragmentActivity {
	public static final String APPID = "2016102802383554";
	public static final String RSA2_PRIVATE = "";
	public static final String RSA_PRIVATE = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALbUGZlfrFiw1h35" +
			"2TF1tBgw9OuNPCK3172WS3kYTFb0CKqiYf6NVrZWHBWZM4IzvYsXqmKqqVyX5Qsd" +
			"nSejGh/rJLoDjXyuo5gQNPkj+mmfb4F1/A/hWrFNjsjHTfFDqkU3Z/ajO2YSpVRQ" +
			"lPqYCUccnerZqOedVOwNd9gzXqbFAgMBAAECgYEAiI5HSI1zNxNt+hnBpfWaPG9k" +
			"oANvpSbXlx2I5bvGWTQQvRJoSy7aU3pho6g4Fsn6isd0VhnOQgCZ7QGDfjWOrn+n" +
			"rXo2730axUZMRkzSBOkWB0iX1yfveKNN04s2GUCDkU5YIBpYMFfTDphZmgJeJ8zd" +
			"5yOey1hBZCjch1iM8YkCQQDvX5ywzwUndslAaBSuNbVNsZmmuAy74v+KSTvbW2c6" +
			"c+sCnz8G+1BrfGOhdGBUsrJGo9jbEXJh6ezwiwFOrPi/AkEAw4cKgcILsFUYsXA3" +
			"flVKIIuPrw31Ryz9EXcysPehcQUkATXh3WmVuzmEOyZSd9hFDgLAdBsuh6IzTipk" +
			"tcqdewJBAMtEweZSpenRMS0ENSuKaB9FxViRyh5ysNVZQv8PKyWz8ckUOY1QNAZS" +
			"Zrhf/r1t0X2y/R9qPVtwLchGAiIxODkCQAC1A0+20O4BUMaLflfhnRQDDTD33vQz" +
			"8HJYuQE01AuhliC+/iMb16PGsHi6ScAPMyi6z9Fbq85nwsG8m4KgyfMCQHv5kjsW" +
			"CL/Cd30MGr5BMbZOPJwG+SD9tT04STQt9cjz9Y2ltGyGMMiK87sLze7Ha65aUwDr" +
			"MRCqT2VCBalK0yo=";
	
	private static final int SDK_PAY_FLAG = 1;
	private static final int SDK_AUTH_FLAG = 2;

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		@SuppressWarnings("unused")
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SDK_PAY_FLAG: {
				@SuppressWarnings("unchecked")
				PayResult payResult = new PayResult((Map<String, String>) msg.obj);
				/**
				 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
				 */
				String resultInfo = payResult.getResult();// 同步返回需要验证的信息
				String resultStatus = payResult.getResultStatus();
				// 判断resultStatus 为9000则代表支付成功
				if (TextUtils.equals(resultStatus, "9000")) {
					// 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
					Toast.makeText(PayDemoActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
				} else {
					// 该笔订单真实的支付结果，需要依赖服务端的异步通知。
					Toast.makeText(PayDemoActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
				}
				break;
			}
			case SDK_AUTH_FLAG: {
				@SuppressWarnings("unchecked")
				AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
				String resultStatus = authResult.getResultStatus();

				// 判断resultStatus 为“9000”且result_code
				// 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
				if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
					// 获取alipay_open_id，调支付时作为参数extern_token 的value
					// 传入，则支付账户为该授权账户
					Toast.makeText(PayDemoActivity.this,
							"授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
							.show();
				} else {
					// 其他状态值则为授权失败
					Toast.makeText(PayDemoActivity.this,
							"授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

				}
				break;
			}
			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pay_main);
	}

	public void payV2(View v) {
		if (TextUtils.isEmpty(APPID) || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))) {
			new AlertDialog.Builder(this).setTitle("警告").setMessage("需要配置APPID | RSA_PRIVATE")
					.setPositiveButton("确定", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialoginterface, int i) {
							//
							finish();
						}
					}).show();
			return;
		}
	

        boolean rsa2 = (RSA2_PRIVATE.length() > 0);
		Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2);
		String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

		String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
		String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
		final String orderInfo = orderParam + "&" + sign;

		Runnable payRunnable = new Runnable() {

			@Override
			public void run() {
				PayTask alipay = new PayTask(PayDemoActivity.this);
				Map<String, String> result = alipay.payV2(orderInfo, true);
				Log.i("msp", result.toString());

				Message msg = new Message();
				msg.what = SDK_PAY_FLAG;
				msg.obj = result;
				mHandler.sendMessage(msg);
			}
		};

		Thread payThread = new Thread(payRunnable);
		payThread.start();
	}






}
