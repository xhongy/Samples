package cn.coco.annotationtest;

import androidx.appcompat.app.AppCompatActivity;
import cn.coco.annotationlib.AnnotationTest;
import cn.coco.annotationtest.Inject.InjectUtil;
import cn.coco.annotationtest.Inject.InjectView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

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
        ArrayList<CustomerParcelable> parcelables = new ArrayList<>();
        parcelables.add(new CustomerParcelable("lili",10));

        Intent intent = new Intent(this, InjectTestActivity.class);
        intent.putExtra("name","coco")
                .putExtra("attr","你好！")
                .putExtra("array",new int[]{1,2,3,4,5,6})
                .putExtra("customerParcelable",new CustomerParcelable("Jact", 13))
                .putExtra("customerParcelables",new CustomerParcelable[]{new CustomerParcelable("曹", 13)})
                .putExtra("users",new CustomerSericalizable[]{new CustomerSericalizable("zhang", 23)})
                .putExtra("strs",new String[]{"test1","test2"})
                .putParcelableArrayListExtra("parcelables",parcelables);
        startActivity(intent);
    }
}
