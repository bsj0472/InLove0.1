package com.b_s_j.inlove01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Tab1_MapFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab1map,container,false);

        //카카오,기상청,영화 api가져와 뷰활용해서 보여주기, firebase설정해서 사진 대화 연결 앨범을 세로는 시간대 가로로 사진을 리스트뷰로 , 채팅은 대충 채팅, 캘린더 만들고 더보기에 설정들 하기
        //firebase 연동하니까 오류남ㅣㅏㅟㅏㅜ
    }
}
