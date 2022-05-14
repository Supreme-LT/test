package cn.edu.goodscommons.vo;

public class ResultVo {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private ResultVo() {}

    public static ResultVo ok(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(200);
        resultVo.setData(data);
        resultVo.setMsg("ok");
        return resultVo;
    }

    public static ResultVo ok(){
        return ResultVo.ok(null);
    }

    public static ResultVo error(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg("error");
        return resultVo;
    }

    public static ResultVo error(String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg(msg);
        return resultVo;
    }
}