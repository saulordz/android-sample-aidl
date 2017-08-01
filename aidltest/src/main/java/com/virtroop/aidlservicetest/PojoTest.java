package com.virtroop.aidlservicetest;

import android.os.Parcel;
import android.os.Parcelable;

public class PojoTest implements Parcelable {

    private int _id;
    private String name;

    public PojoTest() {
    }

    protected PojoTest(Parcel in) {
        _id = in.readInt();
        name = in.readString();
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final Creator<PojoTest> CREATOR = new Creator<PojoTest>() {
        @Override
        public PojoTest createFromParcel(Parcel in) {
            return new PojoTest(in);
        }

        @Override
        public PojoTest[] newArray(int size) {
            return new PojoTest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_id);
        parcel.writeString(name);
    }

    @Override
    public String toString() {
        return "id: " + _id + "\t name:" + name;
    }
}
