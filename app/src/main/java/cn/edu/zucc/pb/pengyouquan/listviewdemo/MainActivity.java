package cn.edu.zucc.pb.pengyouquan.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import cn.edu.zucc.pb.pengyouquan.listviewdemo.adapter.ListViewAdapter;
import cn.edu.zucc.pb.pengyouquan.listviewdemo.databean.ComentData;
import cn.edu.zucc.pb.pengyouquan.listviewdemo.databean.ContentData;
import cn.edu.zucc.pb.pengyouquan.listviewdemo.databean.LikeData;
import cn.edu.zucc.pb.pengyouquan.listviewdemo.databean.LinkData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter adapter;
    private View headView;
    private List data=new ArrayList();
    private ContentData[] contentDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initData();
    }

    private void init(){
        setContentView(R.layout.activity_main);
        adapter = new ListViewAdapter(this,data);
        headView = LayoutInflater.from(this).inflate(R.layout.header, null);
        listView = (ListView) findViewById(R.id.listView);
        listView.addHeaderView(headView, null, false);
        listView.setAdapter(adapter);

        ContentData contentData = new ContentData("测试1","内容测试，夕阳西下，断桥残雪");
        List images = new ArrayList();
        images.add(R.drawable.header);
        images.add(R.drawable.header);
        images.add(R.drawable.header);
        images.add(R.drawable.header);
        images.add(R.drawable.header);
        ContentData imagesData = new ContentData(images,"测试2","多图测试");
        List image = new ArrayList();
        image.add(R.drawable.headerbg);
        ContentData imageData = new ContentData(image,"测试3","单图测试");
        ContentData linkData = new ContentData("测试4","链接测试：https://www.baidu.com",new LinkData("https://www.baidu.com",R.drawable.header,"作为一个连接标题，我也是有个性的"));
        ContentData likeData = new ContentData("测试5","点赞测试");
        List likeDatas = new ArrayList();
        likeDatas.add(new LikeData("测试1"));
        likeDatas.add(new LikeData("测试2"));
        likeDatas.add(new LikeData("测试3"));
        likeDatas.add(new LikeData("测试4"));
        likeData.setLikeData(likeDatas);

        ContentData comentData = new ContentData("测试6","评论测试");
        List comentDatas = new ArrayList();
        comentDatas .add(new ComentData("测试1", "你这个是错误的答案", "测试2"));
        comentDatas .add(new ComentData("测试2", "我这个是正确的答案", "测试1"));
        comentDatas .add(new ComentData("测试3", "静静的看楼上在装", null));
        comentDatas .add(new ComentData("测试4", "+1", null));
        comentData.setComentDatas(comentDatas);
        comentData.setLikeData(likeDatas);
        contentDatas = new ContentData[]{contentData,imagesData,imageData,linkData,likeData,comentData};
    }

    private void initData(){
        //Random random = new Random();
        for(int i= 0;i<6;i++){
            data.add(contentDatas[i]);
        }
        adapter.notifyDataSetChanged();
    }
}
