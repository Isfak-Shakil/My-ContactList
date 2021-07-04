package com.example.mycontactlist.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mycontactlist.model.SignInUser;
import com.example.mycontactlist.reository.SignInRepo;
import com.google.firebase.auth.AuthCredential;

public class SignInViewModel extends AndroidViewModel {
   private SignInRepo repository;
   public LiveData<SignInUser> checkAuthenticateLiveData;
   public LiveData<String> authenticateLiveData;
    public SignInViewModel(@NonNull Application application) {
        super(application);

        repository=new SignInRepo();
    }
    public   void  signInWithGoogle(AuthCredential authCredential){
        authenticateLiveData=repository.firebaseSignInGoogle(authCredential);
    }
    public void checkAuthenticate(){
        checkAuthenticateLiveData=repository.checkAuthenticationInFirebase();
    }
}
