package config;

// 메시지만 주는게 아니라, 내용까지 주고 싶을 때
public class BaseResponse2<T> {
    private Boolean success;
    private Integer code;
    private String message;
    private T result;

    public BaseResponse2(T result) {
        this.success = BaseResponseMessage.REQUEST_SUCCESS.getSuccess();
        this.code = BaseResponseMessage.REQUEST_SUCCESS.getCode();
        this.message = BaseResponseMessage.REQUEST_SUCCESS.getMessage();
        this.result = result;
    }

    public BaseResponse2(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
