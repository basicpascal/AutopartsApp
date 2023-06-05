package com.mirea.autopartsapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Part implements Parcelable {
    private String name;
    private String description;

    public Part(String name, String description) {
        this.name = name;
        this.description = description;
    }

    protected Part(Parcel in) {
        name = in.readString();
        description = in.readString();
    }

    public static final Creator<Part> CREATOR = new Creator<Part>() {
        @Override
        public Part createFromParcel(Parcel in) {
            return new Part(in);
        }

        @Override
        public Part[] newArray(int size) {
            return new Part[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
    }
}
