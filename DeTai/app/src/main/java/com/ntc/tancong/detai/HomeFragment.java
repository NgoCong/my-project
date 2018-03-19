package com.ntc.tancong.detai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by tanco on 3/11/2018.
 */

public class HomeFragment extends Fragment {

    ArrayList<Item> list;
    AdapterNewsfeed adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list=new ArrayList<Item>();
        list.add(new Item("Thông báo về việc quản lý vận hành hầm xe, dịch vụ bảo vệ từ 1/4/2017","\n" +
                "Thông báo về việc quản lý vận hành hầm xe, dịch vụ bảo vệ từ 1/4/2017\n" +
                "30/03/2017 CCPT Ban Quản Trị\n" +
                "\n" +
                "Kính gửi:     QUÝ CƯ DÂN CHUNG CƯ PHÚ THẠNH\n" +
                "\n" +
                "Thực hiện quy chế quản lý, sử dụng nhà chung cư thông tư số 02/2016/TT-BXD ngày 15/02/2016 của Bộ Xây Dựng;\n" +
                "\n" +
                "BAN QUẢN TRỊ CHUNG CƯ PHÚ THẠNH (BQT) XIN THÔNG BÁO:\n" +
                "\n" +
                "    BQT không tiếp tục ký kết hợp đồng trực tiếp với các đơn vị cung ứng dịch vụ bảo vệ an ninh và quản lý hầm xe tại chung cư Phú Thạnh.\n" +
                "\n" +
                "    Kể từ ngày 31/03/2017, các hợp đồng cung ứng dịch vụ tại chung cư Phú Thạnh được giao cho đơn vị quản lý vận hành nhà chung cư (hiện nay là Cty CP Môi Trường Sống Sạch), các hợp đồng trước đây do BQT ký trực tiếp với các đối tác không còn hiệu lực.\n" +
                "\n" +
                "    Công tác bảo vệ an ninh tại chung cư Phú Thạnh và công tác quản lý vận hành hầm xe được giao cho đơn vị quản lý vận hành nhà chung cư Phú Thạnh (BQL) hiện nay là Cty CP Môi Trường Sống Sạch đảm nhận và chịu trách nhiệm (Thực hiện đúng tinh thần thông tư 02).\n" +
                "\n" +
                "Kính thông báo quý cư dân, trân trọng./.","25/03/2017"));
        adapter= new AdapterNewsfeed(getActivity(),list);
        ListView lvNewsfeed  = (ListView) view.findViewById(R.id.lvNewsfeed);
        lvNewsfeed.setAdapter(adapter);

    }
}
