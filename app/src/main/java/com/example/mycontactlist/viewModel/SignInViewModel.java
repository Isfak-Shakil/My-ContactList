package com.example.mycontactlist.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mycontactlist.model.SignInUser;
import com.example.mycontactlist.reository.SignInRepo;

public class SignInViewModel extends AndroidViewModel {
   private SignInRepo repository;
   public LiveData<SignInUser> checkAuthenticateLiveData;
    public SignInViewModel(@NonNull Application application) {
        super(application);

        repository=new SignInRepo();
    }
    public void checkAuthenticate(){
        checkAuthenticateLiveData=repository.checkAuthenticationInFirebase();
    }
}
