package com.example.mycontactlist.reository;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.mycontactlist.model.SignInUser;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInRepo {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private SignInUser user = new SignInUser();
// check in login  or not
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
    // sign in user
    public MutableLiveData<String>  firebaseSignInGoogle(AuthCredential authCredential){
        MutableLiveData<String> authMutableLiveData=new MutableLiveData<>();
        firebaseAuth.signInWithCredential(authCredential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
        FirebaseUser currentUser=firebaseAuth.getCurrentUser();
        String uId=currentUser.getUid();
        authMutableLiveData.setValue(uId);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
              authMutableLiveData.setValue(e.toString());
            }
        });
        return authMutableLiveData;
    }
}
