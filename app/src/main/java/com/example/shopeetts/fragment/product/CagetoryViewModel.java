package com.example.shopeetts.fragment.product;

import androidx.lifecycle.MutableLiveData;

import com.example.shopeetts.adapter.ProductAdapter;
import com.example.shopeetts.base.BaseViewmodel;
import com.example.shopeetts.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CagetoryViewModel extends BaseViewmodel {
    ProductAdapter productAdapter = new ProductAdapter();
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
}
