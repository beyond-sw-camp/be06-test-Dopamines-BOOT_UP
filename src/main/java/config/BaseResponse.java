package config;

public class BaseResponse<T> {
    private Boolean success;
    private Integer code;
    private String message;
    private T generic;

    public BaseResponse(BaseResponseMessage result) {
        this.success = result.getSuccess();
        this.code = result.getCode();
        this.message = result.getMessage();
    }

    public BaseResponse(BaseResponseMessage result, T generic) {
        this.success = result.getSuccess();
        this.code = result.getCode();
        this.message = result.getMessage();
        this.generic = generic;
    }

    public BaseResponse(Boolean success, Integer code, String message) {
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
