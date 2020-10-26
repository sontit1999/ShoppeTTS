package com.example.shopeetts.fragment;

import androidx.lifecycle.MutableLiveData;

import com.example.shopeetts.adapter.CagetoryAdapter;
import com.example.shopeetts.adapter.FlashSaleAdapter;
import com.example.shopeetts.adapter.ProductAdapter;
import com.example.shopeetts.adapter.SliderAdapterImage;
import com.example.shopeetts.base.BaseViewmodel;
import com.example.shopeetts.model.Cagetory;
import com.example.shopeetts.model.Product;
import com.example.shopeetts.model.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class HomesViewModel extends BaseViewmodel {
    SliderAdapterImage adapterImage = new SliderAdapterImage();
    CagetoryAdapter cagetoryAdapter = new CagetoryAdapter();
    FlashSaleAdapter flashSaleAdapter = new FlashSaleAdapter();
    ProductAdapter productAdapter = new ProductAdapter();
    MutableLiveData<List<SliderItem>> arrImageSlide = new MutableLiveData<>();
    MutableLiveData<List<Cagetory>> arrCagetory = new MutableLiveData<>();


    MutableLiveData<List<Product>> arrFlashSale = new MutableLiveData<>();
    public MutableLiveData<List<Product>> getArrFlashSale() {

        List<Product> list = new ArrayList<>();
//        list.add(new Product("1","Nước hoa","429 000đ","https://product.hstatic.net/1000025647/product/chance-eau-tendre-eau-de-parfum.png","51","Rất thơm","sale","30%","5"));
//        list.add(new Product("1","Iphone 12","4 290 000đ","https://img.fpt.shop/uploads/images/tin-tuc/109907/Originals/thong-tin-iPhone-12-1.jpg?imgeng=/cmpr_10","51","Rất thơm","sale","70%","5"));
//        list.add(new Product("1","Tai nghe","699 000đ","https://cf.shopee.vn/file/ff50a39b759ecd2c7e1395b79c1fa17d","51","Rất thơm","sale","50%","5"));
//        list.add(new Product("1","Ví nam","129 000đ","https://i-shop.vnecdn.net/resize/560/560/images/2019/03/09/5c832d40b3c9a-IMG_2124.jpg","51","Rất thơm","sale","20%","5"));
//        list.add(new Product("1","Đồng hồ","1 029 000đ","https://binhminhdigital.com/storedata/images/product/dong-ho-thong-minh-fitbit-versa-2-black-carbon-vn.jpg","51","Rất thơm","sale","40%","5"));
//        list.add(new Product("1","Son","429 000đ","https://kyo.vn/wp-content/uploads/2019/03/Son-3CE-Red-Recipe-Lip-Color.jpg","51","Rất thơm","sale","50%","5"));
//        list.add(new Product("1","Sạc dự phòng","299 000đ","https://cf.shopee.vn/file/49d00a883f9cef2302d3992e7cf0b4be","51","Rất thơm","sale","50%","5"));
//        list.add(new Product("1","Quần lót ren","59 000đ","https://img.zanado.com/media/catalog/product/cache/all/thumbnail/700x817/7b8fef0172c2eb72dd8fd366c999954c/1/2/combo_3_quan_lot_ren_goi_cam_04fa.jpg","51","Rất thơm","sale","50%","5"));
//        list.add(new Product("1","Túi sách","249 000đ","https://cdn.elly.vn/uploads/2019/07/13135847/tui-xach-nu-cao-cap-da-that-ELLY-ET112-5.jpg","51","Rất thơm","sale","10%","5"));
//        list.add(new Product("1","Ví nữ","19 000đ","https://cf.shopee.vn/file/c1d8ae1fd95a0d92c32a856c6690477c","51","Rất thơm","sale","80%","5"));
        arrFlashSale.postValue(list);

        return arrFlashSale;
    }

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
//        list.add(new Cagetory("1","Quần áo","https://vn-test-11.slatic.net/p/0ffe06dc5869c2dbb502f55d4e817b45.jpg"));
//        list.add(new Cagetory("1","Túi và Ví","https://image.yes24.vn/Upload/ProductImage/xuanthu2018/1996212_L.jpg"));
//        list.add(new Cagetory("1","ĐT và PK","https://cf.shopee.vn/file/64efe4e7cc5751e1e03979d5f0cbda85"));
//        list.add(new Cagetory("1","Điện tử","https://lh3.googleusercontent.com/proxy/sZ6eEpzzU-QPvkVf4qQJFjOBSUs81laXvLCUEn0IhFc0GZIaLmtPHj-yj3IZo63bRSRX_cSto4dt7GvFBZBA14Yz8BdeSB9ILqmY50u5LFFwlYq3Jxiaz-zLpHo_EYgqtco1qAoYIiURH9ArvA"));
//        list.add(new Cagetory("1","Máy quay","https://st.quantrimang.com/photos/image/2018/10/10/may-anh-gia-re-duoc-danh-gia-cao-7.jpg"));
//        list.add(new Cagetory("1","Đồng hồ","https://lh3.googleusercontent.com/proxy/tIHLY8VJdurWMZ0WCC0GOwGFs8Y-sh1Ji-fFhP63iAo_GhgXifuKDh_NXG6YSDWtYbLnzR2-FbHkACzpaCOrdoY2c7MrlFeo8PCeqH1Kl2EKnnmq3znfGdf1xNtQNuzx_rEVKc7_y2b6PS-xQjW6lxccSBN83VFBZkuP7qheSwTFSOaIrCHaAYlDlVGQjgfRTGIxJSuq2boDlCHkHzoHlA"));
//        list.add(new Cagetory("1","Giày dép","https://media3.scdn.vn/img3/2019/10_21/BBdEhi_simg_de2fe0_500x500_maxb.jpg"));
//        list.add(new Cagetory("1","Laptop","https://phongvu.vn/cong-nghe/wp-content/uploads/2019/05/acer-nitro-5-2019.jpg"));
//
//        list.add(new Cagetory("1","Sách","https://cafefcdn.com/thumb_w/640/2017/photo-0-1514690372366.jpg"));
//        list.add(new Cagetory("1","Đồ chơi","https://lh3.googleusercontent.com/proxy/bJOVVaCFAyGIkUN2OXcPVrHXUk3q3Y3vZxGFf2pVcXuMR1rVNRRZGIAN-ENWl3gOtrlWHGUZv1s1t1Bk_hIb9-0EXGmfF8jqfE3AcIsVk-rM-nVHs5sbFIE"));
//        list.add(new Cagetory("1","Phụ kiện thời trang","https://miro.medium.com/max/500/0*kO9IbbOsZIPKUBfC.jpg"));
//        list.add(new Cagetory("1","Đồ gia dụng","https://bigshop.vn/media/product/250_1510_noi_e_cook_deco_lock_lock_led2202_ih_20cm.jpg"));

         arrCagetory.postValue(list);
        return arrCagetory;
    }

}
