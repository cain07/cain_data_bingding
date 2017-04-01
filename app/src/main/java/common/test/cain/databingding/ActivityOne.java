package common.test.cain.databingding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import common.test.cain.databingding.databinding.ActivityOneBinding;

public class ActivityOne extends Activity {

    private final static String tag ="ActivityOne";

    private User user;
    private ActivityOneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_one);
        user = new User("Test", "User");
        binding.setUser(user);
        binding.setView(this);


        binding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup bindingRoot = (ViewGroup) binding.getRoot();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(bindingRoot);
                }
                return true;
            }
        });

    }


    public void btnClick(View v){
        Log.e(tag,"btnClick");
        user.setFirstName("mayun");
        user.setLastName("liuqiangdong");

    }
}
