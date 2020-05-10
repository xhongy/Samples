package cn.coco.annotationtest;

import androidx.appcompat.app.AppCompatActivity;
import cn.coco.annotationlib.AnnotationTest;
import cn.coco.annotationtest.Inject.InjectUtil;
import cn.coco.annotationtest.Inject.InjectView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @AnnotationTest("帅")
    public int num;
    @AnnotationTest(value="帅",age = 2)
    public int num2;

    @InjectView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtil.injectView(this);
        tv.setText("Coco 你好！！！");
    }

    public void clicked(View v){
        Intent intent = new Intent(this, InjectTestActivity.class);
        intent.putExtra("name1","coco1");
        intent.putExtra("name2","coco2");
        intent.putExtra("name3","coco3");
        intent.putExtra("name4","coco4");
        intent.putExtra("name5","coco5");
        startActivity(intent);
    }
}
