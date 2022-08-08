package com.coder.nha.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Truyen implements Parcelable {

    private String TenTruyen;
    private String LinkAnh;
    private String TenChap;
    private String TheLoai;
    private String TacGia;
    private String DichGia;
    private String GioiThieu;
    private String DTruyen;
    private String Loai;
    private String LTruyen;
    private List<String> ImgAnh;
    private int LLike, LBinhLuan, LChiaSe;

    public Truyen() {
    }

    protected Truyen(Parcel in) {
        TenTruyen = in.readString();
        LinkAnh = in.readString();
        TenChap = in.readString();
        TheLoai = in.readString();
        TacGia = in.readString();
        DichGia = in.readString();
        GioiThieu = in.readString();
        DTruyen = in.readString();
        Loai = in.readString();
        LTruyen = in.readString();
        ImgAnh = in.createStringArrayList();
        LLike = in.readInt();
        LBinhLuan = in.readInt();
        LChiaSe = in.readInt();
    }

    public static final Creator<Truyen> CREATOR = new Creator<Truyen>() {
        @Override
        public Truyen createFromParcel(Parcel in) {
            return new Truyen(in);
        }

        @Override
        public Truyen[] newArray(int size) {
            return new Truyen[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TenTruyen);
        dest.writeString(LinkAnh);
        dest.writeString(TenChap);
        dest.writeString(TheLoai);
        dest.writeString(TacGia);
        dest.writeString(DichGia);
        dest.writeString(GioiThieu);
        dest.writeString(DTruyen);
        dest.writeString(Loai);
        dest.writeString(LTruyen);
        dest.writeStringList(ImgAnh);
        dest.writeInt(LLike);
        dest.writeInt(LBinhLuan);
        dest.writeInt(LChiaSe);
    }

    public String getTenTruyen() {
        return TenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        TenTruyen = tenTruyen;
    }

    public String getLinkAnh() {
        return LinkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        LinkAnh = linkAnh;
    }

    public String getTenChap() {
        return TenChap;
    }

    public void setTenChap(String tenChap) {
        TenChap = tenChap;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {
        TacGia = tacGia;
    }

    public String getDichGia() {
        return DichGia;
    }

    public void setDichGia(String dichGia) {
        DichGia = dichGia;
    }

    public String getGioiThieu() {
        return GioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        GioiThieu = gioiThieu;
    }

    public String getDTruyen() {
        return DTruyen;
    }

    public void setDTruyen(String DTruyen) {
        this.DTruyen = DTruyen;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public String getLTruyen() {
        return LTruyen;
    }

    public void setLTruyen(String LTruyen) {
        this.LTruyen = LTruyen;
    }

    public List<String> getImgAnh() {
        return ImgAnh;
    }

    public void setImgAnh(List<String> imgAnh) {
        ImgAnh = imgAnh;
    }

    public int getLLike() {
        return LLike;
    }

    public void setLLike(int LLike) {
        this.LLike = LLike;
    }

    public int getLBinhLuan() {
        return LBinhLuan;
    }

    public void setLBinhLuan(int LBinhLuan) {
        this.LBinhLuan = LBinhLuan;
    }

    public int getLChiaSe() {
        return LChiaSe;
    }

    public void setLChiaSe(int LChiaSe) {
        this.LChiaSe = LChiaSe;
    }

    public static Creator<Truyen> getCREATOR() {
        return CREATOR;
    }

    public Truyen(String tenTruyen, String linkAnh, String tenChap, String theLoai, String tacGia, String dichGia, String gioiThieu, String DTruyen, String loai, String LTruyen, List<String> imgAnh, int LLike, int LBinhLuan, int LChiaSe) {
        TenTruyen = tenTruyen;
        LinkAnh = linkAnh;
        TenChap = tenChap;
        TheLoai = theLoai;
        TacGia = tacGia;
        DichGia = dichGia;
        GioiThieu = gioiThieu;
        this.DTruyen = DTruyen;
        Loai = loai;
        this.LTruyen = LTruyen;
        ImgAnh = imgAnh;
        this.LLike = LLike;
        this.LBinhLuan = LBinhLuan;
        this.LChiaSe = LChiaSe;
    }
}
