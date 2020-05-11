package cn.coco.annotationtest;

import android.os.Parcel;
import android.os.Parcelable;

public class CustomerParcelable implements Parcelable {

    private int id;
    private String name;
    private int age;


    public CustomerParcelable() {
        super();
    }

    public CustomerParcelable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(age);
    }

    public static final Parcelable.Creator<CustomerParcelable> CREATOR = new Creator<CustomerParcelable>() {
        @Override
        public CustomerParcelable createFromParcel(Parcel source) {
            CustomerParcelable CustomerParcelable = new CustomerParcelable();
            CustomerParcelable.id = source.readInt();
            CustomerParcelable.name = source.readString();
            CustomerParcelable.age = source.readInt();
            return CustomerParcelable;
        }

        @Override
        public CustomerParcelable[] newArray(int size) {
            return new CustomerParcelable[0];
        }
    };

//    protected CustomerParcelable(Parcel in) {
//    }
//
//    public static final Creator<CustomerParcelable> CREATOR = new Creator<CustomerParcelable>() {
//        @Override
//        public CustomerParcelable createFromParcel(Parcel in) {
//            return new CustomerParcelable(in);
//        }
//
//        @Override
//        public CustomerParcelable[] newArray(int size) {
//            return new CustomerParcelable[size];
//        }
//    };
}
