package com.test.hellohuaweimaps;

import android.os.Parcel;
import android.os.Parcelable;

import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;

public class MyModel implements Parcelable {

    private int anInt;
    private Integer aIntegerObject;
    private Float aFloat;
    private Float aFloatObject;
    private double aDoubke;
    private Double aDoubleObject;

    public Float getaFloat() {
        return aFloat;
    }

    public void setaFloat(Float aFloat) {
        this.aFloat = aFloat;
    }

    public Float getaFloatObject() {
        return aFloatObject;
    }

    public void setaFloatObject(Float aFloatObject) {
        this.aFloatObject = aFloatObject;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public Integer getaIntegerObject() {
        return aIntegerObject;
    }

    public void setaIntegerObject(Integer aIntegerObject) {
        this.aIntegerObject = aIntegerObject;
    }

    public double getaDoubke() {
        return aDoubke;
    }

    public void setaDoubke(double aDoubke) {
        this.aDoubke = aDoubke;
    }

    public Double getaDoubleObject() {
        return aDoubleObject;
    }

    public void setaDoubleObject(Double aDoubleObject) {
        this.aDoubleObject = aDoubleObject;
    }


    public MyModel() {

    }

    protected MyModel(Parcel in) {

        ParcelReader parcelReader = new ParcelReader(in);

        anInt = parcelReader.readInt(0, -1);
        aIntegerObject = parcelReader.readIntegerObject(1, null);
        aFloat = parcelReader.readFloat(2, -1f);
        aFloatObject = parcelReader.readFloatObject(3, null);
        aDoubke = parcelReader.readDouble(4, -1.0);
        aDoubleObject = parcelReader.readDoubleObject(5, null);

    }

    public static final Creator<MyModel> CREATOR = new Creator<MyModel>() {
        @Override
        public MyModel createFromParcel(Parcel in) {
            return new MyModel(in);
        }

        @Override
        public MyModel[] newArray(int size) {
            return new MyModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        ParcelWrite parcelWrite = new ParcelWrite(dest);
        int result = parcelWrite.beginObjectHeader();

        parcelWrite.writeInt(0, anInt);
        parcelWrite.writeIntegerObject(1, aIntegerObject, false);
        parcelWrite.writeFloat(2, aFloat);
        parcelWrite.writeFloatObject(3, aFloatObject, false);
        parcelWrite.writeDouble(4, aDoubke);
        parcelWrite.writeDoubleObject(5, aDoubleObject, false);

        parcelWrite.finishObjectHeader(result);
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "anInt=" + anInt +
                ", aIntegerObject=" + aIntegerObject +
                ", aFloat=" + aFloat +
                ", aFloatObject=" + aFloatObject +
                ", aDoubke=" + aDoubke +
                ", aDoubleObject=" + aDoubleObject +
                '}';
    }
}