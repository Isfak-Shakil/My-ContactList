package com.example.mycontactlist.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.mycontactlist.model.SignInUser;
import com.example.mycontactlist.viewModel.SignInViewModel;

public class SplashActivity extends AppCompatActivity {
        private SignInViewModel signInViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSplashViewModel();
        checkUserAuthenticate();
    }

    private void checkUserAuthenticate() {
        signInViewModel.checkAuthenticate();
        signInViewModel.checkAuthenticateLiveData.observe(this, new Observer<SignInUser>() {
            @Override
            public void onChanged(SignInUser signInUser) {
                if (!signInUser.isAuth){
                    //goToSignInActivity
                    Intent intent=new Intent(SplashActivity.this,SignInActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {

                  //  goToMainActivity
                    Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void initSplashViewModel() {
        signInViewModel=new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(SignInViewModel.class);
    }
}