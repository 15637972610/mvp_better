package com.mvp.mvp_better;

import android.os.LocaleList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mvp.mvp_better.factory.CreatePresenter;
import com.mvp.mvp_better.mvpannotation.ViewFind;
import com.mvp.mvp_better.presenter.BaseMvpPresenter;
import com.mvp.mvp_better.view.AbstractMvpActivitiy;

@CreatePresenter(LoginPresenter.class)
public class MainActivity extends AbstractMvpActivitiy<LoginView,LoginPresenter> implements LoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewFind.bind(this);

    }

    @Override
    public void showDialog(boolean isShow) {
        getMvpPresenter().showDialog(isShow);
    }
}
