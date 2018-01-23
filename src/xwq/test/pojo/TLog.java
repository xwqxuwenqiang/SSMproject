package xwq.test.pojo;

public class TLog {
    private Integer id;

    private String times;

    private byte[] infor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times == null ? null : times.trim();
    }

    public byte[] getInfor() {
        return infor;
    }

    public void setInfor(byte[] infor) {
        this.infor = infor;
    }
}