package com.example.uptop.pandorikatest.database.models;import com.example.uptop.pandorikatest.database.PandorikaTestDataBase;import com.raizlabs.android.dbflow.annotation.Column;import com.raizlabs.android.dbflow.annotation.ConflictAction;import com.raizlabs.android.dbflow.annotation.PrimaryKey;import com.raizlabs.android.dbflow.annotation.Table;import com.raizlabs.android.dbflow.annotation.Unique;import com.raizlabs.android.dbflow.annotation.UniqueGroup;import com.raizlabs.android.dbflow.sql.language.SQLite;import com.raizlabs.android.dbflow.structure.BaseModel;import java.util.List;@Table(database = PandorikaTestDataBase.class, uniqueColumnGroups = {@UniqueGroup(groupNumber = 1,uniqueConflict = ConflictAction.IGNORE)})public class Recordings extends BaseModel {    @PrimaryKey(autoincrement = true)    long id;    @Unique(unique = false, uniqueGroups = 1)    @Column    String artistName;    @Unique(unique = false, uniqueGroups = 1)    @Column    String musicName;    @Unique(unique = false, uniqueGroups = 1)    @Column    String imgUrl;    public long getId() {        return id;    }    public void setId(long id) {        this.id = id;    }    public String getArtistName() {        return artistName;    }    public void setArtistName(String artistName) {        this.artistName = artistName;    }    public String  getMusicName() {        return musicName;    }    public void setMusicName(String musicName) {        this.musicName = musicName;    }    public String  getImgUrl() {        return imgUrl;    }    public void setImgUrl(String imgUrl) {        this.imgUrl = imgUrl;    }    public static List<Recordings> getAllRecordings() {        return SQLite.select()        .from(Recordings.class)        .queryList();    }    public static List<Recordings> removeAllRecordings() {        return SQLite.delete()        .from(Recordings.class)        .queryList();    }}