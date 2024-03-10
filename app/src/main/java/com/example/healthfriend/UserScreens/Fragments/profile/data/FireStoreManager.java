package com.example.healthfriend.UserScreens.Fragments.profile.data;

import com.example.healthfriend.UserScreens.Fragments.profile.domain.EditUserCallback;
import com.example.healthfriend.UserScreens.Fragments.profile.domain.GetUserCallback;
import com.example.healthfriend.UserScreens.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;


public class FireStoreManager {
    private FirebaseFirestore db;
    public FireStoreManager(FirebaseFirestore db) {
        this.db = db;
    }

    public void getUser(final GetUserCallback callback) {  // Change return type to void
        db.collection("Users")
                .document(User.getInstance().getEmail())
                .collection("personal_info")
                .document("data")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        DocumentSnapshot doc = task.getResult();
                        if (doc != null) {
                            ProfileUser user = new ProfileUser(
                                    String.valueOf(doc.getLong("weight")),
                                    String.valueOf(doc.getLong("height")),
                                    String.valueOf(doc.getLong("gender")),
                                    String.valueOf(doc.getLong("age"))
//                                    doc.getString("weight"),
//                                    doc.getString("height"),
//                                    doc.getString("gender"),
//                                    doc.getString("age")
                            );
                            callback.onSuccess(user);  // Notify success
                        } else {
                            callback.onError("No document found");  // Handle missing document
                        }
                    } else {
                        callback.onError(Objects.requireNonNull(task.getException()).getMessage());  // Handle task failure
                    }
                });
    }

    public void editWeight(String value, final EditUserCallback callback) {
        db.collection("Users")
                .document(User.getInstance().getEmail())
                .collection("personal_info")
                .document("data")
                .update("weight", value)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        callback.onSuccess();
                    } else {
                        callback.onError(Objects.requireNonNull(task.getException()).getMessage());
                    }
                });
    }

    public void editHeight(String value, final EditUserCallback callback) {
        db.collection("Users")
                .document(User.getInstance().getEmail())
                .collection("personal_info")
                .document("data")
                .update("height", value)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        callback.onSuccess();
                    } else {
                        callback.onError(Objects.requireNonNull(task.getException()).getMessage());
                    }
                });
    }
    public void editAge(String value, final EditUserCallback callback) {
        db.collection("Users")
                .document(User.getInstance().getEmail())
                .collection("personal_info")
                .document("data")
                .update("age", value)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        callback.onSuccess();
                    } else {
                        callback.onError(Objects.requireNonNull(task.getException()).getMessage());
                    }
                });
    }
    public void editGender(String value, final EditUserCallback callback) {
        db.collection("Users")
                .document(User.getInstance().getEmail())
                .collection("personal_info")
                .document("data")
                .update("gender", value)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        callback.onSuccess();
                    } else {
                        callback.onError(Objects.requireNonNull(task.getException()).getMessage());
                    }
                });
    }
    public void editTarget(String value, final EditUserCallback callback) {
        db.collection("Users")
                .document(User.getInstance().getEmail())
                .collection("personal_info")
                .document("data")
                .update("target", value)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        callback.onSuccess();
                    } else {
                        callback.onError(Objects.requireNonNull(task.getException()).getMessage());
                    }
                });
    }
    public void editCalories(String value, final EditUserCallback callback) {
        db.collection("Users")
                .document(User.getInstance().getEmail())
                .collection("personal_info")
                .document("data")
                .update("calories", value)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        callback.onSuccess();
                    } else {
                        callback.onError(Objects.requireNonNull(task.getException()).getMessage());
                    }
                });
    }
}
