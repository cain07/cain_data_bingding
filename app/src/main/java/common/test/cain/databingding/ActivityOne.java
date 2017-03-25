package common.test.cain.databingding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import common.test.cain.databingding.databinding.ActivityOneBinding;

public class ActivityOne extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        ActivityOneBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_one);
        User user = new User("Test", "User");
        binding.setUser(user);

    }
}
