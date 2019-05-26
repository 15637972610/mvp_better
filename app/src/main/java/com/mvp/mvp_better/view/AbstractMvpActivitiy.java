package com.mvp.mvp_better.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.mvp.mvp_better.factory.PresenterMvpFactory;
import com.mvp.mvp_better.factory.PresenterMvpFactoryImpl;
import com.mvp.mvp_better.presenter.BaseMvpPresenter;
import com.mvp.mvp_better.proxy.BaseMvpProxy;
import com.mvp.mvp_better.proxy.PresenterProxyInterface;


/**
 * @author dkp
 * @date 2017/11/17
 * @description 继承自Activity的基类MvpActivity
 * 使用代理模式来代理Presenter的创建、销毁、绑定、解绑以及Presenter的状态保存,其实就是管理Presenter的生命周期
 */
public abstract class AbstractMvpActivitiy<V extends BaseMvpView, P extends BaseMvpPresenter<V>> extends Activity implements PresenterProxyInterface<V,P> {
    private static  String TAG  = "AbstractMvpActivitiy";
    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";
    /**
     * 创建被代理对象,传入默认Presenter的工厂
     */
    private BaseMvpProxy<V,P> mProxy = new BaseMvpProxy<>(PresenterMvpFactoryImpl.<V,P>createFactory(getClass()));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"V onCreate");
        Log.e(TAG,"V onCreate mProxy = " + mProxy);
        Log.e(TAG,"V onCreate this = " + this.hashCode());

        if(savedInstanceState != null){
            mProxy.onRestoreInstanceState(savedInstanceState.getBundle(PRESENTER_SAVE_KEY));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"V onResume");
        mProxy.onResume((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"V onDestroy = " );
        mProxy.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG,"V onSaveInstanceState");
        outState.putBundle(PRESENTER_SAVE_KEY,mProxy.onSaveInstanceState());
    }

    @Override
    public void setPresenterFactory(PresenterMvpFactory<V, P> presenterFactory) {
        Log.e(TAG,"V setPresenterFactory");
        mProxy.setPresenterFactory(presenterFactory);
    }

    @Override
    public PresenterMvpFactory<V, P> getPresenterFactory() {
        Log.e(TAG,"V getPresenterFactory");
        return mProxy.getPresenterFactory();
    }

    @Override
    public P getMvpPresenter() {
        Log.e(TAG,"V getMvpPresenter");
        return mProxy.getMvpPresenter();
    }
}
