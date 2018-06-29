package com.shoumipay.domain;

public class CertificationFile {
    private Long id;

    private Long memberid;

    private String idcardFrontPhotoPath;

    private String idcardPortraitPhotoPath;

    private String idcardBackPhotoPath;

    private String livingPhotoPath;

    private String livingVideoPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public String getIdcardFrontPhotoPath() {
        return idcardFrontPhotoPath;
    }

    public void setIdcardFrontPhotoPath(String idcardFrontPhotoPath) {
        this.idcardFrontPhotoPath = idcardFrontPhotoPath == null ? null : idcardFrontPhotoPath.trim();
    }

    public String getIdcardPortraitPhotoPath() {
        return idcardPortraitPhotoPath;
    }

    public void setIdcardPortraitPhotoPath(String idcardPortraitPhotoPath) {
        this.idcardPortraitPhotoPath = idcardPortraitPhotoPath == null ? null : idcardPortraitPhotoPath.trim();
    }

    public String getIdcardBackPhotoPath() {
        return idcardBackPhotoPath;
    }

    public void setIdcardBackPhotoPath(String idcardBackPhotoPath) {
        this.idcardBackPhotoPath = idcardBackPhotoPath == null ? null : idcardBackPhotoPath.trim();
    }

    public String getLivingPhotoPath() {
        return livingPhotoPath;
    }

    public void setLivingPhotoPath(String livingPhotoPath) {
        this.livingPhotoPath = livingPhotoPath == null ? null : livingPhotoPath.trim();
    }

    public String getLivingVideoPath() {
        return livingVideoPath;
    }

    public void setLivingVideoPath(String livingVideoPath) {
        this.livingVideoPath = livingVideoPath == null ? null : livingVideoPath.trim();
    }
}