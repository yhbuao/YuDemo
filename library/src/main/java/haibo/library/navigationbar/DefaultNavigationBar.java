package haibo.library.navigationbar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import haibo.library.R;

/**
 * @author: yuhaibo
 * @time: 2018/1/18 11:37.
 * projectName: xhhread-android.
 * Description:默认的NavigationBar
 */

public class DefaultNavigationBar extends AbsNavigationBar<DefaultNavigationBar.Builder.DefaultNavigationBarParams> {
    public TextView textView;

    public DefaultNavigationBar(Builder.DefaultNavigationBarParams barParams) {
        super(barParams);
    }

    @Override
    public int bindHeadLayoutId() {
        return R.layout.layout1;
    }

    @Override
    public void applyView() {
        //绑定效果
        textView = setText(R.id.title, getParams().mTitle);
        setIcon(R.id.image, getParams().mRightRes);
        setIcon(R.id.toolbar,getParams().mLeftRes);
        setOnClickListener(R.id.image, getParams().mRightClickListener);
        setOnClickListener(R.id.toolbar, getParams().mLeftClickListener);
    }

    public static class Builder extends AbsNavigationBar.Builder {

        private DefaultNavigationBarParams p;

        public Builder(Context context, ViewGroup parent) {
            super(context, parent);
            p = new DefaultNavigationBarParams(context, parent);
        }

        public Builder(Context context) {
            super(context, null);
            p = new DefaultNavigationBarParams(context, null);
        }

        @Override
        public DefaultNavigationBar builder() {
            DefaultNavigationBar defaultNavigationBar = new DefaultNavigationBar(p);
            return defaultNavigationBar;
        }

        //设置所有效果

        /**
         * 设置title
         *
         * @param title
         * @return
         */
        public DefaultNavigationBar.Builder setTitle(String title) {
            p.mTitle = title;
            return this;
        }

        /**
         * 设置右边的文字
         *
         * @param rightText
         * @return
         */
        public DefaultNavigationBar.Builder setRightText(String rightText) {
            p.mRightText = rightText;
            return this;
        }

        /**
         * 设置左边的图片
         *
         * @param leftRes
         * @return
         */
        public DefaultNavigationBar.Builder setLeftIcon(int leftRes) {
            p.mLeftRes = leftRes;
            return this;
        }

        /**
         * 设置右边的图片
         *
         * @param rightRes
         * @return
         */
        public DefaultNavigationBar.Builder setRightIcon(int rightRes) {
            p.mRightRes = rightRes;
            return this;
        }

        /**
         * 设置右边的点击事件
         *
         * @param rightClickListener
         * @return
         */
        public DefaultNavigationBar.Builder setRightClickListener(View.OnClickListener rightClickListener) {
            p.mRightClickListener = rightClickListener;
            return this;
        }

        /**
         * 设置左边的点击事件
         *
         * @param leftClickListener
         * @return
         */
        public DefaultNavigationBar.Builder setLeftClickListener(View.OnClickListener leftClickListener) {
            p.mLeftClickListener = leftClickListener;
            return this;
        }

        public static class DefaultNavigationBarParams extends AbsNavigationBar.Builder.AbsNavigationBarParams {
            //放所有效果
            private String mTitle;
            private String mRightText;
            private int mLeftRes;
            private int mRightRes;
            private View.OnClickListener mRightClickListener;
            private View.OnClickListener mLeftClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Activity) mContext).finish();
                }
            };

            public DefaultNavigationBarParams(Context context, ViewGroup parent) {
                super(context, parent);
            }
        }
    }
}
