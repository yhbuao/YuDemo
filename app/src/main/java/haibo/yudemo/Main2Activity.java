package haibo.yudemo;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;
import haibo.yudemo.base.BaseActivity;

public class Main2Activity extends BaseActivity {

    @BindView(R.id.bt)
    Button mBt;

    @Override
    protected int contentViewRes() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.t("main").d("Main2Activity : ");
    }

    @Override
    protected void initData() {
    }

    @OnClick(R.id.bt)
    public void onViewClicked() {
        Toast.makeText(this, "dianji", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com/"));
        startActivity(intent);
    }
}
