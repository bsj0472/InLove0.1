package com.b_s_j.inlove01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.daum.mf.map.api.MapView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tab1_MovieFragment extends Fragment {

    String apiKey="e8d3f57f29784395ad562feb53810cbd";

    ArrayAdapter adapter;

    ArrayList<String>items=new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_tab1movie,container,false);

        ListView listView = new ListView(getActivity());
        adapter= new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        return v;
    }


    public void clickMovie(View view){
       Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                items.clear();

                Date date = new Date();//지금 날짜 시간객체
                date.setTime(date.getTime() - (1000 * 60 * 60 * 24));//지금날짜 -1 날짜

                SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
                String dateStr = sdf.format(date);
                String adress = " http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml"
                        + "?key=" + apiKey
                        + "&targetDt" + dateStr
                        + "&itemPerPage=10";

                try {
                    URL url = new URL(adress);
                    InputStream is = url.openStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    //  XML 문서를 분석(parse)해주는 객체 생성
                    // Factory  필요해서 팩토리 만들고 pullparser 를 만듬 그리고 pullparser 에게 isr 연결
                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    XmlPullParser xpp = factory.newPullParser();
                    xpp.setInput(isr);

                    int eventType = xpp.getEventType();

                    String tagName;
                    StringBuffer buffer = null;

                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        switch (eventType) {
                            case XmlPullParser.START_DOCUMENT:
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getActivity(), "파싱중입니다.", Toast.LENGTH_SHORT).show();

                                    }
                                });
                                break;

                            case XmlPullParser.START_TAG:
                                tagName = xpp.getName();
                                if (tagName.equals("dailyBoxOffice")) {
                                    buffer = new StringBuffer();
                                } else if (tagName.equals("rank")) {
                                    buffer.append("순위");
                                    xpp.next();
                                    buffer.append(xpp.getText() + "\n");
                                    String text = xpp.getText();
                                    buffer.append(text + "\n");
                                } else if (tagName.equals("movieNm")) {
                                    buffer.append("제목:");
                                    xpp.next();
                                    buffer.append(xpp.getText() + "\n");

                                } else if (tagName.equals("openDt")) {
                                    buffer.append("개봉일:");
                                    xpp.next();
                                    buffer.append(xpp.getText() + "\n");

                                } else if (tagName.equals("audiAcc")) {
                                    buffer.append("누적관객수:");
                                    xpp.next();
                                    buffer.append(xpp.getText() + "\n");
                                }
                                break;

                            case XmlPullParser.TEXT:
                                break;
                            case XmlPullParser.END_TAG:
                                tagName = xpp.getName();
                                if (tagName.equals("dailyBoxOffice")) {
                                    items.add(buffer.toString());

                                    //listview
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            adapter.notifyDataSetChanged();
                                        }
                                    });
                                }
                                break;
                        }
                        eventType = xpp.next();
                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "파싱완료", Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }


            }
        };
        t.start();
    }


}
