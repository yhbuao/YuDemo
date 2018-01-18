package haibo.yudemo.aop;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;


/**
 * @author: yuhaibo
 * @time: 2018/1/15 16:24.
 * projectName: YuDemo.
 * Description:处理切点
 */
@Aspect
public class SectionAspect {

    /**
     * 找到要处理的切点
     * * *(..) 代表处理所有方法
     */
    @Pointcut("execution(@haibo.yudemo.aop.CheckNet * *(..))")
    public void executionAspectJ() {
    }

    /**
     * 处理切点
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("executionAspectJ()")
    public Object aroundAspectJ(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.i("处理切点", "hjdfhsdsjhnlhz");
        //1.获取CheckNet 注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckNet checkNet = signature.getMethod().getAnnotation(CheckNet.class);
        if (checkNet != null) {
            //2.判断有没有网络
            Object object = joinPoint.getThis();
            Context context = getContext(object);
            if (context != null) {
                if (!isNetworkAvalible(context)) {
                    //3.没有网络不往下执行
                    Toast.makeText(context, "请您链接网络！", Toast.LENGTH_LONG).show();
                    return null;
                } else {
                    Toast.makeText(context, "有网络", Toast.LENGTH_LONG).show();
                }
            }
        }
        return joinPoint.proceed();
    }

    /**
     * 获取Context
     *
     * @param object
     * @return
     */
    private Context getContext(Object object) {
        if (object instanceof Activity) {
            return (Activity) object;
        } else if (object instanceof Fragment) {
            return ((Fragment) object).getActivity();
        } else if (object instanceof View) {
            return ((View) object).getContext();
        }
        return null;
    }

    /**
     * 判断网络情况
     *
     * @param context 上下文
     * @return false 表示没有网络 true 表示有网络
     */
    private static boolean isNetworkAvalible(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
