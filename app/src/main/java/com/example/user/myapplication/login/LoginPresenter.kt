package com.example.user.myapplication.login

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.user.myapplication.interactors.ILoginInteractor
import com.example.user.myapplication.utils.RxSchedulersAbs
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Evgeniya on 05.02.2018.
 */


@InjectViewState
class LoginPresenter(val loginInteractor: ILoginInteractor) : MvpPresenter<ILoginView>() {

    val TAG = "LoginPresenter"
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getOrCreateAuthentication(userName:String, password:String){
                loginInteractor.getOrCreateAuthentication(userName, password)
//                .compose(schedulers.getIOToMainTransformerFlowable())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())

                .subscribe(
                    {loginModel -> viewState.showLoginModel(loginModel)},
                    {throwable -> Log.d(TAG, "getOrCreateAuthentication: onError ${throwable?.message}")}
                )
    }

    override fun onDestroy() {
        super.onDestroy()
//        compositeDisposable.dispose()
//        compositeDisposable.clear()
    }

}