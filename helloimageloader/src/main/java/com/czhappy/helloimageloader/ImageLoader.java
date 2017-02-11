package com.czhappy.helloimageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.czhappy.helloimageloader.core.LocalCacheUtils;
import com.czhappy.helloimageloader.core.MemoryCacheUtils;
import com.czhappy.helloimageloader.core.NetCacheUtils;
import com.czhappy.helloimageloader.utils.LogUtil;
import com.czhappy.helloimageloader.utils.Utils;

/**
 * Description:网络图片加载工具类
 * User: chenzheng
 * Date: 2017/2/11 0011
 * Time: 11:21
 */
public class ImageLoader {

    private static ImageLoader mInstance = null;

    private NetCacheUtils mNetCacheUtils;
    private LocalCacheUtils mLocalCacheUtils;
    private MemoryCacheUtils mMemoryCacheUtils;

    public static ImageLoader getInstance(){
        if(mInstance==null){
            synchronized (ImageLoader.class){
                if(mInstance==null){
                    mInstance = new ImageLoader();
                }
            }
        }
        return mInstance;
    }

    private ImageLoader(){
        mMemoryCacheUtils=new MemoryCacheUtils();
        mLocalCacheUtils=new LocalCacheUtils();
        mNetCacheUtils=new NetCacheUtils(mLocalCacheUtils,mMemoryCacheUtils);
    }

    /**
     * 加载网络图片
     * @param mImageView
     * @param url
     */
    public void loadImageView(ImageView mImageView, String url) {
        mImageView.setImageResource(R.drawable.empty_photo);
        if(Utils.isEmpty(url)){
            return;
        }
        Bitmap bitmap;
        //内存缓存
        LogUtil.i("尝试从内存中获取图片...");
        bitmap=mMemoryCacheUtils.getBitmapFromMemory(url);
        if (bitmap!=null){
            mImageView.setImageBitmap(bitmap);
            return;
        }

        //本地缓存
        LogUtil.i("尝试从本地获取图片...");
        bitmap = mLocalCacheUtils.getBitmapFromLocal(url);
        if(bitmap !=null){
            mImageView.setImageBitmap(bitmap);
            //从本地获取图片后,保存至内存中
            mMemoryCacheUtils.setBitmapToMemory(url,bitmap);
            return;
        }
        //网络缓存
        LogUtil.i("尝试从网络获取图片...");
        mNetCacheUtils.getBitmapFromNet(mImageView,url);
    }
}
