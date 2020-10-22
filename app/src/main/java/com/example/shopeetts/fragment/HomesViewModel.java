package com.example.shopeetts.fragment;

import androidx.lifecycle.MutableLiveData;

import com.example.shopeetts.adapter.CagetoryAdapter;
import com.example.shopeetts.adapter.SliderAdapterImage;
import com.example.shopeetts.base.BaseViewmodel;
import com.example.shopeetts.model.Cagetory;
import com.example.shopeetts.model.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class HomesViewModel extends BaseViewmodel {
    SliderAdapterImage adapterImage = new SliderAdapterImage();
    CagetoryAdapter cagetoryAdapter = new CagetoryAdapter();
    MutableLiveData<List<SliderItem>> arrImageSlide = new MutableLiveData<>();


    MutableLiveData<List<Cagetory>> arrCagetory = new MutableLiveData<>();
    public MutableLiveData<List<SliderItem>> getArrImageSlide() {
        List<SliderItem> list = new ArrayList<>();
        list.add(new SliderItem("https://cf.shopee.vn/file/67e108f93ec4f9caa5fe4fb1853fc7e9"));
        list.add(new SliderItem("https://magiamgiashopee.com/wp-content/uploads/2020/02/shopee-sieu-sale-11-11-1024x535-1.jpg"));
        list.add(new SliderItem("https://magiamgiashopee.vn/wp-content/uploads/2019/07/Si%C3%AAu-Sale-Freeship-Shopee.png.webp"));
        list.add(new SliderItem("https://cdn.chanhtuoi.com/uploads/2019/10/11-11-shopee-sieu-sale-01.jpg"));
        list.add(new SliderItem("https://muaodau.pro/wp-content/uploads/2019/11/shopee_02.11_3.jpg"));
        list.add(new SliderItem("https://saigonbiz.com.vn/wp-content/uploads/2018/11/Dai-tiec-mua-sam-lazada.jpg"));
        list.add(new SliderItem("https://bloggiamgia.vn/wp-content/uploads/2018/10/Lazada-khuy%E1%BA%BFn-m%C3%A3i-11-11.png.webp"));
        arrImageSlide.postValue(list);
        return arrImageSlide;
    }
    public MutableLiveData<List<Cagetory>> getArrCagetory() {
        List<Cagetory> list = new ArrayList<>();
        list.add(new Cagetory("1","Quần áo","https://vn-test-11.slatic.net/p/0ffe06dc5869c2dbb502f55d4e817b45.jpg"));
        list.add(new Cagetory("1","Túi và Ví","https://image.yes24.vn/Upload/ProductImage/xuanthu2018/1996212_L.jpg"));
        list.add(new Cagetory("1","ĐT và PK","https://cf.shopee.vn/file/64efe4e7cc5751e1e03979d5f0cbda85"));
        list.add(new Cagetory("1","Điện tử","https://lh3.googleusercontent.com/proxy/sZ6eEpzzU-QPvkVf4qQJFjOBSUs81laXvLCUEn0IhFc0GZIaLmtPHj-yj3IZo63bRSRX_cSto4dt7GvFBZBA14Yz8BdeSB9ILqmY50u5LFFwlYq3Jxiaz-zLpHo_EYgqtco1qAoYIiURH9ArvA"));
        list.add(new Cagetory("1","Máy quay","https://st.quantrimang.com/photos/image/2018/10/10/may-anh-gia-re-duoc-danh-gia-cao-7.jpg"));
        list.add(new Cagetory("1","Đồng hồ","https://lh3.googleusercontent.com/proxy/tIHLY8VJdurWMZ0WCC0GOwGFs8Y-sh1Ji-fFhP63iAo_GhgXifuKDh_NXG6YSDWtYbLnzR2-FbHkACzpaCOrdoY2c7MrlFeo8PCeqH1Kl2EKnnmq3znfGdf1xNtQNuzx_rEVKc7_y2b6PS-xQjW6lxccSBN83VFBZkuP7qheSwTFSOaIrCHaAYlDlVGQjgfRTGIxJSuq2boDlCHkHzoHlA"));
        list.add(new Cagetory("1","Giày dép","https://media3.scdn.vn/img3/2019/10_21/BBdEhi_simg_de2fe0_500x500_maxb.jpg"));
        list.add(new Cagetory("1","Laptop","https://phongvu.vn/cong-nghe/wp-content/uploads/2019/05/acer-nitro-5-2019.jpg"));

        list.add(new Cagetory("1","Quần áo","https://vn-test-11.slatic.net/p/0ffe06dc5869c2dbb502f55d4e817b45.jpg"));
        list.add(new Cagetory("1","Túi và Ví","https://image.yes24.vn/Upload/ProductImage/xuanthu2018/1996212_L.jpg"));
        list.add(new Cagetory("1","ĐT và PK","https://cf.shopee.vn/file/64efe4e7cc5751e1e03979d5f0cbda85"));
        list.add(new Cagetory("1","Điện tử","https://lh3.googleusercontent.com/proxy/sZ6eEpzzU-QPvkVf4qQJFjOBSUs81laXvLCUEn0IhFc0GZIaLmtPHj-yj3IZo63bRSRX_cSto4dt7GvFBZBA14Yz8BdeSB9ILqmY50u5LFFwlYq3Jxiaz-zLpHo_EYgqtco1qAoYIiURH9ArvA"));
        list.add(new Cagetory("1","Máy quay","https://st.quantrimang.com/photos/image/2018/10/10/may-anh-gia-re-duoc-danh-gia-cao-7.jpg"));
        list.add(new Cagetory("1","Đồng hồ","https://lh3.googleusercontent.com/proxy/tIHLY8VJdurWMZ0WCC0GOwGFs8Y-sh1Ji-fFhP63iAo_GhgXifuKDh_NXG6YSDWtYbLnzR2-FbHkACzpaCOrdoY2c7MrlFeo8PCeqH1Kl2EKnnmq3znfGdf1xNtQNuzx_rEVKc7_y2b6PS-xQjW6lxccSBN83VFBZkuP7qheSwTFSOaIrCHaAYlDlVGQjgfRTGIxJSuq2boDlCHkHzoHlA"));
        list.add(new Cagetory("1","Giày dép","https://media3.scdn.vn/img3/2019/10_21/BBdEhi_simg_de2fe0_500x500_maxb.jpg"));
        list.add(new Cagetory("1","Laptop","https://phongvu.vn/cong-nghe/wp-content/uploads/2019/05/acer-nitro-5-2019.jpg"));
         arrCagetory.postValue(list);
        return arrCagetory;
    }

}
