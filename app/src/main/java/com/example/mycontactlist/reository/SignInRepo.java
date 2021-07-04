package com.example.mycontactlist.reository;

import androidx.lifecycle.MutableLiveData;

import com.example.mycontactlist.model.SignInUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInRepo {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private SignInUser user = new SignInUser();

    public MutableLiveData<SignInUser> checkAuthenticationInFirebase(){
        MutableLiveData<SignInUser> isAuthenticateLiveData =new MutableLiveData<>();

        FirebaseUser currentUser=firebaseAuth.getCurrentUser();
        if (currentUser==null){
            user.isAuth=false;
            isAuthenticateLiveData.setValue(user);
        }
        else {
            user.uId=currentUser.getUid();
            user.isAuth=true;
            isAuthenticateLiveData.setValue(user);
        }

        return isAuthenticateLiveData;
    }
}
