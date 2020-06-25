package _javaChat5;
import java.io.*;
/**
 * 梨꾪똿�뿉 李몄뿬�븯�뒗 �궗�슜�옄 �젙蹂대�� �떞�뒗 媛앹껜
 *  VO媛앹껜 (Value Object), DTO媛앹껜(Data Transfer Object)
 *  : �룄硫붿씤 怨꾩링 (Domain Layer)
 */
public class User implements Serializable {
    private String ip;
    private String id;
    private String chatName;
    private String gender;

    public User() {
    }

    public User(String id, String chatName, String gender) {
        this.id = id;
        this.chatName = chatName;
        this.gender = gender;
    }
    
    //gettter, settter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    
}
