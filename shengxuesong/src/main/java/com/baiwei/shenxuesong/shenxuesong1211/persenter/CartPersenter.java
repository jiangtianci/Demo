package com.baiwei.shenxuesong.shenxuesong1211.persenter;

import com.baiwei.shenxuesong.shenxuesong1211.Bean.CGSB;
import com.baiwei.shenxuesong.shenxuesong1211.Bean.CartBean;
import com.baiwei.shenxuesong.shenxuesong1211.model.CartModel;
import com.baiwei.shenxuesong.shenxuesong1211.view.ICart;

/**
 * Created by Dell on 2017/12/11.
 */

public class CartPersenter {

    private final CartModel cartModel;
   private ICart iCart;
    public CartPersenter(ICart iCart) {
        cartModel = new CartModel();
        this.iCart=iCart;


    }
    public void getCartGoods(String s, String uid,String source){
        cartModel.getCart(s, uid, source, new CGSB<CartBean>() {
            @Override
            public void chengGong(CartBean cartBean) {
                iCart.showBean(cartBean);
            }
        });
    }
}
