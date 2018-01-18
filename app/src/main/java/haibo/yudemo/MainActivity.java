package haibo.yudemo;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import haibo.library.navigationbar.DefaultNavigationBar;
import haibo.yudemo.aop.CheckNet;
import haibo.yudemo.base.BaseActivity;

/**
 * @author User
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.tv)
    TextView mTv;

    @Override
    protected int contentViewRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initTitle() {
        DefaultNavigationBar defaultNavigationBar = new DefaultNavigationBar.Builder(this)
                .setTitle("第一个")
                .setLeftIcon(R.mipmap.zw_info_icon_previous)
                .setRightClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击啦！", Toast.LENGTH_LONG).show();
                    }
                })
                .setRightIcon(R.mipmap.ic_launcher)
                .builder();
        defaultNavigationBar.textView.setText("干啥");
    }

    @Override
    protected void initView() {
        mTv.setText("这是一个TextView");
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.tv)
    @CheckNet
    public void onViewClicked() {
        startActivity(new Intent(this, Main2Activity.class));
    }

}
