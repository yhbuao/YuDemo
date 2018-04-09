package haibo.yudemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import haibo.yudemo.R;

/**
 * @author: yuhaibo
 * @time: 2018/2/28 13:36.
 * projectName: YuDemo.
 * Description:
 */

public class FragmentB extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.layout_fragment, null);
        ((TextView) fragmentView.findViewById(R.id.tv)).setText("第二个界面");
        return fragmentView;
    }
}
