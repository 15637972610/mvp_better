package com.mvp.mvp_better;

import com.mvp.mvp_better.presenter.BaseMvpPresenter;

/**
 * Created by dkp on 2018/5/26.
 */

public class LoginPresenter extends BaseMvpPresenter<LoginView>{

    LoginModel mLoginModel;
    public LoginPresenter() {
        mLoginModel = new LoginModel();
    }

    public void login(){
        mLoginModel.doLogin("张三","1232434");
    }

    public void interruptHttp(){
        mLoginModel.interruptHttp();
    }

    public void showDialog(boolean isShow) {

    }
}
