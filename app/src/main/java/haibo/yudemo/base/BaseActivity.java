package haibo.yudemo.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import haibo.library.Statusbar.StatusBarUtil;
import haibo.yudemo.R;

/**
 * @author: yuhaibo
 * @time: 2018/1/12 13:31.
 * projectName: YuDemo.
 * Description:Activity基类
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(contentViewRes());
        //根据状态栏颜色来决定状态栏文字用黑色还是白色
        StatusBarUtil.setStatusBarMode(this, true, R.color.statusBarColor);
        //设置所有Activity界面背景默认为白色
        //((ViewGroup) findViewById(android.R.id.content).getParent()).setBackgroundColor(Color.BLACK);
        //butterKnife绑定
        unbinder = ButterKnife.bind(this);

        initTitle();
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放ButterKnife的所有绑定
        unbinder.unbind();
    }

    //设置界面视图
    protected abstract int contentViewRes();

    // 初始化头部
    protected abstract void initTitle();

    //初始化界面
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();


    /**
     * findViewById 不需要再去强转
     */
    public <T extends View> T viewById(@IdRes int resId) {
        return (T) super.findViewById(resId);
    }

}
