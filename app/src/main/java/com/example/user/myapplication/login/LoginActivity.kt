package com.example.user.myapplication.login

import android.opengl.Visibility
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.user.myapplication.R
import com.example.user.myapplication.di.app_di.DI
import com.example.user.myapplication.di.login.LoginModule
import kotlinx.android.synthetic.main.login_activity.*
import javax.inject.Inject


/**
 * Created by Evgeniya on 05.02.2018.
 */

class LoginActivity : MvpAppCompatActivity(), ILoginView{
    val TAG = "LoginActivity"

    @Inject
    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun providePresenter(): LoginPresenter {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DI.instance?.componentManager()?.appComponent()?.plus(LoginModule())?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        enter_button.setOnClickListener {
            if(!user_name.text.isNullOrBlank() && !password.text.isNullOrBlank()){

                Log.d(TAG, "onCreate ")
                presenter.getOrCreateAuthentication(user_name.text.toString(), password.text.toString())

            }else{

                showSnackBarEmptyFeilds(layout)
            }
        }
    }

    override fun showLoginModel(loginModel: LoginModel) {
        if(loginModel.loading){
            progress_bar.visibility = View.VISIBLE
        }else{
            progress_bar.visibility = View.GONE
        }

        if(loginModel.invalidUser){
            showSnackBarError(loginModel.ErrorText)
        }

        if(loginModel.internetError){
            showSnackBarError(loginModel.ErrorText)
        }

        if(loginModel.success){
            showSnackBarError("ghghghghhghghg")
        }
    }

    private fun showSnackBarEmptyFeilds(view: View){
        val snackbar = Snackbar
                .make(view, getString(R.string.empty_feilds), Snackbar.LENGTH_LONG)

        snackbar.show()
    }


    private fun showSnackBarError(text:String){
        val snackbar = Snackbar
                .make(layout, text, Snackbar.LENGTH_LONG)

        snackbar.show()
    }





}