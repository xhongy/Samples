package cn.coco.annotationtest;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import cn.coco.annotationtest.Inject.InjectUtil;
import cn.coco.annotationtest.Inject.InjectView;
import cn.coco.annotationtest.Inject.InjectData;

public class InjectTestActivity extends AppCompatActivity {

    @InjectView(R.id.tv)
    TextView tv;

    @InjectData
    String name;
    @InjectData("attr")
    String attr;
    @InjectData
    int[] array;
    @InjectData
    CustomerParcelable customerParcelable;
    @InjectData
    CustomerParcelable[] customerParcelables;
    @InjectData
    List<CustomerParcelable> parcelables;
    @InjectData("users")
    CustomerSericalizable[] customerSericalizables;
    @InjectData("strs")
    String[] strs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        InjectUtil.injectView(this);
        InjectUtil.injectData(this);
         String temp ="";
         temp = "name="+name+"\n" +
                 "attr="+attr+"\n"+
                 "array="+ Arrays.toString(array)+"\n"+
                 "customerParcelable="+customerParcelable.getName()+"  "+customerParcelable.getAge()+"\n"+
                 "customerParcelables="+customerParcelables[0].getName()+"\n"+
                 "parcelables="+parcelables.get(0).getName()+"  "+parcelables.get(0).getAge()+"\n"+
                 "customerSericalizables="+customerSericalizables[0].getName()+"\n"+
                 "strs="+Arrays.toString(strs);

        tv.setText(temp);
    }
}
