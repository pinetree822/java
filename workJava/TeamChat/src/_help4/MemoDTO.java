/*
 * DTO ( Data Transfer Object) : db���� ������ �����ͳ� gui�Է� ������
    ������ �����͸� ��� �ִ� ��ü
    VO(Value Object) ��� ��
 */
package _help4;
import java.io.Serializable;
import java.sql.Date;

public class MemoDTO implements Serializable{
    //db �÷��� ��Ī�Ǵ� ��������� ����=> ĸ��ȭ
    private int idx;
    private String name;
    private String msg;
    private java.sql.Date wdate;
    public MemoDTO(){
        
    }
    public MemoDTO(int idx, String name, String msg, Date wdate) {
        this.idx = idx;
        this.name = name;
        this.msg = msg;
        this.wdate = wdate;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }

    @Override
    public String toString() {
        return "MemoDTO{" + "idx=" + idx + ", name=" + name + ", msg=" + msg + ", wdate=" + wdate + '}';
    }
    
}///////////////////////////////////////
