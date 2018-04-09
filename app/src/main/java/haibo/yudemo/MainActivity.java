package haibo.yudemo;

import android.content.Intent;
import android.view.View;
import android.widget.RadioGroup;

import haibo.library.navigationbar.DefaultNavigationBar;
import haibo.yudemo.base.BaseActivity;
import haibo.yudemo.fragment.FragmentA;
import haibo.yudemo.fragment.FragmentB;
import haibo.yudemo.fragment.FragmentC;
import haibo.yudemo.fragment.FragmentD;
import haibo.yudemo.fragment.FragmentManagerHelper;

/**
 * @author User
 */
public class MainActivity extends BaseActivity {
    private FragmentManagerHelper fragmentManagerHelper;
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;
    private FragmentD fragmentD;

    @Override
    protected int contentViewRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initTitle() {
        new DefaultNavigationBar.Builder(this)
                .setTitle("第")
                .setLeftIcon(R.mipmap.zw_info_icon_previous)
                .setRightClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, Main2Activity.class));
                    }
                })
                .setRightIcon(R.mipmap.ic_launcher)
                .builder();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        fragmentManagerHelper = new FragmentManagerHelper(getSupportFragmentManager(), R.id.main_frameLayout);
        fragmentA = new FragmentA();
        fragmentManagerHelper.add(fragmentA);

        ((RadioGroup) findViewById(R.id.radioGroup)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        if (fragmentA == null) {
                            fragmentA = new FragmentA();
                        }
                        fragmentManagerHelper.switchFragment(fragmentA);
                        break;
                    case R.id.radioButton2:
                        if (fragmentB == null) {
                            fragmentB = new FragmentB();
                        }
                        fragmentManagerHelper.switchFragment(fragmentB);
                        break;
                    case R.id.radioButton3:
                        if (fragmentC == null) {
                            fragmentC = new FragmentC();
                        }
                        fragmentManagerHelper.switchFragment(fragmentC);
                        break;
                    case R.id.radioButton4:
                        if (fragmentD == null) {
                            fragmentD = new FragmentD();
                        }
                        fragmentManagerHelper.switchFragment(fragmentD);
                        break;
                }
            }
        });

    }

}
