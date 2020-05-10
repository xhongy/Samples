package cn.coco.annotationtest;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import cn.coco.annotationtest.Inject.InjectUtil;
import cn.coco.annotationtest.Inject.InjectView;
import cn.coco.annotationtest.Inject.InjectData;

public class InjectTestActivity extends AppCompatActivity {

    @InjectView(R.id.tv)
    TextView tv;

    @InjectData("name1")
    String name1;
    @InjectData("name2")
    String name2;
    @InjectData("name3")
    String name3;
    @InjectData("name4")
    String name4;
    @InjectData("name5")
    String name5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        InjectUtil.injectView(this);
        InjectUtil.injectData(this);

        tv.setText("name1="+name1+"\n"+"name2="+name2+"\n"+"name2="+name2+"\n"+"name2="+name2+"\n"+"name2="+name2+"\n");
    }
}
