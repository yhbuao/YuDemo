package haibo.library.navigationbar;

/**
 * @author: yuhaibo
 * @time: 2018/1/18 11:11.
 * projectName: xhhread-android.
 * Description:定义一套导航栏规范
 */

public interface INavigationBar {
    /**
     * 头部的布局id
     *
     * @return
     */
    public int bindHeadLayoutId();

    /**
     * 绑定头部的参数
     */
    public void applyView();
}
